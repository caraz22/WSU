#include "./types.h"
#include "./io.h"

#define low_16(address) (uint16)((address) & 0xFFFF)
#define high_16(address) (uint16)(((address) >> 16) & 0xFFFF)
#define low_8(address) (uint8)((address) &  0xFF)
#define high_8(address) (uint8)(((address) >> 8) & 0xFF)

enum dma_registers {
    ISA_DMA_REGISTER_StartAddressChannel0 = 0x00, // Unusable (Both for Channel 0 and 4)
    ISA_DMA_REGISTER_CountChannel0 = 0x01, // Unusable (Both for Channel 0 and 4)
    ISA_DMA_REGISTER_StartAddressChannel1 = 0x02,
    ISA_DMA_REGISTER_CountChannel1 = 0x03,
    ISA_DMA_REGISTER_StartAddressChannel2 = 0x04,
    ISA_DMA_REGISTER_CountChannel2 = 0x05,
    ISA_DMA_REGISTER_StartAddressChannel3 = 0x06,
    ISA_DMA_REGISTER_CountChannel3 = 0x07,
    ISA_DMA_REGISTER_Status = 0x08,
    ISA_DMA_REGISTER_Command = 0x08,
    ISA_DMA_REGISTER_Request = 0x09,
    ISA_DMA_REGISTER_SingleChannelMask = 0x0A,
    ISA_DMA_REGISTER_Mode = 0x0B,
    ISA_DMA_REGISTER_FlipFlopRest = 0x0C,
    ISA_DMA_REGISTER_Intermediate = 0x0D,
    ISA_DMA_REGISTER_MasterReset = 0x0D,
    ISA_DMA_REGISTER_MaskReset = 0xDC,
    ISA_DMA_REGISTER_MultiChannelMaskRegister = 0xDE,


    ISA_DMA_REGISTER_Channel0PageAddress = 0x87, // Unusable
    ISA_DMA_REGISTER_Channel1PageAddress = 0x83,
    ISA_DMA_REGISTER_Channel2PageAddress = 0x81,
    ISA_DMA_REGISTER_Channel3PageAddress = 0x82,
    ISA_DMA_REGISTER_Channel4PageAddress = 0x8F, // Unusable
    ISA_DMA_REGISTER_Channel5PageAddress = 0x8B,
    ISA_DMA_REGISTER_Channel6PageAddress = 0x89,
    ISA_DMA_REGISTER_Channel7PageAddress = 0x8A,
};

void maskChannel(uint8 channel, int masked){
    uint8 out = 0;
    uint16 port = 0x0A;

    if(masked){
        out += 4;
    }

    if(channel >= 4){
        port += 0xC0;
        channel -= 4;
    }


    out += channel;
    outb(port, out);

}


// the address should only be 24bits long, and have a total of 0x23ff in size
void initFloppyDMA(uint32 address, uint16 count){



    // idk man bitwise operations help idk how to do it without spliting in two before
    /*
     *  we ignore the high 8 bits, and use the other 3 bytes for our address
     *
     *
     *  |        |        |        |        |
     *  |--------|00000000|00000000|00000000|
     *  |        |        |        |        |
     *
     */
    uint16 firstHalf = low_16(address);
    uint16 secondHalf = high_16(address);

    // total of 24 bytes from our address
    uint8 firstThird = low_8(firstHalf);
    uint8 secondThird = high_8(firstHalf);
    uint8 thirdThird = low_8(secondHalf);


    // mask DMA channel 2 and 0 (assuming 0 is already masked)
    //outb(ISA_DMA_REGISTER_SingleChannelMask, 0x06);
    maskChannel(2, 1);

    // reset the master flip-flop
    outb(ISA_DMA_REGISTER_FlipFlopRest, 0xFF);

    // low byte of address
    outb(ISA_DMA_REGISTER_StartAddressChannel2, firstThird);

    // high byte of address
    outb(ISA_DMA_REGISTER_StartAddressChannel2, secondThird);

    // reset the master flip-flop again
    outb(ISA_DMA_REGISTER_FlipFlopRest, 0xFF);

    // set count (declared above)
    outb(ISA_DMA_REGISTER_CountChannel2, low_8(count));
    outb(ISA_DMA_REGISTER_CountChannel2, high_8(count));

    // external page register (upper 8bits of our address)
    outb(ISA_DMA_REGISTER_Channel2PageAddress, thirdThird);

    // unmask DMA channel 2
    //outb(ISA_DMA_REGISTER_SingleChannelMask, 0x02);
    maskChannel(2, 0);

}


void prepare_for_floppyDMA_write(){
    // mask channel 2, and 0 (admiting 0 is already masked)
    // outb(ISA_DMA_REGISTER_SingleChannelMask, 0x06);
    maskChannel(2, 1);

    outb(ISA_DMA_REGISTER_Mode, 0x5A); // 01011010
    //single transfer, address increment, auto init, write, channel2

    // unmask DMA channel 2
    // outb(ISA_DMA_REGISTER_SingleChannelMask, 0x02);
    maskChannel(2, 0);

}

void prepare_for_floppyDMA_read(){
    // mask channel 2, and 0 (admiting 0 is already masked)
    // outb(ISA_DMA_REGISTER_SingleChannelMask, 0x06);
    maskChannel(2, 1);

    outb(ISA_DMA_REGISTER_Mode, 0x56); // 01010110
    //single transfer, address increment, autoinit, read, channel2

    // unmask DMA channel 2
    // outb(ISA_DMA_REGISTER_SingleChannelMask, 0x02);
    maskChannel(2, 0);

}
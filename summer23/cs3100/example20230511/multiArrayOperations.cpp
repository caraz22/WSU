#include <cstdint>
#include <iostream>

int16_t s_multiArray[6][7];
static int16_t* s_cell_p = (int16_t*)s_multiArray;

static int32_t multiArrayOperations(int32_t argc, const char* argv_p[]) 
{
    bool flag;
    std::cout << sizeof(s_multiArray) << ": size of s_multiarray[7][6]\n";

    std::cout << sizeof(s_cell_p) << ": size of (int16_t*)s_multiArray\n";

    s_multiArray[3][4] = -1;
    std::cout << "s_multiArray[3][4] is " << s_multiArray[3][4] << "\n";
    *(s_cell_p + 3 * 7 + 4) = -2;
    std::cout << "s_multiArray[3][4] is " << s_multiArray[3][4] << "\n";

    for (int32_t i = 0; i < 6; ++i)
    {
        for (int32_t j = 0; j < 7; ++j) 
        {
            std::cout << s_multiArray[i][j] << " ";
        }
        std::cout << std::endl; //same as \n
    }

    return 0;
}
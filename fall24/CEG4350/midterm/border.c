void border() {
    int cursorCol = 0;
    int cursorRow = 0;
    while (cursorRow == 0 && cursorCol < 80) {
        char * index = (char *)(0xB8000 + ((cursorRow * 80 * 2) + (cursorCol * 2)));
        *index = '#';
        index++;
        *index = 0x20;
        cursorCol++;
    }
    cursorCol = 0;

        while (cursorRow < 25 && cursorCol == 0) {
        char * index = (char *)(0xB8000 + ((cursorRow * 80 * 2) + (cursorCol * 2)));
        *index = '#';
        index++;
        *index = 0x20;
        cursorRow++;
    }
    cursorRow = 0;

    while (cursorRow == 24 && cursorCol < 80) {
        char * index = (char *)(0xB8000 + ((cursorRow * 80 * 2) + (cursorCol * 2)));
        *index = '#';
        index++;
        *index = 0x20;
        cursorCol++;
    }
    cursorCol = 0;

    while (cursorRow < 25 && cursorCol == 79) {
        char * index = (char *)(0xB8000 + ((cursorRow * 80 * 2) + (cursorCol * 2)));
        *index = '#';
        index++;
        *index = 0x20;
        cursorRow++;
    }
}
#include <iostream>

extern int32_t multiArrayOperations(int32_t argc, const char* argv_p[]);
extern int16_t s_multiArray[6][7];

int32_t main(int32_t argc, const char* argv_p[]) 
{
    s_multiArray[0][0] = 1;
    int32_t result = multiArrayOperations(argc, argv_p);

    return result;
}
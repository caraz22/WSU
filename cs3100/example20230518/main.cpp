#include <iostream>
#include <stdint.h>

struct MultiValue 
{
    int32_t value;
    int64_t bigValue;
    uint8_t values[32000];
};

void printLessOnePointer(int32_t *value_p) 
{
    *value_p -= 1;
    std::cout << *value_p << " " << value_p << "\n";
}

void printLessOneReference(int32_t &value)
{
    value -= 1;
    std::cout << value << " " << &value << "\n";
}

int main(int32_t argc, const char * argv[]) 
{
    static int32_t bestValue = 42;
    printLessOnePointer(&bestValue);
    printLessOneReference(bestValue);
    std::cout << "best value is " << bestValue << " " << &bestValue << "\n";
    return 0;
}
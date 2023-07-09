#include <iostream>
#include <stdint.h>

struct MultiValue 
{
    int32_t value;
    int64_t bigValue;
    uint8_t values[32000];
};

void printLessOneValue(MultiValue multi) 
{
    multi.value -= 1;
    std::cout << multi.value << " " << &multi << "\n";
}

void printLessOnePointer(MultiValue *multi_p) 
{
    multi_p++;
    multi_p->value -= 1;
    std::cout << multi_p->value << " " << multi_p << "\n";
}

void printLessOneReference(MultiValue multi)
{
    multi.value -= 1;
    std::cout << multi.value << " " << &multi << "\n";
}

int main(int32_t argc, const char * argv[]) 
{
    std::cout << "sizeof(MultiValue) " << sizeof(MultiValue) << "\n";
    static MultiValue bestValue {42};
    printLessOnePointer(&bestValue);
    printLessOneReference(bestValue);
    std::cout << "best value is " << bestValue.value << " " << &bestValue << "\n";
    return 0;
}
#include <iostream>

int main(int argc, const char** argv) 
{
    std::cout << "Hello, World!\n"; 
    for(int i = 0; i < argc; i++) {
        std::cout << *(argv + i) << "\n";
    }

    const char* s_p = "Hello, World!\n";
    std::cout << *s_p << "\n"; 
    return 0;
}
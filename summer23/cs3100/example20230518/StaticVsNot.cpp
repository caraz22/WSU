#include <iostream>

class Adder
{
    private:
        int32_t m_valueToAdd = 42;
    public:
        int32_t add(int32_t value)
        {
            return value + m_valueToAdd;
        }
};

int main(int argc, const char * argv[])
{
    Adder myAdder{};

    std::cout << myAdder.add(-1) << "\n";
    return 0;
}
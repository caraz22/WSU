#include <iostream>

using namespace std;

int foo(int, int);

int main() {
    
    int a = 7; 
    int b = 9;
    int c = (foo(a, b));
    cout << c << endl;
}

int foo(int first, int second) {
    first = first + 7;
    second = second + 9;
    return (first * second + 6);
}
#include <iostream>

using namespace std;

int foo(int *, int *);

int main() {
  
    int a = 7; 
    int b = 9;

    int c = (foo(&a, &b));
    cout << c << endl;
    cout << a << endl;
    cout << b << endl;

    // int * p = &a;

/*    
    int * p = &a;
    *p = 12; // reference or follow

    int & r = a; // only reference
    r = 52;

    p++;
    cout << p << endl;
    cout << *p << endl;
    cout << r << endl;
*/


}

int foo(int * first, int * second) { // pointers change the value in the stack frame (pass by value), non pointers only change the passed in copy (pass by reference)
    *first = *first * 7; // equivalent to first *= 7;
    *second = *second + 9;
    return (*first * *second + 6);
}
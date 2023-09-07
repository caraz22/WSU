#include <iostream>

using namespace std;

int main() {
    int j = 20;
    int * p;
    p = &j;

    int myArray[5] = {1, 2, 3, 4, 5};
    p = myArray;
    p = p + 1;
    *p = 5;

    cout << myArray[0] << endl;
    // cout << j << endl;
    cout << *p << endl;
    cout << "Done" << endl;


}
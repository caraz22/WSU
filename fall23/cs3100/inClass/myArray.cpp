#include <iostream>

using namespace std;

int main() {
    int * p;
    int myArray[5] = {1, 2, 3, 4, 5};
    p = myArray;

    for (int i = 0; i < 5; i++) {
        *p = *p * 2;    // *p *= 2;
        p = p + 1;  // p++;
        // p[i] *= 2;
    }

    for (int i = 0; i < 5; i++) {
        cout << myArray[i] << endl;
    }

    // cout << myArray[0];
    // cout << *p << endl;
    cout << "Done" << endl;
}
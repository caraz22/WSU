#include <iostream>

using namespace std;

int main() {
    /*
    int arraySize;  // Stack
    double d;   // Stack   
    static int something;   // Statics area
    cout << "How big of an array do you want?" << endl;
    cin >> arraySize;
    cout << endl << "Creating an array of size: " << arraySize << endl;
    */

    int myArray[5] = {1, 2, 3, 4, 5};
    // int * myArray;
    int * p;

    for (int i = 0; i < 5; i++) {
        cout << myArray[i] << endl;
    }

    // myArray = new int[5];
    p = myArray;
    cout << endl;

    for (int i = 0; i < 5; i++) {
        *p *= 2;
        p += 1;
        // myArray[i] = 2 * i;
    }

    // Release myArray
    // delete [] myArray;

    // Print out the array
    for (int i = 0; i < 5; i++) {
        cout << myArray[i] << endl;
    }

    cout << "Done" << endl;
}
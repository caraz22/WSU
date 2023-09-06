#include <iostream>

using namespace std;

int main() {
    int arraySize;  // Stack
    double d;   // Stack   
    static int something;   // Statics area
    cout << "How big of an array do you want?" << endl;
    cin >> arraySize;
    cout << endl << "Creating an array of size: " << arraySize << endl;

    // int myArray[arraySize];
    int * myArray;
    int * p;

    myArray = new int[arraySize];
    p = myArray;

    for (int i = 0; i < arraySize; i++) {
        myArray[i] = 2 * i;
    }

    // Release myArray
    delete [] myArray;

    // Print out the array
    for (int i = 0; i < arraySize; i++) {
        cout << myArray[i] << endl;
    }

    cout << "Done" << endl;
}
#include <iostream>

using namespace std;

int main() {
    int arraySize;
    cout << "Choose the size of the array: ";
    cin >> arraySize;
    cout << endl << "Creating an array the size of " << arraySize << endl;
    int myArray[arraySize];
    for (int i = 0; i < arraySize; i++) {
        myArray[i] = i + 1;
    }

    for (int i = 0; i < arraySize; i++) {
        cout << myArray[i] << endl;
    }
}
#include <iostream>
#include <iomanip>

using namespace std;

// Function declarations
void makeArray();

int main() {

    cout << "About to run makeArray a lot!" << endl;
    for (int i = 0; i < 10000; i++) {
        makeArray();
    }
    cout << "Finished running makeArray" << endl;
}

// Function definition
void makeArray() {
    int size = 5;
    // cout << endl << "Creating an array of size " << size << endl;
    int * array = nullptr;

    array = new int[size]; // every time you use new you must use delete

    // for (int i = 0; i < size; i++) {
    //     array[i] = 2 * i;
    // }

    // for (int i = 0; i < size; i++) {
    //     cout << array[i] << endl;
    // }

    delete [] array;
}
#include <iostream>

using namespace std;

// Function declaration for doubleIt
int doubleIt(int &);

int main() {
    int i;
    int j = 2;
    i = doubleIt(j);
    cout << j << endl;
    cout << i << endl;
}

// Function definition for doubleIt
int doubleIt(int & value) {
    value *= 2;
    return value;
}
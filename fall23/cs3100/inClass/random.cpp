#include <iostream>
#include <cstdlib>

using namespace std;

int main() {
    srand(time(NULL));  // Needed before using rand()

    int randNum;
    randNum = (rand() % 6) + 1;
    cout << randNum << endl;
    randNum = (rand() % 6) + 1;
    cout << randNum << endl;
    randNum = (rand() % 6) + 1;
    cout << randNum << endl;
    randNum = (rand() % 6) + 1;
    cout << randNum << endl;
    
}
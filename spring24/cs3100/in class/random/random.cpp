#include <iostream>
#include <iomanip>
#include <random>
#include <cstdlib>

using namespace std;

int main() {

    int r;
    srand(time(NULL));

    for (int i = 0; i < 10; i++) {
        r = rand() % 6;
        cout << r << endl;        
    }
}
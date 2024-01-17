#include <iostream>
#include <iomanip>
#include <random>
#include <cstdlib>

using namespace std;

int main() {

    int r;
    r = rand();
    for (int i = 0; i < 10; i++) {
        r = rand();
        cout << r << endl;        
    }
}
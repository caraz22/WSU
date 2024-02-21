#include "sequence.h"

using namespace std;

int main() {
    Sequence mySequence(5);
    mySequence[0] = 1;
    mySequence[1] = 2;
    mySequence[2] = 3;
    mySequence[3] = 4;
    mySequence[4] = 5;
    mySequence.print(cout);

    mySequence.insert(2, 6);
    cout << endl;
    mySequence.print(cout);
}
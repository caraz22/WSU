#include "MaxHeap.h"
#include <iostream>

using namespace std;

int main() {
    MaxHeap myHeap;

    cout << myHeap.isEmpty() << endl;

    myHeap.offer(10);
    myHeap.offer(13);
    myHeap.offer(2);
    myHeap.offer(17);

    cout << myHeap.peek() << endl;
    cout << myHeap.isEmpty() << endl;
    cout << myHeap;
}
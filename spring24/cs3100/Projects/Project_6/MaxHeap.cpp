#include "MaxHeap.h"

MaxHeap::MaxHeap() {
    heapArray = new int[HEAP_MIN_SIZE];
}

MaxHeap::MaxHeap(int * values, int count) {
    int * newArray = new int[count];
    for (int i = 0; i < count; i++) {
        newArray[i] = values[i];
    }

    count = heapSize;

    this->heapify();
}

MaxHeap::MaxHeap(const MaxHeap& heap) {
    
}

MaxHeap::~MaxHeap() {

}

MaxHeap& MaxHeap::operator=(const MaxHeap& h) {

}

void MaxHeap::offer(int value) {
    if (heapSize == maxArraySize) 
        this->expandArray();
    
    heapArray[heapSize] = value;
}

int MaxHeap::poll() {
    if (isEmpty() == true) {
        throw exception();
    } else {
        maxVal = heapArray[0];
        heapArray[0] = NULL;
        this->heapify();
    }

    return maxVal;
}

bool MaxHeap::isEmpty() const {
    if (heapSize == 0) {
        return true;
    } else {
        return false;
    }
}

int MaxHeap::peek() const {
    if (heapSize == 0) {
        throw exception();
    }
}

vector<int> MaxHeap::sorted() const {

}

ostream& operator<<(ostream& os, const MaxHeap& h) {

}

void MaxHeap::expandArray() {
    maxArraySize *= 2;
    int * newArray = new int[maxArraySize];
    for (int i = 0; i < heapSize; i++) 
        newArray[i] = heapArray[i];
    delete[] heapArray;
    heapArray = newArray;
}

void MaxHeap::heapify() {

}

void siftDown() {

}
#include "MaxHeap.h"

MaxHeap::MaxHeap() {
    heapArray = new int[HEAP_MIN_SIZE];
    maxArraySize = HEAP_MIN_SIZE;
    heapSize = 0;
}

MaxHeap::MaxHeap(int * values, int count) {
    maxArraySize = HEAP_MIN_SIZE;
    while (maxArraySize < count) {
        maxArraySize *= 2;
    }
    
    heapArray = new int[maxArraySize];
    for (int i = 0; i < count; i++) {
        heapArray[i] = values[i];
    }

    heapSize = count;

    this->buildHeap();
}

MaxHeap::MaxHeap(const MaxHeap& h) {
    heapSize = h.heapSize;
    maxArraySize = h.maxArraySize;    
    
    heapArray = new int[heapSize];
    for (int i = 0; i < heapSize; i++) {
        heapArray[i] = h.heapArray[i]; 
    }
}

MaxHeap::~MaxHeap() {
    delete[] heapArray;
}

MaxHeap& MaxHeap::operator=(const MaxHeap& h) {
    heapSize = h.heapSize;
    maxArraySize = h.maxArraySize;    

    delete[] heapArray;

    heapArray = new int[heapSize];
    for (int i = 0; i < heapSize; i++) {
        heapArray[i] = h.heapArray[i]; 
    }

    return *this;
}

void MaxHeap::offer(int value) {
    if (heapSize == maxArraySize) {
        this->expandArray();
    }

    heapArray[heapSize] = value;
    heapSize++;

    siftUp(heapSize - 1);
}

int MaxHeap::poll() {
    int maxVal = peek();

    heapArray[0] = heapArray[heapSize - 1];
    heapSize--;

    if (heapSize < (maxArraySize/2) && heapSize > HEAP_MIN_SIZE) {
        this->shrinkArray();
    }

    heapify(0);

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
    } else {
        return heapArray[0];
    }
}

vector<int> MaxHeap::sorted() const {
    vector<int> sortedHeap;
    MaxHeap heapCopy(heapArray, heapSize);

    if (heapSize == 0) {
        return sortedHeap;
    }

    while (heapCopy.isEmpty() == false) {
        int maxVal = heapCopy.poll();
        sortedHeap.push_back(maxVal);
    }

    return sortedHeap;
}



void MaxHeap::print(ostream& os) const {
    for (int i = 0; i < heapSize; i++) {
        os << heapArray[i] << ", ";
    }
}

ostream& operator<<(ostream& os, const MaxHeap& h) {
    h.print(os);
    return os;
}

void MaxHeap::expandArray() {
    maxArraySize *= 2;
    int * newArray = new int[maxArraySize];
    for (int i = 0; i < heapSize; i++) 
        newArray[i] = heapArray[i];
    delete[] heapArray;
    heapArray = newArray;
}

void MaxHeap::shrinkArray() {
    maxArraySize /= 2;
    int * newArray = new int[maxArraySize];
    for (int i = 0; i < heapSize; i++) {
        newArray[i] = heapArray[i];
    }
    delete[] heapArray;
    heapArray = newArray;
}

void MaxHeap::buildHeap() { 
    for (int i = heapSize/2; i >= 0; i--) {
        heapify(i);
    }
}

void MaxHeap::heapify(int index) { 
    int maxValIndex = index;

    if (isLeaf(index) == false) {
        if (heapArray[getLeftChild(index)] > heapArray[maxValIndex]) {
            maxValIndex = getLeftChild(index);
        }
    
        if (getRightChild(index) < heapSize && heapArray[getRightChild(index)] > heapArray[maxValIndex]) {
            maxValIndex = getRightChild(index);            
        }
    }

    if (maxValIndex != index) {
        swap(heapArray[index], heapArray[maxValIndex]);

        heapify(maxValIndex);
    } 
}

void MaxHeap::siftUp(int index) {
    while (index > 0) {
        if (heapArray[index] > heapArray[getParent(index)]) {
            swap(heapArray[index], heapArray[getParent(index)]);
            index = getParent(index);
        } else {
            return;
        }
    }
}

int MaxHeap::getParent(int index) {
    int parentIndex;
    if (index == 0 || index >= heapSize) {
        throw exception();
    } else {
        parentIndex = ((index - 1) / 2);
    }

    return parentIndex;
}

int MaxHeap::getLeftChild(int index) {
    int leftChildIndex = (2 * index) + 1;
    return leftChildIndex;
}

int MaxHeap::getRightChild(int index) {
    int rightChildIndex = (2 * index) + 2;
    return rightChildIndex;
}

bool MaxHeap::isLeaf(int index) { 
    return (index >= heapSize / 2);
}
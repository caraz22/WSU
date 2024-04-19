#include "MaxHeap.h"

MaxHeap::MaxHeap() {
    heapArray = new int[HEAP_MIN_SIZE];
    maxArraySize = HEAP_MIN_SIZE;
}

MaxHeap::MaxHeap(int * values, int count) {
    int * newArray = new int[count];
    for (int i = 0; i < count; i++) {
        newArray[i] = values[i];
    }

    count = heapSize;

    this->heapify();
}

MaxHeap::MaxHeap(const MaxHeap& h) {
    for (int i = 0; i < heapSize; i++) {
        h.heapArray[i] = heapArray[i]; 
    }
}

MaxHeap::~MaxHeap() {
    if (heapSize == 0) {
        return;
    }

    delete[] heapArray;
}

MaxHeap& MaxHeap::operator=(const MaxHeap& h) {
    delete[] heapArray;

    for (int i = 0; i < heapSize; i++) {
        h.heapArray[i] = heapArray[i];
    }

    return *this;
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

<<<<<<< HEAD
    return maxVal;
=======
    heapArray[heapSize] = value;
    heapSize++;
>>>>>>> ec3470b2356368631d9a30bb9a8a7895cde32fa6
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
<<<<<<< HEAD
=======
    } else {
        return heapArray[0];
>>>>>>> ec3470b2356368631d9a30bb9a8a7895cde32fa6
    }
}

vector<int> MaxHeap::sorted() const {
    return sortHelper(heapSize);
}

vector<int> MaxHeap::sortHelper(int index) const {
    vector<int> sortedHeap;
    if (heapSize == 0) {
        return sortedHeap;
    } else {
        
    }
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

void MaxHeap::heapify() {
    for (int i = heapSize - 1; i >= 0; i--) {
        if (isLeaf(heapArray[i]) == false) {
            int parent = getParent(i);
            if (heapArray[i] > heapArray[parent]) {
                int tempVal = heapArray[parent];
                heapArray[parent] = heapArray[i];
                heapArray[i] = tempVal;
            }
        }
    }    
}

void MaxHeap::siftDown() {

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
    int rightChildIndex = (2 * index) + 2; 
    int leftChildIndex = (2 * index) + 1;
    if (rightChildIndex >= heapSize && leftChildIndex >= heapSize) {
        return true;
    } else {
        return false;
    }
}
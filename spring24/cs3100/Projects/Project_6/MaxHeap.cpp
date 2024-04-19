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
    
    heapArray = new int[count];
    for (int i = 0; i < count; i++) {
        heapArray[i] = values[i];
    }

    count = heapSize;

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
    for (int i = heapSize/2; i >= 0; i--) {
        siftUp(i);
    }

    heapArray[heapSize] = value;
    heapSize++;
}

int MaxHeap::poll() {
    int maxVal = peek();

    heapArray[0] = heapArray[heapSize - 1];
    heapSize--;

    for (int i = heapSize/2; i >= 0; i--) {
        heapify(i);
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
    } else {
        return heapArray[0];
    }
}

vector<int> MaxHeap::sorted() const {
    return sortHelper(heapSize);
}

vector<int> MaxHeap::sortHelper(int index) const { //heap sort
    int * newArray = new int[heapSize];
    for (int i = 0; i < heapSize; i++) {
        newArray[i] = heapArray[i];
    }

    for (int i = heapSize - 1; i >= 0; i--) {
        swap(newArray[0], newArray[i]);
        
    }
}
// Heapsort(numbers, numbersSize) {
//    // Heapify numbers array
//    for (i = numbersSize / 2 - 1; i >= 0; i--) {
//       MaxHeapPercolateDown(i, numbers, numbersSize)
//    }

//    for (i = numbersSize - 1; i > 0; i--) {
//       Swap numbers[0] and numbers[i]
//       MaxHeapPercolateDown(0, numbers, i)
//    }
// }

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

void MaxHeap::buildHeap() { 
    for (int i = heapSize/2; i >= 0; i--) {
        heapify(i);
    }
}

void MaxHeap::heapify(int index) { 
    int maxValIndex = index;

    if (isLeaf(index) == true) {
        if (getLeftChild(index) > heapArray[maxValIndex]) {
            maxValIndex = getLeftChild(index);
        }
        if (getRightChild(index) > heapArray[maxValIndex]) {
            maxValIndex = getRightChild(index);
        }
    }

    if (maxValIndex = index) {
        swap(heapArray[index], heapArray[maxValIndex]);

        heapify(maxValIndex);
    }
}

void MaxHeap::siftUp(int index) {

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
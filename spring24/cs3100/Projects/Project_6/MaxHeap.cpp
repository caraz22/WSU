/*
Cara Zozokos
Project 6 - Max Heaps
This is the implementation file for project 6
*/

#include "MaxHeap.h"

// Default constructor
// creates an array of size HEAP_MIN_SIZE (20),
// sets the capacity of the array to HEAP_MIN_SIZE,
// and sets the amount of values in the heap to 0
MaxHeap::MaxHeap() {
    heapArray = new int[HEAP_MIN_SIZE];
    maxArraySize = HEAP_MIN_SIZE;
    heapSize = 0;
}

// Parameterized constructor
// takes in an array of integers and its size
// and turns it in to a heap
MaxHeap::MaxHeap(int * values, int count) {
    maxArraySize = HEAP_MIN_SIZE;
    while (maxArraySize < count) {      // while the maxArraySize is less than the amount of values 
        maxArraySize *= 2;              // double the maxArraySize
    }
    
    heapArray = new int[maxArraySize];          // creates an array of size maxArraySize
    for (int i = 0; i < count; i++) {           // copying the values into the array
        heapArray[i] = values[i];
    }

    heapSize = count;           // setting the heapSize to the amount of values

    this->buildHeap();          // turns the array into a Max Heap
}

// Copy constructor
// produces an independent copy of your heap
MaxHeap::MaxHeap(const MaxHeap& h) {
    heapSize = h.heapSize;
    maxArraySize = h.maxArraySize;    
    
    heapArray = new int[heapSize];
    for (int i = 0; i < heapSize; i++) {
        heapArray[i] = h.heapArray[i]; 
    }
}

// Destructor
// deallocates memory by deleting the array
MaxHeap::~MaxHeap() {
    delete[] heapArray;
}

// Copy assignment operator
// releases the array and replaces it with a new one
MaxHeap& MaxHeap::operator=(const MaxHeap& h) {
    heapSize = h.heapSize;
    maxArraySize = h.maxArraySize;    

    delete[] heapArray;                     // releasing array

    heapArray = new int[heapSize];
    for (int i = 0; i < heapSize; i++) {    // replacing array
        heapArray[i] = h.heapArray[i]; 
    }

    return *this;
}

// inserts a new value into the heap
void MaxHeap::offer(int value) {
    if (heapSize == maxArraySize) {     // if the amount of elements in the array are equal to the max capacity of the array
        this->expandArray();            // increase its capacity
    }

    heapArray[heapSize] = value;        // sets the index after the last value's index to the inserted value
    heapSize++;                         // increase the heap size by 1

    siftUp(heapSize - 1);               // restore the heap property
}

// removes and returns the maximum value in the heap
int MaxHeap::poll() {
    int maxVal = peek();                        // get the max value in the heap

    heapArray[0] = heapArray[heapSize - 1];     // replace the first index with the last
    heapSize--;                                 // decrease the heap size by 1

    if (heapSize < (maxArraySize/2) && heapSize > HEAP_MIN_SIZE) {          // if removing the value makes the size of the heap less than half of the max capacity AND greater than the HEAP_MIN_SIZE,
        this->shrinkArray();        // make the array smaller
    }

    heapify(0);                 // restore the heap property

    return maxVal;
}


// returns true if the heap is empty, and false otherwise
bool MaxHeap::isEmpty() const {
    if (heapSize == 0) {
        return true;
    } else {
        return false;
    }
}

// returns the max value in the heap without removing it
int MaxHeap::peek() const {
    if (heapSize == 0) {
        throw exception();
    } else {
        return heapArray[0];
    }
}

// creates and returns a vector of integers containing the heap elements sorted in largest to smallest order
vector<int> MaxHeap::sorted() const {
    vector<int> sortedHeap;
    MaxHeap heapCopy(heapArray, heapSize);          // copying the heap elements into a new heap

    if (heapSize == 0) {
        return sortedHeap;
    }

    while (heapCopy.isEmpty() == false) {           // while the heap is not epty
        int maxVal = heapCopy.poll();               // get the max value of the heap
        sortedHeap.push_back(maxVal);               // add that value to the vector
    }

    return sortedHeap;
}


// prints the heap in the order in which it is stored in the array
void MaxHeap::print(ostream& os) const {
    for (int i = 0; i < heapSize; i++) {
        os << heapArray[i] << ", ";
    }
}

// Overloaded stream insertion operator
ostream& operator<<(ostream& os, const MaxHeap& h) {
    h.print(os);
    return os;
}

// doubles the size of the heap array
// used when the size of the heap becomes greater than or equal to its max capacity
void MaxHeap::expandArray() {
    maxArraySize *= 2;                          // double the array size
    int * newArray = new int[maxArraySize];     // create a new array with the doubled size
    for (int i = 0; i < heapSize; i++) 
        newArray[i] = heapArray[i];             // copy contents into new array
    delete[] heapArray;                         // delete the old array
    heapArray = newArray;                       // and set it equal to the new one
}

// halves the size of the heap array
// used when the heap becomes less than half full but larger than HEAP_MIN_SIZE
void MaxHeap::shrinkArray() {
    maxArraySize /= 2;                              // halve the array size
    int * newArray = new int[maxArraySize];         // create a new array with the halved size
    for (int i = 0; i < heapSize; i++) {
        newArray[i] = heapArray[i];                 // copy contents into new array
    }
    delete[] heapArray;                             // delete the old array
    heapArray = newArray;                           // and set it equal to the new one
}

// builds the heap from the array
void MaxHeap::buildHeap() { 
    for (int i = heapSize/2; i >= 0; i--) {
        heapify(i);
    }
}

// heapifies the array
void MaxHeap::heapify(int index) { 
    int maxValIndex = index;            // making index the index of a max value

    if (isLeaf(index) == false) {           // if the index is NOT a leaf
        if (heapArray[getLeftChild(index)] > heapArray[maxValIndex]) {  // if the value of the left child is greater than the max value
            maxValIndex = getLeftChild(index);          // max value now equals left child
        }
    
        if (getRightChild(index) < heapSize && heapArray[getRightChild(index)] > heapArray[maxValIndex]) {          // if the value of the right child is greater than the max value
            maxValIndex = getRightChild(index);         // max value now equals right child   
        }
    }

    if (maxValIndex != index) {         // if the max value has changed
        swap(heapArray[index], heapArray[maxValIndex]);     // swap the value at the index with the value at the max value index

        heapify(maxValIndex);           // recursive call
    } 
}

// does upward heapification
void MaxHeap::siftUp(int index) {
    while (index > 0) {             // while the index is greater than 0
        if (heapArray[index] > heapArray[getParent(index)]) {       // if the value at index is greater than its parent's value
            swap(heapArray[index], heapArray[getParent(index)]);    // swap the value at the index with the value at the parent index
            index = getParent(index);           // index now equals its parent's index
        } else {
            return;
        }
    }
}

// returns the index of the parent
int MaxHeap::getParent(int index) {
    int parentIndex;
    if (index == 0 || index >= heapSize) {
        throw exception();
    } else {
        parentIndex = ((index - 1) / 2);        // equation for parent
    }

    return parentIndex;
}

// returns the index of the left child
int MaxHeap::getLeftChild(int index) {
    int leftChildIndex = (2 * index) + 1;       // equation for left child
    return leftChildIndex;
}

// returns the index of the right child
int MaxHeap::getRightChild(int index) {
    int rightChildIndex = (2 * index) + 2;      // equation for the right child
    return rightChildIndex;
}

// returns whether or not a leaf
bool MaxHeap::isLeaf(int index) { 
    return (index >= heapSize / 2);         // the back half of the array will be leaves
}
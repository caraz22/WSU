/*
Cara Zozokos
Project 6 - Max Heaps
This is the header file for project 6
*/

#include <iostream>
#include <vector>
#include <exception>
#include <array>
#include <algorithm>

using namespace std;

#define HEAP_MIN_SIZE 20            // Defining the minimum heap size of the heap array to 20

class MaxHeap {
    public:
    MaxHeap();                      // Default constructor
    MaxHeap(int *, int);            // Parameterized constructor
    MaxHeap(const MaxHeap&);        // Copy constructor

    ~MaxHeap();                     // Destructor

    MaxHeap& operator=(const MaxHeap&);             // Copy assignment operator

    void offer(int);                        // inserts a new value into the heap

    int poll();                             // removes and returns the max value in the heap

    bool isEmpty() const;                   // returns true if the heap is empty, and false otherwise

    int peek() const;                       // returns the maximum value in the heap without removing it

    vector<int> sorted() const;             // creates and returns a vector of integers containing the heap elements sorted in largest to smallest order

    friend ostream& operator<<(ostream&, const MaxHeap&);       // Overloaded stream insertion operator
    
    void print(ostream&) const;             // prints the heap in the order in which it is stored in the array

    private:
    void expandArray();             // doubles the size of the heap array

    void shrinkArray();             // halves the size of the heap array

    void buildHeap();               // builds the heap from the array

    void heapify(int);              // heapifies/sifts down the array

    void siftUp(int);               // upward heapification

    int getParent(int);             // returns the index of the parent 

    int getLeftChild(int);          // returns the index of the left child

    int getRightChild(int);         // returns the index of the right child

    bool isLeaf(int);               // returns true if there are no children, returns false if there is at least one child

    int heapSize;                   // current amount of values in the heap
    int maxArraySize;               // the max capacity of the heap array
    int * heapArray;                // the array to store heap elements
};
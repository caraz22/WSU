#include <iostream>
#include <vector>
#include <exception>
#include <array>

using namespace std;

#define HEAP_MIN_SIZE 20

class MaxHeap {
    public:
    MaxHeap();
    MaxHeap(int *, int);
    MaxHeap(const MaxHeap&);

    ~MaxHeap();

    MaxHeap& operator=(const MaxHeap&);

    void offer(int);

    bool isEmpty() const;

    int peek() const;

    vector<int> sorted() const;

    friend ostream& operator<<(ostream&, const MaxHeap&);

    private:
    void expandArray();

    void heapify();

    void siftDown();    

    int heapSize;
    int maxArraySize;
    int maxVal;
    int * heapArray;
};
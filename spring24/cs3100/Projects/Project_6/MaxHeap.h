#include <iostream>
#include <vector>
#include <exception>

using namespace std;

#define HEAP_MIN_SIZE 20;

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

    void fullHeap(const MaxHeap&);

    MaxHeap heapify(const MaxHeap&);

    void siftDown(const MaxHeap&);

    int heapSize;
    int maxVal;
};
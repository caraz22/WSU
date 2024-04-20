#include <iostream>
#include <vector>
#include <exception>
#include <array>
#include <algorithm>

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
    
    int poll();

    bool isEmpty() const;

    int peek() const;

    vector<int> sorted() const;

    friend ostream& operator<<(ostream&, const MaxHeap&);
    
    void print(ostream&) const;

    private:
    void expandArray();

    void shrinkArray();

    void buildHeap();

    void heapify(int);    

    void siftUp(int);

    int getParent(int);

    int getLeftChild(int);

    int getRightChild(int);

    bool isLeaf(int);

    int heapSize;
    int maxArraySize;
    int * heapArray;
};
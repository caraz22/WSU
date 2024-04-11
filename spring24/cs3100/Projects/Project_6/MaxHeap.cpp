#include "MaxHeap.h"

MaxHeap::MaxHeap() {
    heapSize = HEAP_MIN_SIZE;
}

MaxHeap::MaxHeap(int * values, int valuesCount) {
    MaxHeap heap;
    heapify(heap);
}

MaxHeap::MaxHeap(const MaxHeap& heap) {
    
}

MaxHeap::~MaxHeap() {

}
/*
INCLUDE HEADER
*/
#include "AVLTree.h"

int main() {
    AVLTree myTree;
    myTree.insert(10, "ten");
    myTree.insert(20, "twenty");
    myTree.insert(5, "five");

    cout << myTree.getSize();
}
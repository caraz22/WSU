#include "AVLTree.h"

AVLTree::AVLTree() {
    root = nullptr;
    treeSize = 0;
}

bool AVLTree::insert(int key, string value) {
    if (treeSize == 0) {
        root = new TreeNode(key, value);
    }
}


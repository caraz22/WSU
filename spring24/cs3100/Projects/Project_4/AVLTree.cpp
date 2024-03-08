#include "AVLTree.h"

AVLTree::AVLTree() {
    root = nullptr;
    treeSize = 0;
}

bool AVLTree::insert(int keyNum, string valueStr) {
    if (treeSize == 0) {
        root = new TreeNode(keyNum, valueStr);
    } else {
        TreeNode* current = new TreeNode(keyNum, valueStr);
    }
}


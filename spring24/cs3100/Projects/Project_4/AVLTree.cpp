/*
INCLUDE HEADER
*/
#include "AVLTree.h"

AVLTree::AVLTree() {
    root = nullptr;
    treeSize = 0;
}

bool AVLTree::insert(int keyNum, string valueStr) {
    return insertHelper(keyNum, valueStr, root);
}

bool AVLTree::insertHelper(int keyNum, string valueStr, TreeNode*& current) {
    if (current == nullptr) {
        current = new TreeNode(keyNum, valueStr);
        treeSize++;
        return true;
    } else if (keyNum < current->key) {
        return insertHelper(keyNum, valueStr, current->left);
    } else if (keyNum > current->key) {
        return insertHelper(keyNum, valueStr, current->right);
    } else {
        return false;
    }
} 

int AVLTree::getHeight() {
    if (root == nullptr) {
        treeHeight = 0;
    }

    TreeNode*& current = root;
    return treeHeight;
}

int AVLTree::getSize() {
    return treeSize;
}


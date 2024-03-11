#include "AVLTree.h"

AVLTree::AVLTree() {
    root = nullptr;
}

bool AVLTree::insert(int keyNum, string valueStr) {
    return insertHelper(keyNum, valueStr, root);
}

bool AVLTree::insertHelper(int keyNum, string valueStr, TreeNode*& current) {
    if (current == nullptr) {
        current = new TreeNode(keyNum, valueStr);
        return true;
    } else if (keyNum < current->key) {
        return insertHelper(keyNum, valueStr, current->left);
    } else if (keyNum > current->key) {
        return insertHelper(keyNum, valueStr, current->right);
    } else {
        return false;
    }
}
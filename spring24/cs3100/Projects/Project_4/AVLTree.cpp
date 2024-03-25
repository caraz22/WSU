/*
INCLUDE HEADER
*/
#include "AVLTree.h"

AVLTree::AVLTree() {
    root = nullptr;
    treeSize = 0;
    treeHeight = 0;
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
    return getHeightHelper(root);
}

int AVLTree::getHeightHelper(TreeNode*& current) {
    if (current == nullptr) {
        return 0;
    }

    return max(getHeightHelper(current->left), getHeightHelper(current->right)) + 1;
}

int AVLTree::getSize() {
    return treeSize;
}

bool AVLTree::find(int keyNum, string& valueStr) {
    return findHelper(keyNum, valueStr, root);
}

bool AVLTree::findHelper(int keyNum, string& valueStr, TreeNode*& current) {
    if (current == nullptr) {
        return false;
    } else if (current->key == keyNum) {
        valueStr = current->value;
        return true;
    } else if (current->key < keyNum) {
        return findHelper(keyNum, valueStr, current->right);
    } else if (current->key > keyNum) {
        return findHelper(keyNum, valueStr, current->left);
    }
}

vector<string> AVLTree::findRange(int start, int end) {
    vector<string> range;
    findRangeHelper(range, start, end, root);
    return range;
}

void AVLTree::findRangeHelper(vector<string>& range, int start, int end, TreeNode*& current) {
    if (current == nullptr) {
        return;
    } 
    
    if (current->key > start) {
        findRangeHelper(range, start, end, current->left);
    }
    
    if (start <= current->key && current->key <= end) {
        range.push_back(current->value);
    }

    if (current->key < end) {
        findRangeHelper(range, start, end, current->right);
    }
}
/*
INCLUDE HEADER
*/
#include "AVLTree.h"

AVLTree::AVLTree() {
    root = nullptr;
    treeSize = 0;
    treeHeight = 0;
}

AVLTree::AVLTree(const AVLTree& tree) {
    root = copyTree(tree.root);
}

AVLTree::TreeNode* AVLTree::copyTree(TreeNode* current) {
    if (current = nullptr) {
        return nullptr;
    }

    TreeNode* newNode = new TreeNode(current->key, current->value);
    newNode->left = copyTree(current->left);
    newNode->right = copyTree(current->right);
    return newNode;
}

AVLTree::~AVLTree() {
    clear(root);
}

void AVLTree::clear(TreeNode* current) {
    if (root == nullptr) {
        return;
    }

    while (current != nullptr) {
        clear(current->left);
        clear(current->right);
        delete current;
    }
}

bool AVLTree::insert(int keyNum, string valueStr) {
    return insertHelper(keyNum, valueStr, root);
}

bool AVLTree::insertHelper(int keyNum, string valueStr, TreeNode*& current) {
    if (current == nullptr) {
        current = new TreeNode(keyNum, valueStr);
        treeSize++;
        return true;

        int balance = getBalance(current);
        if (balance >= 2) {
            singleRotate(current, current->left);
        } else if (balance <= -2) {
            singleRotate(current, current->right);
        }
    } else if (keyNum < current->key) {
        return insertHelper(keyNum, valueStr, current->left);
    } else if (keyNum > current->key) {
        return insertHelper(keyNum, valueStr, current->right);
    } else if (find(keyNum, valueStr) == true) {
        return false;
    }
} 

int AVLTree::getBalance(TreeNode* current) {
    if (current == nullptr) {
        return 0;
    }

    int leftHeight = getHeightHelper(current->left);
    int rightHeight = getHeightHelper(current->right);
    return leftHeight - rightHeight;
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

void AVLTree::singleRotate(TreeNode*& problem, TreeNode*& hook) {
    if (getBalance(problem) > 1) {
        hook = problem;
        problem = hook->right;
    } else if (getBalance(problem) < -1) {
        hook = problem;
        problem = hook->left;
    }
}

void AVLTree::print(ostream& os, TreeNode* current, string indent) const {   
    if (current == nullptr) {
        return;
    }

    print(os, current->right, indent);

    os << indent << current->key << ", " << current->value << endl;

    print (os, current->left, indent);
}

ostream& operator<<(ostream& os, const AVLTree& tree) {
    string indent = "       ";
    tree.print(os, tree.root, indent);
    return os;
}
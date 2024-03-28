/*
Cara Zozokos
Project 4 - AVL Trees
This is the implementation file for project 4
*/
#include "AVLTree.h" // Include header file for AVLTree class

// Constructor: Initializes AVL tree with root as nullptr, size and height as 0
AVLTree::AVLTree() {
    root = nullptr;
    treeSize = 0;
    treeHeight = 0;
}

// Copy constructor: Creates a deep copy of the AVL tree
AVLTree::AVLTree(const AVLTree& tree) {
    root = copyTree(tree.root);
}

// Recursive function to copy a tree starting from a given node
AVLTree::TreeNode* AVLTree::copyTree(TreeNode* current) {
    if (current == nullptr) {
        return nullptr;
    }

    // Create a new node with the same key and value
    TreeNode* newNode = new TreeNode(current->key, current->value);

    // Recursively copy left and right subtrees
    newNode->left = copyTree(current->left);
    newNode->right = copyTree(current->right);

    return newNode;
}

// Destructor: Deallocates memory by clearing the AVL tree
AVLTree::~AVLTree() {
    clear(root);
}

// Recursive function to clear the AVL tree
void AVLTree::clear(TreeNode* current) {
    if (current == nullptr) {
        return;
    }

    // Recursively delete left and right subtrees
    clear(current->left);
    clear(current->right);

    // Delete the current node
    delete current;
}

// Insert a new node with given key and value into the AVL tree
bool AVLTree::insert(int keyNum, string valueStr) {
    return insertHelper(keyNum, valueStr, root);
}

// Helper function for insert
bool AVLTree::insertHelper(int keyNum, string valueStr, TreeNode*& current) {
    // Base case: If current node is null, insert new node here
    if (current == nullptr) {
        current = new TreeNode(keyNum, valueStr);
        treeSize++;

        // Perform rebalancing if necessary
        int balance = getBalance(current);
        if (balance >= 2) {
            singleRotate(current, current->left);
        } else if (balance <= -2) {
            singleRotate(current, current->right);
        }

        return true;
    }
    // Recursive cases: Insert into left or right subtree based on key comparison
    else if (keyNum < current->key) {
        return insertHelper(keyNum, valueStr, current->left);
    } else if (keyNum > current->key) {
        return insertHelper(keyNum, valueStr, current->right);
    }
    // If key already exists in the tree, return false
    else {
        return false;
    }
} 

// Get the balance factor of a node in the AVL tree
int AVLTree::getBalance(TreeNode* current) {
    if (current == nullptr) {
        return 0;
    }

    int leftHeight = getHeightHelper(current->left);
    int rightHeight = getHeightHelper(current->right);
    return leftHeight - rightHeight;
}

// Get the height of the AVL tree
int AVLTree::getHeight() {
    return getHeightHelper(root);
}

// Recursive helper function to get the height of a node in the AVL tree
int AVLTree::getHeightHelper(TreeNode*& current) {
    if (current == nullptr) {
        return 0;
    }

    return max(getHeightHelper(current->left), getHeightHelper(current->right)) + 1;
}

// Get the size of the AVL tree
int AVLTree::getSize() {
    return treeSize;
}

// Find a node with the given key and store its value in the second parameter
bool AVLTree::find(int keyNum, string& valueStr) {
    return findHelper(keyNum, valueStr, root);
}

// Recursive helper function to find a node with the given key
bool AVLTree::findHelper(int keyNum, string& valueStr, TreeNode*& current) {
    if (current == nullptr) {
        return false;
    } else if (current->key == keyNum) {
        valueStr = current->value;
        return true;
    } else if (current->key < keyNum) {
        return findHelper(keyNum, valueStr, current->right);
    } else { // (current->key > keyNum)
        return findHelper(keyNum, valueStr, current->left);
    }
}

// Find all values within the given range of keys
vector<string> AVLTree::findRange(int start, int end) {
    vector<string> range;
    findRangeHelper(range, start, end, root);
    return range;
}

// Recursive helper function to find all values within a given range of keys
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

// Perform a single rotation to balance the AVL tree
void AVLTree::singleRotate(TreeNode*& problem, TreeNode*& hook) {
    if (getBalance(problem) > 1) {
        hook = problem;
        problem = hook->right;
    } else if (getBalance(problem) < -1) {
        hook = problem;
        problem = hook->left;
    }
}

// Print the AVL tree
void AVLTree::print(ostream& os, TreeNode* current, string indent) const {   
    if (current == nullptr) {
        return;
    }

    print(os, current->right, indent);

    os << indent << current->key << ", " << current->value << endl;

    print (os, current->left, indent);
}

// Overloaded stream insertion operator for printing the AVL tree
ostream& operator<<(ostream& os, const AVLTree& tree) {
    string indent = "       ";
    tree.print(os, tree.root, indent);
    return os;
}
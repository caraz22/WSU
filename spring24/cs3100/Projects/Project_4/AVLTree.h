/*
Cara Zozokos
Project 4 - AVL Trees
This is the header file for project 4
*/
#include <iostream>
#include <vector>
#include <exception>

using namespace std;

class AVLTree {
private:
    // TreeNode class represents each node in the AVL tree
    class TreeNode {
    public:
        TreeNode* left;   // Pointer to the left child
        TreeNode* right;  // Pointer to the right child
        int key;          // Key value of the node
        string value;     // Associated value of the node

        // Constructors
        TreeNode() : left(nullptr), right(nullptr) {}

        TreeNode(int keyNum, string valueStr) : key(keyNum), value(valueStr), left(nullptr), right(nullptr) {}
    };

public:
    TreeNode* root;     // Pointer to the root node of the AVL tree
    int treeSize;       // Number of nodes in the AVL tree
    int treeHeight;     // Height of the AVL tree

    // Constructors and Destructor
    AVLTree();                           // Default constructor
    AVLTree(const AVLTree&);             // Copy constructor
    ~AVLTree();                          // Destructor

    // Copy assignment operator
    AVLTree& operator=(const AVLTree&);

    // Clear the AVL tree
    void clear(TreeNode*);

    // Insert a new node with given key and value into the AVL tree
    bool insert(int, string);

    // Helper function for insert
    bool insertHelper(int, string, TreeNode*&);

    // Get the height of the AVL tree
    int getHeight();

    // Helper function for getHeight
    int getHeightHelper(TreeNode*&);

    // Get the size of the AVL tree
    int getSize();

    // Overloaded stream insertion operator for printing the AVL tree
    friend ostream& operator<<(ostream&, const AVLTree&);

    // Print the AVL tree
    void print(ostream&, TreeNode*, string) const;

    // Find a node with the given key and store its value in the second parameter
    bool find(int, string&);

    // Helper function for find
    bool findHelper(int, string&, TreeNode*&);

    // Find all values within the given range of keys
    vector<string> findRange(int, int);

    // Helper function for findRange
    void findRangeHelper(vector<string>&, int, int, TreeNode*&);

    // Perform a single rotation to balance the AVL tree
    void singleRotate(TreeNode*&, TreeNode*&);    

    // Get the balance factor of a node in the AVL tree
    int getBalance(TreeNode*);

    // Copy the AVL tree rooted at the given node and return the new root
    TreeNode* copyTree(TreeNode*);
};
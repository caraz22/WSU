/*
INCLUDE HEADER
*/
#include <iostream>
#include <vector>
#include <exception>

using namespace std;

class AVLTree {
    private:
    class TreeNode {
        public:
        TreeNode* left;
        TreeNode* right;
        // TreeNode* hook;
        // TreeNode* problem;
        
        int key;
        string value;

        TreeNode() : left(nullptr), right(nullptr) {
        } 

        TreeNode(int keyNum, string valueStr) : key(keyNum), value(valueStr), left(nullptr), right(nullptr) {
        }
    };

    public:
    TreeNode* root;   
    int treeSize; 
    int treeHeight;

    AVLTree();

    AVLTree(const AVLTree&);

    TreeNode* copyTree(TreeNode*);

    AVLTree& operator=(const AVLTree&);

    ~AVLTree();

    void clear(TreeNode*);

    bool insert(int, string);

    bool insertHelper(int, string, TreeNode*&);

    int getHeight();

    int getHeightHelper(TreeNode*&);

    int getSize();

    friend ostream& operator<<(ostream&, const AVLTree&);

    void print(ostream&, TreeNode*, string) const;

    bool find(int, string&);

    bool findHelper(int, string&, TreeNode*&);

    vector<string> findRange(int, int);

    void findRangeHelper(vector<string>&, int, int, TreeNode*&);

    void singleRotate(TreeNode*&, TreeNode*&); // week 7 lecture 2

    void doubleRotate(TreeNode*&, TreeNode*&); // week 8 lecture 1

    int getBalance(TreeNode*);
};
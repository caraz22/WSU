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
        TreeNode* parent;
        
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

    bool insert(int, string);

    bool insertHelper(int, string, TreeNode*&);

    int getHeight(TreeNode*&);

    int getSize();

    friend ostream& operator<<(ostream&, const AVLTree&);

    bool find(int, string&);

    vector<string> findRange(int, int);


};
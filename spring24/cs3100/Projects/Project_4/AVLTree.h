#include <iostream>
#include <vector>
#include <exception>

using namespace std;

class AVLTree {

    public:
    typedef unsigned int size_type;

    AVLTree();

    bool insert(int, string);

    int getHeight();

    int getSize();

    friend ostream& operator<<(ostream&, const AVLTree&);

    bool find(int, string&);

    vector<string> findRange(int, int);

    private:
    class TreeNode {
        public:
        TreeNode* left;
        TreeNode* right;
        int key;
        string value;

        TreeNode() : left(nullptr), right(nullptr) {
        } 

        TreeNode(int keyNum, string valueStr) : key(keyNum), value(valueStr) {
        }
    };

    TreeNode* root;
    size_type treeSize;
};
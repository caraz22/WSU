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
        TreeNode* next;
        TreeNode* prev;
        int key;
        string value;

        TreeNode() : next(nullptr), prev(nullptr) {
        } 

        TreeNode(int keyNum, string valueStr) : key(keyNum), value(valueStr) {
        }
    };

    TreeNode* root;
    size_type treeSize;
};
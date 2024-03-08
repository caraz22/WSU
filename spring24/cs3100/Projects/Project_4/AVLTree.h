#include <iostream>
#include <vector>

using namespace std;

class AVLTree {

    public:
    bool insert(int, string);

    // bool insertHelper(int, Node *&);

    int getHeight();

    int getSize();

    friend ostream& operator<<(ostream&, const AVLTree&);

    bool find(int, string&);

    vector<string> findRange(int, int);
};
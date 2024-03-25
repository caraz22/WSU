/*
INCLUDE HEADER
*/
#include "AVLTree.h"

int main() {
    AVLTree myTree;
    myTree.insert(10, "ten");
    myTree.insert(20, "twenty");
    myTree.insert(5, "five");
    myTree.insert(27, "twenty seven");
    myTree.insert(22, "twenty two");
    myTree.insert(36, "thirty six");
    myTree.insert(18, "eighteen");

    string valueStr;

    cout << myTree.getSize() << endl;

    cout << myTree.find(8, valueStr) << endl;

    vector<string> range = myTree.findRange(10, 50);
    for (string s : range) {
        cout << s << endl;
    }

    cout << myTree.getHeight();
}
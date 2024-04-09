#include "Trie.h"

using namespace std;

int main() {
    Trie myTrie;
    myTrie.insert("apple");
    cout << myTrie.count() << endl;
    cout << myTrie.getSize() << endl;
    cout << myTrie.find("apple") << endl;
    cout << myTrie.find("banana") << endl;
}
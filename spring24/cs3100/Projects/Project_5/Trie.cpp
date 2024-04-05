#include "Trie.h"

Trie::Trie() {
    root = new TrieNode();
    numWords = 0;
    numNodes = 1;
}

Trie::Trie(const Trie& trieCopy) {

}

Trie::~Trie() {

}

bool Trie::insert(string word) {
    if (find(word) == true) {
        return false;
    }

    insertHelper(word, root);
}

bool Trie::insertHelper(string word, TrieNode*& current) {
    for (char c : word) {
        if (current->character != c) {
            current->children[c] = new TrieNode();
        }
        current = current->children[c];
    }

    
}
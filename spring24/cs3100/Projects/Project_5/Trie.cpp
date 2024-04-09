#include "Trie.h"

Trie::Trie() {
    root = new TrieNode();
    numWords = 0;
    numNodes = 1;
}

Trie::Trie(const Trie& trieCopy) {
    *this = trieCopy;
}

Trie::~Trie() {

}

int Trie::count() {
    return numWords;
}

int Trie::getSize() {
    return numNodes;
}

bool Trie::insert(string word) {
    if (find(word) == true) {
        return false;
    }

    return insertHelper(word, root);
}

bool Trie::insertHelper(string word, TrieNode*& current) {
    bool inserted;

    if (word.length() == 0) {
        inserted = false;
    }

    if (current->character != word[0]) {
        current = new TrieNode();
        numNodes++;

        if (word.length() == 1) {
            current->endOfWord = true;
            numWords++;
            inserted = true;
        } else if (word.length() > 1) {
            insertHelper(word.substr(1), current);
        }
    }

    return inserted;
}

bool Trie::find(string word) {
    return findHelper(word, root);
}

bool Trie::findHelper(string word, TrieNode*& current) {
    bool found = false;
    if (current->endOfWord && word.length() == 0) {
        found = true;
    }
    if (word.length() > 1) {
        findHelper(word.substr(1), current->children.at(word[0]));
    } else if (word.length() == 1) {
        findHelper("", current->children.at(word[0]));
    }

    return found;
}

// int Trie::completeCount(string word) {
//     return completeCountHelper(word, root);
// }

// int Trie::completeCountHelper(string word, TrieNode*& current) {
//     int count = 0;
//     for (char c : word) {

//     }


//     return count;
// }
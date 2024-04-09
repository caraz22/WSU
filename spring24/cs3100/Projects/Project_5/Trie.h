#include <iostream>
#include <exception>
#include <vector>

using namespace std;

class Trie {
    private:
    class TrieNode {
        public:
        char character;
        vector<TrieNode*> children;
        bool endOfWord;

        TrieNode() : character(' '), children(26, nullptr), endOfWord(false) {}
    };

    public:
    TrieNode* root;
    int numWords;
    int numNodes;

    Trie();
    Trie(const Trie&);
    ~Trie();
    
    bool insert(string);
    bool insertHelper(string, TrieNode*&);
    int count();
    int getSize();
    bool find(string);
    bool findHelper(string, TrieNode*&);
    int completeCount(string);
    int completeCountHelper(string, TrieNode*&);
    // vector<string> complete(string);
    // Trie& operator=(const Trie&);
};
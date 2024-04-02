#include <iostream>
#include <exception>
#include <vector>

using namespace std;

class Trie {
    public:
    Trie();
    Trie(const Trie&);
    ~Trie();
    
    bool insert(string);
    int count();
    int getSize();
    bool find(string);
    int completeCount(string);
    vector<string> complete(string);
    Trie& operator=(const Trie&);
};
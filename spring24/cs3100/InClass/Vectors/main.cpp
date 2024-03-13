#include <iostream>
#include <vector>

using namespace std;

int main() {
    vector<string> v;
    v.push_back("Hi");
    v.push_back("There");
    v.push_back("Done"); 

    for (string s : v) {
        cout << s << endl;
    }
}
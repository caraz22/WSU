#include <iostream>
#include <random>

using namespace std;

class Character {
    private:
    string name;
    string role;
    int hp;
    int ab;
    int db;
    int ac;

    public:
    Character();
    Character(string, string, int, int ,int, int);

    string getName();
    string getRole();
    int getHP();
    
    void attack(Character &);
    void damage(int);

    Character getCharacter(string, string, string, int, int, int, int);

    void print(ostream&);
};
#include <iostream>
#include <random>

using namespace std;

class Character {
    private:
    string name;            // the character's name
    string role;            // the character's role
    int hp;                 // the character's hit points
    int ab;                 // the character's attack bonus
    int db;                 // the character's damage bonus
    int ac;                 // the character's armor class

    public:
    Character(string, string, int, int ,int, int);          // parameterized constructor

    string getName();                   // returns the character's name
    string getRole();                   // returns the character's role
    int getHP();                        // returns the character's hp
    
    void attack(Character &);           // attack the other character
    void damage(int);                   // take the damage from the attack and subtract it from the character's current hp

    void print(ostream&);               // print the character's summary
};
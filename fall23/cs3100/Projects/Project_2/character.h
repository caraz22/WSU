#include <string>

using namespace std;

class Character {
    private:
    string name;            // the character's name
    string role;            // the type of character
    int hp;                 // the character's current health
    int attackBonus;        // value added to the character's attack roll
    int dmgBonus;           // value added to the character's damage roll
    int armorClass;         // value that determines how hard a character is to hit

    public:
    // Parameterized constructor
    Character(string, string, int, int, int, int);

    // print the character
    void print(ostream&);
    // attack another character
    void attack(Character &otherCharacter);
    // subtract amount from the character's current hp
    void damage(int amount);

    // return the character's current health
    int getHP();
    // return the character's name
    string getName();
    // return the character's role
    string getRole();
    // return the character's attack bonus
    int getAB();
    // return the character's damage bonus
    int getDB();
    // return the character's armor class
    int getAC();
};
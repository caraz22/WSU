#include "Character.h"
#include <iostream>
#include <cstdlib>

using namespace std;

// Character: Take in the parameters, and assign their values to a character
// Parameters: each passed in parameter is set equal to their equivalent variable from the .h file
// The variables' functions are stated in the .h file
Character::Character(string charName, string charRole, int charHP, int charAB, int charDB, int charAC) {
    name = charName;
    role = charRole;
    hp = charHP;
    attackBonus = charAB;
    dmgBonus = charDB;
    armorClass = charAC;
}

// getName: a getter that returns the character's name
string Character::getName() {
    return name;
}

// getRole: a getter that returns the character's role
string Character::getRole() {
    return role;
}

// getHP: a getter that returns the character's HP
int Character::getHP() {
    return hp;
}

// print: prints out the summary for all the character's attributes
void Character::print(ostream& os) {
    os << "Character summary" << endl;
    os << "-----------------" << endl;
    os << name << " the " << role << endl;
    os << "HP: " << hp << endl;
    os << "AB: " << attackBonus << endl;
    os << "DB: " << dmgBonus << endl;
    os << "AC: " << armorClass << endl;
}

// attack: a method called for one character to attack the other
// Parameters:
//      &otherCharacter (Character) - the character that is being attacked
//      diceRollOne (int) - a randomly generated number from 1 to 20
//      diceRollTwo (int) - a randomly genereated number from 1 to 10
void Character::attack(Character &otherCharacter, int diceRollOne, int diceRollTwo) {
    int plusAB = diceRollOne + attackBonus;     // add the character's attack bonus to the first dice roll
    int plusDB = diceRollTwo + dmgBonus;        // add the character's damage bonus to the second dice roll

    cout << name << " attacks!" << endl;
    // Printing out the individual numbers and their sum
    cout << "Attack roll: " << diceRollOne << " + " << attackBonus << " = " << plusAB;

    // if the sum of the character's attack bonus and the first dice roll
    // is less than the other character's armor class, then the attack misses
    if (plusAB < otherCharacter.armorClass) {       
        cout << " --> MISS!" << endl;               
    }
    // if the sum of the character's attack bonus and the first dice roll
    // is greater than the other character's armor class, then he attack hits
    else if (plusAB >= otherCharacter.armorClass) { 
        cout << " --> HIT!" << endl;
        // the attack's damage is determined by the sum of the second dice roll and the character's damage bonus
        cout << "Damage: " << diceRollTwo << " + " << dmgBonus << " = " << plusDB << endl;
        // passing in the attack's damage into the damage method
        otherCharacter.damage(plusDB);
        // printing out the attacked character's remaining hp
        cout << otherCharacter.name << " has " << otherCharacter.hp << " hit points remaining" << endl;
    }
}

// damage: a method called for the calculation of subtracting a certain amount of damage from the character's hp
// Parameters:
        // amount (int) - the number that will be subtracted from the character's hp
void Character::damage(int amount) {
    // if the remainder of the character's hp after the subtraction calculation is less than 0
    // then set the character's hp equal to 0
    if ((getHP() - amount) < 0) {
        hp = 0;
    }
    // otherwise, subtract the amount from the character's hp
    else {
        hp -= amount;
    }
}
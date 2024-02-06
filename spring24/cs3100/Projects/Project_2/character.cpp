#include "character.h"

/*
Character: create a character using the parameters and setting them equal to their respective private variable
Parameters: 
    charName (string) - the name from user input
    charRole (string) - the role from user input
    charHP (int) - the number assigned to the character's HP
    charAB (int) - the number assigned to the character's attack bonus
    charDB (int) - the number assigned to the character's damage bonus
    charAC (int) - the number assigned to the character's armor class
*/
Character::Character(string charName, string charRole, int charHP, int charAB, int charDB, int charAC) {
    name = charName;            
    role = charRole;
    hp = charHP;
    ab = charAB;                    // the attack bonus is the value that will be added to the character's attack roll to determine if an attack hits
    db = charDB;                    // the damage bonus is the value that will be added to the character's damage role when attacking
    ac = charAC;                    // the armor class is the value that determines if the attack will hit
}

// getName: a getter that returns the character's name
string Character::getName() {
    return name;
}

// getRole: a getter that returns the character's role
string Character::getRole() {
    return role;
}

// getHP: a getter that returns the character's current HP
int Character::getHP() {
    return hp;
}

/*
attack: function for one character to attack the other
Parameters:
    &otherCharacter (Character) - the character that will be attacked
*/
void Character::attack(Character &otherCharacter) {
    cout << getName() << " attacks!" << endl;           // get the name of the character to print out who is attacking
    
    bool attackHits;                                    // boolean for when an attack hits or not

    int diceRoll = (rand() % 20) + 1;                   // the first dice roll is a random number generated between 1 and 20
    int addedAttack = diceRoll + ab;                    // add the character's attack bonus to the dice roll
    cout << "Attack roll: " << diceRoll << " + " << ab << " = " << addedAttack << " --> ";
    if (addedAttack >= otherCharacter.ac) {             // if the added value of the first dice role and the character's attack bonus
        attackHits = true;                              // is greater than the other character's armor class, 
        cout << "HIT!" << endl;                         // then set the boolean to true and the attack hits
    } else {                                            // if the added value of the first dice role and the character's attack bonus
        attackHits = false;                             // is less than the other character's armor class,
        cout << "MISS!" << endl;                        // then set the boolean to false and the attack misses
    }

    int diceRollTwo = (rand() % 10) + 1;                // the second dice roll is a random number generated between 1 and 10
    int addedDamage = diceRollTwo + db;                 // add the character's damage bonus to the dice roll

    if (attackHits == true) {                                                                                                   // if the boolean was set to true and the attack hits,
        cout << "Damage: " << diceRollTwo << " + " << db << " = " << addedDamage << endl;                                       // display the damage, and call the damage function 
        otherCharacter.damage(addedDamage);                                                                                     // on the other character
        if (otherCharacter.getHP() > 0) {                                                                                       // if the other character's hp is still greater than 0,
            cout << otherCharacter.getName() << " has " << otherCharacter.getHP() << " hit points remaining" << endl;           // display their remaining health
        } else {                                                                                                                // if their hp is less than or equal to 0
            cout << otherCharacter.getName() << " has " << otherCharacter.getHP() << " hit points remaining" << endl;           // display their remaining health (0)
            cout << endl << getName() << " wins!";                                                                              // and display the winner's name
        }
    }
}

/*
damage: if an attack hits, use this function to determine how much of the other character's hp is left
Parameters:
    dmg (integer) - the amount of damage being dealt
*/
void Character::damage(int dmg) {
    if ((getHP() - dmg) > 0) {          // if the character's hp after the attack is greater than 0,
        hp -= dmg;                      // then subtract the damage from their hp
    } else {                            // otherwise,
        hp = 0;                         // their health is 0
    }
}

/*
print: used to display the character's summary
Parameters:
    &os (ostream) - allows the use of cout to be passed in
*/
void Character::print(ostream &os) {
    os << "Character summary" << endl;
    os << "-----------------" << endl;
    os << getName() << " the " << getRole() << endl;
    os << "HP: " << hp << endl;
    os << "AB: " << ab << endl;
    os << "DB: " << db << endl;
    os << "AC: " << ac << endl;
}
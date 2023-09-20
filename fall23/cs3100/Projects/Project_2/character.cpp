#include "character.h"
#include <iostream>
#include <cstdlib>

using namespace std;

Character::Character(string newName, string newRole) {
    setName(newName);
    setRole(newRole);
}

void Character::setName(string newName) {
    name = newName;
}
string Character::getName() {
    return name;
}

void Character::setRole(string newRole) {
    role = newRole;
}
string Character::getRole() {
    return role;
}

void Character::setHP(int charHP) {
    hp = charHP;
}
int Character::getHP() {
    return hp;
}

void Character::setAB(int charAB) {
    attackBonus = charAB;
}
int Character::getAB() {
    return attackBonus;
}

void Character::setDB(int charDB) {
    dmgBonus = charDB;
}
int Character::getDB() {
    return dmgBonus;
}

void Character::setAC(int charAC) {
    armorClass = charAC;
}
int Character::getAC() {
    return armorClass;
}

void Character::print(ostream& os) {
    os << "Character summary" << endl;
    os << "-----------------" << endl;
    os << getName() << " the " << getRole() << endl;
    os << "HP: " << getHP() << endl;
    os << "AB: " << getAB() << endl;
    os << "DB: " << getDB() << endl;
    os << "AC: " << getAC() << endl;
}

void Character::attack(Character &otherCharacter) {
    srand(time(NULL));
    int diceRollOne = (rand() % 20) +1;
    int plusAB = diceRollOne + getAB();

    int diceRollTwo = (rand() % 10) + 1;
    int plusDB = diceRollTwo + getDB();
    
    Character * charTwo = &otherCharacter;

    cout << getName() << " attacks!" << endl;
    cout << "Attack roll: " << diceRollOne << " + " << getAB() << " = " << plusAB;

    if ((plusAB + getAB()) < charTwo->getAC()) {
        cout << " --> MISS!" << endl;
    }
    else if ((plusAB + getAB()) >= charTwo->getAC()) {
        cout << " --> HIT!" << endl;
        cout << "Damage: " << diceRollTwo << " + " << getDB() << " = " << plusDB << endl;
        charTwo->damage(plusDB);
        cout << charTwo->getName() << " has " << charTwo->getHP() << " hit points remaining";
    }
}

void Character::damage(int amount) {
    int currentHP = getHP();
    if ((currentHP - amount) < 0) {
        currentHP = 0;
    }
    else {
        currentHP -= amount;
    }
}
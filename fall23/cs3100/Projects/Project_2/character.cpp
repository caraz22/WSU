#include "character.h"
#include <iostream>

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
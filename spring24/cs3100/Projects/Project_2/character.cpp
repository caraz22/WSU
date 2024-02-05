#include "character.h"

Character::Character() {
}

Character::Character(string charName, string charRole, int charHP, int charAB, int charDB, int charAC) {
    name = charName;
    role = charRole;
    hp = charHP;
    ab = charAB;
    db = charDB;
    ac = charAC;
}

string Character::getName() {
    return name;
}

string Character::getRole() {
    return role;
}

int Character::getHP() {
    return hp;
}

void Character::attack(Character &otherCharacter) {
    cout << getName() << " attacks!" << endl;
    
    bool attackHits;

    int diceRoll = (rand() % 20) + 1;
    int addedAttack = diceRoll + ab;
    cout << "Attack roll: " << diceRoll << " + " << ab << " = " << addedAttack << " --> ";
    if (addedAttack >= otherCharacter.ac) {
        attackHits = true;
        cout << "HIT!" << endl;
    } else {
        attackHits = false;
        cout << "MISS!" << endl;
    }

    int diceRollTwo = (rand() % 10) + 1;
    int addedDamage = diceRollTwo + db;

    if (attackHits == true) {
        cout << "Damage: " << diceRollTwo << " + " << db << " = " << addedDamage << endl;    
        otherCharacter.damage(addedDamage);
        if (otherCharacter.getHP() > 0) {
            cout << otherCharacter.getName() << " has " << otherCharacter.getHP() << " hit points remaining" << endl;
        } else {
            cout << otherCharacter.getName() << " has " << otherCharacter.getHP() << " hit points remaining" << endl;
            cout << endl << getName() << " wins!";
        }
    }
}

void Character::damage(int dmg) {
    if ((getHP() - dmg) > 0) {
        hp -= dmg;
    } else {
        hp = 0;
    }
}

Character Character::getCharacter(string order, string charName, string charRole, int charHP, int charAB, int charDB, int charAC) {
    cout << order << " character name?" << endl;
    cin >> charName;

    cout << endl << charName << "'s role?" << endl;
    cin >> charRole;

    cout << endl << charName << " the " << charRole << "'s hit points?" << endl;
    cin >> charHP;

    cout << endl << charName << " the " << charRole << "'s attack bonus?" << endl;
    cin >> charAB;

    cout << endl << charName << " the " << charRole << "'s damage bonus?" << endl;
    cin >> charDB;

    cout << endl << charName << " the " << charRole << "'s armor class?" << endl;
    cin >> charAC;   

    Character character(charName, charRole, charHP, charAB, charDB, charAC);
    return character;
}

void Character::print(ostream &os) { // this.print(cout)
    os << "Character summary" << endl;
    os << "-----------------" << endl;
    os << getName() << " the " << getRole() << endl;
    os << "HP: " << hp << endl;
    os << "AB: " << ab << endl;
    os << "DB: " << db << endl;
    os << "AC: " << ac << endl;
}
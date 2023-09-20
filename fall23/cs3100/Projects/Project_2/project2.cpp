#include <iostream>
#include "Character.h"

using namespace std;

int main() {
    string firstCharName;
    string firstCharRole;
    int firstCharHP;
    int firstCharAB;
    int firstCharDB;
    int firstCharAC;

    cout << "First character name?" << endl;
    cin >> firstCharName;
    cout << endl << firstCharName << "'s role?" << endl;
    cin >> firstCharRole;
    Character firstChar(firstCharName, firstCharRole);

    cout << endl << firstCharName << " the " << firstCharRole << "'s hit points?" << endl;
    cin >> firstCharHP;
    firstChar.setHP(firstCharHP);

    cout << endl << firstCharName << " the " << firstCharRole << "'s attack bonus?" << endl;
    cin >> firstCharAB;
    firstChar.setAB(firstCharAB);

    cout << endl << firstCharName << " the " << firstCharRole << "'s damage bonus?" << endl;
    cin >> firstCharDB;
    firstChar.setDB(firstCharDB);

    cout << endl << firstCharName << " the " << firstCharRole << "'s armor class?" << endl;
    cin >> firstCharAC;
    firstChar.setAC(firstCharAC);

    cout << endl;
    firstChar.print(cout);
    cout << endl;

    string secondCharName;
    string secondCharRole;
    int secondCharHP;
    int secondCharAB;
    int secondCharDB;
    int secondCharAC;

    cout << "Second character name?" << endl;
    cin >> secondCharName;
    cout << endl << secondCharName << "'s role?" << endl;
    cin >> secondCharRole;
    Character secondChar(secondCharName, secondCharRole);

    cout << endl << secondCharName << " the " << secondCharRole << "'s hit points?" << endl;
    cin >> secondCharHP;
    secondChar.setHP(secondCharHP);

    cout << endl << secondCharName << " the " << secondCharRole << "'s attack bonus?" << endl;
    cin >> secondCharAB;
    secondChar.setAB(secondCharAB);

    cout << endl << secondCharName << " the " << secondCharRole << "'s damage bonus?" << endl;
    cin >> secondCharDB;
    secondChar.setDB(secondCharDB);

    cout << endl << secondCharName << " the " << secondCharRole << "'s armor class?" << endl;
    cin >> secondCharAC;
    secondChar.setAC(secondCharAC);

    cout << endl;
    secondChar.print(cout);
    cout << endl;

    cout << endl << "Simulated Combat:" << endl;

    while ((firstChar.getHP() > 0) || (secondChar.getHP() > 0)) {
        firstChar.attack(secondChar);
        cout << endl;
        secondChar.attack(firstChar);
        cout << endl;
    }

    if (firstChar.getHP() == 0) {
        cout << secondChar.getName() << " wins!";
    }
    else if (secondChar.getHP() == 0) {
        cout << firstChar.getName() << " wins!";
    }
}
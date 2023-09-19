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
    cout << endl << endl << firstCharName << " role?" << endl;
    cin >> firstCharRole;
    Character firstChar(firstCharName, firstCharRole);

    cout << endl << endl << firstCharName << " the " << firstCharRole << " hit points?" << endl;
    cin >> firstCharHP;
    firstChar.setHP(firstCharHP);

    cout << endl << endl << firstCharName << " the " << firstCharRole << " attack bonus?" << endl;
    cin >> firstCharAB;
    firstChar.setAB(firstCharAB);

    cout << endl << endl << firstCharName << " the " << firstCharRole << " damage bonus?" << endl;
    cin >> firstCharDB;
    firstChar.setDB(firstCharDB);

    cout << endl << endl << firstCharName << " the " << firstCharRole << " armor class?" << endl;
    cin >> firstCharAC;
    firstChar.setAC(firstCharAC);

    firstChar.print(cout);
}
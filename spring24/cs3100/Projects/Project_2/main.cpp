#include "character.h"

using namespace std;


int main() {
    string firstCharOrder = "First";
    string firstCharName;       // initializing the first character's name
    string firstCharRole;       // initializing the first character's role
    int firstCharHP = 0;            // initializing the first character's HP
    int firstCharAB = 0;            // initializing the first character's attack bonus
    int firstCharDB = 0;            // initializing the first character's damage bonus
    int firstCharAC = 0;            // initializing the first character's armor class

    Character firstChar;
    firstChar.getCharacter(firstCharOrder, firstCharName, firstCharRole, firstCharHP, firstCharAB, firstCharDB, firstCharAC);
    cout << endl;
    firstChar.print(cout);
    
    string secondCharOrder = "Second";
    string secondCharName;      // initializing the second character's name
    string secondCharRole;      // initializing the second character's role
    int secondCharHP = 0;           // initializing the second character's hp
    int secondCharAB = 0;           // initializing the second character's attack bonus
    int secondCharDB = 0;           // initializing the second character's damage bonus
    int secondCharAC = 0;           // initializing the second character's armor class

    Character secondChar;
    secondChar.getCharacter(secondCharOrder, secondCharName, secondCharRole, secondCharHP, secondCharAB, secondCharDB, secondCharAC);
    cout << endl;
    secondChar.print(cout);
    
    cout << endl;

    cout << "Simulated Combat:" << endl;

    srand((unsigned int)time(NULL));
    while (firstChar.getHP() > 0 && secondChar.getHP() > 0) {
        firstChar.attack(secondChar);
        cout << endl;
        if (secondChar.getHP() > 0) {
            secondChar.attack(firstChar);  
            cout << endl;                  
        } else {
            break;
        }

    }
}

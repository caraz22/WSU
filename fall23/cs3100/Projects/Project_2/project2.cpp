#include <iostream>
#include "Character.h"

using namespace std;

int main() {
    srand((unsigned int)time(NULL));    // needed for the random numbers to change for each time rand() is used
    int diceRollOne;                    // first dice roll for the attack method
    int diceRollTwo;                    // second dice roll for the attack method

    string firstCharName;       // initializing the first character's name
    string firstCharRole;       // initializing the first character's role
    int firstCharHP;            // initializing the first character's HP
    int firstCharAB;            // initializing the first character's attack bonus
    int firstCharDB;            // initializing the first character's damage bonus
    int firstCharAC;            // initializing the first character's armor class

    cout << "First character name?" << endl;                    // prompting for the first character's name
    cin >> firstCharName;

    cout << endl << firstCharName << "'s role?" << endl;        // prompting for the first character's role
    cin >> firstCharRole;

    cout << endl << firstCharName << " the " << firstCharRole << "'s hit points?" << endl;      // prompting for the first character's hp
    cin >> firstCharHP;

    cout << endl << firstCharName << " the " << firstCharRole << "'s attack bonus?" << endl;    // prompting for the first character's 
    cin >> firstCharAB;                                                                         // attack bonus

    cout << endl << firstCharName << " the " << firstCharRole << "'s damage bonus?" << endl;    // prompting for the first character's 
    cin >> firstCharDB;                                                                         // damage bonus

    cout << endl << firstCharName << " the " << firstCharRole << "'s armor class?" << endl;     // prompting for the first character's 
    cin >> firstCharAC;                                                                         // armor class

    // initializing the first character using all the user's inputs
    Character firstChar(firstCharName, firstCharRole, firstCharHP, firstCharAB, firstCharDB, firstCharAC);

    cout << endl;
    // calling print function to print out the first character's summary
    firstChar.print(cout);      
    cout << endl;

    string secondCharName;      // initializing the second character's name
    string secondCharRole;      // initializing the second character's role
    int secondCharHP;           // initializing the second character's hp
    int secondCharAB;           // initializing the second character's attack bonus
    int secondCharDB;           // initializing the second character's damage bonus
    int secondCharAC;           // initializing the second character's armor class

    cout << "Second character name?" << endl;                   // prompting for the second character's name
    cin >> secondCharName;
    cout << endl << secondCharName << "'s role?" << endl;       // prompting for the second character's role
    cin >> secondCharRole;

    cout << endl << secondCharName << " the " << secondCharRole << "'s hit points?" << endl;        // prompting for the second
    cin >> secondCharHP;                                                                            // character's hp

    cout << endl << secondCharName << " the " << secondCharRole << "'s attack bonus?" << endl;      // prompting for the second
    cin >> secondCharAB;                                                                            // character's attack bonus

    cout << endl << secondCharName << " the " << secondCharRole << "'s damage bonus?" << endl;      // prompting for the second
    cin >> secondCharDB;                                                                            // character's damage bonus

    cout << endl << secondCharName << " the " << secondCharRole << "'s armor class?" << endl;       // prompting for the second
    cin >> secondCharAC;                                                                            // character's armor class

    // initializing the second character using all the user's inputs
    Character secondChar(secondCharName, secondCharRole, secondCharHP, secondCharAB, secondCharDB, secondCharAC);

    cout << endl;
    // calling print function to print out the first character's summary
    secondChar.print(cout);         
    cout << endl;

    // Starting the simulated combat
    cout << endl << "Simulated Combat:" << endl;

    // while both character's hp are greater than 0
    while ((firstChar.getHP() > 0) && (secondChar.getHP() > 0)) {
        diceRollOne = (rand() % 20) + 1;        // generating a random number from 1 to 20
        diceRollTwo = (rand() % 10) + 1;        // generating a random number from 1 to 10
        firstChar.attack(secondChar, diceRollOne, diceRollTwo);     // first character attacks first using their dice rolls
        cout << endl;
        // if the second character's hp is equal to 0
        if (secondChar.getHP() == 0) {
            // declare the first character as the winner
            cout << firstChar.getName() << " the " << firstChar.getRole() << " wins!" << endl;
            // break out of the loop
            break;
        }

        diceRollOne = (rand() % 20) + 1;        // generating a randon number from 1 to 20
        diceRollTwo = (rand() % 10) + 1;        // generating a random number from 1 to 10
        secondChar.attack(firstChar, diceRollOne, diceRollTwo);     // second character attacks after the first using their dice rolls
        cout << endl;
        // if the first character's hp is equal to 0
        if (firstChar.getHP() == 0) {
            // declare the second character as the winner
            cout << secondChar.getName() << " the " << secondChar.getRole() << " wins!" << endl;
        }    
    }
}
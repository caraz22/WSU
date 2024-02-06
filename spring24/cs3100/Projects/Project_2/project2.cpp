#include "character.h"
#include <unistd.h>             // I know this is NOT required, I just wanted to implement sleep into this project to make it more readable on runtime

using namespace std;


int main() {
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
    sleep(2);                       // sleep for 2 seconds before starting the combat
    
    cout << endl;

    // beginning of combat
    cout << "Simulated Combat:" << endl;

    // required to get a different dice roll each turn
    srand((unsigned int)time(NULL));
    while (firstChar.getHP() > 0 && secondChar.getHP() > 0) {       // while both characters' hp are greater than 0
        firstChar.attack(secondChar);                               // first character attacks first
        sleep(1);                                                   // sleep for 1 second in between attacks
        cout << endl;                                   
        if (secondChar.getHP() > 0) {                               // if the first character's attack
            secondChar.attack(firstChar);                           // leaves the second character with more than 0 hp,
            sleep(1);                                               // sleep for 1 second in between attacks
            cout << endl;                                           // continue with the loop
        } else {                                                    // otherwise, 
            break;                                                  // break out of the loop so that the second character does not attack
        }

    }
}

/*
Cara Zozokos
Project #1 - Simulating dice rolls
*/

#include <iostream>
#include <cstdlib>

using namespace std;

/*
counter: go through every value in the array, check the value, and add it to a counter if the value is equal to the specified number.

Returns: nothing, method is void, prints an output instead.

Parameters:
    rolls (int) - the number of rolls specified from user input
    tosses[] (array of integers) - the array of values for each roll
    num (int) - the specified number whose count is added up each time it appears in the array
*/
void counter(int rolls, int tosses[], int num) {    
    int count = 0;                           // initializing the counter at 0
    int * p = tosses;                        // setting a pointer equal to the array (so its first memory address)
    for (int i = 0; i < rolls; i++) {        // for loop to go through each value in the array and check its value
        if (*p == num) {                     // if the value equals the given number,
            count += 1;                      // add 1 to the count
        }
        p += 1;                              // move to the next address in memory
    }

    cout << num << " was rolled " << count << " times" << endl;
}

int main() {
    cout << "How many rolls? ";                                  // prompting for user input
    int rolls;                                                   // setting the variable for the rolls
    cin >> rolls;                                                // taking in user input
    cout << "Simulating " << rolls << " rolls..." << endl;

    int tosses[rolls];           // creating an array at the size of the number of rolls specified

    srand(time(NULL));           // must be done so that the values are different each time the program is ran

    int randNumOne;        // initializing the first dice value                                       
    int randNumTwo;        // initializing the second dice value
    int totalVal;          // initializing the value for the sum of dice values


    for (int i = 0; i < rolls; i++) {           // for every roll,
        randNumOne = (rand() % 6) + 1;          // create a random number for dice 1
        randNumTwo = (rand() % 6) + 1;          // and dice 2
        totalVal = randNumOne + randNumTwo;     // add the two numbers together
        tosses[i] = totalVal;                   // and add that value to the array
    }

    cout << "Results:" << endl;

    for (int i = 2; i < 13; i++) {      // for every possible value, 
        counter(rolls, tosses, i);      // run it through the counter method as the specified number
    }
}
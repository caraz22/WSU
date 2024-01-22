#include "Student.h"

    // Parameterized constructor
    Student::Student(string newLastName, string newFirstName, int newUid) {
        lastName = newLastName;
        firstName = newFirstName;
        uid = newUid;
    }

    // Default constructor
    Student::Student() {
        lastName = "invalid";
        firstName = "invalid";
        uid = 0;
    }

    void Student::setLastName(string newLastName) {
            // Error checking
            lastName = newLastName;
        }

    string Student::getLastName() {
        return lastName;
    }
    void Student::print() {
        cout << lastName << ", " << firstName << ", (U" << uid << ")" << endl;
    }
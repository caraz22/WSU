#include "Student.h"
#include <iostream>
#include <iomanip>
#include <exception>
#include <stdexcept>

using namespace std;

// Default constructor
// We have to use Student:: before each method
// definition to specify that this method belongs
// to class Student
Student::Student() {
    uid = -1;
    firstName = "invalid";
    lastName = "student";
    gradeList = nullptr;
}

// Fully paramaterized constructor
Student::Student(int newUid, string newLastName, string newFirstName) : lastName(newLastName), firstName(newFirstName) {
    setUid(newUid);
    gradeList = nullptr;
}

// Copy constructor
Student::Student(const Student &oldStudent) {
    lastName = oldStudent.lastName;
    firstName = oldStudent.firstName;
    uid = oldStudent.uid;
    gradeList = nullptr;
    GradeNode * current = oldStudent.gradeList;
    while(current) {
        addGrade(current->grade);
        current = current->next;
    }
}

// Destructor
Student::~Student() {
    GradeNode * current = gradeList;
    while(current != nullptr) {
        GradeNode * killMeNext = current->next;
        delete current;
        current = killMeNext;
    }
}

// Getters and setters
int Student::getUid() {
    return uid;
}

void Student::setUid(int newUid) {
    if ((newUid <= 0) || (newUid > MAX_UID)) {
        throw invalid_argument("Invalid UID");
    }

    uid = newUid;
}

// Print a student as follows:
// "LastName, FirstName (U00000123)"
void Student::print(ostream& os) {
    os << lastName << ", " << firstName;
    os << " (U" << setw(8) << setfill('0') << uid << ")" << endl;
    os << "Grades: ";
    GradeNode * current = gradeList;
    while(current) {
        os << current->grade << ", ";
        current = current->next;
    }

    os << endl;
}

void Student::addGrade(char newGrade) {
    if (gradeList == nullptr) {
        gradeList = new GradeNode();
        gradeList->grade = newGrade;
    } 
    else {
        GradeNode * current = gradeList;
        while(current->next != nullptr) {
            current = current->next;
        }

        current->next = new GradeNode();
        current->next->grade = newGrade;
    }
}

void Student::changeGrade(int index, char newGrade) {
    GradeNode * current = gradeList;
    // if (current == nullptr)
    if (!current) {
        throw exception();
    }

    // Find the right grade node
    for (int i = 0; i < index; i++) {
        current = current->next;
        if (!current) {
            throw exception();
        }
    }

    current->grade = newGrade;
}

// float Student::getGPA() {
//     int gpaPoints = 0;
//     int gradeCount = 0;
//     GradeNode * current = gradeList;
//     while(current) {
//         gpaPoints += current->getPoints();
//         gradeCount++;
//         current = current->next;
//     }

//     if (!gradeCount) {
//         return 0.0;
//     }

//     return (float)gpaPoints/(float)gradeCount;
// }
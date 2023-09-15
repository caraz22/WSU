#include "Student.h"
#include <iostream>
#include <iomanip>
#include <exception>
#include <stdexcept>

using namespace std;

Student::Student() {
    uid = -1;
    firstName = "invalid";
    lastName = "student";
    gradeList = nullptr;
}

Student::Student(int newUid, string newLastName, string newFirstName) : lastName(newLastName), firstName(newFirstName) {
    setUid(newUid);
    gradeList = nullptr;
}

Student::~Student() {
    GradeNode * current = gradeList;
    while(current != nullptr) {
        GradeNode * killMeNext = current->next;
        delete current;
        current = killMeNext;
    }
}

int Student::getUid() {
    return uid;
}

void Student::setUid(int newUid) {
    if ((newUid <= 0 || newUid > MAX_UID)) {
        throw invalid_argument("Invalid UID");
    }

    uid = newUid;
}

void Student::setLastName(string lastName) {
    this->lastName = lastName;
}

void Student::print(ostream& os) {
    os << lastName << ", " << firstName;
    os << " (U" << setw(8) << setfill('0') << uid << ")" << endl;
}

void Student::addGrade(char newGrade) {
    if (gradeList == nullptr) {
        gradeList = new GradeNode();
        gradeList->grade = newGrade;        
    } else {
        GradeNode * current = gradeList;
        while (current->next != nullptr) {
            current = current->next;
        }       

        current->next = new GradeNode();
        current->next->grade = newGrade; 
    }
}
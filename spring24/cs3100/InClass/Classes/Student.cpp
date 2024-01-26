#include "Student.h"

    // Parameterized constructor
    Student::Student(string newLastName, string newFirstName, int newUid) : lastName(newLastName), firstName(newFirstName) {
        setUid(newUid);
        gradeList = nullptr;
    }

    // Default constructor
    Student::Student() {
        lastName = "invalid";
        firstName = "invalid";
        uid = 0;
        gradeList = nullptr;
    }

    void Student::setLastName(string newLastName) {
        this->lastName = newLastName;
    }

    string Student::getLastName() {
        return lastName;
    }
    void Student::print(ostream& os) {
        os << lastName << ", " << firstName;
        os << " (U" << setw(8) << setfill('0') << uid << ")" << endl;
    }

    int Student::getUid() {
        return uid;
    }

    void Student::setUid(int newUid) {
        if ((newUid <= 0) || (newUid > MAX_UID)) {
            throw invalid_argument("Invalid UID");
        }

        uid = newUid;
    }

    void Student::addGrade(char newGrade) {
        gradeList = new GradeNode();
        gradeList->grade = newGrade;
    }
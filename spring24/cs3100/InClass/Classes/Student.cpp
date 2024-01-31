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

// Copy Constructor
Student::Student(const Student & copyMe) {
    lastName = copyMe.lastName;
    firstName = copyMe.firstName;
    uid = copyMe.uid;
    gradeList = nullptr;
    GradeNode * current = copyMe.gradeList;
    while (current != nullptr) {
        addGrade(current->grade);
        current = current->next;
    }
}

// Destructor
Student::~Student() {
    cout << "Calling destructor on student: U" << uid << endl;
    GradeNode * current = gradeList;
    while (current != nullptr) {
        GradeNode * killMeNext = current->next;
        cout << "Deleting grade: " << current->grade << endl;
        delete current;
        current = killMeNext;
    }
}

void Student::setLastName(string newLastName) {
    this->lastName = newLastName;
}

string Student::getLastName() {
    return lastName;
}
void Student::print(ostream& os) const {
    os << lastName << ", " << firstName;
    os << " (U" << setw(8) << setfill('0') << uid << ")" << endl;
    GradeNode * current = gradeList;
    while (current) {
        os << current->grade;
        current = current->next;
        if (current) {
            os << ", ";
        } else {
            os << endl;
        }
    }
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

bool Student::operator==(const Student & other) {
    if (uid == other.uid) {
        return true;
    } else {
        return false;
    }
}

char Student::operator[](unsigned int index) {
    GradeNode * current = gradeList;

    for (int i = 0; i < index; i++) {
        if (current == nullptr) {
            throw exception();
        }
        current = current->next;
    }

    if (current == nullptr) {
        throw exception();
    } else {
        return current->grade;
    }
}

void Student::operator=(const Student & copyMe) {
    // clean up the current student
    GradeNode * current = gradeList;
    while (current != nullptr) {
        GradeNode * killMe = current;
        current = current->next;        
        delete killMe;
    }

    lastName = copyMe.lastName;
        firstName = copyMe.firstName;
        uid = copyMe.uid;
        gradeList = nullptr;
        current = copyMe.gradeList;
        while (current != nullptr) {
            addGrade(current->grade);
            current = current->next;
        }
}

ostream & operator<<(ostream & os, const Student & me) {
    me.print(os);
    return os;
}
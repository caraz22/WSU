#include "Student.h"
#include <exception>
#include <stdexcept>

using namespace std;

Student::Student() {
    uid = -1;
    firstName = "invalid";
    lastName = "student";
}

Student::Student(int newUid, string newLastName, string newFirstname) {
    setUid(newUid);
    lastName = newLastName;
    firstName = newFirstname;
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
#include <iostream>
#include "Student.h"

using namespace std;

void testStudent(int);

int main() {
    Student s1(123, "Zozokos", "Cara");
    cout << s1.getUid() << endl;

    Student s2(234, "Raymer", "Mike");
    cout << s2.getUid() << endl;

    Student * p;
    p = new Student(456, "Doe", "John");
    cout << p->getUid() << endl; // Same as: cout << (*p).getUid() << endl;

    delete p;

    while(true) {
        testStudent(123);
    }
}

void testStudent(int uid) {
    Student * ptr;
    ptr = new Student(uid, "Test", "Student");
    delete ptr;
    // cout << "Created student with UID: " << ptr->getUid() << endl;
}
#include <iostream>
#include "Student.h"

using namespace std;

void foo(Student s);

int main() {
    Student s2("Jones", "Barbara", 1234);
    s2.addGrade('A');
    s2.addGrade('B');
    foo(s2);
}

void foo(Student s) {
    cout << "Printing thes student: " << endl;
    s.print(cout);
}
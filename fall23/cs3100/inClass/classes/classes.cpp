#include <iostream>
#include "Student.h"

using namespace std;

void foo();
void changeStudent(Student);

int main() {
    cout << "Ready" << endl;
    
    Student s1(123, "Zozokos", "Cara");
    s1.addGrade('A');
    s1.addGrade('A');
    s1.addGrade('B');
    s1.addGrade('C');

    changeStudent(s1);
    cout << "Back in main: " << endl;
    s1.print(cout);
}

void foo() {
    cout << "Ready" << endl;
    Student s1(123, "Zozokos", "Cara");
    s1.addGrade('A');
    s1.addGrade('A');
    s1.addGrade('B');
    s1.addGrade('C');
}

void changeStudent(Student theStudent) {
    theStudent.setLastName("Jones");
    cout << "In changeStudent: " << endl;
    theStudent.print(cout);
}
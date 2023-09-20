#include <iostream>
#include <iomanip>
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

    Student s2(123, "Smith", "Michael");
    
    if (s1 == s2) {
        cout << "They are the same!" << endl;
    } else {
        cout << "They are different!" << endl;
    }

    if (s1.operator==(s2)) {
        cout << "SAME" << endl;
    }
    
    changeStudent(s1);
    cout << "Back in main: " << endl;

    s1.print(cout);
    // cout << "GPA: " << setprecision(2) << fixed << s1.getGPA() << endl;

    cout << "Done" << endl;
    // string response;
    // cin >> response;
}

void foo() {
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
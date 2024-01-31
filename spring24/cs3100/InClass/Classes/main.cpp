#include <iostream>
#include "Student.h"

using namespace std;

void foo(Student s);

int main() {
    Student s1("Jones", "Barbara", 1234);
    Student s2("Zozokos", "Cara", 5586);

    // s2.addGrade('A');
    // s2.addGrade('B');
    // foo(s2);
    
    if (s1 == s2) {
        cout << "SAME!" << endl;
    } else {
        cout << "DIFFERENT!"<< endl;
    }
    
    s1.addGrade('A');
    s1.addGrade('B');
    s1.addGrade('C');
    char secondGrade = s1[1];
    cout << secondGrade << endl;

    s2 = s1;

    cout << s1 << endl;
}

void foo(Student s) {
    cout << "Printing the student: " << endl;
    s.print(cout);
}
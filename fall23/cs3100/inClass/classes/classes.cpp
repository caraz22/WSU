#include <iostream>
#include "Student.h"

using namespace std;

int main() {
    Student s1(123, "Zozokos", "Cara");
    s1.addGrade('A');
    s1.addGrade('A');
    s1.addGrade('B');
    s1.addGrade('C');
    
    s1.print(cout);

    // cout << "GPA: " << setprecision(2) << fixed << s1.getGPA() << endl;

    cout << "Done" << endl;
}
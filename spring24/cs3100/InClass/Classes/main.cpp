#include <iostream>
#include "Student.h"

using namespace std;

int main() {
    Student s("Zozokos", "Cara", 5586);
    s.addGrade('A');
    s.print(cout);

    Student * p = new Student("Jones", "Sally", 4566);
    (*p).print(cout);
    p->print(cout); // line 11 and 12 do the same thing

    GradeNode g;
}
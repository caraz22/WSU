#include <iostream>
#include "Student.h"

using namespace std;

int main() {
    Student s1(123, "Zozokos", "Cara");
    s1.addGrade('A');
    s1.print(cout);
    cout << "Done" << endl;
}
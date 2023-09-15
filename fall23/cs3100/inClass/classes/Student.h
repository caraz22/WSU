#include <string>
#include "GradeNode.h"

using namespace std;

#define MAX_UID 99999999

class Student {
    private:
    int uid;
    string lastName;
    string firstName;
    GradeNode* gradeList;

    // SetUid is a private setter
    // Can't change a student's UID once created
    void setUid(int);

    public:
    // Constructors
    // Default
    Student();

    // Parameterized
    Student(int, string, string);

    // Getters and setters
    int getUid();
    void setLastName(string);

    // Other methods
    void print(ostream&);
    void addGrade(char);
};
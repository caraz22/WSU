#include <iostream>
#include <string>
#include <iomanip>
#include "GradeNode.h"

using namespace std;

#define MAX_UID 99999999

class Student {
    private:
    string lastName;
    string firstName;
    int uid;
    GradeNode* gradeList;

    // Private setter
    // Can't change a student's UID once created
    void setUid(int);

    public:

    // Parameterized constructor
    Student(string,  string,  int);
    

    // Default constructor
    Student(); 

    // Destructor
    ~Student();

    // Accessors & mutators
    void setLastName(string newLastName);

    int getUid();

    string getLastName();

    void print(ostream&) const;

    void addGrade(char);

    bool operator==(const Student &);

    char operator[](unsigned int);

    void operator=(const Student &);

    friend ostream & operator<<(ostream &, const Student &);
};
#include <string>

using namespace std;

#define MAX_UID 99999999

class Student {
    private:
    int uid;
    string lastName;
    string firstName;

    void setUid(int);

    public:
    // Constructors
    Student();
    Student(int, string, string);

    // Getters and setters
    int getUid();
};
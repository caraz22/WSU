#pragma once
#include <iostream>
#include <string>

using namespace std;

class Student {
    private:
        string lastName;
        string firstName;
        int uid;

    public:

        // Parameterized constructor
        Student(string,  string,  int);
        

        // Default constructor
        Student(); 

        // Accessors & mutators
        void setLastName(string newLastName);

        string getLastName();

        void print();
};
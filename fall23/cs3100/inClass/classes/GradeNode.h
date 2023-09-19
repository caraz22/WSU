#include <map>

using namespace std;

class GradeNode {
    public:
    // Singleton design pattern  
    // Static const map<char, int> point_values; 
    char grade;
    GradeNode* next;

    // Default constructor
    GradeNode();

    // Get the GPA points for a grade
    // int getPoints();
};
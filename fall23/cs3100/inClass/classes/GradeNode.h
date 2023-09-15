using namespace std;

class GradeNode {
    public:
    char grade;
    GradeNode* next;

    // Default constructor
    GradeNode() {
        grade = 'N';
        next = nullptr;
    }
};
#include "GradeNode.h"

// Static member initializations
// const std::map<char, int> GradeNode::point_values = {
//      {'A', 4},
//      {'B', 3},
//      {'C', 2},
//      {'D', 1},
//      {'F', 0},
//      {'N', 0}
// };

GradeNode::GradeNode() {
    // Initialize the node
    grade = 'N';
    next = nullptr;
}

// int GradeNode::getPoints() {
//     return point_values.at(grade);
// }
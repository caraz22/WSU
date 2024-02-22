#include "Sequence.h"

// Function: Sequence -- parameterized constructor
// Inputs: sz -- the number of elements to create the sequence with (size_type, unsigned int)
// Side effects: a new sequence is created
Sequence::Sequence(size_type sz)
{
    // set the number of elements equal to the specified size
    numElts = sz;

    if (sz == 0){           // if the size is 0
        head = nullptr;     // set head and tail to null
        tail = nullptr;
        return;
    } else {
       head = new SequenceNode();   // otherwise, create a new node and set it equal to the head
       tail = head;                 // set tail equal to head (only one node would be the head and tail of the sequence)
    }

    for (size_type i = 0; i < sz - 1; i++){     // for each element less than sz
        tail->next = new SequenceNode();        // the new node will be what the tail is pointing to next
        tail->next->prev = tail;                
        tail = tail->next;                      // resetting tail to the newest node
    }
}

// Function: Sequence -- copy constructor
// Inputs: s -- sequence to be copied (const Sequence&)
// Side effects: a deep copy of sequence is created
Sequence::Sequence(const Sequence& s)
{
    head = nullptr;     // setting head to null
    numElts = 0;        // setting the number of elements to zero

    SequenceNode * current = s.head;    // creating pointer current and setting it equal to the head of sequence
    while (current != nullptr) {    // while current is not null
        push_back(current->elt);    // call push_back() to add element to the sequence
        current = current->next;    // point current to the next node
    }
}

// Function: ~Sequence -- destructor
// Side effects: destroys all items in the sequence and releases the memory associated with it
Sequence::~Sequence()
{
    clear();        // calling clear(), which frees up memory used by the nodes, just not automatically
}

// Function: operator= -- releasing and replacing
// Inputs: s -- sequence to be copied (const Sequence&)
// Returns: *this with elements from s copied into
// Side effects: the current sequence is released and replaced by a deep copy of sequence
Sequence& Sequence::operator=(const Sequence& s)
{
    SequenceNode * current = head;                  // creating pointer current and setting it equal to the he ad of sequence
    while (current != nullptr) {                    // while current is not null
        SequenceNode * deleteMe = current;          // creating pointer to be the current node to delete
        current = current->next;                    // point current to the next node
        delete deleteMe;                            // delete node
    }

    current = s.head;                   // setting current equal to the head of the sequence
    while (current != nullptr) {        // while current is not null
        push_back(current->elt);        // call push_back() to add element to the sequence
        current = current->next;        // point current to the next node
    }

    return *this;           // return the copied elements
}

// Function: operator[] -- sequence indexing 
// Inputs: position -- the position of item being accessed (size_type, unsigned int)
// Returns: reference to the item at index position in the sequence
// Side effects: the index of the specified position is returned
Sequence::value_type& Sequence::operator[](size_type position)
{
    SequenceNode * current = head;                  // setting current equal to the head of the sequence
    for (size_type i = 0; i < position; i++) {      // for each element less than position
        if (current == nullptr) {                   // if current is null
            throw exception();                      // thrown an exception
        }
        current = current->next;                    // point current to the next node
    }

    if (current == nullptr) {           // if current is null       
        throw exception();              // thrown an exception
    } else {                            
        return current->elt;            // otherwise, return the reference to the element
    }
}

// Function: push_back -- appending 
// Inputs: value -- item to be added (const value_type(int)&)
// Side effects: adds an item to the end of the sequence
void Sequence::push_back(const value_type& value)
{
    if (head == nullptr) {                  // if head is null
        head = new SequenceNode();          // create a new node at head
        head->elt = value;                  // set the value to the head's element
        head->next = nullptr;               // setting the following node to null
    } else {
        SequenceNode * current = head;              // setting current equal to the head of the sequence
        while (current->next != nullptr) {          // while the next node is not null
            current = current->next;                // point current to the next node
        }

        current->next = new SequenceNode();         // at the end of the sequence, create a new node
        current->next->elt = value;                 // set the value of the element
        current->next->next = nullptr;              // point the next next node to nullptr
    }
}

// Function: pop_back -- deletion
// Side effects: the item at the end of the sequence is deleted and the size of the sequence is reduced by one
void Sequence::pop_back()
{
    if (numElts == 0) {         // if the number of elements is zero
        throw exception();      // throw an exception (nothing to delete)
    } else {
        SequenceNode * current = head;          // setting current equal to the head of the sequence
        if (current->next == nullptr) {         // if the next node is null
            delete current;                     // delete the current node
            numElts--;                          // reduce the number of elements by one
            return;                             // end the function
        }

        while (current->next->next != nullptr) {        // while the next next node is not null
            current = current->next;                    // point current to the next node
        }

        delete current->next;           // delete the next node
        current->next = nullptr;        // set the pointer to the deleted node to null
        numElts--;                      // reduce the number of elements by one
    }
}

// Function: insert -- add at index
// Inputs: position -- the position to where the value will be inserted (size_type, unsigned int)
//         value -- the value being inserted
// Side effects: the value of item is inserted at position and the size of sequence is increased by one
void Sequence::insert(size_type position, value_type value)
{
    if (position > numElts) {           // if the position is less than the number of elements in the sequence
        throw exception();              // throw an exception
    }
    
    SequenceNode * newNode = new SequenceNode();        // create a pointer to a new node
    newNode->elt = value;                               // set the element of that node to the speicified value

    if (position == 0 || numElts == 0) {        // if the position is at 0 or the sequence is empty
        head = newNode;                         // set the new node as the head of the sequence
    } else {
        SequenceNode * current = head;          // setting current equal to the head of the sequence
        for (size_type i = 0; i < position - 1; i++) {      // for each element less than position
            if (current == nullptr) {                       // if the current node is null
                throw exception();                          // throw an exception
            }
            current = current->next;                        // point current to the next node
        }

        newNode->next = current->next;          // point the new node to the same spot as where current is pointing
        current->next = newNode;                // point current to the new node
    }

    numElts++;          // increase the number of elements by one
}

// Function: front -- first item
// Returns: a reference to the first element in the sequence
// Side effects: the first item in the sequence is returned
const Sequence::value_type& Sequence::front() const
{
    if (numElts <= 0) {         // if the sequence is empty
       throw exception();       // throw an exception
    } else {
        SequenceNode * current = head;      // setting current equal to the head of the sequence
        return current->elt;                // return the element at current
    }
}
    
// Function: back -- last item
// Returns: a reference to the alst element in the sequence
// Side effects: the last item in the sequence is returned
const Sequence::value_type& Sequence::back() const
{
    if (numElts <= 0) {         // if the sequence is empty
        throw exception();      // throw an exception
    } else {
        SequenceNode * current = head;              // setting current equal to the head of the sequence
        while (current->next != nullptr) {          // while the next node is not null
            current = current->next;                // point current to the next node
        }

        return current->elt;        // return the element at that node
    }
}

// Funtion: empty -- sequence empty, true or false?
// Returns: true or false, true being the sequence is empty, false being the sequence has at least one element
// Side effects: whether or not the sequence is empty is returned
bool Sequence::empty() const
{
    if (numElts == 0) {     // if the sequence is empty
        return true;        // return true (1)
    } else {                // if the sequence is not empty
        return false;       // return false (0)
    }
}

// Function: size -- number of elements
// Returns: numElts -- the number of elements in the sequence (size_type, unsigned int)
// Side effects: the size of the sequence is returned
Sequence::size_type Sequence::size() const
{
    return numElts;     // return the size of the sequence
}

// Function: clear -- delete items and release their memory
// Side effects: All items in the sequence are deleted, and their associated memory is released
void Sequence::clear()
{
    if (numElts == 0) {         // if the sequence is empty
        return;                 // end the function
    }

    SequenceNode * current = head;          // setting current equal to the head of the sequence
    while (current != nullptr) {
        SequenceNode * deleteMeNext = current->next;        // create new node and set it equal to the next node
        delete current;                     // delete the current node
        current = deleteMeNext;             // set current equal to the next node to be deleted
    }
    head = tail = nullptr;      // set head and tail to null since the sequence will be empty
    numElts = 0;                // set the number of elements to zero
}

// Function: erase -- deleting items at index
// Inputs: position -- the position to start removing items from (size_type, unsigned int)
//         count -- the number of elements to remove (size_type, unsigned int)
// Side effects: items are deleted starting at the specified position, the number of items deleted are specified by count
void Sequence::erase(size_type position, size_type count)
{
    if ((position + count - 1) > numElts || numElts == 0) {     // if there are positions to be deleted that do not exist, or if the sequence is empty
        throw exception();                                      // throw an exception
    }

    if (position == 0) {                                // if the position is zero
        for (size_type i = 0; i < count; i++) {         // for each element less than count
            if (head == nullptr) {                      // if head is null
                throw exception();                      // throw an exception
            }
            SequenceNode * nextNode = head->next;       // create a new node for where the head is pointing to next
            nextNode = head->next;                      // set the new node as that node where head is pointing
            delete head;                                // delete the head node
            head = nextNode;                            // set the head as the node following the deleted node
            numElts--;                                  // reduce the number of elements in the sequence by one
        }
        return;
    }

    SequenceNode * current = head;                      // setting current equal to the head of the sequence
    for (size_type i = 0; i < position - 1; i++) {      // for each element less than position - 1
        if (current == nullptr) {                       // if current is null
            throw exception();                          // throw exception
        }
        current = current->next;                        // point current to the next node
    }

    for (size_type i = 0; i < count; i++) {             // for each element less than count
        SequenceNode * nextNode = current->next;        // create a new node for where current is pointing to next
        if (nextNode == nullptr) {                      // if the node is now null
            throw exception();                          // throw an excpetion
        }
        current->next = nextNode->next;                 // current now points to where the new node points
        delete nextNode;                                // delete the new node
        numElts--;                                      // decrease number of elements by one
        if (current->next == nullptr) {                 // if the next element is null
            tail = current;                             // set tail to the current element
        }
    }
}

// Place code for print sequence here (well not here, inside the method)
void Sequence::print(ostream& os) const
{
    SequenceNode * current = head;
    while (current != nullptr) {
        os << current->elt << " ";
        current = current->next;        
    }
}

// Don't modify, do the output in the print method
ostream& operator<<(ostream& os, const Sequence& s)
{
    s.print(os);
    return os;
}


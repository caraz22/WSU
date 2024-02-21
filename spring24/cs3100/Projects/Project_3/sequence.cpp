#include "Sequence.h"

Sequence::Sequence(size_type sz)
{
    numElts = sz;

    if (sz == 0){
        head = nullptr;
        tail = nullptr;
    } else {
       head = new SequenceNode();
       tail = head; 
    }

    for (int i = 0; i < sz - 1; i++){
        tail->next = new SequenceNode();
        tail->next->prev = tail;
        tail = tail->next;
    }
}

Sequence::Sequence(const Sequence& s)
{
    SequenceNode * current = s.head;
    while (current != nullptr) {
        push_back(current->elt);
        current = current->next;
    }
}

Sequence::~Sequence()
{
    SequenceNode * current = head;
    while (current != nullptr) {
        SequenceNode * deleteMeNext = current->next;
        delete current;
        current = deleteMeNext;
    }
}

Sequence& Sequence::operator=(const Sequence& s)
{
    SequenceNode * current = head;
    while (current != nullptr) {
        SequenceNode * deleteMe = current;
        current = current->next;
        delete deleteMe;
    }

    current = s.head;
    while (current != nullptr) {
        push_back(current->elt);
        current = current->next;
    }

    return *this;
}

Sequence::value_type& Sequence::operator[](size_type position)
{
    SequenceNode * current = head;
    for (int i = 0; i < position; i++) {
        if (current == nullptr) {
            throw exception();
        }
        current = current->next;
    }

    if (current == nullptr) {
        throw exception();
    } else {
        return current->elt;
    }
}

void Sequence::push_back(const value_type& value)
{
    if (head == nullptr) {
        head = new SequenceNode();
        head->elt = value;
    } else {
        SequenceNode * current = head;
        while (current->next != nullptr) {
            current = current->next;
        }

        current->next = new SequenceNode();
        current->next->elt = value;
    }
}

void Sequence::pop_back()
{
    if (numElts == 0) {
        throw exception();    
    } else {
        SequenceNode * current = head;
        while(current->next != nullptr) {
            current = current->next;
        }

        delete current;
        numElts--;
    }
}

void Sequence::insert(size_type position, value_type value)
{
    if (position < 0 || position > numElts) {
        throw exception();
    }
    
    SequenceNode * newNode = new SequenceNode();
    newNode->elt = value;

    if (position == 0 || numElts == 0) {
        head = newNode;
    } else {
        SequenceNode * current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current == nullptr) {
                throw exception();
            }
            current = current->next;
        }

        newNode->next = current->next;
        current->next = newNode;     
    }

    numElts++;
}

const Sequence::value_type& Sequence::front() const
{
    throw exception();
}

const Sequence::value_type& Sequence::back() const
{
    throw exception();
}

bool Sequence::empty() const
{
    return false;
}

Sequence::size_type Sequence::size() const
{
    return -1;
}

void Sequence::clear()
{

}

void Sequence::erase(size_type position, size_type count)
{
    throw exception();
}

// Place code for printing sequence here (well not here, inside the method)
void Sequence::print(ostream& os) const
{
    SequenceNode * current = head;
    while (current != nullptr) {
        os << current->elt << " ";
        current = current->next;        
    }
}

// Don't modify, do the output in the print() method
ostream& operator<<(ostream& os, const Sequence& s)
{
    s.print(os);
    return os;
}


#include "Sequence.h"

Sequence::Sequence(size_type sz)
{
    if (sz == 0) {
        numElts = 0;
    } else {
        numElts = sz;
        SequenceNode * current = new SequenceNode();
        for (int i = 0; i < numElts; i++) {
            current->next = new SequenceNode();
            current = current->next;
        }
    }
}

Sequence::Sequence(const Sequence& s)
{

}

Sequence::~Sequence()
{

}

Sequence& Sequence::operator=(const Sequence& s)
{
    return *this;
}

Sequence::value_type& Sequence::operator[](size_type position)
{
    throw exception();
}

void Sequence::push_back(const value_type& value)
{
}

void Sequence::pop_back()
{
    throw exception();
}

void Sequence::insert(size_type position, value_type value)
{
    throw exception();
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

}

// Don't modify, do the output in the print() method
ostream& operator<<(ostream& os, const Sequence& s)
{
    s.print(os);
    return os;
}


#include <review/m10/Employee.h>

using namespace m10;
using namespace std;

Employee::Employee(
        const unsigned& id,
        const string& name,
        const string& position,
        const float& rate) :
    _id(id),
    _name(name),
    _position(position),
    _rate(rate)
{
}

string Employee::getName()
{
    return _name;
}

bool Employee::isManager()
{
    return _position == "manager";
}

float Employee::getRate()
{
    return _rate;
}

string Employee::toString()
{
    return "id=" + to_string(_id)
        + " name=" + _name
        + " position=" + _position
        + " rate=" + to_string(_rate);
}
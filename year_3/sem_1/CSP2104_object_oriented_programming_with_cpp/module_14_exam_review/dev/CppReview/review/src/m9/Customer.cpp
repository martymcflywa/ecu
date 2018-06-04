#include <review/m9/Customer.h>

using namespace m9;
using namespace std;

Customer::Customer(
        const string& first,
        const string& middle,
        const string& last,
        const double& balance,
        const double& limit,
        const string& phoneNumber) :
    _name(first, middle, last),
    _credit(balance, limit),
    _phoneNumber(phoneNumber)
{
}

string Customer::toString()
{
    return _name.toString() + '\n'
        + _phoneNumber + '\n'
        + _credit.toString();
}
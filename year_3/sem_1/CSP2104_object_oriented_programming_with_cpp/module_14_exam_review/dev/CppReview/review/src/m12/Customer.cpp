#include <review/m12/Customer.h>
#include <review/m12/Transaction.h>

using namespace m12;
using namespace std;

Customer::Customer(
        const unsigned& id,
        const string& first,
        const string& last,
        const float& balance) :
    _id(id),
    _first(first),
    _last(last),
    _balance(balance)
{
}

void Customer::apply(const Transaction& transaction)
{
    _balance += transaction._amount;
}

string Customer::toString()
{
    return string("Customer:")
        + "\nid=" + to_string(_id)
        + "\nfirst=" + _first
        + "\nlast=" + _last
        + "\nbalance=" + to_string(_balance);
}
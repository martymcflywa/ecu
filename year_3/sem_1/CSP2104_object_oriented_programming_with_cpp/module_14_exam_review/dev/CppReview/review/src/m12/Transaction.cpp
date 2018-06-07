#include <review/m12/Transaction.h>

using namespace m12;
using namespace std;

Transaction::Transaction(const unsigned& id, const float& amount) :
        _id(id),
        _amount(amount)
{
}

string Transaction::toString()
{
    return string("Transaction:")
        + "\nid=" + to_string(_id)
        + "\namount=" + to_string(_amount);
}
#include <review/m9/Credit.h>

using namespace m9;
using namespace std;

Credit::Credit(const double& balance, const double& limit)
{
    _balance = balance;

    if (limit < balance)
    {
        _limit = balance;
        return;
    }
    _limit = limit;
}

string Credit::toString()
{
    auto available = _limit - _balance;

    return "balance=$" + to_string(_balance) + '\n'
        + "limit=$" + to_string(_limit) + '\n'
        + "available=$" + to_string(available);
}
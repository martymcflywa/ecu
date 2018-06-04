#include <review/m9/Name.h>

using namespace m9;
using namespace std;

Name::Name(
        const string& first,
        const string& middle,
        const string& last) :
    _first(first),
    _middle(middle),
    _last(last)
{
}

string Name::toString()
{
    return _first + ' '
        + _middle + ' '
        + _last;
}
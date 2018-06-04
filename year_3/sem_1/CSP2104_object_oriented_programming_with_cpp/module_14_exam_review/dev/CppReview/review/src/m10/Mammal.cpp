#include <review/m10/Mammal.h>

using namespace m10;
using namespace std;

Mammal::Mammal(
        const unsigned& legs,
        const bool& hasTail,
        const bool& isMale,
        const string& furColor,
        const string& eyeColor) :
    _legs(legs),
    _hasTail(hasTail),
    _isMale(isMale),
    _furColor(furColor),
    _eyeColor(eyeColor)
{
}

string Mammal::toString()
{
    return "This mammal walks on " + to_string(_legs)
        + " legs and has " + (_hasTail ? "a " : "no ")
        + "tail. It has " + _furColor + " fur and "
        + _eyeColor + " eyes.";
}
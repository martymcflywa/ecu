#include <review/m10/Lion.h>

using namespace m10;
using namespace std;

Lion::Lion(
        const unsigned& legs,
        const bool& hasTail,
        const bool& isMale,
        const std::string& furColor,
        const std::string& eyeColor) :
    Mammal(legs, hasTail, isMale, furColor, eyeColor),
    _hasMane(isMale)
{
}

string Lion::toString()
{
    return "This lion is a mammal that walks on " + to_string(_legs)
        + " legs and has " + (_hasTail ? "a " : "no ")
        + "tail. It is a " + (_isMale ? "male " : "female ")
        + "with " + (_hasMane ? "a mane of " : "")
        + _furColor + " fur and " + _eyeColor + " eyes.";
}
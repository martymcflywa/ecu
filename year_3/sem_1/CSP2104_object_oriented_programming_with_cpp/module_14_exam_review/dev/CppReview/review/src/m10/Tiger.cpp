#include <review/m10/Tiger.h>

using namespace m10;
using namespace std;

Tiger::Tiger(
        const unsigned& legs,
        const bool& hasTail,
        const bool& isMale,
        const std::string& furColor,
        const std::string& eyeColor) :
    Mammal(legs, hasTail, isMale, furColor, eyeColor)
{
}

string Tiger::toString()
{
    return "This tiger is a mammal that walks on " + to_string(_legs)
        + " legs. It is a " + (_isMale ? "male " : "female ")
        + "and has " + _furColor + " fur, which means it has "
        + (_furColor == "white" ? GREY : BROWN);
}
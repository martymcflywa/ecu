#include <review/m10/Liger.h>

using namespace m10;
using namespace std;

Liger::Liger(
        const unsigned& legs,
        const bool& hasTail,
        const bool& isMale,
        const std::string& furColor,
        const std::string& eyeColor) :
    Tiger(legs, hasTail, isMale, furColor, eyeColor),
    Lion(legs, hasTail, isMale, furColor, eyeColor)
{
}

string Liger::toString()
{
    return "This liger is a mammal that walks on " + to_string(Tiger::_legs)
        + " legs and has " + (Tiger::_hasTail ? "a " : "no ")
        + "tail. It is a " + (Tiger::_isMale ? "male " : "female ")
        + "with " + (Lion::_hasMane ? "a mane of " : "")
        + Tiger::_furColor + " fur, which means it has "
        + (Tiger::_furColor == "white" ? GREY : BROWN);
}
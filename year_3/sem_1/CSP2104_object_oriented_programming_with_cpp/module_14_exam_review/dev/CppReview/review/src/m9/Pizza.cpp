#include <review/m9/Pizza.h>

using namespace m9;
using namespace std;

const string Pizza::DEFAULT_TYPE = "standard";
const string Pizza::DEFAULT_TOPPING = "cheese";
const unsigned Pizza::DEFAULT_SIZE = 12;
const double Pizza::DEFAULT_PRICE = 8.99;

Pizza::Pizza(
        const string& type,
        const string& topping,
        const unsigned& size,
        const double& price) :
    _type(type),
    _topping(topping),
    _size(size),
    _price(price)
{
}

Pizza::Pizza(
        const string& type,
        const string& topping) :
    _type(type),
    _topping(topping),
    _size(DEFAULT_SIZE),
    _price(DEFAULT_PRICE)
{
}

Pizza::Pizza(
        const string& type, 
        const string& topping, 
        const unsigned& size) :
    _type(type),
    _topping(topping),
    _size(size),
    _price(DEFAULT_PRICE)
{
}

Pizza::Pizza() :
        _type(DEFAULT_TYPE),
        _topping(DEFAULT_TOPPING),
        _size(DEFAULT_SIZE),
        _price(DEFAULT_PRICE)
{
}

string Pizza::toString()
{
    return _type + " pizza:"
        + " topping=" + _topping
        + " size=" + to_string(_size)
        + " price=" + to_string(_price);
}
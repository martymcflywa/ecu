#include <review/m12/SalesOffice.h>

using namespace m12;
using namespace std;

SalesOffice::SalesOffice(const string& name, const double& sales) :
    _name(name), _sales(sales)
{
}

string SalesOffice::compare(SalesOffice& that)
{
    return "The " + _name + " office has "
        + to_string(*this / that) 
        + "% of the sales compared to the "
        + that._name + " office.";
}

double SalesOffice::operator/(SalesOffice& that)
{
    return _sales / that._sales * 100;
}
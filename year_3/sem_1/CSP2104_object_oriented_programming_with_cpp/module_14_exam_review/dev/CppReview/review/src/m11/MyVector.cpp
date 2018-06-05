#include <review/m11/MyVector.h>
#include <review/m11/RequestedException.h>

using namespace m11;
using namespace std;

// have to declare possible instances here
// otherwise put implementation in *.h
template class MyVector<int>;
template class MyVector<double>;
template class MyVector<float>;

template <class T>
MyVector<T>::MyVector(T x, T y, T z, bool doThrow) :
        _x(x), _y(y), _z(z), _doThrow(doThrow)
{
}

template <class T>
string MyVector<T>::toString()
{
    return "x=" + to_string(_x)
        + " y=" + to_string(_y)
        + " z=" + to_string(_z)
        + " doThrow=" + to_string(_doThrow);
}

template <class T>
MyVector<T> MyVector<T>::operator+(MyVector<T> that)
{
    auto x = _x + that._x;
    auto y = _y + that._y;
    auto z = _z + that._z;
    auto doThrow = _doThrow | that._doThrow;
    return { x, y, z, doThrow };
}

template <typename T>
bool MyVector<T>::throwMe()
{
    if (_doThrow)
        throw RequestedException("You asked for it");
    
    return _doThrow;
}
#pragma once

#include <review/m11/RequestedException.h>
#include <string>

namespace m11
{
    template <class T>
    class MyVector
    {
        T _x;
        T _y;
        T _z;
        bool _doThrow;
    public:
        MyVector(T x, T y, T z, bool doThrow);
        std::string toString();
        MyVector operator+(MyVector that);
        bool throwMe();
    };
}
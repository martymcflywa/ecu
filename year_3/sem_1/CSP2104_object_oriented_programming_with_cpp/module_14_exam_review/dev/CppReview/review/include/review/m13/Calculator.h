#pragma once

#include <type_traits>

namespace m13
{
    class Calculator
    {
    public:
        // second template param ensures T is a number
        template <typename T,
                typename = typename std::enable_if<std::is_arithmetic<T>::value, T>::type>
        static T add(T a, T b)
        {
            return a + b;
        }
        template <typename T,
                typename = typename std::enable_if<std::is_arithmetic<T>::value, T>::type>
        static T multiply(T a, T b)
        {
            return a * b;
        }
    };
}
#pragma once

#include <string>

namespace m10
{
    class Mammal
    {
    protected:
        unsigned _legs;
        bool _hasTail;
        bool _isMale;
        std::string _furColor;
        std::string _eyeColor;
    public:
        Mammal(
            const unsigned& legs,
            const bool& hasTail,
            const bool& isMale,
            const std::string& furColor,
            const std::string& eyeColor);
        virtual std::string toString();
    };
}
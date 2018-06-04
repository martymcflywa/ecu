#pragma once

#include <review/m10/Mammal.h>
#include <string>

namespace m10
{
    class Lion : public Mammal
    {
    protected:
        bool _hasMane;
    public:
        Lion(
            const unsigned& legs,
            const bool& hasTail,
            const bool& isMale,
            const std::string& furColor,
            const std::string& eyeColor);
        std::string toString() override;
    };
}
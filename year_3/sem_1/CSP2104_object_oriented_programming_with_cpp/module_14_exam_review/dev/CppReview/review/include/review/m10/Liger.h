#pragma once

#include <review/m10/Mammal.h>
#include <review/m10/Lion.h>
#include <review/m10/Tiger.h>
#include <string>

namespace m10
{
    class Liger : public Lion, public Tiger
    {
    public:
        Liger(
            const unsigned& legs,
            const bool& hasTail,
            const bool& isMale,
            const std::string& furColor,
            const std::string& eyeColor);
        std::string toString() override;
    };
}
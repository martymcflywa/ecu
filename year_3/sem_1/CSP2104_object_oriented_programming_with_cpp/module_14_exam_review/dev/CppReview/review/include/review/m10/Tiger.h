#pragma once

#include <review/m10/Mammal.h>
#include <string>

namespace m10
{
    class Tiger : public Mammal
    {
    protected:
        const std::string GREY = "grey stripes.";
        const std::string BROWN = "brown stripes.";
    public:
        Tiger(
            const unsigned& legs,
            const bool& hasTail,
            const bool& isMale,
            const std::string& furColor,
            const std::string& eyeColor);
        std::string toString() override;
    };
}
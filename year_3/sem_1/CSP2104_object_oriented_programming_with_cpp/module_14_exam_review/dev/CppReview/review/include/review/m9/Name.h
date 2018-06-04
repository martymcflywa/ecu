#pragma once

#include <string>

namespace m9
{
    class Name
    {
        std::string _first;
        std::string _middle;
        std::string _last;
    public:
        Name(
            const std::string& first,
            const std::string& middle,
            const std::string& last);
        std::string toString();
    };
}
#pragma once

#include <string>

namespace m9
{
    class Credit
    {
        double _balance;
        double _limit;
    public:
        Credit(
            const double& balance, 
            const double& limit = 0.0);
        std::string toString();
    };
}
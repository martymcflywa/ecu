#pragma once

#include <review/m9/Name.h>
#include <review/m9/Credit.h>
#include <string>

namespace m9
{
    class Customer
    {
        Name _name;
        Credit _credit;
        std::string _phoneNumber;
    public:
        Customer(
            const std::string& first,
            const std::string& middle,
            const std::string& last,
            const double& balance,
            const double& max,
            const std::string& phoneNumber);
        std::string toString();
    };
}
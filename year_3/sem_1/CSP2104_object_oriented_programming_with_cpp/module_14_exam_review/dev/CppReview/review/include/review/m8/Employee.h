#pragma once

#include <string>

namespace m8
{
    class Employee
    {
        unsigned _id;
        std::string _name;
        std::string _position;
        float _rate;
    public:
        Employee(
            const unsigned& id,
            const std::string& name,
            const std::string& position,
            const float& rate);
        std::string getName();
        bool isManager();
        float getRate();
        std::string toString();
    };
}
#pragma once

#include <string>

namespace m10
{
    class Employee
    {
    protected:
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
        virtual bool isManager();
        float getRate();
        std::string toString();
    };
}
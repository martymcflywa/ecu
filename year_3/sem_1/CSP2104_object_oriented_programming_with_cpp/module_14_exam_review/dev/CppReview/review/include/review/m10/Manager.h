#pragma once

#include <review/m10/Employee.h>
#include <string>

namespace m10
{
    class Manager : public Employee
    {
    public:
        Manager(
            const unsigned& id,
            const std::string& name,
            const std::string& position,
            const float& rate);
        bool isManager() override;
    };
}
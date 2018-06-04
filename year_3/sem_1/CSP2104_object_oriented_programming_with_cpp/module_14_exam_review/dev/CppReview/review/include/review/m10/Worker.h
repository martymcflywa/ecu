#pragma once

#include <review/m10/Employee.h>

namespace m10
{
    class Worker : public Employee
    {
    public:
        Worker(
            const unsigned& id,
            const std::string& name,
            const std::string& position,
            const float& rate);
        bool isManager() override;
    };
}
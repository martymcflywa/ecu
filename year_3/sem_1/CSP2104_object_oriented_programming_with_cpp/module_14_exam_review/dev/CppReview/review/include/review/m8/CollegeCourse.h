#pragma once

#include <util/Cli.h>
#include <string>

namespace m8
{
    class CollegeCourse
    {
        unsigned _id;
        std::string _department;
        unsigned _seats;
    public:
        CollegeCourse();
        void setId(unsigned id);
        void setDepartment(const std::string& department);
        void setSeats(unsigned seats);
        std::string toString();
    };
} 
#pragma once

#include <review/m8/Employee.h>
#include <util/Cli.h>
#include <util/Reader.h>
#include <string>
#include <vector>

namespace m8
{
    class HrSystem
    {
        util::Cli _cli;
        util::Reader _reader;
        std::vector<Employee> _employees;
    public:
        HrSystem(util::Cli& cli, util::Reader& reader);
        void run();
    private:
        std::vector<Employee> load();
        std::string menu();
        void rateQuery();
        std::string allToString();
        std::string managersToString();
        std::string workersToString();
        bool isValid(const std::string& selection);
        bool isFound(const std::vector<Employee>::iterator& it);
    };
}
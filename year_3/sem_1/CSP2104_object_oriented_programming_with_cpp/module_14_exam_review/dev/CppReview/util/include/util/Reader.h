#pragma once

#include <util/Cli.h>
#include <fstream>
#include <string>

namespace util
{
    class Reader
    {
        Cli _cli;
    public:
        Reader(Cli& cli);
        std::string getFilepath();
        void read(std::ifstream& file);
    private:
        void read(const std::string& filepath, std::ifstream& file);
        std::string trim(const std::string& str);
    };
}
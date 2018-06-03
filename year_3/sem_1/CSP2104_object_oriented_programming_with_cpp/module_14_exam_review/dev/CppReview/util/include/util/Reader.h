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
        void read(std::ifstream& file);
    private:
        std::string getFilepath();
        void read(const std::string& filepath, std::ifstream& file);
    };
}
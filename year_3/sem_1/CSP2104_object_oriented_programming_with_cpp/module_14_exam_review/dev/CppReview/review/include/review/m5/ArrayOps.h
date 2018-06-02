#pragma once

#include <util/Cli.h>
#include <array>

namespace m5
{
    class ArrayOps
    {
        Cli _cli;
        std::array<unsigned, 7> _a = {1, 2, 3, 4, 3, 2, 1};
    public:
        ArrayOps(Cli& cli);
        void run();
    private:
        void print();
        unsigned sum();
        unsigned occurrence(const unsigned& target);
        void replace();
        void shiftRight();
    };
}
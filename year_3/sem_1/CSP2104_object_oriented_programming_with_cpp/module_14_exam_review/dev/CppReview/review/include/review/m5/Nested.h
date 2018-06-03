#pragma once

#include <util/Cli.h>

namespace m5
{
    struct Matrix
    {
        unsigned col[10];
        unsigned row[10];
    };

    class Nested
    {
        util::Cli _cli;
    public:
        Nested(util::Cli& cli);
        void getMatrix();
    };
}
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
        Cli _cli;
    public:
        Nested(Cli& cli);
        void getMatrix();
    };
}
#pragma once

#include <util/Cli.h>
#include <util/Reader.h>
#include <string>

namespace m7
{
    struct Vector3
    {
        double x;
        double y;
        double z;

    public:
        std::string toString()
        {
            return "x=" + std::to_string(x)
                + " y=" + std::to_string(y)
                + " z=" + std::to_string(z);
        }
    };

    class Functions
    {
        util::Cli _cli;
        util::Reader _reader;
    public:
        Functions(util::Cli& cli, util::Reader& reader);
        void compute();
        void setVector();
        void initFileIo();
    private:
        float compute(float a, float* b, float& c);
        void setVector(Vector3& v, double x, double y, double z);
        std::string read();
        void write();
        int menuSelect();
    };
}
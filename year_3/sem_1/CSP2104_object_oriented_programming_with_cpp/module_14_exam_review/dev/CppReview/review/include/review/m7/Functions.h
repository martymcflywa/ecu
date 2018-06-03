#pragma once

#include <util/Cli.h>
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
    public:
        Functions(util::Cli& cli);
        void compute();
        void setVector();
        void initFileIo();
    private:
        float compute(float a, float* b, float& c);
        void setVector(Vector3& v, double x, double y, double z);
        std::string read(const std::string& filename);
        void write(const std::string& filename);
        int menuSelect();
        std::string getFilename();
    };
}
#include <review/m5/Nested.h>

using namespace m5;
using namespace util;
using namespace std;

Nested::Nested(Cli& cli) : _cli(cli)
{
}

void Nested::getMatrix()
{
    Matrix matrix;
    _cli.print("This is a simple example of nested loops, which generate a 2x2 matrix");

    for (auto i = 0; i < 10; ++i) 
    {
        matrix.col[i] = i;
        _cli.print("Iteration i = " + to_string(i));
        for (auto j = 0; j < 10; ++j) 
        {
            matrix.row[j] = j;
            _cli.print("Iteration j = " + to_string(j)
                + ", " + to_string(matrix.col[i])
                + ", " + to_string(matrix.row[j]));
        }
    }
}
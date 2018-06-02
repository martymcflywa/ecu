#include <review/m5/ArrayOps.h>

using namespace m5;
using namespace std;

ArrayOps::ArrayOps(Cli& cli) : _cli(cli)
{
}

void ArrayOps::run()
{
    _cli.print("Original");
    print();

    _cli.print(string("Sum: " 
        + to_string(sum())));

    _cli.print(string("Occurrence of '3': ") 
        + to_string(occurrence(3)));
    
    _cli.print(string("Replace elements greater than 2 with 0"));
    replace();
    print();

    _cli.print(string("Shift right"));
    shiftRight();
    print();
}

void ArrayOps::print()
{
    string out = "";

    for (const auto& i : _a)
        out += string("[") + to_string(i) + "] ";
    
    _cli.print(out);
}

unsigned ArrayOps::sum()
{
    unsigned sum;

    for (const auto& i : _a)
        sum += i;
    
    return sum;
}

unsigned ArrayOps::occurrence(const unsigned& target)
{
    auto found = 0;

    for (const auto& i : _a)
        if (i == target)
            found++;
    
    return found;
}

void ArrayOps::replace()
{
    for (auto i = 0; i < _a.size(); ++i)
        if (_a[i] > 2)
            _a[i] = 0;
}

void ArrayOps::shiftRight()
{
    array<unsigned, 7> shifted;
    const auto last = _a[_a.size() - 1];

    for (int i = _a.size() - 2; i >= 0; --i)
        shifted[i + 1] = _a[i];

    shifted[0] = last;
    _a = shifted;
}
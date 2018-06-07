#include <util/Reader.h>
#include <iostream>

using namespace util;
using namespace std;

Reader::Reader(Cli& cli) : _cli(cli)
{
}

void Reader::read(ifstream& file)
{
    auto filepath = getFilepath();
    read(filepath, file);
}

string Reader::getFilepath()
{
    return trim(_cli.get("Enter path to file"));
}

void Reader::read(const string& filepath, ifstream& file)
{
    _cli.print("Reading " + filepath);
    file.open(filepath);

    if (!file.is_open())
    {
        _cli.print("Unable to open " + filepath);
        exit(1);
    }
}

string Reader::trim(const string& str)
{
    unsigned first = str.find_first_not_of(' ');
    unsigned last = str.find_last_not_of(' ');
    return str.substr(first, (last - first + 1));
}
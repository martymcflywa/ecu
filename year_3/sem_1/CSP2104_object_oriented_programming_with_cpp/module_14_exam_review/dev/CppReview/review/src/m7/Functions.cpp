#include <review/m7/Functions.h>
#include <fstream>

using namespace m7;
using namespace util;
using namespace std;

Functions::Functions(Cli& cli) : _cli(cli)
{
}

void Functions::compute()
{
    auto x = 8.f;
    auto y = 4.f;
    auto z = 0.f;
    auto w = compute(x, &y, z);
    _cli.print(string("Functions::compute =")
        + " x=" + to_string(x)
        + " y=" + to_string(y)
        + " z=" + to_string(z)
        + " w=" + to_string(w));
}

void Functions::setVector()
{
    Vector3 v;
    setVector(v, 1.0, 4.0, 5.0);
    _cli.print("Functions::setVector = " + v.toString());
}

float Functions::compute(float a, float* b, float& c)
{
    a += 2;
    (*b)--;
    c++;
    return a + *b + c;
}

void Functions::setVector(Vector3& v, double x, double y, double z)
{
    v.x = x;
    v.y = y;
    v.z = z;
}

void Functions::initFileIo()
{
    auto selection = menuSelect();
    auto filename = getFilename();

    if (selection == 1)
    {
        read(filename);
        return;
    }
    
    if (selection == 2)
    {
        write(filename);
        return;
    }
}

string Functions::read(const string& filename)
{
    _cli.print("Read mode");
    auto file = ifstream(filename);

    if (!file.is_open())
    {
        _cli.print("Unable to open file");
        exit(1);
    }

    string record;
    auto line = 0L;

    while (!file.eof())
    {
        getline(file, record);
        _cli.print(string("Line ") + to_string(line) + ": " + record);
        ++line;
    }

    file.close();
    return record;
}

void Functions::write(const string& filename)
{
    _cli.print("Write mode");
    auto file = ofstream(filename, ios::app);

    if (!file.is_open())
    {
        _cli.print("Unable to open file");
        exit(1);
    }

    file << "Write 1\n";
    file << "Write 2\n";
    file << "Write 3\n";
    file.close();
}

int Functions::menuSelect()
{
    const string title = "Select an [item] from the menu:";
    const string menu = "[1] Read file\n[2] Write file"; 

    _cli.print(title);
    auto selection = stoi(_cli.get(menu));

    while(selection != 1 && selection != 2)
    {
        _cli.print("Invalid selection, try again");
        selection = stoi(_cli.get(menu));
    }
    return selection;
}

string Functions::getFilename()
{
    return _cli.get("Enter fully qualified path to file");
}
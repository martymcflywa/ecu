#include <review/m10/HrSystem.h>
#include <review/m10/Manager.h>
#include <review/m10/Worker.h>

#include <algorithm>
#include <iterator>

using namespace m10;
using namespace util;
using namespace std;

HrSystem::HrSystem(Cli& cli, Reader& reader) :
    _cli(cli),
    _reader(reader)
{
}

void HrSystem::run()
{
    _employees = load();
    _cli.print("All employees:\n" + allToString());
    _cli.print("Managers:\n" + managersToString());
    _cli.print("Workers:\n" + workersToString());
    menu();
}

vector<Employee*> HrSystem::load()
{
    auto file = ifstream();
    _reader.read(file);

    auto employees = vector<Employee*>{};

    auto cursor = 0;
    string line;
    unsigned id;
    string name;
    string position;
    float rate;

    while (!file.eof())
    {
        getline(file, line);

        if (cursor == 0)
        {
            id = stoi(line);
            cursor++;
            continue;
        }

        if (cursor == 1)
        {
            name = line;
            cursor++;
            continue;
        }

        if (cursor == 2)
        {
            position = line;
            cursor++;
            continue;
        }

        rate = stof(line);

        if (position == "manager")
        {
            // new keyword so it remains in scope
            employees.push_back(new Manager(id, name, position, rate));
        }
        else
        {
            employees.push_back(new Worker(id, name, position, rate));
        }

        cursor = 0;
    }
    file.close();
    return employees;
}

string HrSystem::menu()
{
    _cli.print("WELCOME TO HR");
    _cli.print("Select an item from the menu");

    string selection;

    do
    {
        selection = _cli.get("[1] Rate query\n[2] Exit");

        if (selection == "1")
            rateQuery();

        if (selection == "2")
            exit(0);
    }
    while (!isValid(selection));

    return selection;
}

void HrSystem::rateQuery()
{
    _cli.print("RATE QUERY");
    
    auto it = vector<Employee*>::iterator();
    string name;

    do
    {
        name = _cli.get("Enter employee name");

        it = find_if(
            _employees.begin(),
            _employees.end(),
            [&name](Employee* e) 
            { 
                return e->getName() == name; 
            });
    }
    while (!isFound(it));

    _cli.print((*it)->toString());
}

string HrSystem::allToString()
{
    string out;
    for (const auto& e : _employees)
        out.append(e->toString() + '\n');

    return out; 
}

string HrSystem::managersToString()
{
    string out;
    for (const auto& e : _employees)
        if (e->isManager())
            out.append(e->toString() + '\n');
    
    return out;
}

string HrSystem::workersToString()
{
    string out;
    for (const auto& e : _employees)
        if (!e->isManager())
            out.append(e->toString() + '\n');
    
    return out;
}

bool HrSystem::isValid(const string& selection)
{
    auto isValid = selection == "1" || selection == "2";

    if (!isValid)
        _cli.print("Invalid input, try again");
    
    return isValid;
}

bool HrSystem::isFound(const vector<Employee*>::iterator& it)
{
    auto isFound = it != _employees.end();

    if (!isFound)
        _cli.print("Employee not found, try again");
    
    return isFound;
}
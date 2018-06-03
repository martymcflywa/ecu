#include <util/Cli.h>
#include <iostream>

using namespace util;
using namespace std;

std::string Cli::get(const string& message)
{
    string line;
    cout << message + ":\n";
    getline(cin, line);
    return line;
}

void Cli::print(const string& message)
{
    cout << message + '\n';
}

void Cli::beginModule(unsigned id, const string& subject)
{
    cout << string("\n*** ") 
        + "Module " + to_string(id) + ": "
        + subject + " ***\n";
}

void Cli::beginExercise(unsigned id)
{
    cout << "\n[Exercise " + to_string(id) + "]\n\n";
}
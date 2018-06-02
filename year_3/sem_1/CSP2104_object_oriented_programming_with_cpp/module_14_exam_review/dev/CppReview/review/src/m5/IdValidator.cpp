#include <review/m5/IdValidator.h>

using namespace m5;
using namespace std;

IdValidator::IdValidator(Cli& cli) : _cli(cli)
{
}

void IdValidator::validate()
{
    const string inputMessage = "Enter an id number between "
        + to_string(MIN_ID) + " and "
        + to_string(MAX_ID) + " inclusive";
    
    unsigned id;
    id = stoi(_cli.get(inputMessage));

    while (id < MIN_ID || id > MAX_ID)
    {
        _cli.print("Invalid id number");
        id = stoi(_cli.get(inputMessage));
    }

    string successMessage = "Thank you. Your valid id is " + to_string(id);
    _cli.print(successMessage);
}
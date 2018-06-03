#include <review/m5/SessionPlanner.h>

using namespace m5;
using namespace util;
using namespace std;

SessionPlanner::SessionPlanner(Cli& cli) : 
    _cli(cli)
{
}

void SessionPlanner::get()
{
    setId(_client);
    setSessions(_client);
    setDate(_client);

    _cli.print("Client #" + to_string(_client.id));
    printSession(1, _client.day, _client.month, _client.year);
    
    for (unsigned i = 2, nextMonth = _client.month, nextYear = _client.year;
            i <= _client.sessions;
            ++i)
    {
        nextMonth += 1;
        if (nextMonth > MAX_MONTHS)
        {
            nextMonth -= MAX_MONTHS;
            ++nextYear;
        }
        printSession(i, _client.day, nextMonth, nextYear);
    }
}

void SessionPlanner::setId(Client& client)
{
    const string inputMessage = "Enter an id number between "
        + to_string(MIN_ID) + " and "
        + to_string(MAX_ID) + " inclusive";
    
    client.id = stoi(_cli.get(inputMessage));

    while (client.id < MIN_ID || client.id > MAX_ID)
    {
        _cli.print("Invalid id number");
        client.id = stoi(_cli.get(inputMessage));
    }

    string successMessage = "Thank you. Your valid id is " 
        + to_string(client.id);

    _cli.print(successMessage);
}

void SessionPlanner::setSessions(Client& client)
{
    const string inputMessage = "Enter number of sessions";

    client.sessions = stoi(_cli.get(inputMessage));

    while (_client.sessions < 1 || _client.sessions > MAX_SESSIONS)
    {
        _cli.print("We guarantee no more than 4 sessions will be necessary");
        client.sessions = stoi(_cli.get(inputMessage));
    }
}

void SessionPlanner::setDate(Client& client)
{
    const string inputMessage = "Getting date of first session...";
    _cli.print(inputMessage);

    client.day = stoi(_cli.get("Enter day"));
    while (client.day < 1 || client.day > MAX_DAYS)
    {
        _cli.print("Enter a day between 1 and " + to_string(MAX_DAYS));
        client.day = stoi(_cli.get("Enter day"));
    }

    client.month = stoi(_cli.get("Enter month"));
    while (client.month < 1 || client.month > MAX_MONTHS)
    {
        _cli.print("Enter a month between 1 and " + to_string(MAX_MONTHS));
        client.month = stoi(_cli.get("Enter month"));
    }

    client.year = stoi(_cli.get("Enter year"));
    while (client.year < CURRENT_YEAR)
    {
        _cli.print("Enter a year at least " + to_string(CURRENT_YEAR));
        client.year = stoi(_cli.get("Enter year"));
    }
}

void SessionPlanner::printSession(
        unsigned session, 
        unsigned day, 
        unsigned month, 
        unsigned year)
{
    _cli.print(string("Session #") + to_string(session) + " is on: "
        + to_string(day) + '/' 
        + to_string(month) + '/'
        + to_string(year));
}
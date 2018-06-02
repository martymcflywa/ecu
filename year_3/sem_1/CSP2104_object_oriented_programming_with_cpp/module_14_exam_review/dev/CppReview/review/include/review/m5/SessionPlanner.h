#pragma once

#include <util/Cli.h>
#include <string>

namespace m5
{
    struct Client
    {
        unsigned id;
        unsigned sessions;
        unsigned day;
        unsigned month;
        unsigned year;
    };

    /**
     * \brief 4.2
     * Complete the following code, compile and run. 
     * On successful execution the program will output something similar to the 
     * following output example:
     * 
     * Enter an ID number between 1000 and 9999 inclusive: 22
     * Invalid ID number
     * Enter an ID number from 1000 through 9999: 2518
     * Enter number of sessions client needs: 12
     * We guarantee that no more than 4 will be necessary.
     * Please re-enter the number of sessions: 4
     * Enter the day of the first session: 7
     * Enter the month of the first session: 11
     * Enter the year of the first session: 2015
     *
     * Client #2518
     * First session is on the following day: 7/11/2015
     * Session #2 is on: 7/12/2015
     * Session #3 is on: 7/1/2016
     * Session #4 is on: 7/2/2016
     */
    class SessionPlanner
    {
        Cli _cli;
        Client _client;
        const unsigned MIN_ID = 1000;
        const unsigned MAX_ID = 9999;
        const unsigned MAX_SESSIONS = 4;
        const unsigned MAX_DAYS = 31;
        const unsigned MAX_MONTHS = 12;
        const unsigned CURRENT_YEAR = 2018;
    public:
        SessionPlanner(Cli& cli);
        void get();
    private:
        void setId(Client& client);
        void setSessions(Client& client);
        void setDate(Client& client);
        void printSession(
            unsigned session, 
            unsigned day, 
            unsigned month, 
            unsigned year);
    };
}
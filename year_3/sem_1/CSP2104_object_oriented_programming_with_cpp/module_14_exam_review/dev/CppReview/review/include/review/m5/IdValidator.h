#pragma once

#include <util/Cli.h>

namespace m5
{
    /**
     * \brief 4.1
     * Write a program which uses the loop outlined below to validate a user 
     * data entry. The input and output requirements are shown below. 
     * Get your tutors feedback once you have completed this.
     * 
     * Example code:
     * for (count = 2, 
     *          nextSessionMonth = aClient.firstSessionMonth, 
     *          nextSessionYear = aClient.firstSessionYear; 
     *          count <= aClient.numSessions; ++count) 
     * {
     *      nextSessionMonth += 1;
     *      if (nextSessionMonth > MONTHS_IN_YEAR) {
     *          nextSessionMonth -= MONTHS_IN_YEAR);
     *          ++nextSessionYear;
     *      }
     *      cout << “Session #” << count << “ is on: “ << aClient.firstSessionDay 
     *          << “/” << nextSessionMonth << “/” << nextSessionYear << endl;
     * }

     */
    class IdValidator
    {
        util::Cli _cli;
        const unsigned MIN_ID = 111;
        const unsigned MAX_ID = 999;
    public:
        IdValidator(util::Cli& cli);
        void validate();
    };
}
#pragma once

#include <util/Cli.h>
#include <mutex>
#include <string>

namespace m11
{
    class Async
    {
        static std::mutex _mx;
    public:
        static void increment(
            util::Cli& cli,
            int id,
            int& counter,
            int limit);
    };
}
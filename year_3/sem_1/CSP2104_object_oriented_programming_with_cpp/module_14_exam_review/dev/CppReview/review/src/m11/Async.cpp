#include <review/m11/Async.h>

using namespace m11;
using namespace util;
using namespace std;

mutex Async::_mx;

void Async::increment(
        Cli& cli,
        int id,
        int& counter,
        int limit)
{
    int tempTotal = 0;
    for (int i = 0; i < limit; i++)
    {
        tempTotal++;
    }
    lock_guard<mutex> block(_mx);
    counter += tempTotal;

    cli.print("thread=" + to_string(id) 
        + " finished counter=" + to_string(counter));
}
#include <review/m10/Worker.h>

using namespace m10;
using namespace std;

Worker::Worker(
        const unsigned& id,
        const string& name,
        const string& position,
        const float& rate) :
    Employee(id, name, position, rate)
{
}

bool Worker::isManager()
{
    return false;
}
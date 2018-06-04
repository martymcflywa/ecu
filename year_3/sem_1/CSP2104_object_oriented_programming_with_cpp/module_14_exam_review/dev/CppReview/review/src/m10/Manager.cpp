#include <review/m10/Manager.h>

using namespace m10;
using namespace std;

Manager::Manager(
        const unsigned& id,
        const string& name,
        const string& position,
        const float& rate) :
    Employee(id, name, position, rate)
{
}

bool Manager::isManager()
{
    return true;
}
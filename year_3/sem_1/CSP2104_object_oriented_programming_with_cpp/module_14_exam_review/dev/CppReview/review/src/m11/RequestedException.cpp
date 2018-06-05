#include <review/m11/RequestedException.h>

using namespace m11;
using namespace std;

RequestedException::RequestedException(const std::string& message) :
    domain_error(message)
{
}
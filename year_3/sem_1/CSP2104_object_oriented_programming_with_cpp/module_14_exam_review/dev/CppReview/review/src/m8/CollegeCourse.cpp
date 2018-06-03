#include <review/m8/CollegeCourse.h>

using namespace m8;
using namespace std;

CollegeCourse::CollegeCourse()
{
}

void CollegeCourse::setId(unsigned id)
{
    _id = id;
}

void CollegeCourse::setDepartment(const string& department)
{
    _department = department;
}

void CollegeCourse::setSeats(unsigned seats)
{
    _seats = seats;
}

string CollegeCourse::toString()
{
    return "courseId=" + to_string(_id)
        + " department=" + _department
        + " seats=" + to_string(_seats);
}
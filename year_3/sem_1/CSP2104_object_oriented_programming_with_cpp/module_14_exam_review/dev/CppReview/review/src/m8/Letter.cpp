#include <review/m8/Letter.h>

using namespace m8;
using namespace std;

// init static member!
int Letter::_count = 0;

Letter::Letter()
{
    _count++;
}

void Letter::setRecipient(const string& recipient)
{
    _recipient = recipient;
}

void Letter::setSubject(const string& subject)
{
    _subject = subject;
}

void Letter::setContent(const string& content)
{
    _content = content;
}

void Letter::setSender(const string& sender)
{
    _sender = sender;
}

string Letter::toString()
{
    return "To " + _recipient + ",\n"
        + "Subject: " + _subject + '\n'
        + _content + '\n'
        + "From: " + _sender;
}

int Letter::getCount()
{
    return _count;
}
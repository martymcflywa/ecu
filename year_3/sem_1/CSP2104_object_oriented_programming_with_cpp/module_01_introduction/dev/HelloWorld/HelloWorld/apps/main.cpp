#include <iostream>
#include "../src/Person.cpp"

using namespace std;

int main()
{
    auto person = Person();
    cout << "What is your date of birth? " << endl;
    cin >> person.dateOfBirth;
    cout << "You are born on " << person.dateOfBirth << endl;
    return 0;
}

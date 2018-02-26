#include <iostream>
#include "../src/Person.cpp"

using namespace std;

int main()
{
    int dateOfBirth;
    cout << "What is your date of birth? " << endl;
    cin >> dateOfBirth;
    cout << "You are born on " << dateOfBirth << endl;
    getchar();
    return 0;
}

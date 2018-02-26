# Module 1 learning objectives

- List 3 primitive data types
    - int
    - char
    - double
- Describe what an object is
    - An individual identifiable entity, real or abstract with a well defined role in the problem domain
- What is abstraction
    - Paying attention to key information
    - Leave out fine details
- What is encapsulation
    - Variables and instructions are packed away
    - Can be reused easily
    - Reduces coupling
    - Interact with encapsulated modules with interfaces
        - Knowledge of inner working not required
        - But to call a module you need to know some details
- Print to console

``` cpp
#include <iostream.h>
using namespace std;

int main()
{
    cout << "Hello world!" << endl;
}
```

- Take input and store in variable

``` cpp
#include <iostream.h>
using namespace std;

int main()
{
    int age;
    cout << "What is your age?\n";
    cin >> age;
    return age;    
}
```
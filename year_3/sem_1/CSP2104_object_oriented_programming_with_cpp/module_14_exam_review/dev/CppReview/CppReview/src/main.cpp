#include <iostream>
#include <string>

#include <util/Cli.h>
#include <util/Reader.h>
#include <review/m5/IdValidator.h>
#include <review/m5/SessionPlanner.h>
#include <review/m5/Nested.h>
#include <review/m5/ArrayOps.h>
#include <review/m7/Functions.h>
#include <review/m8/CollegeCourse.h>
#include <review/m8/Letter.h>
#include <review/m8/HrSystem.h>
#include <review/m9/Pizza.h>
#include <review/m9/Customer.h>
#include <review/m10/HrSystem.h>
#include <review/m10/Mammal.h>
#include <review/m10/Lion.h>
#include <review/m10/Tiger.h>
#include <review/m10/Liger.h>

using namespace std;
using namespace util;
using namespace m5;
using namespace m7;
using namespace m8;
using namespace m9;
using namespace m10;

int main()
{
    auto cli = Cli();
    auto reader = Reader(cli);

    // 4.0
    cli.beginModule(5, "Loops");
    // 4.1
    cli.beginExercise(1);
    auto idValidator = IdValidator(cli);
    idValidator.validate();
    // 4.2
    cli.beginExercise(2);
    auto sessionPlanner = SessionPlanner(cli);
    sessionPlanner.get();
    // 4.3
    cli.beginExercise(3);
    auto nested = Nested(cli);
    nested.getMatrix();
    // 4.4
    cli.beginExercise(4);
    auto ops = ArrayOps(cli);
    ops.run();

    // 7.0
    cli.beginModule(7, "Functions");
    // 7.1
    cli.beginExercise(1);
    auto functions = Functions(cli);
    functions.compute();
    // 7.2
    cli.beginExercise(2);
    functions.setVector();
    // 7.3
    cli.beginExercise(3);
    functions.initFileIo();

    // 8.0
    cli.beginModule(8, "Classes");
    // 8.1
    cli.beginExercise(1);
    auto course = CollegeCourse();
    course.setId(101);
    course.setDepartment("Science");
    course.setSeats(50);
    cli.print(course.toString());
    // 8.2
    cli.beginExercise(2);
    auto firstLetter = Letter();
    firstLetter.setRecipient("John Doe");
    firstLetter.setSubject("Hi!");
    firstLetter.setContent("Hey John, how are you?");
    firstLetter.setSender("Jane Doe");
    cli.print(firstLetter.toString());
    cli.print("letterCount=" + to_string(firstLetter.getCount()));
    auto secondLetter = Letter();
    secondLetter.setRecipient("Jane Doe");
    secondLetter.setSubject("I'm well!");
    secondLetter.setContent("I'm great Jane, how are you?");
    secondLetter.setSender("John Doe");
    cli.print(secondLetter.toString());
    cli.print("letterCount=" + to_string(secondLetter.getCount()));
    // 8.3
    cli.beginExercise(3);
    auto hrSystem = m8::HrSystem(cli, reader);
    hrSystem.run();

    // 9.0
    cli.beginModule(9, "Class features and design issues");
    // 9.1
    cli.beginExercise(1);
    auto standard = Pizza();
    cli.print(standard.toString());
    auto special = Pizza("special", "pineapple");
    cli.print(special.toString());
    auto deluxe = Pizza("deluxe", "sausage", 16.00);
    cli.print(deluxe.toString());
    auto superDeluxe = Pizza("super deluxe", "lobster", 20, 17.99);
    cli.print(superDeluxe.toString());
    // 9.2
    cli.beginExercise(2);
    auto first = cli.get("Enter first name");
    auto middle = cli.get("Enter middle name");
    auto last = cli.get("Enter last name");
    auto current = stod(cli.get("Enter balance"));
    auto limit = stod(cli.get("Enter limit"));
    auto phone = cli.get("Enter phone number");
    auto customer = Customer(
        first,
        middle,
        last,
        current,
        limit,
        phone);
    cli.print(customer.toString());

    // 10.0
    cli.beginModule(10, "Inheritance");
    // 10.1
    cli.beginExercise(1);
    auto newHrSystem = m10::HrSystem(cli, reader);
    newHrSystem.run();
    // 10.2
    cli.beginExercise(2);
    auto mammalOne = Mammal(4, true, true, "brown", "brown");
    auto mammalTwo = Mammal(2, false, false, "black", "blue");
    cli.print(mammalOne.toString());
    cli.print(mammalTwo.toString());
    auto lionOne = Lion(4, true, true, "golden", "brown");
    auto lionTwo = Lion(4, true, false, "white", "blue");
    cli.print(lionOne.toString());
    cli.print(lionTwo.toString());
    auto tigerOne = Tiger(4, true, false, "orange", "brown");
    auto tigerTwo = Tiger(4, true, true, "white", "blue");
    cli.print(tigerOne.toString());
    cli.print(tigerTwo.toString());
    auto ligerOne = Liger(4, true, true, "white", "brown");
    auto ligerTwo = Liger(4, true, false, "tan", "blue");
    cli.print(ligerOne.toString());
    cli.print(ligerTwo.toString());

    return 0;
}

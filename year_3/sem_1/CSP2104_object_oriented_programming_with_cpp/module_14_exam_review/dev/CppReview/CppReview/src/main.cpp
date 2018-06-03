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

using namespace std;
using namespace util;
using namespace m5;
using namespace m7;
using namespace m8;

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
    auto hrSystem = HrSystem(cli, reader);
    hrSystem.run();

    return 0;
}

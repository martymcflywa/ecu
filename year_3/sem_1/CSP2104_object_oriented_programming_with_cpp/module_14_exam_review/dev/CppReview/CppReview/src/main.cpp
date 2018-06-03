#include <iostream>
#include <string>

#include <util/Cli.h>
#include <review/m5/IdValidator.h>
#include <review/m5/SessionPlanner.h>
#include <review/m5/Nested.h>
#include <review/m5/ArrayOps.h>
#include <review/m7/Functions.h>

using namespace std;
using namespace m5;
using namespace m7;

int main()
{
    auto cli = Cli();

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
    
    return 0;
}

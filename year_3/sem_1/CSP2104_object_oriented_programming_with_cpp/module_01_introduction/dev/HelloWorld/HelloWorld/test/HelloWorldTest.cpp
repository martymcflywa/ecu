#include <gtest/gtest.h>
#include "../src/Person.cpp"

int main(int argc, char* argv[])
{
    testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}

/**
 * Meaningless test, just trying to figure out how it works atm.
 **/
TEST(HelloWorldTest, DateOfBirthMatch)
{
    auto person = Person();
    person.dateOfBirth = 19830617;
    EXPECT_EQ(19830617, person.dateOfBirth);
}
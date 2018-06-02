#pragma once

#include <string>

class Cli
{
public:
    std::string get(const std::string& message);
    void print(const std::string& message);
    void beginModule(unsigned id, const std::string& subject);
    void beginExercise(unsigned id);
};
#pragma once

#include <stdexcept>

namespace m11
{
    class RequestedException : public std::domain_error
    {
    public:
        explicit RequestedException(const std::string& message);
    };
}
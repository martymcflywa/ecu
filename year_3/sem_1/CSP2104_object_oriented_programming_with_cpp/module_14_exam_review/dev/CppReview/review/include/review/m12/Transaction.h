#pragma once

#include <review/m12/Customer.h>
#include <string>

namespace m12
{
    class Customer;

    class Transaction
    {
        unsigned _id;
        float _amount;
    public:
        Transaction(const unsigned& id, const float& amount);
        friend void Customer::apply(const Transaction& transaction);
        std::string toString();
    };
}
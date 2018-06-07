#pragma once

#include <string>

namespace m12
{    
    class Transaction;

    class Customer
    {       
        unsigned _id;
        std::string _first;
        std::string _last;
        float _balance;
    public:
        Customer(
            const unsigned& id,
            const std::string& first, 
            const std::string& last,
            const float& balance = 0.f);
        void apply(const Transaction& transaction);
        std::string toString();
    };
}
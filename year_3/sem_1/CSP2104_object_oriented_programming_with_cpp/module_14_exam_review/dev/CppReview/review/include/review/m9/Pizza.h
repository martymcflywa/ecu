#pragma once

#include <string>

namespace m9
{
    class Pizza
    {
        std::string _type;
        std::string _topping;
        unsigned _size;
        double _price;
        
        static const std::string DEFAULT_TYPE;
        static const std::string DEFAULT_TOPPING;
        static const unsigned DEFAULT_SIZE;
        static const double DEFAULT_PRICE;
    public:
        Pizza(
            const std::string& type,
            const std::string& topping,
            const unsigned& size,
            const double& price);
        Pizza(
            const std::string& type, 
            const std::string& topping);
        Pizza(
            const std::string& type,
            const std::string& topping, 
            const unsigned& size);
        Pizza();
        
        std::string toString();
    };
}
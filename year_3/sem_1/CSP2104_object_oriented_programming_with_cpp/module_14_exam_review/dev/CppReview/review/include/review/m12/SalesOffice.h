#pragma once

#include <string>
#include <ostream>

namespace m12
{
    class SalesOffice
    {
        std::string _name;
        double _sales;
    public:
        SalesOffice(const std::string& name, const double& sales);
        std::string compare(SalesOffice& that);
        double operator/(SalesOffice& that);
        friend std::ostream& operator<<(
            std::ostream& out, 
            const SalesOffice& so);
    };

    std::ostream& operator<<(
            std::ostream& out, 
            const SalesOffice& so)
    {
        return out << "The " << so._name << " office sold $"
            << so._sales << '\n';
    }
}
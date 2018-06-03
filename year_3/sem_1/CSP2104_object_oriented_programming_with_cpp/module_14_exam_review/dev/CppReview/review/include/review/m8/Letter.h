#pragma once

#include <util/Cli.h>
#include <string>

namespace m8
{
    class Letter
    {
        std::string _recipient;
        std::string _subject;
        std::string _content;
        std::string _sender;
        static int _count;
    public:
        Letter();
        void setRecipient(const std::string& recipient);
        void setSubject(const std::string& subject);
        void setContent(const std::string& content);
        void setSender(const std::string& sender);
        std::string toString();
        static int getCount();
    };
}
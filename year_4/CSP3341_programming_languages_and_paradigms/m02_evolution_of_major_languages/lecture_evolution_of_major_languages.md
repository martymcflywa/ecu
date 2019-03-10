# Evolution of Major Languages

## Overview

- Context and issues surrounding release and evolution of major languages
- Evolution of capabilities and features
- Introduction and discussion of major languages
- Textbook
  - Chapter 2
  - Must read

# Genealogy of common languages

![genealogy](https://snag.gy/qiJwtz.jpg)

# Zuse's Plankalkul

- Designed in 1945
- Not published until 1972
- Never implemented
- Remarkably advanced given its context
  - Various data types and structures
    - Arrays
    - Records
  - Selection statement
    - Includes if statement
    - No else
  - Iterative statement
    - Includes break statement
- Zuse's manuscript contained may algorithms written in Plankakul
  - Includes 49 pages of algorithms to play chess
- An assignment statement to assign the `A[4] + 1 to A[5]`

```
// single statement consists of three lines
  | A + 1 => A   // A + 1, assign value to A
V | 4        5   // array subscripts, A[4], A[5] (optional)
S | 1.n 1.n  1.n // data type, integer of n bits
```

# Machine code and pseudocodes

- Computers in 1940s and early 1950s were slow, unreliable, expensive and difficult to program
  - No high level languages
    - Had to use machine code
  - Instructions use numeric codes
    - Not words/symbols
    - ie. Instruction for ADD may be `14` instead of `ADD` or `+`
  - Memory addressing is absolute
    - If program was changed and instructions were added or removed
      - Then references to original function in memory would be off by one
    - Error prone and tedious
- Higher level languages called pseudocodes were developed to make programming easier
  - Not the same meaning of **pseudocode**
  - Short code (1949) used codes to represent mathematical functions
    - Could be grouped
    - Interpreted
    - Slow
  - Speedcoding (1953) implemented on IBM 701
    - Floating point calculation
    - Mathematical functions
    - Interpreted
  - UNIVAC compiling systems (1951 - 1953)
    - Expanded source pseudocode into machine code

# IBM 704 and Fortran

- Slow speed of pseudocode was tolerable
  - Because more time was spent on floating point operations
    - Not supported in hardware
    - Had to be simulated in software
- IBM 704 (1954) supported floating point instructions in hardware
  - Removed the time spent simulating it in software
  - Slow speed of interpretation became noticeable
- Fortran credited as first major compiled high level language
  - Designed for IBM 704
  - Original report for Fortran 0 published in 1954
  - Changed during implementation period
    - Between 1955 and 1957 when compiler was released
  - Implementation form is what is known as Fortran I

## Fortran I

- Original compiler was efficient
  - Performs a lot of optimisation
  - Made translated machine code almost half as efficient as handwritten machine code
- Features
  - Basic input/output formatting
  - Variable names up to six char long
  - User defined sub programs
  - Arithmetic based `if` statement
  - Post test `do` counter loop statement
- No data types
  - Variable names starting with I, J, K, L, M, N were automatically integers
  - Everything else was a float
- Significant in evolution of major programming languages
  - Played a role in emergence of many standard features of modern languages
- IBM 704 put cap on size of Fortran programs

## Fortran II, III, IV, 77, 90, 95 and 2003

- The Fortran II compiler was released in 1958
  - Supported independent compilation of sub programs
  - IBM 704 was unreliable
    - Compiling large programs without it crashing was tricky
    - Compiling parts at a time was better
- Fortran III was released
  - Never really took off
- Fortran IV (1960 - 1962) was a major improvement
  - Variable type declarations
  - Logical `if` statement
- Fortran 77
  - String handling
  - Logical loops
  - Optional `else`
- [Fortran 90](https://www.nsc.liu.se/~boein/f77to90/a3.html) dramatically different to Fortran 77
  - Dynamic arrays
  - Records
  - Pointers
  - Multiple selection statements
  - Modules
  - Introduced concept of deprecating features
    - List of constructs recommended for removal in future versions
  - Removed rigid formatting requirements of code
    - Based on using punch cards
- Fortran 95 didn't add much significance
- Fortran 2003
  - Supported object oriented programming
  - Interoperability with C
- Fortran had massive impact on evolution of programming languages in many ways

# Functional programming and Lisp

- Need for functional programming emerged with first applications is ai during 1950s
  - Interest in field of linguistics, psychology and mathematics
  - All interests needed a language to store and process symbolic data in linked lists
    - As opposed to numeric data in arrays
- Lisp (1958) was first major functional language
  - Designed by John McCarthy at MIT
  - Syntax based on lambda calculus
  - Only two data types
    - Atoms
    - Lists
  - New dialects of Lisp include
    - Scheme
      - Small
      - Simple
      - Useful for education
    - Common Lisp
      - Combines features of many Lisp dialects
      - Large
      - Complex

## Lists in Lisp

- `(A, B, C, D)`
- `(A, (B, C), D, (E, (F, G)))`

![lisp list](https://snag.gy/TbYKMj.jpg)

# ALGOL 58

- In late 1950s, numerous high level languages were emerging
  - Most of them for one platform
    - UNIVAC
    - IBM
  - No portability or universal language to communicate in
- In 1958, the US Association for Computing Machinery (ACM) and German Society of Applied Mathematics and Mechanics (GAMM) form a joint team to develop a machine independent language
- First meeting established design goals
  - Close to standard mathematical notation
  - Programs written in it should be easily readable
  - Good for describing algorithms in publications
  - Must be translatable to machine code
- Language designed is ALGOL 58
  - Generalised, expanded descendent of Fortran
    - Simple
    - Flexible
    - Elegant
    - Data type declarations
    - Compound statements
    - Long variable names
    - Nested selection statements
- Had some success
  - IBM dropped it in favour of Fortran
    - Did not fancy the prospect of getting another language established
- Was debated
  - Changes suggested throughout 1958
  - New notation describing syntax
    - Backus-Naur-Form (BNF)


## ALGOL 60

- Second meeting in 1960 to discuss suggested changes and additions to ALGOL 58
  - Block structures (scoping)
  - New parameter passing methods for sub programs
  - Stack dynamic arrays
  - Did not include input/output statements with formatting
    - Deemed too machine dependent
- ALGOL 60 became the only formal way to depict algorithms in literature
- Influenced all imperative languages that followed it
  - Pascal
  - Ada
  - C
  - Java
- Never became a prominent language
  - Too flexible
    - Implementation hard to understand, tricky
  - Lack of input/output statements and strings caused problems
  - BNF was strange and complicated to people at the time

# COBOL

- Like ALGOL, COBOL was designed by committee for similar reasons
  - In domain of business applications
  - Not scientific
- Design goals of COBOL
  - Use simple English
  - Easy to use
    - Even at expense of power
    - To broaden base of computer users/code literacy
  - Not restricted by current implementation limitations
- Initial design published in 1960
  - Revised in
    - 1961
    - 1962
    - 1974
    - 1985
    - 2002
  - Still evolving and in use today
- Significant features
  - `DEFINE` command for macros
  - Hierarchical data structures
    - Records
  - Long variable names that support hyphens
- Variables and records are defined in detail
- Commands to output to printer exist
- Use mandated by Department of Defence
  - Established until computers and compilers were powerful and cheap enough for COBOL to be widely used by business
  - No other major languages in business application domain
  - COBOL is still capable of meeting business application needs
  - But these days off the shelf application software is often used

# BASIC

- Designed by Dartmouth College 1963
  - Easy for non science students to use
- Design emphasis
  - Pleasant and friendly to use
    - Free and private to access
  - Fast turnaround time for small programs
    - Homework
  - Must not require understanding of computer hardware to use
  - Must consider user time more important than computer time
- Was the first major language to use timesharing
  - Accessed via terminals connected to remote computer
  - Decreasing cost and availability of computers recognised
  - Timesharing made better use of single powerful computer
- Many versions exist
  - Resurgence of use from 1990s with Visual BASIC
    - Easy GUI
  - VB.NET widely used
- A timeshare BASIC terminal
  - Output was to paper
  - Programs saved to punch cards/tape
  - What Bill Gates and Paul Allen wrote programs on in 1969

![BASIC terminal](https://social.technet.microsoft.com/wiki/cfs-filesystemfile.ashx/__key/communityserver-wikis-components-files/00-00-00-00-05/7607.hh182234.HP_2D00_1000_2800_en_2D00_us_2C00_MSDN.10_2900_.jpg)

# PL/I

- First attempt to create a language that could cater for many different application domains
  - Bring science FORTRAN and business COBOL domains together
- IBM developed a computer that could do both floating point and decimal arithmetic suitable for science and business
  - IBM System/360 1964
- Designed a universal language to support science and business applications
  - As well as systems programming and list processing too
- Originally called NPL
  - Name changed to PL/I ain 1965
- Language included features from other languages
  - ALGOL 60
    - Recursion
    - Block structure
  - Fortran IV
    - Separate compilation of sub programs
  - COBOL
    - Data structures
    - IO
    - Report generation
- New features
  - First unit level concurrency
  - First exception handling
  - Switch selectable recursion
  - First pointer data type
  - First array cross sections
- Massive and complex language
  - Cobbled together
  - Hard to understand/use
- Several new features poorly designed or badly implemented
- Saw significant use in scientific and business domains
- Negatives
  - Too many constructs
  - Too large/complex
  - New features not well designed
  - Tossed everything together they thought would be useful without thinking about how anyone was meant to understand how to use it effectively
  - Not orthogonal

# APL (A Programming Language)

- Designed at IBM by Ken Iverson 1960
  - Still in use
  - Minimal changes
  - Not widely used
- Many powerful operators
  - Many for arrays
  - Makes it very expressive and writable
  - Hard to read/maintain
  - Often thought of as being good for throw away code
- Originally used special terminals and typeballs to support characters needed for operators

# SNOBOL

- Designed in early 1960s as string processing language
  - Many powerful operators for string pattern matching
  - Early uses include writing text editing applications
  - Still used for certain text processing tasks
- APL and SNOBOL similarities
  - Minimal influence from languages that came before them
  - Minimal influence on languages that came after them
  - Both featured dynamic typing and dynamic storage allocation
    - A variable takes on a type when value is allocated to it
    - Storage space for variable is allocated at that point

# SIMULA 67

- SIMULA I designed in early 1960s
  - Replaced by SIMULA 57
  - Influenced by ALGOL 60
    - Extends it
  - Never achieved widespread usage or high influence
- Introduced concept of coroutines
  - Sub programs that run in parallel rather than as caller/callee
  - Can enter/exit at more than the start and end of code block
- Introduced classes
  - Data abstraction
  - Allows definition of data structure and functions to manipulate
  - Instance of class is an object

# ALGOL 68

- Dramatically different to ALGOL 60
  - Never achieved widespread use
  - Used confusing new syntax description language
- Based on high orthogonality
  - A few primitive types and structures
  - Can be combined into many different structures
  - Has been included in most imperative languages since
    - Strong influence on
      - C
      - Pascal
      - Ada
- Introduced dynamic arrays
  - Array declaration doesn't include subscript bounds
  - Memory allocated on assignment
- Orthogonal approach
  - ALGOL 68 achieved high writeability in simple/elegant manner
  - PL/I tried to achieve high writeability by providing a massive pile of data types and structures

# Pascal

- Released in 1971
  - Based on ALGOL 60
- Designed for teaching structured programming
  - Widely used for this from early 1970s to late 1990s
- Design focus resulting in lacking several features necessary for application development
  - Can't compile sub programs separately
  - Can't handle variable length arrays as sub program parameters
  - Led to dialects like Turbo Pascal
- High simplicity and expressivity
- Safe to code

# C

- Originally designed in 1972 for systems programming
  - Well suited for other applications
- Influenced by
  - CPL
  - BCPL
  - B
  - ALGOL 68
- Highly expressive and writeable due to
  - Adequate operators
  - Control structures
  - Data structures
- Complete lack of type checking in early versions
  - Some appreciated the flexibility
    - Some found it dangerous
- Several dangerous/insecure features
  - Pointers
  - High flexibility must be used wisely/safely
- Doesn't go out of way to stop people doing stupid things that cause programs to crash or contain security flaws
- A C compiler was included in UNIX
  - Freely available
  - Contributed greatly to its rise in popularity in 1980s

# Logic programming and Prolog

- Use of formal logic to communicate computational processes to a computer
  - Summarised as an intelligent database system that uses an inferencing process to infer truth of queries
  - Based on predicate calculus
- Logical languages are declarative
  - Non procedural
  - Statements describe what to accomplish
    - Not how to do it
- Prolog 1972 is a logic language
  - Consists of
    - Facts
    - Rules
    - Goals/queries
    - All resolve to true or false
  - Inefficient
    - Not designed around Von Neumann architecture
  - Not widely used
    - Only a few areas of application
      - AI
      - DBMS

# Ada

- Developed for US DoD 1974
  - Had hundreds of languages in use in embedded devices
  - No standardisation
  - Low reuse
  - No development tools
  - Many languages no suitable for embedded devices
- Most extensive and expensive language design ever
  - Hundreds of people
  - A lot of money
  - 8 years
- Aim was to design one language to use
  - Suitable for embedded systems
- Design process long and tedious
  - Many submissions evaluated and refined
- First spec released 1980
  - Standardised in 1983
- Took until 1985 to release first truly usable Ada compiler
- Four major contributions
  - Packages
    - Allows encapsulation of
      - Data objects
      - Specifications and procedures
  - Exception handling
    - Catch runtime errors
  - Generic program units
    - Untyped procedures
    - Increase code reuse
    - Minimise code duplication
  - Concurrency
    - Procedures to run at the same time
- Ada 95 replaced Ada
  - Introduced
    - Type derivation
      - Inheritance
    - Dynamic binding of sub program calls
      - Polymorphism
    - Improved concurrency mechanisms
  - Use slowed when DoD stopped requiring it
    - When C++ released

# Object oriented programming and Smalltalk

- Smalltalk 1972 was first language to fully support OOP
  - Supported
    - Data abstraction
    - Inheritance
    - Dynamic binding
  - Some OO features emerged in SIMULA and Ada
    - Reached maturation in Smalltalk
- Everything is an object
  - Integers
  - Software systems
  - All computing done by calling methods on objects
  - Syntax looks odd
    - Even arithmetic and logic done via method calls on objects
- Replaced by Smalltalk-80
- Pioneered GUI design

# Combining imperative and OOP: C++

- C++ evolved from C
  - Incorporated language facilities of
    - SIMULA
    - OOP support from Smalltalk
  - Increased safety via type checking and exception handling
  - Emerged between 1983 and 1985
    - After numerous expansions to C
    - Continues to evolve
- Includes
  - Support for both procedural and object oriented programming
  - Multiple inheritance
  - Overloading operators and class methods
- Very popular, widely used
  - Good, free compilers
  - High compatibility with C
  - Object oriented support
  - Suitable for application devs
- Still relatively unsafe compared to other languages

# Java

- Developed by Sun in 1990s
  - Started with C++
    - Removed changed added bits
    - Came up with smaller simpler safer language
    - Retains much of power and flexibility of C++
- Designed for embedded consumer electronics
  - Needed to be reliable
  - Never really eventuated
  - Found to be very useful for web applets
- Some features that make it safer/reliable
  - References
    - Safer than pointers
  - Index range checking for arrays
  - Garbage collection to deallocate storage for objects
  - Implicit type coercion only for widening assignments
- Does not include from C++
  - Struct
  - Union
  - Enum (It does?)
  - Pointer arithmetic
  - Multiple inheritance
- Has become widely used in various areas
  - Appreciate design
    - Smaller, safer than C++
    - More reliable
  - Portability
    - Runs on any computer that has JVM
  - Freely available online
- Still widely used and developed

# Scripting languages

- Evolved from batch files/shell scripts
  - List of commands that execute system sub programs
- Added variables and control structures to make them more powerful
- Eventually evolved into complete languages
- Often serve as general purpose interpreted languages

## Perl

- General purpose
- Simple
- Unusual as it is compiled into intermediate form
- First character of variable name denotes namespace
  - `$`, `@`, `%`
  - Variable naming more readable
    - Informed about variable by reading its name
- Includes dynamic length and associative arrays
- Powerful but somewhat dangerous due to
  - Type coercion
  - Issues with detecting errors in arrays

## Web scripting: Javascript and PHP

- Javascript designed by Netscape and Sun in 1995
  - Server side processing was possible with CGI
    - But client side needed in order to create dynamic and interactive pages
  - Javascript interpreter usually embedded into browser
- PHP released as a package to help track site visitors in 1995
  - Purely interpreted
  - Evolved into general purpose server side scripting language
  - Mainly used for web apps
    - Scripts usually produce HTML pages as output
    - Sent to client
  - Includes
    - OOP support
    - Associative/dynamic arrays
    - Dynamic typing
    - Easy web form processing
    - DBMS integration

# Python

- OOP interpreted scripting language 1991
  - Similar application areas as Perl
    - System admin
    - CGI programming
    - Small app development
- Includes
  - OOP support
  - Exception handling
  - Garbage collection
  - CGI module for form processing
  - Modules for other stuff
  - Open source
- Known for peculiar syntax
  - Designed to be highly readable and clear
  - Whitespace used instead of curly brackets or keywords to delimit blocks

# Ruby and Lua

- Ruby 1996 is purely OO based like Smalltalk
  - Methods can be dynamically added to both classes and objects
    - Different instantiations can be different
  - Dynamic typing with scope specified by first char of variable name
    - `char` is local
    - `@` is instance
    - `$` is global
- Lua 1993 supports both procedural and functional programming
  - Only one data structure
    - Tables
  - Incorporates capabilities of associative and traditional arrays
  - Includes
    - Garbage collection
    - Dynamic typing
  - Relatively small and simple language
- Both used for CGI programming and form processing

# .NET

- Released in 2002, adds common library and virtual machine for range of interoperable languages to the Windows OS
  - C#
    - Influenced by
      - C++
      - Java
      - Visual BASIC
      - Delphi
      - Tweaked parts of C++ for safety
  - J#
    - .NET version of Java
    - Discontinued
  - VB.NET
    - .NET version of Visual BASIC
    - OO support
  - ASP.NET
    - Server side web application language
  - Powershell
    - OO command line shell scripting language
- All .NET languages compile into a single intermediate language
  - Then compiled with a Just-In-Time (JIT) compiler

# Summary

- Context of language in history of languages is important
  - Design goals and motivations
  - Situation it emerged and evolved in
  - What it added to area of programming languages
  - Reason for success and failure
  - What languages influenced it and what it influenced
- Some languages such as Fortran, ALGOL, Ada, C/C++, Java are well known and had major impacts or usage
  - Others are not as common or widely used but still introduced something new or expanded something important
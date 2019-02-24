# Preliminaries

# Overview

- Preliminary topics and concepts of programming languages
- Overview of programming language domains and categories
- Language evaluation criteria and design influences
- Language implementation and programming environments
- Textbook
  - Chapter 1
  - Reading required

# Why study programming languages

- Advantages
  - Increased ability to express ideas
  - Improved background for choosing appropriate languages
  - Increased ability to learn new languages
  - Better understanding of significance of implementation
  - Better use of languages that are already known
  - Overall advancement of computing
- Parallel between programming and natural languages
  - Understanding how languages work makes learning a new language much easier
  - Vocabulary (syntax) of language is not the important part

# Programming domains

- Computers have been applied to many different areas
  - Falls into a few core domains
  - Domain boundaries can be blurry

## Scientific

- Original purpose of digital computers
  - 1940s
- Involves lots of floating point computations
- High use of arrays and matrices
- Fortran
  - First and most prominent in this domain

## Business

- Emerged in 1950s and 1960s
- Reports
  - Decimals
  - Characters
- COBOL
  - First successful business language

## Artificial intelligence

- Symbols rather than numbers are manipulated
- Use of linked lists rather than arrays
- High flexibility required
  - Create and run code during execution
- LISP
  - Functional
- Prolog
  - Logical language often used for ai programming

## Systems

- Used for operating systems
  - Must provide low level features to interface with external devices
- Needs to be efficient
  - Used continuously
- C and C related languages is the major language in this area
  - C is low level and efficient
  - But relies on programmers having the knowledge / skill to use it safely and effectively

## Web

- Eclectic collection of languages
  - Some dedicated to markup
    - XHTML, XML
    - Not programming
- Some web enabled general purpose languages
  - Java
- Scripting languages
  - PHP
  - Javascript
  - Designed for the web to provide
    - Dynamic content
    - Web based apps
- Rapidly emerging and evolving field

# Language evaluation criteria

- Four primary factors to take into account

## Readability

- Ease with which programs can be read and understood
- Before 1970s, emphasis was on write-ability
  - As concept of software life cycle emerged, maintenance of code saw a more prominent role
  - Maintenance relies on readability
    - Important criteria since 1970s
- Appropriate language selection as impact on readability
  - If a language is used in a domain it was not intended for, it is likely to result in confusing and convoluted code

### Simplicity of language

- Manageable set of features and constructs
- Avoid offering multiple ways to do the same thing
- Avoid overloading operators or keywords in un-intuitive ways

### Orthogonality

- Relatively small and simple set of primitive constructs can be combined in a relatively small number of ways
- All combinations are legal and have sensible / intuitive results
- Minimal exceptions to these guidelines

### Data types

- Languages that offer appropriate data types are readable
  - `true` is more meaningful than `1`

### Syntax considerations

- Variable name rules
  - Short name limits hinder readability
  - Special character prefix makes them easier to spot, improves readability
- Control structures that end group statements with `}` are less readable than those which use `end if`, `end loop` etc.
- Meaning of reserved and key words in a language should be intuitive and obvious
- Reserved and key words that have different meanings in different contexts reduce readability
  - So does ability to define variables with same names as reserved / key words

## Write-ability

- Ease with which a language can be used to create programs
- Most of the factors that affect readability also affect write-ability
  - Writing a program involves reading it quite a bit
- Must consider the intended domain of the language

### Simplicity and orthogonality

- Large complex languages with inconsistent rules for combining their primitive elements are more difficult to write
- Inefficient code may result if a user does not know of certain features of the language
  - Or uses them incorrectly

### Support for abstraction

- Abstraction is a core concept in programming languages
  - Define and use structures that allow the details of a process to be ignored
- Allows for efficient and meaningful code to be written

### Expressivity

- Convenient and meaningful ways of specifying operations
- Appropriate set of pre-defined functions to make use of

## Readability vs. write-ability

- Are balancing acts
  - Raising one can lower the other
  - Both have extremes to avoid
- A language with massive amounts of pre-defined functions may be very easy to write
  - But can be difficult to read
- A language which is very simple may be highly readable
  - But too much simplicity can make it cumbersome to write in
- The goal is to strike an optimal balance between readability and write-ability
  - A language that is simple and predictable
    - Readability
  - But flexible and expressive
    - Write-able

## Simplicity, orthogonality and Lego

- One way to think of simplicity and orthogonality in programming languages is by comparing it to Lego sets
- Old Lego sets were simple
  - Generic set of well known pieces
  - Simple and consistent combination
- New Lego sets are silly
  - Lots of one-off and specific pieces
  - Limited connectivity and scope

## Reliability

- Conformance to specifications
  - Does what it is meant to do in all conditions
- A program is reliable if it performs to its specifications under all conditions
  - If it always does what it's meant to do
- A language's intended domain influences the reliability of a language
  - A program written in an inappropriate language / domain will be convoluted and inelegant
    - Prone to errors
- Readability and write-ability influence reliability
  - A language hard to write requires convoluted and inelegant solutions
    - Prone to errors
  - A language which is not readable is harder to write and maintain
    - Prone to errors

### Type checking

- Loosely types languages are less reliable than strongly typed
- Less able to detect type errors
  - Could lead to uncaught errors and crashes

### Exception handling

- Languages which provide features to detect and handle runtime errors are more reliable

### Aliasing

- Allowing more than one distinct name to refer / access the same memory address
  - Two pointers pointing at one variable
  - Reduces reliability
  - Dangerous feature

## Cost

- The ultimate total cost
- Based on numerous factors
  - Readability
  - Write-ability
  - Reliability
- Must consider all aspects that contribute to cost
  - Time
  - Effort
  - Need for expertise
- May not be directly financial but have associated cost
  - Highly readable languages are quicker / easier to maintain
    - Minimise cost of maintaining code
  - Highly write-able languages are quicker / easier to write
    - Minimise cost of developing code
  - Highly reliable languages do not need to be maintained as often
    - Minimise cost of maintenance
    - Failure of mission critical program could be very costly

### Cost of learning / training

- Learning or being trained to use a language
  - Influenced by readability and write-ability

### Cost of compiling and executing

- Compiling and executing code was important in early languages
  - Less important now
- Optimisation during compilation is a trade-off
  - Between compile and execution cost
  - During development when compilation is frequent
    - Optimisation is less cost effective

### Maintainability

- Relies on all three criteria
  - Readability
  - Write-ability
  - Reliability
- Most important factor

## Language evaluation criteria summary

- Cost is largely a product of the other three criteria
- Readability and write-ability can be seen as the two most important pieces of criteria
  - Both have significant impact on reliability and cost
- Importance of certain criteria can vary depending on the domain and type of application at hand
  - Mission critical and embedded programs must be reliable
  - Languages hoping for widespread use in industry and education should be readable and write-able
- Language designers must strive for an optimal balance of all criteria
  - Relative to the intended application / domain

# Influences on language designs / methodologies

- In 1950s and early 1960s, hardware was expensive and using it was time consuming and costly
  - Languages focused on machine efficiency
- From late 1960s, hardware became less expensive and more powerful
  - Person efficiency became focus
  - More sophisticated languages and programs
  - Programmer costs increase with complexity of program
  - Better control structures and type checking emerge
- In late 1970s, data oriented design emerged
  - Focus on abstract data types
- Early to mid 1980s, object oriented design emerged
  - Improve efficiency via inheritance and polymorphism

# Language categories

## Imperative

- Most common / widely used
- Includes scripting languages
  - Only distinct by their implementation method
- Includes most object oriented languages
  - Differs from procedural
  - But languages that support procedural tend to be imperative
- Involves sequences of statements that change state
  - A procedural approach
  - Defines how to achieve the desired results
- Heavy use of subprograms / functions to abstract processes
- Languages
  - FORTRAN
  - BASIC
  - Ada
  - Java
  - C
  - Python
  - PHP

## Functional

- Related to lambda calculus
- Design based on evaluation of mathematical functions
- Fundamentally different from imperative languages
  - Computation via evaluation of mathematical functions
  - No need for variables
  - Not based on changing state
    - Pure functions
- Declarative rather than imperative
  - Statements describe what to accomplish
  - Rather than how to accomplish it
- Languages
  - LISP
  - APL
  - Scheme
  - Haskell
- Applications are primarily in artificial intelligence

## Logic

- Related to predicate calculus
- Design based on evaluation of mathematical logic
- Fundamentally different from imperative languages
  - Express programs in a form of symbolic logic
- Also declarative
  - Describes what, not how
- Languages
  - Prolog
- Applications are primarily in expert systems and natural language processing
- Functional and logic languages have simpler syntax and semantics
  - But are inefficient to execute
  - Both are niche

# Von Neumann computer architecture

- Von Neumann architecture is the prevalent computer architecture
  - Has profound effect on design of languages
  - Were made to execute efficiently on this architecture
- Fundamentals of architecture
  - Data and programs stored in memory
  - Memory is separate to CPU
  - Instructions and data are piped from memory to CPU
  - CPU executes instructions and returns results to memory
- Led to fundamental concepts of imperative languages
  - Variables
  - Assignment statements
  - Iteration
- Functional and logic languages are not based on this architecture
  - Their execution is relatively inefficient

![von neumann architecture](https://snag.gy/fMi25Z.jpg)

## The fetch-execute cycle

- Process of executing machine code on a computer
- An endless loop
  - Fetch next instruction from memory
  - Decode instruction to determine what action it specifies
  - Fetch data from memory if instruction requires it
  - Execute instruction
  - Return results to memory
- Control of the cycle / instruction queue transfers between the OS and applications as required

## Von Neumann bottleneck

- Speed of the connection between memory and CPU usually determines speed of computer
  - This is because instructions can typically be executed faster than they can be moved to the processor for execution
  - The CPU is often idle
    - Waiting for next instruction to arrive
- Known as the Von Neumann bottleneck
  - Primary limiting factor of the architecture
- The bottleneck is a core motivator for research into parallel computing
  - Where multiple CPU's are available

# Language categories and computer architecture

- Early programming languages and all of the commonly used languages are all imperative
  - Closely tied to Von Neumann architecture
  - Designed for efficiency using that architecture
- Functional and logic languages are not based on this
  - Many feel that functional and logic languages are technically more sophisticated in terms of syntax and semantics
  - Yet such languages have never seen more than niche usages
- Despite supposed technical superiority, functional and logic programming languages are unlikely to become more than niches
  - Even if functional and logic languages were as efficient as imperative languages
    - Most people are accustomed to imperative

# Language implementation methods

- Compilation
  - Code translated into machine language by a compiler
- Interpretation
  - Code is interpreted by a program known as an interpreter
- Hybrid implementation
  - A compromise between compilers and interpreters

## Machine code and high level language interfaces

- CPU only understands machine code
  - A low level language that provides most basic primitive operations
- System software is needed to provide an interface to this, translating higher level languages to machine code
  - The OS provides interfaces with input and output devices, resource management, storage, etc.
- High level languages need these
  - Their interfaces interact with the OS
  - Rather than directly with the CPU
- These interfaces are layered over the OS
  - Can be thought of as **virtual computers**
- This is a form of abstraction
  - Implementation / execution details of lower level languages are hidden from higher levels

![layered virtual computers](https://snag.gy/zWxqec.jpg)

## Compilation

- Source code is translated into machine code
- Several phases
  - Lexical analysis
    - Converts source program into lexical units
  - Syntax analysis
    - Transforms lexical units into parse trees
    - Represent the syntactic structure of the program
  - Semantics analysis
    - Generates intermediate code
  - Code generation
    - Machine code is generated
- Translation process is slow
- But results in fast program execution of compiled programs
- Can include optimisation
- Results in even faster and / or smaller compiled programs

## Interpretation

- Opposite end of compilation
- Source code is interpreted by and interpreter without any translation
- Software simulation of a processor performing a fetch-execute cycle for the high level language
- No translation means runtime debugging is much easier
- Execution is much slower than compiled program due to complexity of decoding high level statements
- Rarely used in high level languages since the 1980s
- Has made a resurgence in web based scripting languages

## Compilation and interpretation process

![compilation and interpretation process](https://snag.gy/N6y42V.jpg)

## Hybrid implementation

- Compromise between compilation and interpretation
- High level language translated to intermediate language
  - Can be interpreted easier
- Faster than pure interpretation
  - High level statements only need to be decoded once into intermediate language
- Initial Java implementations were hybrids
  - Source code compiled into intermediate byte code
  - Byte code could be interpreted on any machine by the Java Virtual Machine
  - Resulting in high portability of Java programs

![hybrid implementation](https://snag.gy/UytuXY.jpg)

## Just in time implementation

- Initially translates source code into intermediate language
- Then compiles the subprograms of it into machine code when they are called
- Compiled versions kept for subsequent calls to save time
- High level statements only need to be decoded once
- Individual subprograms can be recompiled if needed
- Essentially compilation with a pause and some flexibility
- Widely used in modern Java and .NET

# Programming environment

- The collection of tools used in software development
- Some languages include development tools
  - May also be from third party vendors
- Not part of the language itself
  - But still an important factor
  - A sophisticated and usable environment makes writing, reading and maintaining code much easier
- Examples
  - Visual Studio and .NET
  - NetBeans and Java
  - There are also generic tools
    - Programming oriented text editors
      - Visual Studio Code
      - Sublime Text

# Summary

- Justification of study of programming languages
- Programming domains
- Language evaluation criteria
  - Readability
  - Write-ability
  - Reliability
  - Cost
- Influences on language design
- Language categories
  - Imperative
  - Functional
  - Logic
- Von Neumann architecture
  - Fetch-execute cycle
  - Von Neumann bottleneck
- Language implementation methods
  - Compilation
  - Interpretation
  - Hybrid implementation
- Programming environments
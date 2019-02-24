# Favourite language: Java

## Release dates and versions

- Year of first release
  - JDK 1.0: January 1996
- Current version
  - Java SE 11
- Year of current release
  - March 2019

## Domains, implementation methods and paradigms

- Intended programming domains
  - Business
  - Web
- Implementation methods
  - Hybrid
  - JIT
- Supported categories or paradigms
  - Imperative
  - Functional
    - See Stream API from Java 8

## Language evaluation criteria

- Readability
  - 3/5
  - Relies on symbols rather than words to denote start/end of blocks
  - Object oriented with inheritance and polymorphic functionality
  - Strongly typed
- Write-ability
  - 3/5
  - Very verbose
    - Types must always be declared
      - Unable to determine from assignment, unlike C# / Kotlin `var` keyword for method variables
      - ie. `Foo foo = new Foo();` in Java, as opposed to `var foo = new Foo();` in C#
  - Object oriented with inheritance and polymorphic functionality
    - Can program by contract
      - Provides construct of interfaces, unlike C++
    - Reuseable code
- Reliability
  - 4/5
  - JVM has functionality to protect programmers from themselves
    - Garbage collection
    - Can't define / dereference pointers
  - Strongly typed
  - Can still be caught out by unchecked exceptions, ie. `NullPointerException`

## Inter language influences

- Influenced by
  - C
- Has influenced
  - C#
  - Kotlin
  - Android API
# Syntax and semantics

## Overview

- Formally describe syntax of programming language
- BNF
- EBNF
- Attribute grammars

## Textbook

- Chapter 3 Describing syntax and semantics
- Must read 3.5

# Need to formally describe syntax

- Important to have a precise and understandable description of a language's syntax
  - Helps avoid differences in interpretation and implementation
- ALGOL 60/68 included this
  - But both used notations which were new and confusing at the time
- Syntax description of a language must be understood by
  - Initial evaluators working on the design of the language
  - Implementers working on compilers/tools for the language
  - Users of the language
    - Programmers
- Syntax and semantics of a language are closely linked
  - Appearance and structure of commands should imply meaning

# Syntax description terminology

## Lexeme

- Smallest unit within a language
- Categorised into tokens
    - Numeric literals
    - Arithmetic operators
    - Reserved/key words
    - Descriptive names that indicate their purpose/identity
- Examples
  - `=`
  - `*`
  - `private`
  - `(`

## Token

- A category of lexemes
  - Identifiers are
    - Names of
      - Variables
      - Classes
      - Methods
  - A variable name is an instance lexeme of the identifier token
- Some tokens can only have one lexeme
  - `plus_op`

```
index = 2 * count + 17;
```

| Lexeme  | Token       |
| :------ | :---------- |
| `index` | identifier  |
| `=`     | equal sign  |
| `2`     | int literal |
| `*`     | multiply op |
| `count` | identifier  |
| `+`     | plus op     |
| `17`    | int literal |
| `;`     | semicolon   |

# Formal syntax

- Formally describing syntax involves defining valid combinations of lexemes and tokens that form sentences or stmts in the language
  - These principles are the same for programming vs. natural languages
  - However rules of natural languages are more complex than programming languages
- Formal syntax descriptions are made up of rules which use **abstraction**
  - A part of one rule may itself be another rule
- All rules can eventually be resolved into a series of lexemes and tokens
  - Which are considered indivisible units
- The syntax of program written in a language can be verified if it can be transcribed to/from the formally defined rules

# Backus-Naur Form BNF

- Metalanguage for syntax
- Original work in the area of context free grammars for natural languages was done by Chomsky 1950s
- Adapted by Backus and refined by Naur for ALGOL
- A BNF rule has two main parts
  - `<assignment> -> <variable> = <expr>`
  - Left hand side LHS
    - Abstraction being defined
    - The abstraction in this case is `<assignment>`
  - Right hand side RHS
    - The definition of the abstraction
- Abstractions are denoted `<like_this>` and are **non terminals**
  - They are divisible
  - Needing definition by a rule
- Lexemes and tokens are **terminals**
  - They are indivisible
- For this example to be of any use, rules for `<variable>` and `<expr>` would need to be defined
  - `<variable>` will need to be able to encompass
    - Identifiers
    - Array subscripts
    - etc.
  - `<expr>` will need to be able to encompass
    - `<variable`s
    - Arithmetic operators
    - Other functions
    - Combinations of above
- As would definitions for any non terminals in those rules

## BNF multiple definitions

- A single LHS can have multiple RHS

```
<if_stmt> -> if ( <logic_expr> ) <stmt>
                | if ( <logic_expr> ) <stmt> else <stmt>
```

- Allows `for` stmts with multiple/optional clauses
  - Each subsequent RHS begins with `|`, indented in line with `->`

## BNF variable length lists

- A variable length list is denoted via recursion
  - A list of variable names in a variable declaration stmt

```
<identifier_list> -> identifier
                   | identifier, <identifier_list>
```

- The second form of the rule can recursively define itself as needed, switching to the first definition at the end of the list

## Non terminal multiple definitions

- Non terminals can have multiple definitions, representing different ways of using the syntax
  - ie. `if` stmt may involve an `else` (or not, or other things), indicated by using a `|`
- An `<identifier_list>` may either be an identifier token, or an identifier token followed by a comma, and the `<identifier_list>` itself
- The length of the list can be controlled as necessary, since the first definition, just needs to be used when ending the list

## Grammars and derivations

### Grammar

- A collection of rules defining a language
- Must be a non-empty and finite set of rules

### Start symbol

- Special non terminal
- The single highest non terminal which encompasses a whole program
- Often named `<program>`

### Derivation

- Sentences in a language are generated by repeatedly applying the rules of a grammar
- Beginning from
  - The start symbol
- Ending with
  - A string of terminals

## Example grammar

```
<program>        -> begin <stmt_list> end

<stmt_list> -> <stmt>
                  | <stmt> ; <stmt_list>

<stmt>      -> <var> = <expr>

<var>            -> A | B | C

<expr>     -> <var> + <var>
                  | <var> - <var>
                  | <var>
```

- A program is made up of a series of statements
- The only stmt is `<var> = <expr>`
  - An assignment
- Expressions are either `+`, `-` or a single variable
- Variable names are either `A`, `B`, or `C`

## Derivation of a sentence

- Using the example grammar, we can derive a sentence

```
<program> => begin <stmt_list> end
          => begin <stmt> ; <stmt_list> end
          => begin <var> = <expr> ; <stmt_list> end
          => begin A = <expr> ; <stmt_list> end
          => begin A = <var> + <var> ; <stmt_list> end
          => begin A = B + <var> ; <stmt_list> end
          => begin A = B + C ; <stmt_list> end
          => begin A = B + C ; <stmt> end
          => begin A = B + C ; <var> = <expr> end
          => begin A = B + C ; B = <expr> end
          => begin A = B + C ; B = <var> end
          => begin A = B + C ; B = C end
```

- Begins at the start symbol, ends in a string of terminals
- Each line replaces a non-terminal with its definition

### Leftmost derivation

- Always replace the leftmost non terminal
- But can use rightmost, or other derivations

### Order of derivation

- No impact upon language that can be generated from a grammar
- By choosing different RHS of a rule definition when replacing a non terminal, different sentences can be generated
- If you were to exhaustively combine all possible combinations, you would generate the entire language
  - Every possible stmt
- Even though it is simple, this language is infinite
  - The recursive nature of `<stmt_list>` means that there are an infinite number of possibilities

### Rightmost derivation

```
<program> => begin <stmt_list> end
          => begin <stmt> end
          => begin <var> = <expr> end
          => begin <var> = <var> - <var> end
          => begin <var> = <var> - B end
          => begin <var> = A - B end
          => begin C = A - B end
```

### Identify error in derivation

```
<program> => begin <stmt_list> end
          => begin <stmt> end
          => begin <var> = <expr> end
          // need to break down <expr> to next sentential form <var>
          // missing line "begin <var> = <var>"
          => begin A = <expr> end
          => begin A = C end
```

## Parse trees

- Grammars naturally describe the hierarchical syntactic structure of sentences in the languages it describes
  - This can be depicted visually as a **parse tree**
  
![parse tree](https://snag.gy/7rRGfi.jpg)

## Ambiguity

- If a grammar allows two or more different parse trees to be created for a single final sentential form
  - It is ambiguous
- This is a problem since compilers use parse trees to determine what code to generate
- The following grammar is ambiguous
  - `<expr>` appears on RHS and is recursive

```
<assign> -> <id> = <expr>
<id>     -> A | B | C
<expr>   -> <expr> + <expr> // ambiguous
          | <expr> * <expr> // ambiguous
          | ( <expr> )
          | <id>
```

- Multiple parse trees are possible for `A = B + C * A`

![ambiguous parse tree](https://snag.gy/u6XOPA.jpg)

### Resolving ambiguity with operator precedence

- The order of precedence for operators can be determined via the parse tree
  - The lower an operator appears in the tree, the higher the precedence it has
    - Since it must be evaluated first
- A badly written and/or ambiguous grammar will not enforce operator precedence
- By using a few more rules, grammars can be written so that operator precedence is enforced
  - And is unambiguous
- This is achieved by creating rules that establish a clear hierarchy of operators
  - Ensuring that certain operators must appear above others in resulting parse trees

#### Operator precedence example

- This grammar is functionally equivalent to the previous one, but not ambiguous and it enforces operator precedence

```
// establishes order of precedence
// <id> then ()  then * then +
<assign> -> <id> = <expr>
<id>     -> A | B | C
<expr>   -> <expr> + <term>   // <expr> is either + or <term>
          | <term>
<term>   -> <term> * <factor> // <term> is either * or <factor> 
          | <factor>
<factor> -> ( <expr> )        // <factor> is either () or <id>
          | <id>
```

#### Unambiguous parse tree for `A = B + C * A`

![unambiguous parse tree](https://snag.gy/1Tkzer.jpg)

# Extended Backus-Naur Form (EBNF)

- Extended versions of BNF exist
- To improve readability/writeability
- Three common features
  - Involve **meta-symbols**
  - Not terminals which appear in syntax being described
  - Part of the EBNF notation
- If meta-symbol is actually required as terminal part of other syntax
  - Terminal instances can be denoted/escaped with underline or quotation marks

## Feature 1: Optionals with `[]`

- Brackets used for optional parts

```
// BNF
<if_stmt> -> if ( <logic_expr> ) <stmt>
           | if ( <logic_expr> ) <stmt> else <stmt>

// EBNF
<if_stmt> -> if ( <logic_expr> ) <stmt> [else <stmt>]
```

## Feature 2: Iterations with `{}`

- Braces used for iterative parts

```
// BNF
<ident_list> -> identifier
              | identifier, <ident_list>

// EBNF
<ident_list> -> identifier {, identifier}
```

- Anything inside the braces can be repeated **zero or more** times
- Replaces recursive from BNF

## Feature 3: Choices with `( | )`

- Parenthesis and pipes used for choice

```
// BNF
<term> -> <term> * <factor>
        | <term> / <factor>
        | <term> % <factor>

// EBNF
<term> -> <term> ( * | / | % ) <factor>
```

- All choices are placed between `()`, delimited by `|`

## BNF vs. EBNF comparison

- This grammar describes a language to control a set of lights

```
// BNF
<program>   -> begin <inst_list> end
<inst_list> -> <inst>
             | <inst> then <inst_list>
<inst>      -> on <light_set>
             | off <light_set>
             | <flash>
<flash>     -> flash <light_set>
             | flash <light_set> fast
             | flash <light_set> slow
<light_set> -> <light>
             | <light> and <light_set>
<light>     -> red | orange | green

// EBNF
<program>   -> begin <inst_list> end
<inst_list> -> <inst> {then <inst>} // {} for iteration
<inst>      -> (on|off) <light_set> // (|) for choice
             | <flash>
<flash>     -> flash <light_set> [(fast|slow)] // [(|)] for optional choice
<light_set> -> <light> {and <light>}
<light>     -> red | orange | green
```

## Reducing grammar with EBNF

- It is possible to perform further reduction
- As long as readability and meaning is maintained, rules can be merged

```
<program>   -> begin <inst> {then <inst>} end
<inst>      -> (on|off) <light_set>
             | flash <light_set> [(fast|slow)]
<light_set> -> <light> {and <light>}
<light>     -> red | orange | green
```

# Static semantics

- Some aspects of a language are difficult/impossible to effectively describe in BNF or EBNF
- Example
  - Type compatibility
    - Mixing int and float in an expression
  - The need to declare a variable before using it
- To describe these things, we need **static semantics**
  - Despite the term **semantics**, this is about syntax
    - Not meaning
  - Further defines the legal forms of programs in a language
  - Extension of a context free grammar
  - Often concerned with checking type constraints
- **Attribute grammars** are a formal approach to describing and checking static semantics rules in a program

## Attribute grammars

- An attribute grammar is a context free grammar with

### Attributes

- Variables associated with terminal and non terminal symbols in the grammar
- They store information about each instance of the symbols

### Attribute computation functions

- Functions associated with grammar rules
  - Used to determine the values of the attributes
- Also known as **semantic functions**

### Predicate functions

- Boolean statements that state the static semantic rules of the language
  - Associated with grammar rules
- Must be true for a program to be valid

## Attribute grammar example

```
// Simple BNF
<assign> -> <var> = <expr>
<expr>   -> <var> + <var>
<var>    -> A | B | C
```

- Rules not depicted in BNF
  - Variable types can be either `int` or `float`
  - If two of the same type are added, the result is the same type
    - `int + int = int`
    - `float + float = float`
  - If two different types are added, the result is `float`
  - The type on the left side of an assignment statement must match the right side
    - Can't assign `float` to an `int` and vice versa
- The attributes we have declared are
  - `actual_type`
    - Stores the actual type of `<var>` or `<expr>`
  - `expected_type`
    - Stores the expected type of an `<expr>`
    - Determined by the `actual_type` of the left side of `<assign>`
- Grammar with semantic functions and predicates

```
<assign>             -> <var> = <expr>
<expr>.expected_type <- <var>.actual_type    // semantic function 1
<expr>               -> <var>[1] + <var>[2]  // repeat occurrences disambiguated with subscript
<expr>.actual_type   <- IF <var>[1] and <var>[2] ARE BOTH int, THEN
  int,
ELSE
  float                                      // semantic function 2
<expr>.actual_type   == <expr>.expected_type // predicate
<var>                -> A | B | C
<var>.actual_type    <- LOOKUP(<var>.string) // semantic function 3
```

- We have two attributes
  - Both store `int` or `float`
- The `actual_type` attribute is associated with `<var>` and `<expr>`
- In the case of `<var>`
  - The actual type is determined by the type of the actual instance of the variable
- In the case of `<expr>`
  - The actual type is determined by the types of the variables that the expression involves
  - ie. If the expression involves `int + float`
    - The `actual_type` of `<expr>` will be float

### Semantic function 1

- It says that the expected type of an expression is the same as the type of the variable it is being assigned to
- ie. If assigning the result of an expression to an `int`
  - It expects the result of the addition to be `int`

### Semantic function 2

- If both variables are `int`
  - The `actual_type` is `int`
- Else the `actual_type` is `float`

### Predicate

- The `actual_type` of an expression must be the same as the `expected_type`
- The `expected_type` is set based on the type of variable that the expression is being assigned to
  - See semantic function 1

### Semantic function 3

- Sets the type of `<var>`
- Uses function that looks up the type in the symbol table based on the name of the variable

### Example parse tree

- Testing the validity of `A = A + B` using attribute grammar

![parse tree](https://snag.gy/i0py5Q.jpg)
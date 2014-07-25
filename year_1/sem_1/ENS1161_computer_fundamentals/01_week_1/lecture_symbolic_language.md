# ENS1161 Lecture 1

## Propositions and Connectives

Propositions are statements that are either `true` or `false`.

- `p` = file is being printed
- `q` = system is ready
- `r` = red light is on

Compound propositions are built from simple connectives (aka operators) like in the example below.

- `~` = `not`
- `˄` = `and`
- `˅` = `or`
- `→` = `then`

### Examples of compound propositions

- If the system is ready and red light is on, then file is printed

	- `(q ˄ r) → p`

- If the file is not printed then either the red light is not on or the system is not ready

	- `~p → (~r ˅ ~q)`

- Either the red light is on and the file is printed or else the system is not ready

	- `(r ˄ p) ˅ ~q`

## Truth Tables

Show all possible combinations of the simple propositions and corresponding truth values of the compound proposition.

- truth value of `1` = `true`
- truth value of `0` = `false`

To be able to use truth tables as an important tool, we need to first define connectives.

## The `NOT` Connective

`NOT` is the simplest operation denoted by the `~` symbol.

`~p` is read as `not p` or `p is not true`.

For example, if `p = today is saturday`, then `~p = it is not true that today is Saturday`. Or in simpler english `Today is not Saturday`.

Other examples:

- `p: 3 + 4 = 7` or `~p: 3 + 4 ≠ 7`
- `q: it is raining` or `~q: it is not raining`
- `r: 8 > 15` or `~r: 8 ≤ 15`

#### `NOT` Truth Table Example

|  p  |  ~p  |
|:---:|:----:|
| 0   | 1    |
| 1   | 0    |


## The `AND` Connective

`AND` or `p ˄ q` is read as `p and q`

`AND` carries with it the expectation of both.

#### `AND` Truth Table Example

| p | q | p ˄ q |
|:-:|:-:|:-----:|
| 0 | 0 | 0     |
| 0 | 1 | 0     |
| 1 | 0 | 0     |
| 1 | 1 | 1     |

An `AND` statement is `true` if both parts are true, otherwise it is `false`.

## The `OR` Connective

`OR` or `p ˅ q` is read as `p or q`

An `OR` statement is `true` if at least one part is `true`, and it is also `true` if both parts are `true`.

#### `OR` Truth Table Example

| p | q | p ˅ q |
|:-:|:-:|:-----:|
| 0 | 0 | 0     |
| 0 | 1 | 1     |
| 1 | 0 | 1     |
| 1 | 1 | 1     |

An `OR` statement is `false` if both parts are `false`; otherwise it is `true`.

## Compound Propositions Exercises

Define the following propositions:

- `p` = Peter is driving his own car
- `a` = Andrew is late
- `m` = Max has caught the bus

**Translate a compound proposition below into symbolic notation:**
>Either Peter is driving his own car and Andrew is late, or else Max has not caught the bus.

#### Answer

`(p ˄ a) ˅ ~m`

**Translate the following into simple english:**

`m ˄ (~p ˅ ~a)`

#### Answer

>Max has caught the bus and either Peter is not driving his own car, or Andrew is not late.

## Truth Tables for Compound Propositions

Construct the truth table for `p ˄ (q ˅ ~r)`.
There are 8 possible combinations for each proposition. The formula is:

`x = number of propositions; y = number of outcomes (which is two, 0 or 1)`

`x^y = number of possible combinations`

**Step 1:**
Build the table and list all the possible combinations for the number of existing propositions.

| p | q | r | ~r | q ˅ ~r | p ˄ (q ˅ ~r) |
|:-:|:-:|:-:|:--:|:------:|:------------:|
| 0 | 0 | 0 |    |        |              |
| 0 | 0 | 1 |    |        |              |
| 0 | 1 | 0 |    |        |              |
| 0 | 1 | 1 |    |        |              |
| 1 | 0 | 0 |    |        |              |
| 1 | 0 | 1 |    |        |              |
| 1 | 1 | 0 |    |        |              |
| 1 | 1 | 1 |    |        |              |

**Step 2:**
Fill column by column according to relation defined for the particular column.

| p | q | r | ~r | q ˅ ~r | p ˄ (q ˅ ~r) |
|:-:|:-:|:-:|:--:|:------:|:------------:|
| 0 | 0 | 0 | 1  |        |              |
| 0 | 0 | 1 | 0  |        |              |
| 0 | 1 | 0 | 1  |        |              |
| 0 | 1 | 1 | 0  |        |              |
| 1 | 0 | 0 | 1  |        |              |
| 1 | 0 | 1 | 0  |        |              |
| 1 | 1 | 0 | 1  |        |              |
| 1 | 1 | 1 | 0  |        |              |

**Step 3:**
Continue filling the columns.

| p | q | r | ~r | q ˅ ~r | p ˄ (q ˅ ~r) |
|:-:|:-:|:-:|:--:|:------:|:------------:|
| 0 | 0 | 0 | 1  | 1      |              |
| 0 | 0 | 1 | 0  | 0      |              |
| 0 | 1 | 0 | 1  | 1      |              |
| 0 | 1 | 1 | 0  | 1      |              |
| 1 | 0 | 0 | 1  | 1      |              |
| 1 | 0 | 1 | 0  | 0      |              |
| 1 | 1 | 0 | 1  | 1      |              |
| 1 | 1 | 1 | 0  | 1      |              |

**Step 4:**
Fill in final column.

| p | q | r | ~r | q ˅ ~r | p ˄ (q ˅ ~r) |
|:-:|:-:|:-:|:--:|:------:|:------------:|
| 0 | 0 | 0 | 1  | 1      | 0            |
| 0 | 0 | 1 | 0  | 0      | 0            |
| 0 | 1 | 0 | 1  | 1      | 0            |
| 0 | 1 | 1 | 0  | 1      | 0            |
| 1 | 0 | 0 | 1  | 1      | 1            |
| 1 | 0 | 1 | 0  | 0      | 0            |
| 1 | 1 | 0 | 1  | 1      | 1            |
| 1 | 1 | 1 | 0  | 1      | 1            |

>Use data in previous columns to determine proposition of current column

## Tautologies and Contradictions

A proposition that is true for every combination of truth value is called a tautology.

The proposition `(p ˅ q) ˅ (~p ˄ ~q)` is a tautology.

**Step 1:**

| p | q | p ˅ q | ~p ˄ ~q | (p ˅ q) ˅ (~p ˄ ~q) |
|:-:|:-:|:-----:|:-------:|:-------------------:|
| 0 | 0 |       |         |                     |
| 0 | 1 |       |         |                     |
| 1 | 0 |       |         |                     |
| 1 | 1 |       |         |                     |

**Step 2:**

| p | q | p ˅ q | ~p ˄ ~q | (p ˅ q) ˅ (~p ˄ ~q) |
|:-:|:-:|:-----:|:-------:|:-------------------:|
| 0 | 0 | 0     | 1       | 1                   |
| 0 | 1 | 1     | 0       | 1                   |
| 1 | 0 | 1     | 0       | 1                   |
| 1 | 1 | 1     | 0       | 1                   |

A proposition that is false for every possible combination of truth values is called a contradiction.

The proposition `(p ˄ q) ˄ (~p ˅ ~q)` is a contradiction.

| p | q | p ˄ q | ~p ˅ ~q | (p ˄ q) ˄ (~p ˅ ~q) |
|:-:|:-:|:-----:|:-------:|:-------------------:|
| 0 | 0 | 0     | 1       | 0                   |
| 0 | 1 | 0     | 1       | 0                   |
| 1 | 0 | 0     | 1       | 0                   |
| 1 | 1 | 1     | 0       | 0                   |

## Logical Equivalence

We often have different, but equivalent, logical expressions. To determine whether two given propositions have exactly the same logical meaning, we use a truth table to check it. 

Logical equivalence is denoted by the `≡` symbol.

Create a truth table for the following compound proposition.

`~p ˄ (p ˅ ~q) ≡ ~(p ˅ q)`

| p | q | ~p | ~q | p ˅ ~q | ~p ˄ (p ˅ ~q) | p ˅ q | ~(p ˅ q) |
|:-:|:-:|:--:|:--:|:------:|:-------------:|:-----:|:--------:|
| 0 | 0 | 1  | 1  | 1      | 1             | 0     | 1        |
| 0 | 1 | 1  | 0  | 0      | 0             | 1     | 0        |
| 1 | 0 | 0  | 1  | 1      | 0             | 1     | 0        |
| 1 | 1 | 0  | 0  | 1      | 0             | 1     | 0        |

The truth table shows that `~p ˄ (p ˅ ~q)` and `~(p ˅ q)` are logically equivalent.

## The Negation of an `AND` Statement

One of `de Morgan's laws` define the negation of an `AND` statement.

`NOT(p AND q) ≡ NOT p OR NOT q`

`~(p ˄ q) ≡ ~p ˅ ~q`

| p | q | p ˄ q | ~(p ˄ q) | ~p | ~q | ~p ˅ ~q |
|:-:|:-:|:-----:|:--------:|:--:|:--:|:-------:|
| 0 | 0 | 0     |  1       | 1  | 1  | 1       |
| 0 | 1 | 0     |  1       | 1  | 0  | 1       |
| 1 | 0 | 0     |  1       | 0  | 1  | 1       |
| 1 | 1 | 1     |  0       | 0  | 0  | 0       |

## The Negation of an `OR` Statement

The second of `de Morgan's laws`.

`NOT(p OR q) ≡ NOT p AND NOT q`

`~(p ˅ q) ≡ ~p ˄ ~q`

| p | q | p ˅ q | ~(p ˅ q) | ~p | ~q | ~p ˄ ~q |
|:-:|:-:|:-----:|:--------:|:--:|:--:|:-------:|
| 0 | 0 | 0     |  1       | 1  | 1  | 1       |
| 0 | 1 | 1     |  0       | 1  | 0  | 0       |
| 1 | 0 | 1     |  0       | 0  | 1  | 0       |
| 1 | 1 | 1     |  0       | 0  | 0  | 0       |

## Laws of Propositional Logic

We frequently need to simplify logical expressions or to check whether given logical expressions are logically equivalent. One way to simplify expressions is to use the laws of logic.

For our purposes, the most important laws are the `distributive laws` and `de Morgan's laws`.

| Distributive Laws                | De Morgan's Laws     |
|----------------------------------|----------------------|
| `p ˅ (q ˄ r) = (p ˅ q) ˄ (p ˅ r)`| `~(p ˅ q) = ~p ˄ ~q` |
| `p ˄ (q ˅ r) = (p ˄ q) ˅ (p ˄ r)`| `~(p ˄ q) = ~p ˅ ~q` |
| **Alternate Symbols**            |                      |
| `p + q • r = (p + q) • (p + r)`  | `(p + q)' = p' • q'` |
| `p • (q + r) = p • q + p • r`    | `(p • q)' = p' + q'` |

## Conditional Statements

In computing we often use conditional statements in the form `if... then...`. In other words, if particular conditions are satisfied, then certain consequences should follow.

A proposition of the form `if p then q` is called a conditional statement, and is represented by `p → q`.

The symbolic statement is usually read as `if p then q` or perhaps as `p implies q`.

For condition `true → false` is false; the other combinations are true.

| p | q | p → q |
|:-:|:-:|:-----:|
| 0 | 0 | 1     |
| 0 | 1 | 1     |
| 1 | 0 | 0     |
| 1 | 1 | 1     |

## The Negation of a Conditional Statement

The negation of conditional `p → q` is:

`~(p → q) ≡ p ˄ ~q`

| p | q | p → q | ~(p → q) | p | ~q | p ˄ ~q |
|:-:|:-:|:-----:|:--------:|:-:|:--:|:------:|
| 0 | 0 | 1     | 0        | 0 | 1  | 0      |
| 0 | 1 | 1     | 0        | 0 | 0  | 0      |
| 1 | 0 | 0     | 1        | 1 | 1  | 1      |
| 1 | 1 | 1     | 0        | 1 | 0  | 0      |

The conditional `p → q` and its contra-positive `~q → ~p` are logically equivalent.

`p → q ≡ ~q → ~p`

>Compliment of `if` statement produces compound proposition without `if`. A compliment statement that includes an `if` should not contain `if`. Must maintain correct order in `if` statement.

## The Converse of a Conditional Statement

`p → q` is a conditional statement, its converse is `q → p`. These two statements may look similar, bu there is no logical connections.

**The two statements are completely independent of each other.**

One of the most common errors in logic is to confuse a conditional statement and its converse.

**There is no logical connection between:**

`p → q AND q → p`

## Truth Table Examples

Construct truth tables for the following proposition:

`((p ˄ ~q) → r) ˄ (~p → ~r)`

| p | q | r | ~q | p ˄ ~q | (p ˄ ~q) → r | ~p | ~r | ~p → ~r | ((p ˄ ~q) → r) ˄ (~p → ~r) |
|:-:|:-:|:-:|:--:|:------:|:------------:|:--:|:--:|:-------:|:--------------------------:| 
| 0 | 0 | 0 | 1  | 0      | 1            | 1  | 1  | 1       | 1                          |
| 0 | 0 | 1 | 1  | 0      | 1            | 1  | 0  | 0       | 0                          |
| 0 | 1 | 0 | 0  | 0      | 1            | 1  | 1  | 1       | 1                          |
| 0 | 1 | 1 | 0  | 0      | 1            | 1  | 0  | 0       | 0                          |
| 1 | 0 | 0 | 1  | 1      | 0            | 0  | 0  | 1       | 0                          |
| 1 | 0 | 1 | 1  | 1      | 1            | 0  | 0  | 1       | 1                          |
| 1 | 1 | 0 | 0  | 0      | 1            | 0  | 1  | 1       | 1                          |
| 1 | 1 | 1 | 0  | 0      | 1            | 0  | 0  | 1       | 1                          |

The last column is the truth table for `((p ˄ ~q) → r) ˄ (~p → ~r)`

Use a truth table to show that `p ˄ (q ˅ r) ≡ (p ˄ q) ˅ (p ˄ r)`

| p | q | r | q ˅ r | p ˄ (q ˅ r) | p ˄ q | p ˄ r | (p ˄ q) ˅ (p ˄ r) |
|:-:|:-:|:-:|:-----:|:-----------:|:-----:|:-----:|:-----------------:|
| 0 | 0 | 0 | 0     | 0           | 0     | 0     | 0                 |
| 0 | 0 | 1 | 1     | 0           | 0     | 0     | 0                 |
| 0 | 1 | 0 | 1     | 0           | 0     | 0     | 0                 |
| 0 | 1 | 1 | 1     | 0           | 0     | 0     | 0                 |
| 1 | 0 | 0 | 0     | 0           | 0     | 0     | 0                 |
| 1 | 0 | 1 | 1     | 1           | 0     | 1     | 1                 |
| 1 | 1 | 0 | 1     | 1           | 1     | 0     | 1                 |
| 1 | 1 | 1 | 1     | 1           | 1     | 1     | 1                 |

Column for `p ˄ (q ˅ r)` and `(p ˄ q) ˅ (p ˄ r)` are identical proving that `p ˄ (q ˅ r) ≡ (p ˄ q) ˅ (p ˄ r)` is `true`.

## Compound Propositions Example

**Define the following propositions:**

- `s` = Sue is a geologist
- `a` = Anne sells insurance
- `m` = Mary teaches music

**Convert the following english sentence into a compound proposition:**

- If Mary teaches music then Sue is a geologist and Anne does not sell insurance.
    -  **Answer:** `m → s ˄ ~a`

- Translate into simple english: `~s → (~m ˄ ~a)`
    - **Answer:** If Sue is not a geologist then Mary does not teach music and Anne does not sell insurance.

Use `de Morgan's laws` to find the negation of each of the following statements. Give your answers in simple English.

- Peter has long hair and he is not wearing a coat.
    - **Answer:** Either Peter does not have long hair or else he is wearing a coat.
    
- David plays guitar and likes tennis
    - **Answer:** David does not play guitar or else he does not like tennis.
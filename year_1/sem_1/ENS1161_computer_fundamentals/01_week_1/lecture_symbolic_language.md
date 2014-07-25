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
|-----|------|
| 0   | 1    |
| 1   | 0    |


## The `AND` Connective

`AND` or `p ˄ q` is read as `p and q`

`AND` carries with it the expectation of both.

#### `AND` Truth Table Example

| p | q | p ˄ q |
|---|---|-------|
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
|---|---|-------|
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
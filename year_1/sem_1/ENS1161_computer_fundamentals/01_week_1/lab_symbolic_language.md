# Conditional statement

if p:1 then q:0 | 0
all other statements will be 1

order is important. if q:1 then p:0 is different.

# Negation of conditional statement

~ means to flip to opposite.

Write down all forms of laws that are shown for future reference.

# Exercises Set 1

## 1. Define the following propositions:

- `p`: Peter is driving his own car
- `a`: Andrew is late
- `m`: Max has caught the bus

### A: Write each of the following in symbols.

1. Andrew is late and Peter is driving his own car.
	- `a ˄ p`
2. Either Max has caught the bus or else Andrew is late.
	- `m ˅ a`
3. Either Peter is driving his own car and Andrew is late or else Max has not caught the bus.
	- `(p ˄ a) ˅ ~m`
4. Peter is driving his own car and either Andrew is late or else Max has caught the bus.
	- `p ˄ (a ˅ m)`
5. Max has caught the bus and Andrew is not late.
	- `m ˄ ~a`

### B: Translate into simple English.

1. `(a ˄ p) ˅ (~a ˄ m)`
	- Either Andrew is late and Peter is driving or else Andrew is not late and Max caught the bus.
2. `p ˅ (~m ˄ ~a)`
	- Either Peter is driving or else Max did not catch the bus and Andrew is not late.
3. `m ˄ (~p ˅ ~a)`
	- Max caught the bus and either Peter is not driving or Andrew is not late.
4. `p ˄ m ˄ a`
	- Peter is driving and Max caught the bus and Andrew is late.
5. `(~a ˄ p) ˅ m`
	- Either Andrew is not late and Peter is driving or else Max caught the bus.

> When translating from compound propositions to plain English, use **EITHER** when parentheses or **OR** are used.

## 2. Construct truth tables for the following propositions:

**1:** `(p ˅ ~q) ˄ (~p ˅ q)` 

| p | q | p ˅ ~q | ~p ˅ q | (p ˅ ~q) ˄ ( ~p ˅ q) |
|:-:|:-:|:------:|:------:|:--------------------:|
| 0 | 0 | 1      | 1      | 1                    |
| 1 | 0 | 1      | 0      | 0                    |
| 0 | 1 | 0      | 1      | 0                    |
| 1 | 1 | 1      | 1      | 1                    |

**2:** `(q ˄ ~r) ˅ (~p ˄ r)`

| q | r | p | q ˄ ~r | ~p ˄ r | (q ˄ ~r) ˅ (~p ˄ r) |
|:-:|:-:|:-:|-------:|:------:|:-------------------:|
| 0 | 0 | 0 | 0      | 0      | 0                   |
| 0 | 0 | 1 | 0      | 0      | 0                   |
| 0 | 1 | 0 | 0      | 1      | 1                   |
| 0 | 1 | 1 | 0      | 0      | 0                   |
| 1 | 0 | 0 | 1      | 0      | 1                   |
| 1 | 0 | 1 | 1      | 0      | 1                   |
| 1 | 1 | 0 | 0      | 1      | 1                   |
| 1 | 1 | 1 | 0      | 0      | 0                   |

**3:** `((p ˄ ~q) → r) ˄ (~p → ~r)`

| p | q | r | p ˄ ~q | (p ˄ ~q) → r | ~p → ~r | ((p ˄ ~q) → r) ˄ (~p → ~r) |
|:-:|:-:|:-:|:------:|:------------:|:-------:|:--------------------------:|
| 0 | 0 | 0 | 0      | 1            | 1       | 1                          |
| 0 | 0 | 1 | 0      | 1            | 0       | 0                          |
| 0 | 1 | 0 | 0      | 1            | 1       | 1                          |
| 0 | 1 | 1 | 0      | 1            | 0       | 0                          |
| 1 | 0 | 0 | 1      | 0            | 1       | 0                          |
| 1 | 0 | 1 | 1      | 1            | 1       | 1                          |
| 1 | 1 | 0 | 0      | 1            | 1       | 1                          |
| 1 | 1 | 1 | 0      | 1            | 1       | 1                          |

### Takeaway:

When constructing truth tables for conditional statements, think of the *conclusion* as a promise. For example 

>If you eat vegetables, then you will be healthy 

The statement above is represented by `a → b`. `a` is the hypothesis, and `b` is the conclusion. The **only** way `a → b` is `false`, is when `a` is `true` but `b`, the conclusion is `false`. Any other condition will be `true`. I found it a lot easier to comprehend by thinking of it in this sense.

>I ate vegetables, but did not become healthy. 

The promise to be healthy was violated, thus making `a → b` false.

Check out this great [video](http://youtu.be/2npo-L0DJRQ) that explains it a lot better.  

**4:** `((r → (q → p)) ^ ~p) → ~r`

| r | q | p | q → p | r → (q → p) | (r → (q → p)) ˄ ~p | ((r → (q → p)) ˄ ~p) → ~r |
|:-:|:-:|:-:|:-----:|:-----------:|:------------------:|:-------------------------:|
| 0 | 0 | 0 | 1     | 1           | 1                  | 1                         |
| 0 | 0 | 1 | 1     | 1           | 0                  | 1                         |
| 0 | 1 | 0 | 0     | 1           | 1                  | 1                         |
| 0 | 1 | 1 | 1     | 1           | 0                  | 1                         |
| 1 | 0 | 0 | 1     | 1           | 1                  | 0                         |
| 1 | 0 | 1 | 1     | 1           | 0                  | 1                         |
| 1 | 1 | 0 | 0		| 0           | 0                  | 1                         |
| 1 | 1 | 1 | 1     | 1           | 0                  | 1                         |

### Takeaway:

When plotting values for base propositions, ie. `p` or `r`, use binary to order the combinations. Plotting the negation may also be useful, try it with other exercises to see if it helps and speeds up the process. Also try writing these out, to get used to it for the exam.

## 3. Tautologies and Contradictions

### A: Use a truth table to show that `(p ˅ q) ˅ (~p ˄ ~q)` is a tautology.

| p | q | ~p | ~q | p ˅ q | ~p ˄ ~q | (p ˅ q) ˅ (~p ˄ ~q) |
|:-:|:-:|:--:|:--:|:-----:|:-------:|:-------------------:|
| 0 | 0 | 1  | 1  | 0     | 1       | 1                   |
| 0 | 1 | 1  | 0  | 1     | 0       | 1                   |
| 1 | 0 | 0  | 1  | 1     | 0       | 1                   |
| 1 | 1 | 0  | 0  | 1     | 0       | 1                   |

Truth table shows `(p ˅ q) ˅ (~p ˄ ~q)` is a tautology since all possible outcomes are `true`.

### B: Use a truth table to show that `~(p ˅ q) ˄ p` is a contradiction.

| p | q | p ˅ q | ~(p ˅ q) | ~(p ˅ q) ˄ p |
|:-:|:-:|:-----:|:--------:|:------------:|
| 0 | 0 | 0     | 1        | 0            |
| 0 | 1 | 1     | 0        | 0            |
| 1 | 0 | 1     | 0        | 0            |
| 1 | 1 | 1     | 0        | 0            |

Truth table shows `~(p ˅ q) ˄ p` is a contradiction since all possible outcomes are `false`.

## 4. Is it true that, if a given proposition is **not** a contradiction, then it must be a tautology? Explain.

Above statement is not true. Just because a proposition is **not** a contradiction, it doesn't automatically mean that **all** values in its truth table would be `1`. After constructing the proposition's truth table, it is possible to find that it is a tautology, but a proposition does not automatically become a tautology just because it is not a contradiction.

**The answer, per solutions sheet:**
>No, it is not true. If a proposition is a contradiction, then all values in its truth table are `0`. So if it is not a contradiction then not all values in its truth table are `0`, so there must be at least one value that is not `0`. This does not mean that all values are non-zero. If a proposition is not a contradiction, then it could be a tautology, but it might not be a tautology either.

## 5. Use a truth table to show that `p ˄ (q ˅ r) ≡ (p ˄ q) ˅ (p ˄ r)`

| p | q | r | ~p | ~q | q ˅ r | p ˄ (q ˅ r) | p ˄ q | p ˄ r | (p ˄ q) ˅ (p ˄ r) |
|:-:|:-:|:-:|---:|:--:|:-----:|:-----------:|:-----:|:-----:|:-----------------:|
| 0 | 0 | 0 | 1  | 1  | 0     | 0           | 0     | 0     | 0                 |
| 0 | 0 | 1 | 1  | 1  | 1     | 0           | 0     | 0     | 0                 |
| 0 | 1 | 0 | 1  | 0  | 1     | 0           | 0     | 0     | 0                 |
| 0 | 1 | 1 | 1  | 0  | 1     | 0           | 0     | 0     | 0                 |
| 1 | 0 | 0 | 0  | 1  | 0     | 0           | 0     | 0     | 0                 |
| 1 | 0 | 1 | 0  | 1  | 1     | 1           | 0     | 1     | 1                 |
| 1 | 1 | 0 | 0  | 0  | 1     | 1           | 1     | 0     | 1                 |
| 1 | 1 | 1 | 0  | 0  | 1     | 1           | 1     | 1     | 1                 |

The truth table shows that the outcomes for `p ˄ (q ˅ r)` and `(p ˄ q) ˅ (p ˄ r)` are the same. 

The statement `p ˄ (q ˅ r) ≡ (p ˄ q) ˅ (p ˄ r)` is `true`.

## 6. Use a truth table to show that `p ˅ (q ˄ r) ≡ (p ˅ q) ˄ (p ˅ r)`

| p | q | r | q ˄ r | p ˅ (q ˄ r) | p ˅ q | p ˅ r | (p ˅ q) ˄ (p ˅ r) |
|:-:|:-:|:-:|:-----:|:-----------:|:-----:|:-----:|:-----------------:|
| 0 | 0 | 0 | 0     | 0           | 0     | 0     | 0                 |
| 0 | 0 | 1 | 0     | 0           | 0     | 1     | 0                 |
| 0 | 1 | 0 | 0     | 0           | 1     | 0     | 0                 |
| 0 | 1 | 1 | 1     | 1           | 1     | 1     | 1                 |
| 1 | 0 | 0 | 0     | 1           | 1     | 1     | 1                 |
| 1 | 1 | 0 | 0     | 1           | 1     | 1     | 1                 |
| 1 | 1 | 1 | 1     | 1           | 1     | 1     | 1                 |

The truth table shows that the outcomes for `p ˅ (q ˄ r)` and `(p ˅ q) ˄ (p ˅ r)` are the same.

The statement `p ˅ (q ˄ r) ≡ (p ˅ q) ˄ (p ˅ r)` is `true`.

## 7. Use a truth table to show that `~p ˄ (p ˅ ~q) ≡ ~(p ˅ q)`

| p | q | ~p | ~q | p ˅ ~q | ~p ˄ (p ˅ ~q) | p ˅ q | ~(p ˅ q) |
|:-:|:-:|:--:|:--:|:------:|:-------------:|:-----:|:--------:|
| 0 | 0 | 1  | 1  | 1      | 1             | 0     | 1        |
| 0 | 1 | 1  | 0  | 0      | 0             | 1     | 0        |
| 1 | 0 | 0  | 1  | 1      | 0             | 1     | 0        |
| 1 | 1 | 0  | 0  | 1      | 0             | 1     | 0        |

The truth table shows that the outcomes for `~p ˄ (p ˅ ~q)` and `~(p ˅ q)` are the same.

The statement `~p ˄ (p ˅ ~q) ≡ ~(p ˅ q)` is `true`.

## 8. Bill tried for a job where the requirement was that you must have a B-class licence and be over 20 years of age. He failed to meet the requirement. What conclusion can we draw?

- `b` = Has B-class licence
- `y` = Over 20 years old
- `j` = Bill got the job

~(b ˄ y) → ~j

**The answer, per solutions sheet:**
>Either he did not have a B-class licence or else he was not over 20 years of age (or perhaps both) 

### Takeaway: 

Question did not ask to convert to compound proposition, so answer in plain English.

## 9. Suzie applied for a position on the next Antarctic expedition. You could get a place if you were a qualified mechanic or a biologist. She didn't have the necessary training. What conclusion can we draw?

Suzie will not get the job because she either isn't a qualified mechanic or a biologist.

**The answer, per solutions sheet:**
>She was not a mechanic and she was not a biologist. Or, more concisely 'she was neither a mechanic nor a biologist'.

### Takeaway: 

The question never specified which training Suzie didn't have, so how can it be assumed that she was not a biologist `AND` not a mechanic? See `symbolic_language.todo`.

## 10.



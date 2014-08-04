# ENS1161 Lecture 2

# Predicates and Sets

## Predicates and Propositions

A predicate is a statement with one or more variables. If we assign values to the variables then the statement becomes a propositon, and has a truth value.

For example:

- `7 > 20` is a proposition and `x > 20` is a predicate
- `Peter owns 3 cats` is a proposition and `x owns y cats` is a predicate

More examples:
- If we define `P(x): "x + 5 = 12"` then `P(3)` is `false` and `P(7)` is `true`
- If we define `Q(x, y): "the name x has y letters"`, then `Q(John, 4)` is `true` and `Q(Sam, 8)` is `false`
- If we define `C(x, y): "x us the ASCII code for y"`, then `C(36, $)` is `true` and `C(90, A)` is `false`

## Set Notation

A set is a collection of things, usually (but not necssarily) sharing some common attribute.

- `P = set of all people in the room`
- `A = set of all letters in the alphabet`

In maths we have some special sets of numbers.

- `R` denotes the set of all real numbers (decimal or floats).
- `N` dennotes the set of all natural numbers (integers).

We use `∈` to denote **membership** of a set. The `∈` symbol is read "is a member of" or "is an element of" or "belogs to"

Examples:

- `g ∈ A`
- `11 ∈ N`
- `% ∉ A`
- `2.5 ∉ N`

## Quantifiers

Instead of substituting particular values for the variables in **predicate**, we may be able to make a more general statement by using a quantifier. We will use two quantifiers:
- The **universal** quantifier `∀`
- The **existential** quantifier `∃`

### Universal Quanitifier

The **universal quantifier** `∀` is used for statements like:

- "All do..."
- "All are..."
- "None do..."
- "None are..."

Example:

- Consider the predicate `Q(x): (x < 5) ˅ (x ≥ 5) This is true for all real numbers.` 
	- So we can say: `For all real numbers x, Q(x)`.
	- We can use the symbol `∀` which means "for all" or "for every", and write the following

```
∀x ∈ R, Q(x)
```

Which is translated as "for every `x` that is a member of `real numbers`, `Q(x)`".

- If `P =  set of people in this room`
	- and `C(x): x likes chocolate`
	- `∀x ∈, C(x)` means "Everybody in this room likes chocolate."
	- If `D(x): x likes going to the dentist`
	- `∀x ∈ P, ~D(x)` means "Nobody in this room likes going to the dentist."

### Existential Quantifier

The **existential quantifier** `∃` is used for statements like:

- "Some do..."
- "Some don't.."
- "There exists.."
- "There is at least one..."
- "For some..."

Examples:

- If `I(x): x speaks Italian` and if `P = set of people in the room`
	- then `∃x ∈ P, I(x)`
	- Which translates to "There is at least one person in this room who speaks Italian."
	- or `∃x ∈ P, ~I(x)`
	- Which translates to "There is at least one person in this room who does not speak Italian."
- If `S(x): (x > 2) ˄ (x < 7)`
	- then `∃x ∈ N, S(x)`
	- Which translates to "There is at least one natural number that is bigger than 2 and less than 7."

## Negation of `∀`

The negation of `∀` gives an `∃`

Example:

- Consider the statement "All swans are black."
	- Define the set: `S = set of swans`
	- Define the predicate: `B(x): swan x is black`
	- The statement becomes: `∀x ∈ S, B(x)`
- The negation of the above statement is "Some swans are not black."
	- Which becomes `∃x ∈ Sm ~B(x)` in symbols. It could be translated to English in various ways including:
		- "It is true that not all swans are black."
		- "There is at least one swan that is not black."
- So we have `~(∀x ∈ S, B(x)) ≡ ∃x ∈ Sm ~B(x)`
- Notice that the **negation** of `∀` gives an `∃`
	- Or in other words:
		- The opposite of "All do" is "Some do not"
		- The opposite of "All are" is "Some are not"

More Examples:

Consider the following set of strings of digits:

- a: 171095946644741945
- b: 605902976190243621
- c: 354559987164464731
- d: 319644307182580295
- e: 159367451305908388
- f: 137255178469493869
- g: 258220617871305195 *
- h: 620096821201763239 *

Now consider the claim: "Each of the strings includes the digit 4."

Is this true?

There is (at least one) string that does not have a 4.

- `S = {a, b, c, d, e, f, g, h}` defines the set of strings.
- `P(x): string x contains the digit 4` defines the predicate
- The claim is `∀x ∈ S, P(x)`
- Which is refuted by `∃x ∈ S, ~P(x)`
- So the negation of the claim is:

```
∀x ∈ S, P(x) is ∃x ∈ S, ~P(x)
```

or 

```
~(∀x ∈ S, P(x)) ≡ ∃x ∈ S, ~P(x)
```

## Negation of `∃`

The negation of `∃` gives an `∀`

Example:

- If `P = {people in the room}
- and the predicate is `N(x): x speaks Navaho`
- Consider the statement "There is somebody in this room who speaks Navaho."

```
∃x ∈ P, N(x)
```

This is refuted by "Nobody here speaks Navaho."

```
∀ x ∈ P, ~N(x)
```

So in other words:

```
~(∃x ∈ P, N(x)) ≡ ∀x ∈ P, ~N(x)
```

Notice that the negation of `∃` gives `∀`.

- The opposite of "Some do" is "None do"
- The opposite of "Some are" is "None are"

Another example:

Consider the set of strings:

- a: 171095946644741945
- b: 605902976190243621
- c: 354559987164464731
- d: 319644307182580295
- e: 159367451305908388
- f: 137255178469493869
- g: 258220617871305195
- h: 620096821201763239

Consider the claim: "There is a string with triple digits." or a string which contains three matching consecutive digits, ie. 555.

After checking every string, we can conclude the claim is false. In other words, "for each string there is no triple of consecutive digits." In order to refute the existential statement, we had to check all possibilities.

Using the symbols again, while `S = {a, b, c, d, e, f, g, h}` we can define the predicate as:

```
P(x): string x contains a triple of digits
```

Then the claim is:

```
∃x ∈ S, P(x)
```

And is refuted by:

```
∀x ∈ S, ~P(x)
```

So the negation of the claim is `∃x ∈ S,P(x)` is `∀x ∈ S, ~P(x)` or

```
~(∃x ∈ S, P(x)) ≡ ∀x ∈ S, ~P(x)
```

So in summary:

```
~(∀x ∈ S, ~P(x)) ≡ ∃x ∈ S, ~ P(x)
~(∃x ∈ S, P(x)) ≡ ∀x ∈ S, ~P(x)
```

Or in plain English:

| Statement   | Negation        |
|-------------|-----------------|
| All do...   | Some don't...   |
| All are...  | Some are not... |
| Some do...  | None do...      |
| Some are... | None are...     |

## Statements Negation

Negate each of the following statements:

- All cars run on petrol
	- Some cars don't run on petrol
- Some files are not binary
	- All files are binary
- Everybody likes ice cream
	- Some people don't like ice cream
- Some students like Maths
	- No students like Maths
- Nobody listens to techno
	- Some people listen to techno
- Some people don't eat curry
	- Everybody eats curry
- All rabbits are grey
	- Some rabbits are not grey
- Not all dogs bite (is like saying some dogs bite)
	- All dogs bite

## Proposition With Two quanitifiers

Now we consider propositions with two quantifiers, for example "Every student passed at least one unit." or "There is at least one song that everybody has heard."

Example:

- `P = {A, B, C}` is a set of people
- `M = {F, G, H}` is a set of movies
- The predicate: `S(x, y)` which means "person x has seen movie y"
- Defined in symbolic statement is: `∀x ∈ P, ∃y ∈ M, S(x, y)`
- Which is translated to: "For each person `x`, there is some movie `y` such that `x` has seen `y`."
- Or in simpler English: "Every person has seen at least one movie."

Notice that if we simply replace `∀` by "for all" and `∃` by "there exists", the resulting statement may be very awkward, and may need to insert the phrase "such that" after `∃` in order to obtain a reasonable sentence.

Using the above example again, `∃y ∈ M, ∀x ∈ P, S(x, y)` means "there is a movie that every person has seen." whereas `∀x ∈ P, ∃y ∈ M, S(x, y)` means that "each person has seen at least one movie."

We can see the difference if we assume that the diagram below shows which people have seen various movies.

For the situation shown on the diagram (See `pp. 29`), the statement `∃y ∈ M, ∀x ∈ P, S(x, y)` is `false`, because "there is no movie that everyone has seen."

Whereas the statement `∀x ∈ P, ∃y ∈ M, S(x, y)` is `true`, since "every person has seen at least one movie."

## Negation of a Proposition with Two Quantifiers

### Negation of `∀∃`

Consider the claim:

```
∀x ∈ P, ∃y ∈ M, S(x, y)
```

Translated to simple English:

"Every person has seen at least one movie."

Now we can check each person to see whether this claim is true. But according to graph 2 on `pp. 30`, person `C` has not seen a movie. In other words "For each movie, Person C has not seen the movie." So the claim is false. 

So we can say that `∃x ∈ P, ∀y ∈ M, ~S(x, y)`.

```
~(∀x ∈ P, ∃y ∈ M, S(x, y)) ≡ ∃x ∈ P, ∀y ∈ M, ~S(x, y)
```

### Negation of `∃∀`

Consider the claim:

```
∃y ∈ M, ∀x ∈ P, S(x, y)
```

Translated to simple English:

"There is some movie that everyone has seen."

Now we can check each person to see whether this claim is true. But according to graph 1 on `pp. 31`, it shows that some movies have not been seen by everyone.

Se we can say that `∀y ∈ M, ∃x ∈ P, ~S(x, y)`

Or in simple English:

"For each movie there is someone who has not seen it." or "No movie has been seen by everybody."

```
~(∃y ∈ M, ∀x ∈ P, S(x, y)) ≡ ∀y ∈ M, ∃x ∈ P, ~S(x, y)
```

## Negation of Proposition With Two Quantifier Examples

### Negation of `∀∃`

```
~(∀x ∈ P, ∃y ∈ M, S(x, y)) ≡ ∃x ∈ P, ∀y ∈ M, ~S(x, y)
```

### Negation of `∃∀`

```
~(∃y ∈ M, ∀x ∈ P, S(x, y)) ≡ ∀y ∈ M, ∃x ∈ P, ~S(x, y)
```

### Negation of `∃∃`

```
~(∃x ∈ P, ∃y ∈ M, S(x, y)) ≡ ∀x ∈ P, ∀y ∈ M, ~S(x, y)
```

### Negation of `∀∀`

```
~(∀y ∈ M, ∀x ∈ P, S(x, y)) ≡ ∃y ∈ M, ∃x ∈ P, ~S(x, y)
```

## An Algabraic Derivation

The laws for the negation of doubly-quantified propositions may be derived algabraically.

Examples:

- Find the negation of each of the following propositions by:
	1. Translating the proposition into symbols.
	2. Finding the negation of the symbolic statement.
	3. Translating the negated symbolic statement into English.

- For each movie there is some person who has seen it:
	1. `∀y ∈ M, ∃x ∈ P, S(x, y)`
	2. `∃y ∈ P, ∀x ∈ M, ~S(x, y)`
	3. There is at least one movie that nobody has seen.

- Somebody has seen every movie:
	1. `∃x ∈ P, ∀y ∈ M, S(x, y)`
	2. `∀x ∈ P, ∃y ∈ M, ~S(x, y)`
	3. Nobody has seen every movie.

- There is some movie that everyone has seen:
	1. `∃y ∈ M, ∀x ∈ P, S(x, y)`
	2. `∀y ∈ M, ∃x ∈ P, ~S(x, y)`
	3. For each movie there is someone who has not seen it.

## Set Theory - Sets

A set is a collection of things, usually (but not necessarily) sharing some common attribute.

For example, you might be concerned with a set of files, a set of dates, a set of orders for a particular month, a set of customers etc.

Examples: 

- `P = {Word, Excel, PowerPoint, Outlook}`
- `E = {2, 4, 6, 8, 10, ...}`
- `check_dates = {15 March, 17 June, 28 September}`
- `S = {x | x is an even number < 18}`
- D = {d | d is a date before 1 July}`

In maths we have some special sets of numbers:

- `N` denotes the set of natural numbers `{1, 2, 3, 4, ...}`
- `Z` denotes the set of all integers `{0, ±1, ±2, ±3, ±4, ...}`
- `R` denotes the set of all real numbers (float) `{1.25, 2.12, 3.55, ...}`

## Specification of a Set

There are varioys ways. For example, we can list the members of a set:

- `{1, 2, 3, 4}`
- `{1, 2, 3, 4, ...}`
- `{1, 2, 3, 4, ..., 30}`

Or we can describe the members of the set:

- `{x | x is an odd number less than 10}`
- `{y ∈ N | y > 5 and y < 13}`

The order of the elements of a set is unimportant, so `{a, b, c}` is the same set as `{c, b, a}`.

Repetitions are unimportant, but naturally we choose the simplest version. `{a, a, a, b, a, c, c, b}` is the set as `{a, b, c}`.

The universal set `U` is simply the set of all things that we happen to be working with in a particular problem.

It is sometimes convenient to talk about the empty set `∅`, or `{}` which is a set that has no members.

## Membership of a Set

The symbol `∈` is read "is a member of" or "is an element of" or "belongs to".

- For example:
	- `p ∈ { p, q, r }`
	- `3 ∈ N`
	- `4.5 ∉ N`
	- `π ∈ R`
	- `√-1 ∉ R`

Examples of sets and Venn diagrams:

Example 1:

- `U = {1, 2, 3, ..., 12}`
- `E = {even numbers}`
- `T = {numbers divisible by 3}`

Place each number in the appropriate region.

![venn UET](http://i.imgur.com/sdYEhJ2.png)

Example 2:

- `U = {animals}`
- `H = {animals with horns}`
- `M = {meat-eaters}`
- `S = {striped animals}`

Place animals in the appropriate sub-set: cow, horse, lion, tiger, zebra.

![venn UHMS](http://i.imgur.com/ao9FD80.png)

## Subsets

We say that B is a subset of A, if every element of B is also an element of A. In symbols `B ⊆ A`.

Example:

Let `A = {1, 2, 3, 4, 5}`, `B = {1, 3, 4}`, `C = {2, 4, 6}`

![venn AB1](http://i.imgur.com/I9Ltz7b.png)

Clearly `B ⊆ A` since each element of `B` is also an element of `A`. Also, `C` is not a subset of `A` since `6 ∈ C` but `6 ∉ A`.

## Set Operations

### Intersection

`A ∩ B` is the set of elements in both A and B.

That is:

```
A ∩ B = {x | x ∈ A ˄ x ∈ B}
```

Translates to:

"The subsection of `A` and `B` is `x` which is an element of `A` and an element of `B`"

If `A` and `B` have no elements in common, that is if `A ∩ B = ∅`, then `A` and `B` are said to be disjoint.

![venn intersect](http://i.imgur.com/xakbqsF.png)

### Union

`A ∪ B` is the set of elements in `A` or `B` or both.

That is:

```
A ∪ B = {x | x ∈ A ˅ x ∈ B}
```

![venn union](http://i.imgur.com/QleKOzl.png)

### Complement

The complement of `A` is denoted by `A'` and consists of all the elements of the universal set that are not in `A`.

That is:

```
A' = {x | x ∈ U ˄ x ∉ A}
```

![venn complement](http://i.imgur.com/vYUOLB8.png)

### Examples of Set Operations

#### `A ∩ B'`

![A ∩ B'](http://i.imgur.com/CuQiScS.png)

#### `A' ∪ B ≡ (A ∩ B')'`

![A' ∪ B ≡ (A ∩ B')'](http://i.imgur.com/cz2uVTY.png)

#### `(A ∩ B') ∪ (A' ∩ B)`

![(A ∩ B') ∪ (A' ∩ B)](http://i.imgur.com/s6WwUt3.png)

#### `A ∩ B ∩ C'`

![A ∩ B ∩ C'](http://i.imgur.com/Y4YlAln.png)

#### `A ∩ (B ∪ C)`

![A ∩ (B ∪ C)](http://i.imgur.com/e0DvAcK.png)

#### `A' ∩ B' ∩ C'`

![A' ∩ B' ∩ C'](http://i.imgur.com/tdRiyVA.png)

#### `(A ∪ B) ∩ C'`

![(A ∪ B) ∩ C'](http://i.imgur.com/aDdgHXI.png)

#### `C ∩ (A ∪ B)' ≡ C ∩ A' ∩ B'`

![C ∩ (A ∪ B)' ≡ C ∩ A' ∩ B'](http://i.imgur.com/eeUYTJB.png)

#### `(A ∩ B') ∪ (A ∩ C)`

![(A ∩ B') ∪ (A ∩ C)](http://i.imgur.com/wHBHbdw.png)

## The Addition Principle

Let `n(A)` denote the number of elements in set `A`.

If set `A` has `n(A)` elements and set `B` has `n(B)` elements, then the number of elements in the union `A ∪ B` is:

```
n(A ∪ B) = n(A) + n(B) - n(A ∩ B)
```

This is called the **Addition principle**.

From a Venn diagram we can see that if we add `n(A)` and `n(B)` then we will be counting `n(A ∩ B)` twice.

![venn addition](http://i.imgur.com/V03rjMd.png)

If `A` and `B` are disjoint, that is, if `A ∩ B = ∅` and hence `n(A ∩ B) = 0`, the addition principle becomes:

```
n(A ∪ B) = n(A) + n(B)
```

Example:

- Suppose that
	- `A = {multiples of 3 less than 32}`
	- `A = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30}`
- And
	- `B = {multiples of 5 less than 32}`
	- `B = {5, 10, 15, 20, 25, 30}`
- Then `A ∪ B = {3, 5, 6, 9, 10, 12, 15, 18, 20, 21, 24, 25, 27, 30}`
	- By counting `n(A ∪ B) = 14`

### The Addition Principle Examples

- Using the addition principle
	- `A = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30}`
	- `B = {5, 10, 20, 25, 30}`
	- `A ∩ B = {15, 30}; n(A) = 10, n(B) = 6, n(A ∩ B) = 2`
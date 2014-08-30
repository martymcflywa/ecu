# Relations

## Relations between sets

- Relations between sets form the basis for relational databases and similar structures, which are widely used for the storage and retrieval of data
- We shall admit our discussions to so called binary relations and different ways of representing binary relations
- A relation between two sets is a subset of their **Cartesian product**
- Recall that if `A` and `B` are sets, then their **Cartesian product** `A × B` is the set of all ordered pairs `(a, b)` where `a ∈ A` and `b ∈ B`
- A relation `R` between `A` and `B` is a subset of `A × B`
	- There are usually many possible relations between two sets

### Example: Students taking courses

- `S = {Andrew, Betty, Chris, Dianne}` is a set of students
- `C = {CS101, CS102, CS103}` is a set of computer science courses

There are many ways of showing which students are taking which courses.

We could draw an *arrow diagram*:

![arrow students](http://i.imgur.com/0tscVNs.png)

We could draw a *graph*:

![graph students](http://i.imgur.com/7hKkF2V.png)

We could give the *set of ordered pairs* shown on the graph:

`{(A, CS101), (A, CS102), (B, CS101), ..., (D, CS103)}`

### Example: People at a sports camp

- `M` is the team `{Geoff, Hillary, Ian, Jane}`
- `S` is the set of sessions `{Sat am, Sat pm, Sun am}`
- We could have a relation between `M` and `S` that shows who is competing and at what times

We could use a graph:

![graph sports](http://i.imgur.com/yDENE3R.png)

We could use a table:

| Member  | Sat am | Sat pm | Sun am |
|:-------:|:------:|:------:|:------:|
| Geoff   | 0      | 1      | 1      |
| Hillary | 1      | 0      | 1      |
| Ian     | 1      | 1      | 0      |
| Jane    | 1      | 1      | 1      |

We could present the information in the table as a **matrix**:

![matrix sports](http://i.imgur.com/sLNY2du.png)

## Definition of a relation between two sets

In each case we have two sets and some of the elements of one set are *related to* or *associated with* some of the elements of the other set.

If we call the two sets `A` and `B`, then a relation `R` between `A` and `B` is a subset of `A × B`. Which is:

`R ⊆ A × B`

Since there are usually many subsets of `A × B`, there are many possible relations between `A` and `B`.

### Example 1

Let `A = {a, b, c}` and `B = {x, y}`

The **Cartesian product** `A × B` may be represented graphically as shown:

![cart product 1](http://i.imgur.com/zH6ZUQh.png)

### Example 2

- Let `A = {a, b, c}` and `B = {x, y}`
- Let `R` be the relation `R = {(a, x), (b, x), (b, y), (c, y)}`
- Then we could represent `R` by the graph:

![cart product 2](http://i.imgur.com/i5Op1ew.png)

### Example 3

- Let `A = {a, b, c}` and `B = {x, y}`
- Similarly, if `P` and `Q` are relations defined by:
	- `P = {(a, x), (b, y), (c, x)}`
	- `Q = {(a, y), (c, x), (c, y)}`
- They could be represented by:

![cart product 3](http://i.imgur.com/XGXHpjg.png)

## Different methods of representing a relation

We can represent a relation between two sets as a set of ordered pairs, or by using:

- Table
- Arrow diagram
- Graph
- Matrix

In real applications, the other representations are more convenient. 

These different methods of representing a relation is shown diagrammatically in the following example.

![different methods](http://i.imgur.com/sMorjZG.png)

## Why use ordered pairs?

Why define a relation to be a set of ordered pairs?

Isn't it much easier to see what is happening with a graph, rather than a long list of ordered pairs?

It is, but we are talking about a representation that is implemented ina computer package, and computers are designed to process long lists of symbols.

Secondly, and just as importantly, the idea of ordered pairs can be generalised.

Consider what happens when we work with cartesian products such as `A × B × C` or `A × B × C × D`.

Graphical representations of relations defined above in graphs form are no longer possible.

Instead of just ordered pairs, we can use ordered triples or ordered quadruples, or `n`-tuples (tuples).

For example, a university admin centre deals with many sets such as:

- `S1 = {student names}`
- `S2 = {student IDs}`
- `S3 = {year of enrolment}`
- `S4 = {address}`
- `S5 = {study units}`
- `S6 = {academic status}`

Then the set of all students who enrolled in Maths could be:

`{(John Adams, 992345, Maths), (Sue Ball, 003338, Maths), ...., etc}` which is a subset of `S1 × S2 × S5`.

And the set of all students who are doing Maths and who have status *good standing* could be a subset of `S1 × S2 × S5 × S6`.

## A possible application

Suppose data is entered as a table:

| Order No. | Supplier | Item      | Quantity |
|:---------:|----------|-----------|:--------:|
| 401       | Ace Co.  | PC        | 10       |
| 403       | Ace Co.  | Modem     | 24       |
| 406       | Dataco   | Zip disk  | 74       |
| 411       | Computek | ZP3 cable | 30       |

Each row is a **4-tuple**, for example `(403, Ace Co., Modem, 24)`.

The set of orders for February, say, is a relation because it is a set of **4-tuples**, and therefore is a subset of the Cartesian product.

## Using `infix` notation

We sometimes use a symbol such as `R` to represent a relation, and write it between two elements, hence the name **infix**. So we could read `a R b` as "`a` is related to `b`" and `a` ~~R~~ `b` as "`a` is not related to `b`".

### Example 1

- Let `A = {10, 20, 30, 40}` and `B = {2, 3, 4, 5, 6}`
- Suppose `M` means "is multiple of"
- Then ~~M~~ means "is not a multiple of"

So we have: `10 M 2`, `10` ~~M~~ `5`, `20 M 5` and `40` ~~M~~ `6`, etc.

### Example 2

- Let `A = {Perth, Sydney, Melbourne}` and `B = {NSW, SA, VIC, NSW}`
- Suppose that `C` means "is the capital of", and ~~C~~ means "is not the capital of"

Then: `Perth C WA`, `Sydney` ~~C~~ `SA`, `Melbourne` ~~C~~ `NSW`, etc.

### Example 3

- Let `A = {people}` and `B = {foodstuffs}`

Then `Suzie L chocolate`, `John` ~~L~~ `pasta`.

## Composition of relations

### Example 1

- Let `A = {a, b, c}`, `B = {d, e, f}`, `C = {g, h, i}`
- Suppose that `R` is a relation between `A` and `B` defined by:
	- `a R e`
	- `b R d`
	- `c R d`
	- `c R f`
- `S` is a relation between `B` and `C` defined by
	- `e S g`
	- `e S h`
	- `f S h`
	- `f S i`

Then we can represent `R` and `S` using arrow diagrams:

![composition arrow 1](http://i.imgur.com/BaH67U7.png)

We can then use the diagrams to combine the relations `R` and `S` to form the "composition of `R` followed by `S`". This is denoted by `R ○ S`, which shows how `A` is related to `C` by the combination of the relations `R` and `S`:

![composition arrow 2](http://i.imgur.com/ecaCVE6.png)

We can then express the composition of `R` followed by `S` as a set of ordered pairs:

`R ○ S = {(a, g), (a, h), (c, h), (c, i)}`

### Exercise

- Let `A = {a, b, c}`, `B = {d, e, f}`, `C = {g, h, i}`
- Suppose that `R` and `S` are relations between `A` and `B`, and between `B` and `C` respectively, and defined by:
	- `a R e`
	- `b R f`
	- `c R d`
	- `c R f`
	- `e S h`
	- `e S i`
	- `f S g`
	- `f S h`

Draw arrow diagrams to represent `R` and `S` and the composition `R ○ S`. Hence express `R ○ S` as a set of ordered pairs.

![exercise arrow 1](http://i.imgur.com/QrA7YAg.png)

## Composition using matrices

Instead of arrow diagrams, which can become very complicated, we can use matrices.

We consider the two previous examples of composition of relations, but this time using logical multiplication of matrices.

Here are the first two examples.

### Example 1

- Let `A = {a, b, c}`, `B = {d, e, f}`, `C = {g, h, i}`
- Suppose that `R` and `S` are relations between `A` and `B`, and between `B` and `C` respectively, defined by:
	- `a R e`
	- `b R d`
	- `c R d`
	- `c R f`
	- `e S g`
	- `e S h`
	- `f S h`
	- `f S i`

Then we can represent `R` and `S` using the matrices:

![compositoin matrix 1](http://i.imgur.com/ABHOGHn.png)

### Combining relations in a matrix

To combine the relations `R` and `S` to form the "compostion of `R` followed by `S`" denoted by `R ○ S`, we multiply the matrices `M(R)` and `M(S)` using Boolean arithmetic.

![compositon matrix 2](http://i.imgur.com/ieI7F4v.png)

**Not sure how `M(R ○ S)` is being calculated here**

## Inversion of a relation

- Consider the relation `R` defined between sets
	- `A = {a, b, c, d}`
	- `B = {e, f, g}`
	- `R = {(a, f), (a, g), (b, e), (c, e), (d, f)}`

![inverse 1](http://i.imgur.com/Kz3xTKg.png)

The inverse relation is `R`<sup>-1</sup> `= {(f, a), (g, a), (e, b), (e, c), (f, d)}`

Notice that each of the ordered pairs has been reversed.

If `a R g` is defined to be mean that "`a` is the student of `g`", then `g R`<sup>-1</sup> `a` means "`g` is the teacher of `a`".

Suppose that `a R g` is defined to mean that "`a` is younger than `g`", then `g R`<sup>-1</sup> `a` means "`g` is older than `a`".

### Exercise

- `A = {a, b, c}`
- `B = {f, g, h}`
- `S` is the relation between the sets, defined by:
	- `a S g`
	- `a S h`
	- `b S g`
	- `c S g`

Draw an arrow diagram for `S`<sup>-1</sup> and express `S`<sup>-1</sup> as a set of ordered pairs:

![inverse 2](http://i.imgur.com/fZtJwnq.png)

## Inversion of a relation using matrices

- `A = {a, b, c, d}`
- `B = {e, f, g}`
- `R = {(a, f), (a, g), (b, e), (c, e), (d, f)}`

The relation `R` is represented by the matrix:

![inverse matrix 1](http://i.imgur.com/IDQs6Bp.png)

The inverse relation is:

`R`<sup>-1</sup> `= {(f,a), (g, a), (e, b), (e, c), (f, d)}`

So the relation `R`<sup>-1</sup> is represented by the matrix:

![inverse matrix 2](http://i.imgur.com/6wX5y8k.png)

The rows and columns of `R` have been transposed, that is the 1st row of `M(R)` becomes the 1st column of `M(R)`<sup>T</sup> and the 2nd row becomes the 2nd column, etc.

The result is called the transpose of `M(R)` and is denoted by `M(R)`<sup>T</sup>.

If `M(R)` represents `R`, then `M(R)`<sup>T</sup> represents `R`<sup>-1</sup>.

### Exercise

- `A = {a, b, c}`
- `B = {f, g, h}`
- `S` is the relation between sets defined by:
	- `a S g`
	- `a S h`
	- `b S g`
	- `c S g`
- Find the matrix `M(S)` that represents `S`
- Then find `M(S)`<sup>T</sup> and hence express the inverse relation `S`<sup>-1</sup> as a set of ordered pairs

![inverse exercise 1](http://i.imgur.com/kI5XaYh.png)

## Inverse of a composition of relations

### Example 1

- `A = {a, b, c}`
- `B = {f, h, g}`
- `C = {w, x, y, z}`
- `R` is relation between `A` and `B`
- `S` is relation between `B` and `C`
	- `a R g`
	- `b R h`
	- `c R f`
	- `c R g`
	- `g S x`
	- `h S w`
	- `h S z`

The arrow diagrams for `R`, `S` and `R ○ S`:

![inverse composition 1](http://i.imgur.com/fu7Ucdy.png)

The arrow diagrams for `S`<sup>-1</sup>, `R`<sup>-1</sup> and `S`<sup>-1</sup> `○ R`<sup>-1</sup>:

![inverse composition 2](http://i.imgur.com/N3pNPbl.png)

Notice that `S`<sup>-1</sup> `○ R`<sup>-1</sup> is the inverse of `R ○ S`, or put in another way:

`(R ○ S)`<sup>-1</sup> `= S`<sup>-1</sup> `○ R`<sup>-1</sup>

Stated in terms of matrices, this becomes

```
M((R ○ S)^-1) = (M(R)M(S))^T = M(S)^T M(R)^T = M(S^-1)M(R^-1)
```

### Note

The rule for inverses that we have just seen, that is `(R ○ S)`<sup>-1</sup> `= S`<sup>-1</sup> `○ R`<sup>-1</sup>, applies in many situations, even every day ones. When we have a combination of two procedures, the opposite (or inverse) of the combined procedures requires the procedures to be reversed, but also the order of the procedures. 

For example, consider the combination:

>Put on socks followed by put on shoes

The reverse is:

>Take off shoes followed by take off socks

## Application

The following (very simple) example gives an idea of how relations may be used to answer simple queries.

Consider the following:

- A set of units `A = {a, b, c, d}`
- A set of students `S = {e, f, g, h, i}`
- A set of book titles `C = {j, k, l, m, n, p, q}`
- Relation `U` for `A × S`
	- `x U y` means "unit `x` is taken by student `y`"
	- Or `y U`<sup>-1</sup> `x` means "student `y` is enrolled in unit `x`"
- Relation `B` for `S × C`
	- `x B y` means "student `x` has borrowed book `y`"
	- Or `y B`<sup>-1</sup> `x` means "book `y` has been borrowed by student `x`"

Suppose our query is:

>Which books have been borrowed by students who are enrolled in the same units as the students who borrowed book `k`?

- `B`<sup>-1</sup> will tell us who borrowed book `k`
- `U`<sup>-1</sup> will tell us which units this person is enrolled in
- `U` will tell us which students are enrolled in these units
- `B` will tell us which books have been borrowed by these students

![application 1](http://i.imgur.com/dJwtqdY.png)

![application 2](http://i.imgur.com/NmGPAB9.png)

Following the arrows from `k`, we see that the titles are `j`, `k`, `m` and `n`.

## Relation on a set

A relation between sets `A` and `B` is a subset of `A × B`.

A relation on a set `A` is a relation between `A` and `A` and so is a subset of `A × A`.

### Example

- `A = {1, 2, 3, 4}`
- `G` is the relation "is greater than"
	- `2 G 1`
	- `3 G 1`
	- `4 G 1`
	- `4 G 2`
	- `4 G 3`
- Or in terms of ordered pairs:
	- `G = {(2, 1), (3, 1), (3, 2), (4, 1), (4, 2), (4, 3)}`

The graph and arrow diagrams:

![relation set 1](http://i.imgur.com/Kphv9pP.png)

### Exercise

- `S = {Anne, Bob, Cathy, Dave}`
- `Y` is the relation "is the same age as"
- Suppose the respective ages are `18`, `20`, `19`, `18`

Then we have:

`Anne Y Anne`, `Bob Y Bob`, ..., `Anne Y Dave`, `Dave Y Anne`

In terms of ordered pairs, the relation is:

`Y = {(Anne, Anne), (Bob, Bob), (Cathy, Cathy), ..., (Anne, Dave), (Dave, Anne)}`

The graph and arrow diagrams:

![relation set 2](http://i.imgur.com/ZERYeKe.png)

## Properties of relations

Relations on a set can be classified according to certain properties. We look at only three of these:

- Reflexivity
- Symmetry
- Transitivity

Suppose `R` is a relation on a set `S`.

- `R` **reflexive** means:
	- `∀x ∈ S, x R x`
- `R` **symmetric** means:
	- `∀x, y ∈ S, x R y → y R x`
- `R` **transitive** means:
	- `∀x, y, z ∈ S, ( x R y ) ˄ ( y R z ) → ( x R z )`

### Reflexive relation

`x R x` for **all** `x`

![reflexive](http://i.imgur.com/SvS2GpC.png)

### Symmetric relation

**If** `x R y` **then** `y R x`, **for all** `x` **and** `y`

![symmetric](http://i.imgur.com/17Xmod1.png)

### Transitive relation

**If** `x R y` **and** `y R z`, **then** `x R z`, **for all** `x`, `y` and `z`

![transitive](http://i.imgur.com/uw0ikMT.png)

### Example 1

- Suppose that `S` is the set of all Australian males, and consider the relations:
	- `B` is the brother of
	- `H` is the same height as
	- `Y` is younger than
	- `M` has met

#### `B` is the brother of

- Not reflexive
	- I am not the brother of myself
- Is symmetric
	- I am John's brother, John is my brother
- Is transitive
	- I am John's brother, Matt is John's brother, so Matt is my brother

#### `H` is the same height as

- Is reflexive
- Is symmetric
- Is transitive

#### `Y` is younger than

- Not reflexive
- Not symmetric
- Is transitive

#### `M` has met

- Is reflexive
- Is symmetric
- Not transitive

### Example 2

Consider the following sets and relations:

- Case 1
	- Natural numbers
	- Is divisible by
- Case 2
	- People
	- Lives in the house next to
- Case 3
	- Towns
	- Is not more than 50km from
- Case 4
	- People
	- Has the same blood type as

For each case we ask:

>Is the relation reflexive?  
>Is it symmetric?  
>Is it transitive?

| Case   | Reflexive | Symmetric | Transitive |
|-------:|:---------:|:---------:|:----------:|
| Case 1 | Yes       | No        | Yes        |
| Case 2 | No        | Yes       | No         |
| Case 3 | Yes       | Yes       | No         |
| Case 4 | Yes       | Yes       | Yes        |

## Equivalence relations

If a relation on a set is **reflexive**, **symmetric** and **transitive**, then it is called an **equivalence relation**.

So, for example, "has the same blood type as" is an equivalence relation.

Some other examples are:

>Is the same age as  
>Starts with the same letter as  
>Has the same number of letters as  
>Leaves the same remainder, when divided by 2, as

## Multiplication of matrices

If we were multiplying an `m × n` matrix `A` by an `n × q` matrix `B` to obtain an `m × q` matrix `C`, the formula for the typical element `c`<sub>ij</sub> of `C` is:

![formula](http://i.imgur.com/Ly4sPfK.png)

Logical multiplication of matrices is exactly the same as multiplication except that, instead of ordinary arithmetic, we use Boolean arithmetic.

You will recall that in Boolean arithmetic we only use the numbers 0 and 1, and the rules for multiplication and addition are:

| Multiplication | Addition    |
|:--------------:|:-----------:|
| `0 x 0 = 0`    | `0 + 0 = 0` |
| `0 x 1 = 0`    | `0 + 1 = 1` |
| `1 x 0 = 0`    | `1 + 0 = 1` |
| `1 x 1 = 1`    | `1 + 1 = 1` |


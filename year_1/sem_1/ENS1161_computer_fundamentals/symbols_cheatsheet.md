# Lecture 1

| Symbol | Name                  | Function
|--------|-----------------------|------------------------------------------------| 
| `~`    | `NOT`                 | Negates                                        |
| `˄`    | `AND`                 | And                                            |
| `˅`    | `OR`                  | Or                                             |
| `→`    | `IF THEN`             | Conditional                                    |
| `≡`    | `LOGICAL EQUIVALENCE` | Is equal to                                    |

`|` = `CONCLUSION` = Anything to the right of `|` is the conclusion

# Lecture 2

| Symbol  | Name                     | Function
|---------|--------------------------|------------------|
| `P(x):` | `Predicate`              | a statement with one or more variables, I see it as a function |
| `R`     | `SET` of real numbers    | 1.5, 2.5, 3.5    |
| `N`     | `SET` of natural numbers | 1, 2, 3          |
| `∈`    | `element of`             | sets membership  |
| `∉`     | `not element of`         | negative of `∈` |
| `∀`    | `for all`                | quantifier "for every"      |
| `∃`    | `there exists`           | quantifier "for some"       |
| `U`     | `universal set`          | the `set` of all things that contains working parts of a problem |
| `∅`     | `empty set`              | self explanatory, null |
| `{}`    | `empty set`              | self explanatory, null |
| `⊆`    | `subset`                 | a set of elements within another `set` |
| `∩`     | `intersect`              | the set of elements that are in common with... |
| `∪`    | `union`                  | the set of elements that are in **all** `sets`, except the `universal set` |
| `'`     | `complement`             | the set of elements that are in the `universal set`, but not in `A` for example |
| `n(A)`  | `number of elements`     | count how many elements are a member of `A` |
| `A × B` | `cartesian product`      | the `×` denotes cartesian product of A then B |

# Analogy with logic concepts

The laws are essentially the same, but are just presented differently.

`~(A ˅ B) ≡ ~A ˄ ~B` corresponds to `(A ∪ B)' = A' ∩ B'`

| Logic   | Set  |
|---------|------|
| `~`     | `'`  |
| `˄`     | `∩`  |
| `˅`     | `∪` |
| `true`  | `U`  |
| `false` | `∅`  |

## Negations

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

## Laws of Sets

The laws are in pairs, and can swap from a law to its dual (matching pair) by swapping `∪` with `∩`, and `U` with `∅`.

### Distributive Laws

```
A ∩ (B ∪ C) = (A ∩ B) ∪ (A ∩ C)
A ∪ (B ∩ C) = (A ∪ B) ∩ (A ∪ C)
```

### de Morgan's Laws:

```
(A ∪ B)' = A' ∩ B'
(A ∩ B)'' = A' ∪ B'
```


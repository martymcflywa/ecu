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
| `P(x):` | `Predicate`              |                  |
| `R`     | `SET` of real numbers    | 1.5, 2.5, 3.5    |
| `N`     | `SET` of natural numbers | 1, 2, 3          |
| `∈`    | `element of`             | sets membership  |
| `∉`     | `not element of`         | negative of `∈` |
| `∀`    | `for all`                | "for every"      |
| `∃`    | `there exists`           | "for some"       |
| `U`     | `universal set`          |                  |
| `∅`     | `empty set`              |                  |
| `{}`    | `empty set`              |                  |
| `⊆`    | `subset`                 |                  |
| `∪`    | `union`                  |                  |
| `'`     | `complement`             |                  |



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
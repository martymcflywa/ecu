# Workshop 08: Replication

Martin Ponce 10371381

## Question 1

A file is replicated on 9 servers. List all combinations of read/write quorum that are permitted by voting algorithm, Gifford's quorum.

### Gifford's quorum

Guarantee at least one new copy is read/written

1. `N_r + N_w > N`
   - Prevent read/write conflicts
2. `N_w > N / 2`
   - Prevent write/write conflicts

### N = 9

#### Read pool

1, 2, 3, 4, 5, 6, 7, 8, 9

#### Write pool

5, 6, 7, 8, 9

#### Combinations

```
(5, 5), (5, 6), (5, 7), ..., (5, 9)
(6, 4), (6, 5), (6, 6), ..., (6, 9)
(7, 3), (7, 4), (7, 5), ..., (7, 9)
(8, 2), (8, 3), (8, 4), ..., (8, 9)
(9, 1), (9, 2), (9, 3), ..., (9, 9)
```

#### Explanation

All combinations above meets the following conditions:

```
N_r + N_w > N && N_w > N / 2
```

This guarantees that at least one new copy is read/written.

#### Best combinations

```
(5, 5)
(6, 4)
(7, 3)
(8, 2)
(9, 1)
```
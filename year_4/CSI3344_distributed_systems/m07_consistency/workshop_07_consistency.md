# Workshop 07: Consistency

Martin Ponce 10371381

## Question 1

### A

- Is causally consistent
- There is potential causal relationship between
  - `W_1(x)a`
  - `R_2(x)a`, `W_2(x)b`
- `a` happens before `b`
- But `c` can be read at any time since it was written concurrently

### B

- Is causally consistent
- There is no causal relationship between `a`, `b` or `c` writes
  - Concurrent
- Can be read in any order

### C

- Not causally consistent
- There is potential causal relationship between
  - `W_1(x)a`
  - `R_2(x)a`, `W_2(x)b`
- `a` happens before `b`
- But P3 read order violates the rule

### D

- Is causally consistent
- There is potential causal relationship between
  - `W_1(x)a`
  - `R_2(x)a`, `W_2(x)b`
- Both P3 and P4 read in correct order

### E

- Is causally consistent
- There is no causal relationship
  - Concurrent
- Can be read in any order

## Question 2

- P1
  - `x = 1`
  - `print(y, z)`
- P2
  - `y = 1`
  - `print(x, z)`
- P3
  - `z = 1`
  - `print(x, y)`

### 1

```
z = 1
print(x, y) 00 P3
y = 1
print(x, z) 01 P2
x = 1
print(y, z) 11 P1

print: 000111
sign:  110100
```

### 2

```
y = 1
print(x, z) 00 P2
z = 1
print(x, y) 01 P3
x = 1
print(y, z) 11 P1

print: 000111
sign:  110100
```

### 3

```
x = 1
print(y, z) 00 P1
z = 1
print(x, y) 10 P3
y = 1
print(x, z) 11 P2

print: 001011
sign:  001110
```

### 4

```
x = 1
y = 1
print(y, z) 10 P1
print(x, z) 10 P2
z = 1
print(x, y) 11 P3

print: 101011
sign:  101011
```
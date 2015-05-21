# Tutorial 11: Sets and maps

## Task 1

- Let
	- `A = {1, 2, 3, 4, 5}`
	- `B = {4, 5, 6, 7}`
	- `C = {2, 3, 4}`

### 1.1

`A ∪ B = {1, 2, 3, 4, 5, 6, 7}`

### 1.2

`A ∩ B = {4, 5}`

### 1.3

`A - B = {1, 2, 3}`

### 1.4

`B - A = {6, 7}`

### 1.5

`C - A = {}`

### 1.6

The relationship between `A` and `C` is `A ⊇ C`

## Task 2

Test the Java implementation of the `TreeSet` class given in `WS1101`.

### 2.1

Notice the invocation of `add()`, `first()`, `last()`, `headSet()`, `subSet()`, and `tailSet()` methods provided by the `TreeSet` class.

### 2.2

Execute this program and analyze the results corresponding to individual method invocations in the program.

```
[Australia, Canada, China, Egypt, Greece, India, Oman, Peru, Togo, USA]
countries.first() = Australia
countries.last()  = USA
countries.headSet(Australia) = []
countries.subSet(Australia,Canada) = [Australia]
countries.tailSet(Canada) = [Canada, China, Egypt, Greece, India, Oman, Peru, Togo, USA]
```

## Task 3

Test the Java implementation of the `HashSet` class given in `WS1102`.

### 3.1

Notice the invocation of `add()`, `contains()`, and `remove()` methods provided by the `HashSet` class.

### 3.2

Execute this program and analyze the results corresponding to individual method invocations in the program.

```
7 elements: [New Zealand, Canada, USA, China, Australia, Peru, India]
set.contains(Australia) = true
countries.remove("Australia") = true
6 elements: [New Zealand, Canada, USA, China, Peru, India]
set.contains(Australia) = false
6 elements: [New Zealand, Canada, USA, China, Peru, India]
set.contains(Fiji) = false
countries.remove("Fiji") = false
countries.add("Fiji") = true
7 elements: [New Zealand, Canada, USA, Fiji, China, Peru, India]
set.contains(Fiji) = true
countries.add("Fiji") = false
7 elements: [New Zealand, Canada, USA, Fiji, China, Peru, India]
set.contains(Fiji) = true
```

## Task 4

A multi-map is similar to a map, except there may be several entries with the same key. How would you represent a multi-map without storing multiple copies of the same key? Use the table given below to illustrate your representations.

| Country | Language |
|---------|----------|
| BE      | Flemish  |
| BE      | French   |
| DE      | German   |
| FR      | French   |
| IT      | Italian  |
| LU      | French   |
| NL      | Dutch    |

We can represent a multi-map in the same manner as an ordinary map, except that each key is associated with a **set** of values. The following figures illustrate sorted array, sorted SLL, and BST representations of a multi-map.

In each case, the set of values associated with a particular key is represented by an unsorted SLL, which is adequate if it can be assumed that multiple entries with the same key will be relatively uncommon.

**Multi-map array:**

![multi-map array](http://snag.gy/B9kVF.jpg)

**Multi-map SLL:**

![multi-map sll](http://snag.gy/SNMXZ.jpg)

**Multi-map BST:**

![multi-map bst](http://snag.gy/kUq7M.jpg)

## Task 5

Test the Java implementation of the `HashMap` class given in `WS1103`.

### 5.1

Notice how to build a dictionary using `HashMap` class.

### 5.2

Notice the order of the words in this dictionary created using `HashMap` class.

```
map={
	Ast=gate
	Wal=whale
	Rat=advice, counsel
	Hut=hat
	Mut=courage
	Zug=procession, train
	Eis=ice
	Ost=east
	Rad=wheel
	Tor=gate
	Ohr=ear
	Mal=mark, signal
	Tag=day
	Hof=court, yard, farm
	Lob=praise
	Uhr=clock
}
map.keySet()=[Ast, Wal, Rat, Hut, Mut, Zug, Eis, Ost, Rad, Tor, Ohr, Mal, Tag, Hof, Lob, Uhr]
map.size()=16
```

# Normalisation extras

## Simple rule for deriving normal forms

- 1NF: The key
- 2NF: The whole key
- 3NF: And nothing but the key

### More formally

- 1NF: Remove repeating groups
- 2NF: Remove partial depdendence
- 3NF: Remove indirect dependence

## Normalisation is not a new idea

- Normalisation works because of relational calculus
- It is a deterministic technique but there is still room for creativity

## Normalisation and performance

- Don't all these extra tables have an impact on performance?
	- True, but the benefites usually far outweight the costs
- Do we ever not normalise tables?
	- Under certain circumstances, yes
		- ie. In data warehouses we might elect not to fully normalise some tables for performance

## How far to go?

- Is 3NF the same as fully normalised?
- No, there are more forms
	- Boyce-Codd NF
	- 4NF
	- 5NF
	- Not covered in this unit
- Forunately, entities in 3NF are often also in the higher forms automatically

## Example

- Consider the common problem of customers making orders
	- An un-normalised situation may look like this:

```
cust-order (order#, customer#, customer-name, {item-code, unit-price, quantity-ordered})
```

![example](http://snag.gy/ufFI7.jpg)

## 1NF

- As we already know, this is about removing repeating groups
- Often, the hardest part is finding the key of the new table
- Remember that the key is the minimum set of columns required to uniquely identify a row

### Problems solved through 1NF

- With a repeating group, access can only be done by searching a row and identifying the repeating group by some (usually programmatic) means
- We want to be able to access an individual column directly for data independence
	- Plus it is good relational algebra
- Also, if the repeating group is split after the database has been in use for some time, the magic program will need to be changed

### 1NF example

```
customer (order#, customer#, customer-name)
order (order#, item-code, unit-price, quantity-ordered)
```

### Does the example work?

![example 1NF](http://snag.gy/I1Xiv.jpg)

## 2NF

- Non-key attributes must be fully functionally dependent on the key
- Partial dependence of attributes on the key causes problems such as...

### Problems solved through 2NF

- Insertion
	- Can't introduce a new item into the 1NF version of `order` with a specific price unless a customer places an order, so cannot store data about a new item that hasn't been ordered yet
- Deletion
	- If the data about a customer order are deleted, the information about the order (ie. price) is also deleted
	- If this is the last order for that item, then the information about that item will be lost
- Amendment
	- The information about an item appears as many times as there are orders for it, so changing any data about the item is problematic

### 2NF example

```
customer(order#, customer#, customer-name)
order(order#, quantity-ordered, item-code*)
product(item-code, unit-price)
```

### Does the example work?

![example 2NF](http://snag.gy/urcrD.jpg)

## 3NF

- If a relation is in 2NF and its non-key attributes are fully functionally and directly dependent on the key, then the relation is in 3NF
- Therefore, the example is already in 3NF as none of the relations show transitive dependency
	- ie. The attributes are fully dependent on the key but are themselves mutually dependent

## Transitive dependence

![transitive](http://snag.gy/f8oec.jpg)

- Transitive = indirect
- Therefore Assembly A is transitively (indirectly) dependent on part C
- Also, Assembly A is intransitively (directly) dependent on sub-assembly B

## Design choices

- Why does `order#` have to be part of the customer relation?
# Fuzzy expert systems: Fuzzy logic

## Outline

- Introduction
- Fuzzy sets
- Linguistic variables and hedges
- Operations of fuzzy sets
- Fuzzy rules
- Summary

## Introduction

- Experts rely on **common sense** when they solve problems
- How can we represent expert knowledge that uses vague and ambiguous terms in a computer?
- Fuzzy logic is not logic that is fuzzy, but logic that is used to describe fuzziness
	- Fuzzy logic is the theory of fuzzy sets, sets that calibrate vagueness
- Fuzzy logic is based on the idea that all things admit of degrees
	- In other words, submit to a scale
		- Temperature
		- Height
		- Speed
		- Distance
		- Beauty
	- The motor is running **really hot**
	- Tom is a **very tall** guy
- Boolean logic uses sharp distinctions
	- It forces us to draw lines between members of a class and non members
		- For instance, we may say, Tom is tall because his height is 181cm
		- If we drew a line at 180cm, we would find that David, who is 179cm is small
		- Is David really a small man or did we just draw an arbitrary line in the sand?
- Fuzzy logic reflects how people think
	- It attempts to model our
		- Sense of words
		- Decision making
		- Common sense
	- As a result, it is leading to new, more human, intelligent systems

### Fuzzy logic history

- Fuzzy, or multi-valued logic was introduced in the 1930s by **Jan Lukasiewicz**, a Polish philosopher
	- While classical logic operates with only two values, `1 = true` and `0 = false`, Lukasiewicz introduced logic that extended the range of truth values to all real numbers between `0` and `1`
	- He used a number in this interval to represent the **possibility** that a given statement was true or false
	- For example, the possibility that a man 181cm tall is really tall might be set to a value of `0.86`
		- It is **likely** that the man is tall
	- This work led to an inexact reasoning technique often called **possibility theory**
- In 1965, **Lotfi Zadeh** published his famous paper **Fuzzy sets**
	- Zadeh extended the work on possibility theory into a formal system of mathematical logic, and introduced a new concept for applying natural language terms
	- This new logic for representing and manipulating fuzzy terms was called **fuzzy logic**, and Zadeh became the master of fuzzy logic

### Why fuzzy, why logic?

- Why fuzzy
	- As Zadeh said, the term is concrete, immediate and descriptive; we all know what it means
	- However, many people in the West were repelled by the word **fuzzy**, because it is usually used in a negative sense
- Why logic
	- Fuzziness rests of fuzzy set theory, and fuzzy logic is just a small part of that theory

### Fuzzy mathematical principles

- Unlike two-valued Boolean logic, fuzzy logic is **multi-valued**
	- It deals with **degrees of membership** and **degrees of truth**
	- Fuzzy logic uses the continuum of logical values between `0` (completely false) and `1` (completely true)
	- Instead of just black and white, it employs the spectrum of colours, accepting that things can be partly true and partly false at the same time

### Boolean vs. fuzzy logic range of values

![boolean vs. fuzzy logic range of values](http://snag.gy/0JnAv.jpg)

## Fuzzy sets

- The concept of a **set** is fundamental to mathematics
- However, our own language is also the supreme expression of sets
	- For example, **car** indicates the **set of cars**
		- When we say **a car**, we mean one out of the set of cars

### Tall men fuzzy set

- The classical example in fuzzy sets is **tall men**
	- The elements of the fuzzy set **tall men** are all men, but their degrees of membership depend on their height

![tall men 1](http://snag.gy/FRmce.jpg)

![tall men 2](http://snag.gy/ZxQve.jpg)

- The **x-axis** represents the **universe of disclosure**
	- The range of all possible values applicable to a chosen variable
	- In our case, the variable is height
		- According to this representation, the universe of men's heights consists of all tall men
- The **y-axis** represents the **membership value of the fuzzy set**
	- In our case, the fuzzy set of **tall men** maps height values into corresponding membership values

### Fuzzy set with fuzzy boundaries

#### Classical sets

- Let `X` be the universe of disclosure and its elements be denoted as `x`
	- In the classical set theory,
		- Crisp set `A` of `X` is defined as function `f_A(x)` called the **characteristic function** of `A`

![classic set formula](http://snag.gy/QwiLy.jpg)

- This set maps universe `X` to a set of two elements
	- For any element `x` of universe `X`, characteristic function `f_A(x)`:
		- Is equal to 1 if `x` is an element of set `A`
		- Is equal to 0 if `x` is not an element of set `A`

#### Fuzzy sets

- In fuzzy set theory, fuzzy set `A` of universe `X` is defined by function:
	- `μ_A(x)`
	- Called the **membership function** of set `A`

![fuzzy set formula](http://snag.gy/nqwzN.jpg)

- This set allows a continuum of possible choices
- For any element `x` of universe `X`, membership function `μ_A(x)` equals the degree to which `x` is an element of set `A`
- This degree, a value between `0` and `1`, represents the **degree of membership** of element `x` in set `A`
	- Also called **membership value**

### How to represent a fuzzy set in a computer

- First, we determine the membership functions
	- In our **tall men** example, we can obtain fuzzy sets of tall, short and average men
- The universe of discourse, the men's heights, consists of three sets: short, average and tall men
	- As you will see, a man who is 184cm tall is a member of the **average men** set with a degree of membership `0.1`
		- At the same time, he is also a member of the **tall men** set with a degree of `0.4`

#### Crisp vs. fuzzy sets of short, average and tall men

![crisp vs. fuzzy short, average, tall](http://snag.gy/fazli.jpg)

### Representation of crisp and fuzzy subsets

![crisp vs. fuzzy subsets](http://snag.gy/eYKIa.jpg)

- Typical functions that can be used to represent a fuzzy set are
	- **Sigmoid**
	- **Gaussian**
	- **Pi**
- However, these functions increase the time of computation
- Therefore, in practice, most applications use
	- **Linear fit functions**

## Linguistic variables and hedges

- At the root of fuzzy set theory lies the idea of linguistic variables
- A **linguistic variable is a fuzzy variable**
	- For example, the statement "John is tall" implies that the linguistic variable `John` takes the linguistic value `tall`
- In fuzzy expert systems, linguistic variables are used in fuzzy rules
	- For example:

```
IF		wind is strong
THEN	sailing is good

IF		project_duration is long
THEN	completion_risk is high

IF		speed is slow
THEN	stopping_distance is short
```

### Hedges

- The range of possible values of a linguistic variable represents the universe of disclosure of that variable
	- For example, the universe of disclosure of the linguistic variable `speed` might have the range between `0` and `220` km/h and may include such fuzzy subsets as
		- Very slow
		- Slow
		- Medium
		- Fast
		- Very fast
- A linguistic variable carries with it the concept of fuzzy set qualifiers, called **hedges**
- **Hedges are terms that modify the shape of fuzzy sets**
	- They include adverbs such as
		- Very
		- Somewhat
		- Quite
		- More
		- Less
		- Slightly

#### Fuzzy sets with hedge "very"

![hedge very](http://snag.gy/hiAE4.jpg)

#### Representation of hedges in fuzzy logic

![representation of hedges in fuzzy logic 1](http://snag.gy/r7uuV.jpg)

![representation of hedges in fuzzy logic 2](http://snag.gy/sRzEr.jpg)

## Operations of fuzzy sets

- The classical set theory developed in the late 19th century by Georg Cantor describes how crisp sets can interact
	- These interactions are called **operations**

### Cantor's sets

![cantor's sets](http://snag.gy/OKoG9.jpg)

### Complement

- Crisp
	- Who does not belong to the set?
- Fuzzy
	- How much do elements not belong to this set?
- Description
	- The complement of a set is an opposite of this set
	- For example, if we have the set of tall men, its complement is the set of **not** tall men
	- When we remove the tall men set from the universe of discourse, we obtain the complement
	- If `A` is the fuzzy set, its complement `A'` can be found as follows:

![complement formula](http://snag.gy/d8VTP.jpg)

### Containment

- Crisp
	- Which sets belong to which other sets?
- Fuzzy
	- Which sets belong to other sets?
- Description
	- Similar to a Chinese box, a set can contain other sets
	- The smaller set is called the **subset**
	- For example, the set of tall men contains all tall men
		- Very tall men is a subset of tall men
		- However, the tall men set is just a subset of the set of men
	- In crisp sets, all elements of a subset entirely belong to a larger set
	- In fuzzy sets, each element can belong less to the subset than to the larger set
		- Elements in the fuzzy subset have smaller membership in it than in the larger set

### Intersection

- Crisp
	- Which elements belongs to both sets?
- Fuzzy
	- How much of the element is in both sets?
- Description
	- In classical set theory, an intersection between two sets contains the elements shared by these sets
	- For example, the intersection of the set of tall men and the set of fat men is the area where these sets overlap
	- In fuzzy sets, an element may partly belong to both sets with different memberships
	- A fuzzy intersection is the lower membership in both sets of each element
	- The fuzzy intersection of two fuzzy sets `A` and `B` on universe of discourse `X`:

![intersection formula](http://snag.gy/gnmC3.jpg)

### Union

- Crisp
	- Which element belongs to either set?
- Fuzzy
	- How much of the element is in either set?
- Description
	- The union of two crisp sets consists of every element that falls into either set
	- For example, the union of tall men and fat men contains all men who are tall **or** fat
	- In fuzzy sets, the union is the reverse of the intersection
		- That is, the union is the largest membership value of the element in either set
		- The fuzzy operation for forming the union of two fuzzy sets `A` and `B` on universe `X` can be given as:

![union formula](http://snag.gy/bMRqJ.jpg)

### Fuzzy set operation models

![fuzzy set operation models](http://snag.gy/GDWOE.jpg)

## Fuzzy rules

- In 1973, Lofti Zadeh published his second most influential paper
	- This paper outlined a new approach to analysis of complex systems, in which Zadeh suggested capturing human knowledge in fuzzy rules

### What is a fuzzy rule?

- A fuzzy rule can be defined as a conditional statement in the form:

```
IF		x is A
THEN	y is B
```

- Where `x` and `y` are linguistic variables
	- `A` and `B` are linguistic values determined by fuzzy sets on the universe of discourses `X` and `Y` respectively

### Classic vs. fuzzy rules

#### Classic example

- A classical `IF-THEN` rule uses binary logic
	- For example:

```
Rule 1:
IF		speed is > 100
THEN	stopping_distance is long

Rule 2:
IF		speed is < 40
THEN	stopping_distance is short
```

- The variable `speed` can have any numerical value between 0 and 220 km/h, but the linguistic variable `stopping_distance` can take either value `long` or `short`
	- In other words, classical rules are expressed in the black and white language of boolean logic

#### Fuzzy example

- We can also represent the stopping distance rules in a fuzzy form:

```
Rule 1:
IF		speed is fast
THEN	stopping_distance is long

Rule 2:

IF		speed is slow
THEN	stopping_distance is short
```

- In fuzzy rules, the linguistic variable `speed` also has the range (universe of discourse) between 0 and 220 km/h, but this range includes fuzzy sets, such as
	- Slow
	- Medium
	- Fast
- The universe of discourse of the linguistic variable `stopping_distance` can be between 0 and 300m and may include such fuzzy sets as
	- Short
	- Medium
	- Long

### Fuzzy rules relations

- Fuzzy rules relate to fuzzy sets
- In a fuzzy system, all rules fire to some extent
	- In other words, they partially fire
	- If the antecedent is true to some degree of membership, then the consequent is also true to the same degree

### Fuzzy sets of tall and heavy men

![fuzzy sets tall and heavy men](http://snag.gy/C01LZ.jpg)

- These fuzzy sets provide the basis for a weight estimation model
	- The model is based on a relationship between a man's height and his weight

```
IF		height is tall
THEN	weight is heavy
```

- The value of the output or a truth membership grade of the rule consequent can be estimated directly from a corresponding truth membership grade in the antecedent
	- This for of fuzzy inference uses a method called **monotonic selection**

![monotonic selection](http://snag.gy/EK3Ls.jpg)

### Multiple antecedents and consequents

- A fuzzy rule can have multiple antecedents:

```
IF		project_duration is long
AND		project_staffing is large
AND		project_funding is inadequate
THEN	risk is high

IF		service is excellent
OR		food is delicious
THEN	tip is generous
```

- The consequent of a fuzzy rule can also include multiple parts:

```
IF		temperature is hot
THEN	hot_water is reduced;
		cold_water is increased
```

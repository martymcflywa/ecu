# Fuzzy expert systems: Fuzzy inference

## Overview

- Mamdani fuzzy inference
- Sugeno fuzzy inference
- Case study
- Summary

## Fuzzy inference

- The most commonly used fuzzy inference technique is called **Mamdani** method
- In 1975 Profession Ebrahim Mamdani of London University built one of the first fuzzy systems to control a steam engine and boiler combination
- He applied a set of fuzzy rules supplied by experienced human operators

### Mamdani fuzzy inference

- The Mamdani style inference process is performed in four steps
	1. Fuzzification of the input variables
	2. Rule evaluation
	3. Aggregation of the rule outputs
	4. Defuzzification

### Mamdani example

- We examine a simple two input, one output problem that includes three rules:

```
Rule 1					Rule 1
IF		x is A3			IF		project_funding is adequate
OR		y is B1			OR		project_staffing is small
THEN	z is C1			THEN	risk is low

Rule 2					Rule 2
IF		x is A2			IF		project_funding is marginal
AND		y is B2			AND		project_staffing is large
THEN	z is C2			THEN	risk is normal

Rule 3					Rule 3
IF		x is A1			IF		project_funding is inadequate
THEN	z is C3			THEN	risk is high
```

### Step 1: Fuzzification

- The first step is to take the crisp inputs
	- `x1 = project_funding`
	- `y1 = project_staffing`
- And determine the degree to which these inputs belong to each of the appropriate fuzzy sets

![step 1: fuzzification](http://snag.gy/LpTWx.jpg)

### Step 2: Rule evaluation

- The second step is to take the fuzzified inputs:

![step 2: fuzzified inputs](http://snag.gy/gBOyY.jpg)

- And apply them to the antecedents of the fuzzy rules
- If a given fuzzy rule has multiple antecedents
	- The fuzzy operator `AND`, `OR` is used to obtain a single number that represents the result of the antecedent evaluation
- This number (the **truth** value) is then applied to the consequent membership function

#### Dealing with `OR` and `AND`

##### `OR` disjunction

- Apply **fuzzy union**:

![fuzzy union](http://snag.gy/pwWfl.jpg)

##### `AND` conjunction

- Apply **fuzzy intersection**:

![fuzzy intersection](http://snag.gy/W4XId.jpg)

#### Mamdani style rule evaluation

![mamdani style rule evaluation](http://snag.gy/uPeKA.jpg)

#### Clipping and scaling

- Now the result of the antecedent evaluation can be applied to the membership function of the consequent

##### Clipping

- The most common method of correlating the rule consequent with the truth value of the rule antecedent
- Cut the consequent membership function at the level of the antecedent truth
- Since the top of the membership function is sliced, the clipped fuzzy set loses some information
- However, clipping is still often preferred because it involves less complex and faster mathematics, and generates an aggregated output surface that is easier to defuzzify

##### Scaling

- While clipping is a frequently used method, **scaling** offers a better approach for preserving the original fuzzy set
- The original membership function of the rule consequent is scaled by
	- **Multiplying all its membership degrees by the truth value of the antecedent**
- This method, which generally loses less information, can be useful in fuzzy expert systems
- The example below shows **clipping** on the left side, and **scaling** on the right

![clipping scaling](http://snag.gy/bYQeX.jpg)

### Step 3: Aggregation of the rule outputs

- Aggregation is the process of unification of the output of all rules
	- We take the membership functions of all rule consequents previously clipped or scaled and **combine them into a single fuzzy set**
		- **Input** of the aggregation process
			- List of clipped or scaled consequent membership functions
		- **Output**
			- One fuzzy set for each output variable

![aggregation of the rule outputs](http://snag.gy/HloEI.jpg)

### Step 4: Defuzzification

- The last step in the fuzzy inference process is defuzzification
	- Fuzziness helps us to evaluate the rules
		- But the final output of a fuzzy system has to be a crisp number
	- **Input** for the defuzzification process is the aggregate output fuzzy set
	- **Output** is a single number

#### Centroid technique

- There are several defuzzification methods, but the most popular one is the **centroid technique**
- It finds the point where a vertical line would slice the aggregate set into two equal masses
- Mathematically this is **center of gravity (COG)** can be expressed as:

![center of gravity formula](http://snag.gy/xauGr.jpg)

- Centroid defuzzification method finds a point representing the center of gravity of the fuzzy set, `A`, on the interval, `ab`
- A reasonable estimate can be obtained by calculating it over a sample of points

>Summation of membership degree for each data point  
Divided by  
Summation of each sampled point

![sample of points](http://snag.gy/zQ3ka.jpg)

##### Center of gravity (COG)

![cog formula example](http://snag.gy/DgzWU.jpg)

![cog model](http://snag.gy/EaIBA.jpg)

## Sugeno fuzzy inference

- Mamdani style inference requires us to find the centroid of a two-dimensional shape by integrating across a continuously varying function
	- In general, this process is not computationally efficient
	- **Michio Sugeno** suggested to use a **single spike** (a singleton) as the membership function of the rule consequent
		- A **fuzzy singleton** is a fuzzy set with a membership function that is:
			- Unity at a single particular point on the universe of discourse
			- Zero everywhere else
- Sugeno style fuzzy inference is very similar to the Mamdani method
	- Sugeno changed only a rule consequent
	- Instead of a fuzzy set, he used a mathematical function of the input variable
	- The format of the Sugeno style fuzzy rule is:

```
IF		x is A
AND		y is B
THEN	z is f(x,y)
```

- Where `x`, `y` and `z` are linguistic variables
	- `A` and `B` are fuzzy sets on universe of discourses `X` and `Y` respectively
	- `f(x,y)` is a mathematical function

### Sugeno function `f(x,y)`

- Linear combination of inputs

![sugeno f(x,y)](http://snag.gy/wydx8.jpg)

- `c_i`: Constants that can be found using **least-square fit** algorithm
- The formula for a general `N` dimension of space below
	- ie. There are `N` elements of the input vector:

![original sugeno function](http://snag.gy/rARVx.jpg)

- The second term is omitted for simplicity for our study in this unit
- `f(x,y) = c_0`
	- Singleton membership function (impulse spike shape)
		- `1.0` at `c_0`
		- `0.0` otherwise

### Zero-order Sugeno fuzzy model

- The most commonly used **zero-order** Sugeno fuzzy model applies fuzzy rules in the following form:

```
IF		x is A
AND		y is B
THEN	z is k
```

- Where `k` is a constant
	- In this case, the output of each fuzzy rule is constant
	- All consequent membership functions are represented by singleton spikes

### Sugeno style rule evaluation

![sugeno style rule evaluation](http://snag.gy/vxc94.jpg)

#### Sugeno style aggregation of the rule outputs

![sugeno style aggregation of the rule outputs](http://snag.gy/Rctrd.jpg)

#### Weighted average

- Use weighted average to produce crisp output

![weighted average](http://snag.gy/6yuIH.jpg)

- `mu(k_1)`
	- Membership value
	- Value along y axis of the set
- `k_1`
	- Fuzzy set value
	- Value along x axis

![sugeno crisp output](http://snag.gy/E02F5.jpg)

## Mamdani vs. Sugeno

- **Mamdani** is widely accepted for capturing expert knowledge
	- Allows to describe the expertise in more intuitive, more human like manner
	- Mamdani entails a substantial computational burden
- **Sugeno** is computationally effective
	- Works well with optimisation and adaptive techniques
		- Also more flexible
	- Makes it attractive in control problems
		- Particularly for dynamic, nonlinear systems

# Building a fuzzy expert system: Case study

- A service center keeps spare parts and repairs failed ones
- A customer brings a failed item and receives a spare of the same type
- Failed parts are repaired, placed on the shelf and thus become spares
- The objective here is to advise a manager of the service center on certain decision policies to keep the customers satisfied

## Process of developing a fuzzy expert system

1. Specify the problem and define linguistic variables
2. Determine fuzzy sets
3. Elicit and construct fuzzy rules
4. Encode the following to perform fuzzy inference into the expert system
	- Fuzzy sets
	- Fuzzy rules
	- Procedures
5. Evaluate and tune the system

## Step 1: Specify problem and define linguistic variables

- There are four main linguistic variables
	- Average waiting time (mean delay)
		- `m`
	- Repair utilisation factor of the service center
		- `p`
	- Number of servers
		- `s`
	- Initial number of spare parts
		- `n`

### Linguistic variables / ranges

![linguistic variable ranges](http://snag.gy/Dy743.jpg)

## Step 2: Determine fuzzy sets

- Fuzzy sets can have a variety of shapes
	- However, a triangle or trapezoid can often provide an adequate representation of the expert knowledge
	- It also significantly simplifies computation

### Fuzzy set `m`: Mean delay

![fuzzy set: m](http://snag.gy/UmWzn.jpg)

- Needs the following sets to cover the entire universe of discourse
	- `long`
	- `very long`

### Fuzzy set `p`: Repair utilisation factor

![fuzzy set: p](http://snag.gy/hNsrQ.jpg)

### Fuzzy set `s`: Number of servers

![fuzzy set: s](http://snag.gy/KSMpY.jpg)

### Fuzzy set `n`: Number of spares

![fuzzy set: n](http://snag.gy/MJqR5.jpg)

## Step 3: Elicit and construct fuzzy rules

- To accomplish this task, we might ask the expert to describe how the problem can be solved using the fuzzy linguistic variables defined previously
	- Required knowledge also can be collected from other sources such as
		- Books
		- Computer databases
		- Flow diagrams
		- Observed human behaviour
- If there are 3 inputs and 1 output, the representation takes the shape of a **M x N x K** cube, which is called a **Fuzzy Associative Memory (FAM)**

### Square Fuzzy Associated Memory (FAM) representation

- 2 input variables for square FAM

![fam](http://snag.gy/U3N6u.jpg)

### Rule table

![rule table](http://snag.gy/WrS7N.jpg)

### Rule base 1

![rule base 1](http://snag.gy/5H4OQ.jpg)

### Cube FAM: Rule base 2

- Greater than 2 input variables for cube FAM

![cube fam rule base 2](http://snag.gy/GPJCd.jpg)

## Step 4: Encode fuzzy sets, rules, procedures

- Encode fuzzy sets, rules, procedures to perform fuzzy inference into the expert system
	- To accomplish this task, we may choose one of two options
		- Build our system using a programming language
			- C/C++
			- Pascal
		- Apply a fuzzy logic development tool
			- MATLAB fuzzy logic toolbox
			- Fuzzy knowledge builder

## Step 5: Evaluate and tune the system

- We want to see whether our fuzzy system meets the requirements specified at the beginning
- Several test situations depend on
	- The mean delay
	- Number of servers
	- Repair utilisation factors
- The fuzzy logic toolbox can generate surface to help us analyse the system's performance

### 3D plots: Rule base 1

![3d plot: n, m, s 1](http://snag.gy/9HFHm.jpg)

![3d plot: n, m, p 1](http://snag.gy/NhJCV.jpg)

![3d plot: n, m, s 2](http://snag.gy/0eRQJ.jpg)

![3d plot: n, m, p 2](http://snag.gy/OM4Ax.jpg)

### Improving the expert system

- However, the expert might not be satisfied with the system performance
- To improve system performance, we may use additional sets on the universe of discourse `number_of_servers`, or `p` then extend the rule base
	- Rather small
		- `RS`
	- Rather large
		- `RL`

#### Modified fuzzy sets: Number of servers `s`

![modified number of servers](http://snag.gy/nxxhL.jpg)

#### Cube FAM: Rule base 3

![cube fam rule base 3](http://snag.gy/gJAsS.jpg)

#### 3D plots: Rule base 3

![3d plot: rule base 3.1](http://snag.gy/y4nsC.jpg)

![3d plot: rule base 3.2](http://snag.gy/8DiCJ.jpg)

### Tuning fuzzy systems

1. Review model input and output variables
	- If required, redefine ranges
2. Review the fuzzy sets
	- If required, define additional sets on the universe of discourse
	- The use of wide fuzzy sets may cause the fuzzy system to perform roughly
3. Provide sufficient overlap between neighbouring sets
	- It is suggested that:
		- **Triangle-to-triangle** and **trapezoid-to-triangle** fuzzy sets should overlap between 25% to 50% of their bases
4. Review the existing rules
	- If required, add new rules to the rule base
5. Examine the rule base for opportunities to write hedge rules
	- Captures the pathological behaviour of the system
6. Adjust the rule execution weights
	- Most fuzzy logic tools allow control of the importance of rules by changing a weight multiplier
7. Revise shapes of the fuzzy sets
	- In most cases, fuzzy systems are highly tolerant of shape approximation

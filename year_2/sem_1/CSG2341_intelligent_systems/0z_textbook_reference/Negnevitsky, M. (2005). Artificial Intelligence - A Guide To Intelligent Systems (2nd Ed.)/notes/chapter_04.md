# Chapter 4: Fuzzy expert systems

## 4.1 Introduction: What is fuzzy thinking

- Experts rely on common sense when problem solving
- Use vague and ambiguous terms
	- Example
		- Thought power transformer is **slightly** overloaded, i can keep this load for **awhile**
- Chapter explores
	- Fuzzy set theory
	- Fuzzy logic

### Fuzzy logic

- Fuzzy logic is not logic that is fuzzy
- It is logic that is used to describe fuzziness
- The theory of fuzzy sets
	- Sets that calibrate vagueness
- Based on the idea that all things admit of degrees
	- All things come on a sliding scale
		- Temperature
		- Height
		- Speed
		- Distance
	- Makes it impossible to distinguish members of a class from non members
		- When does a hill become a mountain?
- Reflects how people think
- Attempts to model
	- Sense of words
	- Decision making
	- Common sense

![figure 4.1](http://snag.gy/Wmfan.jpg)

### Boolean logic

- Uses sharp distinctions
- Forces to draw lines between members/non-members of a class

### Why fuzzy

- The term is concrete, immediate and descriptive

### Why logic

- Rests on fuzzy set theory
- Fuzzy logic is just a small part of that theory
- Is determined as a set of mathematical principles for knowledge representation
	- Based on degrees of membership
	- Rather than crisp membership of classical binary logic
- Unlike boolean logic
	- Fuzzy logic is multi valued
	- Deals with
		- Degrees of membership
		- Degrees of truth
- Uses continuum of logical values between
	- 0 = completely false
	- 1 = completely true
- Employs spectrum of colors
	- Instead of black and white
	- Accepts things can be partly true and false at the same time

## 4.2 Fuzzy sets

- Crisp set theory
	- Governed by logic that uses one of only two values
		- True or false
	- Cannot represent vague concepts
- Fuzzy sets
	- Basic idea
		- An element belongs to a fuzzy set with a certain degree of membership
		- A proposition is not either true or false
			- But may be partly true/false to any degree
				- Degree is usually taken as a real number
					- Between 0 and 1

### Classical example

- Tall men
- Elements of fuzzy set *tall men* are all men
	- Their degrees of membership depend on their height
		- See table 4.1

![table 4.1](http://snag.gy/TVrUy.jpg)

- Crisp set
	- Asks the question
		- Is the man tall?
	- Draws a line at 180cm
	- Tall men are above this height
	- Not tall men are below
- Fuzzy set
	- Asks question
		- How tall is the man
	- The answer is the partial membership in the fuzzy set
	- Example
		- Tom is 0.82 tall
- Fuzzy set is capable of providing a graceful transition across a boundary
	- See figure 4.2

![figure 4.2](http://snag.gy/dmgcW.jpg)

- Figure 4.2
	- Horizontal axis
		- Represents the universe of discourse
		- Variable is human height
	- Vertical axis
		- Represents membership value of the fuzzy set
		- Maps height values into corresponding membership values
		- Example
			- David
				- 179cm tall
				- Just 2cm shorter than Tom
				- No longer suddenly becomes not tall (short)
			- David and other men are gradually removed from the set of tall men according to the decrease of their heights

### What is a fuzzy set

- Defined as a set with fuzzy boundaries
- Let X be the universe of discourse and its elements be denoted as x

#### Classical set theory

- In classical set theory
	- Crisp set A of X is defined as function f<sub>A</sub>(x)
		- Called the **characteristic function** of A

![equation 4.1](http://snag.gy/kpZic.jpg)

- This set maps universe X to a set of two elements
- For any element x of universe X
	- Characteristic function f<sub>A</sub>(x)
		- Is equal to 1 if x is an element of set A
		- Is equal to 0 if x is not an element of set A

#### Fuzzy set theory

- Fuzzy set A of universe A is defined by function &mu;<sub>A</sub>(x)
	- Called the **membership function** of set A

![equation 4.2](http://snag.gy/1mwkh.jpg)

- This set allows a continuum of possible choices
- For any element x of universe X
	- Membership function &mu;<sub>A</sub>(x) equals the degree to which x is an element of set A
- This degree represents the **degree of membership**
	- Value between 0 and 1
	- Also called **membership value** of element x in set A

### How to represent a fuzzy set in a computer

- Membership function must be determined first
- A number of methods learned from knowledge acquisition can be applied here
- Can use
	- An expert
	- Multiple experts
	- Neural network
		- Learns available system operation data
		- Derives fuzzy sets automatically
- Example figure 4.3
	- Universe of discourse consists of three fuzzy sets
		- Short
		- Average
		- Tall
	- A man who is 184 cm tall is a member of
		- Average set
			- Degree of membership = 0.1
		- Tall set
			- Degree of membership = 0.4
		- Partial membership in multiple sets

![figure 4.3](http://snag.gy/ZEh0U.jpg)

- The universe of discourse X
	- A crisp set containing five elements
		- X = {x<sub>1</sub>, x<sub>2</sub>, x<sub>3</sub>, x<sub>4</sub>, x<sub>5</sub>}
- Let A be a crisp subset of X
- Assume A consists of two elements
	- A = {x<sub>2</sub>, x<sub>3</sub>}
- Subset A can be described as
	- A = {(x<sub>1</sub>, 0), (x<sub>2</sub>, 1), (x<sub>3</sub>, 1), (x<sub>4</sub>, 0), (x<sub>5</sub>, 0)}
	- ie. As a set of pairs {x<sub>i</sub>, &mu;<sub>A</sub>(x<sub>i</sub>)}
		- Where &mu;<sub>A</sub>(x<sub>i</sub>) is the membership function of element x<sub>i</sub> in subset A
- The question is whether &mu;<sub>A</sub>(x<sub>i</sub>)
	- Can take only two values
		- 0 or 1
	- Or any value between 0 and 1
- If X is the reference super set and A is a subset of X
	- Then A is said to be a fuzzy set of X
		- If, and only if:

![equation 4.3](http://snag.gy/YTCPb.jpg)

- In a special case, when X &rarr; {0,1} is used instead of X &rarr; [0,1]
	- The fuzzy subset A becomes the crisp subset A
- Fuzzy and crisp sets can also be represented as shown in figure 4.4

![figure 4.4](http://snag.gy/vCgDz.jpg)

- Fuzzy subset A of the finite reference super set X can be expressed as:

![equation 4.4](http://snag.gy/7Mkge.jpg)

- However it is more convenient to represent A as:

![equation 4.5](http://snag.gy/NiNvK.jpg)

- Where the separating symbol `/` is used to associate the membership value with its coordinate on the horizontal axis
- To represent a continuous fuzzy set in a computer
	- We need to express it as a function
	- Then map the elements of the set to their degree of membership
- Typical functions that can be used are
	- Sigmoid
	- Gaussian
	- Pi
- These functions can represent the real data in fuzzy sets
	- Also increase time of computation
- In practice
	- Most applications use **linear fit functions**
		- Similar to figure 4.3
- Example
	- Fuzzy set of tall men in figure 4.3 can be represented as a **fit-vector**

>tall men = (0/180, 0.5/185, 1/190) or  
>tall men = (0/180, 1/190)

## 4.3 Linguistic variables and hedges

- Linguistic variable is a fuzzy variable
- Example
	- John is tall
		- Implies that the linguistic variable John takes the linguistic value tall
- In fuzzy expert systems
	- Linguistic variables are used in fuzzy rules

```
IF wind is strong
THEN sailing is good

IF project_duration too long
THEN completion_risk is high

IF speed is slow
THEN stopping_distance is short
```

- Range of possible values of a linguistic variable represents the universe of discourse of that variable
- Linguistic variable carries with it the concept of fuzzy set qualifiers
	- Called **hedges**

### Hedges

- Terms that modify the shape of fuzzy sets
- Include adverbs
	- Very
	- Somewhat
	- Quite
	- More or less
	- Slightly
- Used as
	- All purpose modifiers
		- Very
		- Quite
		- Extremely
	- Truth values
		- Quite true
		- Mostly false
	- Probabilities
		- Likely
		- Not very likely
	- Quantifiers
		- Most
		- Several
		- Few
	- Possibilities
		- Almost impossible
		- Quite possible
- Act as operations themselves
	- Very performs concentration
		- Creates a new subset
	- From set of tall men
		- Derives the subset of very tall men
	- More or less performs dilation
		- Opposite to concentration
		- Expands the set
		- More or less tall men is broader than set of tall men
- Can break down continuums into fuzzy intervals
	- Example
		- Hedges could be used to describe temperature
			- Very cold
			- Moderately cold
			- Slightly cold
			- Neutral
			- Slightly hot
			- Moderately hot
			- Very hot
		- These fuzzy sets overlap
- Hedges help to reflect human thinking
	- People cannot usually distinguish between slightly hot and moderately hot
- Figure 4.5 shows application of hedges
	- Sets shown in figure 4.3 are modified mathematically by the hedge very

![figure 4.5](http://snag.gy/pv0X8.jpg)

- Example
	- Man who is 185cm tall
		- Member of tall men set
			- Degree of membership = 0.5
		- Also member of very tall men
			- Degree of membership = 0.14

#### Hedges in practical applications

##### Very

- Concentration
- Narrows a set down
- Reduces the degree of membership of fuzzy elements
- Operation can be given as a mathematical square

![equation 4.6](http://snag.gy/vrf40.jpg)

- Tom has a 0.86 membership in set of tall men
	- 0.7396 membership in set of very tall men

##### Extremely

- Same purpose as very
- Does it at a greater extent
- Can be performed by raising to the third power

![equation 4.7](http://snag.gy/OWPTr.jpg)

- Tom has 0.86 membership in set of tall men
	- 0.7396 membership in set of very tall men
	- 0.6361 membership in set of extremely tall men

##### Very very

- Extension of concentration
- Can be performed as square of the concentration operation

![equation 4.8](http://snag.gy/GMPzd.jpg)

- Tom has 0.86 membership in tall men set
	- 0.7396 membership in very tall men set
	- 0.5470 membership in very very tall men set

##### More or less

- Operation of dilation
- Expands set
- Increases degree of membership of fuzzy elements
- Can be performed as square root

![equation 4.9](http://snag.gy/efO1x.jpg)

- Tom has 0.86 membership in tall men set
	- 0.9274 membership in more or less tall men set

##### Indeed

- Operation of intensification
- Intensifies meaning of whole sentence
- Can be performed by
	- Increasing the degree of membership above 0.5
	- Decreasing the degree of membership below 0.5

![equation 4.10/11](http://snag.gy/feGSB.jpg)

- Tom has 0.86 membership in tall men set
	- 0.9608 membership in indeed tall men set
- Mike has 0.24 membership in tall men set
	- 0.1152 membership in indeed tall men set

#### Representation of hedges in fuzzy logic

![table 4.2](http://snag.gy/72qVl.jpg)

## 4.4 Operation of fuzzy sets

![figure 4.6](http://snag.gy/pJBFb.jpg)

![figure 4.7](http://snag.gy/dyAew.jpg)

### Complement

- Crisp
	- Who does not belong to the set?
- Fuzzy
	- How much do elements not belong to the set?
- Opposite of the set
- Example
	- Set of tall men
	- Complement is set of NOT tall men
- Operation:
	- -1

![equation 4.12](http://snag.gy/Jia3I.jpg)

>tall men = (0/180, 0.25/182.5, 0.5/185, 0.75/187.5, 1/190)  
>NOT tall men = (1/180, 0.75/182.5, 0.5/185, 0.25/187.5, 0/190)

### Containment/Subset

- Crisp
	- Which sets belong to which other sets?
	- All elements of a subset entirely belong to a larger set
	- Membership values are 1
- Fuzzy
	- Which sets belong to other sets?
	- Each element can belong less to the subset than to the superset
	- Elements of fuzzy subset have smaller memberships in it than larger set

>tall men = (0/180, 0.25/182.5, 0.5/185, 0.75/187.5, 1/190)  
>very tall men = (0/180, 0.06/182.5, 0.25/185, 0.56/187.5, 1/190)

### Intersection

- Crisp
	- Which element belongs to both sets?
	- Contains elements shared by these sets
	- Intersection is area where sets overlap
- Fuzzy
	- How much of the element is in both sets?
	- An element may partly belong to both sets with different memberships
	- Is the lower membership of both sets of each element
- Operation:
	- min()

![equation 4.13](http://snag.gy/FMcc5.jpg)

>tall men = (0/165, 0/175, 0.0/180, 0.25/182.5, 0.5/185, 1/190)  
>average men = (0/165, 1/175, 0.5/180, 0.25/182.5, 0.0/185, 0/190)  
>tall men &cap; average men = (0/165, 0/175, 0.0/180, 0.25/182.5, 0.0/185, 0/190)

### Union

- Crisp
	- Which element belongs to either set?
	- Consists of every element that falls into either set
- Fuzzy
	- How much of the element is in either set?
	- Reverse of intersection
	- Largest membership value of the element in either set
- Operation
	- max()

![equation 4.14](http://snag.gy/5L4hD.jpg)

>tall men = (0/165, 0/175, 0.0/180, 0.25/182.5, 0.5/185, 1/190)  
>average men = (0/165, 1/175, 0.5/180, 0.25/182.5, 0.0/185, 0/190)  
>tall men &cup; average men = (0/165, 1/175, 0.5/180, 0.25/182.5, 0.5/185, 1/190)

### Properties

#### Commutativity

>A &cup; B = B &cup; A  
>A &cap; B = B &cap; A

- tall men OR short men = short men OR tall men
- tall men AND short men = short men AND tall men

#### Associativity

>A &cup; (B &cup; C) = (A &cup; B) &cup; C  
>A &cap; (B &cap; C) = (A &cap; B) &cap; C

- tall men OR (short men OR average men) = (tall men OR short men) OR average men
- tall men AND (short men AND average men) = (tall men AND short men) AND average men

#### Distributivity

>A &cup; (B &cap; C) = (A &cup; B) &cap; (A &cup; C)  
>A &cap; (B &cup; C) = (A &cap; B) &cup; (A &cap; C)

- tall men OR (short men AND average men) = (tall men OR short men) AND (tall men OR average men)
- tall men AND (short men OR average men) = (tall men AND short men) OR (tall men AND average men)

#### Idempotency

>A &cup; A = A  
>A &cap; A = A

- tall men OR tall men = tall men
- tall men AND tall men = tall men

#### Identity

>A &cup; &empty; = A  
>A &cap; X = A  
>A &cap; &empty; = &empty;  
>A &cup; X = X

- tall men OR empty set = tall men
- tall men AND unknown = tall men
- tall men AND empty set = empty set
- tall men OR unknown = unknown
- Where
	- Empty set
		- The set having all degrees of membership = 0
	- Unknown
		- The set having all degree of memberships = 1

#### Involution

>'('A) = A

- NOT (NOT tall men) = tall men

#### Transitivity

>(A &sub; B) &cap; (B &sub; C) &rarr; A &sub; C

- Every set contains the subsets of its subsets
- IF (extremely tall men &sub; very tall men) AND (very tall men &sub; tall men) THEN (extremely tall men &sub; tall men)

#### De Morgan's laws

>'(A &cap; B) = 'A &cup; 'B  
>'(A &cup; B) = 'A &cap; 'B

- NOT (tall men AND short men) = NOT tall men OR NOT short men
- NOT (tall men OR short men) =  NOT tall men AND NOT short men

### Obtaining variations of fuzzy sets

- Using fuzzy set operations, properties and hedges
	- Can obtain a variety of fuzzy sets from existing ones
- Example
	- Fuzzy set A = tall men
	- Fuzzy set B = short men
	- Can derive
		- Fuzzy set C = not very tall men
		- Fuzzy set D = not very very tall and not very very short men
	- From following operations:

![derived fuzzy sets](http://snag.gy/5NWSs.jpg)

## 4.5 Fuzzy rules

### What is a fuzzy rule

- Defined as a conditional statement

```
IF x is A
THEN y is B
```

- Where
	- x and y are linguistic variables
	- A and B are linguistic values
		- Determined by fuzzy sets on universe of discourses X and Y

### What is the different between classical and fuzzy rules

- Classical
	- IF-THEN rules use binary logic
	- Expressed in black and white language of boolean logic

```
IF speed is > 100
THEN stopping_distance is long

IF speed is < 40
THEN stopping_distance is short
```

- Fuzzy
	- Uses fuzzy sets

```
IF speed is fast
THEN stopping_distance is long

IF speed is slow
THEN stopping_distance is short
```

### How to reason with fuzzy rules

- Includes two distinct parts
	- Antecedent
	- Implication/applying consequent
- Classical
	- If antecedent is true
	- Consequent is true
- Fuzzy
	- All rules fire to some extent
		- Fire partially
	- If antecedent is true to some degree of membership
	- Consequent is true to that same degree

![figure 4.8](http://snag.gy/8RQEZ.jpg)

![figure 4.9](http://snag.gy/Q2oPT.jpg)

- Fuzzy sets provide basis for weight estimation model
	- Based on relationship between man's height and weight
	- Expressed as single fuzzy rule:

```
IF height is tall
THEN weight is heavy
```

- Monotonic selection
	- Value of the output or a truth membership grade of the rule consequent can be estimated directly from a corresponding truth membership grade in the antecedent

### Can the consequent of a fuzzy rule have multiple parts

- Consequent can include multiple parts:

```
IF temperature is hot
THEN hot_water is reduced;
	cold_water is increased
```

- All parts of the consequent are affected equally by antecedent
- In general
	- Fuzzy expert system incorporates several rules that describe expert knowledge
		- Play off one another
- Output of each rule is a fuzzy set
	- Usually need to obtain a single number representing the expert system output
	- We want to get a precise solution
		- Not a fuzzy one

### How are all output fuzzy sets combined/transformed into a single number

- To obtain a single crisp solution for output variable
	- Aggregate all output fuzzy sets into a single output fuzzy set
	- Defuzzifies resulting fuzzy set into a single number

## 4.6 Fuzzy inference

- Defined as the process of mapping from a given input to an output
	- Using theory of fuzzy sets

### 4.6.1 Mamdani style inference

![figure 4.10](http://snag.gy/7mAmj.jpg)

- Four steps
	1. Fuzzification of input variables
	2. Rule evaluation
	3. Aggregation of rule outputs
	4. Defuzzification

#### Example

- Two input
- One output
- Three rules

```
Rule 1:
IF (x1) project_funding is (A3) adequate
OR (y1) project_staffing is (B1) small
THEN (z1) risk is (C1) low

Rule 2:
IF (x2) project_funding is (A2) marginal
OR (y2) project_staffing is (B2) large
THEN (z2) risk is (C2) normal

Rule 3:
IF (x3) project_funding is (A1) inadequate
THEN (z3) risk is (C3) high
```

#### Step 1: Fuzzification

- Crisp inputs
	- x1: project_funding
	- y1: project_stffing
- Determine the degree to which these inputs belong to each of the appropriate fuzzy sets

##### What is a crisp input and how is it determined

- Always a numerical value limited to universe of discourse
	- x1: Universe of discourse X
	- y1: Universe of discourse Y
- Range of universe of discourse can be determined by expert judgments
- Once crisp input obtained
	- They are fuzzified against linguistic fuzzy sets
		- Input x1 = 0.35 corresponds to membership functions
			- A1: inadequate = 0.5
			- A2: marginal = 0.2
		- Input y1 = 0.6 corresponds to membership functions
			- B1: small = 0.1
			- B2: large = 0.7
	- Each input is fuzzified over all the membership functions used by the fuzzy rules

#### Step 2: Rule evaluation

- Take fuzzified inputs
- Apply them to antecedents of the fuzzy rules
- If given rule has multiple antecedents
	- Fuzzy operator AND|OR is used to obtain a single number that represents the result of the antecedent evaluation
- Truth value is then applied to the consequent membership function
- Disjunction (OR)
	- Uses union operation
	- max()
- Conjunction (AND)
	- Uses intersection operation
	- min()
- Result of antecedent is applied to membership function of consequent
	- Clipped/scaled to level of truth value of rule antecedent
- Figure 4.11
	- Rule 2 representation

![figure 4.11](http://snag.gy/WY8JE.jpg)

##### Clipped/scaled

- Clipping
	- Most common method of correlating rule consequent with truth value of rule antecedent
	- Cut the consequent membership function at the level of the antecedent truth
		- Called
			- Clipping
			- Correlation minimum
	- Since top of the membership function is sliced
		- Clipped fuzzy set loses some information
	- Clipping is still preferred
		- Involves less complex/faster mathematics
		- Generates an aggregated output surface that is easier to defuzzify
- Scaling
	- Also called correlation product
	- Better approach for preserving shape of fuzzy set
	- Original membership function of the rule consequent is adjusted
		- Multiplying all its membership degrees by the truth value of the rule antecedent
	- Loses less information
		- Useful in fuzzy expert systems
- See figure 4.12

![figure 4.12](http://snag.gy/icHoS.jpg)

#### Step 3: Aggregation of the rule outputs

- Unification of the outputs of all rules
- Take membership functions of all rule consequents clipped or scaled
	- Combine into a single fuzzy set
- Aggregation process
	- Input
		- List of clipped or scaled consequent membership functions
	- Output
		- One fuzzy set for each output variable
- Figure 4.10 shows how the output of each rule is aggregated into a single fuzzy set for the overall fuzzy output

#### Step 4: Defuzzification

- Output has to be a crisp number
- Input
	- Aggregate output fuzzy set
- Output
	- Single crisp number
- Can use centroid technique

##### Centroid technique

- Finds the point where a vertical line would slice the aggregate set into two equal masses
- Centre of gravity (COG) expressed as:

![equation 4.17](http://snag.gy/G0A3J.jpg)

- Figure 4.13 shows centroid defuzzification method
	- Finds a point representing the COG of
		- Fuzzy set A
		- On interval ab
- In theory
	- The COG is calculated over a continuum of points in the aggregate output membership function
- In practice
	- Reasonable estimate is gained by calculating over a sample of points
		- Shown in figure 4.13
	- With following formula:

![equation 4.18](http://snag.gy/Cb6B1.jpg)

![figure 4.13](http://snag.gy/WLydh.jpg)

- Calculating the COG for figure 4.14:

![figure 4.14](http://snag.gy/9qUFD.jpg)

- Result
	- Crisp output z1 = 67.4
	- Risk involved in fuzzy project is 67.4%

### 4.6.2 Sugeno style inference

![figure 4.15](http://snag.gy/gKCK8.jpg)

- Mamdani style inference not computationally efficient
	- When calculating centroid of 2d shape
- Sugeno very similar to mamdi method
	- Only difference
		- Rule consequent
		- Instead of fuzzy set
		- Uses mathematical function of the input variable

#### Shortening time of fuzzy inference

- Use a single spike as the membership function of the rule consequent
	- Fuzzy singleton
		- Fuzzy set with membership function that is unity at a single particular point on universe of disclosure


#### Format of Sugeno style rule

```
IF x is A
AND y is B
THEN z is f(x,y)
```

- Where
	- x, y, z are linguistic variables
	- A and B are fuzzy sets on universe of discourses X and Y
	- f(x,y) is mathematical function

#### Zero order Sugeno style model

- Applies fuzzy rules in following form:

```
IF x is A
AND y is B
THEN z is k
```

- Where
	- k is a constant
- In this case
	- The output of each fuzzy rule is a constant
	- All consequent membership functions are represented by singleton spikes
	- Figure 4.15 shows the fuzzy inference process for a zero order sugeno model
- Compare figure 4.15 with figure 4.10
	- Sugeno and mamdani style is very similar
	- Only distinction is that rule consequents are singletons in sugeno style

#### How is crisp output obtained

- As seen in figure 4.15
	- Aggregation operation simply includes all the singletons
- Now we cna find the weighted average (WA) of these singletons

![weighted average equation](http://snag.gy/yJOVD.jpg)

- Zero order sugeno system might be sufficient for problem's needs
	- Singleton output functions satisfy requirements of a given problem quite often

#### When to use Mamdani or Sugeno

- Mamdani
	- Widely accepted for capturing expert knowledge
	- Allows to describe expertise in more intuitive, human like manner
	- Needs lots of calculation overhead
- Sugeno
	- Computationally efficient
	- Works well with optimization/adaptive techniques
	- Very attractive for control problems
		- Dynamic nonlinear systems

## 4.7 Building a fuzzy expert system

1. Specify problem and define linguistic variables
2. Determine fuzzy sets
3. Elicit and construct fuzzy rules
4. Encode fuzzy sets/rules and procedures to perform fuzzy inference into the expert system
5. Evaluate and tune the system

### Step 1: Specify the problem and define linguistic variables

- Describe problem in terms of knowledge engineering
- Determine problem input/output variables and their ranges

### Step 2: Determine fuzzy sets

- Have variety of shapes
- Triangle or trapezoid can often provide adequate representation of expert knowledge
	- Simplifies computation
- Examples
	- Figure 4.16 to 4.19

![figure 4.16 - 4.19](http://snag.gy/S2aka.jpg)

### Step 3: Elicit and construct fuzzy rules

- Obtain rules
	- Ask expert to describe how problem can be solved
		- Using fuzzy linguistic variables
	- Collect from other sources
		- Books
		- Databases
		- Flow diagrams
		- Observed human behavior

#### Matrices

- Fuzzy associative memory (FAM)
- M * N matrix
	- Two inputs
	- One output
- M * N * K matrix (cube)
	- Three inputs
	- One output

![figure 4.20](http://snag.gy/V9XfQ.jpg)

![table 4.4, figure 4.21](http://snag.gy/gkrIE.jpg)

### Step 4: Encode fuzzy sets, rules and procedures to perform fuzzy inference into the fuzzy system

- Two options
	- Build system using programming language
		- C
		- Pascal
	- Apply fuzzy logic development tools
		- MATLAB
		- Fuzzy knowledge builder

### Step 5: Evaluate and tune the system

- Want to see whether fuzzy system meets requirements specified at beginning
- Tuning takes more time and effort than
	- Determining fuzzy sets
	- Constructing fuzzy rules
- Improving system becomes art rather than engineering
- May involve number of actions in following order
	1. Review
		- Input/output variables
		- Redefine ranges if necessary
		- Variables used in the same domain must be measured in the same units on the universe of discourse
	2. Review fuzzy sets
		- Define additional sets on the universe of discourse
			- If necessary
		- The use of wide fuzzy sets may cause fuzzy system to perform roughly
	3. Provide sufficient overlap between neighboring sets
		- No precise method to determine overlap
		- Suggestion
			- Triangle to triangle or trapezoid to triangle fuzzy sets
				- Should overlap between 25% and 50% of their bases
	4. Review existing rules
		- Add new rules to rule base
			- If required
	5. Example rule base for opportunities to write hedge rules
		- To capture pathological behavior of system
	6. Adjust rule execution weights
		- Most fuzzy logic tools allow control of the importance of rules by changing a weight multiplier
	7. Revise shapes of the fuzzy sets
		- In most cases, fuzzy systems are highly tolerant of a shape approximation
		- A system can still behave well even when the shapes of the fuzzy sets are not precisely defined

### Tuning defuzzification methods

- Centroid technique provides consistent results
	- Well balanced method sensitive to height and width of total fuzzy region
		- As well as sparse singletons
- Unless strong reason to believe fuzzy system will behave better under other defuzzification methods
	- Centroid technique recommended

## 4.8 Summary

- Fuzzy logic describes fuzziness
	- Fuzzy logic attempts to model human's senses of
		- Words
		- Decision making
		- Common sense
	- Leading to more human intelligent machines
- Fuzzy logic is a set of mathematical principles for knowledge representation
	- Based on degrees of membership
	- Rather than on crisp membership of binary logic
	- Is multi valued
- Fuzzy set is a set with fuzzy boundaries
	- Examples
		- Short
		- Average
		- Tall
	- To represent fuzzy set in computers
		- Expressed as a function
		- Map the elements of the set to their degree of membership
		- Typical membership functions are
			- Triangles
			- Trapezoids
- Linguistic variable is used to describe a term or concept with vague or fuzzy values
	- Values are represented in fuzzy sets
- Hedges are fuzzy set qualifiers
	- Used to modify the shape of fuzzy sets
	- Include adverbs
		- Very
		- Somewhat
		- Quite
		- More or less
		- Slightly
	- Perform mathematical operations
		- Concentration
			- Reduces degree of membership
		- Dilation
			- Increases the degree of membership
		- Intensification
			- Increasing degree of membership above 0.5
			- Decreasing degree of membership below 0.5
- Fuzzy sets can interact
	- Operations
		- Complement
		- Containment
		- Intersection
		- Union
- Fuzzy rules are used to capture human knowledge
	- IF x is A
	- THEN y is B
- Fuzzy inference is process of mapping from a given input to an output by using theory of fuzzy sets
	- Includes four steps
		- Fuzzification of input variables
		- Rule evaluation
		- Aggregation of rule outputs
		- Defuzzification
- Two fuzzy inference techniques
	- Mamdani
		- Ability to capture expert knowledge in fuzzy rules
		- Greater calculation overhead
	- Sugeno
		- Uses spikes for outputs
- Building fuzzy system is an iterative process
	- Involves
		- Defining fuzzy sets/rules
		- Evaluating/tuning system to meet specified requirements
- Tuning is most laborious and tedious part in building a fuzzy system
	- Involves adjusting existing fuzzy sets/rules

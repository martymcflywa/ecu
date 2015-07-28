# Rule-based expert systems

- Introduction
- Rules as a knowledge representation technique
- The main players in the development team
- Structure of a rule-based expert system
- Characteristics of an expert system
- Forward chaining and backward chaining
- Conflict resolution

## Introduction

- Knowledge is a theoretical or practical understanding of a subject or domain
	- Knowledge is also the sum of what is currently known, and apparently knowledge is power
	- Those who possess knowledge are called experts
- Anyone can be considered a domain expert if he or she has deep knowledge of both facts and rules, and strong practical experience in a particular domain
	- The area of the domain may be limited
	- In general, an expert is a skillful person who can do things other people cannot
- The human mental process is internal, and it is too complex to be represented as an algorithm
	- However, most experts are capable of expressing their knowledge in the form of **rules** for problem solving

```
IF		the traffic light is green
THEN	the action is go
```

```
IF		the traffic light is red
THEN	the action is stop
```

## Rules as a knowledge representation technique

- The term **rule** in AI, which is the most commonly used type of knowledge representation, can be defined as an `IF-THEN` structure that relates given information or facts in the `IF` part to some action in the `THEN` part
	- A rule provides some description of how to solve a problem
	- Rules are relatively easy to create and understand
- Any rule consists of two parts
	- `IF`
		- Antecedent
		- Premise
		- Condition
	- `THEN`
		- Consequent
		- Conclusion
		- Action

```
IF		<antecedent>
THEN	<consequent>
```

- A rule can have multiple antecedents joined by the keywords
	- `AND`
		- Conjunction
	- `OR`
		- Disjunction
- Can have a combination of both

```
IF		<antecedent 1>
AND		<antecedent 2>
...
AND		<antecedent n>
THEN	<consequent>
```

```
IF		<antecedent 1>
OR		<antecedent 2>
...
OR		<antecedent n>
THEN	<consequent>
```

- The antecedent of a rule incorporates two parts
	- An **object**
		- Linguistic object
	- And its **value**
	- The object and its value are linked by an **operator**
- The operator identifies the object and assigns the value
	- Operators like the ones below are used to assign a **symbolic value** to a linguistic object
		- Is
		- Are
		- Is not
		- Are not
- Expert systems can also use mathematical operators to define an object as numerical and assign it to the **numerical value**

```
IF		'age of customer' < 18
AND		'cash withdrawal' > 1000
THEN	'signature of parent' is required
```

## 

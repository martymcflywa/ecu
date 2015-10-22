# Chapter 3: Uncertainty management in rule based expert systems

## 3.1 Introduction: What is uncertainty

- Common characteristic of information available to human experts
	- Imperfection
- Information can be
	- Incomplete
	- Inconsistent
	- Uncertain
	- All three
	- Unsuitable for solving a problem
- Expert can cope with defects
	- Make correct judgments and right decisions
- Expert systems have to be able to handle uncertainty
	- Draw valid conclusions

### What is uncertainty in expert systems?

- Defined as the lack of exact knowledge that would enable to reach perfectly reliable conclusion
- Classical logic
	- Only permits exact reasoning
	- Assumes perfect knowledge is always available
	- Law of excluded middle can always be applied
- Example:

```
IF A is true
THEN A is not false

IF B is false
THEN B is not true
```

- Most real world problems where expert systems could be used do not provide clear cut knowledge
- Available information often contains
	- Inexact
	- Incomplete
	- Unmeasurable data

### What are the sources of uncertain knowledge in expert systems?

- Four main sources
	- Weak implications
	- Imprecise language
	- Unknown data
	- Difficulty of combining views of different experts

#### Weak implications

- Rule based expert systems can suffer from weak implications and vague associations
- Domain experts/knowledge engineers have task of establishing concrete correlations between IF (condition) and THEN (action) parts of rules
- Therefore, expert systems need to have ability to handle vague associations
- Example
	- Accepting the degree of correlations as numerical certainty factors

#### Imprecise language

- Natural language is inherently ambiguous/imprecise
- We describe facts with terms like
	- Often
	- Sometimes
	- Frequently
	- Hardly ever
- It can be difficult to express knowledge in the precise IF-THEN form of production rules
- If the meaning of the facts is quantified
	- It can be used in expert systems
- Quantifying the meaning of the terms enables an expert system to establish an appropriate matching of the IF (condition) part of the rules with facts available in the database

#### Unknown data

- When data is incomplete or missing
- Only solution is to accept the value "unknown" and proceed to an appropriate reasoning with this value

#### Combining views of different experts

- Large expert systems may combine knowledge/expertise of number of different experts
- Experts seldom reach exactly the same conclusions
- Experts have contradictory opinions and produce conflicting rules
- To resolve conflict
	- Knowledge engineer has to attach weight to each expert
	- Then calculate the composite conclusion
- Even a domain expert generally does not have the same uniform level of expertise throughout a domain
- No systematic method exists to obtain weights

### Managing uncertainty

- Expert systems should be able to manage uncertainties
	- Any real world domain contains inexact knowledge
	- Needs to cope with uncertain data
- There are a number of numeric and on numeric methods to deal with uncertainty
- Introduced in this chapter
	- Bayesian reasoning
	- Certainty factors
- First will look at basic principles of classical probability theory

## 3.2 Basic probability theory

### Probability definition

- Probability of an event is the proportion of cases in which the event occurs
- Scientific measure of chance
- Can be expressed mathematically as a numerical index
	- Between 0
		- An absolute impossibility
	- To unity
		- Absolute certainty
- Most events have probability index between 0 and 1
	- Each event has at least two possible outcomes
		- Favorable/success
		- Unfavorable/failure
- Probability of success and failure can be determined as:

![equation 3.1/2](http://snag.gy/imZID.jpg)

- Therefore
	- If s is the number of times success can occur
	- If f is the number of times failure can occur
- Then:

![equation 3.3/4/5](http://snag.gy/8x7Cn.jpg)

- Consider classical examples with coin and dice
	- If we throw a coin
		- Probability of heads will be equal to probability of getting tails
		- In a single throw
			- s = f = 1
			- Therefore the probability of getting heads/tails is 0.5
	- If we roll a die
		- Probability of getting a 6 from a single throw
			- s = 1, f = 5
			- Since there is just one way of getting a 6
			- And 5 ways of not getting a 6
		- Therefore the probability of getting a 6 is:

![dice probability](http://snag.gy/UFULp.jpg)

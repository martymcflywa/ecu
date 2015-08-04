# Uncertainty management in rule based expert systems

## Outline

- Introduction
- Basic probability theory
- Bayesian reasoning
	- Bias of the Bayesian method
- Certainty factors theory and evidential reasoning
- Summary

## Introduction

- Information can be
	- Incomplete
	- Inconsistent
	- Uncertain
	- All three
		- In other words, information is often unsuitable for solving a problem
- **Uncertainty** is defined as
	- The lack of knowledge that would enable us to reach a perfectly reliable conclusion
	- Classical logic permits only exact reasoning
		- It assumes that perfect knowledge always exists
		- The law of **the excluded middle** can always be applied
			- `IF A is true THEN A is not false`
			- `IF A is false THEN A is not true`

### Sources of uncertain knowledge

- **Weak implications**
	- Domain experts and knowledge engineers have the painful task of establishing concrete correlations between `IF (condition)` and `THEN (action)` parts of the rules
	- Therefore, expert systems need to have the ability to handle vague associations
		- For example, by accepting the degree of correlations as numerical certainty factors

### Quantification of ambiguous and imprecise terms on a time-frequency scale

![quantification of ambiguous and imprecise terms](http://snag.gy/3yGvm.jpg)

- **Unknown data**
	- When the data is incomplete or missing, the only solution is to accept the value **unknown** and proceed to an approximate reasoning with this value
- **Combining views of different experts**
	- Large expert systems usually combine the knowledge and expertise of a number of experts
	- Unfortunately, experts often have contradictory opinions and produce conflicting rules
	- To resolve the conflict, the knowledge engineer has to attach a **weight** to each expert and then calculate the composite conclusion
	- But no systematic method exists to obtain these weights

## Basic probability theory

- The concept of probability has a long history that goes back thousands of years when words shown below were introduced into spoken languages
	- Probably
	- Likely
	- Maybe
	- Perhaps
	- Possibly
- However, the mathematical theory of probability was formulated only in the 17th century
- The **probability** of an event is the proportion of cases in which the event occurs
- Probability can also be defined as a **scientific measure of chance**

### Expression of probability

- Probability can be expressed mathematically as a numerical index with a range between
	- 0
		- Absolute impossibility
	- Unity
		- Absolute certainty
- Most events have a probability index strictly between `0` and `1`, which means that each event has at least two possible outcomes
	- Favourable outcome or success, and unfavourable outcome or failure

![p success/failure formula](http://snag.gy/LH4Us.jpg)

- If `s` is the number of times success can occur, and `f` is the number of times failure can occur, then:

![s/f formula](http://snag.gy/hX25r.jpg)

- If we throw a coin, the probability of getting a head will be equal to the probability of getting a tail
	- In a single throw `s = f = 1`, and therefore, the probability of getting a head or tail is `0.5`

### Conditional probability

- Let `A` be an event in the world, and `B` be another event
	- Suppose that events `A` and `B` are not mutually exclusive, but occur conditionally on the occurrence of the other
	- The probability that event `A` will occur if event `B` occurs is called the **conditional probability**
- Conditional probability is denoted mathematically as `p(A|B)` in which the vertical bar represents `GIVEN` and the complete probability expression is interpreted as
	- **Conditional probability of event `A` occurring given that event `B` has occurred**

![p(A|B) formula](http://snag.gy/CMxea.jpg)

### Joint probability

- The number of times `A` and `B` can occur, or the probability that both `A` and `B` will occur is called the **joint probability** of `A` and `B`
	- It is represented mathematically as `p(A∩B)`
	- The number of ways `B` can occur is the probability of `B`, `p(B)`, and thus:

![p(A∩B) formula 1](http://snag.gy/KBsOf.jpg)

- Similarly, the conditional probability of event `B` occurring given that `A` has occurred equals:

![p(B∩A) formula 1](http://snag.gy/vSHEz.jpg)

- Hence:

![p(B∩A formula 2)](http://snag.gy/JhJaB.jpg)

- Or:

![p(A∩B) formula 2](http://snag.gy/bPZfA.jpg)

- Or substitution the last equation into:

![p(A|B) substitute formula](http://snag.gy/JTnch.jpg)

- The formula above yields the **Bayesian rule**

## Bayesian rule

![bayesian formula](http://snag.gy/cfr21.jpg)

- `p(A|B)` is the conditional probability that event `A` occurs given that event `B` has occurred
- `p(B|A)` is the conditional probability that event `B` occurs given that event `A` has occurred
- `p(A)` is the probability of event `A` occurring
- `p(B)` is the probability of event `B` occurring

### Joint probability sum

![joint probability sum](http://snag.gy/5feXp.jpg)

### Bayesian reasoning

- Suppose all rules in the knowledge base are represented in the following form:

```
IF		E is true
THEN	H is true {with probability p}
```

- This rule implies that if event `E` occurs, then the probability that event `H` will occur is `p`
- In expert systems, `H` usually represents a hypothesis and `E` denotes evidence to support this hypothesis
- Therefore, we can obtain a comparison rule that states:

```
IF		the symptom is "odd noises"
THEN	the start is good {with probability 0.3}
```

- Domain experts do not deal with conditional probabilities and often deny the very existence of the **hidden implicit probability**
	- `0.3` in our example
- We would also use available statistical information and empirical studies to derive the following rules:

```
IF		the starter is bad
THEN	the symptom is "odd noises" {probability 0.85}

IF		the starter is bad
THEN	the symptom is not "odd noises" {probability 0.15}
```

## Certainty factors theory and evidential reasoning

- Certainty factors theory is a popular alternative to Bayesian reasoning
- A **certainty factor** `cf`, a number to measure the expert's belief
	- The max/min values of the certainty factor is, for example:
		- `+1.0` = definitely true
		- `-1.0` = definitely false
	- For example, if the expert states that some evidence is almost certainly true, a `cf` value of `0.8` would be assigned to this evidence

### `cf` factors in MYCIN

![cf MYCIN](http://snag.gy/d59LP.jpg)

### `cf` factors in expert systems

- In expert systems with certainty factors, the knowledge base consists of a set of rules that have the following syntax:

```
IF		<evidence>
THEN	<hypothesis> {cf}
```

- Where `cf` represents belief in hypothesis `H` given that evidence `E` has occurred

### `cf` example

- Consider a simple rule:

```
IF		A is X
THEN	B is Y
```

- An expert may not be absolutely certain that this rule holds
	- Also suppose that it has been observed that in some cases, even when the `IF` part of the rule is satisfied and object `A` takes on value `X`, object `B` can acquire some different value `Z`

```
IF		A is X
THEN	B is Y {cf 0.7}
		B is Z {cf 0.2}
```

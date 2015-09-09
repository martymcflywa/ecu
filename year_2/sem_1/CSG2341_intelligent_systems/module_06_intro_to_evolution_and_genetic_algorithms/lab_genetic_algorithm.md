# CSG2341

## Workshop 6: An introduction to genetic algorithms

#### Martin Ponce 10371381

## Recorded example

- At construction
	- 1
		- old: UrroiYcEGlNxivFNjIstQKiYe
		- new: UrroiYcEGlNxivFNjIstQKiYe
	- 2
		- old: fVxLLbIvpZbCsWAEkAJFkugrxa
		- new: fVxLLbIvpZbCsWAEkAJFkugrxa
- At mutation
	- 1
		- old: UrroiYcEGlNxivFNjIstQKiYe
		- new: Urroi nEGlNxivFNjIstQKiYe
	- 2
		- old: fVxLLbIvpZbCsWAEkAJFkugrxa
		- new: fVxLLbIvpobCsWAEkAJFkugrxa
- At crossover
	- 1
		- old: Urroi nEGlNxivFNjlstQKiYe
		- new: Urroi nEGlNxivFNjIstkugrxa
	- 2
		- old: fVxLLbIvpobCsWAEkAJFkugrxa
		- new: fVxLLbIvpobCsWAEkAJFQKiYe

## Question 1

>Describe how the mutation operator works in this program.

- When mutation occurs
	- A single gene is changed to a random letter
	- The original chromosome is kept in "old"
	- Mutation is stored as "new"

<div class="page-break"></div>

## Question 2

>Describe how the crossover operator works in this program. Is this one-point or two-point crossover?

- When crossover occurs `StringSearchEvolvable.crossover()`
	- Random int generated to divide string into two substrings
		- Will be referred to as "sub1" and "sub2"
	- 1's sub1 concatenated with 2's sub2
	- 2's sub1 concatenated with 1's sub2
- Is one-point crossover

## Question 3

![EvolveString run](http://snag.gy/v4Fbb.jpg)

## Question 4

>What is the size of the search space here? ie. How many different random strings can be made using a sequence of 26 letters from the 49 allowed letters?

26<sup>49</sup> = 2.1562249e+69

<div class="page-break"></div>

## Question 5

>Describe what happens with MUTATION_FACTOR = 0.0. Attempt to explain why.

- Infinite loop
- Without mutation, string 1 and 2 just crosses over the same substrings
- Never has the chance to "adapt"

## Question 6

>Describe what happens with MUTATION_FACTOR = 30.0. Attempt to explain why.

- Ran til ~300,000 generations
- Average fitness never goes above ~2.5
- Too much randomness introduced

>"too high mutation rate increases the probability of searching more areas in search space, however, prevents population to converge to any optimum solution" (Kazimipour, 2013)

Kazimipour, B. (2013, January 3). *Why is the mutation rate in genetic algorithms very small?* [Online forum comment]. Retrieved September 9, 2015, from http://www.researchgate.net/post/Why_is_the_mutation_rate_in_genetic_algorithms_very_small

## Question 7

>Try different amounts of mutation and crossover until you find a combination that gives an average number of probes near to 40,000. What were the mutation factor and crossover probability that gave that result?

``` console
MUTATION_FACTOR = 0.3
CROSSOVER_PROB = 0.8

Mean number of probes = 37573.0
```

>Can you say anything from this about what mutation probability and crossover probability should be used in a Genetic Algorithm?

- Should be kept low, so that it does not introduce too much randomness
- But should also have enough probability to mutate/crossover so that the result can adapt towards the desired goal

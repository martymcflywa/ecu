# Rule-based expert systems

- Introduction
- Rules as a knowledge representation technique
- The main players in the development team
- Structure of a rule-based expert system
- Characteristics of an expert system
- Forward chaining and backward chaining
- Conflict resolution
- Metaknowledge
- Advantages / disadvantages of rule-based expert systems

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

### Rules can represent relations, recommendations, directives, strategies and heuristics

#### Relation

```
IF		'fuel tank' is empty
THEN	'car' is dead
```

#### Recommendation

```
IF		'season' is autumn
AND		'sky' is cloudy
AND		'forecast' is drizzle
THEN	advice is 'take umbrella'
```

#### Directive

```
IF		'car' is dead
THEN	action is 'check fuel tank';
		'step1' complete
```

```
IF		'step1' complete
AND		'fuel tank' is full
THEN	action is 'check battery';
		'step2' complete
```

#### Heuristic

```
IF		'spill' is liquid
AND		'spill pH' < 6
AND		'spill smell' is vinegar
THEN	'spill material' is 'acetic acid'
```

## The main players in the development team

- There are five members of the expert system development team
	- Domain expert
	- Knowledge engineer
	- Programmer
	- Project manager
	- End user

![dev team model](http://snag.gy/NGv5c.jpg)

### Domain expert

- Knowledgeable and skilled person capable of solving problems in a specific area or domain
- This person has greatest expertise in a given domain
- This expertise is to be captured in the expert system
- Therefore, expert must be able to communicate his or her knowledge
	- Willing to participate in the expert system development
	- Commit substantial amount of time to the project
- Domain expert is most important player in the expert system dev team

### Knowledge engineer

- Capable of designing, building and testing an expert system
- Interviews the domain expert to find out how a particular problem is solved
- Establishes what reasoning methods the expert uses to handle facts and rules and decides how to represent them in the expert system
- The knowledge engineer then chooses some development software or expert system shell
	- Or looks at programming languages for encoding the knowledge
- Is responsible for testing, revising and integrating the expert system into the workplace

### Programmer

- Responsible for actual programming, describing the domain knowledge in terms that a computer can understand
- Programmer needs to have skills in symbolic programming in such AI languages like
	- LISP
	- Prolog
	- OPS5
- Has experience in application of different types of expert system shells
- Should also know conventional programming languages like
	- C
	- Pascal
	- FORTRAN
	- Basic

### Project manager

- Leader of expert system dev team
- Responsible for keeping project on track
- Makes sure that all deliverables and milestones are met
- Interacts with all members of team, including end user

### End user

- Person who uses the expert system when it is developed
- User must be confident in expert system performance and comfortable in its use
- Design of user interface of expert system is also vital for project's success
	- Contribution of end user towards UI can be crucial

## Structure of rule-based expert system

- Newell and Simon (1970s) proposed a production system model, the foundation of the modern rule based expert systems
- Production model is based on the idea that humans solve problems by applying their knowledge (expressed as production rules) to a given problem represented by problem-specific information
- Production rules are stored in long-term memory and problem specific information or facts are stored in short-term memory

### Production system model

![production system model](http://snag.gy/BdtLc.jpg)

### Basic structure of a rule-based expert system

![basic structure of a rule-based expert system](http://snag.gy/clSAb.jpg)

#### Knowledge base

- Contains the domain knowledge useful for problem solving
- In a rule-based expert system, the knowledge is represented as a set of rules
- Each rule specifies a relation, recommendation, directive, strategy or heuristic and has the `IF (condition) THEN (action)` structure
- When the condition part of a rule is satisfied, the rule is said to **fire** and the action part is executed

#### Database

- Includes a set of facts used to match against the `IF (condition)` parts of rules stored in the knowledge base

#### Inference engine

- Carries out the reasoning whereby the expert system reaches a solution
- It links the rules given in the knowledge base with the facts provided in the database

#### Explanation facilities

- Enable the user to ask the expert system **how** a particular conclusion is reached and **why** a specific fact is needed
- An expert system must be able to explain its reasoning and justify its advice, analysis or conclusion

#### User interface

- A means of communication between a user seeking a solution to the problem and an expert system

### Complete structure of a rule-based expert system

![complete structure of a rule-based expert system](http://snag.gy/hYT8W.jpg)

## Characteristics of an expert system

- An expert system is built to perform at a human expert level in a **narrow, specialised domain**
	- Thus, the most important characteristic of an expert system is its **high quality performance**
	- No matter how fast the system can solve a problem, the user will not be satisfied if the result is wrong
- On the other hand, the speed of reaching a solution is also important
	- Even the most accurate decision or diagnosis may not be useful if it is too late to apply
		- For instance in an emergency, when a patient dies, or a nuclear power plant goes into melt down
- Expert systems apply **heuristics** to guide the reasoning and thus reduce the search area for a solution
- A unique feature of an expert system is its **explanation capability**
	- It enables the expert systems to review its own reasoning and explain its decisions
- Expert systems employ **symbolic reasoning** when solving a problem
	- Symbols are used to represent different types of knowledge such as facts, concepts and rules

### Can expert systems make mistakes?

- Even a brilliant expert is only human and thus can make mistakes
	- This suggests that an expert system built to perform at a human expert level also should be allowed to make mistakes
	- But we still trust experts, even though we recognise that their judgement can be wrong
	- Likewise, at least in most cases, we can rely on solutions provided by expert systems, but mistakes are possible and we should be aware of this
- In expert systems, knowledge is separated from its processing
	- The knowledge base and inference engine are split up
	- A conventional program is a mixture of knowledge and the control structure to process this knowledge
	- This mixing leads to difficulties in understanding and reviewing the program code, as any change to the code affects both the knowledge and its processing
- When an expert system shell is used, a knowledge engineer or an expert simply enters rules in the knowledge base
	- Each new rule adds some new knowledge and makes the expert system smarter

### Comparison of expert systems with conventional systems and human experts

| Human experts | Expert systems | Conventional programs |
|:--------------|:---------------|:----------------------|
| Use knowledge in the form of rules of thumbs or heuristics to solve problems in a narrow domain | Process knowledge expressed in the form of rules and use symbolic reasoning to solve problems in a narrow domain | Process data and use algorithms, a series of well-defined operations, to solve general numerical problems |
| In a human brain, knowledge exists in a compiled form | Provide a clear separation of knowledge from its processing | Do not separate knowledge from the control structure to process this knowledge |
| Capable of explaining a line of reasoning and providing the details | Trace the rules fired during a problem-solving session and explain how a particular conclusion was reached and why specific data was needed | Do not explain how a particular result was obtained and why input data was needed |
| Use inexact reasoning and can deal with incomplete, uncertain and fuzzy information | Permit inexact reasoning and can deal with incomplete, uncertain and fuzzy data | Work only on problems where data is complete and exact |
| Can make mistakes when information is incomplete or fuzzy | Can make mistakes when data is incomplete or fuzzy | Provide no solution at all, or a wrong one, when data is incomplete or fuzzy |
| Enhance the quality of problem solving via years of learning and practical training. This process is slow, inefficient and expensive | Enhance the quality of problem solving by adding new rules or adjusting old ones in the knowledge base. When new knowledge is acquired, changes are easy to accomplish | Enhance the quality of problem solving by changing the program code, which affects both the knowledge and its processing, making changes difficult |

## Forward chaining and backward chaining

- In a rule-based expert system, the domain knowledge is represented by a set of `IF-THEN` production rules and data is represented by a **set of facts about the current situation**
	- The inference engine compares each rule stored in the knowledge base with facts contained in the database
	- When the `IF (condition)` part of the rule matches the fact, the rule is fired and its `THEN (action)` part is executed
- The matching of the rule `IF` parts to the facts produces **inference chains**
	- The inference chain indicates how an expert system applies the rules to reach a conclusion

### Inference engine cycles via a match-fire procedure

![inference engine cycles via a match-fire procedure](http://snag.gy/n6YGQ.jpg)

### Example of an inference chain

![example of an inference chain](http://snag.gy/5PthJ.jpg)

### Forward chaining

- Forward chaining is the **data-driven reasoning**
	- The reasoning starts from the known data and proceeds forward with that data
	- Each time only the topmost rule is executed
	- When fired, the rule adds a new fact in the database
	- Any rule can be executed only once
	- The match-fire cycle stops when no further rules can be fired
- Forward chaining is a technique for gathering information and then inferring from it whatever can be inferred
- However, in forward chaining, many rules may be executed that have nothing to do with the established goal
- Therefore, if our goal is to infer only one particular fact, the forward chaining inference technique would not be efficient

#### Forward chaining model

![forward chaining model](http://snag.gy/6P1aG.jpg)

### Backward chaining

- Backward chaining is the **goal-driven reasoning**
	- An expert system has the goal (a hypothetical solution) and the inference engine attempts to find the evidence to prove it
	- First, the knowledge base is searched to find rules that might have the desired solution
	- Such rules must have the goal in their `THEN (action)` parts
	- If such a rule is found and its `IF (condition)` part matches data in the database, then the rule is fired and the foal is proved
	- However, this is rarely the case
- Thus the inference engine puts aside the rule it is working with (the rule is said to **stack**) and sets up a new goal, a subgoal to prove the `IF` part of this rule
	- Then the knowledge base is searched again for rules that can prove the subgoal
	- The inference engine repeats the process of stacking the rules until no rules are found in the knowledge base to prove the current subgoal

#### Backward chaining model

![backward chaining model](http://snag.gy/7Cu78.jpg)

### How do we choose between backward / forward chaining?

- If an expert first needs to gather some information and then tries to infer from it whatever can be inferred, choose the forward chaining inference engine
- However, if your expert begins with a hypothetical solution and then attempts to find facts to prove it, choose the backward chaining inference engine

## Conflict resolution

- Earlier we considered two simple rules for crossing a road, we'll now add a third rule

```
Rule 1:
IF		'traffic light' is green
THEN	action is 'go'

Rule 2:
IF		'traffic light' is red
THEN	action is 'stop'

Rule 3:
IF		'traffic light' is red
THEN	action is 'go'
```

- We have two rules, Rule 2 and Rule 3 with the same `IF` part
	- Thus both of them can be set to fire when the condition part is satisfied
	- These rules represent a conflict set
	- The inference engine must determine which rule to fire from such a set
	- A method for choosing a rule to fire when more than one rule can be fired in a given cycle is called **conflict resolution**
- In forward chaining, **both** rules would be fired
	- Rule 2 is fired first as the topmost rule, and as a result, its `THEN` part is executed and linguistic object `action` obtains value `stop`
	- However, Rule 3 is also fired because the condition part of this rule matches the fact `'traffic light' is red`, which is still in the database
	- As a consequence, object `action` takes a new value `go`

### Methods for conflict resolution

- Fire the rule with the **highest priority**
	- In simple applications, the priority can be established by placing the rules in appropriate order in the knowledge base
	- Usually this strategy works well for expert systems with around 100 rules
- Fire the **most specific rule**
	- This method is also known as the **longest matching strategy**
	- It is based on the assumption that a specific rule processes more information than a general one
- Fire the rule that uses the **data most recently entered** in the database
	- This method relies on time tags attached to each fact in the database
	- In the conflict set, the expert system first fires the rule whose antecedent uses the data most recently added to the database

## Metaknowledge

- Metaknowledge can be simply defined as **knowledge about knowledge**
	- Metaknowledge is knowledge about the use and control of domain knowledge in an expert system
- In rule-based expert systems, metaknowledge is represented by **metarules**
	- A metarule determines a strategy for the use of task-specific rules in the expert system

### Metarules

- Metarule 1
	- Rules supplied by experts have higher priorities than rules supplied by novices
- Metarule 2
	- Rules governing the rescue of human lives have higher priorities than rules concerned with clearing overloads on power system equipment

## Advantages / disadvantages of rule-based expert systems

### Advantages

#### Natural knowledge representation

- An expert usually explains the problem-solving procedure with such expressions as
	- "In situation x, i do y"
- These expressions can be represented quite naturally as `IF-THEN` production rules

#### Uniform structure

- Production rules have the uniform `IF-THEN` structure
- Each rule is an independent piece of knowledge
- The very syntax of production rules enables them to be self-documented

#### Separation of knowledge from processing

- Structure provides an effective separation of knowledge base from the inference engine
- Makes it possible to develop different applications using the same expert system shell

#### Dealing with incomplete and uncertain knowledge

- Most rule-based expert systems are capable of representing reasoning with incomplete and uncertain knowledge

### Disadvantages

#### Opaque relations between rules

- Although individual production rules are relatively simple and self-documenting, their logical interactions within the large set of rules may be opaque
- Rule-based systems make it difficult to observe how individual rules serve the overall strategy

#### Ineffective search strategy

- The inference engine applies an exhaustive search through all the production rules during each cycle
- Expert systems with a large set of rules (> 100) can be slow, and thus large rule-based systems can be unsuitable for real-time applications

#### Inability to learn

- In general, rule-based expert systems do not have an ability to learn from experience
- Unlike human experts, who knows when to *break the rules*, an expert system cannot automatically modify its knowledge base, or adjust existing rules or add new ones
- The knowledge base engineer is still responsible for revising and maintaining the system

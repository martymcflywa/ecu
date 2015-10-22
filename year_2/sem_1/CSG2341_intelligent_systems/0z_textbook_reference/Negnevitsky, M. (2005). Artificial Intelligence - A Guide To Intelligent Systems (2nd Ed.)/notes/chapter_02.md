# Chapter 2: Rule-based expert systems

## 2.1 Introduction, or what is knowledge

- 1970s, was accepted that for a machine to solve intellectual problem, one has to have knowledge
	- Knowhow in some specific domain

### What is knowledge

- A theoretical or practical understanding of a subject or domain
- The sum of what is currently known
- Knowledge is power
- Those who possess knowledge are called experts

### Who is generally acknowledged as an expert

- Anyone can be considered a domain expert if s/he has
	- Deep knowledge
		- Facts and rules
	- Strong practical experience in a domain
- Area of domain may be limited
	- ie. Experts in electrical machines may have only general knowledge about transformers
	- ie. Experts in life insurance marketing may have limited understanding of real estate insurance
- An expert is a skillful person who can do things other people cannot

### How do experts think

- Human process is internal
	- Too complex to be represented as an algorithm
- Most experts are able to express knowledge in form of rules for problem solving

#### Production rules

- Defined as IF-THEN structure that relate to the given information
- Rules provide some description of how to solve a problem
- Rules are relatively easy to create and understand

## 2.2 Rules as knowledge, representation techniques

- Rules consist of two parts
	- IF
		- Antecedent
		- Premise
		- Condition
	- THEN
		- Consequent
		- Conclusion
		- Action
- Basic syntax:

```
IF <antecedent>
THEN <consequent>
```

- Rules can have multiple antecedents joined by
	- AND
		- Conjunction
	- OR
		- Disjunction
	- Combination of both
		- But good habit to avoid mixing conjunctions/disjunctions in same rule
- Rules can have multiple consequents

### Operators

- Antecedents incorporate two parts
	- Object
		- Linguistic object
	- Its value
- ie. Road crossing example
	- Linguistic object "traffic light" can take either the value "green" or "red"
- Object and its value are linked by an **operator**
- Operators identify the object and assigns the value
	- IS
	- ARE
	- IS NOT
- Operators assign a symbolic value to a linguistic object
- Can also use mathematical operators to define an object as numerical and assign it to the numerical value
	- Example:

```
IF (age of customer) < 18
AND (cash withdrawal) > 1000
THEN (signature of parent) is required
```

- Consequents combines an object and value by an operator

## 2.3 Main players in the expert system dev team

- Domain expert
	- Knowledgeable and skilled person capable of solving problems in specific area or domain
	- Has greatest expertise in given domain
	- Expertise is to be captured in the expert system
	- Must be able to communicate knowledge
	- Most important player in team
- Knowledge engineer
	- Capable of designing, building and testing an expert system
	- Responsible for selecting an appropriate task for the expert system
	- Interviews domain expert to find out how a problem is solved
	- Establishes what reasoning methods the expert uses to handle facts and rules
	- Decides how to represent them in the expert system
- Programmer
	- Responsible for actual programming
		- Describes the domain knowledge in terms that the computer can understand
	- Needs to have skills in symbolic programming
		- LISP
		- Prolog
		- OPS5
	- Should know conventional programming languages
		- C
		- Pascal
		- FORTRAN
		- Basic
	- If not using expert shell system
		- Must develop
			- Knowledge and data representation structures
				- Knowledge base
				- Database
			- Control structure
				- Inference engine
			- Dialogue structure
				- User interface
- Project manager
	- Leader of the expert system development team
	- Makes sure that all deliverables and milestones are met
- End user
	- Person who uses the expert system when it is developed

## 2.4 Structure of rule-based expert system

- Has five components
	- Knowledge base
		- Contains domain knowledge useful for problem solving
		- Represented as a set of rules
			- IF-THEN structure
		- When condition part of rule is satisfied
			- The rule is **fired**
	- Database
		- Includes set of facts used to match against the IF (condition) parts of rules stored in the knowledge base
	- Inference engine
		- Carries out the reasoning whereby the expert system reaches a solution
		- Links the rules given in the knowledge base with the facts provided in the database
	- Explanation facilities
		- Enables the user to ask the expert system
			- How a particular conclusion is reached
			- Why a specific fact is needed
		- Must be able to explain reasoning and justify its advice, analysis or conclusion
	- User interface
		- A means of communicating between the user and expert system
		- Should be as meaningful and user friendly as possible

![figure 2.2](http://snag.gy/O5M3H.jpg)

![figure 2.3](http://snag.gy/Kbbgp.jpg)

## 2.5 Fundamental characteristics of an expert system

- High quality performance in a narrow, specialized domain
- Speed/responsiveness
	- Accurate decision may not be useful if it is too late to apply
		- ie. In an emergency, life or death situation
- Apply heuristics to guide reasoning
	- Reducing the search area for a solution
- Explanation capability
	- Traces the rules fired during a problem solving session
- Uses symbolic reasoning when solving problems
	- Can easily deal with qualitative data
	- Do not follow a prescribed sequence of steps like conventional programming
	- Permit inexact reasoning
	- Can deal with incomplete or uncertain fuzzy data

### Can expert systems make mistakes

- Mistakes are possible
- Programmers or developers may encode an error into the system
- Expert providing input may provide flawed reasoning

![table 2.1](http://snag.gy/UsHT9.jpg)

## 2.6 Forward/backward chaining inference

- The domain knowledge is represented by a set of IF-THEN production rules
- Data is represented by a set of facts about the current situation
- The inference engine compares each rule stored in the knowledge base with facts contained in the database
- When the IF (condition) part of the rule matches a fact
	- The rule is fired
	- THEN (action) is executed
- The fired rule may change the set of facts by adding a new fact
	- See figure 2.4

![figure 2.4](http://snag.gy/le2ny.jpg)

- Letters in the database and knowledge base are used to represent situations or concepts
- The matching of the rule IF parts to the facts produces **inference chains**
- The inference chain indicates how an expert system applies the rules to reach a conclusion

### Example

- Suppose the database initially includes facts A, B, C, D and E
- The knowledge base contains three rules:

```
IF Y is true
AND D is true
THEN Z is true

IF X is true
AND B is true
AND E is true
THEN Y is true

IF A is true
THEN X is true
```

- The inference chain shown in figure 2.5 indicates how the expert system applies the rules to infer fact Z
	- First rule 3 is fired to deduce new fact X from given fact A
	- Then rule 2 is executed to infer fact Y from initially known facts B and E, and already known fact X
	- Finally, rule 1 applies initially known fact D and just obtained fact Y to arrive a conclusion Z

![figure 2.5](http://snag.gy/NKZ92.jpg)

- An expert system can display its inference chain to explain how a particular conclusion was reached
	- This is an essential part of its explanation facilities
- The inference engine must decide when the rules have to be fired
	- There are two principal ways in which rules are executed
		- Forward chaining
		- Backward chaining

### 2.6.1 Forward chaining

- Data driven reasoning
- The example above uses forward chaining
- Consider the following rules:

```
Rule 1: Y & D → Z
Rule 2: X & B & E → Y
Rule 3: A → X
Rule 4: C → L
Rule 5: L & M → N
```

- Figure 2.6 shows how forward chaining works for the set of rules above
- Forward chaining is **data driven** reasoning
	- Reasoning starts from known data and proceeds forward with that data
	- Each time only the top most rule is executed
	- When fired, the rule adds a new fact in the database
	- Any rule can be executed only once
	- The match fire cycle stops when no further rules can be fired

![figure 2.6](http://snag.gy/qRC8H.jpg)

- Cycle 1
	- Only two rules match facts in the database
		- Rule 3: A → X
			- Fired first being the topmost rule
			- IF part of this rule matches fact A in the database
			- Its THEN part is executed
			- New fact X is added to the database
		- Rule 4: C → L
			- Fired next
			- Fact L is added to database
- Cycle 2
	- Only one rule matching facts in database
		- Rule 2: X & B & E → Y
			- Fact Y is added to database
- Cycle 3
	- Only rule matching facts in database
		- Rule 1: Y & D → Z
			- Fact Z is added to database
	- Cycles stop here since Rule 5: L & M → N does not have any matching facts to execute
- Forward chaining is a technique for gathering information then inferring from it whatever can be inferred
	- However, many rules may execute that have nothing to do with the established goal
		- ie. Goal was to determine fact Z
			- Four rules were fired to determine fact Z
			- Rule 4 was fired which is unrelated to fact Z
- If goal is to infer only one particular fat
	- Forward chaining technique is not efficient
	- Backward chaining is more appropriate

### 2.6.2 Backward chaining

- Goal driven reasoning
- An expert system has the goal
	- Hypothetical solution
- Inference engine attempts to find evidence to prove it
- Knowledge base is searched to find rules that might have the desired solution
- Rules must have the goal in their THEN (action) parts
- If such a rule is found, and its IF (condition) matches data in the database
	- The rule is fired and the goal is proved
- However this is rarely the case
	- Inference engine puts aside the rule it is working with and sets up a new sub goal to prove the IF part of this rule
		- **Stacking**
	- Then the knowledge base is searched again for rules that can prove the sub goal
	- Inference engine repeats process of stacking the rules until no rules are found in the knowledge base to prove the current sub goal
- Figure 2.7 shows how backward chaining works using the rules from the forward chaining example

![figure 2.7](http://snag.gy/7hy03.jpg)

- Pass 1
	- Inference engine attempts to infer fact Z
	- Searches knowledge base to find the rule that has the goal
		- Stacks Rule 1: Y & D → Z
	- The IF part of rule 1 includes facts Y and D
		- These facts must be established
- Pass 2
	- Inference engine sets up sub goal, fact Y
		- Tries to determine it
	- Checks database
		- Fact Y does not exist
	- Searches knowledge base for rule with fact Y in its THEN part
		- Stacks Rule 2: X & B & E → Y
	- The IF part of rule 2 consists of facts X, B and E
		- These facts must be established
- Pass 3
	- Inference engine sets up new sub goal, fact X
	- Checks database
		- Fact X does not exist
	- Searches knowledge base for rule with fact X in its THEN part
		- Stacks Rule 3: A → X
	- Must establish fact A
- Pass 4
	- Inference engine sets up new sub goal, fact A
	- Checks database
		- Fact A exists
	- Fires Rule 3: A → X
		- Adds fact X to database
- Pass 5
	- Returns to sub goal in pass 2, fact Y
	- Checks database
		- Fact X, B, E now exist
	- Fires Rule 2: X & B & E → Y
		- Adds fact Y to database
- Pass 6
	- Returns to main goal in pass 1, fact Z
	- Checks database
		- Fact Y exists
	- Fires Rule 1: Y & D → Z
		- Proves fact Z

### Forward vs. backward chaining

- Four rules fired using forward chaining
- Three rules fired when using backward chaining
- Backward chaining more effective when needing to infer one particular fat
- Forward chaining
	- Data is known at the beginning of the inference process
	- User is never asked to input additional facts
- Backward chaining
	- The goal is set up
	- Only data used is the data needed to support the direct line of reasoning
	- User may be asked to input any fact that is not known in the database

### Choosing between forward/backward chaining

- Study how a domain expert solves a problem
- If expert
	- First needs to gather information
		- Then tries to infer from it whatever can be inferred
		- Select forward chaining
	- Begins with hypothetical solution
		- Then attempts to find facts to prove it
		- Choose backward chaining
- Forward chaining is natural way to design expert systems for analysis and interpretation
- Backward chaining are used for diagnostic purposes

### Combining forward/backward chaining

- Many expert system shells use combination of forward and backward chaining
	- Knowledge engineer does not have to choose between them
- Basic inference mechanism is usually backwards chaining
- Only when a new fact is established is forward chaining employed to maximize use of new data

## 2.8 Conflict resolution

- Inference engine must determine which rule to fire from a set where there are conflict in rules
- When two rules are fired, the consequent value will take on the value from the last fired rule
- Rule order is vital when forward chaining inference is used

### How can we resolve conflict

- Fire rule with highest priority
	- Works well for expert systems with around 100 rules
- Fire the most specific rule
	- Also known as **longest matching strategy**
	- Based on assumption that a specific rule processes more information than a general one
- Fire the rule that uses the **data most recently entered** in the database
	- Relies on timestamped facts in database
	- Expert system first fires the rules with antecedents that use the newest data
- To improve performance of an expert system
	- We should supply the system with some knowledge about the knowledge it possesses
		- Metaknowledge
			- Knowledge about knowledge
			- About the use and control of domain knowledge in an expert system
			- Represented by metarules
			- Defines a strategy for the use of task specific rules in the expert system

## 2.9 Advantages/disadvantages of rule based expert systems

### Advantages

- Natural knowledge representation
	- Expert explains problem solving procedure
		- "In <situation>, I do <action>"
	- Can be expressed naturally as IF-THEN production rules
- Uniform structure
	- IF-THEN structure
	- Each rule is an independent piece of knowledge
	- Syntax of production rules are self documenting
- Separation of knowledge from processing
	- Structure of expert system provides effective separation of knowledge base from inference engine
	- Makes it possible to develop different applications using same expert system shell
	- To make system smarter
		- Add some rules to knowledge base without intervening the control structure
- Dealing with incomplete/uncertain knowledge
	- Most expert systems are capable of representing and reasoning with incomplete/uncertain knowledge
	- Certainty factors (fuzzy)

### Disadvantages

- Opaque relations between rules
	- Logical interactions within large set of rules may be opaque
	- Rule based systems make it difficult to observe how individual rules serve the overall strategy
	- Related to lack of hierarchical knowledge representation in the rule based expert system
- Ineffective search strategy
	- Inference engine applies exhaustive search through all production rules during each cycle
	- Expert systems with large set of rules can be slow
	- Large rule based systems can be unsuitable for real time applications
- Inability to learn
	- Do not have an ability to learn from experience
	- Cannot
		- Automatically modify its knowledge base
		- Adjust existing rules
		- Add new ones
	- Knowledge engineer is still responsible for revising/maintaining the system

## 2.10 Summary

- Knowledge is a theoretical or practical understanding of a subject
	- Knowledge is the sum of what is currently known
- An expert is a person who has deep knowledge in the form of facts and rules and strong practical experience in a particular domain
	- An expert can do things other people cannot
- Experts usually express knowledge in the form of production rules
- Production rules are represented as IF (antecedent) THEN (consequent) statements
	- A production rule is the most popular type of knowledge representation
	- Rules can express
		- Relations
		- Recommendations
		- Directives
		- Strategies
		- Heuristics
- A computer program capable of performing at human-expert level in a narrow problem domain area is called an expert system
	- The most popular expert systems are rule based expert systems
- In developing rule based expert systems, shells are becoming common
	- An expert shell system is a skeleton expert system with the knowledge removed
	- To build a new expert system application
		- All the user has to do is
			- Add the knowledge in the form of rules
			- Provide relevant data
	- Expert system shells offer dramatic reduction in development time of expert systems
- Expert system development team should include
	- Domain expert
	- Knowledge engineer
		- Designs, builds, tests expert system
		- Captures knowledge from domain expert
		- Establishes reasoning methods
		- Chooses development software
	- Programmer
	- Project manager
	- End user
- Rule based expert system has five basic components
	- Knowledge base
		- Contains domain knowledge represented as a set of rules
	- Database
		- Includes a set of facts used to match against the IF part rules
	- Inference engine
		- Links the rules with the facts and carries out the reasoning whereby the expert system reaches a solution
	- Explanation facilities
		- Enable the user to query the expert system about
			- How a particular conclusion is reached
			- Why a specific fact is needed
	- User interface
		- A means of communication between user and expert system
- Expert systems separate knowledge from its processing
	- Splits up the knowledge base and inference engine
	- Makes task of building/maintaining an expert system much easier
	- When expert system shell is used
		- Knowledge engineer/expert simply enters rules in knowledge base
		- Each new rule adds new knowledge and makes expert system smarter
- Expert systems provide limited explanation capability by tracing the rules fired during a problem solving session
- Unlike conventional programs
	- Expert systems can deal with incomplete and uncertain data and permit inexact reasoning
	- However, like human counterparts
		- Expert systems can make mistakes when information is incomplete or fuzzy
- There are two principal methods to direct search and reasoning
	- Forward chaining
		- Data driven reasoning
		- Starts from known data
		- Proceeds forward until no further rules can be fired
	- Backward chaining
		- Goal driven reasoning
		- Has hypothetical solution
			- Goal
		- Inference engine attempts to find evidence to prove it
- Rule based expert systems have advantages
	- Natural knowledge representation
	- Uniform structure
	- Separation of knowledge from processing
	- Coping with incomplete and uncertain knowledge
- Rule based expert systems have disadvantages
	- Opaque relations between rules
	- Ineffective search strategy
	- Inability to learn

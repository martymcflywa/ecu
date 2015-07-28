# Introduction to knowledge-base intelligent systems

- Intelligent machines, or what machines can do
- The history of artificial intelligence or from the *Dark Ages* to knowledge-based systems
- Summary

# Intelligent machines, or what machines can do

- Philosophers have been trying for over 2000 years to understand and resolve two Big Questions of the Universe:
	- How does a human mind work, and can non-humans have minds?
		- These questions are still unanswered
- Intelligence is the ability to understand and learn things
	- Intelligence is the ability to think and understand instead of doing things by instinct or automatically
	- (Essential English Dictionary, Collins, London, 1990)
- In order to think
	- Someone or something has to have a brain
	- Or an organ that enables someone or something to learn and understand things
	- To solve problems and make decisions
- We can define intelligence as
	- The ability to learn and understand
	- To solve problems and make decisions
- The goal of artificial intelligence (AI) as a science is to make machines do things that would require intelligence if done by humans
	- Therefore, the answer to the question *Can Machines Think?* was vitally important to the discipline
- The answer is not a simple *Yes* or *No*
- Some people are smarter in some ways than others
	- Sometimes we can make intelligent decisions but also make silly mistakes
	- Some of us deal with complex mathematical and engineering problems but are moronic in philosophy and history
	- Some people are good at making money, while others are better at spending it
	- As humans, we all have the ability to learn and understand, to solve problems and to make decisions
	- However, our abilities are not equal and lie in different areas
	- Therefore, we should expect that if machines can think, some of them might be smarter than others in some ways

## Alan Turing

- One of the most significant papers on machine intelligence **Computing Machinery and Intelligence**, was written by the British mathematician **Alan Turing** over fifty years ago
	- However, it still stands up well under the test of time, and the Turing's approach remains universal
- He asked
	- Is there thought without experience?
	- Is there mind without communication?
	- Is there language without living?
	- Is there intelligence without life?
- All these questions are variations on the fundamental question of artificial intelligence
	- Can machines think?
- Turing did not provide definitions of machines and thinking, he just avoided semantic arguments by inventing a game
	- The **Turing Imitation Game**

## Turing imitation game

- The imitation game originally included two phases
	- In the first phase, the interrogator, a man and a woman are each placed in separate rooms
		- The interrogator's objective is to work out who is the man and who is the woman by questioning them
		- The man should attempt to deceive the interrogator that *he* is the woman
		- While the woman has to convince the interrogator that *she* is the woman
	- In the second phase of the game, the man is replaced by a computer programmed to deceive the interrogator as the man did
		- It would even be programmed to make mistakes and provide fuzzy answers in the way a human would
		- If the computer can fool the interrogator as often as the man did, we may say this computer has passed the intelligence behavior test

## Imitation game qualities

- By maintaining communication between the human and machine via terminals, the test gives us an objective standard view on intelligence
- The test itself is quite independent from the details of the experiment
	- It can be conducted as a two-phase game, or even as a single-phase game when the interrogator needs to choose between the human and the machine from the beginning of the test
- Turing believed that  by the end of the 20th century, it would be possible to program a digital computer to play the imitation game
	- Although modern computers still cannot pass the Turing test, it provides a basis for the verification and validation of knowledge-based systems
- A program thought intelligent in some narrow area of expertise is evaluated by comparing its performance with the performance of human expert
- To build an intelligent computer system, we have to capture, organize and use human expert knowledge in some narrow area of expertise

# The history of artificial intelligence

## The birth of artificial intelligence (1943 - 1956)

- The first work recognised in the field of AI was presented by Warren McCulloch and Walter Pitts in 1943
	- The proposed a model of an artificial neural network and demonstrated that simple network structures could learn
	- McCulloch, the second *founding father* of AI after Alan Turing, had created the corner stone of neural computing and artificial neural networks (ANN)
- The third founder of AI was John von Neumann, the brilliant Hungarian-born mathematician
	- In 1930, he joined the Princeton University, lecturing in mathematical physics
	- He was an adviser for the Electronic Numerical Integrator and Calculator project at the University of Pennsylvania and helped to design the Electronic Discrete Variable Calculator
	- He was influenced by McCulloch and Pitt's neural network model
	- When Marvin Minsky and Dean Edmonds, two graduate students in the Princeton mathematics department, built the first neural network computer in 1951, von Neumann encouraged and supported them
- Another of the first generation researchers was Claude Shannon
	- He graduated from MIT and joined Bell Telephone Laboratories in 1941
	- Shannon shared Turing's ideas on the possibility of machine intelligence
	- In 1950, he published a paper on chess-playing machines, which pointed out that a typical chess game involved about 10<sup>120</sup> possible moves (Shannon, 1950)
	- Even if the new von Neumann-type computer could examine one move per microsecond, it would take 3 * 10<sup>106</sup> years to make its first move
		- Thus Shannon demonstrated the need to use heuristics in the search for the solution
- In 1956, John McCarthy, Martin Minsky and Claude Shannon organised a summer workshop at Dartmouth College
	- The brought together researchers interested in the study of machine intelligence, artificial neural networks and automata theory
	- Although there were just ten researchers, this workshop gave birth to a new science called artificial intelligence

## The rise of artificial intelligence, or the era of great expectations (1956 - late 1960s)

- The early works on neural computing and artificial neural networks started by McCulloch and Pitts was continued
	- Learning methods were improved and Frank Rosenblatt proved the **perceptron convergence theorem**, demonstrating that his learning algorithm could adjust the connection strengths of perception
- One of the most ambitious projects of the era was the **General Problem Solver (GPS)**
	- Alan Newell and Herbert Simon from the Carnegie Mellon University developed a general-purpose program to stimulate human-solving methods
	- Newell and Simon postulated that a problem to be solved could be defined in terms of **states**
		- They used the mean-end analysis to determine a difference between the current and desirable or goal state of the problem, and to choose and apply operators to reach the goal state
		- The set of operators determined the solution plan
	- However, GPS failed to solve complex problems
		- The program was based on formal logic and could generate an infinite number of possible operators
		- The amount of computer time and memory that GPS required to solve real-world problems led to the project being abandoned
- In the 60s, AI researchers attempted to simulate the thinking process by inventing general methods for solving broad classes of problems
	- They used the general-purpose search mechanism to find a solution to the problem
	- Such approaches, now referred to as **weak methods** applied weak information about the problem domain
- By 1970, the euphoria about AI was gone, and most government funding for AI projects was canceled
	- AI was still a relatively new field, academic in nature, with few practical applications apart from playing games
	- To the outsider, the achieved results would be seen as toys, as no AI system at that time could manage real-world problems

## Unfulfilled promises, or the impact of reality (late 1960s - early 1970s)

- Difficulties for AI in late 1960s were
	- Early programs contained little or no knowledge about a problem domain
		- To solve problems, programs applied a search strategy by trying out different combinations of small steps until the right one was found
		- Approach was feasible for simple problems and seemed reasonable that programs could be scaled up to solve larger problems and would finally succeed
	- Problems that were attempted were too broad and too difficult
		- Typical task for early AI was machine translation
			- National Research Council USA funded the translation of Russian scientific papers after the launch of the first artificial satellite Sputnik in 1957
				- Initially the project team tried simply replacing Russian words with English using an electronic dictionary
				- They soon realised that the translation required a general understanding of the subject to choose the correct words
				- Became too difficult and translation projects were canceled in 1966
- The British government suspended support for AI research in 1971
	- Sir James Lighthill commissioned by the Science Research Council of Great Britain reviewed the current state of AI
		- He did not find any major or even significant results from AI research and saw no need to have a separate science called "artificial intelligence"

## The technology of expert systems, or the key to success (early 1970s - mid 1980s)

- Most important development in 1970s
	- Realisation that the domain for intelligent machines had to be sufficiently restricted
	- Previously, researchers believed that clever search algorithms and reasoning techniques could be invented to emulate general, human-like, problem solving methods
		- A general purpose search mechanism could rely on elementary reasoning steps to find complete solutions and could use weak knowledge about domain
	- When weak methods failed, researchers finally realised hat the only way to deliver practical results was to solve typical cases in narrow areas of expertise, making large reasoning steps

### DENDRAL

- Developed at Stanford University to determine the molecular structure of Martian soil, based on the mass spectral data provided by a mass spectrometer
	- Supported by NASA, headed by Edward Feigenbaum, Bruce Buchanan (computer scientist) and Joshua Lederberg (Nobel prize winner in genetics)
- No scientific algorithm for mapping the mass spectrum into its molecular structure
	- Feigenbaum's job was to incorporate the expertise of Lederberg into a computer program to make it perform at a human expert level
		- Such programs were later called **expert systems**
- DENDRAL marked a major paradigm shift in AI
	- From general purpose, knowledge-sparse weak methods, to domain-specific, knowledge intensive techniques
- The aim of the project was to develop a computer program to attain the level of performance of an experienced human chemist
	- Using heuristics in the form of high-quality specific rules, rules-of-thumb, the DENDRAL team proved that computers could equal and expert in narrow, well defined, problem areas
- The DENDRAL project originated the fundamental idea of expert systems - **knowledge engineering**, which encompassed techniques of capturing, analysing and expressing in rules an expert's *know-how*

### MYCIN

- MYCIN was a rule-based expert system for the diagnosis of infectious blood diseases
	- Also provided a doctor with therapeutic advice in a convenient, user-friendly manner
- MYCIN's knowledge consisted of about 450 rules derived from human knowledge in a narrow domain through extensive interviewing of experts
- The knowledge incorporated in the form of rules was clearly separated from the reasoning mechanism
	- The system developer could easily manipulate knowledge in the system by inserting or deleting some rules
		- For example, a domain-independent version of MYCIN called EMYCIN (Empty MYCIN) was later produced

### PROSPECTOR

- PROSPECTOR was an expert system for mineral exploration developed by the Stanford Research Institute
	- Nine experts contributed their knowledge and expertise
	- PROSPECTOR used a combined structure that incorporated rules and a semantic network
	- PROSPECTOR had over 1000 rules
- The user, an exploration geologist was asked to input the characteristics of a suspected deposit
	- The geological setting, structures, kinds of rocks and minerals
- PROSPECTOR compared these characteristics with models of ore deposits and made an assessment of the suspected mineral deposit
	- It could also explain the steps it used to reach the conclusion

### Survey 1986

- A 1986 survey reported a number of successful expert system applications in different areas (Waterman, 1986)
	- Chemistry
	- Electronics
	- Engineering
	- Geology
	- Management
	- Medicine
	- Process control
	- Military science
- Nearly 200 expert systems were found, most in the field of medical diagnosis
- Seven years later, a similar survey reported over 2500 developed expert systems (Durkin, 1994)
	- New growth in business and manufacturing (60% of all applications)

### Domain restriction

- Expert systems are restricted to narrow domain of expertise
	- ie. MYCIN diagnosed infectious blood diseases
		- If the patient had more than one disease, MYCIN becomes unreliable and therapy described by MYCIN could be come harmful
- Expert systems can show the sequence of the rules they applied to reach a solution, but cannot related accumulated, heuristic knowledge to any deeper understanding of the problem domain
- Expert systems have difficulty in recognising domain boundaries
	- When given a task different from typical problems, an expert system may attempt to solve it and fail in unexpected ways
- Heuristic rules represent knowledge in abstract form and lack basic understanding of the domain area
	- It makes the task of identifying incorrect, incomplete or inconsistent knowledge difficult
- Expert systems have little to no ability to learn from their experience
	- Expert systems are built individually and cannot be developed fast
	- Complex systems can take over 30 years to build

## How to make a machine learn, or the rebirth of neural networks (mid 1980s - onwards)

- Mid 1980s, researchers, engineers and experts found that building an expert system required more than just buying a reasoning system or expert system shell and putting enough rules in it
	- Predicted reduced funding for AI projects lead to researchers taking another look at neural networks
- By late 1960s, most of the basic ideas and concepts necessary for neural computing had already been formulated
	- Mid 1980s a solution emerged, powerful PCs / workstations
- Grossberg established a new principle of self-organisation, **adaptive resonance theory**, which provided the basis for a new class of neural networks (Grossberg, 1980)
- Hopfield introduced neural networks with feedback, **Hopfield networks** (Hopfield, 1982)
- Kohonen published a paper on **self-organising maps** (Kohonen, 1982)
- Barto, Sutton and Anderson published their work on **reinforcement learning** and its application in control (Barto et al., 1983)
- **Back-propagation learning algorithm**, first introduced by Bryson and Ho in 1969, was reinvented by Rumelhart and McClelland in *Parallel Distributed Processing* (1986)

## The new era of knoeldege engineering, or computing with words (late 1980s - onwards)

- Neural network technology offers more natural interaction with the real world than do systems based on symbolic reasoning
	- Neural networks can
		- Learn
		- Adapt to changes in a problem's environment
		- Establish patters in situations where rules are not known
		- Deal with fuzzy or incomplete information
	- However they lack explanation facilities and usually act as a black box
	- The process of training neural networks with current technologies is slow, and frequent retraining can cause serious difficulties
- Classic expert systems are especially good for closed-system application with precise inputs and logical outputs
	- They use expert knowledge in the form of rules, and if required, can interact with the user to establish a particular fact
	- A major drawback is that human experts cannot always express their knowledge in terms of rules or explain the line of reasoning
	- This can prevent the expert system from accumulating the necessary knowledge, and consequently lead to its failure

## Fuzzy logic

- Very important technology dealing with vague, imprecise and uncertain knowledge and data is **fuzzy logic**
	- Human experts do not usually think in probability values, but in such terms as
		- Often
		- Generally
		- Sometimes
		- Occasionally
		- Rarely
	- Fuzzy logic is concerned with capturing the meaning of words, human reasoning and decision making
	- Fuzzy logic provides the way to break through the computational bottlenecks of traditional expert systems
- At the heart of fuzzy logic lies the concept of a **linguistic variable**
	- The values of the linguistic variable are words rather than numbers
- Fuzzy logic or **fuzzy set theory** was introduced by Professor Lotfi Zadeh, Berkley's electrical engineering chairman in 1965
	- It provided a means of computing with words
	- However, acceptance of fuzzy set theory by the technical community was slow and difficult
	- Part of the problem was the provocative name fuzzy
		- It seemed too light hearted to be taken seriously
	- Eventually, fuzzy theory, ignored in the West, was taken seriously in the East, by the Japanese
	- It has been used successfully since 1987 in Japanese-designed dishwashers, washing machines, air conditioners, TVs, copiers and even cars

### Benefits

Benefits derived from the application of fuzzy logic models in knowledge-based and decision-support systems can be summarised as follows:

#### Improved computational power

- Fuzzy rule based systems perform faster than conventional expert systems and require fewer rules
- A fuzzy expert system merges the rules, making the more powerful
- Lotfi Zadeh believes that in a few years, most expert systems will use fuzzy logic to solve higher nonlinear and computationally difficult problems

#### Improved congitive modelling

- Fuzzy systems allow the encoding of knowledge in a form that reflects the way experts think about a complex problem
- They usually think in such imprecise terms as high and low, fast and slow, heavy and light
- In order to build conventional rules, we need to define the crisp boundaries for these terms by breaking down the expertise into fragments
- This fragmentation leads to the poor performance of conventional expert systems when they deal with complex problems
- In contrast, fuzzy expert systems model imprecise information, capturing expertise similar to the way it is represented in the expert mind, and thus improve cognitive modelling of the problem

#### Ability to represent multiple experts

- Conventional expert systems are built for a narrow domain
- It makes the system's performance fully dependent on the right choice of experts
- When a more complex expert system is being built or when expertise is not well defined, multiple experts might be needed
- However, multiple experts seldom reach close agreements
	- There are often differences in opinions and even conflicts
- This is especially true in areas such as business and management, where no simple solution exists and conflicting views should be taken into account
- Fuzzy expert systems can help to represent the expertise of multiple experts when they have opposing views

### Fuzzy system dependence

- Although fuzzy systems allow expression of expert knowledge in a more natural way, they still depend on the rules extracted from the experts and thus might be smart or dumb
	- Some experts can provide very clever fuzzy rules, but some just guess and may even get them wrong
	- Therefore, all rules must be tested and tuned, which can be a prolonged and tedious process
	- For example, it took Hitachi engineers several years to test and tune only 54 fuzzy rules to guide the Sendal Subway System
- In recent years, several methods based on neural network technology have been used to search numerical data for fuzzy rules
	- Adaptive or neural fuzzy systems can find new fuzzy rules, or change and tune existing ones based on the data provided
	- In other words
		- Data in, rules out
		- Or experience in, common sense out

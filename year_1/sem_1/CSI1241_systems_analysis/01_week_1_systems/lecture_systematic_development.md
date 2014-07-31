# Systematic Development

## Definition

- Systematic development is the process of developing an information system in an organised and professional way
- Systematic development implies:
	- It is planned and follows a defined approach (called a methodology) containing phases
	- Models are used
	- Specific deliverables and documentation are produced

## The Systems Development Lifecycle (SLDC)

- In essence there are two approaches to systems development:
	- The pre-defined approach
	- The evolutionary approach

## Pre-Specified Approach

- In the pre-specified approach, an attempt is made to anticipate all requirements in an information system before any coding begins
- These requirements then form the specification of the information system and they are then implemented onto the hardware/software platform as specified

## Example of Traditional Pre-Specified Lifecycle

![Waterfall Method](http://i.imgur.com/NHNYPv0.png)

- Definite bounded phases
- Linear sequential progression
- Lack of iteration
- Likely to have frozen specifications
- Sometimes called the Waterfall model

### The Reality of the Waterfall Method

![The Real Waterfall Method](http://i.imgur.com/2iNc2du.png)

- Constant feedback to other phases as work progresses

## Variants to the Pre-Specified Approach

- There is no rule that says there must be six phases
- Terms such as 'design' or 'construction' are not fixed, only simply an example
- A three phase lifecycle might be:
	- Analysis
	- Design
	- Construction
- But here, construction would have to include programming, testing, integrating all the programs together, documentation, user training etc.

## Quiz

- In terms of the lifecycle, where would you put the following job titles?
	- Systems analyst
	- Programmer
	- Analyst/Programmer
	- Business Analyst
- Who would be responsible for:
	- Testing
	- Documentation
	- User training

### Answer: 3 Phase Lifecycle

| Role               | Lifecycle                      |
|--------------------|--------------------------------|
| Systems Analyst    | Analysis, Design               |
| Analyst/Programmer | Analysis, Design, Construction |
| Business Analyst   | Analysis, Construction         |
| Programmer         | Construction                   |

| Responsibility | Role                                             |
|----------------|--------------------------------------------------|
| Testing        | Analyst/Programmer, Programmer, Business Analyst |
| Documentation  | Analyst/Programmer, Business Analyst             |
| User Training  | Business Analyst                                 |

## Evolutionary Approach

- In evolutionary approach, the view is taken that it is better to gradually develop an information system over time, allowing both users and systems analysts time to come to terms with what the requirements of the information system really are
- Many people believe the evolutionary approach to be superior to the traditional pre-specified approach, yet the pre-specified approach is often the *de-facto* standard

## Variants to the evolutionary approach

- Prototyping
- Incremental
- Spiral

*We will just consider the prototypic approach here*

## Prototyping Lifecycle

![Prototyping Lifecycle](http://i.imgur.com/9DRGTD4.png)

- Personal note: I compare it to early access for video games being released in alpha or beta stage
- Extreme Programming: 
	- Part of Agile family
	- Build each requirement into functionality one at a time
	- Always dealing with a live, working product
	- Will use Agile method in later units

## The Reality of Systems Development

- The reality of systems development is often that a blend of the approaches is taken. For example:
	- Prototyping can be used (and often is) within the traditional Waterfall approach
	- In the evolutionary approach, a degree of pre-specification is necessary to get started

## What You Will See

- In your degree you will use elements of all the approaches
- However, in this unit we will concentrate on the pre-specified approach in order to acquire the necessary skills in using certain diagrams
- In subsequent units, you will meet the evolutionary approach
- Also, it is quite likely for many applications that a software package could be bought for a fraction of the development cost
- Again, in this unit we make the assumption that you will develop 'in-house'

## Methodology

- An information system development methodology is a set of integrated techniques which support the development of an information system at every stage
- Integration is meant that the output from one technique is seamlessly used as the input to a later technique
- So a methodology brings together the phases of systems development lifecycle and defines what is produced from one phase to the next
- In this unit, the methodology we follow falls within what is known as the **structured** approach although we employ several object-oriented concepts as well

## Technique

- Olle et al. (1991) define a technique as 'a part of an information systems development methodology which may employ a well-defined set of concents and a way of handling them in a step of the work'
- Examples of techniques include:
	- Object modelling
	- Interviewing
	- Structured walkthroughs
	- Blackbox texting
- Typcally, techniques contain a relatively well defined set of steps, which if followed, allow the developer to achieve a particular sub-goal in the development of the information system

## Benefits of Using Methodologies

- Follows a framework developed by others with experience
- A defined and consistent approach, ie. a clear list of steps and deliverables
- Clearly defines roles and responsibilities
- Maximises the quality of system development
- Ensures adequate documentation
- Provides a management and control framework

## What We Focus On

- This unit is concerned with systems analysis, so the focus will be on the activities and techniques associated with that part of the lifecycle
- The output of the systems analysis phase is the **system specification**
- Part way through will have the **requirements specification**
- For the most part, the requirements specification contains the same headings as the system specification, but the system specification goes into more detail

## The Province of Systems Analysis

![Province of Systems Analysis](http://i.imgur.com/bEYnLSj.png)

## Or Put In Another Way

*See diagram on pp 20*

## The Specification

- Clearly, a systems specification must contain all the information necessary to develop an information system
- But exactly what information is required? And in what format is it best to describe this?
- Another problem is the process of development itself
- How does the analyst learn about what is required in the information system?
	- If there is an existing system (either manual or computerised) the analyst can examine this
	- Interview people and establish its problems
	- By modelling the existing system (using certain diagrams) and examining its problems, possible solutions can be identified and if agreed, implemented in a new computer system
	- If there is no existing information system, the the analyst has to create one from scratch
	- Probably necessary to model the likely information system using diagrmas
	- Possibly prototype it and get new users to agree with design

## Expectations vs. Requirements

- Expectations are what users perceive to be the net effect of the implemented system
	- They are told how much time they will save
	- How they can add value to the business through being empowered by the information system
- Requirements are statements about what functions or services the system will provide
	- Through providing functions, there is a belief that the expectations will emerge
- Do not confuse the two
	- Personal:
		- Expectation 'System will increase productivity'
		- Requirement 'System needs to do x and y' which in turn increases productivity

## Clarification

- In SCSS how does the topic of systems analysis relate to project management and software engineering?
	- Systems analysis is *more concerned* with acquiring skill in a relatively small number of mainstream techniques for developing systems
	- Project management is *more concerned* with techniques for planning, monitorying and controlling projects and the project team
	- Software engineering is *more concerned* with quality assurance, risk, estimation, metrics for measuring progress and in knowing how to select a technique from all possible techniques that are available as opposed to having skill in specific techniques such as drawing diagrams or interviewing
	- As such, systems analysis is the foundation unit

## Review

**Define the following:**

- Systematic development
	- The process of developing an information system in an organised and professional way
- SDLC
	- Software Development Life Cycle
- Evolutionary approach
	- To gradually develop an information system over time, allowing both users and systems analysts time to come to terms with what the requirements of the information system really are, ie. Agile methodology or Extreme programming
- Pre-specified approach
	- To anticipate all requirements in an information system before any coding begins, ie. Waterfall model
- Waterfall model
	- Definite bounded phases
	- Linear sequential progression
	- Lack of iteration
	- Likely to have frozen specifications
- Prototyping
	- There is a continuous cycle between implementation/maintenance to testing/prototyping that allows the system to be further developed and improved after the final working system is constructed
- Methodology
	- A set of integrated techniques which support the development of an information system at every stage
- Technique
	- Olle et al. (1991) define a technique as 'a part of an information systems development methodology which may employ a well-defined set of concents and a way of handling them in a step of the work'
- Requirements specification
	- Statements about what functions or services the system will provide
- Systems specification
	- Contain all the information necessary to develop an information system
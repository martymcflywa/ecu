# Quality

## Objectives

- What is quality
- Modern quality management and the **quality** movement
- Quality management processes

## What is quality

- Degree of excellence, superiority
	- Oxford dictionary
- Conformance to requirements
	- Crosby
- Software quality assurance definition
- But who defines quality?
	- The client or the IT team?
	- Requirements are not expectations

### Windows 2000 bugs

- 63,000 known bugs
- In February 2000, a Microsoft memo caused a stir when it leaked to the public
- An excerpt reads:

>"Our customers do not want us to sell them products with over 63,000 potential defects. They want those defects corrected. How many of you would spend $500 on a piece of software with over 63,000 potential known defects?"

## Modern quality management

- Requires customer satisfaction
- Prefers prevention to inspection
- Recognizes management responsibility for quality
- Noteworthy quality experts
	- Deming
	- Juran
	- Crosby
	- Ishikawa
	- Taguchi
	- Feigenbaum

## The quality movement

- Early humankind
	- Quality = survival
- Craftsmanship
	- Guilds in the middle ages regulated and controlled quality
- Industrial revolution
	- Mass production
	- Machines could build parts
		- Men learned to operate machines
- The question is whether software development is more like craftsmanship or mass production

## The rise of Japan

- W. Edwards Deming (1900 - 1993)
	- Worked at Western Electric in Chicago in 1920s
	- Management treated the worker as a cog in the machinery
	- Final inspection used to control quality
		- Worker not directly responsible
	- Invited to give a series of lectures in Japan in 1950s
	- The rest is history
- Kaoru Ishikawa (1915 - 1989)
	- Studied under Deming
	- Believes quality is a continuous process that relies on all levels of the organization
	- Advocated the use of easy-to-use statistical tools
		- Pareto diagram
		- Ishikawa fishbone diagram
		- Flow charts

## W. Edwards Demming (1900 - 1993)

### Deming's 14 points

- Don't depend on inspection at the end
- Keep improving constantly
- Institute training on the job
- Institute leadership
- Drive out fear
- Break down barriers between departments
- Eliminate quotas
- Take pride in your work
- Focus education and self-improvement
- It takes everyone to accomplish the transformation

All these points apply to software development

### The quality thrust

>In short term, quality costs. In long term, lack of quality costs. - Deming

- Commitment to quality is a trait that is evident in successful companies
- Total quality management
	- An all pervading organizational approach to quality

### Deming's philosophy

>Quality = result of work efforts / total costs

- The idea is that if you focus on work efforts,
	- Quality tends to increase and costs fall over time
- However, when people or organizations focus mainly on costs,
	- Then costs tend to rise and quality falls over time

## Kaoru Ishikawa (1915 - 1989)

### Pareto analysis

- Involves identify the vital few contributors that account for the most quality problems in a system
- Also called the 80/20 rule
	- 80 % of problems are due to 20% of causes
	- Helps to identify where improvements will have the biggest effect
- Pareto diagrams
	- Histograms or column charts representing a frequency distribution
	- Helps identify and prioritize problem areas

### Ishikawa fishbone diagram

![ishikawa fishbone diagram](http://snag.gy/FiC6c.jpg)

## Quality systems

- International organisation for standardization (ISO)

>Facilitate the international coordination and unification of industrial standards.

- ISO 9000
	- Quality system standard
	- Continuous cycle of
		- Planning
		- Controlling
		- Documenting quality
	- Provides minimum requirements needed for an organization to meet its quality certification standards
	- Helps organizations around the world reduce costs and improve customer satisfaction

## Quality management processes (PMBOK)

- The processes required to ensure that the project will satisfy the needs for which it was undertaken
- Includes all activities of the overall management function that determines
	- Quality policy
	- Objectives
	- Responsibility
- Implements them by a means of
	- Quality planning
	- Quality assurance
	- Quality control
	- Quality improvement

### IT project quality plan

- Purpose and policy
	- Focus on customer satisfaction
	- Prevention not inspection
	- Improve the process to improve the product
	- Quality is everyone's responsibility
	- Fact based management

![it project quality plan](http://snag.gy/C3213.jpg)

## Quality assurance procedures

- Broad term includes
	- Management reviews
	- Peer reviews
		- Walk throughs
		- Inspections
- Work outputs are evaluated by others to
	- Measure progress
	- Identify and expose errors
	- Impose standards

### Management reviews

- A presentation to management/client usually coinciding with a project milestone
	- Designed to ensure that the IT solution provides the required functionality defined in the project scope and detailed requirements definition
	- Ensures that a particular project deliverable
		- Is complete
		- Provides information necessary for the next phase or process
		- Meets predefined standards
		- Conforms to the project and software development methodology
- Reviewers need knowledge/experience to assess and be empowered to approve

### Peer review

- Walkthroughs
	- Are peer group reviews of all items associated with a software product
		- Prototype
		- Data flow diagram
		- Requirements specification
		- Pseudocode
		- Code
		- Presentations

### Walkthroughs

- Need to be conducted formally
- Attendees selected for ability to contribute
- Material distributed prior to event
- Presenter leads the group through the item with reference to
	- Task description
	- Standards
	- etc.
- Walkthrough record produced
	- Attendees
	- Problem areas recorded

#### Walkthrough rules

- Requires
	- Moderator
	- Presenter
	- Recorder
	- Attendees
- Not designed to evaluate presenter
- Presenter responsible for distribution of materials in time for adequate reviewing
- Action items carefully documented
- Outcomes
	- If minor problems
		- Later confirmation by moderator that problems are addressed
	- If serious problems
		- Further walkthrough

### Value of peer reviews

- Strict discipline
	- Substantial increase in quality
- Educational
	- New team members are more easily able to conform to standards
		- Peer work is visible
- Everyone in team responsible for quality
- Other reviewing techniques
	- Self reviews
		- ie. Desk checking
	- Inspections
		- Work reviewed by peer/s individually

## Testing procedures

- Verification: Reviewing the process
	- Focuses on process related activities
	- Ensures that the products/deliverables meet specified requirements before final testing
	- Are we building the product the right way?
- Validation: Reviewing the product
	- Does the system function as intended?
	- Does it have all the capabilities/features defined in project scope and requirements definition?
	- Are we building the right product?

### Accumulative effects of error

![accumulative effects of error](http://snag.gy/68UfY.jpg)

## Software testing approaches

### Unit testing

- Focuses on the module/program/object level to determine whether specific functions work properly
- Black box testing
	- Tests the program against specified requirements or functionality
- White box testing
	- Examines the paths of logic or the structure inside a program
- Gray box testing
	- Focuses on the internal structure of the program

### Integration testing

- Tests whether a set of logically related units work together properly after unit testing is complete
	- Functions
	- Modules
	- Programs
	- etc.

### Systems testing

- Tests the system as a whole in an operating environment to verify functionality and fitness for use
- May include tests to verify
	- Usabilitiy
	- Performance
	- Stress
	- Compatibility
	- Documentation

### Acceptance testing

- Certifies that the system satisfies the end user or customer's scope and detailed requirements after systems testing is complete
- It is the user's or client's responsibility to assure that all features and functionality are included

## Change control and configuration management

- Component identification
	- Naming conventions
- Version control
	- Evolutionary changes
- Change control
	- Proposed changes are
		- Evaluated
		- Approved/rejected
		- Scheduled
		- Tracked
	- Reporting and auditing

## Process improvement

- Lessons learned
	- Provide the basis for continual improvement
	- Can be the basis for identifying and implementing best practices
- A quality plan should do more than attempt to build a better IT solution
	- It should also support the organization in searching for ways to manage projects better

## Maturity models

- Frameworks for helping organizations improve their process and systems
- Software Engineering Institute's **Capability Maturity Model (CMM)** is a five level model laying out a generic path to process improvement for software development in organizations
	- Can measure the maturity of an organization's software process
	- Can evaluate its software process capability
	- Help prioritize improvement efforts
- CMM levels, lowest to highest:
	- Initial
	- Repeatable
	- Defined
	- Managed
	- Optimizing

## CMM process improvement

### Immature software organization

- Reactive in nature
	- Managers continually "fight fires"
- Schedules and budgets usually exceeded
- Functionality and quality often compromised to meet schedules
- Project success determined by who is or is not part of the project team
- No basis for judging quality
- Never seems to be enough time to address problem issues or improve the current processes

### Mature software organization

- Proactive and able to follow a set of disciplined processes throughout the software project
- Software processes and the roles of individuals
	- Defined explicitly and communicated throughout the organization
- Software processes are monitored and continually improved
	- Based on experimentation or experiences
- Budgets/schedules based on past projects so
	- More realistic
	- More likely to be achieved

## Summary

- What is quality?
- Modern quality management and the **quality movement**
- Quality management processes
- Remember
	- Most quality management is about trying to guarantee the quality of the process
		- Rather than trying to guarantee the quality of the end product

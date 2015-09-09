# Chapter 8: Quality

## Importance of quality management

- Most people simply accept poor quality from IT projects
- Quality is a real problem in IT projects
- Companies rush products to market with serious quality problems
- Project managers are ultimately responsible for quality management on their products
- Be familiar with quality terms, standards and resources
	- See
		- [iso.org](http://www.iso.org)
		- [ieee.org](http://www.ieee.org)

## What is project quality management

- Quality definition
	- ISO8042:1994
		- Totality of characteristics of an entity that bear on its ability to satisfy stated or implied needs
	- ISO9000:2000
		- The degree to which a set of inherent characteristics fulfills requirements
	- Conformance to requirements and fitness for use
		- Conformance to requirements
			- Project's processes and products meet written specifications
		- Fitness for use
			- A product can be used as it was intended
- Purpose of quality management
	- Ensure that the project will satisfy the needs for which it was undertaken
	- To meet/exceed stakeholder needs/expectations
		- Develop good relationships with key stakeholders
			- Especially main customer
			- To understand what quality means to them
			- The customer ultimately decides if quality is acceptable
	- Projects fail because project team
		- Focuses only on meeting written requirements for main products
		- Ignores other stakeholder needs/expectations
	- Quality must be on equal level with
		- Scope
		- Time
		- Cost

## Quality management processes

### Planning quality management

- Identify which quality requirements and standards are relevant to the project
- How to satisfy them
- Setting standards
	- SLA

#### Output

- Quality management plan
- Process improvement plan
- Quality metrics
	- Failure rates
	- Availability of goods/services
	- Customer satisfaction ratings
- Quality checklists
- Project document updates

### Performing quality assurance

- Periodically evaluating overall project performance
	- Ensures that the project will satisfy relevant quality standards
- Taking responsibility for quality throughout lifecycle

#### Output

- Change requests
- Project management plan updates
- Project documents updates
- Organizational process asset updates

### Controlling quality

- Monitor specific project results
	- Ensures that they comply with relevant quality standards
	- Identifies ways to improve overall quality
- Associated with technical tools and techniques
	- Patero charts
	- Quality control charts
	- Statistical sampling

#### Output

- Quality control measurements
- Validated changes
- Validated deliverables
- Work performance information
- Change requests
- Project management plan updates
- Project documents updates
- Organizational process asset updates

## Planning quality management

- Implies the ability to anticipate situations and prepare actions that bring about the desired outcome
- Prevention of defects through a program of
	- Selection proper materials
	- Training/indocrinating people in quality
	- Planning a process that ensures the appropriate outcome
- Important to identify relevant quality standards for each project
	- Design quality into products of the project and processes involved in managing the project
- Tools/techniques
	- Design of experiments
		- Helps identify which variables have the most influence on the overall outcome of a process
			- Understanding which variables affect outcome is a very important part of quality planning
		- Can be applied to project management issues
			- Costs/schedule tradeoffs
				- ie. Juior programmers cost less but cannot be expected to complete the same level of work in same amount of time
- Involves communicating correct actions to ensure quality in format that is understandable and complete
	- Describe key factors that directly contribute to meeting customer requirements

### Scope aspects that affect quality

#### Functionality / features

- Functionality
	- The degree to which a system performs its intended function
- Features
	- Special characteristics that appeal to users
- Important to clarify
	- What functions/features the system **must** perform
	- What functions/features are **optional**

#### System outputs

- Screens/reports the system generates
- Important to clearly define what screens/reports look like for a system
	- Can users easily interpret outputs
	- Can users get all the reports they need in suitable format

#### Performance

- Addresses how well a product or service performs the customer's intended use
	- What volumes of data and transactions should the system be capable of handling
	- How many simultaneous users should the system be designed to handle
	- What is the projected growth rate in the number of users
	- What type of equipment must the system run on
	- How fast must the response time be for different aspects of the system under different circumstances

#### Reliability

- Ability of product/service to perform as expected under normal conditions
- Also known as IT service management
- See ISO/IEC 20000

#### Maintainability

- The ease of performing maintenance on a product
- Stakeholders must define their expectations
	- What are the normal conditions of use
	- Can the system be offline during maintenance
	- Do we need to provide helpdesk support
		- SLA of support
	- How often can users tolerate system failure
	- Are stakeholders willing to pay more for higher reliability/fewer failures

## Performing quality assurance

- Includes all activities related to satisfying quality standards for a project
- Continuous quality improvement
- Input
	- Quality management plan
	- Process improvement plan
	- Quality metrics
	- Quality control measurements
	- Project documents
- Terminology
	- Kaizen
		- Japanese word for improvement
	- Lean
		- Evaluating processes to maximize customer value
		- While minimizing waste
- Tools
	- Design of experiments
		- See planning
	- Benchmarking
		- Generates ideas for quality improvements
		- Compare specific project practices or product characteristics to other projects/products within or outside organization
	- Ishikawa fishbone diagrams
		- Helps find root causes of quality problems
	- Quality audit
		- Structured review of specific quality management activities
		- Helps identify lessons learned which could improve performance on current/future projects
		- Can be
			- In-house or third party
			- Scheduled or random

## Controlling quality

- Distinguish quality control from
	- Quality planning
	- Quality assurance
- Outcomes
	- Improve quality
	- Acceptance decisions
	- Reword
	- Process adjustments

### Acceptance decisions

- Determine if the product/service product will be accepted or rejected
	- Accepted
		- Work becomes validated deliverables
	- Rejected
		- Rework must occur

### Rework

- Action taken to bring reject items into
	- Compliance with product requirements
	- Specifications
	- Other stakeholder expectations
- Results in
	- Requested changes
	- Validated defect repair
- Results from
	- Recommended defect repair
	- Corrective/preventative actions
- Can be expensive
	- Try to avoid this need

### Process adjustments

- Correct/prevent further quality problems based on quality control measures
- Results in updates to
	- Quality baseline
	- Organizational process assets
	- Project management plan

## Tools/techniques for quality control

- Seven basic tools of quality
- Statistical sampling
- Six Sigma


### Seven basic tools of quality

- Arose in postwar Japan
	- Inspired by the seven famous weapons of Benkei

#### Cause and effect diagrams

- Trace complaints about quality problems back to responsible production operations
- Help find the root cause of problem
- Also known as **fishbone** or **Ishikawa diagrams**
- Can also use technique called **5 whys**
	- Repeatedly ask the question "why?"
	- Peels away layers of symptoms that can lead to root cause of problem
- ie. Ask why users cannot get into the system
	- Why they keep forgetting passwords
		- Why they did not reset passwords
			- Why they did not check a box to save password
	- Root cause will have significant impact on actions taken to solve problem

#### Control chart

- Graphic display of data that illustrates the results of a process over time
- Allows to determine whether a process is in or out of control
- **In control**
	- Any variations in result are caused by random events
	- Process does not need to be adjusted
- **Out of control**
	- Any variations in result are caused by non-random events
	- Need to identify cause of non-random events
	- Adjust the process to correct/eliminate them
- Must define upper/lower acceptable limits
- Use control charts and **seven run rule** to look for patterns in data

##### Seven run rule

- If seven data points in a row are all either
	- Below the mean
	- Above the mean
	- Increasing/decreasing
- Then the process needs to be examined for non-random problems

#### Checksheet

- Used to collect/analyze data
	- Also known as tally sheet or checklist
		- Depending on format
- Could be used to track media source of complaints

#### Scatter diagram

- Helps to show if there is a relationship between two variables
- The closer data points are to a diagonal line, the more closely the two variables are related
- Could be used to compare satisfaction ratings between different age groups
	- ie. Younger users less satisfied with system

#### Histogram

- Bar graph of a distribution of variables
- Each bar represents an attribute of a problem/situation
- Height of bar represents frequency
- Could be used to show how many total complaints received per week

#### Pareto chart

- Histogram that helps identify/prioritize problem areas
- Variables in histogram are ordered by frequency of occurrence
- Identifies vital few contributors that account for most quality problems in system
- Also known as 80/20 rule
	- 80% of problems due to 20% of causes
- Could be used to identify where to focus improvement
	- Where it will make the highest impact
	- Outlying issues (low values) can be investigated further
		- Could be caused by variables with higher frequency values

#### Flow charts

- Graphic displays of the logic and flow of processes that help analyze how problems occur and how processes can be improved
- Shows
	- Activities
	- Decision points
	- Order of how information is processed
- Used for **stratification**
	- Technique that shows data from a variety of sources to see if a pattern emerges

##### Run charts

- Displays history and pattern of variation of a process over time
- Can be used to perform trend analysis
	- Forecast future outcomes based on historical results
	- ie. Trend analysis can help analyze how many defects have been identified over time
		- See if there are trends

### Statistical sampling

- Concepts
	- Statistical sampling
	- Certainty factor
	- Standard deviation
	- Variability
- Standard deviation and variability are fundamental concepts for understanding quality control charts
- Involves choosing a part of population of interest for inspection
- Size of sample depends on how representative you want to be
	- Simple formula

>sample size = 0.25 * (certainty factor / acceptable error)<sup>2</sup>

#### Certainty factor

- How certain you want to be that the sampled data does not include variations that do not naturally exist in the population
- Calculate certainty factor from tables that are available in statistics books

| Desired certainty | Certainty factor |
|-------------------|------------------|
| 95%               | 1.960            |
| 90%               | 1.645            |
| 80%               | 1.281            |

##### Example

- Suppose that 95% certainty is acceptable that a sample of invoices would contain no variation unless it was present in the population of total invoices
- Sample size would be calculated as:

>sample size = 0.25 * (1.960 / 0.05)<sup>2</sup> = 384

- For 90% certainty:

>sample size = 0.25 * (1.645 / 0.10)<sup>2</sup> = 68

- For 80% certainty:

>sample size = 0.25 * (1.281 / 0.20)<sup>2</sup> = 10

- For a 90% certainty factor, 68 samples would need to be examined to determine the type of data to be captured

### Six sigma

>Six Sigma is a comprehensive and flexible system for achieving, sustaining and maximizing business success. Six Sigma is uniquely driven by close understanding of customer needs, disciplined use of facts, data and statistical analysis, and diligent attention to managing, improving, and reinventing business processes.

- Target for perfection
	- No more than 3.4
		- Defects
		- Errors
		- Or mistakes
	- Per million opportunities
- Principles can be applied to
	- Design/production of product
	- Help desk
	- Other customer service process
- Six Sigma quality control has 5 phase improvement process (DMAIC)
	- Define
	- Measure
	- Analyze
	- Improve
	- Control
- Systematic, closed loop process for continued improvement
	- Scientific and fact based

#### Define

- Define
	- Problem/opportunity
	- Process
	- Customer requirements
- Tools
	- Process maps
	- Voice of the Customer (VOC)
- Voice of the Customer (VOC)
	- Complaints
	- Surveys
	- Comments
	- Market research

#### Measure

- Define measures
- Collect, compile, display data
- Measures are defined in terms of defects per opportunity

#### Analyze

- Scrutinize process details to find improvement opportunities
- Investigate/verify data to prove the suspected root causes of quality problems
	- Substantiate problem statement
- Tool
	- Fishbone/Ishikawa diagram

#### Improve

- Generate solutions/ideas for improving problem
- Final solution verified with project sponsor
- Develop plan to pilot test solution
- Review results of pilot test
	- Refine solution if required
- Implement solution

#### Control

- Track and verify
	- Stability of improvements
	- Predictability of solution
- Tool
	- Control charts

#### How Six Sigma quality control is unique

- Use of Six Sigma is an organization wide commitment
	- Seen improvements due to use
	- There are training investments
		- But they pay off as employees practice Six Sigma principles
	- Produce higher quality goods and services for lower price
- Follows belt system like Karate
	- Yellow belt
		- Minimum level of training
		- 2-3 days training
		- For part time team members
	- Green belt
		- 2-3 weeks training
	- Black belt
		- Work on Six Sigma projects full time
		- 4-5 weeks training
		- Project managers are black belt
	- Master black belt
		- Experienced black belts who act as technical resources and mentors to people with lower level belts
- Organizations that successfully implement Six Sigma have ability and willingness to adopt two contrary objectives at the same time
	- Can be creative and rational
	- Focus on big picture and minute details
	- Reduce errors and get things done faster
	- Make customers happier and make lots of money
- Operating philosophy that is
	- Customer focused
	- Strives to drive out waste
	- Raise levels of quality
	- Improve financial performance at breakthrough levels
	- Sets high goals
	- Uses DMAIC improvement process to achieve extraordinary quality improvements

#### Six Sigma and project selection/management

- Well selected/defined improvement projects
	- Equal better/faster results
- Poorly selected/defined projects
	- Equal delayed results and frustration
- Minimizing defects does not matter if an organization makes products that people don't want
- What makes a project a potential Six Sigma project?
	- Must be quality problem/gap between current and desired performance
	- Project should not have a clearly understood problem
	- Solution should not be predetermined
		- Optimal solution should not be apparent
- Six Sigma projects usually have
	- Business case
	- Project charter
	- Requirements documents
	- Schedule
	- Budget
- Done in teams
	- Have sponsors
		- Called champions
	- Have project manager
		- Called team leaders

#### Six Sigma statistics

- Concept
	- Improve quality by reducing variation
- Sigma
	- Means standard deviation
- Standard deviation
	- How much variation exists in a distribution of data
	- Small standard deviation
		- Data clusters closely around the middle of a distribution
		- Little variability among data
	- Large standard deviation
		- Data is spread around the middle of the distribution
		- Greater variability
	- Noted with Greek symbol &sigma;
- Normal distribution
	- Bell curve
	- Symmetrical about the mean
	- 1&sigma;
		- 68.3%
	- 2&sigma;
		- 95.5%
	- 3&sigma;
		- 99.7%

![normal std dev](http://www.fgse.nova.edu/edl/secure/stats/images/image30.gif)

- Standard deviation is key factor in determining the acceptable number of defective units in a population
- Table below illustrates the relationship between
	- Sigma
	- % of population within sigma range
	- Number of defective units per billion

| Spec range (&sigma; +/-) | % of population within range | Defective units per billion |
|--------------------------|------------------------------|-----------------------|
| 1                        | 68.27                        | 317,300,000           |
| 2                        | 95.45                        | 45,400,000            |
| 3                        | 99.73                        | 2,700,000             |
| 4                        | 99.9937                      | 64,000                |
| 5                        | 99.999943                    | 57                    |
| 6                        | 99.9999998                   | 2                     |

- Six Sigma is a scoring system that accounts for more variation in a process than you would typically find in a few weeks or months of data gathering
	- Time is an important factor in determining process variations
- Table below shows Six Sigma conversion table applied to Six Sigma projects

| &sigma; | Yield     | Defects |
|---------|-----------|---------|
| 1       | 31.0%     | 690,000 |
| 2       | 69.2%     | 308,000 |
| 3       | 93.3%     | 66,800  |
| 4       | 99.4%     | 6,210   |
| 5       | 99.97%    | 230     |
| 6       | 99.99966% | 3.4     |

- Yield
	- Number of units handled correctly through the process steps
- Defect
	- Any instance in which the product or service fails to meet customer requirements
	- Several opportunities to have defect due to multiple requirements
	- Six Sigma measures number of defects based on number of opportunities
- Telecommunications industry
	- Six 9s of quality
		- Measure of quality control equal to 1 fault in 1 million opportunities
		- 99.9999% service availability = 30 seconds of downtime a year
			- This level of quality can also be stated as target goal for
				- Number of errors in communications circuit
				- System failures
				- Errors in lines of code
		- Requires continual testing to find/eliminate errors
		- Or enough redundancy/back up to reduce system failure to required level

### Testing

- Testing needs to be done during almost every phase of life cycle
	- Not just before shipping or handover date
- Other tests not listed below
	- Alpha/beta testing
	- Performance testing
	- Scalability testing
- Testing alone cannot always solve software defect problems
	- Traditional code/test/fix cycle for software development is not enough
	- As code complexity increases
		- Number of defects missed by testing increases
	- Programmers introduce a defect for every 9-10 lines of code
	- Finished software post testing contains 5-6 defects per thousand lines of code

#### Unit testing

- Test individual components of a program
- Ensures that it is as defect free as possible
- Performed before moving on to integration test

#### Integration testing

- Occurs between unit and systems testing
- Tests functionally grouped components
- Ensures that subset/s of the entire system works together

#### Systems testing

- Tests entire system as one entity
- Focuses on big picture to ensure the entire system works properly

#### User acceptance testing

- Independent test performed by end users prior to accepting the delivered item
- Focuses on the business fit of the system to the organization, rather than technical issues

## Modern quality management

- Requires customer satisfaction
- Prefers prevention to inspection
- Recognizes management responsibility for quality

### Deming's 14 points for management

1. Create consistency of purpose for improvement of product and service
2. Adopt the new philosophy
3. Cease dependence on inspection to achieve quality
4. End the practice of awarding business based on price tag alone
	- Instead, minimize total cost by working with a single supplier
5. Improve constantly and forever every process for
	- Planning
	- Production
	- Service
6. Institute training on the job
7. Adopt and institute leadership
8. Drive out fear
9. Break down barriers between staff areas
10. Eliminate slogans, exhortations, and targets for the workforce
11. Eliminate numerical quotas for the workforce and numerical goals for management
12. Remove barriers that rob people of workmanship
	- Eliminate the annual rating or merit system
13. Institute a vigorous program of education and self improvement for everyone
14. Put everyone in the company to work to accomplish the transformation

### Juran's 10 steps to quality improvement

1. Build awareness of the need and opportunity for improvement
2. Set goals for improvement
3. Organize to reach the goals
	- Establish a quality council
	- Identify problems
	- Select projects
	- Appoint teams
	- Designate facilitators
4. Provide training
5. Carry out projects to solve problems
6. Report progress
7. Give recognition
8. Communicate results
9. Keep score
10. Maintain momentum by making annual improvement part of the regular systems and processes of the company

### Crosby's 14 steps for quality improvement

1. Make it clear that management is committed to quality
2. Form quality improvement teams with representatives from each department
3. Determine where current and potential quality problems lie
4. Evaluate the cost of quality and explain its use as a management tool
5. Raise the quality awareness and personal concerns of all employees
6. Take actions to correct problems identified through previous steps
7. Establish a committee for the zero defects program
8. Train supervisors to actively carry out their part of the quality improvement program
9. Hold a "zero defects day" to let all employees realize that there has been a change
10. Encourage individuals to establish improvement goals for themselves and their groups
11. Encourage employees to communicate to management the obstacles they face in attaining their improvement goals
12. Recognize and appreciate those who participate
13. Establish quality councils to communicate on a regular basis
14. Do it all over again to emphasize that the quality improvement program never ends

### Ishikawa's guide to quality control

- Guide to Quality Control (1972)
- Pioneered use of cause and effect diagrams
- Concept of quality circles
	- Groups of nonsupervisors and work leaders in a single company department
	- Volunteer to conduct group studies on how to improve the effectiveness of work in their department

### Taguchi and robust design methods

- Taguchi methods for optimizing the process of engineering experimentation
- Key concepts
	- Quality should be designed into the product
		- Not inspected into it
	- Quality best achieved by minimizing deviation from the target value
- Robust design methods
	- Focus on eliminating defects by substituting scientific inquiry for trial and error methods

### Feigenbaum and worker's responsibility for quality

- Developed total quality control (TQC)
- Responsibility for quality should rest with the people who do the work
- Quality is more important than production rates
	- Workers allowed to stop production when a quality problem occurs

### ISO standards

- Network of national standards institutes
	- Work in partnership with international
		- Organizations
		- Governments
		- Industries
		- Businesses
		- Consumer representatives
- ISO 9000
	- Three part continuous cycle of
		- Planning
		- Controlling
		- Documenting
	- Quality in an organization
	- Represents an international consensus on good quality management practices
	- Consists of standards/guidelines relating to quality management systems and relating supporting standards
- ISO 9001:2008
	- Provides set of standardized requirements for quality management system
		- Regardless of what the user organization
			- Does
			- Its size
			- Private or public
- Overall goals of a standard are to encourage organizations that are interested in improving quality of software products to employ proven, consistent, and reliable methods for assessing the state of their software development processes
	- Can use their assessment results as part of coherent improvement programs
- Outcomes of assessment and consequent improvement programs is
	- Reliable, predictable and continuously improving software processes

## Improving IT project quality

### Leadership

- Top management must lead the way to strive for quality
- Must take responsibility in quality programs
	- Creating
	- Supporting
	- Promoting
- Leadership provides environment conducive to producing quality
	- Must publicly declare the company's philosophy and commitment to quality
	- Implement company wide training programs in quality concepts and principles
	- Implement measurement programs to establish and track quality levels
	- Actively demonstrate importance of quality

### Cost of quality

- Is the cost of conformance plus the cost of non-conformance
- Conformance
	- Delivering the products that meet requirements and fitness of use
	- Costs include associated costs with
		- Developing quality plan
		- Analyzing/managing product requirements
		- Testing
- Non-conformance
	- Taking responsibility for failures
	- Not meeting quality expectations

#### Prevention cost

- Cost of planning and executing a project so that it is error free or within acceptable error range
- Preventative actions
	- Training
	- Detailed studies related to quality
	- Quality surveys of suppliers/contractors

#### Appraisal cost

- Cost of evaluating processes and their outputs to ensure that a project is error free or within acceptable error range
- Activities
	- Inspection/testing of products
	- Maintenance of inspection/test equipment
	- Processing and reporting inspection data

#### Internal failure cost

- Cost incurred to correct an identified defect before the customer receives the product
- Items
	- Scrap and reword
	- Charges related to late payment of bills
	- Inventory costs that are a direct result of defects
	- Costs of engineering changes related to correcting a design error
	- Premature failure of products
	- Correcting documentation

#### External failure cost

- Cost relates to all errors not detected and corrected before delivery to tghe customer
- Items
	- Warranty
	- Field service personnel training
	- Product liability suits
	- Complaint handling
	- Future business losses

#### Measurement and test equipment cost

- Capital cost of equipment used to perform prevention and appraisal activities

### Maturity models

- Frameworks for helping organizations improve their processes and systems
- Describe an evolutionary path of increasingly organized and systematically more mature processes
- Have five levels
	- First level describing characteristics of the least organized/mature organizations
	- Fifth level describing characteristics of the most organized/mature organizations
- Three popular maturity models include
	- Software quality function deployment (SQFD)
	- Capability maturity model integration (CMMI)
	- Project management maturity model

#### Software quality function deployment (SQFD)

- Adaptation of quality function deployment model
- Focuses on defining user requirements and planning software projects
- Result of SQFD
	- Set of measurable technical product specifications and their priorities
- Clearer requirements means
	- Fewer design changes
	- Increased productivity
	- Software products that are more likely to satisfy stakeholder requirements
- Based on idea of introducing quality early
	- Taguchi's robust design methods

#### Capability maturity model integration (CMMI)

- Process improvement approach that provides organizations with the essential elements of effective processes
- Used to guide process improvement across
	- Project
	- Division
	- Entire organization
- Helps
	- Integrate traditionally separate organizational functions
	- Set process improvement goals/priorities
	- Provide guidance for quality processes
	- Provide a point of reference for appraising current processes

##### Capability levels

- Incomplete
	- Process is either not performed or partially performed
	- No generic goals exist for this level
	- One or more of the specific goals not satisfied
- Performed
	- Satisfies the specific goals of the process area
	- Supports and enables the work needed to produce work products
- Managed
	- Process has the basic infrastructure in place to support it
	- Process is planned and executed based on policies
	- Employs skilled people who have adequate resources to produce controlled outputs
	- Existing practices are retained during times of stress
- Defined
	- Process is rigorously defined
	- Standards, process descriptions, procedures for each project are tailored from the organization's set of standard processes
- Quantitatively managed
	- Process is controlled using statistical and other quantitative techniques
	- Organization establishes quantitative objectives for quality and process performance that are used as criteria for managing the process
- Optimizing
	- Process is improved based on an understanding of the common causes of variation inherent in the process
	- Focus is on continually improving the range of process performance through incremental and innovative improvements

#### Project management maturity model (OPM3)

- Based on market research surveys sent to 30,000 project management professionals
- Incorporates
	- 180 best practices
	- 2,400 capabilities, outcomes, key performance indicators (KPI)
- Helps organizations assess/improve their project management capabilities


## Using software to assist in project quality management

- Charts/diagrams for "seven basic tools of quality"
	- Use spreadsheet/charting software
- Statistical software packages
	- Determine standard deviation
- Project management software
	- Gantt charts
	-

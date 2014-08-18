# Describing Business Processes

## Business Processes

- A business process is a discrete meaningful component of a business
    - Sales ordering
    - Marketing
    - Accounting
    - Teaching
- A well defined business process usually exhibits high cohesion and low coupling with respect to other business processes
- Business processes have received a lot of attention recently because by examining them we can identify ways to be more efficient or to obtain advantages over competitors
- Systems analysts would be expected to know about business processes and recommend how an organisation might improve its business processes
    - Often called business process re-engineering (BPR)
- A major issue is that systems analysts have been wrestling with for years is the amount of change that occurs in the business
- The reasons for change are quite clear and easy to understand
    - We live in a dynamic business environment in which we are forced to at least keep up with the competitors, otherwise we do not survive
- While we all know that change is part of the environment, what we do about it and how we design our information systems and human activity systems is a much harder question to address

## Business Process Workflow (BPW)

- So how do we draw business processes?
- Are there rules and symbols?
    - Constructs
- What problems exist in expressing business processes?
- Consider the following problem:

### Pergola Man

The Pergola Man operates in the northern suburbs of Perth, building pergolas and gazebos for private customers. When a customer approaches him, he:

- Visits their house
- Takes measurements
- Then discusses possible pergolas or gazebo options with the customer

As a result of discussion, Pergola Man sends the customer a detailed quotation. The customer may or may not accept the quotation. In due course, the customer is sent an invoice for the work done. Pergola Man allows part-payments over six months in order to encourage more business.

Pergola Man is considering creating a website as a means of attracting new customers. He anticipates the website will allow customers to browse examples of his work, browse company details including likely prices and timescales, email him with a request for a visit and permit part/payment of invoices.

### BPW Example

![pergolaman](http://i.imgur.com/uWcZKqt.png)

- Bubbles represent business process
- Arrows are just helpful aids in understanding the flow
    - No strict rules concerning arrows
    - An arrow might represent a concrete document
    - Or could be conceptual, ie approach
    - Arrows exist to provide context to diagram
    - Start and end arrows are usually named, but naming intermediate arrows are optional
    - Sometimes there is no need for end arrows
        - Like when something is updated in a file or computer, no arrow is shown because nothing further happens at that point

The most important feature is that it shows the underlying precedence (logical sequence) between a collection of business processes. In the example above, measurements need to be taken before options can be discussed.

Note that there were 4 BPWs in the diagram. Each of these BPWs is discrete. In other words, the occur on their own and can be executed independently of the other BPWs.

## Problems with Business Processes

One problem in defining business processes is that they can be used to describe processes at differing levels within an organisation.

In the following example, there is a *business process* called the Sales Administration System (SAS). Yet within it, business processes called Sales Order Processing (SOP), Invoicing and Sales Ledger Maintenance are undertaken. 

![sas](http://i.imgur.com/l0G50Tw.png)

Both BPWs above model the same business process.

## Atomic Business Processes

All the above processes are quite high level, eg. Sales Ledger Maintenance involves a number of different tasks such as posting the invoice into it, and receiving and recording payments.

If a business process has too many inputs or outputs, it is a sign that it is at too high a level.

An atomic business process is a discrete process typically done by one person at one time in one place. So posting an invoice would be atomic, but sales ledger maintenance or sales administration would not.

When we draw business process workflows, **all** processes should be **atomic**.

### Example of Atomic Processes

![atomic](http://i.imgur.com/bSrgUst.png)

**Note** that there is only one input.

The logic of business processes often dictates that some atomic processes are carried out sequentially, while for others, there is a gap in time before the next process *in sequence* begins.

As in the Pergola Man example, it would be logical for the Pergola Man to visit the home, take measurements and discuss options all in the one session. Only some time later would it be likely that the customer would come back to initiate the order.

So where sequence exists, it is important to show it as a chain of atomic business processes. Equally, where there is a logical break in the system, it is important to show that as a **separate** chain.

## Re-Engineering Processes

It is quite straight forward to model processes from a case study and draw the BPWs. A much harder task is to change the processes to make them more efficient or effective.

Efficiency changes often involve putting processes onto the computer. For example, allowing payments over the Internet (as long as implemented securely) will result in increased efficiency for the business because it does not have to waste its own staff time in processing these payments.

Effectiveness changes are harder to identify. You have to analyse carefully how the business is being undertaken, look for weaknesses, inefficiencies and so on. Usually the analyst would work with the managers in the business to negotiate these.

Sometimes re-engineering involves re-thinking the way a task is done or even removing tasks. For example, the PPA worked solution on the website describes in detail different kinds of changes that can be considered.


![bpwnegotiate](http://i.imgur.com/2ICTh0p.png)

## Use Cases

Once we have defined the BPWs for the new system, we need to define how the work will be done in the new system in the new system in terms of how work will be packaged.

Sometimes these processes will remain as *manual* processes, ie. not automated, usually because of their nature. For example, a customer making a complaint will usually be handled manually. Whenever possible, automate the process.

However, it's not simply a matter of taking each BPW and calling it a *use case*. Use cases are mappings of BPWs but htey are not necessarily one to one - just in the same way that new BPWs were mappings of current BPWs.

To understand how to go about packaging processes, we need to define the concepts of cohesion and coupling.

### Cohesion and Coupling

Cohesion is defined as the measure of the strength of association between activities within (in this case) a business process. So high cohesion is good.

Coupling is the degree of interdependence between two (in this case) business processes. So low coupling is good.

So it would not make sense to have some teaching activities (eg. marking) done by the marketing department of a university.

A systems analyst designs a website, therefore would need to make sure that users can do all the things they need to with the website (high cohesion) and avoid having to leave the website or awkwardly go to a different part of the website in order to complete an activity (high coupling).

## Developing Use Cases

A use case is a single discrete episode of use of a human activity system that can stand alone as a meaningful use of the system.

Typically a use case is performed during one session in one location by one actor (but can sometimes have multiple actors). For example, withdrawing cash from an ATM.

Within each computer-based use case is a well-defined sequence of interactions performed by an actor/s and the system in dialogue.

### Actors

An actor is someone or something that interacts with the human activity system. For example, with a website, users interact directly with the website programs, but in manual systems, customers might interact with a sales order clerk.

![actors](http://i.imgur.com/5VW7bcr.png)

### Use Case Diagram

- A use case diagram shows actors and use cases enclosed by a system boundary
- A use case is shown as an ellipse containing the name of the use case
- An actor is shown by a matchstick figure
- Lines show which actor is involved in which use case

![usecase](http://i.imgur.com/9323rFy.png)

- In the diagram above:
    - Paying an account is an example where a customer interacts with a website (most common)
    - Cancelling a customer can be done by either a customer or the sales clerk
    - Ordering a connection is between a customer and a sales clerk
    - Reporting a fault is an example of a use case which is connected to *another system
    - If only the website interacts with an actor, then it is not necessary to show the website as an actor

#### Pergola Man Use Case

![pergolaman_usecase](http://i.imgur.com/1D3dADD.png)

- Use cases need to be highly cohesive and lowly coupled from other use cases
- That is why in Pergola Man's use case, the email visit request was separated from the answer email response
- These are two independent use cases because they are separated in time and completed by different actors
- Having the request and answer in the same use case would be wrong

### Elaborating Use Cases

Once the use case diagram is drawn, each use case will need refining in terms of adding more detail (similar to stepwise refinement in programming). This is done by writing a description of each use case in English. These descriptions can take several forms, one of which is shown in this module.

- In elaborating use cases, ask the the following questions:
    - What are the main tasks of the actor?
    - Will the actor have to read/write any of the system information?
    - Will the actor have to inform the system about outside changes?
    - Does the actor wish to be informed about unexpected changes?
    - It is likely that alternative courses will be identified which are variants of the original basic course
    	- Typically these involve error conditions
    	- Make sure all possible error scenarios are defined

### Elaborating Pergola Man Use Case

It was decided to make the full payment and part-payment into the same use case. This is because the system should be in a position to detect whether a payment is in full or partial. This is high cohesion.

**(part-)pay invoice**
Receive details from web page. If any field is invalid then generate error message. If details correct then check payment amount against invoice balance. If details correct then check payment amount against invoice balance. Three situations can arise. If payment amount = invoice balance then invoice is paid, so send an invoice paid message to the customer and update records. If payment amount < invoice balance, then send part paid message to customer and reduce invoice balance by payment amount. Lastly, if payment amount > invoice balance, then send error message to the customer.

## ATM Use Case

Draw a use case diagram for withdrawing cash from an ATM. Assume there is a supporting security system that will validate a card number and PIN.

![atm](http://i.imgur.com/fyxuieQ.png)

- Now write the elaborated use case for withdrawing cash
	- Assume cash is only dispense in multiples of $20
	- Assume PIN can be entered up to 3 times
	- A receipt is issued on request

### ATM Elaborated Use Case

The cash withdrawal use case starts when the bank customer inserts the bank card. The system checks whether the card is valid or not. If the card is not valid, the use case terminates and the card is returned. The system asks the customer to enter the PIN. After three failed attempts, the use case is terminated, a message appears on the screen and the card is kept. The system asks if a receipt is required. The system requests information about the account and the amount of money to be withdrawn from the bank account. The system repeats this request until the given amount of money is a multiple of $20 (dangerous). The system checks whether the requested amount of money is available in the ATM. If not, the use case terminates (returning the card). If there is money, the system dispenses the cash and prints a receipt if it was requested. The amount of money registered in the account is changed. The card is ejected, and the use case terminates.

## Review

- Define
	- Coupling
		- Coupling is the degree of interdependence between two (in this case) business processes. Low coupling is good.
	- Cohesion
		- Cohesion is defined as the measure of the strength of association between activities within (in this case) a business process. High cohesion is good.
	- Business process
		- A business process is a discrete meaningful component of a business
	- Business process re-engineering
		- To make processes more efficient or effective.
	- Business process workflow
		- A model of the business process
	- Atomic business process
		- An atomic business process is a discrete process typically done by one person at one time in one place.
- How does a systems analyst improve a business process?
	- Through business process re-engineering. Looking for opportunites to improve efficiency and effectiveness. Effectiveness changes are harder to identify. You have to analyse carefully how the business is being undertaken, look for weaknesses, inefficiencies and so on. Usually the analyst would work with the managers in the business to negotiate these. Sometimes re-engineering involves re-thinking the way a task is done or even removing tasks.
- When do you show a chain of atomic business processes, and when do you separate them?
	- Where sequence exists, it is important to show it as a chain of atomic business processes. Equally, where there is a logical break in the system, it is important to show that as a **separate** chain.
- Define
	- A use case
		- A use case is a single discrete episode of use of a human activity system that can stand alone as a meaningful use of the system.
	- A use case diagram
		- A use case diagram models the actors and associated use cases enclosed by a system boundary.
	- An elaborated use case
		- A detailed description of each use case in English.
- How do you elaborate a use case?
	- To elaborate use cases, ask the the following questions:
    - What are the main tasks of the actor?
    - Will the actor have to read/write any of the system information?
    - Will the actor have to inform the system about outside changes?
    - Does the actor wish to be informed about unexpected changes?
    - It is likely that alternative courses will be identified which are variants of the original basic course
    	- Typically these involve error conditions
    	- Make sure all possible error scenarios are defined
- How do you show which actors are involved in which use cases?
	- Lines show which actor is involved in which use case.


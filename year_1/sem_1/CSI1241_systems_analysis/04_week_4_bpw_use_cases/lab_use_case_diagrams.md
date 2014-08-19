# Evaluating a Use Case Diagram

Use Case diagrams are one of the four core UML diagrams. Use case diagrams express the functions of a system in an abstract, readable way as well as specifying the actors involved in the use cases. What happens when the level of abstraction is too low or too high?

## Tasks

- Examine the following use case diagram and accompanying text
- Identify any errors in the diagram
- Explain reasoning

The system to be developed is a medical device that allows an anaesthetist to set up the flow of anaesthetic gas to a patient. The system must conform to ISO27799, the National Privacy Principles and follow the HL7 protocol. The device must have a battery backup in case of power failure. The device will communicate with the operating theatre via a wireless link. In order to conform to ISO27799, the system will perform a memory test on start-up.

### Use Case Diagram

![lab_badusecasediag](http://i.imgur.com/eJRTJM4.png)

## Errors

The use case states that memory test only occurs on start up, and should be reflected on the use case diagram. At the moment, 'perform memory test' is a separate use case to 'Turn machine on'. Also, the `«uses»` stereotype is incorrect. It should either be `«include»` or `«extend»` with the correct arrow type, or have no label and use the current arrow for generalisation.

My proposed amended use case diagram:

![lab_badusecasediag_corrected](http://i.imgur.com/DZ4IjL6.png)

'Turn on machine' now includes 'Perform memory test' and is a parent of 'Test RAM' and 'Test flash memory'.

# Drawing a Use Case Diagram

Use case diagrams are one of the four core UML diagrams. Use case diagrams express the functions of a system in an abstract, readable way as well as specifying the actors involved in the use cases.

## Task

- Read the following text and determine the requirements
	- List any assumptions
- Draw a draft use case diagram of the system, using `«include»` and `«extend»` stereotypes as appropriate
- Explain assumptions

The system to be developed is a GUI that allows a passenger to purchase a train ticket. Before boarding a train, a passenger must have a valid ticket. At the ticket machine, a potential passenger can select the number of zones s/he wishes to travel. The passenger can insert cash and/or coins to at least the value of the journey. The machine returns the ticket and any change, unless the ticket machine is out of change. A passenger can cancel a transaction any time prior to a ticket being issued. If there is no passenger input after 30 seconds, the ticket machine cancels the transaction. If a ticket machine is out of order, it will not accept input. A potential passenger can purchase a single journey ticket, a return ticket, or a multi-rider ticket (which is an advance purchase of the equivalent of ten tickets for the same number of zones that carries a 10% discount).

### Assumptions

- If system is out of change, the system will display warning that exact price must be paid, otherwise change will not be given to customer
	- I make this assumption because if the ticket machine is out of change and no warning is provided, the customer could potentially pay a $2 ticket with a $50 note

### Proposed Use Case Diagram for Ticket Machine GUI

![lab_usecase_ticketgui](http://i.imgur.com/UcPdDOf.png)
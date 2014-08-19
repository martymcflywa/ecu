# Expectation Mapping

## What is an Expectation?

- Expectations are what users perceive to be the net effect of the implementation system
	- They are told how much time they will save
	- How they can add value to the business through empowerment by the information system
	- These are the expectations
- Requirements are specific statements about what functions or services the system will provide
- Through providing functions, there is a belief that the expectations will emerge
	- Don't confuse the two

## The Pergola Man 

### Brief

The Pergola Man operates in the northern suburbs of Perth, building pergolas and gazebos for private customers. When a customer approaches him, he:

- Visits their house
- Takes measurements
- Then discusses possible pergolas or gazebo options with the customer

As a result of discussion, Pergola Man sends the customer a detailed quotation. The customer may or may not accept the quotation. In due course, the customer is sent an invoice for the work done. Pergola Man allows part-payments over six months in order to encourage more business.

Pergola Man is considering creating a website as a means of attracting new customers. He anticipates the website will allow customers to browse examples of his work, browse company details including likely prices and timescales, email him with a request for a visit and permit part/payment of invoices.

### Pergola Man Expectations

- More business
	- Unless the website results in more business for The Pergola Man, he would not be at all interested in having it
	- It is that belief / expectation that is driving the development of this project
	- More business would come from
		- More visibility, reaching to more customers
		- Ease of communicating with The Pergola Man
		- Convenience of internet for customers
- Easier debt collection through convenience of internet for his customers
	- Convenience of sending invoices to customers
	- Easy to send reminders to customers
	- Convenient for customers to pay over internet, thus more likely to get payments
	- Improved cashflow of payments because payments are easier to make
- Showcase his work
	- Belief that by showing examples of his work, this will attract more customers
		- Especially in the early stages of getting the customer to be impressed with The Pergola Man
	- Belief that by showing costs and timescales will also attract business
- Easy to use website
	- This expectation is an inhibitor
		- If website is not perceived to be easy to use by customers, the website may detract
		- Customers have different levels of IT skills, so it is important that novice users can use the website easily and feel confident
- Secure website
	- Another inhibitor
		- Inhibitors are assumed by sponsor or user, so analyst must make these explicit in discussion and in specification
	- How secure is secure?
		- It has to be secure enough for most customers to feel comfortable paying by credit card
		- Customer information should be kept confidential

## Expectation / Requirements Table

A good way of managing expectations in terms of how they are converted into requirements is to use an expectation /  requirements table in which each expectation is mapped onto at least one but usually several requirements.

| Expectation            | Requirement   |
|------------------------|---------------|
| More Business          | Requirement 1 |
| Easier debt collection | Requirement 2 |
| Showcase for work      | Requirement 3 |
| Easy to use website    | Requirement 4 |
| Secure website         | Requirement 5 |

## Mapping of Expectations

- Some specific requirements that might arise out of 'more business'
	- Use business portals to get better coverage with potential customers
	- Instant email
		- Radio button to say "yes I want the Pergola Man to contact me for a quote"
	- Testimonials from previous customers
	- Cost calculator to give indication of price
- Some specific requirements that might arise out of 'easy to use'
	- Minimal data entry for users
		- Use of lists for user to select rather than typing choices, minimises errors
	- Printer friendly copies of payments made
	- Instant email
		- Radio button to email The Pergola Man of problem on that page

## Notes

- When describing requirements, try to make them as specific as possible
	- For example 'minimal data entry for users' tells the designer and programmer something very specific and important about how the design of the interface is to be implemented
	- In contrast, the expectation 'ease of use' is much more vague
- Sometimes expectations seem to map onto other expectations
	- For example, 'easier debt collection' implied improved cashflow which is true as both a expectation and benefit
	- To ensure improved cashflow, the website's debt collection area must be easy and simple to use and these aspects can be written as requirements

## Expectations and the Specification

- It wouldn't be appropriate to have a section titled 'expectations' in the specification
	- They can be labelled benefits and should appear in that part of the specification
- Expectations often have implications for cost
	- For example, a secure method of payment might involve a certified third party payment system through a bank and so a cost would be shown in the costs section of the specification
- It is important to manage expectations too
	- For example, many sponsors often imagine that benefits will be instant, yet it might take up to one year before the website's reputation gets fully known and therefore the profit and cashflow improved
	- Timescales section of the specification is where this can be articulated
- The same requirements might appear against different expectations
	- For example, instant email appeared twice
	- In such cases, a single requirement is all the more important since it affects more than one expectation

## Review

- What is an expectation?
	- Expectations are what users perceive to be the net effect of the implementation system
- What is the difference between an expectation and a requirement?
	- Requirements are specific statements about what functions or services the system will provide
- What is an expectation / requirements table?
	- A table where each expectation is mapped onto at least one but usually several requirements
- What is expectation mapping?
	- Matching expectations with requirements
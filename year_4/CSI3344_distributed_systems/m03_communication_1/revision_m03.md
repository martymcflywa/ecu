# Workshop

## Q1

>In many layered protocols, each layer has its own header. Surely it would be more efficient to have a single header at the front of each message with all the control in it than all these separate headers. Why is this not done?

It would not be more efficient, as a single header would be mean encapsulation by each layer is lost, and the divide and conquer nature of the layered approach cannot be used. Any features could not be changed independently, as the entire header would have to be modified.

## Q2

>Why are transport-level communication services often inappropriate for building distributed applications?

- Don't offer distribution transparency
- Leaves developers having to implement communication at higher layers to suit their application
- Leads to proprietary solutions
- Does not facilitate interoperability

## Q3

>A reliable multicast service allows a sender to reliably pass messages to a collection of receivers. Does such a service belong to a middleware layer, or should it be part of a lower-level layer?

Reliable multicast can only occur if application requirements are considered, and therefore must be implemented at higher layers that middleware offers.

# Review

## Q1

>True or false: Protocols are often constructed in the form of layers.

True

## Q2

>Why OSI is referred as a reference model?

It's a guide, not an actual implementation.

## Q3

>Name the seven layers of the OSI model in sequence.

1. Application
2. Presentation
3. Session
4. Transport
5. Network
6. Data link
7. Physical

## Q4

>How many layers does the Internet communication model have?

1. Application layer
   - Application
   - Presentation
   - Session
2. Transport layer
3. Network model
4. Hardware layer
   - Data link
   - Physical

## Q5

>What does the Data Link layer do?

Responsible for transmitting packets of data between nodes directly connected by physical links.

## Q6

>What does the Physical layer do?

Responsible for the physical connections, and the transmission of data across the physical media, with analogue signals.

## Q7

>By adopting standards, what we can achieve in networked communications?

Heterogeneity and interoperability.

## Q8

>True or false: The Internet communication model is a de facto standard.

True.
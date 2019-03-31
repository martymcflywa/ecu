# Workshop 05: Processes and naming

Martin Ponce 10371381

## Question 1

In a hierarchical location service with a depth of `k`, `2k + 1` records require updating when a mobile entity changes its location, at worst case. This includes `k + 1` records to be changed during insert at new location, and `k + 1` records to be changed during deletion at the old location.

## Question 2

### Single thread

- If file is cached, request takes 15ms
  - True 2 out of 3 requests
  - 15ms * 2/3 = 10ms
- If file is not cached, request takes 15 + 75 = 90ms
  - True 1 out of 3 requests
  – 90ms * 1/3 = 30ms
- Weighted average 10ms + 30ms == 40ms
- 1000ms / 40ms == 25 requests per second

### Multi thread

- If file is cached, request takes 15ms
  - True 2 out of 3 requests
  - 15ms * 2/3 = 10ms
- If file is not cached, request takes 75ms
  - Processing and file operation is overlapped since they occur in parallel
  - True 1 out of 3 requests
  - 75ms * 1/3 == 25ms
- Weighted average 10ms + 25ms == 35ms
- 1000ms / 35ms == 28 requests per second

## Question 3

Some examples of true identifiers are:

- MAC address
- Software licence key
- Credit card number
- Vehicle number plate
- Tax file number
- Passport number

## Question 4

An identifier is allowed to contain information on the entity it refers to, but it cannot be information that can change or be reassigned to another entity. For example, a phone number should not be used as an identifier, as its owner may change, breaking the third property of a true identifier: An identifier always refers to the same entity.
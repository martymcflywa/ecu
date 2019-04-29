# Workshop 06: Synchronization

Martin Ponce 10371381

## Question 1

- Add a new message to the figure that is concurrent with message m1, that is it happens neither before m1 nor after m1
  - P3 sends at local timestamp 10
  - P2 receives at local timestamp 32
- Add a new message to the figure that is after m1 but before m4
  - P1 sends at local timestamp 18
  - P2 receives at local timestamp 40

# Question 2

- Account starts at $5000
- Process u1: deposit $2000
- Process u2: add interest 1%
- Vector timestamp uses vector to keep track of event timestamps between each process
- So in this case our vector is length 2
- `V(1, 0)` u1 deposits
  - u1 increments timestamp at `V[0]`
- `V(0, 1)` u2 add interest
  - u2 increments timestamp at `V[1]`
  - Deposit and add interest operations are parallel
- `V(1, 2)` u2 acknowledge u1 deposit
  - u2 increments timestamp at `V[1]`
- `V(2, 2)` u1 acknowledge u2 add interest
  - u1 increments timestamp at `V[0]`
- Each message and acknowledge pair is replicated to each distributed database
  - Order doesn't matter since deposit and add interest operations were performed in parallel
    - But it's important to replicate order of actions consistently across each database
  - For example, order of action could be
    1. `V(1, 0)` u1 deposit / `V(1, 2)` u2 acknowledge
    2. `V(0, 1)` u2 add interest / `V(2 ,2)` u1 acknowledge
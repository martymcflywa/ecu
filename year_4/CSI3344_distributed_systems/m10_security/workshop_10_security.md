# Workshop 10: Security

Martin Ponce 10371381

## Question 1

### Question

Would it be safe to join message 3 and 4 in the authentication protocol into `K_A,B(R_B,R_A)`? Explain your answer.

### Answer

No, Bob hasn't proven who he is yet. He is yet to send Alice's challenge encrypted with the shared key. Would be open to reflected attack.

## Question 2

### Question

Why is it not necessary in the following figure for the KDC to know for sure it was talking to alice when it receives a request for a secret key that Alice can share with Bob?

### Answer

Because the KDC will send the response to Alice encrypted with a shared key between Alice and KDC, while sending the response to Bob encrypted with a shared key between Bob and KDC.
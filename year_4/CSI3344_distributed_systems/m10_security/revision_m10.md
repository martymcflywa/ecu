# Workshop

## Q1

>Would it be safe to join message 3 and message 4 in the authentication protocol shown in the following figure into KA,B(RB,RA)? Explain your answer.

![q1](https://snag.gy/vc6X0d.jpg)

Yes. If m3 and m4 were combined like `Ka,b(Ra,Rb)` then this reduction would not be susceptible to reflected attacks.

## Q2

>Why is it not necessary in the following figure for the KDC to know for sure it was talking to Alice when it receives a request for a secret key that Alice can share with Bob?

![q2](https://snag.gy/4rDZYa.jpg)

Because the KDC will issue Alice a shared key Ka,b between Alice and Bob encrypted by a shared key Ka,kdc between Alice and KDC. Likewise, the KDC will issue the same shared key Ka,b to Bob, encrypted by a shared key Kb,kdc between Bob and KDC. Decrypting the Ka,b with Ka,kdc alone would prove that the KDC is talking to Alice.

# Review

## Q1

>What are the major security threats?

- Interception
- Interruption
- Modification
- Fabrication

## Q2

>What is the difference between authentication and authorization?

- Authentication proves who you are
- Authorisation allows you to do things you're allowed to do

## Q3

>Describe the major security mechanisms, respectively.

- Encryption
  - Transform data into something attackers cannot understand
  - Data confidentiality
  - Integrity check
- Authentication
  - Verify claimed identity
  - Typically authenticated with passwords
- Authorisation
  - Check whether actor is authorised to perform requested actions
- Auditing
  - Trace actions taken by actors
  - Which files are accessed by who
  - Analyse security threats

## Q4

>What is the difference between symmetric and asymmetric cryptosystems?

- Symmetric
  - Shared between two parties
  - Same key to encrypt/decrypt
- Asymmetric
  - Public certificate is shared
  - Private key is kept secret
  - Keys for encryption/decryption are different

## Q5

>How many keys are required for symmetric and asymmetric cryptosystems, respectively?

- Symmetric requires
  - N - 1 keys for N hosts
  - N(N - 1) / 2 for entire system

## Q6

>Describe the authentication processes for symmetric and asymmetric cryptosystems, respectively.

- Symmetric
  - Alice sends id to Bob
  - Bob sends challenge to Alice, encrypted with shared key
  - Alice decrypts challenge with shared key
  - Alice sends decrypted challenge, with her challenge to Bob, encrypted by the shared key
  - Bob sends Alice's challenge back to Alice, encrypted with shared key
- Asymmetric
  - Alice and Bob have each others public keys
  - Alice sends Bob a challenge, encrypted with Bob's public key
  - Bob decrypts challenge with his private key, and sends it back with his challenge and a session key, encrypted with Alice's public key
  - Alice decrypts Bob's challenge, and the session key with her private key
  - Alice sends back Bob's challenge, encrypted with the session key

## Q7

>What is the difference between ACL and access capability?

- ACL
  - Each object has own ACL
- Access capability
  - Each subject has list of capabilities

## Q8

>Describe the general model of access control.

1. An object is an entity that can handle incoming requests
2. A subject is an entity that issues a request to an object
3. A reference monitor keeps a record of the allocated rights for a specific subject and decides whether the subject is allowed to work on a specific object based on the record kept
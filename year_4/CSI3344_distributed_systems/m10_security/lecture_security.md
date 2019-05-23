# Security

## Overview

- Security issues
- Secure channels
  - Authentication
- Access controls
  - Authorization

# Introduction

- A distributed system should provide the mechanisms that allow a variety of different security policies to be enforced
- Security in distributed systems is divided into two parts
  - Authentication
    - How to set up secure communication channel
  - Authorization
    - How to manage rights to resources

# Fundamentals of security

## Security policies

- Describe what actions the entities in a system are allowed to take and which ones are prohibited

### Security mechanisms

- How to enforce security policies into systems

### Security system design

- Where and how to implement security mechanisms

### Cryptography

- Techniques to carry out some security mechanisms

## Security threats

### Interception

- An unauthorized party has gained access to a service or data

### Interruption

- Services or data become
  - Unavailable
  - Unusable
  - Destroyed

### Modification

- Unauthorized changing of data or service specifications

### Fabrication

- Generation of additional data or activity

## Security mechanisms

### Encryption

- Active security measure
- Transform data into something an attacker cannot understand
- Ensure data confidentiality
- Provide a measure to check data integrity

### Authentication

- Active security measure
- Verify a claimed identity of an entity
- ie. Password

### Authorization

- Active security measure
- Allocation of rights to an authenticated client
- So client can work on some entities in proper ways
- ie. Access/bank card

### Auditing

- Passive security measure
- Trace records of client activities in the system
- ie. Audit records in cookie folder or database log files

## Security design considerations

### Control target

#### Users

- User authentication and authorization
- Protection against unauthorized users

#### Object access (resource authorization)

- Protection against unauthorized invocations

![object access](https://snag.gy/CtHDYf.jpg)

#### Object operations (activity authorization)

- Protection against invalid operations

![object operations](https://snag.gy/ChQcUZ.jpg)

### Control level

- At which logical level are we going to implement security mechanisms?
- No trust to users => implement own mechanisms

![control level](https://snag.gy/pi91mN.jpg)

# Cryptography

## Notation

| notation | description                                  |
| -------- | -------------------------------------------- |
| `P`      | Plain text, the original form of a message   |
| `C`      | Cipher text, the encrypted form of a message |
| `K`      | Key, used to encrypt/decrypt a message       |
| `Ek`     | Encryption key                               |
| `Dk`     | Decryption key                               |
| `K_A,B`  | Secret key shared by `A` and `B`             |
| `K_A+`   | Public key of `A`                            |
| `K_A-`   | Private key of `A`                           |
| `R_A`    | Random number of `A` (challenge)             |

## Principle

- Encryption
  - Using key `K`
  - `C = E_K(P)`
- Decryption
  - Using key `K`
  - `P = D_K(C)`

![encryption](https://snag.gy/o0twaq.jpg)

### Example: Transferring an image

![transferring an image](https://snag.gy/0wLd1T.jpg)

## Classification of crypto

### Symmetric

- Secret/shared key system
- Same key is used to encrypt and decrypt message

```
P = D_k(E_k(P))
```

- Key is shared by and only known to sender and receiver
- Also known as `secret-key` or `shared-key` system

### Asymmetric

- Public key system
- Keys for encryption and decryption are different
- Together they form a unique pair

```
P = D_kD(E_kE(P))
```

- One key is kept private
- Other key made public
- Also known as `public-key` system

# Authentication

- Secure communication requires
  - Authentication of communicating parties
  - Message integrity
  - Confidentiality
- Can be achieved by setting up secure channel between parties
- Different approaches
  - Authentication for symmetric crypto systems
    - Challenge response protocols
  - Authentication using key distribution center
    - KDC
  - Authentication for asymmetric crypto systems

## Goal

- Set up channel allowing for secure communication between two processes
- Authenticate
  - Both know who is on the other side
- Integrity
  - Both know that messages cannot be tampered with
- Confidentiality
  - Both know messages cannot leak

## Authentication for symmetric crypto systems

- Challenge response protocols
- Uses a shared secret key `K_A,B` to set up a secure communication channel
- Challenge each other for verification

![symmetric](https://snag.gy/oMNKvW.jpg)

1. Alice sends id `A` to Bob
2. Bob sends challenge `R_B` to Alice
3. Alice sends encrypted `K_A,B(R_B)` to Bob
   - Encrypt `R_B` with `K_A,B` symmetric key
4. Alice sends challenge `R_A` to Bob
5. Bob sends `K_A,B(R_A)` to Alice
   - Encrypt `R_A` with `K_A,B` symmetric key

### Problems with symmetric

- Number of keys to keep for a system of `N` hosts
- All hosts
  - `N - 1`
- Whole system
  - `N(N - 1) / 2`

### Authentication based on a shared secret key

![auth shared secret key](https://snag.gy/mv5xKY.jpg)

- Chuck has previously stolen Alice's id
- Chuck attempts reflected attack with two sessions
   1. Chuck starts first session
   2. Chuck sends Alice's id `A` with challenge `R_C`
   3. Bob sends challenge `R_B` with encrypted `K_A,B(R_C)`
   4. Chuck doesn't know shared key, but now knows `R_B` so starts second session to attempt capture
   5. Chuck sends Alice's id `A` with challenge `R_B`
   6. Bob sends challenge `R_B2` with encrypted `K_A,B(R_B)`
   7. Chuck now thinks he has `K_A,B(R_B)` so sends it to first session
   8. If secure, Bob should reject `K_A,B(R_B)` since it is now out of date
     - Should only accept `K_A,B(R_B2)`
 

## Authentication for asymmetric crypto systems

- Use known public keys for both parties to initiate setting up secure communication channel
- Achieved with mutual verification using own private keys

![asymmetric](https://snag.gy/D9IBe1.jpg)

1. Alice sends `K_B+(A, R_A)` to Bob
   - Id `A` and challenge `R_A` encrypted by Bob public key `K_B+`
2. Bob sends `K_A+(R_A, R_B, K_A,B)` to Alice
   - The following elements encrypted by `K_A+`
     - Alice's public key
     - Challenge `R_A`
     - Challenge `R_B`
     - Shared session key `K_A,B`
3. Alice decrypts `K_A,B` session key, sends `K_A,B(R_B)` to Bob

## Authentication using a Key Distribution Center (KDC)

- Modification of shared key authentication
- Centralized KDC is used to manage only `N` shared secret keys to set up a secure communication channel for both parties
- All parties must trust KDC

![kdc](https://snag.gy/bCYXMI.jpg)

1. Alice sends id `A,B` to KDC
   - `A` is source id (Alice)
   - `B` is target id (Bob)
2. KDC sends to source and target
   1. `K_A,KDC(K_A,B)` to Alice
     - `K_A,KDC` is shared key between Alice and KDC
   2. `K_B,KDC(K_A,B)` to Bob
     - `K_B,KDC` is shared key between Bob and KDC

## Message integrity check by digital signature

- Package containing two copies of the message
  - First copy is encrypted using sender's private key
  - Second copy is encrypted using receiver's public key
- Check consistency of message

![digital signature](https://snag.gy/AXb8RT.jpg)

# Authorization

## Access control and authorization

- Access control
  - Verifying access rights
- Authorization
  - Granting access rights

## Access control

1. An object is an entity that can handle incoming requests
2. A subject is an entity that issues a request to an object
3. A reference monitor keeps a record of the allocated rights for a specific subject and decides whether the subject is allowed to work on a specific object based on the record kept

![access control](https://snag.gy/iNTqPr.jpg)

### Access control matrix

- Access rights of subjects with respect to objects are kept in a table
- Each subject is represented by a row
- Each object is represented by a column
- The table resides in the reference monitor to control subject access

| subject | publisher | printer-staff | printer-p/g | printer-u/g |
| ------- | --------- | ------------- | ----------- | ----------- |
| tony    | y         | y             | -           | -           |
| william | -         | y             | -           | -           |
| tomas   | -         | y             | y           | -           |
| jitian  | -         | -             | y           | -           |
| chris   | -         | -             | -           | y           |

### Access control list

- Each object keeps a list of subjects that have right to access this object

![acl](https://snag.gy/JRPhHS.jpg)

### Access capability

- Each subject keeps a list of objects that the subject has right to access

![access capability](https://snag.gy/uo5ANL.jpg)

### Firewall

- Special kind of reference monitor
- Controls external access to any part of a distributed system

![firewall](https://snag.gy/eAgJNT.jpg)


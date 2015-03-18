# Cryptography 1

## Terminology

- Encryption
	- To establish confidential communication over an insecure channel
		- Such as the internet
- Cipher
	- An algorithm for encryption or decrypting data
- Plaintext
	- The original, readable message
- Cipher text
	- The output of the encrypted plaintext message
- Cryptography
	- The creation and development of encryption
- Cryptanalysis
	- The study of breaking encryption
- Cryptology
	- Combination of cryptography and cryptanalysis

## Role of cryptography

- One of the most important and fundamental computer security tools
- Used to hide the meaning of information or communication
	- **Confidentiality**
	- When sending highly sensitive documents
	- Undertaking banking online
	- When storing confidential organisational data

## Codes and ciphers

- Codes
	- Replacing a phrase or message with a word or symbol
	- "Be right back" could be replaced with "brb"
	- "Attack at midnight" could be replaced with "aam"
- Ciphers
	- Replacing individual characters, digits or bits
	- "Be right back" could be replaced with "cf sjhiu cbdl"

### Caesar cipher

- Replace each letter with the one "three over" in the alphabet

![caesar](http://snag.gy/NaaKl.jpg)

### Cipher categories

![cipher categories](http://snag.gy/Tgdky.jpg)

## Encryption types

### Scenario

- Alice wants to send a message (plaintext) to Bob
- The Internet is insecure
	- Eavesdropping
- If Alice and Bob have previously agreed on a secret key and an encryption algorithm, Alice can use this key to encrypt the plaintext message and send the cipher text to Bob

### Symmetric encryption

![symmetric](http://snag.gy/836m5.jpg)

- Same key is used for encryption and decryption
- Simple mathematics operations
- Well suited to for basic computer systems
- Think of the key as a password that must be entered/used every time data is encrypted or decrypted

#### Symmetric key distribution problem

![symmetric distribution problem](http://snag.gy/jbMtA.jpg)

#### Symmetric key sharing

- How does the sender and recipient share the key?
	- If it is emailed, it could be intercepted
	- Meeting in persion is not always practical
	- A courier can not always be trusted
	- What if you no longer want an invididual to be able to decrypt a message?
	- What if a key is leaked?
- The problems inherent with symmetric key encryption can be solved through asymmetric based encryption

### Asymmetric encryption

![asymmetric](http://snag.gy/2j3OW.jpg)

- One key is used for encryption and another for decryption
- Private key
	- Recipient key
	- Must be kept secret
	- Security of system relies on secrecy of this key
- Public key
	- Can be given to anyone
	- Could be attached to emails
	- Published on a web page

#### Use of asymmetric keys

- Recipient can give public key to anyone
- Senders can then use recipient's public key to encrypt messages
- Recipient can use private key to decrypt message
	- Recipient has kept the key in their possession at all times
	- No secret information needs to be transmitted in an unencrypted form

### Block ciphers

- Plaintext/ciphertext have a fixed length b
	- ie. 128 bits
- A plaintext of length n is partitioned into a sequence of m blocks

>P[0], ..., P[m-1],  
where n &le; bm < n + b

- Each message is divided into a sequence of blocks and encrypted or decrypted in terms of its blocks

![block cipher](http://snag.gy/17rnJ.jpg)

#### Block cipher mode of operation examples

![block cipher examples](http://snag.gy/kAQqp.jpg)

### Stream cipher

- Symmetric cryptosystem where cipher text C is obtained as the exclusive OR of the plaintext message M and a pseudo-random binary vector S generator from the secret key

![stream cipher](http://snag.gy/V49gt.jpg)

### Symmetric block ciphers

#### DES/3DES

- Data Encryption Standard (DES)
	- Developed by IBM in 1977
	- 64 bit blocks, 56 bit keys (+8 bits for parity)
	- Small key space make exhaustive attack possible
- Triple DES: 3DES
	- Effective key length of 168 bits
	- Tried to resurrect DES, but computationally inefficient
	- Cipher text = E<sub>KC</sub>(D<sub>KB</sub>(E<sub>KA</sub>(P)))

#### AES

- Advanced Encryption Standard (AES)
	- Selected by NIST in 2001 through open international competition and public discussion
	- 128-bit blocks
	- 128, 192 and 256 bit key lengths
	- Exhaustive key search attack is not currently possible

### Symmetric stream cipher: RC4

- Rivest Cipher 4 designed by Ron Rivest from RSA Security in 1987
- Used in SSL and WEP
- Simple and computationally efficient
- Key sizes range form 40 - 2048 bits

### Asymmetric Cipher RSA

- Designed by Rivest, Shamier and Adelman (RSA)
- It is easy to multiply 2 numbers and calculate a product, but difficult to take a product and determine all of its factors
- Usually deals with very large prime numbers
- Common key lengths are 512, 1024, 2048 or even 4096 bits

### Steganography

- Involves hiding data within data
- A picture could be hidden in another picture
- Messages do not attract attention

![steganography](http://snag.gy/DIgdk.jpg)

- The following bit sequence represents 1 pixel

![pixel bit sequence](http://snag.gy/54yFk.jpg)

- Assuming we want to embed the message "Aha!" into the background of a picture

![aha!](http://snag.gy/mTxau.jpg)

- 11 pixels in a picture had their LSB altered
- You can embed data ~10% of the file size

![embed data](http://snag.gy/rNMmQ.jpg)

## Attacking crypto

### Attack categories

#### Cipher-text only attack (COA)

- Cryptanalysis has access to the cipher text all of which were encrypted using the same key
- Goal is to determine the plaintext
	- ie. Determine plaintext from "cf sjhiu cbdl"

![cipher-only](http://snag.gy/PWMe4.jpg)

#### Known plaintext attack

- The cryptanalyst has access to one or more original plaintext messages and the resultant cipher text
- Goal is to determine the key

![known plaintext](http://snag.gy/4dZ0N.jpg)

#### Chosen plaintext attack

- Cryptanalyst has access to the crypto system used
- Introduces plaintext and monitor cipher text
- Goal is to determine key and cipher

![chosen plaintext](http://snag.gy/ciukV.jpg)

#### Chosen cipher-text attack

- Cryptanalyst has access to the crypto system used
- Introduces cipher-text and monitors plaintext
- Goal is to determine key and cipher

![chosen cipher-text](http://snag.gy/MQARQ.jpg)

### Brute forcing symmetric ciphers

- Brute force attacks are also known as key space attack
- The key space is the set of all possible keys for a given cipher
- The key space possibilities are determined by the key length

![brute forcing](http://snag.gy/eSU6H.jpg)

#### Basic probability

- In terms of cryptography, we often talk about some very large numbers
- But how big are some of these numbers?
- Take DES for example
	- DES has 56 effective bits in its key length
	- 2<sup>56</sup> = ~72 quadrillion keys
- If you reached into this key space and selected a random key, what is the probability of obtaining the correct decryption key

##### Sense of scale in numbers

![probability table](http://snag.gy/HIoZw.jpg)

## Brute force attacks

- You systematically test every key until the correct key is found
- A brute force attack has 100% chance of being successful
	- If given enough time
- Or you can now pre-compute them and store them in binary form known commonly as **rainbow** tables

### DES brute force example

- If we could do 1 test every millisecond (1000/second)
	- 72,057,594,037,927,936 keys
	- 72,057,594,037,928 seconds
	- 1,200,959,900,632 minutes
	- 20,015,998,343 hours
	- 833,999,930 days
	- 2,284,931 years to go through the entire key space

#### DES challenge 1

- Initiated in late 1997
- Four months later the message was deciphered
- Involved thousands of Internet connected PCs
- Less than 25% of the key space was searched when the correct key was found
- Key was found by a Pentium 90 PC

#### DES challenge 2

- Won by a device built by the Electronic Frontiers Foundation (EFF)
- Custom built microprocessor system
- Device was built by July 17, 1998
- Cost $250,000 USD to build
- Cracked DES message in 3 days
- Won $10,000 USD prize

### Cracking AES

- According to NIST
	- If you had a machine that could crack DES in 1 second, it would take that machine 149 trillion years to crack 128 bit AES
- That assumes computing power remains constant for the next 149 trillion years

### Brute forcing asymmetric algorithms

- Brute forcing asymmetric ciphers such as RSA usually relies on being able to factor very large prime numbers
- It is easy to multiply two numbers to get a product, but considerably more difficult to start with the product and determine all of its factors
- However
	- Some clever mathematician could come up with a revolutionary new way of factoring numbers
	- There is always the possibility that a breakthrough in mathematics could render current forms of encryption vulnerable

### Traffic analysis

- However, even if the content of the messages is not known, patterns of communication might convey information
- The number and timing of transmitted messages might convey certain information even if the content of the messages is not known

## Encryption in practice

- What are the practicalities?

### Poor uses of encryption

- The way in which a crypto system is used could be a weakness
	- You encrypt your confidential documents but leave plain text copies on your hard disk
	- You have implemented the same password/key for all your accounts, encryption programs etc.

### Does trust exist in encryption

- Can we trust our encryption software
- Do Governments or other agencies have a vested interest in stopping us from using encryption
	- Backdoors
	- Master decryption keys
- Which is more trustworthy
	- Commercial or open source software
	- Freeware/shareware

### Encryption related social issues

- It can and is used to cover up any number of criminal or malfeasant acts
	- Illegal activity
		- Drugs/arms deals
		- Terrorist activities
	- Trade in illegal digital material such as child pornography
	- Theft of intellectual property
	- Extortion
		- Encryption of a victim's device

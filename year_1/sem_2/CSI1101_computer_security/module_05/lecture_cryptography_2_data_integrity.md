# Data integrity

- The validity and trustworthiness of data
- Data may lose its integrity due to
	- Human errors
	- Errors during data transmission over a network
	- Software bugs
	- Malware
	- Hardware malfunctions
	- Natural disasters

## Parity and checksum

### Ensuring integrity via parity

- Parity bits
	- The letter A will be sent over a serial connection
	- ASCII A in binary is 0100 0001
	- We have decided to use **even** parity which means that the total number of 1s must be **even**
	- So the binary sequence will be 0100 0001 0
	- The receiver knows we are using even parity
	- If number of 1s is **even** then no errors occurred
	- But what if 2 errors occurred during transmission?
		- Original binary sequence was 0100 0001 0
			- Receiver got 0100 0010 0
			- Since parity was even, receiver assumed that no errors had occurred
		- Receiver got binary sequence 0100 0010
			- 0100 0010 in ASCII is the letter B
	- What if attack was deliberate?

### Ensuring integrity via checksum

#### Checksum at sender end

- A file will be sent over the Internet
	- 1151 bytes
- Using a checksum of 1 byte gives 256 values
- 1151 / 256 = 4.496
	- Rounded down to 4 (floor)
- 4 * 256 = 1024
- 1151 - 1024 = 127
- The checksum of 127 is added to the file

#### Checksum at receiver end

- The same file is received from sender above
	- 1056 bytes
- 1056 / 256 = 4.125
	- Rounded down to 4 (floor)
- 4 * 246 = 1024
- 1056 - 1024 = 32
- The checksum of 32 does not match the original 127

### Flaws

- An attacker could specifically modify the file to retain the original size
	- In which case, checksum would still work
- Parity bits and checksum are both susceptible to malicious and accidental faults and errors
- To ensure data integrity we need a method which is fault tolerant

## Cryptographic hash functions

- A strong way of assuring the integrity of a digital object
- Digital object could be
	- A document
	- An executable program
	- Any other collection of bits
	- A paragraph of text
- A has function takes the object as an input and outputs a **hash** or **digest**
- A complex mathematical algorithm (formula)
	- MD4/MD5
	- SHA-1/SHA-256/SHA-512
	- RIPEMD160
	- PANAMA
	- TIGER
	- Many others

### Message-Digest Algorithm 5 (MD5)

- Developed by Ron Rivest in 1991
- Outputs 128 bit hash values
- Widely used in legacy applications
- Considered academically broken
- Faster than SHA-1

### Secure Hash Algorithm 1 (SHA-1)

- Developed by NSA and approved by NIST
- Outputs 160 bit hash values
- Contains less implementation issues than MD5
	- As it should
- Is computationally more intensive than MD5
- Superseeded by the SHA-2 family
	- SHA-256
	- SHA-384
	- SHA-512

### Hash function example

![hash functione example](http://snag.gy/0Cvil.jpg)

### Challenge questions

- MD5: How many hexadecimal digits should the function produce?
	- MD5 = 128 bits
	- Hex char = 4 bits
	- 128 / 4 = 32 char
- SHA-1: How many hexadecimal digits should the function produce?
	- SHA-1 = 160 bits
	- Hex char = 4 bits
	- 160 / 4 = 40 bits
- How many unique outputs should MD5 theoretically produce?
	- Number of possible digits = 16
	- Length of string = 32
	- 16^32 = 3.4028237e+38
- Are there any issues with the number of unique values that MD5 can produce?
	- Collision probability is high
		- Where hash of two unique files are completely identical

### Hash function characteristics

- A cryptographic hash function should have the following properties
	- Input of any length
	- Output (hash or digest) of a fixed length
	- Easy to compute in one direction
	- Difficult to compute in the reverse direction
		- Rainbow tables
	- The collision rate should be acceptably low

#### Function formula

- D = H(m)
	- D = Resulting digest
	- H = Hash function
	- m = message/object
- The digest is a hexadecimal number
- This digest should be unique to that object or message

### Hash algorithm

- A hash algorithm is used to obtain a digest of a digital object
- The same algorithm could be used to generate another digest
- If the outputs are the same then the two objects are identical down to the last bit
	- Forensically verified
- If so much as one bit is different between the two objects, the outputs will be completely different

![simplified hash algorithm](http://snag.gy/L54JU.jpg)

- Digest can be recomputed later to see if file/object has changed

### Hash function collisions

- When two entirely different digital objects produce the same hash output
- Hash function collisions are a negative trait
- Hash algorithms must have a very low collision rate
	- The probability that two objects happen to result in the same digest value is so small that it is not even worth considering
	- The result of hash functions are routinely used in a court of law to prove that two binary objects are identical

![collision](http://snag.gy/qGXHf.jpg)

- A collision has occurred as two different objects have the same resulting hash note
- For MD5, this is a 1 in 80 million occurrence
	- If at all

### Real use of hash functions

- Hash functions are important in the field of cyber security and digital forensics
- Common uses include
	- Digital signatures
	- Intrusion detection systems
	- Secure communications protocols
	- Storage of passwords
	- Verifying that evidence has not been tampered with

## Hash Message Authentication Codes (HMAC)

- MACs are Message Authentication Codes
- HMACs combine hash functions and secret keys to not only provide integrity but also authenticity
- Instead of just taking the object as an input to the hash function, a HMAC or keyed hash function also takes a symmetric key that is typically not shared

![HMAC](http://snag.gy/NKJbq.jpg)

### HMAC in use

- Sender could create a HMAC using the object, algorithm and a symmetric key
- Recipient could generate the HMAC using the same object, algorithm and symmetric key
- If the HMACs match, the recipient knows that
	- The object hasn't been tampered with
	- The sender knew the same symmetric key as the recipient knows
- Of course, just as when using symmetric encryption, key management can be an issue

## Signatures

### What is a signature?

- A physical, visible mark on a document that only the authentic person can make
- A conventional signature is included in the document
	- It is part of the document being signed
- When a document is digitally signed, the signature is sent as a separate document

### How signatures work

- With a conventional signature, when a recipient receives a document, they compare the signature on the document with the signature on file or another object
	- ie. The back of a credit card

### How digital signatures work

- With a digital signature, the recipient receives the message AND the signature
- The recipient needs to apply a verification technique to the combination of the message and the signature to verify AUTHENTICITY

### Why use digital signatures

- We know who created a digital artifact and that it hasn't been altered
	- ie. A system patch
- We want to know that we have connected to our real bank website
- We want others to know that the message posted on a forum originated from us
- Basically to assure the integrity and authenticity of our online interactions

### Digital signature process

- Sender uses signing algorithm to sign message
- Message and signature are sent to the receiver
- The receiver receives the message and the signature and applies the verifying algorithm to the combination
- If the result is **true**, the message is accepted
	- Otherwise it is rejected

#### Example

- Alice can use her private key to produce a digital signature
- Bob can verify Alice's digital signature by using her public key

![alice & bob](http://snag.gy/5IY3Y.jpg)

### Mathematical example of RSA digital signature

![rsa digital signature example](http://snag.gy/EjkNn.jpg)

### Digital signature attack

1. What if the message or file is intercepted
2. The attacker then alters/modifies the original message or file
	- Embedding malware
3. The attacker could forward the modified message or file to the intended recipient
4. The attacker may claim their private/public key pair was compromised and that new keys had to be generated

#### Mitigating digital signature attacks

- The aforementioned attack could be mitigated if there was an easy way to register public keys to a central system
- What is needed is for a reputable entity to vouch for an individual's public key

## Digital certificates

- Digital certificates provide a means of proving your identity in electronic transactions by binding a public-private key pair to a person or organisation
- With a digital certificate you can assure friends, business associates and online services that the electronic information they receive from you is authentic
- An attacker impersonating Alice may claim the private/public key pair was compromised and that new keys had to be generated
- We need an independent third party to verify the person's identity and issue a digital certificate

### Digital certificate characteristics

- Name of certifying authority
	- ie. Thawte
- Date of issuance
	- ie. 15-01-2012
- Expiration date
	- ie. 15-01-2013
- Public key used
	- ie. RSA 1024 bit key
- Cryptographic hash function
	- ie. SHA-256
- Digital signature of owner

### Certifying authorities

- Digital certificates are managed by Certifying Authorities
	- CAs
- CAs could be global
	- [VeriSign](http://www.verisign.com/)
	- [Thawte](https://www.thawte.com/)
- Or could be local
	- Within organisation
	- Of course they wouldn't really carry any weight outside your organisation
	

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

## Cryptography hash functions

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
	- Collision is possible
		- Where hash of two unique files are either
			- Completely identical
			- Partially identical

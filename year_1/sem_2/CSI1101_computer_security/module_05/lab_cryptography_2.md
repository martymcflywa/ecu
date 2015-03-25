# Cryptography 2

## Part 1: Cryptotool

### A: Caesar cipher

Decrypting Caesar with cipher text only.

1. How is the cipher text-only attack being carried out?
	- By comparing cipher with example of unencrypted text
		- Finding distribution of letters
		- Using letter with greatest distribution as key
2. What is the advantages of using such an attack?
	- Only have to know cipher text to carry out attack
3. What is the disadvantage of using such an attack?
	- May take a long time
		- Only took a short time since there are only 26 letters in alphabet
			- Small keyspace

### B: Hex cipher brute force

#### 1:

Brute forcing RC2 128-bit key.

1. When you click start, how long does the program predict that the brute force analysis will take?
	- 8.2+e025 years
2. Why is such a brute force attack simply not feasable?
	- Very large keyspace
3. Think about what you could do to improve or reduce the amount of time required
	- Know all or part of key
	- Know actual length of key

#### 2:

Brute forcing RC4 128-bit key.

1. When you click start, how long does the program predict that the brute force analysis will take
	- 4.2+e025 years
2. Has the amount of time required increased or decreased
	- Decreased slightly
3. Using Google or another source of information, try and find some information regarding what makes RC4 different from RC2
	- RC2 [Charbathia2014]
		- Block encryption algorithm developed 1987
		- Proposed to replace DES
		- Variable key size from 1 to 128 bytes
		- Designed to be easily implemented on 16-bit microprocessor
		- Algorithm runs twice as fast if key encryption performed beforehand
		- Algorithm involves three further sub-algorithms
			- Key expansion
			- Encryption
			- Decryption
	- RC4 [Charbathia2014]
		- Stream cipher, symmetric key encryption algorithm
		- Same algorithm is used for both encryption and decryption
		- Data stream is XORed with generated key
		- Key stream does not depend on plaintext
		- Variable key size 1 to 256 bits is used to initialize a 256 bit state table
		- Used in
			- File encryption products
			- Secure communications
				- SSL
				- WEP protocol
		- Considered secure until BEAST attack

#### 3:

Brute forcing RC4 128-bit key with part of key known.

1. How much time is required to brute force attack the cipher text this time
	- 27 years
2. Why has the time value changed
	- First 24 bits are known
	- Only have to brute force 48 bits
3. Have a think about what else we could do to shorten the amount of time required
	- Know more of the key

## Part 2: Asymmetric encryption

### 1:

Creating digital signatures.

1. Why is this user data required when utilising asymmetric encryption
	- To generate certificate
	- For authentication
2. Why does the program require that you move your mouse around when generating your keys?
	- Uses mouse movements to generate pseudo-random number
3. How does this process differ from using symmetric encryption
	- Symmetric uses algorithm and text to generate cipher
	- Asymmetric uses algorithm and pseudo-random number to generate cipher

### 2:

Encrypting digital documents.

1. Why does the encryption component ask us to choose our recipient (think back to symmetric vs. asymmetric encryption)
	- The encryption is asymmetric
	- Uses sender key to encrypt
	- Uses recipient public key to decrypt
2. Which key (public or private) is being used to encrypt the document and why?
	- Private key
3. Compare the output for a different recipient, will the cipher text be the same or different?
	- Different
4. Imagine you accidentally forgot the pin, or have deleted your key pairs. As a result you decide to generate a new private and public key pair. If you use the same user data as the first time, will the cipher text be the same or different?
	- Different
	- A different random number will be used for the new pair

### 3:

Signing documents.

1. What aim of security does signing a document ensure?
	- Data integrity
2. What type of information is now contained in the document?
	- The signature with user data
3. How is digitally signing a document beneficial?
	- Confirms who created/owns object
		- Hasn't been altered
	- Assures data integrity and authenticity
		- Can be verified

## Part 3: Steganography

1. What is the maximum allowable size of files compared to the image?
	- Embedded file size is limited to number of insignificant bits in carrier file [Weiss2009]
2. Are there notable differences between the two statue images from Blackboard?
	- No
3. If you ran both files through a hashing program, would the resultant digests be the same or different?

**Powershell:**

``` bash
$ Get-FileHash StatueOriginal.jpg
SHA256 E76C1DF2EFEE981E174D65A6D59592FCBC847CE4AA469427A1142E2485DBDD5F

$ Get-FileHash StatueSteg.jpg
SHA256 C20506DE035C7DF592C4B674C5375D3CA1D779638FD7FEC7AFDAB7CEC5CAEF50
```

## Part 4: Distributed.net

1. How many keys would this project have to check, given a worst-case scenario?
	- 4,722,366,482,869,645,213,696
2. What is the key size of RC5-72?
	- 72 bits
3. How many keys would this project have to check, given a best-case scenario?
	- Current total + today's total + 1
4. How many keys have they currently checked?
	- 167,575,198,494,932,074,496
5. What percentage of the keyspace is this?
	- 3.549%
6. How long has the project been going?
	- 3/12/2002
7. How long do they estimate that it will take to have a 100% probability of finding the key?
	- In 76035 days at 693,334,234,211 Keys/sec

## Part 5: Hashcalc

lab_file1.txt "This is file 1":  
MD5: e1d1faab91eb551b9a566eead319a012

lab_file2.txt "This is file 2":  
MD5: d20b37e3109090362c0299c1e6aab6f7

1. Has the MD5 value changed?
	- Yes
2. Why did this particular process occur?
	- Because the contents of the files are different

lab_file1.txt "This is file 2":  
MD5: d20b37e3109090362c0299c1e6aab6f7

lab_file2.txt "This is file 1":  
MD5: e1d1faab91eb551b9a566eead319a012

1. Does the MD5 value remain the same or different?
	- They match to the corresponding string contained in the text file
2. Which file is the MD5 value corresponding to?
	- They have switched after renaming

lab_file1.txt "This is file 1":  
MD5: e1d1faab91eb551b9a566eead319a012

lab_file2.txt "This is file 1":  
MD5: e1d1faab91eb551b9a566eead319a012

1. Has the MD5 value changed?
	- Yes, back to its original MD5 hash
2. Does it correspond to a particular MD5 value obtained previously?
	- Yes
3. What changes need to be made to the file for it to alter the resultant MD5 value
	- The data inside the file need to be changed
		- Not the filename

## When to use hash functions

- When submitting assignments at uni
- Check downloads
- Check application patches/updates/upgrades
- Passwords
	- So website doesn't need to store user passwords as plaintext
	- Can store hash instead, use it to compare what user has typed in to confirm password is correct

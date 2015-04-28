# Cryptography and security

## History of cryptography and security

- As long as communication existed
	- Need for secret communication existed
- Cryptography
	- Changing something easy (plaintext) to read into something difficult to read
- Encryption process
	- Taking original information
	- Coding it into a different, unreadable form
- Decryption process
	- Taking encrypted information
	- Putting it back into original form

## Symmetric vs. asymmetric encryption

- Key
	- Special word, phrase or binary number
	- Manipulates data during encryption or decryption
- Symmetric encryption
	- Single key encrypts and decrypts data
		- Shares single key
	- Encrypted data vulnerable if shared key falls into wrong hands
- Assymetric encryption
	- Two keys used
		- One encrypts data
		- Another decrypts it
	- Public key distributed to anyone needing it
	- No damage if public key falls into wrong hands
		- Public key used to encrypt data

![symmetric vs. asymmetric algorithms](http://snag.gy/KmwKr.jpg)

- Symmetric encryption algorithms
	- Use one key for both encryption and decryption
		- Special process used between parties to exchange key
		- Key length determines data level protecetion
- Asymmetric encryption algorithms
	- Use two keys to perform encryption and decryption
		- Mathematical makeup of keys allows each to decrypt data encrypted with another key
	- Important capabalities not available with symmetric keys
		- Digital certificates and digital signatures

![symmetric encryption algorithm key length](http://snag.gy/qOjbz.jpg)

## Encryption strength

- Symmetric encryption algorithm
	- Strength based on
		- Key size
		- Type of algorithm performing encryption
- Asymmetric encryption algorithm
	- Strength based on
		- Size of prime numbers used to create key pair
		- Mathematical formula
- Strength of encryption method
	- Influenced by encryption algorithm
- Complex encryption methods
	- Are more secure
	- Take considerable resources to complete

### Caesar cipher

- Alphabet letters shifted one or more positions to obtain encryption alphabet
- Worst-case decryption scenario requires 25 different shifts
	- 25<sub>10</sub> = 11001<sub>2</sub>
	- Encryption key: 5 bits in length

![caesar cipher](http://snag.gy/JQwuD.jpg)

### Substitution method

- Encrypted alphabet formed by writing secret key letters first
	- Followed by remaining alphabet letters not used in secret key
- Share secret key
- Receiver constructs encryption alphabet and decodes secret message
- Gain insight into the substitution
	- Look for double-letter pairs or frequency analysis

![substitution method](http://snag.gy/Iutkj.jpg)

- Strength of substitution method
	- Number of possible encryption alphabets
		- 26! = 403291461126605635584000000
	- Key size
		- Binary bits representing 26!
		- Number of bits required to represent the encryption key, given the number of possible alphabets
			- 89 binary bits needed to represent number of possible alphabets

![substitution method key size formula](http://snag.gy/G0hcY.jpg)

### O(n) algorithm

``` java
passes = 0;

while(passes < N) {

	// ... execute statements
	passes++;
}
```

### O(n<sup>2</sup>) algorithm

``` java
passes = 0;

while(passes < n) {

	inner = 0;

	while(inner < n) {

		// ... execute some statements
		inner++;
	}

	passes++;
}
```

### Execution time

- Increases significantly for large values of n

![O(n) vs. O(n^2) algorithms](http://snag.gy/70sp5.jpg)

- Nature of algorithm design
	- Requires consideration of other classifications
	- Algorithms between O(n) and O(n<sup>2</sup>) have reasonable performance

![performance of different algorithm types](http://snag.gy/UllKU.jpg)

## Encryption algorithmms

- Symmetric or asymmetric
- Block cipher algorithm
	- Encrypts or decrypts blocks of data
		- 64-bit or 128-bit chunks of information at a time
- Stream ciphers
	- Encrypt any number of bits
- Examining DES
	- Illustrates block cipher algorithm

## Encryption vs. Hashing

- Encryption
	- Data block changed into a different data block
- Hash
	- Computed representation of data
- Hashing a data block
	- Data not changed
	- Hash value created
		- Based on all data block information
	- Used to check for data errors
- One-way hash
	- Cannot unhash data and turn back into original form

### Password hashing

- Provides measure of privacy
- Safer way to store pasword compared to encryption
	- Cannot be unhashed to learn original password
- User forgets logon password
	- IT personnel cannot tell user their password
	- IT personnel must inform user to change password to something new

### Digitally signing an email

- Verifies identity of person sending email
- Verifies email contents not changed during transit
- Accomplised by encryption and hashing combination
- Hash value called a digest
- Not the same as encrypting an email

### Hash algorithms

- Techniques to detect changes to information
- Methods to verify data integrity
	- Ensuring original data not changed
- Performed independently on both sides
- Two popular hashing algorithms
	- Secure Hash Algorithm (SHA)
	- Message Digest (MD)
- Hashing process based on
	- Block of data taken in uniform chunks of data bits
	- Stream of bits taken one at a time

## Steganography

- Technique for hiding one form of information inside another
- Advantages / disadvantages
	- Not obvious that anything is hidden
	- Do not know where or how something is hidden
	- File size of host file determines data amount that can be hidden
- Stenography applications freely available
	- Can hide practically any file type inside any other file type
- Password or pass phrase required to extract hidden information
- Different from watermarking
- Colours look essentially the same to the naked eye
- Comparing RGB channels of the images shows many differences

![steganography example](http://snag.gy/J3ygI.jpg)

### Hiding information inside WAV file

- Simple technique
	- Every 16 samples, sample set least significant bit set to 0 or 1
	- According to data being inserted into the file
- 128-byte block: Adjust LSB of 8 samples
	- Spreading out changes reduces chance that audio is affected
	- Changing sample LSB only means the smallest possible effect made to the sample
- WAV file size determines how much data can be hidden inside it
	- One data byte hidden inside every 128-byte block

![how lsb is affected when hiding data](http://snag.gy/tEYg6.jpg)

### Hiding information inside JPG file

- Pixel-to-DCT relationship important to understand
- DCT coefficients changed when information is hidden inside JPG image
	- Adjusts the LSB of certain coefficients
- Example: Pixel result when changing the DC coefficient located at DCT(0,0)
	- Increases DC coefficient
		- All pixel values increase
	- Decrease DC coefficient
		- All pixel values decrease
	- Very little change to DC coefficient
		- Pixel intensity change not noticable
			- Information hidden without detection by the naked eye

## Troubleshooting techniques

- Work with complex encryption systems
	- Requires
		- Patience
		- Good understanding of system requirements
- An email investigation
	- Verify email encryption configurations
- Testing a VPN connection
	- Try different encryption and hashing combinations
		- Use small and large file sizes
- Sometimes you just have to guess
	- Use a best educated guess to solve problem

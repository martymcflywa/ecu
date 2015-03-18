# Cryptography 1 workshop

## Truecrypt

1. What is an encrypted file container?
	- Two types
		- File-hosted
			- Container
			- A normal file
			- Can reside on any type of storage device
			- File contains completely independent encrypted virtual disk device
		- Partition/device-hosted
			- Non-system
			- Complete hard disk or partition encrypted
				- Entire hard disk
				- USB drive
				- etc.
2. How does the encrypted file container function?
	- Creates an encrypted virtual disk device
	- Authentication required when mounting device
3. How does the encrypted file container differ from encrypting an entire system partition
	- File container is a virtual disk device
		- Can selectively encrypt files
		- Authentication required when mounting device
	- Entire system partition is encrypted
		- All files are encrypted
		- Pre-boot authentication
4. Is it symmetric or asymmetric encryption?
	- Symmetric
		- Same key used to encrypt and decrypt
	- Hash algorithm
		- Produces a unique value (string)
		- If same algorithm is used on modified data, generated checksum is different and confirms loss of data integrity
	- [www.opensourceforu.com](http://www.opensourceforu.com/2012/02/truecrypt-learn-the-art-of-encryption/)
5. What happens to the drive when it is dismounted
	- Container is rehashed
6. After you copied files into the encrypted container, did the size of the container change?
	- Yes
	1. What was the reason behind this?
		- The hash has changed
7. If you delete the encrypted file container what will happen to the files inside?
	- They will also be deleted

## Questions

### 1:

>Eve has an antenna that can pick up Alice's encrypted cell phone conversations. What type of attack is Eve employing?

Cipher-text only attack.

### 2:

>Eve has given a bunch of messages to Alice for her to sign using the RSA signature scheme, which Alice does without looking at the messages and without using a one-way hash function.

>These messages are cipher text that Eve constructed to help her figure out Alice's RSA private key. What kind of attack is Eve using?

Chosen cipher-text attack.

### 3:

>Eve has bet Bob that she can figure out the AES secret key he shares with Alice if he will simply encrypt 20 messages for Eve using that key.

>For some unknown reason, Bob agrees. Eve gives him 20 messages, which he then encrypts and emails back to Eve. What kind of attack is Eve using here?

Chosen plaintext attack.

### 4:

>What are the next four numbers (starting from 5) in the pseudo-random number generator:

>3x + 2 mod 11

5 = 17  
6 = 20  
7 = 23  
8 = 26

### 5:

>What is 7<sup>120</sup> mod 143

= 1

### 6:

>What is the plaintext for the following cipher text, which was encrypted using a simple substitution cipher:

>CJBT COZ NPON ZJV FTTK TWRTUYTFGT NJ DTN O XJL. Y COZ ZJV CPJVIK DTN O XJL MYUCN



ABCDEFGHIJKLMNOPQRSTUVWXYZ

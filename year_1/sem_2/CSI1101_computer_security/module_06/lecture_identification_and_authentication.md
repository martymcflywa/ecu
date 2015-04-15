# Identification and authentication

## Key terms

- Identification
	- Establishing who or what an entity person claims to be
	- Who is this entity?
- Authentication
	- Establishing that the entity really is what it claims to be
	- Is this entity really what they claim to be?
- Authorisation
	- Establishing what the entity is allowed to do
	- What resources can they access/interact with?

## Example

- Consider the following situation when you log into the network in the labs:
	- You type in a username
		- Identification
		- You are claiming that you are a particular person'
	- You type in a password
		- Authentication
		- You are supporting or proving your claim
	- The OS and the network decide which resources you can/cannot access
		- Authorisation

### Other examples

- Sometimes a technology can be used for either identification and/or authentication
- Fingerprints
	- Police could use fingerprint technology at a crime scene to try to identify people that might have been present
	- Fingerprints can also prove the claim that a person might make about their identity
- An ID badge
	- This might both identify and authenticate a person

## Authentication without disclosure of identity

- Some systems try to authenticate users without actually disclosing the identity of the subject
- Essentially, the system knows that the subject is either authentic or not authentic, but does not know the identity of the subject
	- IFF in aircraft
- However, identity is necessary if we want to enforce different authorisation controls on a "per user" basis
	- Or relate actions to a particular user

# Identification and authentication approaches

- 3 approaches:
	- **Something you know:**
		- Passwords
		- Answers to questions
		- Secret handshakes/symbols
	- **Something you have:**
		- ID card
		- Token
		- Private key
	- **Something you are:**
		- Biometric characteristics

## Something you know

- Username
- Password
- DOB
- Address
- Phone number
- etc.

### Passwords

- A very common mechanism
- Commonly used for authentication
- Relies on the fact that the correct person knows something that others don't
- Not necessarily unique to one person
	- Someone could tell others their password
	- Just because one person possesses that knowledge, it doesn't stop someone else from possessing it

#### Strength of passwords

- There is quite a spectrum of password strengths
	- Ranging from those that provide no protection
	- To those that provide strong protection

![password strength](http://snag.gy/Ketcj.jpg)

- Could use this in attack tree:

![password comic](http://snag.gy/r5rLv.jpg)

- Blank or default passwords have obvious issues
- Using meaningful and related words such as names of friends, family pets etc. could be guessed by somebody that knows the person
- Using words made up of alphabetic characters but unrelated to the person can still be vulnerable to dictionary crackers
- Using words unrelated to the person and made of of a mixture of alpha and numeric characters offers much greater protection, but are still vulnerable to brute force attacks

#### Problems with passwords

- Will the user disclose the password to another person intentionally, accidentally or because they were deceived?
- Will the user be able to regularly enter the password correctly?
- Will users be able to remember their passwords or will they have to record them somewhere or choose easily guessed passwords?

### Storage of passwords

- Operating systems store passwords in either an encrypted or hashed format
- Use one way hash/encryption algorithms
- OS never actually decrypts the password
	- User types in their password
	- Password is encrypted through the one way function
	- OS compares hash with hash stored in DB

#### Using hash function to store passwords

![hash function to store password](http://snag.gy/VuCBM.jpg)

#### Hash collisions

- What if the hashing algorithm has been poorly chosen/implemented?

![hash collisions](http://snag.gy/cZAYd.jpg)

#### Password hashing

- `crc32()` produces a 32-bit hash output
	- A 32-bit hash has 4,294,967,296 outcomes
- `md5()` might be more suitable as it produces a 128-bit hash output
	- A 128-bit hash has 340,282,366,920,938,463,463,374,607,431,768,211,456 outcomes

### Cracking passwords

- Passwords could be guessed
	- An attacker may sit at the computer trying every possible password combination
	- Many operating systems, networks and applications use account lockouts if an incorrect password is presented several times
- Attacker could lift passwords from a computer
	- Could take them away to their own computer and use a password cracking program
	- An off-line attack

#### Off-line password cracking

- Password attacks often occur off-line using
	- Dictionary attacks
	- Brute force attacks
	- Hybrid attacks
- These can be very computationally intensive
- An i7 processor can crack most passwords quite quickly
	- What about a cluster of computers?
	- What about a GPU?
		- Or a cluster of GPUs?

#### Dictionary attack

![dictionary attack](http://snag.gy/5CK0x.jpg)


#### Brute force attack

![brute force attack](http://snag.gy/wPVTh.jpg)

#### Hybrid attack

- This type of attack will take a dictionary word and then add characters at the start and end of the word in a brute force manner
- This is designed to crack passwords that are based on a dictionary word with extra characters added such as `Hello123`

#### Success factors

- For these offline attacks to work, the attacker needs:
	- The passwords in their hashed form
	- Knowledge of the hashing process/algorithm
	- The ability to test for a match
	- Significant amounts of time/computing power

### Rainbow tables

- Large tables of pre-computed password hashes
- You search the table for a captured hash
- Generally quicker than brute force and dictionary attacks
- They require significant storage
- Consider every single possible word, random characters and numbers being tabulated along with their hash

#### Hash suite

![hash suite 1](http://snag.gy/AVL5I.jpg)

![hash suite 2](http://snag.gy/5XYCS.jpg)

#### Hashcat password recovery tool

![hashcat performance table](http://snag.gy/TTZUu.jpg)

- Uses CPU/GPU
- 1 Radeon 7970
	- ~12 days to test all 12 character md5 uppercase, lowercase and number based hashes
- 4 GPUs?
	- Distributed cluster of GPUs?

#### Good passwords

- Good passwords should
	- Not relate to the person in any way
	- Be a mixture of alpha and numeric characters
	- Be reasonably long
		- More than 12 characters
	- Changed regularly
- If passwords are too difficult to remember
	- People will write them down
	- It is much easier for an attacker to read a password stuck to a monitor with a post-it note than to go to the effort to capture and crack them
- However, good passwords are only as effective as the system they are used on
	- MD5 has been academically broken
	- Is SHA1 the answer?
	- How long before the current computational resources double or triple?
	- How common will it be for people to use 20 char passwords?

#### Password salt

- Random data used as an additional input to a one-way function
- End-users will naturally use short passwords
- Adding additional random characters will theoretically require additional computational power
- Concatenate a salt with a password
- If the attacker knows the salt they still need to calculate a longer list of hash values requiring additional time/resources before the correct value is found

![password salt](http://snag.gy/4j5dG.jpg)

### Think outside the box

>Donald was reading a newspaper story about password security. Donald decided to implement strict rules regarding the passwords used by employees in his company. Donald decided that:

>- Staff passwords would need to be at least 16 char long
- Staff would need to change their passwords every week
- Every password would need to contain letters, digits and symbols
- The same password cannot be used more than once

- List 5 issues you foresee with Donald's proposal
	1. Passwords will be written down
	2. Passwords will be forgotten
	3. Passwords used will be weak
	4. Staff will spend too much time thinking of new passwords
- How could you improve upon his proposal?
	1. Change time restriction to every month
	2. Change min char to 12

## Something that you have

- Smartcard
- Token
- Private key

### Private key

- Included as something you have because not too many people commit their private keys to memory
- Often accessed via a passphrase

### Barcodes

- Developed in the 20th century to improve efficiency in grocery checkouts
- First-gen barcodes represent data as a series of variable-width, vertical lines of ink
- Recent barcodes are rendered as 2d patterns using dots, squares or other symbols that can be read by specialised optical scanners

![barcode](http://snag.gy/HTyHH.jpg)

- The airline industry has been using 2d barcodes into boarding passes
- The barcode is encoded with a unique identifier allowing staff to look up the passenger's records with that airline
- Barcodes provide convenience but are easy to duplicate

![airline ticket](http://snag.gy/ZSVmB.jpg)

### Magnetic smartcards

- Plastic card with magnetic stripe divided into three tracks
	- Each 2.79mm wide
- First track contains
	- Cardholder's name
	- Account number
	- Data format information
- Second track may contain
	- Account number
	- Expiry date
	- Issuing bank info

![magnetic smartcard](http://snag.gy/6ERq1.jpg)

#### Magnetic smartcard security

- Easy to read and reproduce
- Magnetic stripe readers can be purchased at relatively low cost
	- Approx $50 - $100
- When coupled with a magnetic stripe writer, an attacker can easily clone existing cards
	- Magnetic stripe writer only a little more expensive than readers

### Circuit based smartcards

- A plastic card with an integrated circuit
- May include a microprocessor allowing the data on the card to be read and written to
- Much more secure than magnetic smartcards but vulnerabilities do exist

![circuit based smartcard](http://snag.gy/M42CH.jpg)

#### Structure of circuit smartcard

![circuit smartcard structure](http://snag.gy/zUH0d.jpg)

### Tokens

- Time stamp tokens generate a random number
	- Changes every 30 - 60 seconds
- USB tokens communicate with a server when software is used

![rsa securid](http://snag.gy/yh14U.jpg)

### RFID

- Radio frequency identification tags
- Small devices that can be used for identification and authentication
- Most operate within fairly short ranges
- Many apartment buildings utilise RFID based token to grant occupants access to the building
- Embedded in passports, products, people?

### Wearable authentication devices

- Nymi works by using your unique electrocardiogram **ECG** signals to act as a biometric authentication layer for other devices, applications and services

## Something that you are

### Biometrics

- Biometrics are physiological or behavioural
- Physiological measures inherent physical characteristics
- Behavioural systems measure the way in which people act or perform tasks

#### Physiological vs. behavioural biometrics

- **Physiological:**
	- Iris
	- Retina
	- Finger prints
	- Hand geometry
	- Face recognition
- **Behavioural:**
	- Keystroke analysis
	- Signature analysis
	- Voice analysis

#### Biometric process

![biometric process](http://snag.gy/83xlG.jpg)

##### Confidence limits

- Each sensor reading will be slightly different
	- Ambient light
	- Noise
	- Subject's alignment with sensor
- Confidence limits allow for slight variation
- How to determine optimal confidence limits?
	- Too relaxed and we might authenticate imposter
	- Too tight and we might reject real person
	- Unfortunately, the confidence limits may be fixed by the device itself, and may not be user configurable

##### Biometric errors

- **False positive: Type I error**
	- False acceptance
		- Scan falls within the confidence limits
			- Even though subject is not the authentic person
		- Needs to adjust **False Acceptance Rate (FAR)**
- **False negative: Type II error**
	- False rejection
		- Scan falls outside the confidence limits
			- Even though subject is the authentic person
		- Need to adjust **False Rejection Rate (FRR)**

#### Type of subject

- **Cooperative**
	- Submits to biometric sensor reading
- **Non-cooperative**
	- Doesn't explicitly submit to sensor reading but takes no action to avoid it
- **Uncooperative subject**
	- Takes active steps to avoid sensor
		- ie. Covers face to avoid camera

### Physiological biometrics

#### Iris recognition

- Measures characteristics of the human iris
- Can use a mixture of visible light and infrared imaging
- Higher end models can be difficult to fool
- Probability of two people returning exactly the same iris scan result are 1 in 10<sup>52</sup>
- Very accurate
	- Except for early models which could be fooled with a printed picture

![iris recognition](http://snag.gy/SSTI0.jpg)

#### Retina recognition

- Examines the back of the eye
- Requires the subject to be cooperative
- Patterns of blood vessels can be uniquely identifying
- Usually uses infrared imaging
- Quite expensive

![retina recognition](http://snag.gy/m3nI9.jpg)

#### Fingerprint biometrics

- Used for many years
- Quite accurate
- Easy to use
- Easy to replicate using Play-doh
- Measures patterns of ridges and furrows
- Some stigma attached to being fingerprinted
- Even identical twins have distinct fingerprints

![fingerprint biometrics](http://snag.gy/olIkO.jpg)

#### Hand geometry

- Measures physical features of the hand
	- Length in width of fingers
	- Curvature of fingers
	- Distance between knuckles
- Easy to use
- Not as accurate as other biometric methods
- Usually uses optical imaging
- Only really useful for authentication
	- Substantiating someone's claim of identity
	- Not good for identifying people without such claim

![hand geometry](http://snag.gy/lPtB7.jpg)

#### Face recognition

- Uses optical video cameras as a sensor
- Can be used for authentication and identification
	- Performance for identification drops when dealing with greater number of people
- Often does not require subject to be cooperative
	- Could capture images as people walk down a hallway
	- Most effective with cooperative subjects
	- Can cope with non-cooperative subjects
	- Not good at dealing with uncooperative subjects

![face recognition](http://snag.gy/krEWT.jpg)

### Behavioural biometrics

#### Voice recognition

- Uses a microphone as a sensor
- Often quite expensive
- When registering, systems will often ask subjects to record the answers to several questions
	- System asks a random question each time
	- Helps to prevent the recording and playback of a subject's voice
- Often not very accurate
	- Variation in voice from
		- Stress
		- Cold/flu
		- etc.

![voice recognition](http://snag.gy/zgzru.jpg)

#### Keystroke analysis

- Individuals type at a keyboard in different ways
- Ongoing authentication
	- Users can be re-authenticated repeatedly while using a system
- People typing habits can be quite variable
- Not as accurate as iris scans etc.

![keystroke analysis](http://snag.gy/L0oD6.jpg)

#### Signature analysis

- Subjects use a stylus and/or pressure sensitive pad and write their signature
- Signature recognised by measuring
	- Speed
	- Stroke
	- Pressure
- Most people sign their name slightly different every time
	- Some systems can differentiate between habitual and variable sections of the signature

### The future

- Gait analysis?
	- Using radar or other sensors to measure the way in which people walk, move etc.
- Biometrics based DRM on multimedia?
	- So only you can listen to that tune or read that eBook

#### Resistance to biometrics

- Privacy concerns are an important issue with biometrics
- As biometrics become more widely used, these concerns become more widespread
	- Some countries are starting to use biometrics at airports, in passports etc.
	- What happens to all that information?
	- What databases will it end up in?
	- What data will be matched with it?
	- What assurances do we have that these databases will be accurate?

#### Inhibiting factors

- If biometrics solve so many problems, why do we not use biometrics for everything?
- Are the following factors inhibiting the adoption of biometrics?
	- Social
	- Cultural
	- Religious
	- Technical
	- Economical
	- Practical
	- Others?

#### Future biometric uses

- Imagine a situation in which we used fingerprint scanners to
	- Start our car
	- Open our front door
	- Access medical records
	- Withdraw money from an account
- Would you normally use the same password for all these things?
- Also, we can change passwords regularly
	- We can't really change our thumbs

## Concluding remarks

- Is this ability to identify and authenticate necessarily a good thing?
	- Will we get to a stage where every action can be:
		- Recorded
		- Authenticated
		- Cross checked and matched with other actions
	- Is the notion of cash dead?
	- In what areas of our lives do we still have any degree of anonymity?
- Is there really any notion of privacy left?

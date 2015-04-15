# Tutorial 6: Authentication

## 1: Google reconnaissance

Many people use Google purely for the purpose of locating items of interest usually of an entertaining nature. However, the capabilities of Google can far extend into areas such identifying vulnerabilities or locating web cameras which have not been properly secured and hence have configured in a manner which has no authentication implemented. In this instance, we will use Google to locate potential usernames and password lists.

1. Open your web browser presumably Internet Explorer and go to [Google](http://www.google.com)
2. Click [Advanced Search](http://www.google.com/advanced_search)
3. First we are going to see if there are any publicly available Microsoft Excel spreadsheets containing a list of usernames and passwords. Please note, we are not going to and you are not permitted to use any usernames and passwords we find for malicious purposes.
4. We are going to use the search terms `login:` and `password=` to hopefully acquire some results.
5. Under the "Find web pages that have..." there is a text box namely all these words which you need to enter `"login:*" "password=*"`. For those students who are unsure the asterix represents a wild card search.
6. Next under the "File type" field select Microsoft Excel as we are looking for Excel based spreadsheets. Click the "Advanced Search" button.
7. Have a browse around the the Google search results. Some files may be password protected, others will contain actual authentication credentials.
8. What are the security issues associated with performing Google reconnaissance? How can this be mitigated?
	- Files containing passwords in plaintext stored on a web server public folder may be crawled/indexed by Google
		- Site admin may think file is unaccessible since it may not be linked explicitly in any of the web pages
		- Search engine index may provide link to file directly
			- As well as make contents of file viewable through search preview
	- Can be mitigated by
		- Storing file in private folder
			- Where the viewer must authenticate for online access
		- Encrypting file
		- Not storing a plaintext password file on server at all
			- Completely eliminates possibility that a search engine will index file

## 2: Password storage program

1. Outline three benefits to using a password storage program
	- Only have to remember master password
	- Generates random passwords
	- Stores password/username for all logins
		- Some programs also allow storage of
			- Bank/credit card details
			- Software licence keys
2. Outline three issues to using a password storage program
	- If master password compromised, all passwords compromised
	- If encryption/hash functions compromised, program may not be able to protect stored passwords
	- Master password may be stored by user in unsecure location/method
	- Functionality of syncing passwords across devices may be flawed
		- Password hashes stored in cloud?
			- ie. Dropbox
		- Online storage may be compromised
3. How could the program be improved to increase level of security
	- Unlocking requires two-factor authentication
	- Pair master password with physical device, ie. Token, RFID, wearable
	- Unlock program with biometric authentication

## 3: Questions

### 3.1

>Mary developed a password authentication system which only permits eight character passwords. Assuming the full ASCII character set can be used, what is the total number of passwords that could be constructed from such a character set based on the password length?

ASCII char = 95<sup>8</sup>  
No lowercase = 69<sup>8</sup>  
No uppercase = 69<sup>8</sup>  
No digits = 85<sup>8</sup>  
No special char = 62<sup>8</sup>

95<sup>8</sup> - 69<sup>8</sup> - 69<sup>8</sup> - 85<sup>8</sup> - 62<sup>8</sup>  
= 2663362208057822

Only lowercase = 26<sup>8</sup>  
Only uppercase = 26<sup>8</sup>  
Only digits = 10<sup>8</sup>  
Only special char = 33<sup>8</sup>

2663362208057822 + 26<sup>8</sup> + 26<sup>8</sup> + 10<sup>8</sup> + 33<sup>8</sup>  
= 2665186370805215

See: [math.stackexchange.com](http://math.stackexchange.com/questions/739874/how-many-possible-combinations-in-8-character-password)

>Assuming Mary has not implemented any password lockout features and an attacker could test 1 password every nanosecond, how long (on average) would it take an attacker to guess such a password?

&asymp; 44,419.77 minutes  
&asymp; 740.33 hours  
&asymp; 30.84 days  
&asymp; 1 month

### 3.2

> Bob tried to break into an Automated Teller Machine (ATM) using a screwdriver and a paper clip. Fortunately, the only damage he caused was breaking five different keys on the numeric keypad and jamming the card reader, at which point he heard Amy approaching, so he hid. Amy walked up, put in her ATM card, successfully entered her secret 4-digit PIN, and withdrew some money. Because the card reader was jammed she was not able to get card back and decided to go home and call the bank to report the incident.

>Bob went back to the ATM, and was able to push Amy's card back in which activated the ATM and requested a pin number. He started entering numbers to try and discover Amy's PIN number and steal money from her account. What is the worst-case number of PINs that Bob has to enter before correctly discovering Amy's PIN?

Keypad digits = 10  
Broken digits = 5  
Available digits = 5

= 5<sup>4</sup>  
= 625

### 3.3

> A thief walks up to an electronic lock with a 10-digit keypad and he notices that all but four of the keys are covered in dust. On this type of lock each key is only used once in the four digit combination. He assumes that the keys which are not covered in dust must be the ones that are continually utilized. What is the worst case number of combinations he must now test to try to open this lock using a brute-force attack? Think permutations!

4! = 24

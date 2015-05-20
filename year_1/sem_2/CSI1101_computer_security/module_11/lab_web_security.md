# Tutorial 11: Web security

## 1: Step guideline

Protecting your privacy on the Internet can be a difficult task. Create a ten step guideline detailing how you would encourage a novice computer user to protect their privacy.

1. Lock down social networking site privacy settings
2. Configure browser to block cookies
3. Delete existing cookies
	- Do this regularly
	- Can use tools like [CCleaner](https://www.piriform.com/ccleaner/download)
4. Unlink accounts
	- ie. Third party sites that use Facebook login
5. Use [HTTPS Everywhere](https://www.eff.org/HTTPS-EVERYWHERE)
6. Use an ad blocker ie. [Adblock+](https://adblockplus.org/en/) or [uBlock](https://chrismatic.io/ublock/)
7. Use [Tor Browser](https://www.torproject.org/) when anonymous browsing is essential
	- Or other VPN/proxy service
8. Use encryption for emails ie. PGP
9. Use throw away email addresses when signining up to accounts
	- [Mailinator](http://www.mailinator.com/)
	- [Spamgourmet](http://www.spamgourmet.com/)
10. Use common sense

## 2: Cookies

Research the following potential privacy breaching cookies. Which do you believe to be the biggest threat to your privacy?

- Ever cookies
- Flash cookies
- HTTP cookies

### Ever cookies

- See http://samy.pl/evercookie/
	- Open source
	- Javascript API to produce persistent cookies in browser
	- Ability to identify client even after removal of
		- Standard cookies
		- Flash cookies
	- Stores cookie data in several storage mechanisms available in browser, for example
		- Standard HTTP cookies
		- Flash cookies (Local Shared Objects)
		- Silverlight Isolated storage
		- RGB values of auto-generated, force cached PNGs using HTML5 Canvas tag to read pixel (cookies) back out
	- Allows replication of cookies from storage if deletion detected

### Flash cookies

- See https://www.piriform.com/docs/ccleaner/ccleaner-settings/cleaning-flash-cookies
	- Collection of cookie-like data that a website running Adobe Flash can place on local hard drive
	- Contains info about
		- When a site is viewed
		- Tracking
		- Settings information
	- Stealthier than regular cookies
	- Flash can install cookies without user permission by default
- See http://en.wikipedia.org/wiki/Local_shared_object
	- Also known as Local Shared Objects (LSO)
	- Can be stored/retrieved whenever a user accesses page containing Flash application
	- Can store
		- User preferences
		- Save data from Flash games
		- Data to track user Internet activity
	- Criticised as breach of browser security

### HTTP cookies

- See http://www.nczonline.net/blog/2009/05/05/http-cookies-explained/
	- A small text file stored by a browser on user machine
		- No executable code
	- Web page server instructs browser to store information
		- Then sent back to server from browser
	- Can be used to identify individual users
		- Generally used during authentication process for a website login
- See http://en.wikipedia.org/wiki/HTTP_cookie
	- Small piece of data sent from a website and stored in user browser
	- When website is loaded by user, browser sends cookie back to server to notify the website of user's previous activity
	- Designed to be a reliable mechanism for website to remember stateful information
		- Items in shopping cart
		- Logging in
		- Recording which pages were viewed by user
	- Tracking cookies
		- Used to compile long term records of user browsing histories
	- Authentication cookies
		- Determines whether a user is logged in or out
		- Which account user is logged in to
		- Security of authentication cookie generally depends on
			- Security of issuing website
			- User browser
			- Whether or not cookie is encrypted
			- Vulnerabilities may allow attacker to read cookie data
				- Can be used to gain access to
					- User data
					- User credentials to gain access to account
			- See
				- [Cross-site scripting](http://en.wikipedia.org/wiki/Cross-site_scripting)
				- [Cross-site request forgery](http://en.wikipedia.org/wiki/Cross-site_request_forgery)

### Threat

All three cookie types can be a threat to user web privacy, however **ever cookies** seem to have more nefarious implications. Its ability to self replicate with the sole purpose to avoid detection and deletion have the potential to be used for malicious activities.

## 3: Creepy software

The lecture covered a whole series of privacy breaching technologies. Using the web find additional examples of technologies which are currently available or will be soon. What are the privacy implications of the software Creepy?

- Ability to aggregate data and determine facts about somebody using variety of sources
- Connect
	- Status updates
	- Geotagged photos
- Can determine where a person is, when, what they are doing and who with
- Similar implications with government collecting "metadata" on Internet usage

## 4: Questions

### 4.1

Which of the following security goals are addressed by the HTTPS protocol:

1. Privacy
2. Confidentiality
3. Availability

- Privacy and availability

### 4.2

A spammer named Richard has bribed an ISP official $1,000 to let him send out as many spam emails as he wants and he has no other costs. The conversion rate for his spam is the usual 0.001% and he gets $10 for each converted response. What is Richard's expected profit or loss if he sends out 1,000 emails, 100,000 emails, 1,000,000 emails, or 100,000,000 emails?

- 1,000 emails
	- Conversion: 1
	- Earn: 10
	- Profit/loss: -990
- 100,000 emails
	- Conversion: 100
	- Earn: 1000
	- Profit/loss: 0
- 1,000,000 emails
	- Conversion: 1000
	- Earn: 10,000
	- Profit/loss: +9000
- 100,000,000 emails
	- Conversion: 100,000
	- Earn: 1,000,000
	- Profit/loss: +999,000

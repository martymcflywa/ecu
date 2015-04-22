# Tutorial 7: What does your computer say about you

## 1: WinAudit

The first security tool which we will explore is WinAudit. WinAudit is a freeware (self contained) product, designed to allow individuals to audit a Microsoft Windows based computer. You may obtain WinAudit from [www.winaudit.codeplex.com](https://winaudit.codeplex.com/) or from Blackboard directly. You should scan the file prior to executing it to ensure that it is safe.

Once the correct file has been extracted from the compressed folder, WinAudit can be run by double clicking the executable file. This will automatically load and display a window similar to what has been presented below.

The first step is to allow the program to audit your computer. This can be undertaken by click the "To audit your computer click here" button. The process should take no more than a couple of minutes to complete.

You will see that a series of categories are created once the software processes your action. By clicking through the various categories you will see that in just a couple of minutes the application has extracted a wealth of information regarding the current state of your computer. Spend a few minutes 'auditing' your own computer, paying special attention to the security category.

### Questions

#### 1.1

Imagine that the software was executed and run remotely. The attacker now has access to a wealth of information regarding the state of your computer. How would this information be used to further compromise your computer?

WinAudit reports operating system, installed third party applications and their versions. WinAudit also outlines the permissions set for each application. An attacker could then select an exploit based on the operating system and/or third party applications with known vulnerability to their respective version/s. The **Security Settings** section could also be used to determine what password policies are in place.

#### 2.2

How could each of the aims of security (confidentiality, integrity and availability) be compromised through the (WinAudit) information available to you?

##### Confidentiality

- **Security settings:**
	- Can determine if screen saver is password protected
- **Groups and users:**
	- Can determine if any users are not password protected
- **Network TCP/IP:**
	- Can determine which ports are open
	- ie. Sniff telnet

##### Integrity

- **Groups and users:**
	- Can determine which user has administrator rights and can make system changes
	- ie. Target attacks towards this user to propagate malware

##### Availability

- **Installed programs:**
	- Identify if an installed application has vulnerability for denial of service

## 2: PC-Time

The next security tool which we will briefly experiment with is called PC-Time. PC-Time is a self-contained freeware software, permitting you to monitor when and for how long any computer has been used for during any given time period. A compressed zip file has been placed on Blackboard under this module. To run the program, simply double click on the executable file and view the reported information of the program.

### Questions

#### 2.1

Why would knowing when and for how long a computer was used be beneficial to an investigator who is auditing a computer?

- Determine when to schedule backups
- Attacker may be able to use downtime to determine when computer is unattended for theft/destruction

#### 2.2

In the full version of the software, the investigator may use the software to view the usage time of other computers on the network. How would this information be beneficial within a place of work?

- Determine when to schedule backup for all computers

#### 2.3

Try to come up with three other scenarios in which such a tool benefit an investigator, OR an end-user?

## 3: MyLastSearch

MyLastSearch is a freely available tool allowing you to view the search history of your web browser. You may download a copy from [www.nirsoft.net](http://www.nirsoft.net/utils/my_last_search.html) or obtain the software from this week’s module on Blackboard. Once you have downloaded and extracted the software, simply double click on the executable file to run the program. The program will immediately collect, interpret and present your search history for the computer you are currently using.

### Questions

#### 3.1

What privacy concerns exist with using a program such as MyLastSearch?

- Able to determine what kind of sites have been searched on the computer for/viewing and how much
	- Not user specific
- User/s of computer may not want anyone else to know

#### 3.2

How could this software be misused if it were used by someone who had temporary (and unauthorized) access to your computer?

- Disclose search habits to
	- Others to embarrass
	- Use as leverage for blackmail
	- Marketing companies for targeted advertising
- MyLastSearch also advises which browser the search was made
	- Could use to target any sites the user has logged in to
		- If password saved by browser, attacker may gain access to website
			- ie. Internet banking
			- ie. Web based email

## 4: IEHistoryView

IEHistoryView is a freely available tool allowing you to view all the websites which have been accessed via the computer that you are currently using. You may download a copy from
[www.nirsoft.net](http://www.nirsoft.net/utils/iehv.html) or obtain the software from this week’s module on Blackboard. Once you have downloaded and extracted the software, simply double click on the executable file to run the program. The program will immediately collect, interpret and present your search history for the computer you are currently using.

### Questions

#### 4.1

What privacy concerns exist with using a program such as IEHistoryView?

- Similar to MyLastSearch but for specific sites
	- Able to determine which specific sites the user is viewing, and how often
	- User may not want anyone else to know

#### 4.2

An individual could potentially deny accessing one or all of the websites listed in the IEHistoryView window. What data does IEHistoryView also present which could distinguish an 'accidental' accessing of a URL versus an intentional continuous access of a specific URL?

- It shows the user
- It shows number of hits
	- Can't be accidential if viewed 145 times

#### 4.3

How is IEHistoryView different from MyLastSearch? (You may need to go back and run MyLastSearch to compare the result).

- MyLastSearch
	- Identifies search string
	- Identifies search engine used
	- Identifies date/time of search
	- Identifies browser used
- IEHistoryVIew
	- Identifies specific user/s
	- Identifies specific URLs rather than search terms
		- Could be used to form "watering hole attack"
	- Identifies page title
	- Identifies date/time of search
	- Even shows downloads
		- Identifies location
		- Subfolder
		- File position

## 5: Metadata

Often end-users will leave confidential and/or private information within documents. As a result this information could be utilised to determine the owner of the document. Download and open the document titled 'Fictional Press Release' from Blackboard. As the name suggests this is a press release outlining new products from a fictional company.

### Questions

#### 5.1

Upon initial examination the document seems harmless. However it contains a wealth of information that the company would probably not want released. How much of this information can you find?

- **Properties:**
	- Title: Press Release – Widget Pro 3000 and Widget Deluxe 3000
	- Tags: Waste of time and money;
	- Categories: Marketing junk;
	- Comments: This is a draft.  Make sure it is not released to the public.
	- Revision number: 14
	- Program name: Microsoft Office Word
	- Company: SCIS
	- Content created: 2/02/2006 2:50 PM
	- Date last saved: 6/03/2006 2:10 PM
	- Total editing time: 01:16:00
	- Typist: Jane Citizen
	- Status: Not for the ... (public?)
- **Comments:**
	- Wasn’t this supposed to be released this time last year?
	- This was going to retail for $150, but marketing thinks we can get away with asking $200
	- If only the suckers new this was exactly the same product as the Widget Pro...
	- Except the laundry feature doesn’t actually work yet...
	- Yeah right. There’s a sucker born every minute...

#### 5.2

What other ways can you think of in which data might accidently be leaked when making documents public?

- Passwords shown in video footage
	- http://arstechnica.com/security/2015/04/hacked-french-tv-network-admits-blunder-that-exposed-youtube-password/

## 6: Question

Australia Post has just delivered your international passport which contains an RFID tag containing your sensitive information. A week later while shopping, you notice a salesperson selling a protective cover for your passport. The salesperson's solution costs $79.95 and protects your passport from being read via radio waves while it is in your pocket. Explain how you could achieve the same outcome for under $5.00.

- DIY RFID blocker sleeves
	- https://youtu.be/BEyRfjeE6ac
- Materials
	- UHT self stable carton
		- ie. Carton of milk
		- Needs layer of foil inside
		- Plastic laminated
	- Aluminum foil tape
	- Plastic packing tape
- Method
	- Clean and dismantle carton
	- Spread carton flat
	- Trace passport/card over carton, both sides
	- Cut out tracing
	- Fold cutout in half
	- Use foil tape to stick sides together
	- Use packing tape over foil tape to secure
	- Leave one edge open to insert passport/card
- Alternative
	- Use only foil to cover passport/card

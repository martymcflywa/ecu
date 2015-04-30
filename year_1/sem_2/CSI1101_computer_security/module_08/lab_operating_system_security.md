# Tutorial 8: Operating system security

## 1

For what are the following components of the Windows security architecture responsible?

- SAM
- SRM
- Security descriptors
- Tokens
- EFS

### Answer

- Security Accounts Manager (SAM)
	- A database that stores user accounts and relevant security information about local users and groups
	- Stores users' passwords in hashed format
- Security Reference Monitor (SRM)
	- Determines if a process has the appropriate rights to perform an action
- Security descriptors
	- Part of NTFS file system
		- Each NTFS file associated with a security descriptor
	- Acts as container for security Token of the owner of the file
- Tokens
	- After a user is authenticated, access tokens are issued to user accounts by Local Security Authority (LSA) which contain
		- User's individual Security Identifier (SID)
		- User's group Security Identifier (SID)
		- Local system rights
	- Token is used to access objects via the Security Reference Monitor (SRM)
	- In order to access an NTFS file, Security Reference Monitor (SRM) compares tokens of users to the file's Access Control List (ACL) to determine if access is allowed

## 2

Research and define the following models of security:

- Bell-LaPadula
- Biba
- Clark-Wilson

### Answer

#### Bell-LaPadula

(Manocha, 1999)

- Deals with control of information flow
- "Linear non-discretionary model"
- Consists of:
	- Set of subjects
	- Set of objects
	- Access control matrix
- Security levels
	- Each subject has maximum clearance level
		- Subject can access lower clearance levels but cannot go higher than max
	- Each object has classification
		- Classification is attached to a security level
- Access rights for subjects
	- Read only
		- Subject can only read the object
	- Append
		- Subject can only write to object but cannot read
	- Execute
		- The subject can execute the object but cannot read or write
	- Read-write
		- The subject has both read and write permissions to the object
- Control attribute
	- Given to the subject that creates an object
	- Creator of object can assign any of the access rights above of their object to any subject
		- However it cannot pass the control attribute itself
	- The creator of the object is also known as the controller of that object
- Restrictions
	- Reading down
		- A subject has only read access to objects whose security level is below the subject's clearance level
			- Prevents subject from accessing information available in higher security levels that the subject's clearance level
	- Writing uo
		- A subject has append access to objects whose security level is higher than its current clearance level
			- Prevents subject from passing information to levels lower than its current level
- Supplement
	- The Bell-Lapadula model supplements the access matrix with above restrictions to provide access control and information flow
		- If a subject has read access to an object in the access matrix, it might still not be able to exercise this right if the object is at a security level higher than the subject's clearance level
- Operations
	- `get access`: Initiates access to object (read, append, execute etc.)
	- `release access`: Gives up initiated access
	- `rescind access`: Controller of an object can revoke a designated access to that object from a subject
	- `create object`: Activates an inactive object
	- `delete object`: Deactivates an inactive object
	- `change security level`: Changes clearance level of a subject below an initially assigned value
	- Note: Certain conditions must be satisfied before any of above operations can be performed
		- ie. Subject can perform `get access` and `rescind access` to an object only if it has control attributes to that object

![bell-lapadula model](http://snag.gy/T4cA4.jpg)

- Further reading
	- Singhal,M. and Shivaratri,N.: Advanced Concepts in Operating Systems , McGraw-Hill, 1994.
	- Peterson,J.L. and Silberschatz,A.: Operating System Concepts, 2nd ed, Addison Wesley, 1985.
	- Landwehr,C.E, Formal Models of Computer Security, ACM Computing Surveys, Sept. 1981

(Maniscalchi, 2010)

- Developed in 1970s for US Military by David Bell and Leonard LaPadula of Mitre Corporation
- Developed in response to information leakage
- Concentrates on protecting information from flowing in wrong direction
	- Categorised as an Information-Flow model
- Is a Hierarchical State Machine Model
	- Many layers (lattice)
	- Maintains a secure state
		- Each rule is security preserving
		- Transactions proceed only if the system moves from its existing secure state to another secure state
- Three access rules
	- Dominance relation
		- The clearance level of a user (subject) maps to the classification of files (object)
		- Users with particular clearance will only be able to access files of a particular classification and below
	- Discretionary security
		- Specific users are granted specific modes of access
	- Data flows upwards
		- Data can only move up the lattice from lower levels of classification to higher
- First model to define three fundamental modes of access
	- Read
	- Write
	- Read/write
- Users cannot be assigned more than one access mode
- Security properties
	- Simple security property
		- Users can read data of a lower classification
	- Star security property
		- Users can write data to an area of higher classification
	- Strong star (tranquility) property
		- Users can read and write to own level only

#### Biba

(Maniscalchi, 2010)

- Focuses on data integrity
- Concerned with preventing data from low integrity environments polluting high integrity data
- Security properties
	- Simple integirty property
		- Data can be read from a higher integrity level
	- Star integrity property
		- Data can be written to a lower integrity level
	- Invocation property
		- User cannot request service (invoke) from a higher integrity level
- Opposite of BLP
	- BLP is WURD model
		- Write up read down
	- Biba is RUWD model
		- Read up write down

#### Clark-Wilson integrity model

- Builds on BLP and Biba
- Introduces concept of a program arbitrating a subjects access to an object in an access triple
	- A relationship of subject, program and object
- Three integrity goals
	- Preventing unauthorised users from making any modifications
	- Preventing authorised users from making unauthorised modifications
	- Maintaining internal and external consistency
- Only permits modificationm of data if that modification meets the three integrity goals above

#### Lipner 1982

(Maniscalchi, 2010)

- Combination of BLP and Biba forms the basis of Windows NT security model

## 3

Open source operating systems such as Linux are more secure than closed source (commercial) systems such as Windows 8. This is a great exam question. What is your view on this issue? Do you agree or disagree? Do some research on arguments for and against the statement.

### Open vs. closed

(Basha, 2001)

(Iyengar, Sachdev, & Raja, 2007)

- Open
	- Pros
		- Less market share
			- Less likely to be targeted by attackers
		- Transparent
			- Source code available to anyone
		- More people can debug
		- More frequent patching of vulnerabilities
		- Not hindered by schedule or monetary obstacles
		- Support from community
		- Free
	- Cons
		- Less control over code
		- Anyone can make alterations
		- Could potentially lead to backdoors
			- Although community would report straight away
- Closed
	- Pros
		- Unified experience
		- Less confusion for customers
		- More profitable
		- More control over code
	- Cons
		- Large amount of market share
			- Targeted by attackers more frequently than open source counterparts
		- Can only be debugged by employees/contractors
		- Costs time and money
			- May not be priority of company
		- Have to wait until company releases patch for product to resolve vulnerabilities
		- Cost of product


## 4

Describe a good solution to the problem of having a group of students collaborate on a software construction project using the directory of one of the group members in such a way that it would be difficult for non-members to discover and would not require the help from a system administrator, assuming that the only access rights the group leader can modify are those for `\everyone."`

You may assume that access rights for directories are `\read,"\write,"` and `\exec,"` where `\read"` means the files and subdirectories in that directory can be listed, `\write"` means members of that directory can be inserted, deleted, or renamed, and `\exec"` on a directory or subdirectory means the user can change his location to that directory or subdirectory so long as he specifies its exact name.

# References

- Basha, A. (2001). Open-Source versus Closed-Source Sytems. Retrieved April 30, 2015, from http://www.enderunix.org/docs/opensource_vs_closedsource.html
- Iyengar, K., Sachdev, V., & Raja, M. K. (2007). A Security Comparison of Open-Source and Closed-source Operating Systems. In Swdsi 2007 (Vol. 2012, pp. 236–242). Retrieved from http://www.swdsi.org/swdsi07/2007_proceedings/papers/236.pdf
- Maniscalchi, J. (2010). Information Security Models for Confidentiality and Integrity | Digital Threat. Retrieved April 30, 2015, from http://www.digitalthreat.net/2010/05/information-security-models-for-confidentiality-and-integrity/
- Manocha, H. (1999). Protection: Bell-Lapadula Model. Retrieved April 30, 2015, from http://courses.cs.vt.edu/~cs5204/fall99/protection/harsh/

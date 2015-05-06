# Application security

## Security issues

- Attackers who takeover applications can usually execute commands with access permissions of the compromised application
- Many applications run with admin/root privileges
- So taking over the application gives the attacker total control of the host

### Why admin/root privileges

- Program may make changes to registry
- Program may need access or alter system files
- You may need to make major changes to the OS
	- ie. Installing drivers
- What happens in an ECU computer lab when you try and install a program into `C:/Program Files`?

### Application vulnerabilities

- Like operating systems, applications are complex systems
- They will have
	- Design flaws
	- Implementation errors
	- Leads to vulnerabilities

### Security requirements

- Secure is an attribute that all software should possess
- Software may have particularly high
	- Confidentiality requirements
	- Integrity requirements
	- Availability requirements
- What consequences would there be if the above security requirements of **Keepass** were not met in the software?
	- Confidentiality
		- Stored passwords would be compromised easily
	- Integrity
		- Stored passwords would be incorrect
	- Availability
		- User would not be able to access stored passwords

### Principle of least privilege

- Every process, user or program must only access the information and resources that are necessary for its legitimate purpose
- A user designed to backup a computer system should not be given privileges to install additional software

### Software bugs

- As a general rule
	- More lines of code = more bugs
	- More bugs = more vulnerabilities
- As the number of lines of code grow, it becomes difficult to eliminate bugs
- We need to assume that any software beyond what is trivially simple **will** have bugs

### Tight integration

- Tight integration with operating systems
- Tight integration of multiple packages
- All programs in an integrated package are accessed via a common launch pad
- Does any application consist of one `.exe` file?
	- How many applications install completely into their own directory and are completely standalone?
	- How many applications share components?

### Application and OS integration

- Advantages
	- Less overall code which means less bugs
	- If you write good quality **secure** code, then overall the application should be secure
- Disadvantages
	- A bug in a shared component can be shared across many applications
	- Vulnerabilities can be shared
	- The software writer may purposefully implement vulnerabilities to be exploited at a later date

### Security problems with app development

- Security is often not considered at all
- Security is often an 'addon'
- Security can be scoped out as project deadlines approach
- Security is omitted to improve performance
- Clients notice if functionality is missing in an app
	- They tend not to notice so much when security measures are cut out

## Design issues

>Security must be built in from the start.

- Security problems are often built into software from the design phase
- Useability is more important than security
- Security measures are often seen as infringing upon usability
- What will the lifespan of the application be?
	- Many Y2K problems were caused by applications that were not supposed to be in service as long as they were

### Models of software development

- Prototyping methods can lead to security problems
	- Prototypes are created and presented to end-users
	- Prototypes are refined to meet user requirements
	- Prototype is re-implemented once requirements determined
- Security issues raised
	- Often the last prototype becomes the final system
	- Users are often unaware of security issues
	- It is often difficult to build in security from the start

## Implementation issues

>Software errors

### Buffer overflow / overrun

- A buffer is a section of memory used to temporarily store data
- A buffer overflow, also known as a buffer overrun is a condition whereby the input data placed into a buffer or data holding area exceeds its allocated capacity
- A programming error when a process attempts to store data beyond the limits of a fixed-sized buffer
- This subsequently overwrites adjacent memory locations
	- The location could hold other
		- Program variables
		- Parameters
		- Or program control flow data

#### Buffer overflow example

```
char a[8] = "";
int b = 1979;
```

![buffer overflow example 1](http://snag.gy/dLPC2.jpg)

- During runtime the null terminated string `"excessive"` is entered by the user
- `"excessive"` is 9 characters (bytes) long plus a 1 byte terminator
- However, the array is only initialised to fit 8 characters (bytes)
- The last char of `"excessive"`, `'e'` spills into the variable `b` thus modifying the value for `b` from `1979` to `25856`

![buffer overflow example 2](http://snag.gy/Z7SaT.jpg)

#### Buffer overflow / overrun consequences

- Corruption of program data
- Unexpected transfer of control
- Memory access violations
- Execution of code chosen by attacker
- `C` language assumes that the programmer knows what they are doing and as a result it is up to the programmer to find and fix mistakes

### Stack-based buffer overflow

``` c
int main(int argc, char * argv[]) {

	// create buffer on the stack
	char buff[256];

	// does not check size of buffer
	strcpy(buff, argv[1]);

	// print the contents of buffer
	printf("%s\n", buff);
	return 1;
}
```

- In this instance, a buffer has been created with a size of 256 characters
- If 10 characters are entered, the program works correctly
- If 500 characters were entered, a buffer overflow occurs

#### Stack-based buffer overflow countermeasure

``` c
int main(int argc, char * argv[]) {

	// create a buffer on the stack
	char buff[256];

	// does not check size of buffer
	strcpy(buff, argv[1], sizeof(buff));

	// print the contents of buffer
	printf("%s\n", buff);
	return 1;
}
```

- In this instance, the `sizeof(buff)` has been added to the argument
- Should the buffer exceed 256 characters, only the first 256 characters will be copied

### Arithmetic overflow example

``` c
int main(int argc, char * argv[]) {

	unsigned int connections = 0;

	// insert network code here

	connections++;

	if(connections < 5) {
		grantAccess();
	} else {
		denyAccess();
	}

	return 1;
}
```

- Unfortunately the connection variable will only increment once
- The number of connections may exceed 100 but access will still be granted

#### Arithmetic overflow countermeasure

``` c
int main(int argc, char argv[]) {

	unsigned int connections = 0;

	// insert network code here

	if(connections < 5) {
		connections++;
		grantAccess();
	} else {
		denyAccess();
	}

	return 1;
}
```

- In this instance, by a simple re-arrangement of code, the program is now safe
- With `connections++` inside the `if` statement, `connections` would no longer exceed 5 at a time

### Exploiting buffer overflows

- To exploit a buffer overflow, an attacker needs to identify a buffer overflow vulnerability in a program
- If the buffer overflow contains instructions, these instructions would be processed by the processor
	- Modern computers make no distinction between instructions and data
	- If a processor can be fed instructions when it should be seeing data, it will happily go about executing the passed instructions

### Windows XP example of buffer exploit

- Application login page
	- Enter a username between 6 and 22 chars
- Attacker types the following username / attack code
	- `HomerSimpson1234567890rundll32%20shell.dll,cmdprompt`
- Application fails to check the input and puts entire code into stack
- Code from char 23 may begin execution

### Shellcode and instruction pointers

- Suppose an attacker can cause a buffer overflow to occur
- Also suppose the attacker didn't just try and insert random data
- What if the **data** is actually a carefully crafted set of instructions?
- What if the attacker can also manipulate the instruction pointer
	- The instruction pointer indicates the next instrution that the processor is to execute
- If the attacker can get the instruction pointer to point to the shellcode, the code will be executed by the system
- This is one way in which an attacker can **get into** a system
- This is quite a simplification of the whole process, but it should give you an idea of what a buffer overflow is

### Shellcode

- Shellcode is a series of machine code instructions
	- Hex opcodes
	- Designed to be fed into an overflowed buffer
- Shellcode is usually written to be as small, compact and efficient as possible
- Shellcode can be created in a few different ways
	- Write hex opcodes directly
		- Not for the faint hearted
	- Write / disassemble assembly code to retrieve opcodes
	- Use high level language and disassemble to retrieve opcodes

#### What can shellcode do

- If shellcode can begin execution, it can perform a huge variety of actions
- Initially the aim was often to open a command shell with a high level of privilege
	- Hence the term **shellcode**
	- On *nix systems, a shell with root privileges can give an attacker almost complete control of the system
- Shellcode can be written to do much more
	- However shellcode writers will usually try to keep the code quite small
- Often the shellcode will be used as a **way into** the system

### Exploiting buffer overflows

- Attacks can use automated software to help identify operating systems and applications that are vulnerable to buffer overflows
- [Nessus](http://www.tenable.com/products/nessus-vulnerability-scanner) is one such tool
	- Can be extended through the use of plugins

### Example shellcode to spawn shell

- Desired shellcode code in C

``` c
int main(int argc, char * argv[]) {
	char *sh;
	char *args[2];
	sh = */bin/sh*;
	args[0] = sh;
	args[1] = NULL;
	execve(sh, args, NULL);
}
```

- Equivalent position-independent x86 assembly code

``` assembly
		nop
		nop							// end of nop sled
		jmp		find				// jump to end of code
cont:	pop		%esi				// pop address of sh off stack into %esi
		xor		%eax,%eax			// zero contents of EAX
		mov		%al,0x7(%esi)		// copy zero byte to end of string sh (%esi)
		lea		(%esi),%ebx			// load address of sh (%esi) into %ebx
		mov		%ebx,0x8,(%esi)		// save address of sh in args[0] (%esi+8)
		mov		%eax,0xc,(%esi)		// copy zero to args[1] ($esi+c)
		mov		$0xb,%al			// copy execve syscall number (11) to AL
		mov		%esi,%ebx			// copy address of sh (%esi) to %ebx
		lea		0x8(%esi),%ecx		// copy address of args (%esi+8) to %ecx
		lea		0xc(%esi),%edx		// copy address of args[1] (%esi+c) to %edx
		int		$0x80				// software interrup to execute syscall
find:	call	cont				// call cont which saves next address on stack
sh:		.string	*/bin/sh	*		// string constant
args:	.long 0						// space used for args array
		.long 0						// args[1] and also NULL for env array
```

- Hex values for compiled x86 machine code

```
90 90 eb 1a 5e 31 c0 88 46 07 8d 1e 89 5e 08 89
46 0c b0 0b 89 f3 8d 4e 08 8d 56 0c cd 80 e8 e1
ff ff ff 2f 62 69 6e 2f 73 68 20 20 20 20 20 20
```

### Other common programming flaws

- Login credentials hard coded into programs or scripts
- Off-by-one errors
	- ie. A function loops one too many times
	- ie. A `<` comparison should be `<=`

## Testing issues

### Basic types of testing

- Functional testing **black box**
	- Involves testing components/modules to ensure that it performs the correcnt functions
	- Tests inputs and outputs
- Structural testing **white box**
	- Examines code to ensure that it behaves properly
	- A worked example
- Unit testing
	- Individual functions/components/modules are tested prior to these being integrated with others to build a system
- System testing
	- Tests the system as a whole
	- Pays particular attention to making sure that components work together properly
- Third party testing
	- Testing may also be done by an outside organisation (Bishop, 2003)

## Software maintenance

>Patching and updating systems

### Patching

- Software is often updated in the form of patches
- Patches may correct functionality related problems
- However, they often fix security related problems
- Keeping software up-to-date with patches is usually considered to be vital for improving the security and stability of systems
- However patching can also cause a range of problems

### Patching issues

- If a vulnerability is discovered and a patch is released
	- There is a window of opportunity for an attacker to exploit this vulnerability between the discovery of the vulnerability and the installation of the patch
- Therefore, it is important to minimise this window of opportunity by reducing the time from the vulnerability being discovered to the patch being installed

### Patch testing

- Once a vulnerability has been discovered
	- Vendors need to develop a patch
		- Vendors are under pressure to get a patch released
		- Patches often released soon after the broadcast of a vulnerability
		- This does not leave much time for testing by the vendor
	- Customers need to install the patch, however
		- Does the patch fix what it is intended to fix?
		- Does the patch break anything else?
		- Does it introduce new vulnerabilities?
		- Does it degrade system performance?

### Patching

- Install the patch too soon and you risk breaking existing systems
- Install the patch too late and you leave a larger window of opportunity for a potential attacker
- A balance is required

## Concluding remarks

- Which do you think is more secure, open or closed source software
	- Why?
	- What are the advantages and disadvantages of each

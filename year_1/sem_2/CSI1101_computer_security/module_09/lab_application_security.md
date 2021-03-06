# Tutorial 9: Application security

## 1

Buffer overflows are a common type of programming vulnerability, particular for software written in variants of the C language. Below are some examples of buffer related problems. Examine the source code and try to follow its logic. See if you can find the buffer related problem in each example.

### 1.1

``` c
int main() {
	int buffer_array[5] = {1,2,3,4,5};
	printf("%d\n", buffer_array[5]);
}
```

- `printf("%d\n", buffer_array[5]);` is out of bounds
- `buffer_array[4]` is limit of array

### 1.2

``` c
int main() {
	int buffer_array[5];
	int count;
	for (count=0; count<=10; ++count) {
		buffer_array[count] = count;
	}
}
```

- `count` will cause `for` loop access of `buffer_array[5]` to be out of bounds
- `for` loop should check `sizeof(buffer)`:

``` c
for(count = 0; count < sizeof(buffer); count++) {
	buffer_array[count] = count;
}
```

### 1.3

``` c
int main(char *input) {
	char buffer[10];
	strcpy(buffer, input);
}
```

- Does not check size of `buffer`
- `input` length could be greater than `buffer` length
- `strcpy` should be:

``` c
strcpy(buffer, input, sizeof(buffer));
```

## 2

Research the following terms/projects:

1. Shellcode
2. Opcodes
3. Metasploit project
4. Damn Vulnerable Web App

### 2.1 Shellcode

- A list of carefully crafted instructions that can be executed once the code is injected into a running application
	- Stack and heap-based buffer overflows are the most popular way of doing so
	- The term shellcode literally refers to written code that starts a command shell
- A small piece of code used as the payload in the exploitation of a software vulnerability [wikipedia](http://en.wikipedia.org/wiki/Shellcode)
- A shellcode is a group of instructions which can be executed while another program is running [Rosiello2004]

### 2.2 Opcodes

- An opcode (operation code) is the portion of a machine language instruction that specifies the operation to be performed [wikipedia](http://en.wikipedia.org/wiki/Opcode)
	- Beside the opcode itself, instructions usually specify the data they will process, in the form of operands
	- In addition to opcodes used in instruction set artchitectures of various CPUs, which are hardware devices, they can also  be used in abstract computing machines as part of their byte code specifications

### 2.3 Metasploit project

- [metasploit.com](http://www.metasploit.com/)
- Computer science project that provides information about security vulnerabilities and aids in penetration testing and IDS signature development [wikipedia](http://en.wikipedia.org/wiki/Metasploit_Project)
	- Best known for open-source sub-project Metasploit Framework
		- A tool for developing and executing exploit code against a remote target machine
	- Other sub-projects include
		- Opcode database
		- Shellcode archive
		- Related research

### 2.4 Damn Vulnerable Web App

- [dvwa.co.uk](http://www.dvwa.co.uk/)
- A PHP/MySQL web app that is vulnerable
	- Aid for security professionals to test their skills and tools in a legal environment
	- Helps web developers better understand the process of securing web apps
	- Aids teachers/students to teach/learn web app security

## 3

Advanced question.

Consider the following piece of C code:

``` c
int main(int argc, char *argv[]) {
	char continue = 0;
	char password[8];

	strcpy(password, argv[1]);

	if(strcmp(password, "CS166") == 0) {
		continue = 1;
	}

	if(continue) {
		*login();
	}
}
```

- In the above code, `*login()` is a pointer to the function `login()`
	- In C, one can declare pointers to functions which means that the call to the function is actually a memory address that indicates where the executable code of the function lies

### 3 questions

1. Is this code vulnerable to a buffer-overflow attack with reference to the variables `password[]` and `continue`?
	- If yes, describe how an attacker can achieve this and give an ideal ordering of the memory calls that correspond the variables `password[]` and `continue` so that this attack can be avoided
		- Assume that the memory addresses increase from left to right
2. To fix the problem, a security expert suggests to remove the variable `continue` and simply use the comparison for login
	- Does this fix the vulnerability?
	- What kind of new buffer overflow attack can be achieved in a multiuser system where the `login()` function is shared by a lot of users, and many users can try to log in at the same time?
		- Both malicious and non-malicious users
		- Assume for this question only that the pointer is on the stack rather than in the data segment, or a shared memory agent
3. What is the existing vulnerability when `login()` is not a pointer to the function code, but terminates with a `return()` command?
	- Note that the function `strcpy` does not check an array's length

#### 3.1

- Is this code vulnerable to a buffer-overflow attack with reference to the variables `password[]` and `continue`?
	- Yes
		- It is vulnerable to buffer-overflow attack since `strcpy(password, argv[1]);` does not check `sizeof(password)`
		- Attacker may input a string larger than `password[8]` aiming to make `continue = 1`

#### 3.2

- To fix the problem, a security expert suggests to remove the variable `continue` and simply use the comparison for login
	- Does this fix the vulnerability?
		- No, input may still be larger than allocated array size
			- Program does not have countermeasure to deal with "larger than array" input
		- Attacker may manipulate instruction pointer and execute shellcode
	- What kind of new buffer overflow attack can be achieved in the multiuser system where `login()` function is shared by a lot of users, and used simultaneously
		- Heap overflow attack??

#### 3.3

- What is the existing vulnerability when `login()` is not a pointer to the function code, but terminates with a `return()` command?
	- Note that the function `strcpy` does not check an array's length
		- Stack-based buffer overflow
		- Not secure anyway since password `"CS166"` is hardcoded into program, and in plain-text

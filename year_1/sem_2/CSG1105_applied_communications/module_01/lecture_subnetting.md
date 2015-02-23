# IP addresses: Subnetting and Supernetting

## Objectives

- Subnet masks
- CIDR notation for subnet masks
- IP address format and components
- The meaning of the "." or lack thereof
- Subnetting
- Supernetting
- Subnetting a range to a given requirement

## IP addresses and subnet masks

| IP & Subnet         | Binary                                        |
|:--------------------|:----------------------------------------------|
| 192 . 168 . 0 . 0   | 1100 0000 . 1010 1000 . 0000 0000 . 0000 0000 |
| 255 . 255 . 255 . 0 | 1111 1111 . 1111 1111 . 1111 1111 . 0000 0000 |

### Ingredients for subnetting

- IP Address: 192 . 168 . 1 . 165
	- Every device needs a unique IP address
- Subnet mask: 255 . 255 . 255 . 0
	- Used by the local workstation to determine what subnet it is on
		- The subnet mask isn't usually transmitted across the network
		- You'll ask for the subnet mask all the time
- Default gateway: 192 . 168 . 1 . 1
	- The router that allows communication outside of the local subnet
	- Default gateway must be an IP address on the local subnet

### Secret behind the IP address

- IP address isn't a single address
- IP address is a combination of
	- A network ID
	- A host ID
	- The subnet mask determines which part of the IP address is the network, and which part is the host
		- The subnet mask is just as important as the IP address

### Classful subnetting

- Very specific subnetting architecture
- Not used since 1993
	- Still relevant in casual conversation

| Class   | Subnet              | Binary                                        |
|---------|---------------------|-----------------------------------------------|
| Class A | 255 . 0 . 0 . 0     | 1111 1111 . 0000 0000 . 0000 0000 . 0000 0000 |
| Class B | 255 . 255 . 0 . 0   | 1111 1111 . 1111 1111 . 0000 0000 . 0000 0000 |
| Class C | 255 . 255 . 255 . 0 | 1111 1111 . 1111 1111 . 1111 1111 . 0000 0000 |

### Classless subnetting - CIDR

- Created around 1993
- Removed restrictions created by classful subnet masks
- *Cider* block notation
- Removes boundaries from classful subnetting

| Notation        | Subnet          | Binary                                        |
|-----------------|-----------------|-----------------------------------------------|
| 192.168.1.0 /24 | 255.255.255.0   | 1111 1111 . 1111 1111 . 1111 1111 . 0000 0000 |
| 10.1.0.0 /16    | 255.255.0.0     | 1111 1111 . 1111 1111 . 0000 0000 . 0000 0000 |
| 10.1.1.0 /24    | 255.255.255.0   | 1111 1111 . 1111 1111 . 1111 1111 . 0000 0000 |
| 10.1.1.0 /26    | 255.255.255.192 | 1111 1111 . 1111 1111 . 1111 1111 . 1100 0000 |

`/26` indicates that the leading 26 bits in the address are `1`.

## Using the subnet mask

IP address: 192 . 168 . 1 . 0  
Subnet mask: 255 . 255 . 255 . 0

| IP & Subnet           | Binary                                        |
|-----------------------|-----------------------------------------------|
| 192 . 168 . 1 . 0     | 1100 0000 . 1010 1000 . 0000 0001 . 0000 0000 |
| 255 . 255 . 255 . 0   | 1111 1111 . 1111 1111 . 1111 1111 . 0000 0000 |
| network or host       | nnnn nnnn . nnnn nnnn . nnnn nnnn . hhhh hhhh |

- Network address is *masked* by `1`s
- Client addresses are not masked by the `1`s
	- Eight bits `0000 0000` means 254 possible clients
		- Number of possible clients (2<sup>8</sup> = 256) minus 2 
			- Minus the subnet address
			- Minus the broadcast address

### Calculating subnet and broadcast address

**Note:** 

- Subnet address is all `0`s
- Broadcast address is all `1`s

IP address: 192 . 168 . 1 . 165  
Subnet mask: 255 . 255 . 255 . 0

| IP & Subnet         | Binary 
|---------------------|-----------------------------------------------|
| 192 . 168 . 1 . 165 | 1100 0000 . 1010 1000 . 0000 0001 . 1010 0101 |
| 255 . 255 . 255 . 0 | 1111 1111 . 1111 1111 . 1111 1111 . 0000 0000 |
| Bitwise `AND`       | 1100 0000 . 1010 1000 . 0000 0001 . 0000 0000 |
| Subnet address      | 192 . 168 . 1 . 0                             |
| Broadcast binary    | 1100 0000 . 1010 1000 . 0000 0001 . 1111 1111 |
| Broadcast address   | 192 . 168 . 1 . 255                           |
| Range               | 192 . 168 . 1 . 1 - 192 .168 . 1 . 254        |
| Number of hosts     | 254                                           |

#### Another example

IP address: 10 . 11 . 12 . 13 / 16  
Subnet mask: 255 . 255 . 0 . 0

10 . 11 . 12 . 13 = 0000 1010 . 0000 1011 . 0000 1100 . 0000 1101  
255 . 255 . 0 . 0 = 1111 1111 . 1111 1111 . 0000 0000 . 0000 0000

Bitwise `AND` = 0000 1010 . 0000 1011 . 0000 0000 . 0000 0000

Subnet address = 10 . 11 . 0 . 0

Broadcast binary = 0000 1010 . 0000 1011 . 1111 1111 . 1111 1111

Broadcast address = 10 . 11 . 255 . 255

Range = 10 . 11 . 0 . 1 - 10 . 11 . 255 . 254

Number of hosts = 2<sup>16</sup> - 2 = 65534

## Practical use

### Creating subnet

Assume we have been given the IP range 192.168.0.0 /24 and have been asked to make this into 6 networks.

Firstly, 6 is not a power of 2, and we know the significant digits in binary work in powers of 2. So we could divide this up into 2, 4 or 8 evenly sized networks, but not 6. So let's go with 8 because it gives at least the required number.

By shifting the subnet mask to the right, we halve (powers of 2) the range of hosts and double (powers of 2) the number of networks with each bit.

| Subnet | Binary                                        |
|--------|-----------------------------------------------|
| /24    | 1111 1111 . 1111 1111 . 1111 1111 . 0000 0000 |
| /25    | 1111 1111 . 1111 1111 . 1111 1111 . 1000 0000 |
| /26    | 1111 1111 . 1111 1111 . 1111 1111 . 1100 0000 |
| /27    | 1111 1111 . 1111 1111 . 1111 1111 . 1110 0000 |

So what does 192.168.0.0 /27 actually give us?

| Network           | Last Octet | Broadcast     | Last Octet |
|-------------------|------------|---------------|------------|
| 192.168.0.0 /27   | 0000 0000  | 192.168.0.31  | 0001 1111  |
| 192.168.0.32 /27  | 0010 0000  | 192.168.0.63  | 0011 1111  | 
| 192.168.0.64 /27  | 0100 0000  | 192.168.0.95  | 0101 1111  |
| 192.168.0.96 /27  | 0110 0000  | 192.168.0.127 | 1001 1111  |
| 192.168.0.128 /27 | 1000 0000  | 192.168.0.159 | 1001 1111  |
| 192.168.0.160 /27 | 1010 0000  | 192.168.0.191 | 1011 1111  |
| 192.168.0.192 /27 | 1100 0000  | 192.168.0.223 | 1101 1111  |
| 192.168.0.224 /27 | 1110 0000  | 192.168.0.255 | 1111 1111  | 

This process is called subnetting.

It is the process of dividing a larger network up into smaller networks.

The reverse is called *supernetting*. The process of merging smaller networks into larger ones. It is a technique particularly useful in *route aggregation*.

There are some rules for supernetting. Just like subnetting gives us evenly sized consecutive networks numbering in powers of 2, supernetting likewise requires the reverse.

## Supernetting

### Rules

1. The IP ranges must be consecutive
	- Since IP addressing works by providing a starting point (the network address) and a range (defined by the subnet mask) there is no way to define a *range* that starts at one point, goes for part of a defined range and then stops only to start later on, at some random point
	- The join must result in a continuous range
2. They must be the same size
	- Our ranges work in powers of 2, so the ranges to be merged must be the same, or binary multiples of the smallest size
		- So the ranges must be the same or 2, 4, 8, 16 etc. times larger than the smallest range
3. The ranges to be merged must number a power of 2 of the smallest range
	- This ties back to the second rule
	- Each time we shift the subnet mask to the left by 1 bit, we double the number of hosts in the range
	- So if we have 3 ranges to merge, we simply cannot do that
	- The first shift will double the range, the second shift will double that again (so x4)

![ranges incorrect](http://snag.gy/BEF2J.jpg)

**Note:** If the third range was twice the size of the other two ranges, we would count it as two ranges.

![ranges twice size](http://snag.gy/NS2s7.jpg)

Finally, these new networks have to fall on the binary boundary. Whatever the new host range is, it has to start from all `0`. As such, while 192.168.0.32 /27 and 192.168.0.64 /27 are consecutive, are the same size and 2 networks is a power of 2.... the problem is that 192.168.0.32 is not on a binary boundary.

![shift subnet left](http://snag.gy/T8HGc.jpg)

### Creating supernet

Back to the previous example when creating subnets, the original requirement was to create 6 networks. During the subnet we created 8 networks, but can use supernetting to create the required 6 networks.

![merge supernet](http://snag.gy/H6DsV.jpg)

So what does moving the subnet mask in the last two pairs of ranges give us?

| Network           | Last Octet | Broadcast     | Last Octet |
|-------------------|------------|---------------|------------|
| 192.168.0.0 /27   | 0000 0000  | 192.168.0.31  | 0001 1111  |
| 192.168.0.32 /27  | 0010 0000  | 192.168.0.63  | 0011 1111  |
| 192.168.0.64 /27  | 0100 0000  | 192.168.0.95  | 0101 1111  |
| 192.168.0.96 /27  | 0110 0000  | 192.168.0.127 | 1001 1111  |
| 192.168.0.128 /26 | 1000 0000  | 192.168.0.191 | 1011 1111  |
| 192.168.0.192 /26 | 1100 0000  | 192.168.0.255 | 1111 1111  |


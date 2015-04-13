# Week 6 tutorial

## Objectives

- To learn the benefits of subnets in a network
- To learn about the different classes of networks
- To learn subnet calculations
- To learn about supernets

### By end of the workshop you should be able to

- Explain the benefits of implementing multiple subnets in a network
- Be able to distinguish between class A, B and C networks
- Determine key information on a network
	- Binary calculations
	- Class
	- Network prefix determination
	- Host number determination
	- Number of subnets in network
	- Number of hosts per subnet
	- Host IP address range
	- Broadcast address
	- Explain and determine a supernet comprised of subnets

## Preface: What are subnets?

A subnet is a logical division of a network by increasing the number of bits related to the network prefix. An IP address is comprised of two parts, the **Network Prefix** and the **Host Number**. The Network Prefix is described as the common, identical, most-significant bit-group in the IP address. This means that the Network Prefix is the part of the IP address which does not change, and it is specified by the subnet mask applied to the network. The Host Number occupies the field called a Rest Field which is the unique identifier for that particular host, or network interface.

The Network Prefix is specified by the bit-length of the prefix, and is usually placed at the end of the network in a numeric form **between 0 and 32**, which is the Classless Inter-Domain Routing **CIDR** number. For example, 192.168.0.0/24 is the prefix for a networking starting at that address. These four numbers specify how much of the address is the Network Prefix. As IP addresses are comprised of 4 sets of 8 bits, having a /24 means that the first 24 bits of an IP address is its Network Prefix.

>192.168.0.1/24:  
Network Prefix: 192.168.0  
Host Number: 1

The /24 represents a subnet mask of 255.255.255.0, which is calculated by adding the number of bits turned **on** in each of the four numbers.

>8 + 8 + 8 + 0 = 24

### Benefits of subnets

The benefits of a subnet vary from each implementation. When in a large organisation or for the Internet, the allocation of address spaces are crucial to optimise the number of clients available for use in the network. It can also increase routing efficiency and allows a more modular management of the network as a whole (for security or routing purposes). They can also be used to improve the arrangement of the logical hierarchy of a network, providing a method to partition the network into branches.

## Binary: Counting and converting

When counting in binary, there are only two values, 0 and 1. As we read from right to left of the binary sequence we double the value of the previous bit (a bit is a single number). In networking, we always deal with 8-bit values, leading us to a range of numbers from 0 to 255. For the valye of 0, the binary is `0000 0000`. For 255, the binary is `1111 1111`, and for half-way at 128, we have `1000 0000`. The binary values for a subnet mask will always be a block of 1s followed by a block of 0s. The 0s designate that the following bits are the host number.

To calculate the binary representation of the numbers, you can either use a calculator which can convert decimal to binary, or you can work it out manually. We'll work out how to determine the binary representation for 192.168.0.1 below.

To convert to binary from decimal, the simplest way is to know how to count in binary first: 0, 1, 2, 4, 8, 16, 32, 64, 128 etc. You simply keep doubling the value or work out 2<sup>n</sup> where n represents any number to apply as a power, ie. 2<sup>2</sup> = 4. The highest we'll need to use in networking is 128. Once you know the pattern of binary, you then take your decimal number, ie. 192 and compare it to the largest binary number, ie. 128. If it is equal to or larger than it, you can note down a 1 value, and subtract the binary nbumber from our decimal, ie. 192 - 128 = 64. Once you reach a decimal value that is smaller than the binary, simply note a 0 until it is once again larger. You then repeat this process, as seen below:

>192 > 128 therefore 192 - 128 = 64: 1  
64 = 64 therefore 64 - 64 = 0: 1  
0 < 32 therefore: 0  
0 < 16 therefore: 0  
0 < 8 therefore: 0  
0 < 4 therefore: 0  
0 < 2 therefore: 0  
0 < 1 therefore: 0

Then, arrange the binary from the first subtraction on the left to our final on the right and we have the binary code `1100 0000`, which is 192 in binary.

To go backwards from binary to decimal, simply add the binary value back to the decimal starting from the right, ie. for `1100 0000` it would be 64 + 128 = 192.

## Classes A, B, C

IP addresses are divided into three classes of addresses, and these are based on the leading, most-significant bits in the binary representation of the network address. The values are characterised as follows:

| Class | Leading bits | Size of Network Prefix | Size of Host Number | Start address | Last address    |
|-------|--------------|------------------------|---------------------|---------------|-----------------|
| A     | 0            | 8                      | 24                  | 0.0.0.0       | 127.255.255.255 |
| B     | 10           | 16                     | 16                  | 128.0.0.0     | 191.255.255.255 |
| C     | 110          | 24                     | 0                   | 192.0.0.0     | 223.255.255.255 |

There are more classes higher than these, but they are not defined and are uncommon to see. Today, classful addresses are only used in private networks, and not used on the Internet since the introduction of subnet masks.

## IPv4 subnetting: Network Prefix & Host Number

To determine the network prefix of a subnet, we need two pieces of information. The IP address and the subnet mask. To calculate the network prefix of an address, we perform a process called **bitwise AND** on the binary representation of the IP address compared to its subnet mask. A bitwise AND is the same as a **logical AND** working on the binary values bit-by-bit. The AND process is a method of determining if our value for the network prefix will be 1 or 0 for that bit. As the name suggests, the bit will be 1 only of that relevant bit is 1 in the IP address **AND** the subnet mask. If either of them are 0, or if both are 0, the resulting bit in the network prefix will be 0. The truth table below shows the outcomes.

| Subnet mask | IP address | AND |
|-------------|------------|-----|
| 0           | 0          | 0   |
| 0           | 1          | 0   |
| 1           | 0          | 0   |
| 1           | 1          | 1   |

### Calculating Network Prefix and Host Number

Convert IP address and subnet mask into binary. For example the address is 192.169.0.166, and subnet mask is 255.255.255.0.

Then you simpy need to AND the bit directly beneath the other to determine the network prefix and host number. The host number is any bits left over by the subnet mask (ie. where the subnet mask is **not** 255).

```
IP:            1100 0000 . 1010 1000 . 0000 0000 . 1010 0110 = 192.168.0.166
SubnetMask:    1111 1111 . 1111 1111 . 1111 1111 . 0000 0000 = 255.255.255.0
NetworkPrefix: 1100 0000 . 1010 1000 . 0000 0000 . 0000 0000 = 192.168.0.0
HostNumber:    0000 0000 . 0000 0000 . 0000 0000 . 1010 0110 = 0.0.0.166
```

Looking at the example above, we can see that by simply taking the first 3 numbers from the IP address, we have the Network Prefix, and the last number is the host number. But it is not always that simple. Let's change the subnet mask to 255.255.255.192.

```
IP:            1100 0000 . 1010 1000 . 0000 0000 . 1010 0110 = 192.168.0.166
SubnetMask:    1111 1111 . 1111 1111 . 1111 1111 . 1100 0000 = 255.255.255.192
NetworkPrefix: 1100 0000 . 1010 1000 . 0000 0000 . 1000 0000 = 192.168.0.128
HostNumber:    0000 0000 . 0000 0000 . 0000 0000 . 0010 0110 = 0.0.0.38
```

We now see that the Host Number has changed as the network prefix is now larger. By increasing the values in a subnet mask, we are splitting our network into smaller subnets. If we increased to 255.255.255.192/26, we have made four separate subnets, instead of the single network we originally had.

### Number of subnets and Hosts in a network

We can easily determine how many subnets and hosts per subnet exist by looking at the binary form of our subnet masks. The easiest way to do this is to look at how many bits are **borrowed** by the subnet mask in the last 8-bits of the address. Let's take the subnet mask of 255.255.255.0/24 and 255.255.255.192/26 for example.

```
255.255.255.0:   1111 1111 . 1111 1111 . 1111 1111 . 0000 0000
255.255.255.192: 1111 1111 . 1111 1111 . 1111 1111 . 1100 0000
```

Here we can visually see that 2 additional bits have been *borrowed* into the subnet mask when we go to the .192 mask. To determine how many subnets we now have, we can simply raise 2 to the power of this borrowed number, ie. 2<sup>4</sup> = 4. When using the subnet mask of 255.255.255.192, we have 4 possible subnets.

The network start address is the first available value in that subnet, so for 192.168.0.0/26, our start address is 192.168.0.0. This address is reserved and cannot be used. We then know that we have 82 hosts in this network and as such we can tell our last host address would be 192.168.0.62. Our host range therefore must be 192.168.0.1 - 192.168.0.62. The broadcast address would be 192.168.0.63. From this point, we can tell that our next subnet's start address is: 192.168.0.64.

## Supernets: What are they

A supernet is an IP network which has been formed by two or more subnets with common CIDR network prefixes. They are calculated by comparing the bit values of the subnets and finding a common bit-pattern, from which a new network prefix is determined.

A supernet is a method of reducing the number of networks contained in a routing table on a router, and therefore on the Internet routing tables. It allows multiple networks to be aggregated into one single supernet to be advertised to other routers.

It does have some risks in that each brand of router can implement it in their own way, it can create inefficient routes on the Internet as not all subnets may be contained in this supernet, and the ability to detect a routing loop is severely diminished.

### Supernet calculations

Supernet calculations are done in the same fashion as calculating the network prefix of a subnet. You compare the different subnet starting address and find where the common pattern finishes and then create a network with 0s replacing the remaining slots. You can then also use this to determine the new subnet mask. See example below:

>A router has the following networks connected to it:

>- 192.168.144.0
- 192.168.145.0
- 192.168.146.0
- 192.168.147.0
- 192.168.148.0

We need to convert these to binary values and then compare their higher order bits (left most bits) until we see the common pattern stop.

```
192.168.148.0 = 1100 0000 . 1010 1000 . 1001 0100 . 0000 0000
192.168.149.0 = 1100 0000 . 1010 1000 . 1001 0101 . 0000 0000
192.168.150.0 = 1100 0000 . 1010 1000 . 1001 0110 . 0000 0000
192.168.151.0 = 1100 0000 . 1010 1000 . 1001 0111 . 0000 0000
192.168.152.0 = 1100 0000 . 1010 1000 . 1001 1000 . 0000 0000
```

We can see that the common pattern ends after the first half of the third octet. We can then deduce that the supernet address will have this common pattern followed entirely by 0s, as we can see below.

```
1100 0000 . 1010 1000 . 1001 0000 . 0000 0000 = 192.168.144.0/20
```

Therefore, our summarised route is 192.168.144.0/20 with a subnet mask of 255.255.240.0.

We can see the risk involved with implementing this however, as this would also contain the networks 192.168.144.0, 192.168.145.0, 192.168.146.0 and 192.168.147.0, even though they are not connected to this router.

## Challenges

### 1:

What does CIDR stand for?

Classless inter-domain routing

### 2:

What is the Network Prefix?

A network prefix is the first allocated bits usually around /24 representing the network. Represented by /## (between 0 and 32) which indicates the number of bits at the **start** of a binary IP address allocated as the Network prefix.

For example:

```
1100 0000 . 1010 1000 . 1001 0000 . 0000 0000 = 192.168.144.0/20
```

The first 20 bits in this address is the Network prefix.

### 3:

What is the Host Number?

A host number is the remaining bits in a network address after determining the network prefix.

### 4:

Convert the following numbers into binary:

1. 172
	- 1010 1100
2. 224
	- 1110 0000
3. 48
	- 0011 0000
4. 101
	- 0110 0101
5. 207
	- 1100 1111

### 5:

Convert the following binary values into numbers:

1. 1010 0101
	- 165
2. 0110 1001
	- 105
3. 0110 0011
	- 99
4. 1111 0001
	- 241
5. 1110 1011
	- 235

### 6:

Convert the following IP addresses & CIDR subnet masks into binary and find the Network Prefix and Host Number.

#### 6.1:

```
IP:            0000 1010 . 0000 0000 . 0000 0000 . 0001 0000 = 10.0.0.16 / 27
SubnetMask:    1111 1111 . 1111 1111 . 1111 1111 . 1110 0000 = 255.255.255.244
NetworkPrefix: 0000 1010 . 0000 0000 . 0000 0000 . 0000 0000 = 10.0.0.0
HostNumber:    0000 0000 . 0000 0000 . 0000 0000 . 0001 0000 = 0.0.0.16
```

#### 6.2:

```
IP:            1010 1100 . 0001 0000 . 0000 1000 . 1001 1011 = 172.16.8.155 / 26
SubnetMask:    1111 1111 . 1111 1111 . 1111 1111 . 1100 0000 = 255.255.255.192
NetworkPrefix: 1010 1100 . 0001 0000 . 0000 1000 . 1000 0000 = 172.16.8.128
HostNumber:    0000 0000 . 0000 0000 . 0000 0000 . 0001 1011 = 0.0.0.27
```

#### 6.3:

```
IP:            1100 0000 . 1010 1000 . 0001 0111 . 0010 1100 = 192.168.23.44 / 24
SubnetMask:    1111 1111 . 1111 1111 . 1111 1111 . 0000 0000 = 255.255.255.0
NetworkPrefix: 1100 0000 . 1010 1000 . 0001 0111 . 0000 0000 = 192.168.23.0
HostNumber:    0000 0000 . 0000 0000 . 0000 0000 . 0010 1100 = 0.0.0.44
```

#### 6.4:

```
IP:            1100 1001 . 0110 1110 . 0010 0001 . 0001 0010 = 201.110.33.18 / 29
SubnetMask:    1111 1111 . 1111 1111 . 1111 1111 . 1111 1000 = 255.255.255.248
NetworkPrefix: 1100 1001 . 0110 1110 . 0010 0001 . 0001 0000 = 201.110.33.16
HostNumber:    0000 0000 . 0000 0000 . 0000 0000 . 0000 0010 = 0.0.0.2
```

### 7:

Looking at the following binary subnet masks, how many subnets and hosts per subnet will there be?

#### 7.1:

```
1111 1111 . 1111 1111 . 1111 1111 . 0000 0000 = 255.255.255.0
Subnets: 2^0 = 1
Hosts: 2^8 - 2 = 254
```

#### 7.2:

```
1111 1111 . 1111 1111 . 1111 1111 . 1111 0000 = 255.255.255.240
Subnets: 2^4 = 16
Hosts: 2^4 - 2 = 14
```

#### 7.3:

```
1111 1111 . 1111 1111 . 1111 1111 . 1100 0000 = 255.255.255.192
Subnets: 2^2 = 4
Hosts: 2^6 - 2 = 62
```

#### 7.4:

```
1111 1111 . 1111 1111 . 1111 1111 . 1111 1100 = 255.255.255.252
Subnets: 2^6 = 64
Hosts: 2^2 - 2 = 2
```

### 8:

Looking at the following IP addresses, determine the network start address, IP range and broadcast address for each of their respective subnets.

#### 8.1:

```
IP:            1100 0000 . 1010 1000 . 0000 0000 . 0010 1101 = 192.168.0.45 / 24
SubnetMask:    1111 1111 . 1111 1111 . 1111 1111 . 0000 0000 = 255.255.255.0
NetworkPrefix: 1100 0000 . 1010 1000 . 0000 0000 . 0000 0000 = 192.168.0.0

Hosts: 2^8 - 2 = 254
NetworkStart:  1100 0000 . 1010 1000 . 0000 0000 . 0000 0001 = 192.168.0.1
NetworkEnd:    1100 0000 . 1010 1000 . 0000 0000 . 1111 1110 = 192.168.0.254
Broadcast:     1100 0000 . 1010 1000 . 0000 0000 . 1111 1111 = 192.168.0.255
```

#### 8.2:

```
IP:            1100 0000 . 1010 1000 . 0000 0000 . 0010 1101 = 192.168.0.45 / 25
SubnetMask:    1111 1111 . 1111 1111 . 1111 1111 . 1000 0000 = 255.255.255.128
NetworkPrefix: 1100 0000 . 1010 1000 . 0000 0000 . 0000 0000 = 192.168.0.0

Hosts: 2^7 - 2 = 126
NetworkStart:  1100 0000 . 1010 1000 . 0000 0000 . 0000 0001 = 192.168.0.1
NetworkEnd:    1100 0000 . 1010 1000 . 0000 0000 . 0111 1110 = 192.168.0.126
Broadcast:     1100 0000 . 1010 1000 . 0000 0000 . 0111 1111 = 192.168.0.127
```

#### 8.3:

```
IP:            1100 0000 . 1010 1000 . 0000 0101 . 1000 0101 = 192.168.5.133 / 26
SubnetMask:    1111 1111 . 1111 1111 . 1111 1111 . 1100 0000 = 255.255.255.192
NetworkPrefix: 1100 0000 . 1010 1000 . 0000 0101 . 1000 0000 = 192.168.5.128

Hosts: 2^6 - 2 = 62
NetworkStart:  1100 0000 . 1010 1000 . 0000 0101 . 1000 0001 = 192.168.5.129
NetworkEnd:    1100 0000 . 1010 1000 . 0000 0000 . 1011 1110 = 192.168.5.190
Broadcast:     1100 0000 . 1010 1000 . 0000 0000 . 1011 1111 = 192.168.5.191
```

#### 8.4:

```
IP:            0000 1010 . 0000 0000 . 0000 0000 . 1100 0101 = 10.0.0.197 / 27
SubnetMask:    1111 1111 . 1111 1111 . 1111 1111 . 1110 0000 = 255.255.255.224
NetworkPrefix: 0000 1010 . 0000 0000 . 0000 0000 . 1100 0000 = 10.0.0.192

Hosts: 2^5 - 2 = 30
NetworkStart:  0000 1010 . 0000 0000 . 0000 0000 . 1100 0001 = 10.0.0.193
NetworkEnd:    0000 1010 . 0000 0000 . 0000 0000 . 1101 1110 = 10.0.0.222
Broadcast:     0000 1010 . 0000 0000 . 0000 0000 . 1101 1111 = 10.0.0.223
```

## 9:

What is the summary address for the following /24 routes?

```
172.16.18.0 = 1010 1100 . 0001 0000 . 0001 0010 . 0000 0000
172.16.19.0 = 1010 1100 . 0001 0000 . 0001 0011 . 0000 0000
172.16.20.0 = 1010 1100 . 0001 0000 . 0001 0100 . 0000 0000
172.16.21.0 = 1010 1100 . 0001 0000 . 0001 0101 . 0000 0000
172.16.25.0 = 1010 1100 . 0001 0000 . 0001 1001 . 0000 0000

Super		= 1010 1100 . 0001 0000 . 0001 0000 . 0000 0000
			= 172.16.16.0/20

NetworkPrefix: 1010 1100 . 0001 0000 . 0001 0000 . 0000 0000 = 172.16.16.0/20
SubnetMask:    1111 1111 . 1111 1111 . 1111 0000 . 0000 0000 = 255.255.240.0
Subnets: 2^4 = 16

Supernet includes: 16 + 16 - 1 = 31
172.16.16.0
172.16.17.0
172.16.18.0
172.16.19.0
172.16.20.0
172.16.21.0
172.16.22.0
172.16.23.0
172.16.24.0
172.16.25.0
172.16.26.0
172.16.27.0
172.16.28.0
172.16.29.0
172.16.30.0
172.16.31.0
```

## 10:

What networks are contained in the following route summary?  
10.100.96.0/20

```
NetworkPrefix: 0000 1010 . 0110 0100 . 0110 0000 . 0000 0000 = 10.100.96.0/20
SubnetMask:    1111 1111 . 1111 1111 . 1111 0000 . 0000 0000 = 255.255.240.0
Subnets: 2^4 = 16

Supernet includes: 96 + 16 - 1 = 111
10.100.96.0
10.100.97.0
10.100.98.0
10.100.99.0
10.100.100.0
10.100.101.0
10.100.102.0
10.100.103.0
10.100.104.0
10.100.105.0
10.100.106.0
10.100.107.0
10.100.108.0
10.100.109.0
10.100.110.0
10.100.111.0
```

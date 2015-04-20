# DHCP and VLAN configuration

## Task 4

### Part 2

#### Splitting subnets

- Allocated subnet 172.16.0.0/24
	- Mask 255.255.255.0
- Need to split into 4 subnets
	- /24
		- 1 subnet
		- 256 addresses
			- 254 hosts
			- 1 network address
			- 1 broadcast address
	- /25
		- 2 subnets
		- 128 addresses each subnet
			- 126 hosts
			- 1 network address
			- 1 broadcast address
	- /26
		- 4 subnets
		- 64 addresses each
			- 62 hosts
			- 1 network address
			- 1 broadcast address

Subnet starts at 172.16.0.0/26

```
Subnet1: 172.16.0.0/26 + 64 for next subnet
Subnet2: 172.16.0.64/26 + 64 for next subnet
Subnet3: 172.16.0.128/26 + 64 for next subnet
Subnet4: 172.16.0.192/26
```

Broadcast address will always be the last valid address in that subnet. ie. Start address of next subnet - 1.

```
Subnet1 broadcast: 172.16.0.63
Subnet2 broadcast: 172.16.0.127
Subnet3 broadcast: 172.16.0.191
Subnet4 broadcast: 172.16.0.255
```

If next subnet is required and last broadcast address is 172.16.0.255:  
Next subnet would start at 172.16.1.0/26

#### Assignment tip

Too many VLANs in assignment to follow this method. Instead:

Find VLAN with max number of hosts and structure subnets to suit that VLAN. ie. If 48 devices in one VLAN, then use /26 which has 64 addresses per subnet.

### Part 3

#### Default router

To create DHCP pools, we need to create each subnet's default router. This is the port that the devices can use to leave their current network or subnet.

In this example, it is the port that you connect the DSL modem to. We'll assign a default-router as the first address in each of the networks. This would mean our subnets individual default routers are:

```
Subnet1 default-router: 172.16.0.1/26
Subnet2 default-router: 172.16.0.65/26
Subnet3 default-router: 172.16.0.129/26
Subnet4 default-router: 172.16.0.193/26
```

Create DHCP pools in packet tracer. See packet tracer commands.

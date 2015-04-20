# CSG1105 A2 notes

## Subnet

Allocated subnet: 10.0.0.0/21

```
IP:				0000 1010 . 0000 0000 . 0000 0000 . 0000 0000 = 10.0.0.0/21
SubnetMask:		1111 1111 . 1111 1111 . 1111 1000 . 0000 0000 = 255.255.248.0

Subnets
= 2^5
= 32

Hosts
= 2^11 - 2
= 2046
```

### Subnet split

#### VLAN

VLAN max hosts: Wireless 31 + 9 WAP

Selecting /26 for 64 hosts.

Subnet mask: 255.255.255.192

#### VLAN Map

ADSL/Internet
10.0.0.1

200 Server: 10.0.0.64/26  
default-router: 10.0.0.65

300 Reception: 10.0.0.128/26  
default-router: 10.0.0.129

400 Orders: 10.0.0.192/26  
default-router: 10.0.0.193

500 Production: 10.0.1.0/26  
default-router: 10.0.1.1

550 Design: 10.0.1.64/26  
default-router 10.0.1.65

600 Finance: 10.0.1.128/26  
default-router: 10.0.1.129

750 Conference: 10.0.1.192/26  
default-router: 10.0.1.193

800 Management: 10.0.2.0/26  
default-router: 10.0.2.1

850 Research: 10.0.2.64/26  
default-router: 10.0.2.65

900 Wireless: 10.0.2.128/26  
default-router: 10.0.2.129

950 Secret: 10.200.0.0/16  
Subnet mask: 255.255.0.0  
default-router: 10.200.0.1

Modified duplicate VLAN numbers  
ie. Orders/Reception, Wireless/Secret

```
Secret

IP:				0000 1010 . 1100 1000 . 0000 0000 . 0000 0000 = 10.200.0.0/16
SubnetMask:		1111 1111 . 1111 1111 . 0000 0000 . 0000 0000 = 255.255.0.0
```

## References

[![youtube1](http://img.youtube.com/vi/CAQcPyENCK8/0.jpg)](http://www.youtube.com/watch?v=CAQcPyENCK8)

[![youtube2](http://img.youtube.com/vi/GvYfi-mmtmA/0.jpg)](http://www.youtube.com/watch?v=GvYfi-mmtmA)

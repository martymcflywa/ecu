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

#### VLANS

VLAN max hosts: Wireless 31 + 9 WAP

Selecting /26 for 64 hosts.

- 200 Server: 10.0.0.0/26
- 300 Reception: 10.0.0.64/26
- 400 Orders: 10.0.0.128/26
- 500 Production: 10.0.0.192/26
- 550 Design: 10.0.1.0/26
- 600 Finance: 10.0.1.64/26
- 750 Conference: 10.0.1.128/26
- 800 Management: 10.0.1.192/26
- 850 Research: 10.0.2.0/26
- 900 Wireless: 10.0.2.64/26
- 950 Secret: 10.200.0.0/16
- Total: 11 VLANS

```
Secret

IP:				0000 1010 . 1100 1000 . 0000 0000 . 0000 0000 = 10.200.0.0/16
SubnetMask:		1111 1111 . 1111 1111 . 0000 0000 . 0000 0000 = 255.255.0.0
```

## References

[![youtube1](http://img.youtube.com/vi/CAQcPyENCK8/0.jpg)](http://www.youtube.com/watch?v=CAQcPyENCK8)

[![youtube2](http://img.youtube.com/vi/GvYfi-mmtmA/0.jpg)](http://www.youtube.com/watch?v=GvYfi-mmtmA)

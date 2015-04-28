# 550 DESIGN DHCP

B1L1CoreSwitch troubleshooting map:

- SERVER 200 VLAN
	- 10.0.0.64/26
	- port f0/2 - 9
- DESIGN 550 VLAN
	- 10.0.1.64/26
	- port f0/18
- RESEARCH 850 VLAN
	- 10.0.2.64/26
	- port f0/23

## Console commands

### Setting up DHCP pools

```
B1L1CoreSwitch#conf t
Enter configuration commands, one per line.  End with CNTL/Z.
B1L1CoreSwitch(config)#ip dhcp pool SERVER
B1L1CoreSwitch(dhcp-config)#network 10.0.0.64 255.255.255.192
B1L1CoreSwitch(dhcp-config)#default-router 10.0.0.65
B1L1CoreSwitch(dhcp-config)#exit
B1L1CoreSwitch(config)#ip dhcp pool DESIGN
B1L1CoreSwitch(dhcp-config)#network 10.0.1.64 255.255.255.192
B1L1CoreSwitch(dhcp-config)#default-router 10.0.1.65
B1L1CoreSwitch(dhcp-config)#exit
B1L1CoreSwitch(config)#ip dhcp pool RESEARCH
B1L1CoreSwitch(dhcp-config)#network 10.0.2.64 255.255.255.192
B1L1CoreSwitch(dhcp-config)#default-router 10.0.2.65
B1L1CoreSwitch(dhcp-config)#exit
```

### Tagging ports to VLANs

```
B1L1CoreSwitch#conf t
Enter configuration commands, one per line.  End with CNTL/Z.
B1L1CoreSwitch(config)#int range f0/2 - 9
B1L1CoreSwitch(config-if-range)#switchport mode access
B1L1CoreSwitch(config-if-range)#switchport access vlan 200
B1L1CoreSwitch(config-if-range)#exit
B1L1CoreSwitch(config)#int f0/18
B1L1CoreSwitch(config-if)#switchport mode access
B1L1CoreSwitch(config-if)#switchport access vlan 550
B1L1CoreSwitch(config-if)#exit
B1L1CoreSwitch(config)#int f0/23
B1L1CoreSwitch(config-if)#switchport mode access
B1L1CoreSwitch(config-if)#switchport access vlan 850
B1L1CoreSwitch(config-if)#exit
```

### Configuring VLANs

```
B1L1CoreSwitch#conf t
Enter configuration commands, one per line.  End with CNTL/Z.
B1L1CoreSwitch(config)#int vlan 200
B1L1CoreSwitch(config-if)#ip address 10.0.0.65 255.255.255.192
B1L1CoreSwitch(config-if)#exit
B1L1CoreSwitch(config)#int vlan 550
B1L1CoreSwitch(config-if)#ip address 10.0.1.65 255.255.255.192
B1L1CoreSwitch(config-if)#exit
B1L1CoreSwitch(config)#int vlan 850
B1L1CoreSwitch(config-if)#ip address 10.0.2.65 255.255.255.192
B1L1CoreSwitch(config-if)#exit
```

### Enable routing

```
B1L1CoreSwitch#conf t
Enter configuration commands, one per line.  End with CNTL/Z.
B1L1CoreSwitch(config)#ip routing
B1L1CoreSwitch(config)#
```

WORKS!!!!

# Packet tracer commands

## Switch config

#### Enable privileged mode

```
Switch> enable
Switch#
```

#### Enable configuration mode through terminal

```
Switch# configure terminal
Switch(config)#
```

#### Set hostname

```
Switch(config)# hostname <NAME>
SwitchName(config)#
```

#### Set clock

```
Switch(config)# clock timezone AWST 8 0
// <name> +hour +minute from GMT
```

#### Set banner MOTD

Can be multiple lines, use `}` to finish message.

```
Switch(config)# banner motd }
Enter TEXT message. End with the character '}'.
```

#### Save running config to NVRAM

```
Switch(config)# write memory
```

#### Exit configuration mode

```
Switch(config)# exit
```

## Router config

#### Disable domain lookup

Stops router from attempting to translate typo's as domain names

```
Router# no ip domain-lookup
```

#### Configure specific port

Must be in privileged mode `enable`  
`0/0` is specified module/port

```
Router(config)# interface FastEthernet 0/0
Router(config-if)#
```

#### Set IP address for port

IP address first then subnet mask

```
Router(config-if)# ip address 192.168.0.250 255.255.255.0
```

#### Enable all ports

```
Router(config-if)# no shutdown
```

### DHCP setup

#### Enter pool configuration

```
Router(config)# ip dhcp pool NAME
Router(dhcp-config)#
```

#### Assign subnet to pool

```
Router(dhcp-config)# network 192.168.0.0 255.255.255.0
```

#### Assign default gateway to pool

```
Router(dhcp-config)# default-router 192.168.0.250
```

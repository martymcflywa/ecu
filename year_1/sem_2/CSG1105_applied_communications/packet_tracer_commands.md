# Packet tracer commands

## Switch config

#### Enable privileged mode

``` bash
Switch> enable
Switch#
```

#### Enable configuration mode through terminal

``` bash
Switch# configure terminal
Switch(config)#
```

#### Set hostname

``` bash
Switch(config)# hostname <NAME>
SwitchName(config)#
```

#### Set clock

``` bash
Switch(config)# clock timezone AWST 8 0
// <name> +hour +minute from GMT
```

#### Set banner MOTD

Can be multiple lines, use `}` to finish message.

``` bash
Switch(config)# banner motd }
Enter TEXT message. End with the character '}'.
```

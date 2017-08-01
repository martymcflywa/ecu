# Introduction to mobile applications development

## Summary

- Why mobile apps
- Mobile devices
- Mobile OS
- Mobile dev tools

## Why mobile apps

- Large userbase
- Estimates
    - Worth $50 billion USD
    - 10% of IT jobs in Australia
    - Userbase growing

### Mobile app pros

- Always available
- Quick, easy UI
- Integrates with
    - Email
    - Address bok
    - Calendar
    - Social media
- Advertising/marketing
    - Users spend lots of time using apps
- Access to camera and mic
- Casual games
- Location aware

## Mobile devices

### Typical

- Small
    - Handheld
- Mobile
    - Can be moved place to place
- Computing device
- Touch input
- Wireless connectivity

### Examples

- Smart phones
- Tablets
- Wearables
    - Smart watch
    - Head mounted displays
    - Fitbits
- Personal digital assistants (PDAs)
- Handheld consoles

## Mobile device components

### Input

- Touch screen
- Stylus
- Keyboard
- Buttons
- Audio
- Accelerometer
    - Gravity sensor
    - Motion
    - Tilt
- Compass
- GPS
- Camera
    - Video
    - Still

### I/O

- Wireless
    - Wifi
    - Bluetooth
    - NFC
- I/O ports
    - HDMI
    - USB
    - Firewire (how old is this lecture?)

### Output

- Display
- Audio
- Lights
- Vibration

### Power

- Rechargeable battery
- Small backup battery

### Internals

![samsung galaxy s7](https://snag.gy/yufZjW.jpg)

CPU, other processes, memory and interfaces may be combined on a System on a Chip (SoC).

#### CPU

- Runs programs
    - OS
    - Apps

#### Other processors

- Graphics
- Audio

#### Memory

- ROM / flash
    - OS
    - Apps
    - Slow
    - Persistent
- RAM
    - Running programs
    - Fast/er
    - Volatile

## Mobile OS

The system software that manages computer hardware and software resources. Provides common services for computer programs.

- Android
    - Google
- iOS
    - Apple
- Windows 10 Mobile
    - Microsoft
- Others
    - Blackberry 10

### Android

- 62% market share
    - 2016
- Developed by Google
- Based on Linux kernel
- Devices
    - Smartphones
    - Tablets
    - Others
- Touch based UI
    - Gestures
- Google Play Store
- Apps written in Java
- Current version
    - 7 Nougat

### iOS

- 28.4% market share
    - 2016
- Developed by Apple
- Based on Darwin core OS
    - Unix
- Devices
    - iPhone
    - iPod touch
    - iPad
    - AppleTV
- Touch based UI
    - Gestures
    - Multitouch
- Apple App Store
- Apps written in Swift or Objective-C
- Current version
    - iOS 10.3.3

### Windows 10 Mobile

- 4% market share
    - 2016
- Developed by Microsoft
- Closed source/proprietary
- Devices
    - Windows Phone
    - Surface
- Similar UI to Windows desktops
- Microsoft Store
- Apps written using Visual Studio
    - C#
    - VB
    - Visual C++
- Current version
    - Redstone?

## Native vs. web

- Alternative deployment option
    - Mobile web / web 3.0
- Apps run within browser
- Tradeoffs
    - Access to UI
        - Better as native
    - Access to hard/software
        - Better as native
    - Single codebase, multiplatform
        - Don't need multiple versions for different OS
        - Frequent updates
- HTML5/jQuery closing gap in functionality

## Mobile app architecture

- Often use remote services
    - Backend hosted online
    - Frontend on device
- Unit will concentrate on mobile device side
    - Briefly touch on backend
- Advanced apps/issues covered in CSP3108
    - Advanced mobile applications development

## SDKs

### Android SDK

- Native Android apps
- Android Studio
- Java based
- Includes
    - Debuggers
    - Libraries
    - Handset emulator

### iOS SDK

- Native iOS apps
- Xcode
- Objective-C or Swift based
- Includes
    - Debugger
    - Libraries
    - Handset emulator

### Corona SDK

- Cross platform
    - Single codebase for
        - iOS
        - Android
        - NOOK
        - Win Phone 8
        - Win desktop apps
- Corona Editor IDE
- Lua based
    - Simple to learn
- Includes
    - Debugger
    - Libraries
    - Handset emulator
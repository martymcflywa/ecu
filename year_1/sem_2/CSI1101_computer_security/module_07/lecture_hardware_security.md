# Hardware security

## The earliest computers

- Initially all computer security issues were hardware security issues
	- Systems occupied entire rooms
	- Security was controlled by controlling access to the room
- Today, protecting computers is more complex as they have become
	- Increasingly mobile
	- Interconnected
	- Vast array of functions

## Threats against hardware

- Theft
- Environmental
	- Power supply
	- Operating environment
- Physical destruction

## Theft of hardware

- Computer hardware is an attractive target for thieves
- The portability of many modern systems increases their attractiveness as a target
- Theft of systems can be a problem not only because of the loss of the hardware
	- But importantly because of the loss of data
- In many cases theft of hardware might be the easiest way to steal data
	- Why break into a network, dodge intrusion detection, defeat operating system controls etc. when it is often easier for an attacker to steal an unattended laptop?
- Other times the hardware itself might be the target

### Remedies for theft

- Simple labelling/tagging of equipment
- Use of a locking mechanism to attach the device to a large object
	- ie. Desk
- Using microdot technology to mark it
- Physical storage of portables
- Encryption of disk at risk
	- EFS
	- Truecrypt

### Physical access controls

- Lockable office spaces
- Access cards to monitor/restrict who goes in or out of facility
- Where appropriate, strategically placed CCTV
	- ie. Egress/Ingress points
- Security cables for laptops

## Environmental threats

### Power supply

- Electricity
	- Any spike or stability issues in electricity can cause damage to digital devices
	- It is vital that equipment has a steady uninterrupted and clean power supply
	- Lightning strikes can be a problem, particularly on UTP networks

#### Remedies for electrical problems

- Use of Uninterruptible Power Supply (UPS)
	- Use an active UPS not a passive UPS!
	- Use a UPS that allows sufficient time to shutdown a computer in an orderly fashion
	- Test it regularly!

### Temperature

- Keep ambient temperature < 20*C
- Do NOT use evaporative air conditioning
	- Adds water to the air
- Dust filters on air conditioning units
- Alarms for when air conditioning fails

## Hardware protection examples

- Controlled access to facilities
	- ie. Swipe access cards

![swipe access cards](http://snag.gy/DqraX.jpg)

- Security cables
	- Could easily be defeated by an attacker with a set of bolt cutters

![security cables](http://snag.gy/RIk1X.jpg)

- Audible alarms
	- Set off when item is moved or removed from premises
	- Often disarmed with PIN or key
- Proximity alarms
	- User carries a receiver and an alarm is raised if the laptop and the user are more than a certain distance apart

![audible alarms](http://snag.gy/wIY86.jpg)

## Hardware encryption

- Encrypted hard disks can limit the damage caused by a stolen system
- Hard drives could be encrypted/decrypted on the fly by main-boards or by dedicated cards
- Secure Systems here in WA produces a high grade encryption device

![hardware encryption](http://snag.gy/hRHv2.jpg)

### Hardware vs. software encryption

- Hardware based encryption
	- Uses a dedicated processor located on the encrypted drive
	- Processor contains a random number generator to generate an encryption key
		- Which the user's password will unlock
	- Increased system performance
	- Protects against cold boot attacks, malicious code
- Software based encryption
	- Shares computer resources to encrypt data with other programs on the computer
	- May require software updates
	- Susceptible to brute force attacks, memory attacks
	- Cost-effective in small application environments

## Physical destruction and damage

- Hardware could be damaged deliberately or accidentally
- How can you prevent an individual from physically harming your hardware?
- Defence is backups!

## Hardware threats

### Acoustic emissions

- Asonov and Agrawal published results in 2004 detailing how attackers could use an audio recording of a user typing on a keyboard to reconstruct what was typed
- Each keystroke produces different sounds and certain keys are pressed more than others
- After training an advanced neural network to recognize individual keys, their software recognized an average 79% of all keystrokes

### Hardware key loggers

- Hardware device designed to capture keystrokes
- Small
	- Designed to look like a USB adapter
- Connects in-line between a keyboard and a computer
- Captures ~2GB keystrokes typed at the keyboard
- Could be set and then retrieved by an attacker
- Captured keystrokes could be sent wirelessly

![hardware key loggers](http://snag.gy/y5Ymn.jpg)

## Hardware countermeasures

### Faraday bags, cages and rooms

- To block/limit EMF emissions through the air we can surround sensitive equipment with a metallic conductive shielding or mesh
- The holes in mesh are smaller than the wavelengths of the EMF radiation to block

![faraday bag](http://snag.gy/n1fe7.jpg)

## Reverse engineering

- Reverse engineering involves taking the final product, examining it and working back to its design through
	- Direct interrogation of the device by extracting an image of the software through an interface
		- Typically JTAG
	- Take the resultant image and performing a disassembly of code

### Jailbreaking

- iPhones/iPads, Android devices have been **jailbroken** as a result of reverse engineering the hardware/software or exploiting a vulnerability
- Jailbreaking may allow you to
	- Install custom operating systems
	- Find system vulnerabilities
	- Install/run non-approved software
	- Unlock additional features
- Jailbroken devices are high risk, why?
	- Little or no quality control
		- Jailbreak/Jailbreak app dev may include backdoor

## Computer forensics

- The process of obtaining information contained on an electronic medium such as hard drives, memory cards or RAM

### Data storage

- Data is stored on disk one entire sector at a time
	- A sector is usually 512 bytes
	- If you only use 1 byte, the system still provides the other 511 bytes for you
	- A sector is the smallest addressable unit on persistent storage
- To improve performance and efficiency, sectors are typically grouped into clusers
- A cluster is a fixed number of sectors
	- Must be a power of 2
- If you use 1 byte of a cluster, you have used the entire cluster

![sectors and clusters](http://snag.gy/8lWTe.jpg)

- Many clusters on a modern hard drive are unallocated
- Unallocated clusters may have been allocated earlier though
	- These clusters retain their data until they are reallocated to a new file
	- Thus deleted data is easily recovered
	- It make take days, weeks, months or even years before the data is overwritten

### Data recovery

- Data can be retrieved from persistent storage devices in a number of ways
- Once data is committed to magnetic storage, it is difficult to destroy
- Aside from reading data through software, data sometimes can also be retrieved through physical inspection of hardware using Scanning Electron Microscopy (SEM)
- Data recovery could be undertaken for a number of legitimate or non-legitimate reasons
	- To aid law enforcement in solving a crime
	- Industrial espionage
	- For research purposes
	- By criminals for identity theft

### Secure file deletion tools

- Secure file deletion tools can be used to ensure that data recovery is **difficult**
- Most work by overwriting data many times
	- 1, 3, 7 or 35 times using various bit patterns
- Can wipe files, free space, cluster tips
	- ie. Eraser, DBAN boot and NukeCD
- Erasing a hard drive properly can take days or weeks so people/organisations do not typically dispose of hard disks properly

#### Secure file deletion: Eraser

- An example of a freely available program
- End user can decide how many passes to use
- Typically 1-pass is sufficient for non-sensitive data

![eraser](http://snag.gy/zPlX6.jpg)

## Radio frequency identification (RFID)

- Small tags that communicate wirelessly
- Two categories
	- Active
		- These have their own transmitter and power supply
		- The power source is used to broadcast a signal to a reader
	- Passive
		- These tags have no battery
		- The tags draw power from the reader
			- Which sends out electromagnetic waves that induce a current in the tag's antenna

### RFID tag uses

- Can be used for a number of purposes
- Inventory management
	- Used to tag
		- Individual products
		- Pallets of products
- Tagging people?
- Marketing purposes?

## Backup strategies

- People typically recognise the importance of ongoing, reliable system backups
- However, people are also reluctant to perform this process
- Data could be deleted, corrupted or lost

### Backup issues

- Some questions need to be answered
	- What will be backed up
	- How often will backups be performed
	- Will a rotation strategy be used
	- What type of media will be used
	- Where will backups be stored
	- How will backups be protected
	- Plaintext or encrypted
	- Verification and logging of backups

### What will be backed up

- Identifying important information can be difficult even for a single PC
	- An end-user may perform a back up of important data from a PC and then format that same computer only to find that something important was not included in the backup
	- This can have disastrous consequences for a large organisation
- How many organisations even have a good idea of all the information they have?

### How often will backups be performed

- The more often data is backed up, the easier it is to recover from a loss of data
- However there is a trade off here
- Backups consume resources
	- Time
		- Machine and personnel
		- Quantity of backup media required
		- Potential network bandwidth
		- Investment in equipment

### Backup rotation

- Using a single re-usable medium and overwriting should never be done
- All backup media is prone to wear and tear
- Use multiple sets of media and rotate them
	- ie. Use 5 sets of backup media and rotate them over the course of a week
		- Mon - Fri
	- Then perform a full backup on a separate set of media twice a month

### Choice of media

- A number of factors should be considered when determining what type of media
	- Write once or re-writable
	- Cost of media
	- Longevity of media
	- Reliability of of media
	- Cost of hardware to read and write media
	- Cost and capability of backup software
	- Availability of media
		- Now and future
- Regardless of media, all backups should be encrypted

### Where to store backups

- Onsite
	- Useful for a localised failure
		- ie. Hard drive failure in a PC
	- However, if facility is destroyed, the backup may also be destroyed
		- ie. Building fire
- Offsite storage of some kind is essential
	- Geographically separate will protect against destruction of facility
	- Could be inconvenient in the event of a localised hardware failure
		- ie. Hard drive failure
- Both should be used

### Protection of backups

- Ideally, we should give backups the same level of protection as the primary source
- However this is often not done
	- ie. Backup tapes may be stored poorly
	- An attacker may specifically target the backup media
	- The more copies of backups that exists, the harder it is to control access/storage
	- Put them in a fireproof, high security safe or facility
	- Make sure they are encrypted

### Verification of backups

- Backups need to be verified
	- Are the backups actually being done
		- Is the backup policy being followed
	- Does the backed up data have integrity
	- Does the restore process work
		- Can we actually restore the backup
		- Have we tested this
	- Will we be able to restore the backup tomorrow
		- Next week
		- Next year
		- What about longer term archiving
	- Will the necessary hardware and software be available in future years
		- May need to
			- Archive hardware
			- Archive software
			- Archive machine

## Metadata in documents

- Sometimes organisations release documents or pictures to the public in a range of formats
	- PowerPoint
	- Word
	- Excel
- Often these documents contain not only the public data but also a range of sensitive metadata
	- Document owners
	- Creation, access and modification dates
	- URLs
	- Machine and server names
	- Geographical data
		- EXIF in images
	- Track changes

### Metadata scrubbing

- Many applications now allow you to remove comments and metadata
- Or simply save the material into a non-metadata format
- Use many of the utilities available to remove the metadata
- Turn off the location services on devices
	- ie. Geotagging on smartphones

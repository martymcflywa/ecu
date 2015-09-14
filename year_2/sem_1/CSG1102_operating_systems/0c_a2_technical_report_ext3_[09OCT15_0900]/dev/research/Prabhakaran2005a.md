# Analysis and Evolution of Journaling File Systems

Prabhakaran, V., Arpaci-Dusseau, A. C., & Arpaci-Dusseau, R. H. (2005). Analysis and Evolution of Journaling File Systems. In USENIX Annual Technical Conference (pp. 105–120). Retrieved from https://www.usenix.org/legacy/publications/library/proceedings/usenix05/tech/general/full_papers/prabhakaran/prabhakaran_html/main.html

```
Prabhakaran2005a
```

## Introduction

- Journaling
	- Before changes are committed to disk
	- "write-ahead log" (p. 105) is populated with information about pending updates
- Advantages
	- "Enables fast file recovery after a crash." (p. 105)
		- Compared to "scan based recovery (e.g via `fsck`)"

## The Ext3 File System

- Journaling filesystem
- "Data and metadata eventually placed into the standard ex2 structures" (p. 108)
	- "Fixed location structures" (p. 108)
- "Loosly based on FFS" (p. 108)
	- Fast File System
- Disk split into **block groups**
	- Each block contains
		- Bitmaps
		- Inode blocks
		- Data blocks
- Ext3 journal file itself is stored within the file system
	- Can also be stored on another device or partition
- Information about pending file system update is written to the journal
	- Enables efficient crash recovery
		- Transaction record is written first before changes committed to disk
		- Incomplete transactions can be reversed by scanning the journal log and redoing those actions to bring file system to a consistent state
- Journal file treated as circular buffer
	- Once modification committed to fixed location in ext2 structure
		- Journal space is reclaimed

### Journaling modes

- Writeback mode
- Ordered journaling mode
- Data journaling mode
- Mode selected during mounting of disk
	- Can be changed by remount

#### Writeback mode

- Only file system metadata is journaled
- Data blocks written directly to fixed locations
- Order between journal and fixed location data writes not enforced
- Consistent file system metadata
	- Cannot guarantee data block consistency

#### Ordered journaling mode

- Only metadata is journaled
- Data writes to disk occur before journal writes metadata
- Guarantees consistency of journal and data after recovery

#### Data journaling mode

- Journal records both metadata and data
	- Data written twice
		- Journal
		- Fixed ext2 location
- Same consistency guarantees as ordered journaling

### Transactions

- Disk updates grouped together as **compound transactions**
	- Periodically committed to disk

### Journal structure

- Additional metadata structures track list of journaled blocks
- **Journal superblock**
	- Tracks summary information for the journal
		- Block size
		- Head/tail pointers
- **Journal descriptor block**
	- Marks start of transaction
	- Describes subsequent journaled blocks
	- Includes final fixed on-disk locations
		- Data journaling mode
			- After journal descriptor block
				- Data blocks
				- Metadata blocks
		- Ordered/writeback mode
			- After journal descriptor block
				- Metadata blocks
- Logs full blocks
	- Single bit modified in bitmap results in entire bitmap block being logged
- Multiple descriptor blocks followed by corresponding data/metadata blocks logged
	- Depending on size of transaction
- **Journal commit block**
	- Written at end of transaction
	- Once written
		- Journaled data can be completely recovered

### Checkpointing

- Process of writing journaled metadata and data to fixed locations
- Triggered when thresholds crossed
	- File system buffer space is low
	- Not enough free space left in journal
	- Timer expires

### Crash recovery

- Redo logging
- File system scans log for committed complete transactions
	- Incomplete transactions discarded
- Each update in completed transaction is replayed into fixed location

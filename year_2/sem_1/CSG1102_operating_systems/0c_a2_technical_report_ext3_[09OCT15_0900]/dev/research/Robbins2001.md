# Common threads: Advanced filesystem implementor's guide, Part 7

Robbins, D. (2001). Common threads: Advanced filesystem implementor’s guide, Part 7. IBM DeveloperWorks, 1–6. Retrieved from http://www.ibm.com/developerworks/library/l-fs7/

```
Robbins2001
```

## Introduction

- Ext3 designed by Dr. Stephen Tweedie
- Built on existing ext2 filesystem
	- Almost identical
	- Supports journaling

## Ext3 roots in ext2

- Ext2 and ext3 use identical on disk format
	- Cleanly unmounted ext3 filesystem can be remounted as ext2
- Ext2 and ext3 use identical metadata
	- Can upgrade an "in-place" ext2 to ext3 upgrade
		- Upgrade while ext2 filesystem is mounted

## Ext3 reliability

- Ext3 inherits ext2 `fsck`
- Even though point of journaling is to avoid use of `fsck`
	- There are times when it may be required
		- When metadata is corrupted

### Metadata only journaling

- Filesystem is safe from corruptions
	- But improper shutdowns can cause corruption of recently modified data
	- ie. Editing a text file, and crash occurs forcing reboot
		- Filesystem easily repaired
		- But text file may
			- Have missing recent data
			- Have garbage data included
			- Be unreadable

### Ext3 approach

### Ext3 Journaling Block Device (JBD)

- Journaling code uses Journaling Block Device (JBD) API
- JBD designed to implement a journal on any kind of block device
- Ext3 implements journaling by hooking into JBD API
- Example
	- Ext3 informs JBD of modifications in is performing
		- Also requests permission from JBD before modifying certain data on disk
	- JBD given opportunity to manage the journal on behalf of ext3 filesystem driver

### Inode

- Ext3 journal is stored in an inode
- Allows journaling capability without requiring incompatible extensions to ext2 metadata
- One method to allow for backwards compatibility with ext2

### Journaling approach

- Physical journaling
	- JBD stores complete modified filesystem blocks themselves
	- Ext3 filesystem driver stores complete replicas of the modified blocks in memory to track pending IO operations
		- 1K
		- 2K
		- 4K
	- Multiple pending IO operations within a single block into the same in memory data strucuture
		- Then committed to disk in a single write operation
	- Literal data block is stored in memory
		- Little management of in-memory data is required
	- Larger journal size
	- Less CPU overhead
- Opposite to logical journaling
	- Store modified spans of bytes rather than complete blocks
	- Smaller journal size
	- More CPU overhead

### Data integrity

- Two methods
	- Data journal mode
		- Perform full data and metadata journaling
		- JBD journals all changes to filesystem
			- Either metadata
			- Or data
		- JBD can use journal to bring metadata and data to consistent state
		- Disadvantage
			- Slow
	- Ordered journal mode
		- Journals metadata only
		- Keeps track of particular data blocks that correspond with each metadata update
		- Groups them into single entity called transactions
		- When transaction is committed
			- Data blocks are written to disk first
			- Once written, metadata changes are written to journal
		- Provides data and metadata consistency
			- Even though only metadata is journaled
		- Default mode in ext3

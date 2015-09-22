# Anatomy of Linux journaling file systems

Jones, T. M. (2008). Anatomy of linux journaling file systems. IBM DeveloperWorks. Retrieved September 14, 2015, from http://www.ibm.com/developerworks/linux/library/l-journaling-filesystems/index.html


```
Jones2008
```

- Journaling file systems were originally developed for research, not used by mainstream operating systems
- A journaling file system are now the default file system in Linux
- Provides ability for a file system to be resilient to faults caused by improper shut down
	- ie. Power loss, crash
- Before journaling file systems
	- Improperly shut down computer would initiate `fsck` at boot up to perform data consistency check
		- Scans entire file system
		- Larger volumes would cause longer processing time
	- File system may be so corrupted that the OS boots into single user "safe mode" to allow for further repair
- Journaling file systems negate the need for `fsck` by implementing a log or journal that records changes destined for the file system
	- This journal is stored in a circular buffer data structure
	- The changes recorded in the journal are then committed to the file system periodically
- When improper shut down occurs, the journal is referenced as a checkpoint to recover unsaved information, avoiding corrupted system metadata
- Three modes
	- Writeback
		- Only metadata is journaled
		- Data blocks written directly to location on disk
		- Preserves file system structure and avoids metadata corruption
		- Data can still be corrupted
			- ie. System crash after metadata journaled but before data block is written
	- Ordered
		- Metadata journaled
		- Data block written before journaling metadata
		- Guarantees recovery consistency
	- Data
		- Both metadata and data journaled
		- Offers best corruption protection
		- Trade-off with performance since data written twice
			- First to journal
			- Then to disk
- Ext3
	- Has writeback, ordered, data modes
	- Based on Ext2
		- Uses same structure as Ext2
		- Adds journal
	- Commit policy
		- Configurable
		- Default
			- 1/4 journal space filled
			- Or commit timer timeout
	- Disadvantages
		- Design not based as journal file system
		- Lacks advanced features found in newer journaling file systems
			- Extents
		- Worse performance
	- Advantages
		- Less CPU/memory overhead

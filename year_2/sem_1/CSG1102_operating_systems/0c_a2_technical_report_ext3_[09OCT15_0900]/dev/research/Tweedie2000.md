# Ext3, Journaling Filesystem

Tweedie, S. C. (2000). EXT3 , Journaling Filesystem. Proceedings of the Linux Symposium. Retrieved September 14, 2015, from http://olstrans.sourceforge.net/release/OLS2000-ext3/OLS2000-ext3.html

```
Tweedie2000
```

## Motivations

- Big user base for ext2
	- With large filesystems
	- Long time to `fsck`
	- Costs downtime
- Goals of ext3
	- Better filesystem availability
	- Add journaling to existing ext2
		- With minimal changes
	- Maintain backwards/forwards compatibility
		- Can add journal to ext2, mount as ext3
		- Can mount ext3 as ext2, providing data is consistent

## Ext2/3 similarities

- On disk format
- Functionality
	- Persistent inode attributes
- Ext3 uses same code base as ext2

## JBD / JFS

- Journaling layer added on top of ext2 to create ext3
- Independent of file system
	- Ext3 knows nothing about journaling
		- All it knows about is transactions
			- Only interaction between filesystem and JBD is
				- To communicate
					- Where transactions begin and end
					- Which updates belong to which transaction
	- JBD knows nothing about filesystems
		- Provides concept of a log
		- Allows registration of a journal with JBD
			- On inode
			- Or block device
		- Provides write ordering guarantees
			- If a transaction is in progress but not yet committed
				- JBD guarantees that not one update will be written to disk until commit has occurred
		- JBD maintains a list of all updates which form a transaction
			- Guarantees that a transaction is performed completely, or not performed at all

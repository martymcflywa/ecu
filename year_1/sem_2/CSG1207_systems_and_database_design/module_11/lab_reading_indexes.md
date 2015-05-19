# Index for `employee`

**Part of `employee` table:**

![employee table](http://snag.gy/EbyhK.jpg)

**Query:**

``` sql
SELECT employee_id, salary
FROM employee
WHERE last_name = 'Higgins';
```

SQL Server scans full table even if the row was found in the middle of the table (as DBMS doesn't know if another row exists).

After creating an `INDEX` on the column with:

``` sql
CREATE INDEX emp_last_name_index
ON employee(last_name);
```

DBMS created a structure as below, and following query based on `last_name` will be much quicker as DBMS will check the index rather than scan the whole table.

![employee table model](http://snag.gy/mKUdi.jpg)

1. To search for `'Higgins'`, searching starts from the root of the B-tree, search proceeds for a value greater than or equal to the value to be retrieved
	1. From the root, the value `'Matos'` is retrieved, as `'Higgins' > 'Grant'`, and `'Higgins' <= 'Matos'`, which leads to the node in the middle of the 2nd level
	2. From the middle node of the second level of the B-tree, `'Hunold'` is retrieved, as `'Higgins' <= 'Hunold'`
		- Go to its first node in the third level
	3. `'Higgins'` is found in the node, and from the Row ID, SQL Server can locate the row from the data table
2. All values can be found from the B-tree index, or reported `miss` if it is not found in no more than three sets of comparisons
	- For example, search for `'Zugarbi'` will lead to a `miss` after one comparison
3. Real row ID is much more complicated, a value combining the `filegroupID`, database ID, data block ID and the row ID within the data block


![last_name index](http://snag.gy/EJGJs.jpg)

- Maximum search depth = trunc(log<sub>3</sub>(number of rows))
- Index structure is small in size and is kept in memory, thus can be searched fast and easily

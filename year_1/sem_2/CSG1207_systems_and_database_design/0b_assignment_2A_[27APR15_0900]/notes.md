``` sql
CREATE TABLE customer (
	-- ... other columns
	cust_email VARCHAR(20) NOT NULL,

	-- ... other constraints
	CONSTRAINT cust_email_check CHECK (cust_email LIKE '%@%.%')
);
```

``` sql
CREATE TABLE staff (
	-- ... other columns
	staff_dob DATE NOT NULL,

	-- ... other constraints
	CONSTRAINT staff_min_age CHECK (DATEDIFF(year, GETDATE(), staff_dob) > 16)
);
```

``` sql
CREATE TABLE pizza_type (
	-- ... other columns
	pizza_name VARCHAR(20) NOT NULL,

	-- ... other constraints
	CONSTRAINT pizza_name_uk UNIQUE (pizza_name)
);
```

``` sql
CREATE TABLE pizza_crust (
	-- ... other columns
	pizza_crust_name VARCHAR(20) NOT NULL,

	-- ... other constraints
	CONSTRAINT pizza_crust_name_uk UNIQUE (pizza_crust_name)
);
```

``` sql
CREATE TABLE pizza_sauce (
	-- ... other columns
	pizza_sauce_name VARCHAR(20) NOT NULL,
	
	-- ... other constraints
	CONSTRAINT pizza_sauce_name_uk UNIQUE (pizza_sauce_name)
);
```

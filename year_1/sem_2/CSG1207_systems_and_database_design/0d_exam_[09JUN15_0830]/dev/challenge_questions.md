# Challenge queries

## Challenge query 1

Write a query that selects the following:

- Employee names in the form of "Surname, Firstname", e.g. "King, Steven" (name the column "name")
- The gender column, with NULLs replaced by a "?" (name the column "gender")
- The email column, in lower case with "@company.com" appended to the end (name the column "email")
- The number of years that the employee has worked at the company, based on their hire_date (name the column "years_worked")

## Challenge query 2

Write a query which selects the following:

- Employee surname
- Department name
- Location city
- Country name
- Region name

Use `FULL OUTER JOIN`S for all joins to ensure that all employees, departments, locations, cities, countries and regions are returned.

The results should contain 24 rows, some of which will have `NULL` columns.

## Challenge query 3

Write a query which uses the data in the `job_history` table to produce the following results:

```
jobs
-------------------------------------------------------------
Neena Kochhar was a Public Accountant for 4 years
Neena Kochhar was a Accounting Manager for 4 years
Lex De Haan was a Programmer for 5 years
Jonathon Taylor was a Sales Representative for 0 years
Jonathon Taylor was a Sales Manager for 0 years
Jennifer Whalen was a Administration Assistant for 6 years
Jennifer Whalen was a Public Accountant for 4 years
Michael Hartstein was a Marketing Representative for 3 years

(8 row(s) affected)
```

This will require joins with the employee and job tables (for the names and job titles), a date-based row level function, converting data types, and quite a bit of concatenation.

For an extra challenge, make the query show "for less than a year" instead of "0 years" wherever appropriate.  This may require you to use `CASE`, which we haven't covered in this unit.

## Challenge query 4

Create a view called `emp_names` which produces the following data for all employees.  Give all columns suitable names:

- employee_id
- full name, e.g. "Steven King"
- surname then first name, e.g. "King, Steven"
- first name then upper case surname, e.g. "Steven KING"
- Initial letter of first name then surname, e.g. "S. King"
- Initials of both names, e.g. "S. K."
- For an extra challenge, use the gender column and `CASE` to include one more column:
	- If gender is `M`, show "Mr." and surname, e.g. "Mr. King"
	- If gender is `F`, show "Ms." and surname, e.g. "Ms. Kochhar"
	- If gender is `NULL`, just show surname, e.g. "Mourgos"

# Compound keys

## One-to-many

![phoneplan](http://snag.gy/6e8mX.jpg)

This data set has a **one-to-many** relationship between plans and customers: 

1 plan may have many customers associated with it, but 1 customer may only be associated with 1 plan.

>~~R1 = (<ins>**Plan#**</ins>, PlanName, PlanCost, {<ins>**Cust#**</ins>, CustName, CustPhone})~~  
R11 = (<ins>**Plan#**</ins>, PlanName, PlanCost)  
R12 = (<ins>**Cust#**</ins>, CustName, CustPhone, *Plan#*)

If you map the data from the table to the structure of R11 and R12, you can see that we do not need to expand the PK to include the FK. Each row of the customer table has a unique PK value (Cust#). Since each customer can only have one plan, this will remain true.

![phone map](http://snag.gy/qiC5K.jpg)

## Many-to-many

![enrolment](http://snag.gy/i1qgG.jpg)

This data set has a **many-to-many** relationship between students and units: 

1 student many have many units associated with it, and 1 unit many have many students associated with it.

>~~R1 = (<ins>**Student#**</ins>, StudentName, {<ins>**UnitCode**</ins>, UnitName})~~  
R11 = (<ins>**Student#**</ins>, StudentName)  
R12 = (<ins>**UnitCode**</ins>, UnitName)

If you map the data from the table to the structure of R11 and R12, you can see that we need to expand the PK to include the FK - Since each unit can have many students associated with it, there is a row for each enrolment - meaning that a PK of UnitCode alone is not unique.

![enrolment map 1](http://snag.gy/DDB9u.jpg)

We then continue to normalise the relations, resolving the partial dependency in R12.

>R11 = R11 = (<ins>**Student#**</ins>, StudentName)  
~~R12 = (<ins>**UnitCode**</ins>, UnitName)~~  
R121 = (<ins>**_UnitCode_**</ins>, <ins>**_Student#_**</ins>)  
R122 = (<ins>**UnitCode**</ins>, UnitName)

This leaves us with three relations - one for students, one for units, one for enrolments. The enrolments relation contains a compound PK and two FKs, referring to students and units.

![enrolment map 2](http://snag.gy/ipnsE.jpg)

## Summary

If the relationship is **one-to-many** then you will probably **not** need to expand the PK to include the FK when you split the relations apart.

If the relationship is **many-to-many**, then you probably **will** need to use a compound PK.

At the end of the day, the guiding rule should always be:

>Each relation must have a valid PK at all times

If the current PK is not valid (ie. It cannot uniquely identify each row), you need to correct it. Always consider the scenario when determining whether the PK is valid/what is needed.

Here's a sneak peek at how the two scenarios would look in an Entity Relationship diagram:

![e-r diagram](http://snag.gy/f9NXp.jpg)
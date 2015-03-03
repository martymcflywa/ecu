# Normalisation Process

## Review

### Gathering Unnormalised data sets

- The first step of normalisation involves gathering or identifying an unnormalised data set
	- A collection of all the attributes (names, not data itself) that need to be stored
- Where groups of attributes exist in a nested manner, they are known as repeating groups
	- *Tables within tables*
	- A repeating group is a set of attributes that can have more than one value for a given primary key (value)
		- ie. For a single instance of the **outer** group, there can be multiple instances of a group of **inner** attributes
- This step is often rushed, but is perhaps the most critical of the entire normalisation process
	- If the unnormalised data set contains errors then it is more than likely that these errors will be carried throughout the entire normalisation resulting in possible data anomalies

#### Example 1

![nf0 ex 1.1](http://snag.gy/yjkLy.jpg)

- If we were to identify department details as a repeating group within staff details, it would look like this

>R1 = (Staff#, StaffName, DoB, {DepartmentID, DepartmentName})

- The example above is **incorrect**
	- It is saying that for each staff member, there can be many departments

![nf0 ex 1.2](http://snag.gy/N4oFC.jpg)

- The correct way is to identify staff details as a repeating group within the department details

>R1 = (DepartmentID, DepartmentName, {Staff#, StaffName, DoB})

#### Example 2

![nf0 ex 2.1](http://snag.gy/DebU5.jpg)

- Remember to eliminate **derived** attributes
- In each invoice, there are multiple items
- Customer details are all related attributes, but they are not repeating within an invoice, so the following is **incorrect:**

>R1 = (Invoice#, OrderDate, {Customer#, Name, Phone, Address, {Item#, Description, Qty, UnitPrice}})

![nf0 ex 2.2](http://snag.gy/SGsQ3.jpg)

- However, it is reasonable to assume that one customer may have many invoices, so it is perfectly valid to do this:

>R1 = (Customer#, Name, Phone, Address, {Invoice#, OrderDate, {Item#, Description, Qty, UnitPrice}})

- One customer, many invoices
- One invoice, many items
- The solution in the previous lecture is also valid

## Normalisation process

- The normalisation process follows a series of steps:
	1. Gather unnormalised data set (0NF)
		- Covered last week
	2. Convert to first normal form (1NF)
	3. Convert to second normal form (2NF)
	4. Convert to third normal form (3NF)
- Note: We could do higher normal forms but they are commonly not used or needed
	- ie. 4NF, 5NF etc

## Relational symbolic notation

- During the normalisation process, we use relational symbol notation (ie. **R1**, **R2**) to represent relations, rather than relation names
- When a relation, say **R1**, is split into two or more relations, they new relations will be named **R11**, **R12**, **R13**...
	- Like labelling sections of a report, you and another number each time you split into a further/deeper *level* of relations
	- ie. If **R1223** is split, the resultant relations will be named **R12231**, **R12232**, **R12233**...
	- This makes it easy for us to trace the relation splitting if we find something wrong in some late stage of the normalisation process
- When showing progress through the normal forms, use ~~strikethrough~~ to indicate when a relation has been split

## First normal form (1NF)

- 1NF: A relation is in 1NF if all its underlying attributes contain atomic values only
	- ie. No repeating groups
- Once we have identified the unnormalised data set we must convert it into relations in 1NF
- This is achieved through:
	1. Identification of primary keys in all groups
	2. Removal of any repeating groups in the unnormalised data set into new relations
	3. Introduction of foreign keys in the relations
- We are essentially splitting the inner and outer parts of our repeating groups into separate relations

### Steps from 0NF to 1NF

![0nf to 1nf](http://snag.gy/SGsQ3.jpg)

0NF:

>R1 = (Invoice#, OrderDate, Customer#, Name, Phone, Address, {Item#, Description, Qty, UnitPrice})

#### Step 1

First identify primary keys for the outermost group and all repeating groups in the unnormalised data set:

>R1 = (<ins>**Invoice#**</ins>, OrderDate, Customer#, Name, Phone, Address, {<ins>**Item#**</ins>, Description, Qty, UnitPrice})

- A primary key is an attribute/s that uniquely identifies each instance of a relation (row)
	- Each invoice will have a different <ins>**Invoice#**</ins>
	- Each item will have a different <ins>**Item#**</ins>
- In this example, all our groups have simple and obvious primary key attributes, but this is not always the case:
	- May need to combine multiple attributes (compound key)
	- If no appropriate primary key attributes exist in the original data, it is reasonable to add one if it is logical that it would exist
	- Remember that throughout the normalisation process, all relations should have a valid primary key at all times

#### Step 2

Next, remove the outermost repeating group (and any nested repeating groups it contains) and place it in a new relation

We now have two relations:

>R11 = (<ins>**Invoice#**</ins>, OrderDate, Customer#, Name, Phone, Address)  
R12 = (<ins>**Item#**</ins>, Description, Qty, UnitPrice)

- The original data set has been split into two relations
	- One for the outer group of attributes, and one for the inside of the repeating group
- Note the new names (R11 and R12)
	- You can switch these names if it feels more logical to you

#### Step 3

Then add a copy of the primary key of the outer group into the relation created for the inner group. This is to preserve the link between them. This becomes a foreign key:

>R11 = (<ins>**Invoice#**</ins>, OrderDate, Customer#, Name, Phone, Address)  
R12 = (*Invoice#*, <ins>**Item#**</ins>, Description, Qty, UnitPrice)

- It is a foreign key, as indicated by the italics
- For each instance of R12, the value of the Invoice# attribute identifies the corresponding instance of R11
- Wait! R12 does not currently have a valid primary key, Item# on its own cannot uniquely identify each instance of the relation
	- Often, the foreign key we have added will need to become part of the primary key, forming a compound key

>R12 = (<ins>**_Invoice#_**</ins>, <ins>**Item#**</ins>, Description, Qty, UnitPrice)

Each instance of this relation can now be uniquely identified. There will only ever be one instance of a certain item within a certain invoice.

#### Summary

Final relations at 1NF:

>R11 = (<ins>**Invoice#**</ins>, OrderDate, Customer#, Name, Phone, Address)  
R12 = (<ins>**_Invoice#_**</ins>, <ins>**Item#**</ins>, Description, Qty, UnitPrice)

- This process must be repeated for any remaining repeating groups in the new relations
	- There are no more in this example
- Remember to ensure that all resultant relations have a valid primary key, and a foreign key to preserve links
	- It is likely that the foreign key will also become part of the primary key in the new relation

![1nf process](http://snag.gy/E79Gc.jpg)

## Second normal form (2NF)

- 2NF: A relation is in 2NF if it is in 1NF, and every non-key attribute is **fully dependent** on the entire primary key
- To go from 1NF to 2NF, you must **remove all partial dependencies** that exist in the relations
	- A partial dependency occurs when an attribute is not wholly dependent on the **entire** primary key
	- Can only occur in relations that have more than one primary key attribute
		- ie. A compound key
	- Often occurs when the primary key was expanded to include the foreign key after a relation with a repeating group was split

### Steps from 1NF to 2NF

Upon reaching 1NF, the relations in our example are:

>R11 = (<ins>**Invoice#**</ins>, OrderDate, Customer#, Name, Phone, Address)  
R12 = (<ins>**_Invoice#_**</ins>, <ins>**Item#**</ins>, Description, Qty, UnitPrice)

- R11 does not have a compound key, so it has no partial dependencies
- R12 has a compound key, and we can see that
	- Description and UnitPrice attributes only depend on Item#
	- Qty depends on the whole key

#### Step 1

First, remove any attributes that depend on only part of the key and place them into a new relation.

We now have two relations:

>R121 = (<ins>**_Invoice#_**</ins>, <ins>**Item#**</ins>, Qty)  
R122 = (Description, UnitPrice)

R12 has been split, removing the attributes that don't depend on the whole primary key.

#### Step 2

Then, copy over the part of the primary key that the attributes depend on and make it the primary key for the new relation:

>R121 = (<ins>**_Invoice#_**</ins>, <ins>**_Item#_**</ins>, Qty)  
R122 = (<ins>**Item#**</ins>, Description, UnitPrice)

- Item# in R121 is now a foreign key - italicised
- Invoice# is also a foreign key as it relates to the invoice details in R11
- Together, they are the primary key of R121 - an item in an invoice

#### Summary

Final relations at 2NF:

>R11 = (<ins>**Invoice#**</ins>, OrderDate, Customer#, Name, Phone, Address)  
R121 = (<ins>**_Invoice#_**</ins>, <ins>**_Item#_**</ins>, Qty)  
R122 = (<ins>**Item#**</ins>, Description, UnitPrice)

- This process must be repeated for all partial dependencies in all relations
	- There are no more in this example
- All relations have valid primary keys
- Foreign keys preserve the links between relations
- You can start to see the normalised structure emerging

![2nf process](http://snag.gy/qlfhH.jpg)

## Third normal form (3NF)

- 3NF: A relation is in 3NF if it is in 2NF and every non-key attribute is **mutually independent**
- To achieve 3NF, we need to remove all transitive dependencies between non-key attributes
	- A transitive dependency exists where one or more non-key attributes are dependent on another non-key attribute/s, not just on the designated primary key
	- ie. There is a dependency between non-key attributes in a relation
- Note: If no transitive dependencies exist, 3NF is achieved without having to change any of the existing relations
	- Some scenarioes will also have no partial dependencies, meaning that 2NF is the same as 1NF

### Steps from 2NF to 3NF

Upon reaching 2NF, the relations in our example are:

>R11 = (<ins>**Invoice#**</ins>, OrderDate, Customer#, Name, Phone, Address)  
R121 = (<ins>**_Invoice#_**</ins>, <ins>**_Item#_**</ins>, Qty)  
R122 = (<ins>**Item#**</ins>, Description, UnitPrice)

- All attributes in R121 and R122 depend only on the primary key
- The Name, Phone and Address attributes in R11 rely on Customer#

#### Step 1

First, remove any attributes that depend on non-key attribute/s and place them into a new relation.

We now have two relations:

>R111 = (<ins>**Invoice#</ins>, OrderDate, Customer#)  
R112 = (Name, Phone, Address)

R11 has been split, removing the attributes that depend on non-key attribute/s.

#### Step 2

Then copy over the attribute/s that the removed attributes depend on, and make it the primary key for the new relation:

>R111 = (<ins>**Invoice#**</ins>, OrderDate, *Customer#*)  
R112 = (<ins>**Customer#**</ins>, Name, Phone, Address)

- Customer# in R111 is now a foreign key
- Customer# in R112 is the primary key of the relation

#### Summary

Final relations at 3NF:

>R111 = (<ins>**Invoice#**</ins>, OrderDate, *Customer#*)  
R112 = (<ins>**Customer#**</ins>, Name, Phone, Address)  
R121 = (<ins>**_Invoice#_**</ins>, <ins>**_Item#_**</ins>, Qty)  
R122 = (<ins>**Item#**</ins>, Description, UnitPrice)

- This process must be repeated for all transitive dependencies in all relations
	- There are no more in this example
- All relations have valid primary keys, and each relation contains attributes that directly relate to it
- Foreign keys preserve the links between relations
- The example is now considered normalised

![3nf process](http://snag.gy/VmZFV.jpg)

## Alternative examples

### Example 1

At the start of this lecture we identified another valiud unnormalised data set of this example:

>R1 = (Customer#, Name, Phone, Address, {Invoice#, OrderDate, {Item#, Description, Qty, Unit Price}})

Invoice details are identified as a repeating group.

This unnormalised data set is just as valid and correct, and will normalise to the same set of relations as those we ended with on the previous slide.

We will go over the process quicker this time.

#### 0NF to 1NF

##### Keys identified for all groups:

>R1 = (<ins>**Customer#**</ins>, Name, Phone, Address, {<ins>**Invoice#**</ins>, OrderDate, {<ins>**Item#**</ins>, Description, Qty, UnitPrice}})

##### Outermost repeating group removed (splitting R1)

>R11 = (<ins>**Customer#**</ins>, Name, Phone, Address)  
R12 = (<ins>**Invoice#**</ins>, *Customer#*, OrderDate, {<ins>**Item#**</ins>, Description, Qty, UnitPrice})

Invoice# is still a valid primary key for R12, so it does not need to be expanded to include Customer#.

##### Outermost repeating group removed (splitting R2)

>R121 = (<ins>**Invoice#**</ins>, Customer#, OrderDate)  
R122 = (<ins>**_Invoice#_**</ins>, <ins>**Item#**</ins>, Description, Qty, UnitPrice)

As in previous version of example, Invoice# becomes part of the primary key in R122 to ensure that it remains valid.

##### Final relations at 1NF

>R11 = (<ins>**Customer#**</ins>, Name, Phone, Address)  
R121 = (<ins>**Invoice#**</ins>, *Customer#*, OrderDate)  
R122 = (<ins>**_Invoice#_**</ins>, <ins>**Item#**</ins>, Description, Qty, UnitPrice)

#### 1NF to 2NF

##### Remove partially dependent attributes in R122

>R1221 = (<ins>**_Invoice#_**</ins>, <ins>**Item#**</ins>, Qty)  
R1222 = (Description, UnitPrice)

##### Create primary and foreign keys as needed

>R1221 = (<ins>**_Invoice#_**</ins>, <ins>**Item#**</ins>, Qty)  
R1222 = (<ins>**Item#**</ins>, Description, UnitPrice)

##### Final relations at 2NF

>R11 = (<ins>**Customer#**</ins>, Name, Phone, Address)  
R121 = (<ins>**Invoice#**</ins>, *Customer#*, OrderDate)  
R1221 = (<ins>**_Invoice#_**</ins>, <ins>**Item#**</ins>, Qty)  
R1222 = (<ins>**Item#**</ins>, Description, UnitPrice)

#### 2NF to 3NF

##### No transitive dependencies

- Customer details separated from invoice details at 1NF
	- Hence no changes are needed to achieve 3NF

##### Final relations at 3NF

>R11 = (<ins>**Customer#**</ins>, Name, Phone, Address)  
R121 = (<ins>**Invoice#**</ins>, *Customer#*, OrderDate)  
R1221 = (<ins>**_Invoice#_**</ins>, <ins>**Item#**</ins>, Qty)  
R1222 = (<ins>**Item#**</ins>, Description, UnitPrice)

Result of normalisation is the same as before, with different relation names.

#### Name the resultant relations

- The final step in the normalisation process is to give each of the final relations a meaningful name
- While this step is not mandatory, it is useful, especially when converting normalised relations into E-R models
- At first you may find it hard to think of a proper name, but with experience you will begin to see trends and gain a better *feel* for the purpose of each relation
	- If you cannot determine the purpose or meaning of each relation, it is likely that you have made an error in your normalisation
	- Take this as a sign that you should check your working

##### Relations in 3NF

>R11 = (<ins>**Customer#**</ins>, Name, Phone, Address) >> Customer  
R121 = (<ins>**Invoice#**</ins>, *Customer#*, OrderDate) >> Invoice  
R1221 = (<ins>**_Invoice#_**</ins>, <ins>**Item#**</ins>, Qty) >> InvoiceItem  
R1222 = (<ins>**Item#**</ins>, Description, UnitPrice) >> Item

If a word does not exist to adequately describe a relation, the names of related relations can be combined to make a name.

##### Final relation schema

>Customer = (<ins>**Customer#**</ins>, Name, Phone, Address)  
Invoice = (<ins>**Invoice#**</ins>, *Customer#*, OrderDate)  
InvoiceItem = (<ins>**_Invoice#_**</ins>, <ins>**Item#**</ins>, Qty)  
Item = (<ins>**Item#**</ins>, Description, UnitPrice)

### Example 2

Let's go over another example - A car race.

![car race](http://snag.gy/av1GZ.jpg)

This table/form shows the races one driver has entered.

A possible unnormalised data set (0NF):

>R1 = (Driver#, DriverName, {Race#, RaceDate, Car#, CarClass, ClassLimit, OwerPhone,OwnerName})

#### 0NF to 1NF

##### Keys identified for all groups

>R1 = (<ins>**Driver#**</ins>, DriverName, {<ins>**Race#**</ins>, RaceDate, Car#, CarClass, ClassLimit, OwnerPhone, OwnerName})

##### Outermost repeating group removed (splitting R1)

>R11 = (<ins>**Driver#**</ins>, DriverName)  
R12 = (<ins>**_Driver#_**</ins>, <ins>**Race#**</ins>, RaceDate, Car#, CarClass, ClassLimit, OwnerPhone, OwnerName)

- Race# is not a valid PK with Driver# in the relation, since there are many drivers in each race, so the PK is expanded to include Driver#
- Driver# is a FK, maintaining the link between R12 and R11

#### 1NF to 2NF

##### Final relations at 1NF

>R11 = (<ins>**Driver#**</ins>, DriverName)  
R12 = (<ins>**_Driver#_**</ins>, <ins>**Race#**</ins>, RaceDate, Car#, CarClass, ClassLimit, OwnerPhone, OwnerName)

RaceDate only depends on Race#, not the whole PK.

##### Remove partially dependent attribute in R12

>R121 = (<ins>**_Driver#_**</ins>, <ins>**Race#**</ins>, Car#, CarClass, ClassLimit, OwnerPhone, OwnerName)  
R122 = (RaceDate)

##### Create primary and foreign keys as needed

>R121 = (<ins>**_Driver#_**</ins>, <ins>**_Race#_**</ins>, Car#, CarClass, ClassLimit, OwnerPhone, OwnerName)  
R122 = (<ins>**Race#**</ins>RaceDate)

#### 2NF to 3NF

##### Final relations at 2NF

>R11 = (<ins>**Driver#**</ins>, DriverName)  
R121 = (<ins>**_Driver#_**</ins>, <ins>**_Race#_**</ins>, Car#, CarClass, ClassLimit, OwnerPhone, OwnerName)  
R122 = (<ins>**Race#**</ins>, RaceDate)

CarClass, ClassLimit, Owner and OwnerPhone all depend on Car#.

##### Remove transitive dependent attributes in R121

>R1211 = (<ins>**Driver#**</ins>, <ins>**_Race#_**</ins>, Car#)  
R1212 = (CarClass, ClassLimit, OwnerPhone, OwnerName)

##### Create primary and foreign keys as needed

>R1211 = (<ins>**_Driver#_**</ins>, <ins>**_Race#_**</ins>, Car#)  
R1212 = (<ins>**Car#**</ins>, CarClass, ClassLimit, OwnerPhone, OwnerName)

There are still transitive dependencies in R1212 - not in 3NF yet.

##### Current relationships

>R11 = (<ins>**Driver#**</ins>, DriverName)  
R1211 = (<ins>**_Driver#_**</ins>, <ins>**_Race#_**</ins>, Car#)  
R1212 = (<ins>**Car#**</ins>, CarClass, ClassLimit, OwnerPhone, OwnerName)  
R122 = (<ins>**Race#**</ins>, RaceDate)

- ClassLimit depends on CarClass
- OwnerName depends on OwnerPhone

##### Remove transitive dependencies and create keys as needed

>R12121 = (<ins>**Car#**</ins>, *CarClass*, *OwnerPhone*)  
R12122 = (<ins>**CarClass**</ins>, ClassLimit)  
R12123 = (<ins>**OwnerPhone**</ins>, OwnerName)

There are no more transitive dependencies, we're at 3NF.

#### Final 3NF relations

>R11 = (<ins>**Driver#**</ins>, DriverName)  
R1211 = (<ins>**_Driver#_**</ins>, <ins>**_Race#_**</ins>, *Car#*)  
R12121 = (<ins>**Car#**</ins>, *CarClass*, *OwnerPhone*)  
R12122 = (<ins>**CarClass**</ins>, ClassLimit)  
R12123 = (<ins>**OwnerPhone**</ins>, OwnerName)  
R122 = (<ins>**Race#**</ins>, RaceDate)

#### Name the resultant relations

>Driver = (<ins>**Driver#**</ins>, DriverName)  
DriverRace = (<ins>**_Driver#_**</ins>, <ins>**_Race#_**</ins>, *Car#*)  
Car = (<ins>**Car#**</ins>, *CarClass*, *OwnerPhone*)  
CarClass = (<ins>**CarClass**</ins>, ClassLimit)  
Owner = (<ins>**OwnerPhone**</ins>, OwnerName)  
Race = (<ins>**Race#**</ins>, RaceDate)

## Summary

- Normalisation steps
	1. Gather unnormalised data set (0NF)
	2. Remove repeating groups and identify keys (1NF)
	3. Remove all partial dependencies (2NF)
	4. Remove all transitive dependencies (3NF)
	5. Name resultant relations
- Remember, all of the steps must be completed correctly and in order for the result to be correct

### Tips

- Are you simply not getting it or not seeing the point of / need for normalisation?
- It may help to consider the following
	- Normalisation is not a process that always *needs to be worked through* to design a database
	- It is a method of converting flat file / unnormalised data into a normalised set of relations
		- Flat file / unnormalised data is prone to errors, redundancies and anomalies
	- Once you understand the purpose and end results of normalisation, you can design and implement a database in 3NF without going through the normalisation process step-by-step
# TaxTipCalc Pseudocode

``` java
/*
Variables:
	- Meal cost $100
	- Tax 6.75%
	- Tip 15%
*/

BEGIN TaxTipCalc
	set meal cost
	set tax rate
	set tip rate

	meal = meal cost
	tax = meal * tax rate
	tip = (meal + tax) * tip rate
	total = meal + tax + tip

	print tax
	print tip
	print total
```
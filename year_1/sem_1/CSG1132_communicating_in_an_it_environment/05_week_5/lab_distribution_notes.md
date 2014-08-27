# Distribution

## [What is a "Standard Normal Distribution"?](http://youtu.be/c11d3vVM5v8)

<iframe width="640" height="360" src="http://www.youtube.com/embed/c11d3vVM5v8" frameborder="0" style="margin-bottom: 20px;"></iframe>

### Normal Distribution

![normal dist](http://www.mathsisfun.com/data/images/normal-distribution-1.gif)

There are three things that should be immediate for **normal distribution**:

1. Bell shaped curve
	- Mean, which sits in the middle of the graph has most data sitting around it on either side
2. Total area under curve = `1`
3. Symmetrical

### Standard Normal Distribution

![standard normal dist](http://www.mathsisfun.com/data/images/standardizing.gif)

Adds two more attributes.

1. Bell shaped curve
	- Mean, which sits in the middle of the graph has most data sitting around it on either side
2. Total area under curve = `1`
3. Symmetrical
4. Mean = `0`
5. Standard deviation = `1`

## [Excel Statistics 01 - Creating a Frequency Distribution and Histogram](http://youtu.be/DXj4Q0jhLsI)

<iframe width="640" height="360" src="http://www.youtube.com/embed/DXj4Q0jhLsI" frameborder="0" style="margin-bottom: 20px;"></iframe>

### Preparing data

- Create `Bins` column
- Create `Lower Interval` and `Upper Interval` columns
- Identify 
	- `Max`
	- `Min`
	- `Range`
	- `Interval`
		- Divide range by `10`
- First value of `Lower Interval`
	- Enter `Min`
- First value of `Lower Interval`
	- Enter `Min` + `Interval`
- `+ 1` for cell below first value in `Lower Interval`
- `+ Interval` for cell below first value in `Upper value`
- Drag both cells until `Max` is reached in `Upper value`
- `Bins` are the `Upper Interval` values

### Create Frequency Distribution Table

- Create `Frequency` column
- Select column
- In first cell, type `=FREQUENCY(data-array, bin-array)`
	- Press `CTRL` `SHIFT` `ENTER` to treat formula as array
- Highlight `Bins` and `Frequency` column, including titles
- Click `Insert` -> `Column` -> `2D Column` -> `Clustered Column`

### Format Table

- Right click chart, click `Select Data`
- Click `Edit` beneath `Horizontal axis label`
- Select data in `Bins` column for `X` axis
- Delete `Bins` label under `Legend entries`

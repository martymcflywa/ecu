# Prediction and performance

- Another neural network application: Prediction
	- See Negnevitsky p. 326-330
	- Real estate appraisal

## Real estate appraisal problem

- Inputs
	- House location
	- House condition
	- Number of bedrooms
	- Number of bathrooms
	- Living area
	- Land size
	- Garage
	- Heating
- Output
	- Selling price

### Putting data in

- Data can be:

#### Categorical

- Heating system
	- Wood
	- Oil
	- Electric
- 1 of N encoding
- 3 neurons
	- Wood = (1,0,0)
	- Oil = (0,1,0)
	- Electric = (0,0,1)

#### Discrete

- Location rating
	- 0, 1, 2, 3, ..., 9
- One neuron
	- 0.0, 0.1, 0.2, 0.3, ..., 0.9

#### Continuous

- Living area
	- Range 50 - 250 sq.m
- One neuron
	- 121 sq.m
		- (121 - 50) / (250 - 50) = 0..355

### Getting data out

- Data can be:

#### Categorical

- Heating system
	- Wood
	- Oil
	- Electric
- 1 of N encoding
- 3 neurons
	- (0.6, 0.4, 0.1)
		- Choose max -> wood

#### Discrete

- Location rating
	- 0, 1, 2, 3, ..., 9
- One neuron
	- 0.23
		- Round -> 0.2 = rating 2

#### Discrete

- Selling price
	- Range $50K - $225K
- One neuron
	- 0.3 -> 50 + 0.3 \* (225 - 50) =  $102,500

## Possible network design

![possible network design](http://snag.gy/BL2lo.jpg)

### How much training data and neurons to use

#### Widrow's rule of thumb

- Number of weights = error * number of patterns
- ie. Number of weights:

>nhidden \* (ninput + 1) + noutput \* (nhidden + 1)  
2 \* (10 + 1) + 1 \* (2 + 1) = 25

- If error = 0.1
	- Need at least 250 training examples
- Although it is just a rule of thumb

## Credit approval problem

![credit approval problem](http://snag.gy/daUAL.jpg)

### Credit approval data

```
b,30.83,0,u,g,w,v,1.25,t,t,01,f,g,00202,0,+  
a,58.67,4.46,u,g,q,h,3.04,t,t,06,f,g,00043,560,+  
a,24.50,0.5,u,g,q,h,1.5,t,f,0,f,g,00280,824,+  
b,27.83,1.54,u,g,w,v,3.75,t,t,05,t,g,00100,3,+  
b,20.17,5.625,u,g,w,v,1.71,t,f,0,f,s,00120,0,+  
b,32.08,4,u,g,m,v,2.5,t,f,0,t,g,00360,0,+  
b,33.17,1.04,u,g,r,h,6.5,t,f,0,t,g,00164,31285,+  
a,22.92,11.585,u,g,cc,v,0.04,t,f,0,f,g,00080,1349,+
b,54.42,0.5,y,p,k,h,3.96,t,f,0,f,g,00180,314,+
b,42.50,4.915,y,p,w,v,3.165,t,f,0,t,g,00052,1442,+
b,22.08,0.83,u,g,c,h,2.165,f,f,0,t,g,00128,0,+
b,29.92,1.835,u,g,c,h,4.335,t,f,0,f,g,00260,200,+
...
```

- Let's design a network to predict whether or not to grant approval
	- See `MLPExample.java`
- How can we tell how accurate the trained network is?

### Overfitting

![overfitting](http://snag.gy/MUdRw.jpg)

### Estimating performance

- Using the training set is wrong
- Separate test set is better
- Cross validation is even better

### N-fold cross validation for classifiers

- Divide the training set into n equal parts
- For each part
	- Train the classifier using other (n-1) parts
	- Find the classification rate on the chosen part
		- The **holdout**
- Average the classification rates for each part

### Stratified cross validation

- If the n parts are selected so that the proportion of each class in each part is maintained
	- This is called **stratified** cross validation
- Usually, 10 fold stratified cross validation gives a good estimate

### N-fold cross validation for predictors

- Divide the training set into n equal parts
- For each part
	- Train the predictor using the other (n-1) parts
	- Find the error rate on the chosen part
		- The **holdout**
- Average the error rates for each part
- For extra accuracy
	- Run the training several times on each part
		- Since back propagation is not deterministic

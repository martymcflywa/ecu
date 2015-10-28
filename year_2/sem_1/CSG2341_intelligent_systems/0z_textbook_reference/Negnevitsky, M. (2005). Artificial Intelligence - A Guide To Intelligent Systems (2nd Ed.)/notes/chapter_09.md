# Chapter 9: Knowledge engineering and data mining

# 9.2 Will an expert system work for my problem

### Diagnostic expert problem

- Test for expert system candidates
	- Phone call rule
	- Any problem that can be solved by 10-30min phone call can be developed as an expert system
- Diagnosis and troubleshooting problems
	- Attractive candidates for expert systems

### Classification expert systems

- Example
	- Intelligent system that can help identify different classes of sail boats
- Can be handled well by
	- Expert systems
	- Neural networks
- Expert system
	- Must collect some information
	- Define rules for each class
	- Need to deal with uncertainty

# 9.3 Will fuzzy expert system work for my problem

- If cannot define a set of exact rules for each possible situation
	- Use fuzzy logic
- Well suited for modeling human decision making
- Rely on
	- Common sense
	- Vague/ambiguous terms
- While making important decisions
- Large potential for use in
	- Business
	- Finance
- Where decisions based on
	- Human intuition
	- Common sense
	- Experience
- Rather than availability and precision of data

## Decision support fuzzy systems

- Typical problem
	- Mortgage application assessment
- Must represent
	- Basic concept of mortgage assessment in fuzzy terms
	- Implement concept using fuzzy tool
	- Test/optimize system with selected cases

# 9.4 Will neural network work for my problem

- Powerful general purpose tools
- Successfully applied to problems
	- Prediction
	- Classification
	- Clustering
- Used in variety of areas
	- Speech/character recognition
	- Detecting fraudulent transactions
	- Medical diagnosis of heart attacks
	- Process control
	- Robotics
	- Predicting foreign exchange rates
	- Detecting/identifying radar targets
- Popularity based on
	- Versatility
	- Ability to handle binary and continuous data
	- Produce good results in complex domains
- When output is continuous
	- Network can address prediction problems
- When output is binary
	- Network works as classifier

## Character recognition neural networks

- Typical domain for neural network application
	- Character recognition
		- Handwritten
		- Printed
- Optical recognition
	- One of first commercial applications of neural networks

### Optical character recognition (OCR)

- Ability for computer to translate character images into a text file
- Allows to take printed document
	- Put it into computer in editable form without need of retyping document
- Uses scanner to capture character images
- Scanner
	- Processes image by dividing it into hundreds of pixel sized boxes per inch
	- Representing each box with
		- 1 if box is filled
		- 0 if box is empty
	- Resulting matrix of dots
		- bitmap
	- Bitmaps can be stored, displayed, printed by computer
		- But cannot be edited by word processor
	- Patterns of dots have to be recognized as characters by the computer
		- Job of neural network

### Example

- Application of multilayer feed forward network
- Printed character recognition
	- Recognition of digits 0 to 9
- Each digit is represented by a 5 * 9 bitmap
	- See figure 9.19
	- Some commercial applications may use 16 * 16 bitmaps

![figure 9.19](http://snag.gy/tbYv7.jpg)

#### How to choose architecture of neural network for character recognition

- Depends on complexity of problem
- Handwritten character recognition is performed by complex multilayer networks
	- Three or four hidden layers
	- Hundreds of neurons
- For printed character recognition problem
	- Three layer network
	- Single hidden layer
- Number of neurons
	- Decided by number of pixels in bitmap
	- Example
		- 45 pixels per bitmap
		- 10 possible characters
	- Input
		- 45 input neurons
		- One for each pixel in bitmap
	- Output
		- 10 output neurons
		- One for each possible character

#### How to determine optimal number of hidden neurons

- Number of neurons in hidden layer affects
	- Accuracy of character recognition
	- Speed in training network
- Small number of hidden neurons
	- Can't detect complex patterns
- Too many hidden neurons
	- Increase computational overhead
- Another problem
	- Overfitting

##### Overfitting

- Greater number of hidden neurons
	- Greater ability of network to recognize existing patterns
- If number of hidden neurons is too large
	- Network might simply memorize all training examples
- Prevents network from generalizing
	- Or producing correct outputs
	- When presented with data not used in training
- Example
	- Overfitted character recognition network trained with Helvetica font examples might not be able to recognize same characters in New Times Roman font
- Preventing overfitting
	- Choose smallest number of hidden neurons that yields good generalization
- At the starting point
	- Experimental study could begin with two neurons in hidden layer

##### Example

- Will examine performance with following hidden neurons and compare results
	- 2
	- 5
	- 10
	- 20
- 5 neurons in hidden layer
	- See figure 9.20
	- Use sigmoid activation function
	- Trained with back propagation with momentum
		- Constant set to 0.95

![figure 9.20](http://snag.gy/ckAHC.jpg)

- Input/output training patterns shown in table 9.2
- Binary input vectors representing bitmaps of respective digits are fed directly into the network

![table 9.2](http://snag.gy/wUWqN.jpg)

- Network performance
	- Measured by sum of squared errors
- Figure 9.21
	- Results
	- 9.21(a)
		- Two neurons in hidden layer cannot converge to solution
		- Networks with 5, 10, 20 hidden neurons learn fast
		- Converge less than 250 epochs
		- Epoch
			- Entire pass through all training examples
		- Network with 20 hidden neurons
			- Fastest convergence

![figure 9.21](http://snag.gy/PFPp9.jpg)

- Once training is complete
	- Test network with set of test examples
	- See how well it performs

##### Are test examples same as training examples

- Test set has to be independent from training examples
- To test character recognition
	- Present it with examples that include **noise**
		- Distortion of input patterns
- Distortion can be created
	- By adding small random values chosen from a normal distribution to binary input vectors representing bitmaps of the 10 digits
- Evaluate performance of recognition networks with 1000 test examples
	- 100 for each character
- Results shown in figure 9.21(b)
- Although average recognition error of network with 20 hidden neurons is lowest
	- Results do not demonstrate significant differences between networks with 10 and 20 hidden neurons
- Both networks can sustain similar levels of noise without sacrificing recognition performance
- May conclude that for digit recognition problem
	- 10 hidden neurons is adequate

##### Can performance be improved

- Neural network is as good as examples used to train it
- Can feed network with noisy examples of digits
- Results are shown in figure 9.22
- Some improvement in performance of digit recognition network trained with noisy data

![figure 9.22](http://snag.gy/cL4Cc.jpg)

- This case study illustrated one of most common applications of multilayer neural networks trained with back propagation algorithm
- Modern recognition systems are capable of processing different fonts in different language

## Prediction neural networks

- Real estate appraisal
	- Predicting market value of given house based on knowledge of sales prices of similar houses
	- Can be solved with
		- Expert system
			- Won't be able to understand how an appraisal is reached
			- Black box to user
			- Rules cannot be easily extracted
			- Accuracy more important than understanding why
		- Neural network
- Inputs are well defined and standardized between different real estate agencies
	- House location
	- Living area
	- Number of bedrooms
	- Number of bathrooms
	- Land size
	- Type of heating system
	- etc
- Outputs are well defined
	- We know what we are trying ti predict
- Choosing training examples
	- Critical for accurate prediction
	- Must cover full range of values for all inputs
	- Should include houses that are
		- Large/small
		- Expensive/inexpensive
		- With/without garages
	- Training set has to be sufficiently large

### How to determine sufficiently large training set

- Network's ability to generalize is influenced by three main factors
	- Size of training set
	- Architecture of network
	- Complexity of problem
- Once architecture is decided
	- Issue of generalization is resolved by adequacy of training set
- Appropriate number of training examples can be estimated with
	- **Widrow's rule of thumb**
		- For good generalization
		- Need to satisfy following condition:

![equation 9.1](http://snag.gy/aBBI1.jpg)

- Where
	- N = number of training examples
	- n<sub>w</sub> = number of synaptic weights in network
	- e = network error permitted on test
- If we allow error of 10%
	- Number of training examples should be ~10 times bigger than number of weights in network
- In solving prediction problems
	- Often combine input features of different types
	- Some features such as house's condition and location
		- Can be arbitrarily rated
			- 1 = least appealing
			- 10 = most appealing
	- Some features like living area, land size, sale price
		- Measured in actual physical quantities
			- m<sup>2</sup>
			- $
	- Some features represent counts
		- Number of bedrooms/bathrooms
	- Some are categories
		- Type of heating system
- Neural network works best when all inputs/outputs vary within range between 0 and 1
	- All data must be converted before used in neural networks model

### How to convert data

- Data can be divided into three main types
	- Continuous
	- Discrete
	- Categorical
- Use different techniques to convert different types of data

#### Continuous

- Varies between two preset values
	- Min
	- Max
- Can easily be mapped to range between 0 and 1 as:

![equation 9.2](http://snag.gy/R8d3j.jpg)

##### Example

- Living areas of houses in training examples range between
	- 59 sq meters
	- 231 sq meters
- Might set
	- Min = 50
	- Max = 250
- Any value lower than min is mapped to min
- Any value higher than max is mapped to max
- Therefore
	- A living area of 121 sq meters would be converted as:

![continuous conversion example](http://snag.gy/hkNWU.jpg)

### Discrete

- Example
	- Number of bathrooms
	- Number of bedrooms
- Have min/max values
	- Bedrooms normally between 0 and 4
- Method
	- Assign an equal space to each possible value on interval between 0 and 1
		- See figure 9.23

![figure 9.23](http://snag.gy/YDqNA.jpg)

- Neural network can now handle a feature like "number of bedrooms" as a single input
- Example
	- 3 bedroom house = input value 0.75
- If there are more than a dozen values
	- Discrete feature should be treated as **continuous**

### Categorical

- Can be converted by using **1 of N** coding
- Implies that each categorical value is handled as a separate input
- Example
	- Marital status
		- Single
		- Divorced
		- Married
		- Widowed
	- Represented by four inputs
	- Each input can have value 0 or 1
	- Married person would be represented by an input vector
		- [0, 0, 1, 0]

### Feed forward neural network for real estate appraisal

- Figure 9.24 represents a simplified model that was set up by using training examples
	- With features of houses recently sold in Hobart

![figure 9.24](http://snag.gy/plWHG.jpg)

- Input layer
	- Includes 10 neurons
	- Passes converted input values to hidden layer
	- All input features are treated as single inputs
		- Except *type of heating system*
- Type of heating system
	- Categorical data type
	- Uses 1 of N coding
- Hidden layer
	- Two neurons
	- Uses sigmoid activation function
- Output layer
	- Single neuron
	- Uses sigmoid activation function
- Neural network for real estate appraisal determines
	- Value of house
	- Network output can be interpreted as $

### How to interpret network output

- Network output
	- Represented as continuous values in range between 0 and 1
- To interpret results
	- Reverse procedure for converting continuous data
- Example
	- Sales price range $52,500 to $225,000
	- Output value is set up so
		- $50,000 = 0
		- $250,000 = 1
	- If network output = 0.3546
		- Value corresponds to:

![actual value](http://snag.gy/t3ohe.jpg)

### How to validate results

- Use a set of examples never seen by network
- Before training
	- All available data are randomly divided into
		- Training set
		- Test set
- Once training phase complete
	- Network's ability to generalize is tested against test set
- Neural network is opaque
	- Cannot see how network derives results
- But still need to grasp relationships between
	- Network inputs
	- Network outputs
- Although current research into rule extraction from trained neural networks will eventually bring adequate outcomes
	- Non linear characteristics of neurons may prevent network from producing simple and understandable rules
- To understand importance of a particular input to output
	- Do not need rule extraction
- Instead can use **sensitivity analysis**

#### Sensitivity analysis

- Determines how sensitive the output of a model is to a particular input
- Technique is used for understanding internal relationships in opaque models
	- Can be applied to neural networks
- Performed by measuring the network output when each input is set to its min then max values
	- One at a time
- Changes in some inputs may have little effect on output
	- Network is not sensitive to these inputs
- Changes in other inputs have greater effect on output
	- Network is sensitive to these inputs
- Amount of change in the network output represents the network's sensitivity to a particular input
- In many cases
	- Sensitivity analysis can be as good as rules extracted from trained neural network

## Classification neural networks with competitive learning: Clustering

- Intelligent system that can divide a group of iris plants into classes
	- Then assign any iris plant to one of these classes
	- Data set has several variables
		- No idea how to separate it into different classes
		- Cannot find unique or distinctive features in data
	- Will neural network work for this problem?
- Neural networks can discover significant features in input patterns
	- Learn how to separate input data into different classes
- Neural network with competitive learning is suitable tool
- Competitive learning rule
	- Enables single layer neural network to combine similar input data into groups
		- **Clusters**
	- Process is called **clustering**
- Each cluster is represented by a single output
- Cluster
	- Defined as process of dividing an input space into regions
	- Each of which is associated with a particular output

### Example

- Data set of 150 elements
	- Contains 3 classes of iris plants
		- Iris setosa
		- Veriscolor
		- Virginica
- Each plant in the data set is represented by 4 variables
	- Sepal length
		- 4.3cm to 7.9cm
	- Sepal width
		- 2.0cm to 4.4cm
	- Petal length
		- 1.0cm to 6.9cm
	- Petal width
		- 0.1cm to 2.5cm
- In competitive neural network
	- Each input neuron
		- Corresponds to a single input
	- Each competitive neuron
		- Represent represents a single cluster
- The network for the iris plant classification problem will have
	- Four neurons in input layer
	- Three neurons in competitive layer
	- Architecture shown in figure 9.25

![figure 9.25](http://snag.gy/6vCpy.jpg)

- Before network is trained
	- Data must be converted
	- Then divided into training and test sets
- Iris plant data are continuous
	- Vary between some min/max values
	- Can easily be converted to range between 0 and 1
		- Use equation 9.2
	- Can then be used as inputs
- Next step
	- Generate training and test sets from available data
		- 150 element iris data randomly divided into
			- 100 training elements
			- 50 test elements
- Now train competitive neural networks
	- To divide input vectors into 3 classes
	- Figure 9.26 shows learning process
		- Learning rate of 0.01

![figure 9.26](http://snag.gy/qmE1j.jpg)

- Black dots
	- Represent input patterns
- Three spheres
	- Represent weight vectors of the competitive neurons
- Location of each sphere
	- Determined by neuron's weights in 4 dimensional input space
- Initially
	- All weights of the competitive neurons are assigned the same value of 0.5
	- Only one sphere appears in center of input space
		- See figure 9.26(a)
- After training
	- Weight vectors correspond to positions of the cluster centers
	- Each competitive neuron can now respond to input data in a particular region

### How do we know when learning process is complete

- In competitive neural network
	- Unlike multilayer perceptron trained with back propagation algorithm
	- There is no obvious way of knowing whether learning process is complete or not
- Do not know what the desired outputs are
	- Cannot compute sum of squared errors
- Can use **Euclidian distance** instead
- When no noticeable changes occur during weight vectors of competitive neurons
	- A network can be considered to have converged
- In other words
	- If the motion of competitive neurons in the input space remains sufficiently constrained for several subsequent epochs
		- Can assume that learning process is complete
- Figure 9.27 shows the dynamics of the learning process for competitive neurons in the iris classification neural network

![figure 9.27](http://snag.gy/79GlF.jpg)

- Network was trained with two different learning rates
	- Figure 9.27(b)
		- Learning rate is too high
		- Behavior of competitive neurons become erratic
		- Network may never converge
- In order to accelerate learning
	- Can still use large initial values for learning rate
	- But as training progresses
		- Learning rate must gradually decrease

### How can we associate an output neuron with particular class

- Example
	- How do we know that competitive neuron 1 represents versicolor?
- Competitive neural networks enable to identify clusters in input data
- Since clustering is unsupervised process
	- Cannot use it directly for labeling output neurons
- Clustering is just a preliminary stage of classification
- In most applications
	- Distribution of data that belongs to same cluster is rather dense
	- There are usually natural valleys between different clusters
- As a result
	- Position of the center of a cluster often reveals distinctive features of the corresponding class
- On the other hand
	- Weight vectors of the competitive neurons after training provide us with coordinates of these centers in the input space
- Thus
	- A competitive neuron can be associated with a particular class through its weights
- Table 9.3 shows
	- Final weights of the competitive neurons
	- Decoded values of these weights
	- Corresponding class of iris plant

![table 9.3](http://snag.gy/VbJoN.jpg)

### How to decode weights into iris dimensions

- Reverse procedure used for converting iris data

![decode weights into iris dimensions](http://snag.gy/FB0el.jpg)

- Once weights are decoded
	- Can ask an iris plant expert to label the output neurons

### Can we label competitive neurons automatically without an expert

- Can use test data set for automatic labeling
- Once training of neural network is complete
	- Set of input samples representing the same class is fed into the network
	- Output neuron that wins the competition most of the time receives a label of corresponding class
- Although there is only one layer of competitive neurons
	- It can classify input patterns that are not linearly separable
- In classification tasks
	- Competitive networks learn much faster than multilayer perceptrons trained with back propagation
	- But usually provide less accurate results

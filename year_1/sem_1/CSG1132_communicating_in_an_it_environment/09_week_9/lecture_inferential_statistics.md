# Inferential statistics

## Review exercise

1. Explain the following measures of central tendency
	- Mean
		- The average
	- Median
		- The middle score
	- Standard deviation
		- The average distance of all the scores in the distribution, from the mean, or the central part of the distribution
	- Z-score
2. Calculate the Mean, Median and Standard deviation for the dataset below of exam scores for 2 classes
	1. Using the formula for calculating a z-score, decide in which class student 3 is performing best
	2. Explain result 
		- Mean
			- Class 1: 68.333
			- Class 2: 63.333
		- Median
			- Class 1: 75
			- Class 2: 65
		- Std Dev:
			- Class 1: 16.073
			- Class 2: 7.638
		- Student 3 z-score:
			- Class 1: 0.726
			- Class 2: 0.873
		- Explanation:
			- Student 3 is doing better in Class 2 even though he has a lower mark there. The student is higher above the average in Class 2.

![review](http://snag.gy/EXVyD.jpg)

### Calculating std. dev.

![std dev formula](http://www.socialresearchmethods.net/kb/Assets/images/statdes3.gif)

Step 1: xbar = average  
Step 2: find (x - xbar)^2, x = score and xbar = average  
Step 3: ∑ = sum all answers  
Step 4: sum / n - 1, n = number of scores  
Step 5: square root (sum / n - 1)  
Step 6: hooray answer.

#### Example:

Find Std. Dev of scores: 50, 75, 80

```
xbar = 68.333

(50 - 68.333)^2 = 336.098
(75 - 68.333)^2 = 44.448
(80 - 68.333)^2 = 136.118

Sum = 516.664

Sum / n - 1
= 516.664 / 2
= 258.332

Sqroot 258.332 = 16.073
```

### Calculating z-score

![z-score formula](http://lrieber.coe.uga.edu/edit6900/resources/z_formula_large.gif)

Step 1: x = score, μ = mean, sigma = std dev  
Step 2: x - mean  
Step 3: divide answer by std dev  
Step 4: hooray answer.

#### Example

```
x = 80
mu = 68.333
sigma = 16.073

x - mu
= 80 - 68.333
= 11.667

11.667 / sigma
= 11.667 / 16.073
= 0.726
```

## Inferential statistics

- The CO<sub>2</sub> and sea level rise table from last week suggested an inference, namely that rising CO<sub>2</sub> levels are associated with sea level rise
	- This is typical of inferential statistics, where we are trying to reach conclusions that extend beyond the immediate data alone
	- For instance, we use inferential statistics to try to infer from the sample data what the population might think
		- Or we use inferential statistics to make judgements of the probability that an observed difference between groups is a dependable one, or alternatively, one that might have happened by chance
	- Thus, we use inferential statistics to make inferences from our data to more general conditions
	- We use descriptive statistics to simply describe what's going on in our data

## Correlation testing

- The CO<sub>2</sub> problem involved a test of whether two variables were co-related
	- This is a common problem in statistics for example:

>H<sub>1</sub>: The number of close friends a person has is positively associated with FB friends
 
![formula](http://snag.gy/Rzgxg.jpg)

### Normally distributed test

If data is normally distributed, a **Pearson's product moment correlation** test is used.

### Non-normally distributed test

If data is not normally distributed, a **Spearman's rank order** correlation coefficient **non-parametric** test is used. However, this test requires conversion of interval and ratio data to ordinal data.

## Linear association

The simplest kind of relationship between two variables is a **linear relationship**.

For the dataset below, r = 0.94. This result can be interpreted as:

>There is a **strong** positive relationship between weight and height

*r* is the correlation coefficient, and its range is -1 to +1.

Strength is usually described as *weak*, *moderate* or *strong*. Strong is between around 0.70 - 0.90, depending on value.

![linear formula](http://snag.gy/Bs9dH.jpg)

![table](http://snag.gy/o7W4S.jpg)

## Scatter plot view

The strong positive relationship between height and weight seen in the dataset can be represented on a **scatter plot** with a **regression line**. The regression line is the best fitting straight line drawn through the center of the scatter plot, which indicates the relationship between the variables.

![scatter formula](http://snag.gy/QVyjQ.jpg)

The slope of the line is calculated by this formula:

![slope formula](http://snag.gy/Ju03L.jpg)

### Exercise

1. Explain the formula in your own words
	- relationship * (std dev * score 1 / std dev * score 2) = regression
2. What is the predictive power of the line?
	- It demonstrates that as height goes up, so does weight, and vice versa.

## Multiple linear regression

- Simple linear regression involving bivariate analysis is widely used but involves significant simplification:
	- In the real world, many predictor variables can be at work determining the dependent measure
		- What other predictor variables exist for weight besides height?
	- Multiple linear regression is an analysis method based on multiple variables
	- **Predictive power** is often increased by the use of more sophisticated models based on numerous predictive variables
	- Where strong or moderate correlation exists between two variables, conclusions about **causality** need to be treated with caution
	- For example, the **relationship** that we now accept between smoking and lung cancer has emerged from many empirical studies that have enabled us to be confident about the relationship

## Interpreting correlation

- Care must be exercised in the interpretation of the results of correlation testing:
	- Where strong correlation is observed between variables, this should not be interpreted as **causality**
		- The observed effect may be attributable to a third variable or some combination of predictor variables
		- In other words, the observed effect is co-incident rather than causal
		- A claim of association is no more or no less
- There are many types of correlation coefficients that are paired with data types (Jackson, 2006, p.137)

![correlation coefficients](http://snag.gy/39Zig.jpg)

## Confidence levels

### Rolling the dice

- Inferential statistics are used to accept or reject hypothesis on the basis of **probability** that an observed effect can be **attributed** to a **relationship** between variables
- There are two widely used **gold standards**:
	- a = 0.05 means that the probability of the outcome being observed by chance distribution of values is < 1/20
	- a = 0.01 means that the probability of the outcome being observed by chance distribution of values is < 1/100

## H<sub>1</sub>: Facebook friends and close friends

>H<sub>1</sub> The number of close friends a person has is **positively** associated with Facebook friends

- This hypothesis was aimed at exploring whether individuals in Facebook displaying good sociability as measured by Facebook friends, would display similar sociability in the real world, as measured by close friends
- If the thesis is to be accepted or rejected then it must be tested against the data with a test of association

### Data screening

- The data were found to be normally distributed with Facebook friends, but Close friends displayed a positive skew (with many small values)
- A non-parametric test is required

![data screening](http://snag.gy/metqL.jpg)

### Correlation testing

Since one of the variables is non-normally distributed, Spearman's Rank Order testing is used.

Below is the SPSS dialog for results of the test of correlation.

![spearman results](http://snag.gy/LLVrZ.jpg)

The result shows weak positive association that is significant at the a = 0.05 confidence level.

The result is sufficient to reject the null hypothesis, but what interpretation would you put on it?

## Statistical literacy

>Statistical literacy is critical thinking about statistics in arguments. Critical thinking focuses on identifying and evaluating arguments supporting the truth of disputable claims. Critical thinking focuses on both deductive and inductive arguments. Statistical literacy is critical thinking about statistics as evidence for inferences.

>Milo Scheild. Director of the W. M. Keck Statistical Literacy Project

## Using and abusing numbers

Over the past two weeks, we have explored the foundations of statistical literacy:

- Measures of central tendency
	- Mean
	- Median
- Normality
- Measures of dispersion
	- Standard deviation
- How to interpret or misinterpret statistical findings
	- Lies, damned lies and statistics or
	- Abuse of numbers
- The wilful misuse of statistics is rampant

===

>There are three kinds of lies: lies, damned lies and statistics.  
Disraeli, British Prime Minister, 1804 - 1881)

===

>The only statistics you can trust are those you falsified yourself.  
Winston Churchhill, British wartime Prime Minister, 1874 - 1965

===

>A little inaccuracy saves a world of explanation.  
Clarence Edwin Ayres, economist and philosopher, 1891 - 1972

===

>Statistics rarely lie, but people can and do misuse and misunderstand statistics. Statistical literacy can help the public know when statistics are being presented in a bogus manner and to understand what the statistics really mean.  
Kenneth Prewitt, Director, Bureau of Census USA

### Common statistical fallacies and mistakes

- Differences in means between populations or samples are *significant*
	- Inferential tests are required to establish significant differences
	- The presence of outliers can distort the mean
	- Std. Dev. is essential to understanding what interpretation can be attributed to the mean
- Means shed light on the behaviour of cases
	- For example, Joondalup students are more social as measured by mean Facebook friends than Mount Lawley students
	- Imputing a property of a cohort to particular case is dangerous, similar to z-score scenario
		- Where two means are different, there may be many values common to both distributions
- Review of the data on hours spent on Facebook shows that Joondalup students spend around half as much time online as Mount Lawley students as measured by the mean
	- Claim: Mount Lawley students are more addicted to Facebook that Joondalup students
- This claim may be wrong because:
	- The claim aims to shed light on behaviour at case level
	- Std. Dev. shows considerable variability in the Mount Lawley scores
	- Outliers could be affecting the mean, ie scores of 0
- An independent samples t-test is a more reliable way to resolve this claim
	- Are the distributions of the scores in the samples significantly different at a confidence level of 0.05 or 0.01?

### Confusing causation with association

Consider three claims about the results of an observational study:

1. People who weighmore tend to be taller, than people who weigh less
2. Weight is positively associated with height
3. If you gain weight, you can expect to get taller

Suprious association is where an effect is caused by one or more other variables, rather than the ones being tested

- An assocation is observed between ice creams sales and drownings (Moore, 1993)
- An association is observed between doctors in a region and people dying of disease
- Explanations?

### Simpson's Paradox

- A reversal of an association between two variables after a third variable is taken into account
- Correlation is not necessarily a sign of direct causation
	- An observed correlation may be spurious due entirely to a confounding factor - a common cause
- At Berkley, rejection for admission was more likely for women than for men at the college level
- However, rejection was also found more likely for men than women at the department level
- The confounding factor was the department
- Thus, the association between sex and rejection was reversed after taking into account the department rejecting the admission
- The department was a more important explanatory factor than the sex of the applicant
	- And the choice of department was significantly associated with sex
	- 90% of women chose departments with higher rejection rates while only 50% of men chose such departments

### Distinguishing observational studies from experiment

- In an experiment, the researcher has effective physical control
- In an observational study, the researcher has no physical control
- Surveys are observational studies that take place outside the context of a lab where experimental conditions can be controlled
	- Wherever subjects know that they are involved in a study, this can influence behaviour
		- Called the Hawthorne effect

### Reliability problem with surveys

- Error
	- Random error
		- Often due to large numbers of small determinate causes
			- Minimize by getting a larger sample
	- Systematic error
		- Due to bias
			- Unrepresented subset of the target population
		- Bad measuring instruments
			- Bad questions in a survey
		- Response bias
			- Choosing not to respond
			- Untruthful responses
- Overreach
	- Trying to reach conclusions that extend beyond the immediate data alone
	- Generalizing findings from samples to populations where there are too few measurements or where the sample is not genuinely representative of the population
		- With the Facebook problem, the data could not be used for inference about Facebook user behaviour beyond the immediate context of the CSG1132 population
- Methodological errors in statistical analysis
	- Described by applying tests incorrectly and relying upon simple approaches to understanding data
		- For example, Bivariate analysis when more sophisticated methods should have been used
	- We used the concept of *goodness to fit* to describe match between parameters of a dataset and appropriate methods
		- Should not use parametric methods on non-parametric data and vice versa
		- Always check for normality
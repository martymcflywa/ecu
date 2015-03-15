#2: Algorithms

## Problems

Concerning problems, we can state the following priciples:

- An algorithm must be designed to solve a stated problem
	- Which is a well defined task that has to be performed
- The problem must be solvable by an algorithm

## Algorithms

- The algorithm will be performed by some processor
	- Machine or human
- The algorithm must be expressed in steps that the processor is capable of performing
- Algorithm must eventually terminate, producing required answer

>An algorithm is an automatic procedure for solving a stated problem, a procedure that could (at least in principle) be performed by a machine.

## Efficiency of algorithms

Given an algorithm, we are naturally interested in discovering how efficient it is. Efficiency has two distinct facets:

1. Time facet
	- Is concerned with how much time the algorithm requires
		- Processor
2. Space efficiency
	- Is concerned with how much space the algorithm requires for storing data
		- Memory

Sometimes one algorithm is faster, while an alternative needs less space. This is a classic space-time tradeoff, which can only be resolved with knowledge of the context in which the chosen algorithm will be used.

Usually, the time taken by an algorithm depends on input data. We prefer to measure an algorithm's time efficiency in terms of the algorithm itself. The most satisfactory way to measure an algorithm's time efficiency is to count **characteristic operations**.

Which operations are characteristic depends on the problem to be solved. For arithmetic algorithms, it is natural to count arithmetic operations. For example, the algorithm below takes:

- 2x additions
- 3x subtractions
- 3x multiplications
- 1x divisions
- 1x square root

>To find the area of a triangle with sides a, b, c:

>1. Let s = (a + b + c) / 2
2. Let p = s
3. Multiply p by (s - a)
4. Multiply p by (s - b)
5. Multiply p by (s - c)
6. Let A be the square root of p
7. Terminate with answer A

The next algorithm below is a **simple** power algorithm. The variable p successively takes the values 1, b, b<sup>2</sup>, b<sup>3</sup>, and so on - in other words, successive powers of b.

>To compute b<sup>n</sup> where n is a non-negative int:

>1. Set p to 1
2. For i = 1, ..., n, repeat:
	1. Multiply p by b
3. Terminate with answer p

The obvious characteristic operations are multiplications. The algorithm performs one multiplication for each iteration of the loop, and there will be n iterations. Therefore:

>Number of multiplications = n  
= O(n)

The algorithm below is a smart algorithm that takes advantage of observations regarding powers. The variable q successively takes the values b, b<sup>2</sup>, b<sup>4</sup>, b<sup>8</sup> and so on. At the same time, the variable m successively takes the values n, n/2, n/4 and so on, (neglecting any remainders) down to 1. Whenever m has an odd value, p is multiplied by the current value of q.

>To compute b<sup>n</sup> where n is a non-negative int:

>1. Set p to 1, set q to b, set m to n
2. While m is positive, repeat:
	1. If m is odd, multiply p by q
	2. Halve m (neglecting remainder), and multiply q by itself
3. Terminate with answer p

The algorithm is not easy to understand, but the focus is to analysing its efficiency.

First of all, note that steps 2.1 and 2.2 each perform a multiplication, but the multiplication in step 2.1 is conditional. Between them, these steps perform **at most** two multiplications.

Next, note that these steps are contained within a loop, which is iterated as often as we can havel the value of n (neglecting remainders) until we reach zero. It can be shown (see Appendix A.2) that the number of iterations is floor(log<sub>2</sub>n) + 1, where floor(r) is the function that converts a real number r to an integer by discarding its fractional part.

>Max number of multiplications  
= 2(floor(log<sub>2</sub>n) + 1)  
= 2 floor(log<sub>2</sub>n) + 2

The exact number of multiplications depends on the value of n in a rather complicated way. For n = 15, the actual number of multiplications corresponds to the equation above, since halving 15 repeatedly gives a series of odd numbers; while for n = 16, the actual number of multiplications is smaller, since halving 16 repeatedly gives a series of even numbers. The equation above gives us the maximum number of multiplications for any given n, which is a pessimistic estimate.

## Complexity of algorithms

If we want to understand the efficiency of an algorithm, we first choose characteristic operations, and then analyse the algorithm to determine the number of characteristics operations performed by it. In general, the number of characteristics depends on the algorithm's input data.

For algorithm's like the simple power algorithm, the analysis is straight forward. For other algorithms like the smart power algorithm, the analysis is more complicated. We sometimes have to make simplifying assumptions and we sometimes have to be content with estimating the maximum or average number of characteristic operations rather than the exact number.

The simple power algorithm takes n multiplications, while the smart power algorithm takes at most 2 floor(log<sub>2</sub>n) + 2 multiplications. If we double n, the simple power algorithm takes twice as many multiplications, while the smart power algorithm takes at most two extra multiplications. Now this is the heart of the matter. When we compare the efficiences of alternative algorithms, what is most illuminating is the comparison of growth rates. The function 2 floor(log<sub>2</sub>n) + 2 grows much more slowly than n.

Of course we are interested in the actual times taken by alternative algorithms, but we are especially interested in the rates at which their time requirement grows with n. This interest in growth rates is easily justified. When n is small, we do not really care which algorithm is fastest, because none of the algorithms will take much time. But when n is large, we certainly do care, because all of the algorithms will take more time, and some might take much more time than others. All else being equal, we prefer the algorithm whose time requirement grows most slowly with n.

If we have a formula for an algorithm's time requirement, we can focus on its growth rate as follows:

- Take the fastest-growing term in the formula, and discard all slower-growing terms
- Discard any constant factor in the fastest-growing term

The resulting formula is called the algorithm's **time complexity**. We define **space complexity** similarly.

Referring back to the simple and smart power algorithms, the simple power algorithm's efficiency is given as:

>No. of multiplications = n

The number of multiplications grows proportionalty to n. We say that the simple power algorithm's time complexity is of order n, and write this as:

>O(n)

The analysis in this particular example was trivial, but if the number of multiplications had been 2n + 3, the time complexity would have still been O(n).

The smart power algorithm's efficiency was written as:

>Max no. of multiplications = 2 floor(log<sub>2</sub>n) + 2

Discarding the slower-growing term (+ 2) and the constant factor (2), we get floor(log<sub>2</sub>n). We can approximate this as log<sub>2</sub>n. Thus the number of multiplications grows proportionately to log<sub>2</sub>n. We say that the smart power algorithm's time complexity is of order log n, and write this as:

>O(log n)

Growth rate of O(n log n) grows more steeply than O(n), so an algorithm of O(n) is better than O(n log n).

Every time n is doubled, O(n<sup>2</sup>) is multiplied by four and O(n<sup>3</sup>) is multiplied by eight. And every time n is multiplied by 10, O(n<sup>2</sup>) is multiplied by 100, and O(n<sup>3</sup>) is multiplied by 1000! These numbers are discouraging. If the best algorithm we can find is O(n<sup>2</sup>) or O(n<sup>3</sup>), we have to accept that the algorithm will rapidly slow down as n increases. Such an algorithm is often too slow to be of practical use.

While n<sup>2</sup> and n<sup>3</sup> grow steeply, 2<sup>n</sup> grows at a stupendous rate. Every time n is incremented by 10, O(2<sup>n</sup>) is multiplied by over 1000!. As n is increased from 10 to 20 to 30 to 40, 2<sup>n</sup> grows from a thousand to a million to a billion to a trillion. If the algorithm performs 2<sup>n</sup> operations at the rate of a million per second, its time requirement will grow from a millisecond to a second to over 16 minutes to over 11 days.

We say that an algorithm is **feasible** if it is fast enough to be used in practice. Likewise, we say that a problem is **feasible** if it can be solved by a feasible algorithm.

Algorithms of complexity O(n log n) are feasible. Algorithms of O(n<sup>2</sup>) or O(n<sup>3</sup>) might be feasible, but only for small values of n. Algorithms of complexity O(2<sup>n</sup>) are infeasible, except possibly for very small values of n.

## Recursive algorithms

A recursive algorithm is an algorithm that calls itself. When a recursive algorithm calls itself, it performs the same steps over again. This repetition of steps is somewhat similar to the effect we get when the steps are part of a loop. Indeed, often the same algorithm can be expressed either iteratively, or recursively.

Analogously, a recursive method is a method that calls itself. Indeed, a recursive algorithm is most naturally coded in Java as a recursive method.

### Recursive simple power

Let us return to computing the nth power of b, ie. b<sup>n</sup>, where n is a non-negiative integer. The definition of b<sup>n</sup> in the simple power algorithm led naturally to an iterative algorithm.

Now here is an alternative definition of b<sup>n</sup>.

>b<sup>n</sup> = 1 | if n = 0  
b<sup>n</sup> = b * b<sup>n-1</sup>  | if n > 0

The second equation above says that we can compute the nth power of b by taking the (n-1)'th power of b and multiplying that by b. On its own, the second line would be useless, but the first line tells us how to compute the 0th power of b directly. For example:

>b<sup>3</sup> = b * b<sup>2</sup> = b * (b * b<sup>1</sup>) = b * (b * (b * b<sup>0</sup>)) = b * (b * (b * 1))

These equations lead naturally to the next algorithm below. Step 1 deals with the easy case, n = 0, when Step 1.1 directly gives the answer 1. Step 2 deals with the hard case, n > 0, when Step 2.1 computes the answer with the help of a recursive call to the same algorithm. This next algorithm is therefore recursive. In this section, we shall highlight recursive algorithm calls by underlining.

Will the next algorithm terminate or will it go on calling itself forever? We can reason as follows. When called to compute the nth power of b, with n > 0, the algorithm will call itself to compute the (n-1)th power of b, which is a smaller power of b. In fact it will call itself repeatedly to compute successively smaller powers of b. Eventually it must call itself to compute the 0th power of b, and at this point it will give a direct answer without calling itself again. Therefore the algorithm will terminate.

>To compute b<sup>n</sup> where n is a non-negative int:

>1. If n = 0:
	1. Terminate with answer 1
2. If n > 0:
	1. Terminate with answer b * <ins>b<sup>n-1</sup></ins>

``` java
static int power(int b, int n) {
	// return the value of b raised to the nth power
	// where n is a non-negative int
	if(n == 0) {
		return 1;
	} else {
		return b * power(b, n-1);
	}
}
```

### Recursive smart power

The smart power algorithm is hard to understand. However, there is an alternative version that is much more lucid. We observed that b<sup>20</sup> = b<sup>10</sup> * b<sup>10</sup> and b<sup>21</sup> = b<sup>10</sup> * b<sup>10</sup> * b. Generalizing from this example:

>b<sup>n</sup> = 1 | if n = 0  
b<sup>n</sup> = b<sup>n/2</sup> \* b<sup>n/2</sup> | if n > 0 and n is even  
b<sup>n</sup> = b<sup>n/2</sup> \* b<sup>n/2</sup> \* b | if n > 0 and n is odd

Remember that n/2 neglects the remainder if n is odd.

The equations above naturally lead to the algorithm below, which is recursive. Step 1 is the easy case, n = 0, and gives the answer directly. Step 2 is the hard case, n > 0, and works by a recursive call to compute b<sup>n/2</sup>. Computing b<sup>n/2</sup> is easier than computing b<sup>n</sup>, since n/2 is smaller than n.

>To compute b<sup>n</sup> where n is a non-negative integer:

>1. If n = 0
	1.1 Terminate with answer 1
2. If n > 0:
	1. Let p = b<sup>n/2</sup>
	2. If n is even:
		1. Terminate with answer p * p
	3. If n is odd:
		1. Terminate with answer p * p * b

``` java
static int power(int b, int n) {
	// return the value of b raised to the nth power
	// where n is a non-negative integer
	if(n == 0) {
		return 1;
	} else {
		int p = power(b, n / 2);
		if(n % 2 == 0) { // n is even
			return p * p;
		} else { // n is odd
			return p * p * b;
		}
	}
}
```

Many algorithms can be expressed using either iteration or recursion. Typically, the recursive algorithm is more elegant and easier to understand, but less efficient, than the corresponding iterative algorithm.

We do not always have a straight choice between iteration and recursion. For some problems, an iterative solution would be extremely awkward, and a recursive solution is much more elegant.

### Integer rendering

Rendering means converting data into a form suitable for printing or display on a screen. Most often, data are rendered as character strings (although some data are suitable for rendering graphically).

The problem is to render a given integer i to a given base or radix, r between 2 and 10. The rendered integer is to be signed only if negative. For example:

| i   | r  | Render |
|-----|----|--------|
| +29 | 2  | 11101  |
| +29 | 8  | 35     |
| -29 | 8  | -35    |
| +29 | 10 | 29     |

We can view this problem in terms of three cases:

1. If i < 0, we have a negative integer
	- So we should render a minus sign '-' and then render (-i) to the base r
2. If 0 &le; i < r, we have a single digit non-negative integer
	- So we should simply render the required digit
		- Note that we must carefully distinguish between the integers 0, 1, ..., 9 and the corresponding digits '0', '1', ..., '9'
			- A digit is a character, and as such can be printed or displayed on a screen
			- It is true that each digit has an (integer) internal code, but the internal code for '9' is not 9
3. If i &ge; r, we have a multiple digit non-negative integer
	- If we divide i by r, the remainder can be rendered as the rightmost digit, and the quotient can be rendered as the remaining digits
	- So we should render (i / r) to the base r and then render the single digit corresponding to (i mod r)

This naturally leads to the algorithm below. Step 2 is the easy case (a small non-negative integer) which is solved directly. Step 3 is a harder case, a large non-negative integer, which is solved in part by calling the algorithm recursively to deal with an easier case, a smaller non-negative integer. Step 1 is also a harder case, a negative integer, which is solved in part by calling the algorithm recursively to deal with an easier case, a non-negative integer.

>To render an integer i to the base r, where r is an integer between 2 and 10:

>1. If i < 0:
	1. Render '-'
	2. <ins>Render (-i) to the base r</ins>
2. If 0 &le; i < r:
	1. Let d be the digit corresponding to i
	2. Render d
3. If i &ge; r:
	1. Let d be the digit corresponding to (i mod r)
	2. <ins>Render (i / r) to the base r</ins>
	3. Render d

``` java
static String renderBasedInt(int i, int r) {
	// render i to the base r, where r is an integer between 2 and 10
	String s;
	if(i < 0) {
		s = '-' + renderBasedInt(-i, r);
	} else if(i < r) {
		char d = (char)('0' + i);
	} else {
		char d = (char)('0' + i % r);
		s = renderBasedInt(i / r, r) + d
	}
	return s;
}
```

### Towers of Hanoi

Three vertical poles are mounted on a platform. A number of disks are provided, all of different sizes, and each with a central hole allowing it to be threaded on to any of the poles. Initially, all of the disks are on Pole 1, forming a tower with the largest disk at the bottom, and the smallest disk at the top. Only a single disk may be moved at a time, from the top of any tower to the top of any tower, but no larger disks may be moved on top of a smaller disk. The problem is to move the tower of disks from Pole 1 to Pole 2.

According to legend, this task was originally set for the monks at the monastery of Hanoi. 64 disks were provided. Once the monks completed their task, the universe would come to an end. How long should this take?

Rather than the particular problem of moving the tower of 64 disks from Pole 1 to Pole 2, it will prove helpful to address the more general problem of moving a tower of n disks from pole source to pole dest.

We immediately see that n = 1 is an easy case: just move the single disk from source to dest.

In the harder case, n > 1, we are forced to use the remaining pole (other than source and dest); let us call it spare. If n = 2, for example, we can move the smaller disk from source to spare, then move the larger disk from source to dest, and then finally move the smaller disk from spare to dest.

This gives us a clue to solving the general case, n > 1. Assume for the moment that we have an auxiliary algorithm to move a tower of (n - 1) disks from one pole to another. Thus we can proceed as follows: move a tower of (n - 1) disks from source to spare (using the auxiliary algorithm); then move a single disk from source to dest; then move a tower of (n - 1) disks from spare to dest (again using the auxiliary algorithm).

But of course we do not need an auxiliary algorithm to move a tower of (n - 1) disks; we just use the same algorithm recursively! Thus we have derived the algorithm below. To estimate how long the monks of Hanoi will take to move the tower of 64 disks, we need to analyze the algorithm. The characteristic operations are of course single-disk moves. Let monves(n) be the number of single-disk moves required to move a tower of n disks from one pole to another. Then we can immediately write down the following equations:

>moves(n) = 1 | if n = 1  
moves(n) = 1 + 2 moves(n - 1) | if n > 1

Again we have a pair of recurrence equations. Again we skip the derivation and simply state the solution:

>moves(n) = 2<sup>n</sup> - 1

Thus, for example, moves(1) = 1, which is obviously correct, and moves(2) = 3.

The Towers of Hanoi algorithm has time complexity O(2<sup>n</sup>). In fact, it is the first O(2<sup>n</sup>) algorithm we have encountered.

>To move a tower of n disks from source to dest, where n is a positive integer:

>1. If n = 1:
	1. <ins>Move a single disk from source to dest</ins>
2. If n > 1:
	1. Let spare be the remaining pole, other than source and dest
	2. <ins>Move a tower of (n - 1) disks from source to spare</ins>
	3. Move a single disk from source to dest
	4. <ins>Move a tower of (n - 1) disks from spare to dest</ins>
3. Terminate

The monks of Hanoi would have discovered long ago what this signifies in practice. Their task entails making 2<sup>64</sup> - 1 or about 18 million million million moves, an enourmous number. At the rate of one move per second, their task would take about 570 billing years, or about 40 times the estimated age of the universe.

# Questions

1. How does "Halve m (neglecting remainder), and multiply q by itself" become floor(log<sub>2</sub>n) + 1
	- Where does + 1 come from?

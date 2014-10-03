# Graph Theory

## What is a graph?

Suppose there are 6 soccer teams A, B, C, D, E and F in a competition.

>A has played B, D, E  
B has played A, C, F  
C has played B, E, F  
D has played A, E, F  
E has played A, C, D  
F has played B, C, D

We can illustrate this situation using a diagram.

![graph soccer](http://i.imgur.com/dYALhgJ.png)

The diagram above is called a graph. It has a number of points A, B, C, D, E and F, which are called vertices, and some of the vertices are joined by lines or curves, which are called edges.

Such a graph could represent other situations. For example, A, B, ..., F could be nodes in a local area network (LAN).

Or they could be towns that are connected by roads, or it could simply represent a relation on a set {A, B, C, D, E, F}.

Notice in the diagram above, some edges cross over each other, but the intersections are not vertices. This happens because we have drawn the graph on a 2 dimensional plane with straight lines for edges.

It may be better to think of the vertices as buttons, and the edges as pieces of string or elastic connecting the buttons.

Sometimes it may be possible to redraw the graph so that such intersections do not occur. For example we could redraw the graph above like so:

![graph soccer curved](http://snag.gy/5JIbl.jpg)

Notice that there is the same number of vertices and edges and the same vertices are joined.

## Null graphs, complete graphs and complements

### Null graphs

A null graph is one that consists of vertices and no edges. 

The null graphs with 1, 2, 3 and 4 vertices.

![graph null](http://snag.gy/6p48C.jpg)

### Complete graphs

A complete graph is one in which every vertex is joined to every other vertex.

The complete graphs with 1, 2, 3 and 4 vertices.

![graph complete](http://snag.gy/ziAYG.jpg)

### Complements

The inverse of a graph.

Original graph:

![graph soccer](http://i.imgur.com/dYALhgJ.png)

Complement:

![graph complement](http://snag.gy/W9DUe.jpg)

#### Exercise

Draw the complements *G'* and *H'* of the graphs *G* and *H* below:

![graph g and h](http://snag.gy/tkqB8.jpg)

Solution:

![complement g and h](http://snag.gy/ER2tE.jpg)

## Degree of vertex

A graph in which there is at least one pair of vertices joined by more than one edge is called a **multigraph**, such as the graph below.

If pairs of vertices are joined by not more than one edge, the graph is called **simple**.

![multigraph](http://snag.gy/Wddc0.jpg)

The degree of a vertex is the number of edges that are joined to that vertex.

We call a vertex **even** or **odd** according to whether its degree is an even or odd number.

- In the following graph:
	- deg(A) = 3
	- deg(B) = 2
	- deg(C) = 4
	- deg(D) = 4
	- deg(E) = 3
- A and E are **odd** vertices
- B, C and D are **even** vertices

![odd and even](http://snag.gy/Wddc0.jpg)

### Exercise 1

Draw a graph with 4 vertices, all with degree 2.

![degree ex1A](http://snag.gy/BVpWo.jpg)

#### Solution

![degree ex1B](http://snag.gy/uFHJP.jpg)

### Exercise 2

Draw a graph with 4 vertices, two with degree 2, three with degree 3.

![degree ex2A](http://snag.gy/y4AJk.jpg)

#### Solution

![degree ex2B](http://snag.gy/h1ypw.jpg)

### Exercise 3

Draw a graph with 4 vertices, all with degree 3.

![degree ex3A](http://snag.gy/7nhqr.jpg)

#### Solution

![degree ex3B](http://snag.gy/kSDsj.jpg)

### Exercise 4

Draw a graph with 5 vertices, all with degree 2.

![degree ex4A](http://snag.gy/GQ9oS.jpg)

#### Solution

![degree ex4B](http://snag.gy/lXS2B.jpg)


### Exercise 5

Draw a graph with 6 vertices, all with degree 3.

![degree ex5A](http://snag.gy/rkdfs.jpg)

#### Solution

![degree ex5B](http://snag.gy/cXztN.jpg)

### Exercise 6

Draw a graph with 6 vertices, all with degree 4.

![degree ex6A](http://snag.gy/1PpQK.jpg)

#### Solution

![degree ex6B](http://snag.gy/SnXFd.jpg)

## Number of edges in a graph

### Theorem 1

For any graph, the sum of the degrees of the vertices is equal to twice the number of edges.

Confirm theorem 1 is true for the following graphs:

![theorem 1](http://snag.gy/142gP.jpg)

### Theorem 2

The sum of the degrees of a graph is always even.

### Theorem 3

Any graph has an even number of odd vertices.

## Isomorphic graphs

There are many different ways to draw a graph. The two graphs below look very different but they contain the same information.

For example, if they represented matches played between teams, then each is providing the same information about which team has played which.

![iso soccer](http://snag.gy/vrxrg.jpg)

Such graphs are called **isomorphic** (iso means the same, morphe means form).

Often we need to be able to tell whether two graphs are isomorphic. Sometimes it is easy to see that two graphs cannot be isomorphic.

### Number of vertices

The two graphs below do not have the same number of vertices, not isomorphic:

![not isomorphic 1](http://snag.gy/a2iS6.jpg)

### Number of edges

The two graphs below do not have the same number of edges, not isomorphic:

![not isomorphic 2](http://snag.gy/PKxr9.jpg)

### Degrees

The two graphs below have the same number of vertices and edges, but graph *b* has a vertex where three edges meet and *a* does not have such a vertex.

![not isomorphic 3](http://snag.gy/NjtFn.jpg)

### Example of isomorphic graphs

The two graphs below are isomorphic, which will be demonstrated in the following section:

![isomorphic](http://snag.gy/1Kkdz.jpg)

## How to demonstrate isomorphism?

Consider the two graphs below, graph 1 and graph 2.

They are isomorphic, but how can we demonstrate this?

We must find which vertices correspond to which, and find a **mapping** between the vertices.

![iso mapping 1](http://snag.gy/4uOuo.jpg)

So the mapping is: 

>A → 1, B → 4, C → 2, D → 5, E → 3.

### Note

There is another mapping that could have been used:

>A → 5, B → 2, C → 3, D → 4, E → 1

We could also describe the mapping in terms of a one-to-one onto function from the set of vertices of graph 1 to the set of vertices of graph 2.

>f: {A,B,C,D,E} → {1,2,3,4,5}, f(A)=2, f(B)=5, f(C)=4, f(D)=3, f(E)=1

### Example 1

Graphs A and B are isomorphic. To demonstrate this, we first need to label the vertices.

![iso example 1](http://snag.gy/4uOuo.jpg)

>A → 1, B → 4, C → 2, D → 5, E → 3

The two graphs are isomorphic.

### Example 2

Find a mapping that shows that these two graphs are isomorphic.

![iso example 2](http://snag.gy/C5Lqp.jpg)

Notice that 4 edges meet at E, and 4 edges meet at vertex 5. From there its easy to see that with the mapping:

>A → 1, B → 2, C → 3, D → 4, E → 5

The two graphs are isomorphic.

### Exercise

Find a mapping that shows that the following two graphs are isomorphic.

![iso ex](http://snag.gy/0c5hs.jpg)

> A → 1, B → 2, C → 3, D → 4, E → 5 **or**  
A → 5, B → 4, C → 3, D → 2, E → 1

## Matrix representation of graphs

Drawing graphs are satisfactory for graphs with only a few vertices, but for larger graphs, especially when using a computer, matrix representation is more reliable and convenient.

The matrix is a square array with one column and one row for each vertex.

If two vertices are joined, a **1** is entered in the appropriate cell, otherwise a **0** is entered.

Such a matrix is called an adjacency matrix, because it shows which vertices are **adjacent**.

### Example 1

![adj matrix example 1](http://snag.gy/620o8.jpg)

The matrix is symmetrical at the diagonal from top left to bottom right. This must be the case of course, because if A is joined to B, then B must be joined to A.

### Example 2

![adj matrix example 2](http://snag.gy/tRbve.jpg)

### Exercise 1

Construct the adjacency matrix for this graph:

![adj matrix ex 1](http://snag.gy/MuNqU.jpg)

### Exercise 2

Draw a graph that mathces this adjacency matrix:

![adj matrix ex 2](http://snag.gy/tqP3C.jpg)

## Using matrix representation to show isomorphism

### Example 1

![iso graph 1](http://snag.gy/0WB53.jpg)

Consider the mapping:

>A → Q, B → R, C → S, D → T and E → P

If we arrange the labels on the second matrix so that Q corresponds to A, R to B, ..., P to E, and then fill in the entries of each matrix to represent the appropriate graph, we find that the matrix entries are identical.

#### Matrices

![iso matrix 1](http://snag.gy/t2wY4.jpg)

### Example 2

![iso graph 2](http://snag.gy/4uOuo.jpg)

Previously we used the mapping:

>A → 2, B→ 5, C → 4, D → 3, E → 1

When we label the rows and columns to correspond with this mapping, we see that the adjacency matrices are identical, therefore the graphs are isomorphic.

#### Matrices

![iso matrix 2](http://snag.gy/HktLE.jpg)

### Exercise

![iso matrix ex 1](http://snag.gy/X6P7a.jpg)

#### 1: Find the mapping that demonstrates that the two graphs below are isomorphic

>A → Q, B → P, C → T, D → R, E → S

#### 2: Appropriately label the rows and columns of the adjacency matrix

See 3.

#### 3: Use the graphs to fill each matrix and check that they are identical

![iso matrix ex 1 q 3](http://snag.gy/UUu8E.jpg)

#### 4: Find a second mapping that could be used to show the isomorphism

>A → Q, B → P, C → S, D → R, E → T

## Eulerian and hamilton graphs

An important question is whether or not a particular graph can be traversed. We will consider briefly two types of traversibility, Eulirian and Hamiltonian.

![eulerianhamiltion](http://snag.gy/KpBBQ.jpg)

### Paths

A path is a route that can be traced without lifting the pencil from the page. It may include repeated vertices, but no edge may be traced more than once. For example, in the graph above:

>ADECB is a path.

### Circuits

A circuit is a path in which the last vertex is also the first. For example, in the graph above:

>BAECB is a circuit

### Königsberg bridge problem

These paths and circuits are named in honour of the Swiss mathematician *Leonard Euler* who solved the famous *Königsberg Bridge Problem*.

In the 18th century, on Sunday afternoons, the good citizens of Königsberg would amuse themselves with the following puzzle.

The River Pregel flowed through the city, pass around the island of Kneiphof.

![bridge problem](http://snag.gy/3bFOM.jpg)

There are seven bridges across the river, and the puzzle was to find a route that crossed each bridge exactly once and returned to the startting point. We can represent the situation using a graph, as shown.

![bridge graph](http://snag.gy/Ic0bc.jpg)

Euler proved that there is no solution to the puzzle as we will see shortly.

In certain kinds of problems, such as the Königsberg Bridge Problem, we are concerned with paths that include every edge

### Eulerian paths and circuits

![eul paths and circuits](http://snag.gy/na1QE.jpg)

#### Eulerian path

A Eulerian path is a path that includes everry edge exactly once.  
A Eulerian path may pass through a vertex more than once.

#### Eulerian circuit

A Eulerian circuit is a Eulerian path that is also a circuit.

### Exercise

If possible, find Eulerian paths or Eulerian circuits in the following graphs:

![eul ex 1](http://snag.gy/SInae.jpg)

### Methods for identifying Eulerian paths and circuits

There is a straight forward method of determining whether a graph has a Eulerian path or circuit by considering the number of odd vertices.

#### Theorem

>A graph has:  
1. No Eulerian path if it has more than two odd vertices  
2. A Eulerian path, but no Eulerian circuit if it has two odd vertices  
3. A Eulerian circuit if every vertex is even

#### Examples

![eul ex 1 A](http://snag.gy/9QV6o.jpg)

![eul ex 1 B](http://snag.gy/jlRjy.jpg)

![eul ex 1 C](http://snag.gy/RDGXR.jpg)

### Back to the bridge

We return to the famous puzzle that was mentioned earlier. The problem was to find a way to cross each bridge exactly once and return to the starting point, or to find a Eulerian circuit.

![bridge graph](http://snag.gy/Ic0bc.jpg)

Since there are more than two odd vertices: Three of degree 3, and one of degree 5, there is no Eulerian path, and certainly no Eulerian circuit.

## Hamilton's puzzle

Eulerian paths and circuits must include every edge.

Hamiltonian paths and circuits must include every vertex exactly once, although it is not necessary to include every edge.

The name Hamiltonian is in honor of the Irish mathematician Sir William Rowan Hamilton.

He posed a famous, but not very popular puzzle involving a wooden dodecahedron.

The task is to find a path that passes through every vertex exactly once and returns to the starting point.

![hamilton puzzle](http://snag.gy/6pa9l.jpg)

### Hamiltonian path and circuits

![ham paths and circuits](http://snag.gy/D8k8I.jpg)

#### Hamiltonian path

A Hamiltonian path is a path that includes every vertex exactly once, except that the last vertex may also be the first.

#### Hamiltonian circuit

A Hamiltonian circuit is a Hamiltonian path that is also a circuit.

### Exercises

Find whether each graph has a Hamiltonian circuit, a Hamiltonian path or neither:

![ham ex 1](http://snag.gy/8c07g.jpg)

![ham ex 2](http://snag.gy/vTeXW.jpg)

![ham ex 3](http://snag.gy/kDkW7.jpg)

### Solution to Hamilton's puzzle

![ham puzzle solved](http://snag.gy/KgNUv.jpg)

### Comparison of Eulerian and Hamiltonian paths

Although we might expect there to be some similarity between Eulerian and Hamiltonian paths, this does not appear to be the case.

For example, we have seen that there is a simple theorem that tells us whether a particular graph has Eulerian paths or circuits, but there is no such simple theorem for Hamiltonian paths and circuits.

In fact there appears to be no connection between Eulerian and Hamiltonian paths and circuits, as the following examples suggest.

#### Examples

![compare eul ham 1](http://snag.gy/P3KRx.jpg)

![compare eul ham 2](http://snag.gy/ZRpe7.jpg)

## Planar graphs

A graph that can be drawn so that the edges have no intersections except at the vertices is called a planar graph.

For example, Graph P below may be redrawn as Graph Q so that its edges intersect only at vertices.

Therefore, P is a planer graph.

![graph planar](http://snag.gy/7JJEj.jpg)

### Two important graphs that are non-planar

The following graphs, called K<sub>5</sub> and K<sub>3,3</sub> are two important non-planar graphs. They are often used to prove that other graphs are non-planar.

![non-planar K](http://snag.gy/EMOSD.jpg)

To demonstrate that these two graphs are non-planar, we need to use a theorem that is intuitively obvious, as follows.

### The Jordan Curve Theorem

Suppose that Γ is a closed path in a plane (which may consist of lines, arcs and so on). Then Γ divides the plane into two regions, one of which is inside Γ and the other is outside. Now if P is a point inside Γ and Q is a point outside Γ, then a edge drawn from P to Q must intersect Γ at some point.

![jordan curve](http://snag.gy/mtGfL.jpg)

#### Pentagonal graph K<sub>5</sub>

![pent k_5](http://snag.gy/9hGkc.jpg)

#### Hexagonal graph K<sub>3,3</sub>

![hex K_3,3](http://snag.gy/NiUis.jpg)

### Method

In the easiest cases, one can demonstrate that a graph is planar simply by redrawing the graph so that edges do not intersect except at vertices.

In more complex cases, we need to show in more detail (for example using adjacency matrices) that the given graph is isomorphic to another graph that is known to be planar or non-planar.

#### Example 1

Redraw if possible so that no edges intersect except at vertices:

![redraw 1](http://snag.gy/i71D6.jpg)

#### Example 2

Redraw if possible so that no edges intersect except at vertices:

![redraw 2](http://snag.gy/8cpZN.jpg)

#### Example 3

Redraw if possible so that no edges intersect except at vertices:

![redraw 3](http://snag.gy/Y1iti.jpg)

#### Example 4

Redraw if possible so that no edges intersect except at vertices:

![redraw 4](http://snag.gy/B0U6K.jpg)

#### Example 5

Redraw if possible so that no edges intersect except at vertices:

![redraw 5](http://snag.gy/iUg0Y.jpg)

## Application: Planar graphs and printed circuits

A diagram for an electronic circuit may be represented by a graph in which various gates or terminals (vertices) are connected by strips of conducting metal (edges).

Here is a typical simple circuit:

![simple circuit](http://snag.gy/CFeEf.jpg)

Replacing the various gates by circles gives a simple graph:

![simple circuit graph](http://snag.gy/7X2cp.jpg)

A standard way of manufacturing circuits is to print the conducting material onto a non-conducting board.

The conductors meet only at the terminals, otherwise short circuits will occur.

If the circuit can be represented by a planar grpah there are no unwanted intersections.

An important application of graph theory is to determine the minimum number of boards necessary to produce a given circuit.

![circuit board 1](http://snag.gy/ArYY1.jpg)

![circuit board 2](http://snag.gy/qRY8x.jpg)

![circuit board 3](http://snag.gy/p6PIR.jpg)
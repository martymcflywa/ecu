# Fundamentals of algorithm analysis

## Task 1

Create a spreadsheet to show the growth rates given in the following table.

Observe the differences among these growth rates.

| n    | 1 | log(n) | n    | n * log(n) | n<sup>2</sup> | n<sup>3</sup> | n<sup>10</sup> | 2<sup>n</sup> |
|------|---|--------|------|------------|---------------|---------------|----------------|---------------|
| 1    | 1 | 0      | 1    | 0          | 1             | 1             | 1              | 2
| 2    | 1 | 1      | 2    | 2          | 4             | 8             | 1024           | 4
| 4    | 1 | 2      | 4    | 8          | 16            | 64            | 1048576        | 16
| 8    | 1 | 3      | 8    | 24         | 64            | 512           | 1073741824     | 256
| 10   | 1 | 3.32   | 10   | 33.22      | 100           | 1000          | 10000000000    | 1024
| 20   | 1 | 4.32   | 20   | 86.44      | 400           | 8000          | 1024E10        | 1048576
| 40   | 1 | 5.32   | 40   | 212.88     | 1600          | 64000         | 1048576E10     | 1099511627776
| 80   | 1 | 6.32   | 80   | 505.75     | 6400          | 512000        | 1073741824E10  | 1.2089258196146292E24
| 100  | 1 | 6.64   | 100  | 664.39     | 10000         | 1000000       | 1E20           | 1.2676506002282294E30
| 200  | 1 | 7.64   | 200  | 1528.77    | 40000         | 8000000       | 1024E20        | 1.6069380442589903E60
| 400  | 1 | 8.64   | 400  | 3457.54    | 160000        | 64000000      | 1048576E20     | 2.5822498780869086E120
| 800  | 1 | 9.64   | 800  | 7715.08    | 640000        | 512000000     | 1073741824E20  | 6.668014432879854E240
| 1000 | 1 | 9.97   | 1000 | 9965.78    | 1000000       | 1000000000    | 1E30           | 1.0715086071862673E301

## Task 2

Suppose that the following expressions are the sum of characteristic operations of some algorithms. Determine the time complexity of each of these expressions by means of the Big-O notation.

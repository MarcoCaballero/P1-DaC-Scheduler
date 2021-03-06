# P1-DaC-Scheduler

## Brute Force (Round Robin)
Using the round robin algorithm to permute all the teams, but the pivot (usually the first) iterating through the weeks, as the followig example:

Week 1:

pivot => 1


```text
m m m m m m m m 
| | | | | | | |
1 2 3 4 5 6 7 8
8 7 6 5 4 3 2 1
```

Week 2:

pivot => 1

permute => 1 3 4 5 6 7 8 2

```text
m m m m m m m m 
| | | | | | | |
1 3 4 5 6 7 8 2
2 8 7 6 5 4 3 1
```
### Eficience

Doing this way the algorithm eficient in the worst case (asintotic notation) is `O(n^2)`, else we should permute all cases until `n!`

## Divide and Conquer (Round Robin)

Using the divide and conquer algorithm, we could solve the problem by dividing the problem, from `2^K`, by two recursively, from `1 to 2^(k-1)` and from `2^(k-1) + 1 to 2^n`.

Before the merge of both subsolutions, we need to use other strategy to fulfill the solution matrix by pairing between them. We could maybe, permute one each week (and apply **Round Robin** again).

### Eficience

aT (n/b) + dn^j


```java
int medio;

if (rowMax - rowMin == 1) {
	t[rowMin][0] = rowMax;
	t[rowMax][0] = rowMin;
} else {
	medio = ((rowMax + rowMin) / 2);
	divide(t, medio + 1, rowMax); // Call 1 ( T = 1)
    divide(t, rowMin, medio); // Call 2 ( T = 2)
    
	conquer(t, rowMin, medio, (medio - rowMin), (medio - rowMin) * 2, medio + 1); // O(n^2)
	conquer(t, (medio + 1), rowMax, (rowMax - (medio + 1)), (rowMax - (medio + 1)) * 2, rowMin); // O(n^2)
}
```

```java
for (int sum = 0, j = colMin; j <= colMax; sum++, j++) { // O(n/2)
	t[rowMin][j] = (eqInic + sum);
}

for (int i = rowMin + 1; i <= rowMax; i++) { // O(n) 
	t[i][colMin] = t[i - 1][colMax];
	for (int j = colMin + 1; j <= colMax; j++) { // O(n/2)
		t[i][j] = t[i - 1][j - 1];
	}
}
```
Recursive calls: 2
Problem division: 2
Worst recursive time: O (n^2)
Worst base case: 2

t(n) = | 2, si n = 2
       | 2T (n/2) + n^2, si n > 2

2T (n/2) + n^2 € O(n^2 + 2^log2n ...) € O(n^2)

Then the worst case (asintotic notation) is `O(n^2)`.

Doing this way the algorithm eficient in the worst case (asintotic notation) is `O(n^2)`

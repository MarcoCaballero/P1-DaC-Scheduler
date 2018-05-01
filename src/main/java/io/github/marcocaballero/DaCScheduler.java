package io.github.marcocaballero;

public class DacScheduler extends Algorithm {

	public static int[][] generateResults(int n) {
		int[][] t = checkOdd(n);

		divide(t, 0, (t.length - 1));

		return t;

	}

	public static void divide(int[][] t, int rowMin, int rowMax) {
		int medio;

		if (rowMax - rowMin == 1) {
			t[rowMin][0] = rowMax;
			t[rowMax][0] = rowMin;
		} else {
			medio = ((rowMax + rowMin) / 2);

			divide(t, medio + 1, rowMax);
			divide(t, rowMin, medio);

			conquer(t, rowMin, medio, (medio - rowMin), (medio - rowMin) * 2, medio + 1);
			conquer(t, (medio + 1), rowMax, (rowMax - (medio + 1)), (rowMax - (medio + 1)) * 2, rowMin);
		}
	}

	public static int[][] conquer(int[][] t, int rowMin, int rowMax, int colMin, int colMax, int eqInic) {

		for (int sum = 0, j = colMin; j <= colMax; sum++, j++) { // var reduce; (eqInic + j ) - colMin;
			t[rowMin][j] = (eqInic + sum);
		}

		for (int i = rowMin + 1; i <= rowMax; i++) {
			t[i][colMin] = t[i - 1][colMax];

			for (int j = colMin + 1; j <= colMax; j++) {
				t[i][j] = t[i - 1][j - 1];
			}
		}

		return t;
	}
}

package io.github.marcocaballero;

import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] t = new int[8][7];
		for (int[] is : t) {
			Arrays.fill(is, 99);
		}
		divide(t, 0, 7);
		

		System.out.println();

		for (int[] row : t) {
			System.out.println(Arrays.toString(row));
		}
		
		for (int w = 0; w < t.length - 1; w++) {
			System.out.println("WEEK " + w);
			System.out.println();
			for (int tr = 0; tr < t.length; tr++) {
				System.out.println(tr+ " vs " + t[tr][w]);
			}
			System.out.println();
		}
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

			conquer(t, rowMin, medio, (medio - rowMin), (medio - rowMin) * 2, (medio + 1));

			conquer(t, (medio + 1), rowMax, (rowMax - (medio + 1)), (rowMax - (medio + 1)) * 2, rowMin);
		}
	}

	public static int[][] conquer(int[][] t, int rowMin, int rowMax, int colMin, int colMax, int eqInic) {

		for (int j = colMin; j <= colMax; j++) {
			t[rowMin][j] = eqInic + j - colMin;
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

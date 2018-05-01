package io.github.marcocaballero;

import java.util.Arrays;

public class Algorithm {

	public static void printResultsAsTable(int[][] results) {
		System.out.println("REPORTS ( TABLE )");
		System.out.println("\n");
		for (int[] row : results) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println("\n");
	}

	public static void printResultsAsCalendar(int[][] results) {
		System.out.println("REPORTS ( CALENDAR )");
		System.out.println("\n");
		for (int w = 0; w < results.length - 1; w++) {
			System.out.println("WEEK " + w);
			System.out.println();
			for (int tr = 0; tr < results.length; tr++) {
				System.out.println(tr + " vs " + results[tr][w]);
			}
			System.out.println();
		}
		System.out.println();
	}

	protected static int[][] checkOdd(int n) {
		int[][] t;
		if (n % 2 == 0) {
			t = new int[n][n - 1];
		} else {
			System.out.println("The N-Team => " + (n+1) + " ( row: " + n + ") is the break for the teams \n" );
			t = new int[n + 1][n];
		}
		return t;
	}
}

package io.github.marcocaballero;

import java.util.ArrayList;

public class BruteForceScheduler extends Algorithm {

	public static int[][] generateResults(int n) {
		int[][] t = checkOdd(n);

		ArrayList<Integer> teams = new ArrayList<>();
		for (int i = 0; i < t.length; i++) {
			teams.add(i);
		}

		for (int weekPos = 0; weekPos < teams.size() - 1; weekPos++) {
			roundRobin(teams, t, weekPos); // for (n/2) E O(n/2)
			teams = combineLists(teams); // for (n) E O(n)
		}
		return t;

	}

	private static void roundRobin(ArrayList<Integer> teams, int[][] t, int weekPos) {
		for (int i = 0, j = teams.size() - 1; i < j; i++, j--) {
			t[teams.get(i)][weekPos] = teams.get(j);
			t[teams.get(j)][weekPos] = teams.get(i);
		}
	}

	private static ArrayList<Integer> combineLists(ArrayList<Integer> teams) {
		int buffer = teams.get(1);

		for (int i = 1; i < teams.size() - 1; i++) {
			teams.set(i, teams.get(i + 1));
		}

		teams.set(teams.size() - 1, buffer);
		return teams;
	}

}

package io.github.marcocaballero;

import java.util.ArrayList;

public class BruteForceScheduler extends Scheduler {

	public BruteForceScheduler(ArrayList<Team> teams) {
		super(teams);
	}

	public Team[][] generateSolution() { // n * (n + n) € O(2n^2)
		Team[][] matches = new Team[teams.size()-1][teams.size()];
		for (int weekPos = 0; weekPos < teams.size() - 1; weekPos++) {
			printWeek(matches, weekPos);
			combineLists();
		}
		return matches;
	}

	private void printWeek(Team[][] teamsAux, int weekPos) {
		System.out.println("WEEK - " + (weekPos + 1));
		for (int i = 0, j = teams.size() - 1; i < j; i++, j--) {
			teamsAux[weekPos][i] = teams.get(j);
			teamsAux[weekPos][j] = teams.get(i);
			System.out.println(teams.get(i) + "vs" + teams.get(j));
		}
		System.out.println();
	}

	private void combineLists() {
		Team buffer = teams.get(1);

		for (int i = 1; i < teams.size() - 1; i++) {
			teams.set(i, teams.get(i + 1));
		}

		teams.set(teams.size() - 1, buffer);
	}
}

package io.github.marcocaballero;

import java.util.ArrayList;

public class BruteForceScheduler {
	private ArrayList<Team> teams;

	public BruteForceScheduler(ArrayList<Team> teams) {
		this.teams = teams;
		if (isOddMatch()) {
			this.setBreakTeam();
		}
	}

	public Team[][] generateSolution() { // n * (n + n) � O(2n^2)
		Team[][] teamsAux = new Team[teams.size()][teams.size()];

		for (int weekPos = 0; weekPos < teams.size() - 1; weekPos++) { 
			System.out.println("WEEK - " + (weekPos + 1));
			for (int i = 0, j = teams.size() - 1; i < j; i++, j--) {
				teamsAux[weekPos][i] = teams.get(j);
				teamsAux[weekPos][j] = teams.get(i);
				System.out.println(teams.get(i) + "vs" + teams.get(j));
			}
			System.out.println();
			Team buffer = teams.get(1);

			for (int i = 1; i < teams.size() - 1; i++) {
				teams.set(i, teams.get(i + 1));
			}

			teams.set(teams.size() - 1, buffer);
		}
		return teamsAux;
	}

	private boolean isOddMatch() {
		return (teams.size() % 2 != 0);
	}

	private void setBreakTeam() {
		teams.add(TeamBuilder.buildNullable());
	}
}

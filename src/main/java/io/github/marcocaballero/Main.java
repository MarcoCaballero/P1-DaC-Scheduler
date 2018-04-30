package io.github.marcocaballero;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Team> teams = new ArrayList<>();
		for (int i = 1; i < 25; i++) {
			Team team1 = TeamBuilder.build("Team " + i);
			teams.add(team1);
		}
		new BruteForceScheduler(teams).generateSolution();
	}

}

package io.github.marcocaballero;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Team> teams = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			Team team1 = TeamBuilder.build("Team " + i);
			teams.add(team1);
		}
		//new BruteForceScheduler(teams).generateSolution();
//		new DaCScheduler(teams).generateSolution();
		
		for (Team[] row : new DaCScheduler(teams).generateSolution()) {
			System.out.println(Arrays.asList(row));
		}
		
//		for (Team[] row : new BruteForceScheduler(teams).generateSolution()) {
//			System.out.println(Arrays.asList(row));
//		}
	}

}

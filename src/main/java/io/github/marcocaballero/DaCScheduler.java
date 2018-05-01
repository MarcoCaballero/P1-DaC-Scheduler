package io.github.marcocaballero;

import java.util.ArrayList;

public class DaCScheduler extends Scheduler {

	public DaCScheduler(ArrayList<Team> teams) {
		super(teams);
	}

	@Override
	public Team[][] generateSolution() {
		Team[][] matches = new Team[teams.size() -1][teams.size()];
		divideAndConquer(matches, 0, teams.size() - 1);
		return matches;
	}

	private Team[][] divideAndConquer(Team[][] matches, int first, int last) {
		int middle;
		if (last - first == 1) {
			matches[0][first] = teams.get(last);
			matches[0][last] = teams.get(first);
		} else {
			middle = ((first + last) / 2) + first;
			divideAndConquer(matches, first, middle);
			divideAndConquer(matches, middle + 1, last);
			mergeResults(matches, first, middle, middle, last - 1, middle + 1);
			mergeResults(matches, middle + 1, last, middle, last - 1, first);
		}
		return matches;
	}

	private Team[][] mergeResults(Team[][] matches, int bottomTeamPos, int upperTeamPos, int bottomWeek, int upperWeek, int pivotTeamPos) {
		for (int week = bottomWeek; week <= upperWeek; week++) {
			int pos = pivotTeamPos + week - bottomWeek;
			matches[week][bottomTeamPos] = teams.get(pos);
		}
		
		for (int t = bottomTeamPos + 1; t <= upperTeamPos; t++) {
			matches[t][bottomWeek] = matches[t-1][upperWeek];
			for (int week = bottomWeek + 1; week <= upperWeek; week++) {
				matches[t][week] = matches[t-1][week - 1];
			}
		}
		return matches;
	}
}

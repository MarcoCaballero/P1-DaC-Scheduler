package io.github.marcocaballero;

import java.util.ArrayList;

public abstract class Scheduler {
	protected ArrayList<Team> teams;

	protected Scheduler(ArrayList<Team> teams) {
		this.teams = teams;
		if (isOddMatch()) {
			this.setBreakTeam();
		}
	}
	
	public abstract Team[][] generateSolution();

	protected boolean isOddMatch() {
		return (teams.size() % 2 != 0);
	}

	protected void setBreakTeam() {
		teams.add(TeamBuilder.buildNullable());
	}
}

package io.github.marcocaballero;

import io.github.marcocaballero.Team;

public class TeamNull extends Team{

	public TeamNull(Long id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	public TeamNull(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "  "+ this.getName() +"  ";
	}
}

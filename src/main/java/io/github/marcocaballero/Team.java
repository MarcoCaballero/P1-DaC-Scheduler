package io.github.marcocaballero;

public class Team {
	private Long id;
	private String name;

	public Team(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Team(Long id) {
		this(id, new StringBuilder("team").append(id).toString());
	}

	@Override
	public String toString() {
		return "  " + this.getName() + " (" + this.getId() + ")" + "  ";
	}
}

package io.github.marcocaballero;

import java.util.concurrent.atomic.AtomicLong;

public class TeamBuilder {
private static AtomicLong ID_GENERATOR = new AtomicLong(1);
	
	public static Team build(String name) {
		return new Team(ID_GENERATOR.getAndIncrement(), name);
	}
	
	public static Team build() {
		return new Team(ID_GENERATOR.getAndIncrement());
	}
	
	public static TeamNull buildNullable() {
		return new TeamNull(ID_GENERATOR.getAndIncrement(), "DESCANSA");
	}
}

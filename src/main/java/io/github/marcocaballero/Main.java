package io.github.marcocaballero;

public class Main {

	public static void main(String[] args) {
		// int n = 8;
		// int n = 16;
		// int n = 64;
		int n = 7;
		// int n = 15;
		// int n = 31;

		Algorithm.printResultsAsTable(BruteForceScheduler.generateResults(n));
		// Algorithm.printResultsAsCalendar(BruteForceScheduler.generateResults(n));

		Algorithm.printResultsAsTable(DacScheduler.generateResults(n));
		// Algorithm.printResultsAsCalendar(BruteForceScheduler.generateResults(n));
	}

}

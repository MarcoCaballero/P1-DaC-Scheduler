package io.github.marcocaballero;

import java.util.Arrays;

public class Demo {
	public static void main(String[] args) {
		double cantidad = 35.27;
		double[] vs = { 2, 1, 0.5, 0.2, .1, .05, .02, .01 };
		double[][] sol = new double[vs.length][2];
		for (int i = 0; i < vs.length; i++) {
			sol[i][0] = vs[i];
		}

		greedy(sol, 0, cantidad);

		for (double[] row : sol) {
			System.out.println(Arrays.toString(row));
		}
	}

	public static double[][] greedy(double[][] sol, int idx, double cantidad) {

		if (!(cantidad >= 0.01)) {
			return sol;
		} else {
			sol[idx][1] = Math.floor(cantidad / (sol[idx][0]));
			cantidad -= sol[idx][1] * sol[idx][0];

			idx++;
			while (sol[idx][0] > cantidad && idx < sol.length - 1) {
				idx++;
			}

			greedy(sol, idx, cantidad);

		}
		return sol;
	}

}

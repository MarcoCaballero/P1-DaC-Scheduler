package io.github.marcocaballero;

public class Calendar {
	public int[][] calendar(int[][] tabla) {
		int superior = tabla.length - 1;
		tabla = formarTabla(tabla, 0, superior);
		return tabla;
	}

	private int[][] formarTabla(int[][] tabla, int inferior, int superior) {

		if (inferior == superior - 1) {
			tabla[inferior][0] = superior;
			tabla[superior][0] = inferior;
		} else {
			int medio = (inferior + superior) / 2;

			formarTabla(tabla, inferior, medio);
			formarTabla(tabla, medio + 1, superior);
			System.out.println("PRIMERO: inferior: " + inferior + ", superior: " + superior + ", medio: " + medio);
			completarTabla(tabla, inferior, medio, medio, superior - 1, medio + 1);

			System.out.println("SEGUNDO: inferior: " + inferior + ", superior: " + superior + ", medio: " + medio);
			completarTabla(tabla, medio + 1, superior,  medio, superior - 1, inferior);
			System.out.println("TERCERO: inferior: " + inferior + ", superior: " + superior + ", medio: " + medio);

			for (int i = medio + 1; i < superior; i++) {
				for (int j = 1; j < medio; j++) {
					tabla[i][j] = tabla[i - medio][j] + medio;
					System.out.println(
							"tabla[" + i + "][" + j + "] = tabla[" + (i - medio) + "][" + j + "]" + "+ " + medio);
					mostrarTabla(tabla);
				}
			}
		}

		return tabla;
	}

	private void completarTabla(int[][] tabla, int equInf, int equSup, int diaInf, int diaSup, int equInicial) {
		System.out.println("COMPLETAR TABLA");

		for (int j = diaInf; j <= diaSup; j++) {
			tabla[equInf][j] = equInicial + j - diaInf;
		}

		for (int i = equInf + 1; i <= equSup; i++) {
			// System.out.println(i +" "+ diaInf + " " + diaSup);
			// System.out.println("iteracion en completarTabla :" + i);
			// mostrarTabla(tabla);
			tabla[i][diaInf] = tabla[i - 1][diaSup];
			for (int j = diaInf + 1; j <= diaSup; j++) {
				tabla[i][j] = tabla[i - 1][j - 1];
			}
		}

	}

	public void mostrarTabla(int[][] tabla) {
		System.out.println();
		System.out.println(" TABLA ");
		System.out.println();
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla.length - 1; j++) {
				System.out.print(tabla[i][j] + "  ");
			}
			System.out.println();
		}

	}

}

package com.ubosque.estrucdata;

import java.util.Scanner;
import java.util.Vector;

public class Principal {

	/**
	 * Instacia de Matriz
	 */
	int[][] matriz;

	/**
	 * Metodo constructor
	 * 
	 * @param matriz
	 */
	public Principal(int[][] matriz) {
		super();
		this.matriz = matriz;
	}

	/**
	 * Metodo para asignar numeros aleatorios a cada campo de la matriz
	 */
	public void rellenarMatriz() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				int aleatorio = (int) (Math.random() * 9999) + 1;
				matriz[i][j] = aleatorio;
			}
		}
	}

	/**
	 * Visualiza los elementos de la matriz
	 */

	public void mostrarMatriz() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j] + "  ");
			}
			System.out.println();
		}
	}

	/**
	 * Suma todos los elementos en la matriz y divide por el numero de elementos
	 * existentes en la matriz
	 * 
	 * @return
	 */

	public double calcularPromedio() {
		double promedio = 0.0;
		double suma = 0.0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				suma += matriz[i][j];
			}
		}
		promedio = suma / (matriz.length * matriz.length);
		return promedio;
	}

	/**
	 * Ordenamiento de manera ascendente utilizando el algoritmo de ordenamiento
	 * seleccion.
	 * 
	 * @return
	 */
	public int[] ordenamientoA() {
		int[] array = new int[(matriz.length * matriz.length)];
		int k = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				array[k] = matriz[i][j];
				k++;
			}
		}
		algoBurbuja(array);
		return array;
	}

	/**
	 * Ordenamiento de manera descendente utilizando el algoritmo de ordenamiento
	 * seleccion.
	 * 
	 * @return
	 */
	public int[] ordenamientoD() {
		int[] array = new int[(matriz.length * matriz.length)];
		int k = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				array[k] = matriz[i][j];
				k++;
			}
		}
		algoritmoSeleccion(array);
		return array;
	}

	/**
	 * Algoritmo de ordenamiento utilizando el metodo burbuja.
	 * 
	 * @param array
	 */
	public void algoBurbuja(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					intercambio(array, i, j);
				}
			}
		}
	}

	/**
	 * Algoritmo de de ordenamiento utilizando el metodo de seleccion.
	 * 
	 * @param array
	 */
	public void algoritmoSeleccion(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] < array[j]) {
					intercambio(array, i, j);
				}
			}
		}
	}

	/**
	 * Metodo recurdivo para ser utilizando en los algoritmos de ordenamiento
	 * 
	 * @param array
	 * @param i
	 * @param j
	 */
	public void intercambio(int[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}

	/**
	 * Algoritmo utilizando la tecnica busqueda Binaria.
	 * 
	 * @param num
	 * @return
	 */
	public int busquedaBinaria(int num) {
		int[] array = ordenamientoA();
		int alto = (array.length - 1), bajo = 0, central;
		int valorC;
		while (bajo <= alto) {
			central = (bajo + alto) / 2;
			valorC = array[central];
			if (num == valorC) {
				return central;
			} else if (num < valorC) {
				alto = central - 1;
			} else {
				bajo = central + 1;
			}
		}
		return -1;
	}

	/**
	 * Algoritmo utilizando la tecnica de busqueda secuencial.
	 * 
	 * @param num
	 * @param rep
	 * @return
	 */
	public boolean busquedaSecuencial(int num, int rep) {
		int[] array = ordenamientoA();
		int contador = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == num) {
				contador++;
			}
		}
		return contador == rep ? true : false;
	}

	/**
	 * Metodo para hallar los numeros impares en la matriz y los ordena de forma
	 * ascendente en un vector.
	 *
	 * @return
	 */
	public int[] numerosImpares() {
		int[] array = ordenamientoA();
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				array[i] = 0;
			}
		}
		return array;
	}

	/**
	 * Metodo para hallar los numeros primos en la matriz y los ordena de forma
	 * descendente en un vector.
	 * @return
	 */
	public int[] numerosPrimos() {

		int[] array = ordenamientoD();
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j <= array[i]; j++) {
				if (array[i] % j == 0) {
					k++;
				}
			}
			if (k > 2) {
				array[i] = 0;
			}
			k = 0;
		}
		return array;
	}
	
	/**
	 * Metodo para hallar los multiplos y los ordena de forma
	 * ascendente en un vector.
	 * @param veces
	 * @param multiplos
	 * @return
	 */

	public int[] multiplosX(int veces, int multiplos) {

		int[] array = new int[veces];

		int iterador = 1;

		for (int i = 0; i < array.length; i++) {

			array[i] = multiplos * iterador;

			iterador++;

		}
		return array;

	}

	// Main method
	public static void main(String[] args) {
		// Scanner for input Console

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		try {
			System.out.println("------------------------------------------------");
			System.out.print("Orden de la matriz (nxn):  ");
			int orden = Integer.parseInt(keyboard.nextLine());
			int[][] matriz = new int[orden][orden];
			Principal principal = new Principal(matriz);
			System.out.println("------------------------------------------------");
			System.out.println("Su matriz:");
			principal.rellenarMatriz();
			principal.mostrarMatriz();
			System.out.println("------------------------------------------------");
			System.out.println("Promedio:  " + principal.calcularPromedio());
			System.out.println("------------------------------------------------");
			boolean loop = true;
			while (loop) {
				System.out.println("------------------------------------------------");
				System.out.println("1. Buscar numero en la matriz (Busqueda binaria).");
				System.out.println("2. Existe numero mas de m veces (Busqueda secuencial).");
				System.out.println("3. Numeros impares (Algoritmo de burbuja).");
				System.out.println("4. Numeros primos (Algoritmo de seleccion)");
				System.out.println("-------------------------------------------------------------");
				System.out.println("5. Primeros n multiplos de x (Algoritmo de insercion)");
				System.out.println("-------------------------------------------------------------");
				System.out.println("6. Salir");
				System.out.print("Opcion: ");
				int opcion = Integer.parseInt(keyboard.nextLine());
				switch (opcion) {
				case 1:
					System.out.println("-------------------------------------------------------------");
					System.out.print("-> Ingrese numero a buscar: ");
					int numB = Integer.parseInt(keyboard.nextLine());
					if (numB > 0) {
						if (principal.busquedaBinaria(numB) != -1) {
							System.out.println("-> El numero existe en la matriz");
						} else {
							System.out.println("-> El numero NO exite en la matriz");
						}
					} else {
						System.err.println("Numeros positivos");
					}
					break;
				case 2:
					System.out.println("-------------------------------------------------------------");
					System.out.print("-> Ingrese numero a buscar: ");
					int numS = Integer.parseInt(keyboard.nextLine());
					System.out.print("-> Ingrese numero de veces: ");
					int repS = Integer.parseInt(keyboard.nextLine());
					if (numS > 0) {
						if (principal.busquedaSecuencial(numS, repS)) {
							System.out.println("-> Su numero se repite " + repS + " veces. Efectivamente");
						} else {
							System.out.println("-> Su numero no se repite " + repS + " veces");
						}
					}
					break;
				case 3:
					System.out.println("-------------------------------------------------------------");
					int[] array = principal.numerosImpares();
					System.out.print("-> Impares: [");
					for (int i = 0; i < array.length; i++) {
						if (array[i] != 0) {
							System.out.print(" " + array[i]);
						}
					}
					System.out.println(" ]");
					break;
				case 4:
					System.out.println("-------------------------------------------------------------");
					int[] arrayPrimos = principal.numerosPrimos();
					System.out.print("-> Primos: [");
					for (int i = 0; i < arrayPrimos.length; i++) {
						if (arrayPrimos[i] != 0) {
							System.out.print(" " + arrayPrimos[i]);
						}
					}
					System.out.println(" ]");

					break;
				case 5:
					System.out.println("-------------------------------------------------------------");
					System.out.print("Ingresar numero para calcular multiplos:  ");
					int multiplos = Integer.parseInt(keyboard.nextLine());
					System.out.print("Ingresar numero de multiplos que desea consultar:  ");
					int veces = Integer.parseInt(keyboard.nextLine());
					int[] arrayMultiplos = principal.multiplosX(veces, multiplos);
					System.out.print("--> Multiplos [ ");

					for (int i = 0; i < arrayMultiplos.length; i++) {

						System.out.print(" " + arrayMultiplos[i]);

					}
					System.out.println(" ]");

					break;
				case 6:
					System.out.println("----------------------------------------------------------");
					System.out.println("Gracias por utilizar nuestros algoritmos. Vuelva pronto");
					System.out.println("----------------------------------------------------------");
					loop = false;
					break;

				default:
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Solo se ingresar numeros.");
		}
	}
}

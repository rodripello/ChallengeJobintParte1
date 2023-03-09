package com.jobint.ingreso.alphabetSoup;

public class WordSearcher {

	private char soup[][];

	public WordSearcher(char soup[][]) {
		this.soup = soup;
	}

	/**
	 * El objetivo de este ejercicio es implementar una función que determine si una
	 * palabra está en una sopa de letras.
	 *
	 * ### Reglas
	 * - Las palabras pueden estar dispuestas direcciones horizontal o vertical,
	 * _no_ en diagonal.
	 * - Las palabras pueden estar orientadas en cualquier sentido, esto es, de
	 * derecha a izquierda o viceversa, y de arriba
	 * para abajo o viceversa.
	 * - El cambio de dirección puede estar a media palabra, de modo que, por
	 * ejemplo, parte de la palabra
	 * esté horizontal y de izquierda a derecha, parte esté vertical y de arriba
	 * hacia abajo, y otra parte horizontal
	 * de derecha a la izquierda.
	 *
	 * @param word Palabra a buscar en la sopa de letras.
	 *
	 * @return {@link Boolean} true si la palabra se encuentra
	 *         en la sopa de letras.
	 */
	public boolean isPresent(String word) {

		for (int i = 0; i < soup.length; i++) {
			for (int j = 0; j < soup[i].length; j++) {
				if (soup[i][j] == word.charAt(0)) {
					if (i==2 && j==29){
						System.out.println("estoy aca");
					}
					boolean encontrado = true; //Si encuentra la primer letra ya pone como true y empieza a recorrer

					// Se busca en todas las direcciones
					//Con TRY CATCH podemos evitar que dicha excepción interrumpa el programa.
					//Comprobamos Horizontal hacia adelante
					try {
						for (int h = 1; h < word.length(); h++) {
							if (word.charAt(h) == soup[i][j + h]) {
								encontrado = true; //Sigue la busqueda
							}
							else {
								//Comprobamos Vertical hacia abajo
								int k = (j + h - 1);
								try {
									int cont=1;
									int contk=0;
									for (int v = h; v < word.length(); v++) {
										if (word.charAt(v) == soup[i + cont][k - contk]) {
											encontrado = true;
										}
										else {
											encontrado = false;
											break;
										}
										cont ++;
										contk ++;
									}
								} catch (ArrayIndexOutOfBoundsException ex) {
									encontrado = false;
								}
								//Comprobamos Vertical hacia arriba
								try {
									int cont=1;
									int contk=0;
									for (int v = h; v < word.length(); v++) {
										if (word.charAt(v) == soup[i - cont][k - contk]) {
											encontrado = true;
										}
										else {
											h=word.length();
											encontrado = false;
											break;
										}
										cont ++;
										contk ++;
									}
								} catch (ArrayIndexOutOfBoundsException ex) {
									encontrado = false;
									h=word.length();
								}
							}
						}
					} catch (ArrayIndexOutOfBoundsException ex) {
						//la palabra no está en esta dirección de búsqueda
						encontrado = false;
					}
					if (encontrado) {//Si se ha encontrado
						return true;
					}
					//Horizontal hacia atrás
					try {
						for (int h = 1; h < word.length(); h++) {
							if (word.charAt(h) == soup[i][j - h]) {
								encontrado = true;
							}
							else {
								//Comprobamos Vertical hacia abajo
								int k = (j + h - 1);
								try {
									int cont=1;
									int contk=0;
									for (int v = h; v < word.length(); v++) {
										if (word.charAt(v) == soup[i + cont][k - contk]) {
											encontrado = true;
										}
										else {
											encontrado = false;
											break;
										}
										cont ++;
										contk ++;
									}
								} catch (ArrayIndexOutOfBoundsException ex) {
									encontrado = false;
								}
								//Comprobamos Vertical hacia arriba
								try {
									int cont=1;
									int contk=0;
									for (int v = h; v < word.length(); v++) {
										if (word.charAt(v) == soup[i - cont][k - contk]) {
											encontrado = true;
										}
										else {
											h=word.length();
											encontrado = false;
											break;
										}
										cont ++;
										contk ++;
									}
								} catch (ArrayIndexOutOfBoundsException ex) {
									encontrado = false;
									h=word.length();
								}
							}
						}
					} catch (ArrayIndexOutOfBoundsException ex) {
						encontrado = false;
					}
					if (encontrado) {
						return true;
					}
					//Vertical hacia abajo
					try {
						for (int v = 1; v < word.length(); v++) {
							if (word.charAt(v) == soup[i + v][j]) {
								encontrado = true;
							}
							else {
								int k = (i + v - 1);
								//Comprobamos Horizontal hacia adelante
								try {
									int cont=1;
									int contk=0;
									for (int h = v; h < word.length() ; h++) {
										if (word.charAt(h) == soup[k - contk][j+cont]) {
											encontrado = true;
										}
											else {
											encontrado = false;
											break;
										}
										cont ++;
										contk ++;
									}
								} catch(ArrayIndexOutOfBoundsException ex) {

									encontrado = false;
								}
								//Comprobamos Horizontal hacia atras
								try {
									int cont=1;
									int contk=0;
									for (int h = v; h < word.length(); h++) {
										if (word.charAt(h) == soup[k - contk][j - cont]) {
											encontrado = true;
										}
										else {
											v=word.length();
											encontrado = false;
											break;
										}
										cont ++;
										contk ++;
									}
								} catch(ArrayIndexOutOfBoundsException ex) {
									encontrado = false;
									v=word.length();
								}
							}
						}
					} catch (ArrayIndexOutOfBoundsException ex) {
						encontrado = false;
					}
					if (encontrado) {
						return true;
					}

					//Vertical hacia arriba
					try {
						for (int v = 1; v < word.length(); v++) {
							if (word.charAt(v) == soup[i - v][j]) {
								encontrado = true;
							}
							else {
								int k = (i + v - 1);
								//Comprobamos Horizontal hacia adelante
								try {
									int cont=1;
									int contk=0;
									for (int h = v; h < word.length(); h++) {
										if (word.charAt(h) == soup[k - contk][j + cont]) {
											encontrado = true;
										}
											else {
											encontrado = false;
											break;
										}
										cont ++;
										contk ++;
									}
								} catch(ArrayIndexOutOfBoundsException ex) {

									encontrado = false;
								}
								//Comprobamos Horizontal hacia atras
								try {
									int cont=1;
									int contk =0;
									for (int h = v; h < word.length(); h++) {
										if (word.charAt(h) == soup[k - contk][j-cont]) {
											encontrado = true;
										}
										else {
											v=word.length();
											encontrado = false;
											break;
										}
										cont ++;
										contk ++;
									}
								} catch(ArrayIndexOutOfBoundsException ex) {
									encontrado = false;
									v=word.length();
								}
							}
						}
					} catch (ArrayIndexOutOfBoundsException ex) {
						encontrado = false;
					}
					if (encontrado) {
						return true;
					}
				}
			}
		}
		return false;
	}
}

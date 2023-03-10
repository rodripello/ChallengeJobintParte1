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

	//Solo busca palabras en los siguientes sentidos
	//Horizontal hacia adelante y hacia atras
	//Vertical hacia arriba y hacia abajo
	//Solo puede cambiar de sentido una vez es decir de Vertical a Horizontal y viceversa
	//No se contempla caso de cambio de mas de una direccion es decir de Vertical a Horizontal y otra vez a Vertical
	//Debido a esto ultimo no pasa todos los tests
	public boolean isPresent(String word) {

		for (int i = 0; i < soup.length; i++) {
			for (int j = 0; j < soup[i].length; j++) {
				if (soup[i][j] == word.charAt(0)) {
					boolean encontrado = true; //Si encuentra la primer letra ya pone como true y empieza a recorrer

					// Se busca en todas las direcciones
					//Con TRY CATCH podemos evitar que dicha excepción interrumpa el programa.
					//Comprobamos Horizontal hacia adelante
					try {
						for (int h = 1; h < word.length(); h++) {
							if (word.charAt(h) == soup[i][j + h]) {
								encontrado = true; //Sigue la busqueda
							} else {
								if (h > 1){
									//Comprobamos Vertical hacia abajo
									int k = (j + h - 1);
									int resg=h;
									h=word.length();
								try {
									int cont = 1;
									for (int v = resg; v < word.length(); v++) {
										if (word.charAt(v) == soup[i + cont][k]) {
											encontrado = true;
										} else {
											encontrado = false;
											break;
										}
										cont++;
									}
								} catch (ArrayIndexOutOfBoundsException ex) {
									encontrado = false;
								}
								if(!encontrado) {
									//Comprobamos Vertical hacia arriba
									try {
										int cont = 1;
										for (int v = resg; v < word.length(); v++) {
											if (word.charAt(v) == soup[i - cont][k]) {
												encontrado = true;
											} else {
												h = word.length();
												encontrado = false;
												break;
											}
											cont++;
										}
									} catch (ArrayIndexOutOfBoundsException ex) {
										encontrado = false;
										h = word.length();
									}
								}
							}
								else{
									h=word.length();
									encontrado=false;
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
								if (h > 1){
									//Comprobamos Vertical hacia abajo
									int k = (j + h - 1);
									int resg=h;
									h=word.length();
								try {
									int cont = 1;
									for (int v = resg; v < word.length(); v++) {
										if (word.charAt(v) == soup[i + cont][k]) {
											encontrado = true;
										} else {
											encontrado = false;
											break;
										}
										cont++;
									}
								} catch (ArrayIndexOutOfBoundsException ex) {
									encontrado = false;
								}
								if (!encontrado) {
									//Comprobamos Vertical hacia arriba
									try {
										int cont = 1;
										for (int v = resg; v < word.length(); v++) {
											if (word.charAt(v) == soup[i - cont][k]) {
												encontrado = true;
											} else {
												h = word.length();
												encontrado = false;
												break;
											}
											cont++;
										}
									} catch (ArrayIndexOutOfBoundsException ex) {
										encontrado = false;
										h = word.length();
									}
								}
							}
								else{
									h=word.length();
									encontrado=false;
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
								if (v > 1){
									int k = (i + v - 1);
									int resg=v;
									v=word.length();
								//Comprobamos Horizontal hacia adelante
								try {
									int cont = 1;
									for (int h = resg; h < word.length(); h++) {
										if (word.charAt(h) == soup[k][j + cont]) {
											encontrado = true;
										} else {
											encontrado = false;
											break;
										}
										cont++;
									}
								} catch (ArrayIndexOutOfBoundsException ex) {

									encontrado = false;
								}
								if(!encontrado) {
									//Comprobamos Horizontal hacia atras
									try {
										int cont = 1;
										for (int h = resg; h < word.length(); h++) {
											if (word.charAt(h) == soup[k][j - cont]) {
												encontrado = true;
											} else {
												v = word.length();
												encontrado = false;
												break;
											}
											cont++;
										}
									} catch (ArrayIndexOutOfBoundsException ex) {
										encontrado = false;
										v = word.length();
									}
								}
							}
								else{
									v=word.length();
									encontrado=false;
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
							} else {
								if (v > 1){
									int k = (i + v - 1);
									int resg=v;
									v=word.length();
								//Comprobamos Horizontal hacia adelante
								try {
									int cont = 1;
									for (int h = resg; h < word.length(); h++) {
										if (word.charAt(h) == soup[k][j + cont]) {
											encontrado = true;
										} else {
											encontrado = false;
											break;
										}
										cont++;
									}
								} catch (ArrayIndexOutOfBoundsException ex) {

									encontrado = false;
								}
								if(!encontrado) {
									//Comprobamos Horizontal hacia atras
									try {
										int cont = 1;
										for (int h = resg; h < word.length(); h++) {
											if (word.charAt(h) == soup[k][j - cont]) {
												encontrado = true;
											} else {
												v = word.length();
												encontrado = false;
												break;
											}
											cont++;
										}
									} catch (ArrayIndexOutOfBoundsException ex) {
										encontrado = false;
										v = word.length();
									}
								}
							}
								else{
									v=word.length();
									encontrado=false;
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

package com.jobint.ingreso.strings;

import java.util.ArrayList;
import java.util.List;

public class RepeatedCharacters {
	public static final int MAX_CANT_CARACTERES = 256;

	/**
	 * El metodo debe retornar un booleano indicando si el parametro `cadena` cumple
	 * con alguna de las siguientes propiedades: 1- Todos los caracteres aparecen la
	 * misma cantidad de veces. Ejemplos: "aabbcc", "abcdef", "aaaaaa" 2- Todos los
	 * caracteres aparecen la misma cantidad de veces, a excepcion de 1, que aparece
	 * un vez mas o una vez menos. Ejemplos: "aabbccc", "aabbc", "aaaaccccc"
	 * 
	 * @param cadena la cadena a evaluar
	 * @return booleano indicando si la cadena cumple con las propiedades
	 */
	public Boolean isValid(String cadena) {
		//VARIABLES
		char[] letras = cadena.toCharArray();
		//defino lista donde controlo si la letra a analizar ya fue procesado
		List<Character> controlLetras = new ArrayList<>();
		List<Integer> controlRepetidos = new ArrayList<>();
		//Manejo la cantidad de letras que se repiten en cantidades diferentes
		int contadorControl=0;
		boolean valido = false;
		//Proceso donde arranco el recorrido de mi cadena de caracteres
		for (int i = 0; i < letras.length; i++) {
			//defino contador para saber la cantidad de veces que se repite letra en cadena
			int contador = 1;
			char letra = letras[i];
			boolean letraProcesada=false;
			//Analizo la primer letra
			if (i == 0) {
				for (int j = i + 1; j < letras.length; j++) {
					if (letras[i] == letras[j]) {
						contador++;
					}
				}
				controlLetras.add(letra);
			} else {
				//Controlo si el caracter ya fue procesado anteriormente
				boolean findLetra =false;
				for(Character letraLista:controlLetras){
					if (letra == letraLista){
						findLetra=true;
						letraProcesada=true;
					}
				}
				if (!findLetra){
					for (int j = i + 1; j < letras.length; j++) {
						if (letras[i] == letras[j]) {
							contador++;
						}
					}
					controlLetras.add(letra);
				}
			}
			//Vuelvo a controlar si la letra ya fue procesada
			if(!letraProcesada) {
				if (controlRepetidos.size() == 0) {
					controlRepetidos.add(contador);
					contadorControl++;
				} else {
					boolean letraCantNoRepetida = false;
					for (Integer repetido : controlRepetidos) {
						if (controlRepetidos.size() > 1) {
							if (contador == repetido) {
								letraCantNoRepetida = true;
							}
						} else {
							if (contador == repetido) {
								letraCantNoRepetida = true;
							}
						}
					}
					if (!letraCantNoRepetida) {
						contadorControl++;
						controlRepetidos.add(contador);
					}
				}
			}
		}
		//controlo que mi contralor sea menor a dos es decir que todas las letras se repitan la misma cantidad de veces
		if (contadorControl<2){
			valido = true;
		}
		else {
			// controlo si se repiten la misma cantidad de veces excepto 1
			if(controlRepetidos.size()<3){
				//verifico que la cantidad sea +/- 1
				if (Math.abs(controlRepetidos.get(0) - controlRepetidos.get(1))==1){
					valido=true;
				}
			}
		}
		return valido;
	}
}

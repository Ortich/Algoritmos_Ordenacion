/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosordenacion;

import java.util.Arrays;

/**
 *
 * @author Usuario
 */
public class AlgoritmosOrdenacion {

    public void ordenacionBurbuja(int[] numeros) {
	int aux;
	boolean cambio = true;
	while (cambio) {
	    cambio = false;
	    for (int i = 0; i < numeros.length - 1; i++) {
		if (numeros[i] > numeros[i + 1]) {
		    aux = numeros[i + 1];
		    numeros[i + 1] = numeros[i];
		    numeros[i] = aux;
		    cambio = true;
		}
	    }
	    System.out.println(Arrays.toString(numeros));
	}
    }

    public void ordenacionInsercion(int[] numeros) {
	int aux;
	boolean situado;
	for (int i = 0; i < numeros.length; i++) {
	    situado = false;
	    for (int j = i; j > 0 && !situado; j--) {
		if (numeros[j] < numeros[j - 1]) {
		    aux = numeros[j - 1];
		    numeros[j - 1] = numeros[j];
		    numeros[j] = aux;
		} else {
		    situado = true;
		}
		System.out.println(Arrays.toString(numeros));
	    }
	    System.out.println();
	}
    }

    public void ordenacionShellShort(int[] numeros) {
	int tamaño = numeros.length / 2;
	int aux;
	int pos1;
	int pos2;
	for (int j = tamaño; j>=1; j=j/2) {
	    for (int i = 0; i < numeros.length - j; i++) {
		System.out.println(Arrays.toString(numeros));
		if (numeros[i] > numeros[i + j]) {
		    aux = numeros[i];
		    numeros[i] = numeros[i + j];
		    numeros[i + j] = aux;
		    pos1 = i;
		    pos2 = i-j;
		    if(pos2>=j-1&& numeros[pos2] > numeros[pos1]){
			while(pos2>=j-1){
			System.out.println(Arrays.toString(numeros));
			if(numeros[pos2] > numeros[pos1]){
			    aux = numeros[pos2];
			    numeros[pos2] = numeros[pos1];
			    numeros[pos1] = aux;
			}
			pos1 = pos2;
			pos2 -= j;
		    }
		    }
		}
	    }
	    System.out.println();
	}
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	// TODO code application logic here
	AlgoritmosOrdenacion prueba = new AlgoritmosOrdenacion();

	int[] numeros = {57, 22, 11, 13, 21, 7};
	prueba.ordenacionBurbuja(numeros);

	System.out.println();
	System.out.println("<------------------------------------------------------------------------------------->");
	System.out.println();

	int[] numeros2 = {57, 22, 11, 13, 21, 7};
	prueba.ordenacionInsercion(numeros2);

	System.out.println();
	System.out.println("<------------------------------------------------------------------------------------->");
	System.out.println();

	int[] numeros3 = {61, 109, 149, 111, 34, 2, 24, 119, 122, 125, 27, 145};
	prueba.ordenacionShellShort(numeros3);
    }

}

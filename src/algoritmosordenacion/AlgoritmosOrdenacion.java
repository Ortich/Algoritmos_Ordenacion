/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosordenacion;

import java.util.Arrays;
import java.util.Random;

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
	    //System.out.println(Arrays.toString(numeros));
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
//		System.out.println(Arrays.toString(numeros));
	    }
//	    System.out.println();
	}
    }

    public void ordenacionShellShort(int[] numeros) {
	int tamaño = numeros.length / 2;
	int aux;
	int pos1;
	int pos2;
	for (int j = tamaño; j>=1; j=j/2) {
	    for (int i = 0; i < numeros.length - j; i++) {
//		System.out.println(Arrays.toString(numeros));
		if (numeros[i] > numeros[i + j]) {
		    aux = numeros[i];
		    numeros[i] = numeros[i + j];
		    numeros[i + j] = aux;
		    pos1 = i;
		    pos2 = i-j;
		    if(pos2>=j-1&& numeros[pos2] > numeros[pos1]){
			while(pos2>=j-1){
//			System.out.println(Arrays.toString(numeros));
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
//	    System.out.println();
	}
    }

    public void quickSort(int[] numeros, int izquierda, int derecha) {
	int i = izquierda;
	int j = derecha;
	// toma como pivote el primer elemento de la izquierda
	int pivot = numeros[izquierda];
	while (i <= j) {
	// en cada pasada del bucle se busca un número mayor que el pivote por
	// la izquierda y un numero menor que
	// el pivote por la derecha. Si los encuentra, los intercambia
	    while (numeros[i] < pivot) {
		i++;
	    }
	    while (numeros[j] > pivot) {
		j--;
	    }
	    if (i <= j) {
		int aux = numeros[i];
		numeros[i] = numeros[j];
		numeros[j] = aux;
	    //actualiza los indices por la derecha y por la izquierda
		i++;
		j--;
	    }
	}
	// llama a quickSort() de forma recursiva con los dos subarrays que han quedado
	if (izquierda < j) {
	    quickSort(numeros, izquierda, j);
	}
	if (i < derecha) {
	    quickSort(numeros, i, derecha);
	}
    }

    public void ponNumeros(int[] a1, int[] a2, int[] a3, int[] a4){
	int numero;
	for (int i = 0; i<a1.length; i++){
	    Random random = new Random();
	    numero = random.nextInt();
	    
	    a1[i] = numero;
	    a2[i] = numero;
	    a3[i] = numero;
	    a4[i] = numero;
	}
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	// TODO code application logic here
	AlgoritmosOrdenacion prueba = new AlgoritmosOrdenacion();
	
	int a1[] = new int[100000];
	int a2[] = new int[100000];
	int a3[] = new int[100000];
	int a4[] = new int[100000];
	
	long t1_1;
	long t1_2;
	long t2_1;
	long t2_2;
	long t3_1;
	long t3_2;
	long t4_1;
	long t4_2;
	
	
	prueba.ponNumeros(a1, a2, a3, a4);
	
//	\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

	t1_1 = System.nanoTime();
	prueba.ordenacionBurbuja(a1);
	t1_2 = System.nanoTime();
	
	t2_1 = System.nanoTime();
	prueba.ordenacionInsercion(a2);
	t2_2 = System.nanoTime();
	
	t3_1 = System.nanoTime();
	prueba.ordenacionShellShort(a3);
	t3_2 = System.nanoTime();
		
	t4_1 = System.nanoTime();
	prueba.quickSort(a4, 0, a4.length-1);
	t4_2 = System.nanoTime();
	
//	\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	System.out.println("Metodo burbuja");
	System.out.println((double)(t1_2-t1_1)/1000000000.0 + " Segundos");
	
	System.out.println();
	System.out.println("----------------------------------------------------------------");
	System.out.println();
	
	System.out.println("Ordenacion Insercion");
	System.out.println((double)(t2_2-t2_1)/1000000000.0 + " Segundos");
	
	System.out.println();
	System.out.println("----------------------------------------------------------------");
	System.out.println();
	
	System.out.println("Ordenacion Shell Short");
	System.out.println((double)(t3_2-t3_1)/1000000000.0 + " Segundos");
	
	System.out.println();
	System.out.println("----------------------------------------------------------------");
	System.out.println();
	
	System.out.println("Ordenacion Quick Short");
	System.out.println((double)(t4_2-t4_1)/1000000000.0 + " Segundos");
	
	System.out.println();
	System.out.println("----------------------------------------------------------------");
	System.out.println();
	
    }

}

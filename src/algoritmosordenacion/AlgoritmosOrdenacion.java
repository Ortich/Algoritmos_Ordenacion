/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosordenacion;

/**
 *
 * @author Usuario
 */
public class AlgoritmosOrdenacion {

    public void ordenacionBurbuja(int [] numeros){
	int aux;
	for(int i = 0; i< numeros[i+1];i++){
	    if(numeros[i] > numeros[i+1]){
		aux = numeros[i+1];
		numeros[i+1] = numeros[i];
		numeros[i]=aux;
	    }
	}
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	// TODO code application logic here
    }
    
}

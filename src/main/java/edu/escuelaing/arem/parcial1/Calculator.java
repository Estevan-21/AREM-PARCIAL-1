/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.parcial1;

import java.util.ArrayList;

/**
 *
 * @author estudiante
 */
public class Calculator {
    static ArrayList<Float> lista=new ArrayList<Float>();
    
    /**
     * Cerador de la clase    
     */
    public Calculator(){
        
    }
    
    /**
     * Método Principal del programa
     * @param ArrayList<Float> lista
     * @return  maximo es el número máximo del arreglo
     */
    public Float getMax(ArrayList<Float> lista){
        Float maximo = lista.get(0);        
		for (int i = 0; i < lista.size(); i++){
			if (maximo < lista.get(i))
				maximo = lista.get(i);			
		}
        return maximo;
    }
    
    /**
     * Método Principal del programa
     * @param ArrayList<Float> lista
     * @return  minimo es el número mínimo del arreglo
     */
    public Float getMin(ArrayList<Float> lista){        
        Float minimo = lista.get(0);
		for (int i = 0; i < lista.size(); i++){
			if (minimo > lista.get(i))
				minimo = lista.get(i);			
		}
        return minimo;
    }
    
    /**
     * Método Principal del programa
     * @param ArrayList<Float> lista
     * @return  suma es la suma de los numeros del arreglo
     */
    public int getSum(ArrayList<Float> lista){        
        int suma = 0; //                
		for (int i = 0; i < lista.size(); i++){
			suma+= lista.get(i);							
		}
        return suma;
    }
    
    
    /**
     * Método Principal del programa
     * @param ArrayList<Float> lista
     * @return  mult es la multiplicacion de los numeros del arreglo
     */
    public int getMult(ArrayList<Float> lista){        
        int multi =1; 

		for (int i = 0; i < lista.size(); i++){
			multi*= lista.get(i);							
		}
        return multi;
    }
    
}

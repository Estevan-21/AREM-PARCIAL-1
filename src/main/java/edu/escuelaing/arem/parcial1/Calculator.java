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
    
    public Calculator(){
        
    }
    
    public Float getMax(ArrayList<Float> lista){
        Float maximo = lista.get(0);        
		for (int i = 0; i < lista.size(); i++){
			if (maximo < lista.get(i))
				maximo = lista.get(i);			
		}
        return maximo;
    }
    
    public Float getMin(ArrayList<Float> lista){        
        Float minimo = lista.get(0);
		for (int i = 0; i < lista.size(); i++){
			if (minimo > lista.get(i))
				minimo = lista.get(i);			
		}
        return minimo;
    }
    
    public int getSum(ArrayList<Float> lista){        
        int suma = 0; //                
		for (int i = 0; i < lista.size(); i++){
			suma+= lista.get(i);							
		}
        return suma;
    }
    
    public int getMult(ArrayList<Float> lista){        
        int multi =1; 

		for (int i = 0; i < lista.size(); i++){
			multi*= lista.get(i);							
		}
        return multi;
    }
    
}

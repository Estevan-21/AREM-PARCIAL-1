    package edu.escuelaing.arem.tarea;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.List;
import spark.Request;
import spark.Response;
import static spark.Spark.*;


/**
 * Tarea 1 AREM
 *
 * @author Vargas Brayam
 * 
 */
public class Tarea {
    static ListaDinamica lista=new ListaDinamica();
    static double[] numeros={15.0,69.9,6.5,22.4,28.4,65.9,19.4,198.7,38.8,138.2};     
    
    
    /**
     * Método Principal del programa
     * @param args args
     * @throws  java.io.IOException excepcion
     */
    public static void main(String[] args) {
        //leer("C:/Users/Estevan/Desktop/archivo2.txt");              
        port(getPort());
        get("/lab02", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
    }

    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h1>CALCULADORA DE MEDIA Y DESVIACION ESTANDAR</h1>"
                + "<h2>AREM 2018-2</h2>"
                + "<h3>Por favor ingrese los números a ser procesados</h3>"
                + "<form action=\"/results\">"
                + "  Ingrese los números separados por un espacio:<br>"
                + "  <input type=\"text\" name=\"firstname\" value=\"\">"
                + "  <br>"
                + "  <br> <br>"                  
                + "  <input type=\"submit\" value=\"Enviar\">"
                + "</form>"
                + "<p>Al hacer click en el botón \"Enviar\",sus datos serán procesados y será redirigido a la página \"/results\".</p>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    private static String resultsPage(Request req, Response res) {        
        String[] arre=req.queryParams("firstname").split("\\s+");
        for(int a=0;a<arre.length;a++){
            lista.addLast(Float.parseFloat(arre[a]));
        }
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"                
                + "<h2>AREM 2018-2</h2>"
                + "<h3>La media de los números ingresados es:</h3>"
                + calculoMedia(lista)
                + "<h3>La desviación estandar de los números ingresados es:</h3>"
                + calculoDesviacion(lista)                
                + "</body>"
                + "</html>";
        return pageContent;
    }

    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     *
     * Heroku provides the port automatically so you need this to run the
     * project on Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }


    
    
    /**
     * Lee los números de un archivo .txt y los almacena en una lista enlazada
     * @throws java.io.IOException IoException
     * @throws java.io.FileNotFoundException IoException
     * @param archivo archivo
     *
    public static void leer() throws FileNotFoundException, IOException {
        String cadena; 
       
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena =b.readLine())!=null) {
            float a=Float.parseFloat(cadena);
            lista.addLast(a);
        }
        b.close();
    }  */ 
    
    
    /**
     * Calcula la media de los números que se encuentran en una lista enlazada
     *
     * @param lista lista
     * @return media de los números
     */
    public static float calculoMedia(ListaDinamica lista){
        float media=0;
        float valor=0;        
        for(int i=0;i<lista.size();i++){
            valor=Float.parseFloat(lista.get(i).toString());
            media=media+valor;
        }        
       media= media/lista.size();
        return media;
    }
    
    /**
     * Calcula la desviacion estandar de los números que se encuentran en una lista enlazada
     *
     * @param lista lista
     * @return desviacion estandar de los números
     */
    public static float calculoDesviacion(ListaDinamica lista){ 
        float sumatoria=0;
        float valor=0;
        float media2=calculoMedia(lista);
        float desviacion=0;
        for(int i=0;i<lista.size();i++){
            valor=Float.parseFloat(lista.get(i).toString())-media2;
            valor=valor*valor;
            sumatoria=sumatoria+valor;
        }        
        desviacion=sumatoria/(lista.size()-1); 
        desviacion=(float) sqrt(desviacion);
        return desviacion;
    }
 
}

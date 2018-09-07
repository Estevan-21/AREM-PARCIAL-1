/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.parcial1;

import java.util.ArrayList;
import spark.Request;
import spark.Response;
import static spark.Spark.get;
import static spark.Spark.port;


/**
 *
 * @author estudiante
 */
public class ReadWrite {
    
    static ArrayList<Float> lista=new ArrayList<Float>();  
    static Calculator calc=new Calculator(); 
    

    public ReadWrite(){
        port(getPort());
        get("/numbers", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
    }
    
    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h1>PARCIAL 1</h1>"
                + "<h2>AREM 2018-2</h2>"
                + "<h3>Por favor ingrese los números a ser procesados</h3>"
                + "<form action=\"/results\">"
                + "  Ingrese los números separados por un espacio:<br>"
                + "  <input type=\"text\" name=\"num\" value=\"\">"
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
        String[] arre=req.queryParams("num").split("\\s+");        
        for(int a=0;a<arre.length;a++){
            lista.add(Float.parseFloat(arre[a]));
        }    

        // {nombre:"filename.java",directorio:"undirectorio-imaginario"}
        String result="{\"lista\":"+"\""+lista+"\""+",\"maximo\":"+"\""+calc.getMax(lista)+"\""+",\"minimo\":"+"\""+calc.getMin(lista)+"\""+",\"suma\":"+"\""+calc.getSum(lista)+"\""+",\"multiplicacion\":"+"\""+calc.getMult(lista)+"\""+"}";
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"                
                + "<h2>AREM 2018-2</h2>"
                + result
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
}

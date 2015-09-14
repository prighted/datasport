/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasport;
import java.io.*;
/**
 *
 * @author rafael
 */

public class Lectora {
    
    public Lectora(){
        //clase constructora
    }
    
    public void leerConfig(String ruta){ //recibe la ruta del archivo txt
        BufferedReader br = null;
       String   limInf, limSup,noLaps,inc,vel,k;
       
       try{
           String linea;
           br = new BufferedReader(new FileReader(ruta));
           while((linea = br.readLine())!=null){
               String [] elementos = linea.split(",");
               if(elementos[0].equals("limInf")){
                   limInf = elementos[1];
               }
               if(elementos[0].equals("limSup")){
                   limSup = elementos[1];
               }
               if(elementos[0].equals("noLaps")){
                   noLaps = elementos[1];
               }
               if(elementos[0].equals("inc")){
                   inc = elementos[1];
               }
               if(elementos[0].equals("vel")){
                   vel = elementos[1];
               }
               if(elementos[0].equals("K")){
                   k = elementos[1];
               }
           }
       }catch(Exception e){
           System.out.println("No se encuentra el archivo");
       }finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
}
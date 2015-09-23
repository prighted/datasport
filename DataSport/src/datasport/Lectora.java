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
    
    private float limInf, limSup, inc, vel, k,limSupInc,limInfInc,increVel,increInc;
    private int noLaps, distVuelta;
    private long intCal,intPan;
    private String ruta;
    
    public Lectora(String ruta)
    {
    this.ruta = ruta;
    leerConfig(ruta);
    }
    
    public void leerConfig(String ruta){ //recibe la ruta del archivo txt
        BufferedReader br = null;
       
       
       try{
           String linea;
           br = new BufferedReader(new FileReader(ruta));
           while((linea = br.readLine())!=null){
               String [] elementos = linea.split(",");
               if(elementos[0].equals("limInf")){
                   limInf = Float.parseFloat(elementos[1]);
               }
               if(elementos[0].equals("limSup")){
                   limSup = Float.parseFloat(elementos[1]);
               }
               if(elementos[0].equals("noLaps")){
                   noLaps = Integer.parseInt(elementos[1]);
               }
               if(elementos[0].equals("inc")){
                   inc = Float.parseFloat(elementos[1]);
               }
               if(elementos[0].equals("vel")){
                   vel = Float.parseFloat(elementos[1]);
               }
               if(elementos[0].equals("K")){
                   k = Float.parseFloat(elementos[1]);
               }
                if(elementos[0].equals("intCal")){
                  intCal = (long)Float.parseFloat(elementos[1]);
               }
                if(elementos[0].equals("intPan")){
                  intPan = (long)Float.parseFloat(elementos[1]);
               }
                if(elementos[0].equals("limSupInc")){
                  limSupInc = Float.parseFloat(elementos[1]);
               }
                 if(elementos[0].equals("limInfInc")){
                  limInfInc = Float.parseFloat(elementos[1]);
               }
                 if(elementos[0].equals("increInc")){
                  increInc = Float.parseFloat(elementos[1]);
               }
                 if(elementos[0].equals("increVel")){
                  increVel = Float.parseFloat(elementos[1]);
               }
                 if(elementos[0].equals("distVuelta")){
                  distVuelta = Integer.parseInt(elementos[1]);
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

    public float getLimInf() {
        return limInf;
    }

    public float getLimSup() {
        return limSup;
    }

    public float getInc() {
        return inc;
    }

    public float getVel() {
        return vel;
    }

    public float getK() {
        return k;
    }

    public int getNoLaps() {
        return noLaps;
    }

    public long getIntCal() {
        return intCal;
    }

    public long getIntPan() {
        return intPan;
    }

    public float getLimSupInc() {
        return limSupInc;
    }

    public float getLimInfInc() {
        return limInfInc;
    }

    public float getIncreVel() {
        return increVel;
    }

    public float getIncreInc() {
        return increInc;
    }

    public int getDistVuelta() {
        return distVuelta;
    }
    
    
    
    
    
    
    
    
    
    
    
}
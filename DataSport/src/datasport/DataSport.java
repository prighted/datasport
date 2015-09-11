/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasport;

//import testeando.Reloj2;

/**
 * Esta sera la clase principal de la app Aclaro no sera el ejecutable.
 * @author Reinaldo Pabonh
 */
public class DataSport implements Runnable {

    /**
     * @param args the command line arguments
     */
     public void run(){
       long horaInicial = System.currentTimeMillis();
       Relojrun reloj = new Relojrun(horaInicial);
       reloj.imprimirHoraInicial();  
       }
       
    public static void main(String[] args) {
        
      
       
    
                  
    }
    
}

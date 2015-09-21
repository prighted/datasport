/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasport;

import basededatos.Conexion;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;


/**
 * Sistema de la trotadora
 * @author Reinaldo Pabon
 */
public class Launcher {
    public static void main(String[] args) { 
DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
simbolos.setDecimalSeparator(':');
DecimalFormat formateador = new DecimalFormat("00.00",simbolos);

// Esto sale en pantalla con punto decimal, es decir, 3.4324,
System.out.println (formateador.format (3.43242383));
    }
 
}
     //DataSport Trotadora= new DataSport();
    //Conexion DB = new Conexion(); // Posiblemente se implemente factory
                  
    

 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasport;

import java.sql.*;

/**
 *
 * @author Reinaldo Pabon
 */
public class Conexion {
    
    public void conectaraBD(){
      try{
          
          String controlador = "org.sqlite.JDBC";
          String cadenaconexion = "jdbc:sqlite:BDdatasport1";
          
          Class.forName(controlador);
          Connection cn;
          cn = DriverManager.getConnection(cadenaconexion);
                    
      }catch(ClassNotFoundException ex){
      System.out.println("Controlador no válido");
      }catch (SQLException ex){
      ex.printStackTrace();
      }
    }
    
    public void guardarenBD(){
    
        
        
    }
    
}

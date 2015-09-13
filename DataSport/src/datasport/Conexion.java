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
    
    public static void main(String[] args) {
        try {
 
            Class.forName("org.sqlite.JDBC");
            Connection cn;
            // "jdbc:sqlite:*** remplazar los asteríscos por la ruta de la base de datos en su pc.
            //Ejemplo: jdbc:sqlite:c:/usuarios/rafael/netbeansproyects/datasport/src/datasport/bdatasport.db"
            cn = DriverManager.getConnection("jdbc:sqlite:/home/rafael/NetBeansProjects/datasport/DataSport/src/datasport/BDdatasport1");
            Statement st =cn.createStatement();
            ResultSet rs= st.executeQuery("select * from ejercicio");
 
            while (rs.next()){
                System.out.print("Usuario: "+rs.getString("usuario"));
                System.out.println(" Calorias: "+rs.getString("calorias"));
                System.out.println(" Calorias Acumuladas: "+rs.getString("calAcumuladas"));
                System.out.println(" CI: "+rs.getString("CI"));
                System.out.println(" CV: "+rs.getString("CV"));
                System.out.println(" Inclinacion: "+rs.getString("inc"));
                System.out.println(" Tiempo: "+rs.getString("tiempo"));
                System.out.println(" Velocidad: "+rs.getString("vel"));
                System.out.println(" Vuelta: "+rs.getString("vuelta"));
                
            }
 
        } catch (ClassNotFoundException ex) {
            System.out.println("Controlador no válido");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
 
    }
}

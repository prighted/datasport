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
    
    /*
    String url = "/home/rafael/NetBeansProjects/datasport/DataSport/src/datasport/BDdatasport1";
    Connection connect;
    
    public void connect(){
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:"+url);
            if (connect!=null) {
                System.out.println("Conectado a la BD");
            }
        }catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la BD\n"+ex.getMessage());
        }
    }
    
    public void close(){
        try {
            connect.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void guardarenBD(int usuario, float calorias, float calAcumuladas, float CI, float CV, float inc, int tiempo, float vel, int vuelta){
        
        try {
            PreparedStatement st = connect.prepareStatement("insert into ejercicio (usuario, calorias, calAcumuladas, CI, CV, inc, tiempo, vel, vuelta) values (?,?,?,?,?,?,?,?,?)");
            st.setInt(1, usuario);
            st.setFloat(2, calorias);
            st.setFloat(3, calAcumuladas);
            st.setFloat(4, CI);
            st.setFloat(5,CV);
            st.setFloat(6, inc);
            st.setInt(7, tiempo);
            st.setFloat(8,vel);
            st.setInt(9, vuelta);            
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    
    }
    */
    
}

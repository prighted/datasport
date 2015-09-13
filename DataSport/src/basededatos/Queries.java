/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;
import java.sql.*;


/**
 *
 * @author rafael
 */
public class Queries {
    
    private Conexion conec;
    private Statement st;
    
    public Queries(){
         conec = new Conexion();
         st = conec.getSt();
    }
        
   public void actualizar(){
       conec.connect();
       
       
        try {
            PreparedStatement st = conec.getConnection().prepareStatement("insert into ejercicio (usuario, calorias, calAcumuladas, CI, CV, inc, tiempo, vel, vuelta) values (?,?,?,?,?,?,?,?,?)");
            
            /* st.setInt(1, usuario); 
        st.setFloat(2, calorias);
        st.setFloat(3, calAcumuladas);
        st.setFloat(4, CI);
        st.setFloat(5,CV);
        st.setFloat(6, inc);
        st.setInt(7, tiempo);
        st.setFloat(8,vel);
        st.setInt(9, vuelta);            
        st.execute();
       */
            
        } catch (SQLException ex) {
            
        }
       
        conec.close();
   }
    
   
   public void obtener(){
       
       conec.connect();
        try {
            
            ResultSet rs= st.executeQuery("select * from ejercicio");
            System.out.print("Usuario: "+rs.getString("usuario")); //esta es la llave principal, autoincrementa
            System.out.println(" Calorias: "+rs.getString("calorias"));
            System.out.println(" Calorias Acumuladas: "+rs.getString("calAcumuladas"));
            System.out.println(" CI: "+rs.getString("CI"));
            System.out.println(" CV: "+rs.getString("CV"));
            System.out.println(" Inclinacion: "+rs.getString("inc"));
            System.out.println(" Tiempo: "+rs.getString("tiempo"));
            System.out.println(" Velocidad: "+rs.getString("vel"));
            System.out.println(" Vuelta: "+rs.getString("vuelta"));
        } catch (SQLException ex) {
            
        }
        
        conec.close();
   }
    
    /*
        System.out.print("Usuario: "+rs.getString("usuario")); //esta es la llave principal, autoincrementa
        System.out.println(" Calorias: "+rs.getString("calorias"));
        System.out.println(" Calorias Acumuladas: "+rs.getString("calAcumuladas"));
        System.out.println(" CI: "+rs.getString("CI"));
        System.out.println(" CV: "+rs.getString("CV"));
        System.out.println(" Inclinacion: "+rs.getString("inc"));
        System.out.println(" Tiempo: "+rs.getString("tiempo"));
        System.out.println(" Velocidad: "+rs.getString("vel"));
        System.out.println(" Vuelta: "+rs.getString("vuelta"));
    
    
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
    */
}

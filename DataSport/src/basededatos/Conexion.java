/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;

import java.sql.*;

/**
 *
 * @author Reinaldo Pabon
 */
public class Conexion {
    
    private String url = "D:\\Documentos\\NetBeansProjects\\br\\datasport\\DataSport\\src\\basededatos\\BDdatasport1";
    private Connection connect;
    private Statement st;
    
    public void connect(){
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:"+url);
            if (connect!=null) {
                st = connect.createStatement();
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

    public Statement getSt() {
        return st;
    }
    
    public Connection getConnection()
    {
        if(connect!=null){
            return connect;
        }
        return null;  //si hay conexión le regresa la conexión, de lo contrario le regresa null
    }
    /*
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

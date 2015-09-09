/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasport;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Esta clase solo es empleada para obtener informacion de la hora (ACA NO EXISTE EL TIEMPO)
 * @author Reinaldo Pabon
 */
public class Relojrun {
    /*
    Variables para obtener la hora.
    */
       Calendar cal=Calendar.getInstance();
       int segundos = cal.get(cal.SECOND);
       int minutos = cal.get(cal.MINUTE);
       int horas = cal.get(cal.HOUR_OF_DAY);
    public String getHoraString ()
    {
     String hora=horas+":"+minutos+":"+segundos;
      return hora;
    }

    public int getSegundos() {
        return segundos;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getHoras() {
        return horas;
    }
    
    
}

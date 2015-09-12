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
 * Esta clase solo es empleada para obtener informacion de la hora (ACA NO
 * EXISTE EL TIEMPO)
 *
 * @author Reinaldo Pabon
 */
public class Relojrun {
    /*
     Variables para obtener la hora.
     */
    
    private long horaInicial;
    private long horaFinal;
    private long difHoras;

    public long getHoraInicial() {
        return horaInicial;
    }

    public long getHoraFinal() {
        return horaFinal;
    }


    public void setHoraInicial(long horaInicial) {
        this.horaInicial = horaInicial;
    }

    public void setHoraFinal(long horaFinal) {
        this.horaFinal = horaFinal;
    }


    public long calcularDeltaHoras(){
        difHoras = (this.horaFinal - this.horaInicial)/1000;               //Estoy intentando calcular el delta aquí porque el profesor 
        return difHoras;                                                     //dijo que Reloj debía hacer ese cálculo
        
    }


    public String getHoraString() {
        Calendar cal = Calendar.getInstance();
        int segundos = cal.get(Calendar.SECOND);
        int minutos = cal.get(Calendar.MINUTE);
        int horas = cal.get(Calendar.HOUR_OF_DAY);
        String hora = horas + ":" + minutos + ":" + segundos;
        //SimpleDateFormat s=new SimpleDateFormat("hh:mm:ss");
       // lbl.setText(s.format(hoy));   
        return hora;
    }
    
    public void resetHora(){
        
        
    }
    public void imprimirHoraInicial(){
        System.out.println("la hora incial es: "+horaInicial);
    }
    public void imprimirHoraFinal(){
        System.out.println("la hora final es: "+horaFinal);
    }
}

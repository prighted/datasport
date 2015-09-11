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

    public Relojrun(long horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Relojrun() {
    }


    public void setHoraFinalSeg(long horaFinal) {
        this.horaFinal = horaFinal;
    }
    
    public long calcularDeltaHoras(){
        this.difHoras = (horaFinal - horaInicial)/1000;               //Estoy intentando calcular el delta aquí porque el profesor 
        return difHoras/60;                                                     //dijo que Reloj debía hacer ese cálculo
        
    }
    public long getHoraInicialSeg() {
        Calendar calInicial = Calendar.getInstance();
        this.horaInicial=calInicial.getTimeInMillis();
        return horaInicial;
    }

    public String getHoraString() {
        Calendar cal = Calendar.getInstance();
        int segundos = cal.get(Calendar.SECOND);
        int minutos = cal.get(Calendar.MINUTE);
        int horas = cal.get(Calendar.HOUR_OF_DAY);
        String hora = horas + ":" + minutos + ":" + segundos;
        return hora;
    }
    
    public void imprimirHoraInicial(){
        System.out.println("la hora es: "+horaInicial);
    }
    public void imprimirHoraFinal(){
        System.out.println("la hora es: "+horaFinal);
    }
}

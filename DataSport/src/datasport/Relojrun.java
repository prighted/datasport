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
    Calendar calInicial = Calendar.getInstance();
    private long horaInicial;
    private long horaFinal;
    private long difHoras;

    public void setHoraInicialSeg(long horaInicial) {
        this.horaInicial = horaInicial;
    }

    public void setHoraFinalSeg(long horaFinal) {
        this.horaFinal = horaFinal;
    }
    
    public long calcularDeltaHoras(){
        difHoras = (horaFinal - horaInicial)/1000;                              //Estoy intentando calcular el delta aquí porque el profesor 
        return difHoras;                                                        //dijo que Reloj debía hacer ese cálculo
        
    }
    public long getHoraInicialSeg() {
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
    public long getHoraMilis()
    {
        Calendar cal = Calendar.getInstance();
        return cal.getTimeInMillis();
    }

}

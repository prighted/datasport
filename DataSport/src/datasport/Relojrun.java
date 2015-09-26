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
    private long horaParcial;
    private long tiempoTranscurrido;
    private long transcTemp=0;

    public long getDifHoras() {
        return difHoras;
    }

    public long getTiempoTranscurrido() {
        return tiempoTranscurrido;
    }

    public long getHoraInicial() {
        return horaInicial;
    }

    public long getHoraFinal() {
        return horaFinal;
    }
    
    public void resetsaveT()
    {
    transcTemp=0;
    }
    
    public long getSaveT()
    {
    return transcTemp;
    }
    
    public void saveT()
    {
    transcTemp=tiempoTranscurrido;
    }

    public void setHoraInicial() {
        horaInicial = System.currentTimeMillis();

    }
 

    public String calcularTiempoTranscurrido() {
        /*
         El siguiente método arroja el tiempo transcurrido en formato String
         toma la horaInicial y la resta con la horaParcial, que se va actualizando cada segundo
         */
        String seg, min, hor;
        horaParcial = System.currentTimeMillis()+1;
        tiempoTranscurrido = ((horaParcial - horaInicial) / 1000)+transcTemp; //transcTemp tiempo que llevaba antes de pausa
        int segundos = (int) (tiempoTranscurrido) % 60;
        int minutos = (int) ((tiempoTranscurrido / 60) % 60);
        int horas = (int) ((tiempoTranscurrido / (60 * 60)) % 24);
        if (segundos < 10) {
            seg = ":0" + segundos;
        } else {
            seg = ":" + segundos;
        }
        if (minutos < 10) {                                                         //
            min = ":0" + minutos;
        } else {
            min = ":" + minutos;
        }
        if (horas < 10) {
            hor = "0" + horas;
        } else {
            hor = ":" + horas;
        }
        String tiempoMostrar = hor + "" + min + "" + seg;
        return tiempoMostrar;

    }

    public long calcularDeltaHoras() {
        horaFinal = System.currentTimeMillis();
        difHoras = (horaFinal - horaInicial) / 1000;
        return difHoras;

    }

    public String getHoraString() {
        Date hoy = new Date();
        SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");                    //De esta forma se obtiene la hora en el
        return s.format(hoy);                                                   //Buen formato
    }

    public void resetHora() {
        long horaNueva = System.currentTimeMillis();
    }

    public void imprimirHoraInicial() {
        System.out.println("la hora incial es: " + horaInicial);
    }

    public void imprimirHoraFinal() {
        System.out.println("la hora final es: " + horaFinal);
    }
}

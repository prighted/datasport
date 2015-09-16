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

    public void setHoraInicial() {
        horaInicial = System.currentTimeMillis();

    }
//
//    private String buenFormatoString(int valorInt, String valorString) {
//        /*
//         Me arroja el buen formato de los mins, segs, horas.
//         */
//        if (valorInt < 10) {
//            valorString = ":0" + valorInt;
//            return valorString;
//        } else {
//            valorString = ":" + valorInt;
//            return valorString;
//        }
//    }

    public String calcularTiempoTranscurrido() {
        /*
         El siguiente método arroja el tiempo transcurrido en formato String
         toma la horaInicial y la resta con la horaParcial, que se va actualizando cada segundo
         */
        String seg, min, hor;
        horaParcial = System.currentTimeMillis();
        tiempoTranscurrido = (horaParcial - horaInicial) / 1000;
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

        /*Calendar cal = Calendar.getInstance();
         int segundos = cal.get(Calendar.SECOND);
         int minutos = cal.get(Calendar.MINUTE);
         int horas = cal.get(Calendar.HOUR_OF_DAY);
         String hora = horas + ":" + minutos + ":" + segundos;
         //SimpleDateFormat s=new SimpleDateFormat("hh:mm:ss");
         // lbl.setText(s.format(hoy));   
         return hora;*/
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

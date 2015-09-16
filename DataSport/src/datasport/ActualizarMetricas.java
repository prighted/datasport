/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasport;

import javax.swing.JLabel;

/**
 *
 * @author Reinaldo Pabon Esta clase es el runnable para mostrar las calorías,
 * kms, vuelta
 */
public class ActualizarMetricas implements Runnable {

    //Codigo que se ejecutara durante el thread
    private long intervaloCalculoCalorias, intervaloMostrarPantalla;
    private JLabel lblCal, lblKm, lblVuelta;
    public boolean vivo;                                                        //Para que se repita el run
    private DataSport programa;
    private Relojrun reloj;
    //private int intervalo;
    // private DataSport programa;

    public ActualizarMetricas(JLabel lblCal, JLabel lblKm, JLabel lblVuelta, Relojrun reloj, DataSport programa,
        long intervaloCalculoCalorias, long intervaloMostrarPantalla) {
        this.lblCal = lblCal;
        this.lblKm = lblKm;
        this.reloj = reloj;
        this.lblVuelta = lblVuelta;
        this.programa = programa;
        this.intervaloCalculoCalorias = intervaloCalculoCalorias;
        this.intervaloMostrarPantalla = intervaloMostrarPantalla;
        vivo = true;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    @Override
    public void run() {
        //reloj.setHoraInicial();//
        while (vivo) {
            try {
                long tiempo = reloj.getTiempoTranscurrido();
                programa.calcularCal(intervaloCalculoCalorias);
                programa.calcularKm(tiempo);
                String kmAcum = programa.getDistAcumString();
                String calSeg = programa.getCalString();
                System.out.println("Calorias segundo a segundo "+calSeg);
               
                //System.out.println(stop);
                Thread.sleep(1000);
               if ((tiempo%intervaloMostrarPantalla) ==0) {
                    lblCal.setText(calSeg);
                    lblKm.setText(kmAcum);
                    System.out.println("Calorias acumuladas mostradas "+calSeg);
                }
            } catch (InterruptedException ex) {
            };

        }
    }
}

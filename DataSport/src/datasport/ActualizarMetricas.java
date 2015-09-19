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
    public boolean vivoM;                                                        //Para que se repita el run
    private DataSport programa;
    private Relojrun reloj;
    private int t;
    private String botonM;
    

    public ActualizarMetricas(JLabel lblCal, JLabel lblKm, JLabel lblVuelta, Relojrun reloj, DataSport programa,
        long intervaloCalculoCalorias, long intervaloMostrarPantalla) {
        this.lblCal = lblCal;
        this.lblKm = lblKm;
        this.reloj = reloj;
        this.lblVuelta = lblVuelta;
        this.programa = programa;
        this.intervaloCalculoCalorias = intervaloCalculoCalorias;
        this.intervaloMostrarPantalla = intervaloMostrarPantalla;
        vivoM = true;
        
    }
    
    public void setBoton(String b)
    {
    botonM=b;
        
    }
    

    public void setVivo(boolean vivoM) {
        this.vivoM = vivoM;
    }

    @Override
    public void run() {
        while (vivoM) {
            try {
                //Se ejecuta si esta en play
               if (botonM=="play")
               {
               int tiempo = (int) reloj.getTiempoTranscurrido();
                
                programa.calcularCal(intervaloCalculoCalorias);
                programa.calcularKm(tiempo);
                String kmAcum = programa.getDistAcumString();
                String calSeg = programa.getCalString();
                programa.calculaTimeLap();
                String vueltas = programa.getVueltaString();
                
                if ((tiempo) == 0) {
                    lblCal.setText("0.00");
                    lblKm.setText("0.00");
                }else{
                if (((tiempo+1) % intervaloMostrarPantalla) == 0) {
                     
                        lblCal.setText(calSeg);
                        lblKm.setText(kmAcum);
                        lblVuelta.setText(vueltas);
                }
            
                }    
                
               }
              Thread.sleep(1000);  
            } catch (InterruptedException ex) {
            };

        }
    }
}

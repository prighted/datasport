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
    private int salto;
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
               
                   if (salto!=0) /*
                       Evita que entre de una vez a ejecutar despues de dar pausa.
                       Antes se tenia el bug de que por ejemplo se pausaba en el segundo
                       5 justo antes de 6 mostraba el calculo de calorias para 5 y para 6
                       o sea por dos. Se hace esto para "desfasar un segundo" este thread
                       del otro No se adelanta
                       */
                   { 
                       
                       int tiempo = (int) reloj.getTiempoTranscurrido();
                
                programa.calcularCal(intervaloCalculoCalorias);
                programa.calcularKm(tiempo);
                String kmAcum = programa.getDistAcumString();
                String calSeg = programa.getCalString();
                programa.calculaTimeLap();
                String vueltas = programa.getVueltaString();
                       //System.out.println("Va en la vuelta no "+programa.getVuelta());
                
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
                   else /*
                       una vez se salto el primer segundo despues de pausa incrementa
                       el salto para que entre en los demas ciclos siguientes.
                       */
                   {
                   salto++;
                   }
                }
             
               {
                 if (botonM=="pause") /*
                     si pausan coloca el salto en 0 para que haga el desfase.
                     */
                 {
                  salto=0;
                 }
                 else //usaron stop
                 {
                     if (botonM=="stop")
                     {
                     System.out.println("usaron stop");
                     programa.resetCalorias();
                     programa.resetKm();
                     programa.resetVuelta();
                     programa.resetParametros();
                     lblCal.setText("00.00");
                     lblKm.setText("00.00");
                     lblVuelta.setText("0");
                     }
                 }
               }
              Thread.sleep(1000);  
            } catch (InterruptedException ex) {
            };

        }
    }
}

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
    private String botonM,vueltas;
    

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
                if (programa.getModo()==1)
                {
                    programa.calcularVuelta();
                    vueltas = programa.getVueltaString();
                    
                }
                programa.calcularCal(intervaloCalculoCalorias);
                programa.calcularKm(tiempo);
                       System.out.println("la velocidad es en Metricas" +programa.getVel());
                       System.out.println("La inclinación en Metricas "+programa.getInc());
     
                       System.out.println(" Los km en metricas " +programa.getDistAcumString());
                String kmAcum = programa.getDistAcumString();
                String calSeg = programa.getCalString();
                
                
                
                if ((tiempo) == 0) {
                    lblCal.setText("00000.00");
                    lblKm.setText("       00.00");
                    lblVuelta.setText("0");
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

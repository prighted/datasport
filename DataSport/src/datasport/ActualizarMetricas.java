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
    private JLabel jLabel4, jLabel5, jLabel6, jLabel7, lblCal, lblKm, lblVuelta, lblVel, lblInc; //agregadas variables label para mostrar datos al terminal modo libre
    public boolean vivoM;                                                        //Para que se repita el run
    private DataSport programa;
    private Relojrun reloj;
    private int t;
    private int salto;
    private String botonM, vueltas, calSeg, kmAcum;
    
    public void setVelIncPrestablecido() {

    }

    public ActualizarMetricas(JLabel jLabel4, JLabel jLabel5, JLabel jLabel6, JLabel jLabel7, JLabel lblCal, JLabel lblKm, Relojrun reloj, DataSport programa, long intervaloCalculoCalorias, long intervaloMostrarPantalla) {
        this.jLabel4 = jLabel4;
        this.jLabel5 = jLabel5;
        this.jLabel6 = jLabel6;
        this.jLabel7 = jLabel7;
        this.lblCal = lblCal;
        this.lblKm = lblKm;
        this.reloj = reloj;
        this.programa = programa;
        this.intervaloCalculoCalorias = intervaloCalculoCalorias;
        this.intervaloMostrarPantalla = intervaloMostrarPantalla;
        vivoM = true;

    }

    public ActualizarMetricas(JLabel jLabel4, JLabel jLabel5, JLabel jLabel6, JLabel jLabel7, JLabel lblCal, JLabel lblKm, JLabel lblVuelta, JLabel lblVel, JLabel lblInc,
            Relojrun reloj, DataSport programa, long intervaloCalculoCalorias, long intervaloMostrarPantalla) {
        this.jLabel4 = jLabel4;
        this.jLabel5 = jLabel5;
        this.jLabel6 = jLabel6;
        this.jLabel7 = jLabel7;
        this.lblCal = lblCal;
        this.lblKm = lblKm;
        this.reloj = reloj;
        this.lblVuelta = lblVuelta;
        this.lblVel = lblVel;
        this.lblInc = lblInc;
        this.programa = programa;
        this.intervaloCalculoCalorias = intervaloCalculoCalorias;
        this.intervaloMostrarPantalla = intervaloMostrarPantalla;
        vivoM = true;

    }

    public void calculos(int tiempo) {
        programa.calcularCal(intervaloCalculoCalorias);

        programa.calcularKm();
        programa.calcularVuelta();


    }

    public void setBoton(String b) {
        botonM = b;

    }

    public void setVivo(boolean vivoM) {
        this.vivoM = vivoM;
    }
 
            

    @Override
    public synchronized void run() {
        while (vivoM) {

            try {

                //Se ejecuta si esta en play
                if (botonM == "play") {
                    
                    jLabel4.setVisible(false); //oculta los label cuando empieza el programa
                    jLabel5.setVisible(false);
                    jLabel6.setVisible(false);
                    jLabel7.setVisible(false);

                    if (salto != 0) /*
                     Evita que entre de una vez a ejecutar despues de dar pausa.
                     Antes se tenia el bug de que por ejemplo se pausaba en el segundo
                     5 justo antes de 6 mostraba el calculo de calorias para 5 y para 6
                     o sea por dos. Se hace esto para "desfasar un segundo" este thread
                     del otro No se adelanta
                     */ {

                        int tiempo = (int) reloj.getTiempoTranscurrido();
                        calculos(tiempo);
                         
                         
                                   
                        vueltas = programa.getVueltaString();
                        kmAcum = programa.getDistAcumString();
                        calSeg = programa.getCalString();
//                        System.out.println("la velocidad  en Metricas " + programa.getVel());
//                        System.out.println("La inclinación en Metricas " + programa.getInc());
//
//                        System.out.println("Los km en metricas " + kmAcum);
//                        System.out.println("Las calorias en metricas son " + calSeg);

                        if ((tiempo) == 0) {
                            lblCal.setText("00000.00");
                            lblKm.setText("       00.00");
                            lblVuelta.setText("0");
                            
                        
                        } else {
                            if (((tiempo + 1) % intervaloMostrarPantalla) == 0) {

                                lblCal.setText(calSeg);
                                lblKm.setText(kmAcum);
                                lblVuelta.setText(vueltas);
                               
                            }
                        }
                    } else /*
                     una vez se salto el primer segundo despues de pausa incrementa
                     el salto para que entre en los demas ciclos siguientes.
                     */ {
                        salto++;
                    }

                }

                {
                    if (botonM == "pause") /*
                     si pausan coloca el salto en 0 para que haga el desfase.
                     */ {
                        salto = 0;
                    } else //usaron stop
                    {
                        if (botonM == "stop") {
                            Float velrafa = programa.getVel(); //toma la velocidad
                            System.out.println("usaron stop");
                            jLabel4.setVisible(true);//deja visible los label para poder mostrar los datos
                            jLabel5.setVisible(true);
                            jLabel6.setVisible(true);
                            jLabel7.setVisible(true);
                            jLabel4.setText("Kilómetros: "+ Float.parseFloat(kmAcum));
                            jLabel5.setText("Calorias: "+ Float.parseFloat(calSeg));
                            jLabel6.setText("Vueltas: "+ Float.parseFloat(kmAcum)/0.04f);
                            jLabel7.setText("Velocidad: "+ velrafa);
                            programa.resetCalorias();
                            programa.resetKm();
                            programa.resetVuelta();
                            programa.resetParametros();
                            lblCal.setText("00.00");
                            lblKm.setText("00.00");
                            lblVuelta.setText("0");
                            botonM="";
                        }
                    }
                }
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            };

        }
    }
}

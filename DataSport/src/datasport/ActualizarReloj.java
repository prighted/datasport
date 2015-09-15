/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasport;

import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author Reinaldo Pabon
 */
public class ActualizarReloj implements Runnable {
    //Codigo que se ejecutara durante el thread

    private JLabel etiqueta;
     private JLabel etiqueta1;
    public boolean vivo;                                                        //Para que se repita el run
    private Relojrun reloj;
    private boolean mantenerContador=false;
    private int contador=1;                                                     //Tiempo
    private int intervalo;
    private int horas,minutos,segundos;
    private String tiempoTranscurrido;


    private DataSport programa;

    public ActualizarReloj(JLabel etiqueta, JLabel etiqueta1, Relojrun reloj, DataSport programa) {
        this.etiqueta = etiqueta;
        this.etiqueta1 = etiqueta1;
        this.vivo = true;
        this.reloj = reloj;
        this.programa = programa;
        
        int intervalo = programa.getIntervalo();
    }
    
    public void initDetCont(boolean v)//Para e inicia contador
    {
    mantenerContador=v;
    }
    
    public void resetContador()
    {
    contador=1;
    }

    public int getContador() {
        return contador;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

  
    @Override
    public void run() {
        while (vivo) {
            try {
                String hora = reloj.getHoraString();                          //Obtención de la Hora a mostrar en pantalla
                etiqueta.setText(hora);
                Thread.sleep(1000);
                    segundos = (contador ) % 60 ;
                    minutos = ((contador /60)  %  60);
                    horas  = ((contador / (60*60)) % 24);
                    tiempoTranscurrido =  horas + ":" + minutos + ":" + segundos;
                    etiqueta1.setText(tiempoTranscurrido);
                    contador++;
            
            } catch (InterruptedException ex) {
            };
            
        }
      
       //Aqui ya no existe el thread, pero puedo seguir trabajando
       
    }
}

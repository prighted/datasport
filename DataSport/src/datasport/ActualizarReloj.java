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
    private int stop;
    private JLabel lblReloj, lblTiempo;
    public boolean vivo;                                                        //Para que se repita el run
    private Relojrun reloj;
    //private int intervalo;
   // private DataSport programa;
    

    public ActualizarReloj(JLabel lblReloj, JLabel lblTiempo, Relojrun reloj/*, int intervalo, DataSport programa*/) {
        this.lblReloj = lblReloj;
        this.lblTiempo = lblTiempo;
        this.reloj = reloj;
        //this.intervalo = intervalo;
        //this.programa = programa;
        vivo = true;
        stop = 0;
    }
    
   

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

  
    @Override
    public void run() {
        reloj.setHoraInicial();
        while (vivo) {
            try {
                String hora = reloj.getHoraString();                            //Obtención de la Hora a mostrar en pantalla en el reloj
               // System.out.println("La hora Inicial es "+reloj.getHoraInicial()); 
               // reloj.setHoraParcial(horaParcial);
                String tiempoTranscurrido = reloj.calcularTiempoTranscurrido();
//                System.out.println("El tiempo transcurrido (atributo)"+reloj.getTiempoTranscurrido());
//                System.out.println("El tiempo transcurrido es: "+tiempoTranscurrido);
                lblReloj.setText(hora);
                lblTiempo.setText(tiempoTranscurrido);
                
                
                stop=stop+1;
                //System.out.println(stop);
                Thread.sleep(1000);
//                if (stop==60)
//                {
//                 
//                    //long horaFinal = System.currentTimeMillis();                //Obtiene y setea la hora final
//                    //reloj.setHoraFinal(horaFinal);
//                  //  System.out.println("La hora Inicial es "+reloj.getHoraInicial());
//                   // reloj.calcularDeltaHoras();
//                  //  System.out.println("La hora final es: "+reloj.getHoraFinal());
//                    
//                                                  //Obtiene la diferencia de las horas
//                    //System.out.println("La diferencia de horas es: " + reloj.getDifHoras());
//                    vivo=false;
//                }
                
            
            } catch (InterruptedException ex) {
            };
            
        }
      
       //Aqui ya no existe el thread, pero puedo seguir trabajando
       
    }
}

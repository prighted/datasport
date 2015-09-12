/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasport;

import javax.swing.JLabel;

/**
 *
 * @author Reinaldo Pabon
 */
public class ActualizarReloj implements Runnable {
    //Codigo que se ejecutara durante el thread

    private JLabel etiqueta;
    public boolean vivo;                                                        //Para que se repita el run
    private int stop = 0;                                                       //Para detener el hilo
    private Relojrun reloj;
    
    
    
    public ActualizarReloj(JLabel label, Relojrun reloj) {
        this.etiqueta = label;
        this.reloj = reloj;
        this.vivo = true;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public int getStop() {
        return stop;
    }
  
    @Override
    public void run() {
        while (vivo) {
            try {
                String hora = reloj.getHoraString();                          //Obtención de la Hora a mostrar en pantalla
                etiqueta.setText(hora);
                Thread.sleep(1000);
                stop=stop+1;
                System.out.println(stop);
                if (stop==10)
                {
                 
                    long horaFinal = System.currentTimeMillis();                //Obtiene la hora final
                    reloj.setHoraFinal(horaFinal);
                    System.out.println("La hora final es: "+reloj.getHoraFinal());
                    long difHoras=reloj.calcularDeltaHoras();                              //Obtiene la diferencia de las horas
                    System.out.println("La diferencia de horas es: "+ difHoras);
                    vivo=false;
                }
                
            } catch (InterruptedException ex) {
            };
            
        }
      
       //Aqui ya no existe el thread, pero puedo seguir trabajando
       
    }
}

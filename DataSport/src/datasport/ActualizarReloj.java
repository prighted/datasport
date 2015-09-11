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
    Relojrun running = new Relojrun();
    public boolean vivo;                                                        //Para que se repita el run
    private long difHoras;                                                      //Va a estar en Segundos
 
    private int stop = 0;                                                       //Para detener el hilo
    
    
    
    public ActualizarReloj(JLabel label) {
        etiqueta = label;
        vivo = true;
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
             
                running.imprimirHoraInicial();
                String hora = running.getHoraString();                          //Obtención de la Hora a mostrar en pantalla
                etiqueta.setText(hora); 
                //System.out.println(horaInicial);
                Thread.sleep(1000);
                stop=stop+1;
                System.out.println(stop);
                if (stop==10)
                {
                    
                                                                                //Se crea este método para detener el Hilo
                                            //Y poder hacer el cálculo de los segundos
                    vivo=false;
                    difHoras=running.calcularDeltaHoras();                              //Obtiene la diferencia de las horas
                    System.out.println(difHoras);
                }
                
            } catch (InterruptedException ex) {
            };
            
        }
      
         
       
    }
}

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
    private ProgramaEjercicio progEjer;
    private ModoPrestablecido modoPres;
    private ModoLibre modoLibre;
    private boolean mantenerContador=false;
    private int contador=1;

    public ActualizarReloj(JLabel etiqueta, Relojrun reloj, ProgramaEjercicio progEjer, ModoPrestablecido modoPres, ModoLibre modoLibre) {
        this.etiqueta = etiqueta;
        this.vivo = true;
        this.reloj = reloj;
        this.progEjer = progEjer;
        this.modoPres = modoPres;
        this.modoLibre = modoLibre;
    }
    
    public void initDetCont(boolean v)//Para e inicia contador
    {
    mantenerContador=v;
    }
    
    public void resetContador()
    {
    contador=1;
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
                /*stop=stop+1;
                System.out.println(stop);
                if (stop==10)
                {
                 
                    long horaFinal = System.currentTimeMillis();                //Obtiene la hora final
                    reloj.setHoraFinal(horaFinal);
                    System.out.println("La hora final es: "+reloj.getHoraFinal());
                    float difHoras=reloj.calcularDeltaHoras();                              //Obtiene la diferencia de las horas
                    System.out.println("La diferencia de horas es: "+ difHoras);
                    vivo=false;
                }
                */
                if (mantenerContador==true)
                {
                System.out.println(contador++);
                }
            } catch (InterruptedException ex) {
            };
            
        }
      
       //Aqui ya no existe el thread, pero puedo seguir trabajando
       
    }
}

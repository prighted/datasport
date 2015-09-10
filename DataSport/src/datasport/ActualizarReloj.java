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
    public boolean vivo;        //Para que se repita el run
    private long difHoras;      //Va a estar en Segundos

    public ActualizarReloj(JLabel label) {
        etiqueta = label;
        vivo = true;
    }

    @Override
    public void run() {
        while (vivo) {
            try {
                long horaInicial = running.getHoraInicialSeg();                 //Se crea la instancia de horaInicial para trabajar
                String hora = running.getHoraString();                          //Obtención de la Hora a mostrar en pantalla
                etiqueta.setText(hora); 
                long horaFinal = running.getHoraMilis();
                difHoras = (horaFinal - horaInicial)/1000;
                System.out.println(horaInicial);
                System.out.println(horaFinal);
                System.out.println(difHoras);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            };
        }

    }
}

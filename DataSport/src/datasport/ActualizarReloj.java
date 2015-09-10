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
    public boolean vivo;

    public ActualizarReloj(JLabel label) {
        etiqueta = label;
        vivo = true;
    }

    @Override
    public void run() {
        while (vivo) {
            try {
                  
                String hora = running.getHoraString();
                etiqueta.setText(hora);
                Thread.sleep(1000);

            } catch (InterruptedException ex) {
            };
        }

    }
}

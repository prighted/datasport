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
public class ModoLibre extends ProgramaEjercicio {
   
    public ModoLibre(float vel, float inc, int tiempo, int intervalo) {
        super(vel, inc, tiempo, intervalo);
    }
    
    public void aumentar(JLabel etiqueta)
    {
      double x=Double.parseDouble(etiqueta.getText())+0.1;
      etiqueta.setText(""+x);
    }
    public void valorBoton(JLabel etiqueta,double n)
    {
     etiqueta.setText(""+n);
    }
}

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
public class ModoPrestablecido extends ProgramaEjercicio {
 private Intensidad intensidad;
 private int modo;
 
    public ModoPrestablecido(float vel, float inc, int tiempo, int intervalo) {
        super(vel, inc, tiempo, intervalo);
        //rutina
        intensidad=new Intensidad();
    }
  
 public void setPrograma(JLabel l,int v)
{
 modo=v;
 l.setText(""+v);
 
}
}

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
    
    public void aumentar(JLabel etiqueta, double limInf,
            double limSup,  double aumento)
            /*
            limInf, limSup deben ser doubles, esto es 1.0, 12.0 para que se imprima
            bien en pantalla
            */
    {
      double x=Double.parseDouble(etiqueta.getText());
      
        if((x<limInf)){                                                              //Limite Inferior= limInf
          etiqueta.setText(""+limInf);
        }else{
          if(x==limSup){
          etiqueta.setText(""+limSup);                                             //Limite Superior= limSup
        }else{
            x=x+aumento;
            x=Math.rint(x*10)/10;
            etiqueta.setText(""+x);
          }
      }
    }
    
    public void reducirVelocidad(JLabel etiqueta)
    {
     double x=Double.parseDouble(etiqueta.getText());
      if(x==0){
              etiqueta.setText("0.0");
             }
      else{
      if((x==1))
      {
          etiqueta.setText("1.0");
      }
         else{
            x=x-0.1;
            x=Math.rint(x*10)/10;
            etiqueta.setText(""+x);   
           }
         }   
    }
    public void reducirInclinacion(JLabel etiqueta)
    {
     double x=Double.parseDouble(etiqueta.getText());
      if(x==0){
              etiqueta.setText("0.0");
             }
      else{
            x=x-0.2;
            x=Math.rint(x*10)/10;
            etiqueta.setText(""+x);   
           }
         }   
    
      
    public void valorBoton(JLabel etiqueta,double n)
    {
     etiqueta.setText(""+n);
    }
}

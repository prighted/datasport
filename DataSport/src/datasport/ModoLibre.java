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
    
    public void aumentar(JLabel etiqueta, float limInf,
            float limSup,  float aumento)
            /*
            limInf, limSup deben ser float, esto es 1.0f, 12.0f para que se imprima
            bien en pantalla
            */
    {
      double x=Float.parseFloat(etiqueta.getText());
      
        if((x<limInf)){                                                              //Limite Inferior= limInf
          etiqueta.setText(""+limInf);
        }else{
          if(x==limSup){
          etiqueta.setText(""+limSup);                                             //Limite Superior= limSup
        }else{
            x=x+aumento;
            x=Math.rint(x*10)/10;                                               //redondea a dos dígitos
            etiqueta.setText(""+x);
          }
      }
    }
    
    public void reducirVelocidad(JLabel etiqueta, float limInf, float disminucion)
    {
      double x=Float.parseFloat(etiqueta.getText());
      if(x==0){
              etiqueta.setText("0.0");                                          //Se crea este límite porque en la pantalla aparece en 0.0
             }                                                                  //Y por ahora la velocidad va desde 1=limInf hasta 12=limSup
      else{
      if((x==limInf))
      {
          etiqueta.setText(""+limInf);
      }
         else{
            x=x-disminucion;
            x=Math.rint(x*10)/10;
            etiqueta.setText(""+x);   
           }
         }   
    }
    public void reducirInclinacion(JLabel etiqueta, float limInf, float disminucion)
    {
      double x=Float.parseFloat(etiqueta.getText());
      if(x==limInf){
              etiqueta.setText(""+limInf);
             }
      else{
            x=x-disminucion;
            x=Math.rint(x*10)/10;
            etiqueta.setText(""+x);   
           }
         }   
    
      
    public void valorBoton(JLabel etiqueta,double n)
    {
     etiqueta.setText(""+n);
    }
}

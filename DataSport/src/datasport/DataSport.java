/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasport;

//import testeando.Reloj2;

import javax.swing.JLabel;


/**
 * Esta sera la clase principal de la app Aclaro no sera el ejecutable.
 * @author Reinaldo Pabonh
 */
public class DataSport{
    /*
    vel=velocidad
    inc=inclinación
    limSup=Limite Superior de las etiquetas del ModoLibre
    limInf=Limite Inferior de las etiquetas del ModoLibre
    var= Variación de la vel/inc con +y -
    tiempo= tiempo transcurrido
    intervalo= cada cuanto se hace el cálculo de las calorías
    modo=0:ModoLibre, 1:Prestablecido
    idAtributo=0:Velocidad, 1:Inclinacion
    */
private float vel, inc, limSup, limInf, var, calorias, caloriasAcum;
private int tiempo, intervalo, vuelta, kmVuelta, km, distanciaAcum, K, modo, idAtributo;
private Intensidad intensidad;

    public DataSport(int intervalo) {
        //Modo Libre
        this.intervalo = intervalo;
        this.modo = 0;
    }

    public DataSport(int intervalo,int kmVuelta) {
        //Modo Prestablecido
        this.intervalo = intervalo;
        this.kmVuelta = kmVuelta;
        this.modo=1;
        this.intensidad = intensidad;
        
    }
    
/*
    INICIO Declaración de getters y Setters
*/

    public int getIntervalo() {
        return intervalo;
    }

    public float getVel() {
        return vel;
    }

    public float getInc() {
        return inc;
    }

    public float getCalorias() {
        return calorias;
    }

    public float getCaloriasAcum() {
        return caloriasAcum;
    }

    public int getTiempo() {
        return tiempo;
    }

    public int getVuelta() {
        return vuelta;
    }

    public int getKm() {
        return km;
    }

    public int getDistanciaAcum() {
        return distanciaAcum;
    }

    public int getModo() {
        return modo;
    }

    public void setVel(float vel) {
        this.vel = vel;
    }

    public void setInc(float inc) {
        this.inc = inc;
    }

    public void setCalorias(float calorias) {
        this.calorias = calorias;
    }

    public void setCaloriasAcum(float caloriasAcum) {
        this.caloriasAcum = caloriasAcum;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public void setVuelta(int vuelta) {
        this.vuelta = vuelta;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public void setDistanciaAcum(int distanciaAcum) {
        this.distanciaAcum = distanciaAcum;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }
  
       /*
        FIN Declaración Getters y Setters
        */ 
    public void aumentar(JLabel etiqueta, float limSup, float limInf, float var,
                    int idAtributo)
    {
      double x=Float.parseFloat(etiqueta.getText());
      if(idAtributo==0){
        if((x<limInf)){  
             if(x<10){
                     etiqueta.setText("  "+limInf);
                 }                                                              //Para que se vea de una buena forma
                 else                                                             
                 {
                    etiqueta.setText(""+limInf); 
                 }
          vel=limInf;                                                      //Se establece la velocidad  
         imprVel();
        }else{
          if(x==limSup){
               if(x<10){
                     etiqueta.setText("  "+limSup);
                 }
                 else
                 {
                    etiqueta.setText(""+limSup); 
                 }
          vel=limSup;                                                  
          imprVel();
        }else{
            x=x+var;
            x=Math.rint(x*10)/10;
               if(x<10){
                     etiqueta.setText("  "+x);
                 }
                 else
                 {
                    etiqueta.setText(""+x); 
                 }
            vel=(float)x; 
            imprVel();
            } 
            }
        }else{
          if((x<limInf)){
                  if(x<10){
                     etiqueta.setText("  "+limInf);
                 }
                 else
                 {
                    etiqueta.setText(""+limInf); 
                 }
          inc=limInf;                                                      //Se establece la velocidad  
          imprInc();
        }else{
          if(x==limSup){
               if(x<10){
                     etiqueta.setText("  "+limSup);
                 }
                 else
                 {
                    etiqueta.setText(""+limSup); 
                 }
          inc=limSup;                                                  
          imprInc();
        }else{
            x=x+var;
            x=Math.rint(x*10)/10;   
             if(x<10){
                     etiqueta.setText("  "+x);
                 }
                 else
                 {
                    etiqueta.setText(""+x); 
                 }//redondea a dos dígitos
            inc=(float)x; 
            imprInc();
      }
      }
      }
    }
    
   
public void reducir(JLabel etiqueta, float limInf, float var, int idAtributo)
    {
      double x=Float.parseFloat(etiqueta.getText());
      if(idAtributo==0)
      {
         
             if(x==limInf){
                 if(x<10){
                     etiqueta.setText("  "+limInf);
                 }
                 else
                 {
                    etiqueta.setText(""+limInf); 
                 }
                vel=limInf;
                imprVel();
                           }
             else{
                x=x-var;
                x=Math.rint(x*10)/10;
                if(x<10){
                     etiqueta.setText("  "+x);
                 }
                 else
                 {
                    etiqueta.setText(""+x); 
                 }
                vel=(float)x;
                imprVel();
                }
      }else{
            if(x==limInf){
                  if(x<10){
                     etiqueta.setText("  "+x);
                 }
                 else
                 {
                    etiqueta.setText(""+x); 
                 }
                inc=limInf;
                imprInc();
                          }
            else{
                x=x-var;
                x=Math.rint(x*10)/10;
                   if(x<10){
                     etiqueta.setText("  "+x);
                 }
                 else
                 {
                    etiqueta.setText(""+x); 
                 }
                inc=(float)x;
                imprInc();
                }
      }
    }
    
    
   public void valorBoton(JLabel etiqueta,float n, int idAtritbuto)
    {
     if(n<10)
     {
     etiqueta.setText("  "+n);
     }
     else{
     etiqueta.setText(""+n);
     }
      if(idAtritbuto==0){
            vel=n;
            imprVel();
        }else{
           inc=n;  
           imprInc();
        }
    }
   public void imprVel(){
    System.out.println("La velocidad es: "+vel);
}
public void imprInc(){
    System.out.println("La inclinación es: "+inc);
}


}

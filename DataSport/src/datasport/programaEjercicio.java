/*
 * To change this license header, choose License Headers in project properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasport;

/**
 *
 * @author Reinaldo pabon
 */
public class programaEjercicio {
    
   private float vel;
   private float inc;
   private int vuelta;
   private float calorias; /*No se si sea float 
                            o sea int, por favor revisar
                            */
   private float cv, ci, e, k, p;

    public programaEjercicio(float vel, float inc, float e, float p) {
        this.vel = vel;
        this.inc = inc;
        this.e = e;
        this.p = p;
    }

  

 
public float getVel() {
        return vel;
    }

    public float getInc() {
        return inc;
    }

    public int getVuelta() {
        return vuelta;
    }

    public float getCalorias() {
        return calorias;
    }
   
    public float calcularkm(float vel/*, time tiempo*/ ) //Falta colocar el tiempo
    {
      return 1;                                      /* Se coloca 1 para evitar 
                                                        obtener errores
                                                      */
    }
    
    public int calcularVueltas(float vel/*, time tiempo*/)
    {
      return 1;
              
    }
    
    public int calculaTimeLap()
    {
          return 1;
    }
    
    public float calAcum(float cal)
    {
        return 1;
    }
    
    public float calcularCal()
    {
        k = 10 + 10*((30-e)/10) + 10*(p/100);
        cv = (k*(1+(vel-5)/10));
        ci = k*(inc/12);
        calorias=cv+ci;
        return calorias;
    }
    
}

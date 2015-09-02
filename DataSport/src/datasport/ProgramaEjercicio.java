/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasport;

/**
 *
 * @author Reinaldo Pabon
 */
public class ProgramaEjercicio {
    
   private float vel;
   private float inc;
   private int vuelta;
   private float calorias; /*No se si sea float 
                            o sea int, por favor revisar
                            */

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
   
    public float calcularKm(float vel, time tiempo ) //Falta colocar el tiempo
    {
      return 1;                                      /* Se coloca 1 para evitar 
                                                        obtener errores
                                                      */
    }
    
    public int calcularVueltas(float vel, time tiempo)
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
    
    public float calcularCal(float vel, float inc)
    {
        return 1;
    }
    
}

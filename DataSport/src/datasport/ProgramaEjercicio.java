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
public class ProgramaEjercicio{
   private Reloj2 r; //Falta un metodo que calcule a partir de una interaccion la diferencia de tiempo entre el actual y el de partida
   private float vel;
   private float inc;
   private int vuelta;
   private float calorias; /*No se si sea float 
                            o sea int, por favor revisar
                            */
   private float cv, ci;
   private float caloriasAcumuladas;
   private static final float K=10f;        //es una constante, no es necesario que cambie

    public ProgramaEjercicio(float vel, float inc) {

        this.vel = vel;
        this.inc = inc;
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


   
    public float calcularKm(float vel/*, time tiempo*/ ) //Falta colocar el tiempo
    {
        float tiempoTotal= 100.5f;                              //Esta en segundos
        return tiempoTotal/vel;                                                /* Se coloca 1 para evitar 
                                                                obtener errores
                                                                */
    }
    
    public int calcularVueltas(float vel/*, time tiempo*/)      //Hay que mirar cómo colocar el tiempo
    {
      return 1;
              
    }
    
    public int calculaTimeLap() 
    {
          return 1;
    }
    
    public float calAcum()
    {
       caloriasAcumuladas=0;
       int minutos=10;      //Cantidad de minutos que ha trotado el usuario. Tomar este tiempo de reloj actual menos partida.
       for(int i=1; i<=minutos; i++)
       {
           caloriasAcumuladas=caloriasAcumuladas+calcularCal();
           /*System.out.println(caloriasAcumuladas);
           System.out.println("\n"); 
                   */
      }
        
        return caloriasAcumuladas;
    }
    
    public float calcularCal()
    {
       // K = 10 + 10*((30-e)/10) + 10*(p/100);     Por si necesita modificar    
        cv = (K*(1+(vel-5)/10));
        ci = K*(inc/12);
        calorias=cv+ci;
        return calorias;
    }
    
}

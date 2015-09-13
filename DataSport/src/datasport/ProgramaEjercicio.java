/*
 * To change this license header, choose License Headers in project properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasport;

//import testeando.Reloj2;

/**
 *
 * @author Reinaldo pabon
 */
public class ProgramaEjercicio{
    //Falta un metodo que calcule a partir de una interaccion la diferencia de tiempo entre el actual y el de partida
   private int tiempo;
   private float vel;
   private float inc;
   private int vuelta;
   private int intervalo;  //Cada cuanto va a hacer el cálculo de calorías, 10, 20, 30 seg.
   private float calorias; /*No se si sea float 
                            o sea int, por favor revisar
                            */
   private float cv, ci;
   private int distanciaAcum; //aca se almacena la distancia que va recorriendo
   private float caloriasAcumuladas;
   private static final float K=10f;        //es una constante, no es necesario que cambie

    public ProgramaEjercicio(float vel, float inc, int tiempo, int intervalo) {

        this.vel = vel;
        this.inc = inc;
        this.tiempo=tiempo;
        caloriasAcumuladas=0;
        this.intervalo=intervalo;
    }
   
//metodos setter de velocidad e inclinacion

    public void setVel(float vel) {
        this.vel = vel;
    }
    public void setInc(float inc)
    {
        this.inc = inc;
    }
   

//metodos reset mandan al valor inicial cuando son invocados
public void resetCalorias()
{
caloriasAcumuladas=0;
}

    public int getIntervalo() {
        return intervalo;
    }

public void resetVuelta()
{
vuelta=0;
}

  public void resetKm()
    {
 distanciaAcum=0;
    }
  
public float getVel() 
    {
        return vel;
    }

    public float getInc() {
        return inc;
    }

    public int getVuelta() {
        return vuelta;
    }

 
   
    public void calcularKm(float vel,int tiempo ) 
    {
        distanciaAcum=(int)vel*tiempo;
        System.out.println(distanciaAcum);                                              
    }
    
    public int calcularVueltas(float vel, int tiempo)      //Hay que mirar cómo colocar el tiempo
    {
      return 1;
              
    }
    
    public void calculaTimeLap(int contador) 
    {
          if(distanciaAcum%400==0) //lleva una vuelta
          {
              vuelta++;
              
          System.out.println("Tardo "+contador+" segundos en dar "+vuelta+"vueltas");
          }
    }
    
    public void calAcum()
    {
      //Cantidad de minutos que ha trotado el usuario. Tomar este tiempo de reloj actual menos partida.
      
           caloriasAcumuladas=caloriasAcumuladas+calcularCal(tiempo,intervalo);
           System.out.println(caloriasAcumuladas);

      
    }
    
    public float calcularCal(int contador, int intervalo) //cambiar para que calcule cada segundo
    {                                                                           //intervalo es el parámetro para decirle cada cuanto
       // K = 10 + 10*((30-e)/10) + 10*(p/100);                                 Por si necesita modificar   las calorías deben ser calculadas
        if(contador==intervalo)
    {
        cv = (K*(1+(vel-5)/10));
        ci = K*(inc/12);
        calorias=cv+ci;
        return calorias;
    }
        else
            return 0;
    }
}

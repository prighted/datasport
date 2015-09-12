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
   private float calorias; /*No se si sea float 
                            o sea int, por favor revisar
                            */
   private float cv, ci;
   private int distanciaAcum; //aca se almacena la distancia que va recorriendo
   private float caloriasAcumuladas;
   private static final float K=10f;        //es una constante, no es necesario que cambie

    public ProgramaEjercicio(float vel, float inc, int tiempo) {

        this.vel = vel;
        this.inc = inc;
        this.tiempo=tiempo;
        caloriasAcumuladas=0;
    }
   

  //metodos reset mandan al valor inicial cuando son invocados
public void resetCalorias()
{
caloriasAcumuladas=0;
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

 
   
    public void calcularKm(float vel,int tiempo ) //Falta colocar el tiempo
    {
                                  //Esta en segundos
        distanciaAcum=(int)vel*tiempo;
        System.out.println(distanciaAcum);                                               /* Se coloca 1 para evitar 
                                                                obtener errores
                                                                */
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
    
    public void calAcum(int tiempo)
    {
      //Cantidad de minutos que ha trotado el usuario. Tomar este tiempo de reloj actual menos partida.
      
           caloriasAcumuladas=caloriasAcumuladas+calcularCal();
           System.out.println(caloriasAcumuladas);

      
    }
    
    public float calcularCal() //cambiar para que calcule cada segundo
    {
       // K = 10 + 10*((30-e)/10) + 10*(p/100);     Por si necesita modificar    
        cv = (K*(1+(vel-5)/10));
        ci = K*(inc/12);
        calorias=cv+ci;
        return calorias;
    }
    
}

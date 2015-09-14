/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasport;

/**
 * Esta clase se encarga de crear tres vectores. Intensidades,velocidades y vueltas.
 * Inicialmente estos valores son incrementales. Mas adelante se podran modificar desde un txt 
 * @author 123
 */
public class Intensidad {
   private int[] noLaps;
   private float[] inc,vel;
   
   //por ahora se declaran ese monton de atributos mientras disponemos de un txt por ahora se hara de esa forma
 
   public Intensidad()
   {
   noLaps=new int[12];
   inc=new float[12];
   vel=new float[12];
   //cada uno de esos parametros se obtendra del txt. La intensidad es la tripla noLaps,inc,vel
   noLaps[0]=1;inc[0]=1;vel[0]=1;//intensidad1
   noLaps[1]=2;inc[1]=2;vel[1]=2;//intensidad2
   noLaps[2]=3;inc[2]=3;vel[2]=3;//intensidad3
   noLaps[3]=4;inc[3]=4;vel[3]=4;//intensidad4
   noLaps[4]=5;inc[4]=5;vel[4]=5;//intensidad5
   noLaps[5]=6;inc[5]=6;vel[5]=6;//intensidad6
   noLaps[6]=7;inc[6]=7;vel[6]=7;//intensidad7
   noLaps[7]=8;inc[7]=8;vel[7]=8;//intensidad8
   noLaps[8]=9;inc[8]=9;vel[8]=9;//intensidad9
   noLaps[9]=10;inc[9]=10;vel[9]=10;//intensidad10
   noLaps[10]=11;inc[10]=11;vel[10]=11;//intensidad11
   noLaps[11]=12;inc[11]=12;vel[11]=12;//intensidad12
        
   }
   

public float getVel(int intensidad) //[1,12]
{
return vel[intensidad-1];
}
public int getNoLaps(int intensidad) //[1,12]
{
return noLaps[intensidad-1];
}
}

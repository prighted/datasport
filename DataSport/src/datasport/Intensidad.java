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
    
   private int vuelta, idIntensidad;
   private float inc,vel;
   
   //por ahora se declaran ese monton de atributos mientras disponemos de un txt por ahora se hara de esa forma

    public Intensidad(int vuelta, int idIntensidad, float inc, float vel) {
        this.vuelta = vuelta;
        this.idIntensidad = idIntensidad;
        this.inc = inc;
        this.vel = vel;
    }

    public int getVuelta() {
        return vuelta;
    }

    public int getIdIntensidad() {
        return idIntensidad;
    }

    public float getInc() {
        return inc;
    }

    public float getVel() {
        return vel;
    }

    public void setVuelta(int vuelta) {
        this.vuelta = vuelta;
    }

    public void setIdIntensidad(int idIntensidad) {
        this.idIntensidad = idIntensidad;
    }

    public void setInc(float inc) {
        this.inc = inc;
    }

    public void setVel(float vel) {
        this.vel = vel;
    }
 
   
   
}

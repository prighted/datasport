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
public class Vuelta {
    private int noVuelta;
    float vel;
    float inc;

    public Vuelta(int noVuelta, float vel, float inc) {
        this.noVuelta = noVuelta;
        this.vel = vel;
        this.inc = inc;
    }

    public int getNoVuelta() {
        return noVuelta;
    }

    public float getVel() {
        return vel;
    }

    public float getInc() {
        return inc;
    }

    public void setNoVuelta(int noVuelta) {
        this.noVuelta = noVuelta;
    }

    public void setVel(float vel) {
        this.vel = vel;
    }

    public void setInc(float inc) {
        this.inc = inc;
    }
    
    
}

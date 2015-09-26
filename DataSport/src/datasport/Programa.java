/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasport;

/**
 * Esta clase se encarga de crear tres vectores. Intensidades,velocidades y
 * vueltas. Inicialmente estos valores son incrementales. Mas adelante se podran
 * modificar desde un txt
 *
 * @author 123
 */
public class Programa {

    private int noPrograma;
//Tipo [ ] nombreDelArray = new Tipo [número];
    private Vuelta[] vueltas;

    public Programa(int noPrograma, Vuelta[] vueltas) {
        this.noPrograma = noPrograma;
        this.vueltas = vueltas;
    }

    public int getNoPrograma() {
        return noPrograma;
    }

    public Vuelta[] getVueltas() {
        return vueltas;
    }

    public void setNoPrograma(int noPrograma) {
        this.noPrograma = noPrograma;
    }

    public void setVueltas(Vuelta[] vueltas) {
        this.vueltas = vueltas;
    }

    public int getNoVuelta(int vuelta) {
        int noVuelta = vueltas[vuelta].getNoVuelta();
        return noVuelta;
    }
    
    public float getVelVuelta(int vuelta){
        float velVuelta = vueltas[vuelta].getVel();
        return velVuelta;
    }
    
    public float getIncVuelta(int vuelta){
        float incVuelta = vueltas[vuelta].getInc();
        return incVuelta;
    }
    
    public void imprProg1() {
        int j;
        for (int i = 0; i < vueltas.length; i++) {

            j = i + 1;
            System.out.println("Datos vuelta " + j + " No. Vuelta: " + vueltas[i].getNoVuelta() + " Velocidad: "
                    + vueltas[i].getVel() + " Inclinación: " + vueltas[i].getInc());

        }

    }

}

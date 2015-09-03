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
public class Test {
    
    public static void main(String[] args)
    {
        float v=1.1f;
        float i=0.5f;
        
        ProgramaEjercicio p = new ProgramaEjercicio(v, i);
        float calorias, calAcum;
        calorias=p.calcularCal();
        calAcum=p.calAcum();
        System.out.println("Las calorías son " + calorias);
        System.out.println("Las calorías acumuladas son " + calAcum);
    }
}

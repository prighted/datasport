/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasport;

import javax.swing.JLabel;


/**
 * Esta sera la clase principal de la app Aclaro no sera el ejecutable.
 *
 * @author Reinaldo Pabonh
 */
public class DataSport {
    /*
     vel=velocidad
     inc=inclinación
     limSup=Limite Superior de las etiquetas del ModoLibre
     limInf=Limite Inferior de las etiquetas del ModoLibre
     var= Variación de la vel/inc con +y -
     tiempo= tiempo transcurrido
     intervalo= cada cuanto se hace el cálculo de las calorías
     modo=0:ModoLibre, 1:Prestablecido
     idAtributo=0:Velocidad, 1:Inclinacion
     */

    private float vel, inc, cal, calAcum, K, distanciaAcum, kms;
    private int vuelta, kmVuelta, modo;
    //private int intervalo
    private Intensidad intensidad1, intensidad2;
    // private Relojrun reloj;

    public DataSport() {
        //Modo Libre
        //    this.reloj = reloj;
        // this.intervalo = 60;
        modo = 0;
        K = 10f;
        //tiempo = (int) reloj.getTiempoTranscurrido();
    }

    public DataSport(/*int intervalo, */int kmVuelta) {
        //Modo Prestablecido
        //  this.intervalo = intervalo;
        this.kmVuelta = kmVuelta;
        modo = 1;
        cal = 0.0f;
        vel = 10.0f;
        inc = 0.0f;
        distanciaAcum = 0.0f;
        //this.intensidad = intensidad;
        K = 10f;

    }

    /*
     INICIO Declaración de getters y Setters
     */
    public float getVel() {
        return vel;
    }

    public float getInc() {
        return inc;
    }

    public float getCal() {
        return cal;
    }

    public float getCalAcum() {
        return calAcum;
    }

    public int getVuelta() {
        return vuelta;
    }

    public float getDistanciaAcum() {
        return distanciaAcum;
    }

    public int getModo() {
        return modo;
    }

    public void setCal(float cal) {
        this.cal = cal;
    }

    /*
     FIN Declaración Getters y Setters
     */
    public void aumentar(JLabel etiqueta, float limSup, float limInf, float var,
            int idAtributo) {
        double x = Float.parseFloat(etiqueta.getText());
        if (idAtributo == 0) {
            if ((x < limInf)) {
                if (x < 10) {
                    etiqueta.setText("  " + limInf);
                } //Para que se vea de una buena forma
                else {
                    etiqueta.setText("" + limInf);
                }
                vel = limInf;                                                      //Se establece la velocidad  
                imprVel();
            } else {
                if (x == limSup) {
                    if (x < 10) {
                        etiqueta.setText("  " + limSup);
                    } else {
                        etiqueta.setText("" + limSup);
                    }
                    vel = limSup;
                    imprVel();
                } else {
                    x = x + var;
                    x = Math.rint(x * 10) / 10;
                    if (x < 10) {
                        etiqueta.setText("  " + x);
                    } else {
                        etiqueta.setText("" + x);
                    }
                    vel = (float) x;
                    imprVel();
                }
            }
        } else {
            if ((x < limInf)) {
                if (x < 10) {
                    etiqueta.setText("  " + limInf);
                } else {
                    etiqueta.setText("" + limInf);
                }
                inc = limInf;                                                      //Se establece la velocidad  
                imprInc();
            } else {
                if (x == limSup) {
                    if (x < 10) {
                        etiqueta.setText("  " + limSup);
                    } else {
                        etiqueta.setText("" + limSup);
                    }
                    inc = limSup;
                    imprInc();
                } else {
                    x = x + var;
                    x = Math.rint(x * 10) / 10;
                    if (x < 10) {
                        etiqueta.setText("  " + x);
                    } else {
                        etiqueta.setText("" + x);
                    }//redondea a dos dígitos
                    inc = (float) x;
                    imprInc();
                }
            }
        }
    }

    public void reducir(JLabel etiqueta, float limInf, float var, int idAtributo) {
        double x = Float.parseFloat(etiqueta.getText());
        if (idAtributo == 0) {

            if (x == limInf) {
                if (x < 10) {
                    etiqueta.setText("  " + limInf);
                } else {
                    etiqueta.setText("" + limInf);
                }
                vel = limInf;
                imprVel();
            } else {
                x = x - var;
                x = Math.rint(x * 10) / 10;
                if (x < 10) {
                    etiqueta.setText("  " + x);
                } else {
                    etiqueta.setText("" + x);
                }
                vel = (float) x;
                imprVel();
            }
        } else {
            if (x == limInf) {
                if (x < 10) {
                    etiqueta.setText("  " + x);
                } else {
                    etiqueta.setText("" + x);
                }
                inc = limInf;
                imprInc();
            } else {
                x = x - var;
                x = Math.rint(x * 10) / 10;
                if (x < 10) {
                    etiqueta.setText("  " + x);
                } else {
                    etiqueta.setText("" + x);
                }
                inc = (float) x;
                imprInc();
            }
        }
    }

    public void valorBoton(JLabel etiqueta, float n, int idAtritbuto) {
        if (n < 10) {
            etiqueta.setText("  " + n);
        } else {
            etiqueta.setText("" + n);
        }
        if (idAtritbuto == 0) {
            vel = n;
            imprVel();
        } else {
            inc = n;
            imprInc();
        }
    }

    public void imprVel() {
        System.out.println("La velocidad es: " + vel);
    }

    public void imprInc() {
        System.out.println("La inclinación es: " + inc);
    }

    public void resetCalorias() {
        calAcum = 0;
    }

    public void resetVuelta() {
        vuelta = 0;
    }

    public void resetKm() {
        distanciaAcum = 0;
    }

    public void resetParametros() {
        vuelta = 0;
        cal = 0;

    }

    public String getCalString() {
        String calorias = "" + cal;
        return calorias;
    }

    public String getVueltaString() {
        String sV = "" + vuelta;
        return sV;
    }

    public void calculaTimeLap() {
//        int 
//        if ((0.4 % distanciaAcum) == 0) //lleva una vuelta
//        {
//            vuelta=1+vuelta;
//        }
    }

    public void calcularVuelta() {
        float distanciaM =  kms*1000; //pasa la distancia metros
        float modulo = distanciaM%400;
        System.out.println("El modulo es: " +modulo);
        if ((distanciaAcum==0)) {
            vuelta=0;
        }
        else{
            if(modulo == 0){
            vuelta++;
        } 
        }
       
    }

    public float calcularCal(long intervalo) 
    {
        /*
         Calcula las calorias guardandolas en el atributo y retorna el String 
         para mostrar en pantall
         */
        float calorias;
        float cv;
        float ci;
     
        cv = (K * (1 + (vel - 5) / 10));
        ci = K * (inc / 12);
        calorias = (cv + ci) / intervalo;
        cal = cal + calorias;
        cal = (float) Math.rint(cal * 100) / 100;

        return cal;
        
        // K = 10 + 10*((30-e)/10) + 10*(p/100);                                 Por si necesita modificar   las calorías deben ser calculadas
        
        //
    }

    public void calcularKm(long tiempo) {
        float km = (vel * tiempo / 3600);
        distanciaAcum = km;
        kms = km;
        distanciaAcum = (float) Math.rint(distanciaAcum * 100) / 100;
        System.out.println("km con formato= "+distanciaAcum);
        System.out.println("km sin formato= "+kms);
    }

    public String getDistAcumString() {
        String kms = "" + distanciaAcum;
        return kms;
    }
}

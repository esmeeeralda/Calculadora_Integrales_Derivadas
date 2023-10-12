/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Principal.CDI;
import Principal.ExpresionAlgebraica;
import Principal.ProcesarFunciones;
import java.util.ArrayList;

public class Cociente extends CDI {

    static ExpresionAlgebraica[] num1;
    static ExpresionAlgebraica[] num2;
    static ExpresionAlgebraica[] res;
    static ArrayList Segmento = new ArrayList();
    static ArrayList Signo = new ArrayList();

    /**
     * Calcula el cociente de dos expresiones algebraicas.
     *
     * @param mult1 Un arreglo de ExpresionAlgebraica que representa el
     * numerador.
     * @param mult2 Un arreglo de ExpresionAlgebraica que representa el
     * denominador.
     * @return Un arreglo de ExpresionAlgebraica que representa el resultado
     * del cociente.
     */
    public static ExpresionAlgebraica[] CocienteVariables(ExpresionAlgebraica mult1[], ExpresionAlgebraica mult2[]) {

        int v = 0;
        ExpresionAlgebraica[] expreAUX = new ExpresionAlgebraica[mult1.length * mult2.length];
        float coefAUX;
        String expAUX, signAUX, varAUX;
        
        // Se itera sobre los elementos de mult1 y mult2
        for (ExpresionAlgebraica mult11 : mult1) {
            for (ExpresionAlgebraica mult21 : mult2) {
                // Se asegura de que las variables estén en minúsculas
                mult11.setVariable(mult11.getVariable().toLowerCase());
                mult21.setVariable(mult21.getVariable().toLowerCase());
                
                // Se verifica si los símbolos son iguales
                if (mult11.getSimbolo().equals(mult21.getSimbolo())) {
                    signAUX = "+";
                    
                    // Se verifica si las variables son iguales
                    if (mult11.getVariable().equals(mult21.getVariable())) {
                        expAUX = String.valueOf(Float.valueOf(mult11.getExponente()) - Float.valueOf(mult21.getExponente()));
                        coefAUX = mult11.getCoeficiente() / mult21.getCoeficiente();
                        varAUX = mult11.getVariable();
                        expreAUX[v] = new ExpresionAlgebraica(signAUX, coefAUX, varAUX, expAUX);
                    } else {
                        coefAUX = mult11.getCoeficiente() / mult21.getCoeficiente();
                        expreAUX[v] = new ExpresionAlgebraica(signAUX, coefAUX,
                                mult11.getVariable() + mult21.getVariable(), mult11.getExponente() + "*" + mult21.getExponente());
                    }
                } else {
                    signAUX = "-";
                    
                    // Se verifica si las variables son iguales
                    if (mult11.getVariable().equals(mult21.getVariable())) {
                        expAUX = String.valueOf(Float.valueOf(mult11.getExponente()) - Float.valueOf(mult21.getExponente()));
                        coefAUX = mult11.getCoeficiente() / mult21.getCoeficiente();
                        varAUX = mult11.getVariable();
                        expreAUX[v] = new ExpresionAlgebraica(signAUX, coefAUX, varAUX, expAUX);
                    } else {
                        coefAUX = mult11.getCoeficiente() / mult21.getCoeficiente();
                        expreAUX[v] = new ExpresionAlgebraica(signAUX, coefAUX,
                                mult11.getVariable() + mult21.getVariable(), mult11.getExponente() + mult21.getExponente());
                    }
                }
                v++;
            }
        }
        
        // Se limpian los ArrayLists Segmento y Signo
        Segmento.clear();
        Signo.clear();
        
        // Se agregan las expresiones al ArrayList Segmento y los signos al ArrayList Signo
        for (ExpresionAlgebraica expreAUX1 : expreAUX) {
            Segmento.add(expreAUX1.getCoeficiente() + expreAUX1.getVariable() + "^" + expreAUX1.getExponente());
            Signo.add(expreAUX1.getSimbolo());
        }
        
        // Si el primer signo es "+", se elimina
        if (Signo.get(0).equals("+")) {
            Signo.remove(0);
        }

        // Se procesa el ArrayList Segmento y Signo utilizando el método jeraquia de la clase ProcesarFunciones
        return ProcesarFunciones.jeraquia(Segmento, Signo);
    }
}
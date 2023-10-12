/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Derivadas;

import Principal.ExpresionAlgebraica;
import Principal.CDI;
import Principal.SintaxisExpresiones;

public class Exponencial extends CDI { //Se declara la clase como exponencia para luego ser llamada
    //que se encarga de realizar operaciones relacionadas con exponenciales y cálculos de derivadas.

    static ExpresionAlgebraica[] exp;
    static ExpresionAlgebraica[] expr;

    // Método para calcular la derivada de una función exponencial
    public static ExpresionAlgebraica[] exponencial(String cad, String dif) {
        int t = 0;
        String ExpInter = cad.substring(cad.indexOf("(") + 1, cad.lastIndexOf(")"));
     // Crea la representación de la expresión exponencial
        String ExpExter = "e^(".concat(ExpInter) + ")";

        // Obtiene un arreglo de ExpresionAlgebraica a partir de la expresión interior
        exp = SintaxisExpresiones.Sintaxis(ExpInter, "d", true, dif);
        expr = new ExpresionAlgebraica[exp.length + 1];

        // Copia las expresiones en un nuevo arreglo y añade la expresión de la exponencial
        for (int i = 0; i < exp.length; i++) {
            expr[i] = new ExpresionAlgebraica(exp[i].getSimbolo(), exp[i].getCoeficiente(), exp[i].getVariable(), exp[i].getExponente());
            t++;
        }
        expr[t] = new ExpresionAlgebraica("", 1, "e", ExpInter);

        return expr;
    }
}

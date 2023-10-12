/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Derivadas;

import Principal.CDI;
import Principal.ExpresionAlgebraica;
import Principal.SintaxisExpresiones;
import java.util.ArrayList;
//Código para calcular las derivadas de funciones trigonométricas y logartimicas
// Funciona al recibir una expresión algebraica y el tipo de diferenciación (dif). Luego,
//determina qué función trigonométrica debe aplicarse y utiliza métodos específicos para calcular la derivada de cada una.

public class DerivadasTrigonometricas extends CDI {

    static ExpresionAlgebraica[] exp;

    public static ArrayList correr(ArrayList expre, String dif) {
        ArrayList expr = expre;
        String salida;
        int id;
        for (int i = 0; i < expr.size(); i++) {
            switch (expr.get(i).toString().toLowerCase().substring(0, expr.get(i).toString().indexOf("("))) {
                // Aquí se están procesando diferentes funciones trigonométricas
                case "sen":
                    salida = expr.get(i).toString();
                    id = 0;
                    expr.set(i, funcion(salida, id, dif));
                    break;
                case "cos":
                    salida = expr.get(i).toString();
                    id = 1;
                    expr.set(i, funcion(salida, id, dif));
                    break;
                case "tan":
                    salida = expr.get(i).toString();
                    id = 2;
                    expr.set(i, funcion(salida, id, dif));
                    break;
                case "cot":
                    salida = expr.get(i).toString();
                    id = 3;
                    expr.set(i, funcion(salida, id, dif));
                    break;
                case "sec":
                    salida = expr.get(i).toString();
                    id = 4;
                    expr.set(i, funcion(salida, id, dif));
                    break;
                case "csc":
                    id = 5;
                    salida = expr.get(i).toString();
                    expr.set(i, funcion(salida, id, dif));
                    break;
            }

        }
        return expr;
    }
// Método que determina qué función trigonométrica debe aplicarse
    private static String funcion(String cad, int op, String dif) {
        String respuesta = "";
        switch (op) {
            case 0: {
                respuesta = sen(cad, dif);
            }
            break;
            case 1: {
                respuesta = cos(cad, dif);
            }
            break;
            case 2: {
                respuesta = tan(cad, dif);
            }
            break;
            case 3: {
                respuesta = cot(cad, dif);
            }
            break;
            case 4: {
                respuesta = sec(cad, dif);
            }
            break;
            case 5: {
                respuesta = csc(cad, dif);
            }
            break;
        }
        return respuesta;
    }

    private static String sen(String cad, String dif) {
// Método para calcular la derivada de la función seno,coseno,tangente,el mismo código
//se repite en todo, es ahí donde se utiliza la herencia en cada uno.
        String ExpInter = cad.substring(cad.indexOf("(") + 1, cad.lastIndexOf(")"));

        String ExpExter = "cos(".concat(ExpInter) + ")";

        exp = SintaxisExpresiones.Sintaxis(ExpInter, "d", true, dif);

        cad = "";

        for (ExpresionAlgebraica exp1 : exp) {
            cad = cad.concat(String.format("%s%s%s^%s", exp1.getSimbolo(),
                    exp1.getCoeficiente(), exp1.getVariable(), exp1.getExponente()));
        }

        cad = cad + " ";
        cad = cad.concat(ExpExter);

        return cad;
    }

    private static String cos(String cad, String dif) {

        String ExpInter = cad.substring(cad.indexOf("(") + 1, cad.lastIndexOf(")"));
        exp = SintaxisExpresiones.Sintaxis(ExpInter, "d", true, dif);

        if (ExpInter.charAt(0) == '-') {
            ExpInter = ExpInter.substring(1, ExpInter.length());
        }
        String ExpExter = "sen(".concat(ExpInter) + ")";

        for (ExpresionAlgebraica exp1 : exp) {
            if ("+".equals(exp1.getSimbolo())) {
                exp1.setSimbolo("-");
            } else {
                exp1.setSimbolo("+");
            }
        }
        cad = "";

        for (ExpresionAlgebraica exp1 : exp) {
            cad = cad.concat(String.format("%s%s%s^%s", exp1.getSimbolo(),
                    exp1.getCoeficiente(), exp1.getVariable(), exp1.getExponente()));
        }

        cad = cad + " ";
        cad = cad.concat(ExpExter);
        //  cad = cad.concat(ExpInter);

        return cad;
    }

    private static String tan(String cad, String dif) {

        String ExpInter = cad.substring(cad.indexOf("(") + 1, cad.lastIndexOf(")"));

        String ExpExter = "sec^2(".concat(ExpInter) + ")";

        exp = SintaxisExpresiones.Sintaxis(ExpInter, "d", true, dif);

        cad = "";

        for (ExpresionAlgebraica exp1 : exp) {
            cad = cad.concat(String.format("%s%s%s^%s", exp1.getSimbolo(),
                    exp1.getCoeficiente(), exp1.getVariable(), exp1.getExponente()));
        }

        cad = cad + " ";
        cad = cad.concat(ExpExter);
        //  cad = cad.concat(ExpInter);

        return cad;
    }

    private static String cot(String cad, String dif) {

        String ExpInter = cad.substring(cad.indexOf("(") + 1, cad.lastIndexOf(")"));
        exp = SintaxisExpresiones.Sintaxis(ExpInter, "d", true, dif);

        if (ExpInter.charAt(0) == '-') {
            ExpInter = ExpInter.substring(1, ExpInter.length());
        }
        String ExpExter = "csc^2(".concat(ExpInter) + ")";

        for (ExpresionAlgebraica exp1 : exp) {
            if ("+".equals(exp1.getSimbolo())) {
                exp1.setSimbolo("-");
            } else {
                exp1.setSimbolo("+");
            }
        }
        cad = "";

        for (ExpresionAlgebraica exp1 : exp) {
            cad = cad.concat(String.format("%s%s%s^%s", exp1.getSimbolo(),
                    exp1.getCoeficiente(), exp1.getVariable(), exp1.getExponente()));
        }

        cad = cad + " ";
        cad = cad.concat(ExpExter);
        //  cad = cad.concat(ExpInter);

        return cad;
    }

    private static String sec(String cad, String dif) {

        String ExpInter = cad.substring(cad.indexOf("(") + 1, cad.lastIndexOf(")"));

        String ExpExter = "sec(".concat(ExpInter) + ") " + "tan(".concat(ExpInter) + ")";

        exp = SintaxisExpresiones.Sintaxis(ExpInter, "d", true, dif);

        cad = "";

        for (ExpresionAlgebraica exp1 : exp) {
            cad = cad.concat(String.format("%s%s%s^%s", exp1.getSimbolo(),
                    exp1.getCoeficiente(), exp1.getVariable(), exp1.getExponente()));
        }

        cad = cad + " ";
        cad = cad.concat(ExpExter);
        //  cad = cad.concat(ExpInter);

        return cad;
    }

    private static String csc(String cad, String dif) {
        String ExpInter = cad.substring(cad.indexOf("(") + 1, cad.lastIndexOf(")"));
        exp = SintaxisExpresiones.Sintaxis(ExpInter, "d", true, dif);

        if (ExpInter.charAt(0) == '-') {
            ExpInter = ExpInter.substring(1, ExpInter.length());
        }
        String ExpExter = "csc(".concat(ExpInter) + ") " + "cot(".concat(ExpInter) + ")";

        for (ExpresionAlgebraica exp1 : exp) {
            if ("+".equals(exp1.getSimbolo())) {
                exp1.setSimbolo("-");
            } else {
                exp1.setSimbolo("+");
            }
        }
        cad = "";

        for (ExpresionAlgebraica exp1 : exp) {
            cad = cad.concat(String.format("%s%s%s^%s", exp1.getSimbolo(),
                    exp1.getCoeficiente(), exp1.getVariable(), exp1.getExponente()));
        }

        cad = cad + " ";
        cad = cad.concat(ExpExter);

        return cad;
    }

    // Método para calcular la derivada de una función logarítmica
    private static String logN(String cad, String dif) {

        String ExpInter = cad.substring(cad.indexOf("(") + 1, cad.lastIndexOf(")"));

        exp = SintaxisExpresiones.Sintaxis(ExpInter, "d", true, dif);

        cad = "";

        for (ExpresionAlgebraica exp1 : exp) {
            cad = cad.concat(String.format("%s%s%s^%s", exp1.getSimbolo(),
                    exp1.getCoeficiente(), exp1.getVariable(), exp1.getExponente()));
        }

        return cad;
    }
}

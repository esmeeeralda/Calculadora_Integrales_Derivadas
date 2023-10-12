/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Principal.CDI;
import java.util.ArrayList;

public class NewMain {

    public static ArrayList Procedimiento = new ArrayList();
    public static ArrayList Resultado = new ArrayList();

    /**
     * Método principal de la aplicación.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        // TODO code application logic here 
        // Se inicializan algunas variables
        ArrayList componentes = new ArrayList();
        String[] cadena;

        ArrayList resueltocdi;
        String expesion = ""
                + "+cos(x)"
                + "+3x^5"
                + "-tan(x)"
                + "-ln(4x^3)"
                + "-4x^7";
        String[] cad = new String[expesion.length()];
        int cont = 0, cont2 = 0;

        // Se divide la expresión en componentes basados en los símbolos + y -
        for (int i = 0; i < expesion.length(); i++) {//43  45

            if (expesion.charAt(i) == '+' || expesion.charAt(i) == '-') {
//                simbolos[cont] = expesion.charAt(i);
                cad[cont] = /*expesion.charAt(i) +*/ expesion.substring(cont2, i);
                //            System.out.println(CDI.CDIMaster(cad[cont], "d", "x"));
                cont++;

                cont2 = i;//+ 1;
            }

            // Se maneja el último componente después del último símbolo
            if (!expesion.substring(cont2 + 1, expesion.length()).contains("+") && !expesion.substring(cont2 + 1, expesion.length()).contains("-")) {
//                simbolos[cont] = expesion.charAt(i);
                cad[cont] = /*expesion.charAt(cont2)+*/ expesion.substring(cont2, expesion.length());
            }
        }
        
        // Se agregan los componentes no nulos y de longitud no cero al ArrayList componentes
        for (String cad1 : cad) {
            if (cad1 != null) {
                if (cad1.length() != 0) {
                    componentes.add(cad1);
                }
            }
        }
        // Convierte 'componentes' a un arreglo de cadenas 'cadena'
        cadena = new String[componentes.size()];
        for (int i = 0; i < componentes.size(); i++) {
            cadena[i] = componentes.get(i).toString();
        }
        // Imprime los componentes separados
        for (int i = 0; i < cadena.length; i++) {
            System.out.println(">>" + cadena[i]);
        }

        System.out.println("\n\n\n");
       // Elimina el signo '+' al inicio de cada componente
        for (int i = 0; i < cadena.length; i++) {
            if (cadena[i].charAt(0) == '+') {
                cadena[i] = cadena[i].substring(1);
            }
        }
        // Imprime los componentes sin el signo '+'
        for (int i = 0; i < cadena.length; i++) {
            System.out.println(">>" + cadena[i]);
        }
        // Procesa cada componente y almacena los resultados en 'Procedimiento' y 'Resultado'
        for (String cad1 : cadena) {
            resueltocdi = CDI.CDIMaster(cad1, "d", "x");
            for (int i = 0; i < resueltocdi.size(); i++) {
                if (resueltocdi.get(i) != "&&&") {
                    Procedimiento.add(resueltocdi.get(i));
                } else {
                    int c = i++;
                    for (int j = c; j < resueltocdi.size(); j++) {
                        Resultado.add(resueltocdi.get(j));
                    }
                    break;
                }
            }
            // Limpia las listas de resultados de CDI
            CDI.expz.clear();
            CDI.resultados.clear();

            //+ " cont2: " + cont2 + " i:" + i);
        }
        
        // Imprime los resultados en 'Procedimiento'
        for (int i = 0; i < Procedimiento.size(); i++) {
            System.out.println(Procedimiento.get(i));
        }
        System.out.println("\n\n\n");
        // Imprime los resultados en 'Resultado' excluyendo "&&&"
        for (int i = 0; i < Resultado.size(); i++) {
            if (Resultado.get(i) != "&&&") {
                System.out.print(Resultado.get(i) + " ");
            }
        }

    }

}
       
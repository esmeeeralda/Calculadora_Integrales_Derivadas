/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.util.ArrayList;

public class SintaxisExpresiones extends CDI {
     // Método para analizar y procesar una expresión algebraica
    public static ExpresionAlgebraica[] Sintaxis(String cad, String op, boolean Simplificando, String dif) {
        ArrayList partes = new ArrayList();
        ArrayList signo = new ArrayList();
        ArrayList signo2 = new ArrayList();
        cad = cad.replace(",", "");
        // Eliminar algunos caracteres especiales (",", "[", "]", "{", "}")
        // de la cadena "cad"
        cad = cad.replace("[", "");
        cad = cad.replace("]", "");
        cad = cad.replace("{", "");
        cad = cad.replace("}", "");
        String cadena = cad;
        String parte = "";
        boolean parentesis = false;
        // Bucle para procesar cada carácter en la cadena "cad"
        for (int i = 0; i < cadena.length(); i++) {
            // Verificar si es un operador o un carácter especial
            if ((cad.charAt(i) == '+' || (cad.charAt(i) == '-' && !parte.isEmpty())
                    || cad.charAt(i) == '*' || cad.charAt(i) == '/'
                    || i == cad.length() - 1 || (cad.charAt(i) == ')' && cad.charAt(i + 1) == '('))) {  // Verificar si el carácter actual es un cierre de paréntesis
                if (cad.charAt(i) == ')') {
                    parentesis = false;
                    parte = parte.concat(String.valueOf(cad.charAt(i)));
                } else if (i == cad.length() - 1) {
                    parte = parte.concat(String.valueOf(cad.charAt(i)));
                } else if (i > 0 && cad.charAt(i - 1) == '^') {
                    parte = parte.concat(String.valueOf(cad.charAt(i)));
                    continue;
                }
                if (!parentesis) { 
                    // Verificar si hay un cierre de paréntesis

                    if (i != cad.length() - 1) {
                        if (cad.charAt(i) != ')' && cad.charAt(i) != '(') {
                            signo.add(cad.charAt(i));
                        }
                    }
                    partes.add(parte);
                    parte = "";
                } else {
                    parte = parte.concat(String.valueOf(cad.charAt(i)));
                }
            } else {
                if (cad.charAt(i) == '(') {
                    parentesis = true;
                } else if (cad.charAt(i) == ')') {
                    parentesis = false;
                }
                parte = parte.concat(String.valueOf(cad.charAt(i)));
            }
        }
        if (!partes.isEmpty()) {
            if (partes.get(0).toString().length() > 1) {
                if (partes.get(0).toString().charAt(0) == '-') {
                    partes.set(0, partes.get(0).toString().substring(1, partes.get(0).toString().length()));
                    if (!signo.isEmpty()) {
                        signo2.add("-");
                        signo.stream().forEach((signo1) -> {
                            signo2.add(signo1);
                        });
                        signo.clear();
                        signo = signo2;

                    } else {
                        signo.add('-');
                    }
                }
            }
        }
        for (int i = 0; i < partes.size(); i++) {
            if (partes.get(i).toString().length() != 0) {
                if (partes.get(i).toString().charAt(0) == '-' || partes.get(i).toString().charAt(0) == '+') {
                    partes.set(i, partes.get(i).toString().substring(1));
                }
            }
        }

        if (Segmentador.segmentar) {
            Segmentador.Segmentar(cad, partes, signo, dif, op);
        }

        if (Simplificando) {
            return Enrrutar.Enrrutador(partes, signo, op, dif);
        } else {
            return ProcesarFunciones.jeraquia(partes, signo);
        }
    }
}

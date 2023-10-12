/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

public class ExpresionAlgebraica {
    
    // Variables miembro de la clase
    private String exponente;
    private float coeficiente = 0;
    private String variable;
    private String simbolo;

    // Constructor de la clase que inicializa los miembros
    public ExpresionAlgebraica(String simbolo, float coeficiente, String variable, String exponente) {
        this.variable = variable;
        this.simbolo = simbolo;
        this.coeficiente = coeficiente;
        this.exponente = exponente;
    }
    
    // Métodos para obtener y modificar el exponente
    public String getExponente() {
        return exponente;
        /**
         * @return the exponente
         */
    }

    public void setExponente(String exponente) {
        this.exponente = exponente;
        /**
         * @param exponente the exponente to set
         */
    }
    
     // Métodos para obtener y modificar el coeficiente
    public float getCoeficiente() {
        return coeficiente;
        /**
         * @return the coeficiente
         */
    }

    public void setCoeficiente(float coeficiente) {
        this.coeficiente = coeficiente;
        /**
         * @param coeficiente the coeficiente to set
         */
    }

    public String getVariable() { // Métodos para obtener y modificar la variable
        return variable;
        /**
         * @return the variable
         */
    }
    // Métodos para obtener y modificar el símbolo
    public void setVariable(String variable) {
        this.variable = variable;
        /**
         * @param variable the variable to set
         */
    }

    public String getSimbolo() {
        return simbolo;
        /**
         * @return the simbolo
         */
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
        /**
         * @param simbolo the simbolo to set
         */
    }
}


//En resumen, esta clase parece estar diseñada para representar y manipular términos de expresiones algebraicas. 
//Proporciona métodos para acceder y modificar los diferentes componentes de un término algebraico
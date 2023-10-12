/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;
// Importa la clase CDI  definida en otro archivo
public class OrdenarString extends CDI {

     // Método para ordenar un arreglo de Strings
    private static void arregla(String[] pru) {
        String aux;
        // Llama a la función de ordenamiento quicksort
        //   Arrays.sort(pru);
        quicksort(pru, 0, pru.length - 1);
        //  burbuja(pru);
        for (String pru1 : pru) {  // Imprime los elementos ordenados
            System.out.print(pru1 + " -> ");
        }
        System.out.println("");
        for (String pru1 : pru) { // Imprime los hashes y los Strings correspondientes
            System.out.println(pru1.hashCode() + " -> " + pru1 + " ");
        }
    }

    private static void burbuja(String[] a) {  // Método de ordenamiento burbuja
        String aux; // Variable auxiliar para intercambiar elementos
        for (int i = 1; i < a.length; i++) { // Bucle externo: Itera a través de los elementos del arreglo
            for (int j = 0; j < a.length - i; j++) {
                // Bucle interno: Itera a través de los elementos restantes
            // Se resta 'i' para optimizar y no revisar elementos ya ordenados
                if (a[j].hashCode() > a[j + 1].hashCode()) { // Compara los hashCode de los elementos adyacentes
                    // Si el hashCode del elemento actual es mayor al siguiente
                    aux = a[j]; // Intercambia los elementos
                    a[j] = a[j + 1];
                    a[j + 1] = aux;
                }
            }
        }
    }
// Método de ordenamiento quicksort
    public static void quicksort(String[] A, int izq, int der) {
        int i, j;
        String X, aux;
        i = izq;
        j = der;
        X = A[(izq + der) / 2];  // Selecciona el elemento medio del arreglo


        do {
            while ((A[i].hashCode() < X.hashCode()) && (j <= der)) {
                i++;
            }
            // Encuentra un elemento mayor o igual a X en la parte izquierda


            while ((X.hashCode() < A[j].hashCode()) && (j > izq)) {
                j--;
            }
            // Encuentra un elemento menor o igual a X en la parte derecha

            if (i <= j) {  // Si i es menor o igual a j, intercambia 
                aux = A[i];
                A[i] = A[j];
                A[j] = aux;
                i++;
                j--;
            } 

        } while (i <= j);

        if (izq < j) {
            quicksort(A, izq, j);
        }
        if (i < der) {
            quicksort(A, i, der);
        }
    }
}

package Ejercicio1;

public class MatrizTranspuesta {

    public static void main(String[] args) {
        int[][] matriz = {
                {1, 2, 7},
                {3, 4, 5},
                {5, 6, 6},
                {7, 8, 9}
        };

        int[][] matrizTranspuesta = calcularTranspuesta(matriz);

        // Imprimir la matriz transpuesta
        imprimirMatriz(matrizTranspuesta);
    }

    public static int[][] calcularTranspuesta(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        int[][] transpuesta = new int[columnas][filas];

        // Llenar la matriz transpuesta
        llenarTranspuesta(matriz, transpuesta, 0, 0);

        return transpuesta;
    }

    public static void llenarTranspuesta(int[][] matrizOriginal, int[][] matrizTranspuesta, int fila, int columna) {
        if (fila == matrizOriginal.length) {
            return;
        }

        if (columna == matrizOriginal[0].length) {
            // Avanzar a la siguiente fila y reiniciar la columna
            llenarTranspuesta(matrizOriginal, matrizTranspuesta, fila + 1, 0);
        } else {
            // Intercambiar fila y columna en la matriz transpuesta
            matrizTranspuesta[columna][fila] = matrizOriginal[fila][columna];
            // Avanzar a la siguiente columna
            llenarTranspuesta(matrizOriginal, matrizTranspuesta, fila, columna + 1);
        }
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int[] ints : matriz) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
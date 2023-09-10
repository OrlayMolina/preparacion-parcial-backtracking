package Ejercicio1;

public class Carcel {

    public char[][] carcel={
            {' ', 'P', 'X', ' ', 'P', 'P', ' ', 'P'},
            {' ', 'P', 'P', ' ', 'P', 'P', ' ', 'P'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'P', ' ', 'P', 'P', ' ', 'P', 'P', ' '},
            {'P', ' ', 'X', 'P', ' ', 'P', 'P', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'P', 'X', 'P', ' ', 'P', 'P', ' ', 'P'},

    };

    public static void main(String[] args) {
        Carcel m = new Carcel(); 												// construimos un objeto de la clase Laberinto por defecto
        m.carcel[1][1] = 'X'; 													// introducimos en este caso, la salida (X) en las coordenadas (1,1)
        m.resuelve(8, 1); 															// ahora, introducimos la entrada (S) en las coordenadas (8,1) y llamamos al algoritmo
        System.out.println(m.imprimirCarcel()); 								    // imprimimos el laberinto ya resuelto (si tiene solución)
    }

    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
    public void resuelve(int x, int y){ 				// permite introducir unas coordenadas (x, y)
        if (validarPreso(x, y)) { 								// intentará resolver el laberinto en estas coordenadas
            carcel[x][y] = 'S'; 						// introduce en las coordenadas (x, y) la entrada
        }
    }

    private boolean validarPreso(int x, int y) {

        if (x <= carcel.length - 1 ) {

            if(y <= carcel[0].length - 1){
                if (carcel[x][y] == 'X') { // si hemos llegado a X quiere decir que hemos encontrado solución
                    return true;
                }


                if (carcel[x][y] == '#' || carcel[x][y] == '*' || carcel[x][y] == 'f') { // si llegamos a una pared o al mismo punto,
                    return false; // entonces el laberinto no puede resolverse y termina.
                }

                carcel[x][y] = '*'; // marcamos la posición como visitada (si es la primera, en las coordenadas x e y

                boolean result; // se coloca S de START)

                result = validarPreso(x, y + 1); // DERECHA.
                if (result) return true;

                result = validarPreso(x + 1, y); // ABAJO.
                if (result) return true; /

                result = validarPreso(x - 1, y); // ARRIBA.
                if (result) return true;

                result = validarPreso(x, y - 1); // IZQUIERDA.
                if (result) return true;

                carcel[x][y] = 'f'; // en el caso de no ser el resultado, se marca con +. Ya fue pisado
                return false; // vuelta atrás si la solución no se encuentra aquí
            }else {
                return false;
            }
        }else {
            // Pendiente definir en el caso
            return false;
        }
    }

    private String imprimirCarcel() {
        String salida = "";
        for (int x=0; x<carcel.length; x++) { // recorremos filas
            for (int y=0; y<carcel[x].length; y++) { // recorremos columnas
                salida += carcel[x][y] + " ";
            }
            salida += "\n"; 
        }
        return salida;
    }

}

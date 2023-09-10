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
        if (paso(x, y)) { 								// intentará resolver el laberinto en estas coordenadas
            carcel[x][y] = 'S'; 						// introduce en las coordenadas (x, y) la entrada
        }
    }

    private boolean paso(int x, int y)
    {

        if (carcel[x][y]=='X'){ // si hemos llegado a X quiere decir que hemos encontrado solución
            return true; // luego, el algoritmo termina
        }


        if (carcel[x][y]=='#'||carcel[x][y]=='*' ||carcel[x][y]=='f') { // si llegamos a una pared o al mismo punto,
            return false; // entonces el laberinto no puede resolverse y termina.
        }

        // si no se cumple ninguna de estas dos situaciones, quiere decir que nos encontramos en un
        // caso intermedio, por lo tanto, que empezamos a recorrer o todavía no hemos llegado a nada
        carcel[x][y]='*'; // marcamos la posición como visitada (si es la primera, en las coordenadas x e y

        boolean result; // se coloca S de START)

        result=paso(x, y+1); // intentamos ir hacia la DERECHA. Primera llamada recursiva
        if (result)return true; // si el resultado es el final, entonces el algoritmo termina

        result=paso(x-1, y); // intentamos ir hacia ARRIBA. Segunda llamada recursiva
        if (result) return true; // si el resultado es el final, entonces el algoritmo termina

        result=paso(x, y-1); // intentamos ir hacia la IZQUIERDA. Tercera llamada recursiva
        if (result) return true; // si el resultado es el final, entonces el algoritmo termina

        result=paso(x+1, y); // intentamos ir hacia ABAJO. Cuarta llamada recursiva
        if (result) return true; // si el resultado es el final, entonces el algoritmo termina

        // si no hemos encontrado la solución en estos cuatros movimientos, volvemos atrás, aunque hay que
        // considerar que en este punto, todas las llamadas recursivas han finalizado. Si en ninguna de ellas
        // se ha conseguido el éxito, entonces el algoritmo termina y devuelve false.
        carcel[x][y]='f'; // en el caso de no ser el resultado, se marca con +. Ya fue pisado
        return false; // vuelta atrás si la solución no se encuentra aquí


    }

    private String imprimirCarcel() { // imprimiremos nuestra solución. Debido a que la clase Arrays no tiene implementado
        String salida = "";    // un método toString para arrays bidimensionales, lo programamos a mano
        for (int x=0; x<carcel.length; x++) { // recorremos filas
            for (int y=0; y<carcel[x].length; y++) { // recorremos columnas
                salida += carcel[x][y] + " "; // output es nuestra variable que va almacenando los valores a imprimir
            }
            salida += "\n"; // devolvemos esta variable con un salto de línea
        }
        return salida;
    }

}

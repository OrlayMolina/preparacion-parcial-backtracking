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
        final int totalPresos = 26;
        //boolean presos = validarPresos(0,0);
        //contarPresos(presos);
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

        if (x <= carcel.length - 1) { // fila
            if (y <= carcel[0].length - 1) { //columna

                if((y+1) <= carcel[0].length - 1 && carcel[x][y+1] == 'P'){ //si hay una P cuento el preso DERECHA
                    return true;
                }else {
                    if(carcel[x][y+1] == 'X' || carcel[x][y+1] == '*') {
                        return false;
                    }else {
                        carcel[x][y] = carcel[x][y+1];
                    }
                }

                if(carcel[x+1][y] == 'P'){ //si hay una P cuento el preso ABAJO
                    return true;
                }else {
                    if(carcel[x+1][y] == 'X' || carcel[x+1][y] == '*') {
                        return false;
                    }else {
                        carcel[x][y] = carcel[x+1][y];
                    }
                }

                if(carcel[x-1][y] == 'P'){ //si hay una P cuento el preso ARRIBA
                    return true;
                }else {
                    if(carcel[x-1][y] == 'X' || carcel[x-1][y] == '*') {
                        return false;
                    }else {
                        carcel[x][y] = carcel[x-1][y];
                    }
                }

                if(carcel[x][y-1] == 'P'){ //si hay una P cuento el preso IZQUIERDA
                    return true;
                }else {
                    if(carcel[x][y-1] == 'X' || carcel[x][y-1] == '*') {
                        return false;
                    }else {
                        carcel[x][y] = carcel[x][y-1];
                    }
                }

            }

        }
    }

    public int contarPresos(boolean funcion){
        return 0;
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

package Ejercicio1;

public class Carcel {

    public static char[][] carcel={
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
        int cantidadPresos = contarPresos(validarPreso(0,0));
        int presosFaltantes = totalPresos-cantidadPresos;
        Carcel m = new Carcel();
        m.carcel[0][0] = ' ';
        System.out.println(m.imprimirCarcel());
        System.out.println("La cantidad de presos en la carcel es de: "+cantidadPresos);
        System.out.println("La cantidad de presos faltantes es: "+presosFaltantes);
    }

    private static boolean validarPreso(int x, int y) {

        if (x <= carcel.length - 1 && x >= 0) { // fila
            if (y <= carcel[0].length - 1 && y >= 0) { //columna

                boolean derecha = moverDerecha(x, y);
                boolean abajo = moverAbajo(x, y);
                boolean izquierda = moverIzquierda(x, y);
                boolean arriba = moverArriba(x, y);

                if(derecha){
                    return derecha;
                }else if(abajo){
                    return abajo;
                }else if(izquierda){
                    return izquierda;
                }else if(arriba){
                    return arriba;
                }

            }

        }
        return false;
    }

    public static boolean moverDerecha(int x, int y){
        if(y < carcel[0].length){
            if(y+1 <= carcel[0].length - 1 && carcel[x][y+1] == 'P'){ //si hay una P cuento el preso DERECHA
                return true;
            }else {
                if(carcel[x][y+1] == 'X' || carcel[x][y+1] == '*') {
                    return false;
                }
            }
            carcel[x][y] = carcel[x][y+1];
        }
        return false;
    }

    public static boolean moverAbajo(int x, int y){
        if(x < carcel.length){
            if((x+1) <= carcel.length - 1 && carcel[x+1][y] == 'P'){ //si hay una P cuento el preso ABAJO
                return true;
            }else {
                if(carcel[x+1][y] == 'X' || carcel[x+1][y] == '*') {
                    return false;
                }
            }
            carcel[x][y] = carcel[x+1][y];
        }
        return false;
    }

    public static boolean moverArriba(int x, int y){
        if(x > 0){
            if((x-1) <= carcel.length - 1 && carcel[x-1][y] == 'P'){ //si hay una P cuento el preso ARRIBA
                return true;
            }else {
                if(carcel[x-1][y] == 'X' || carcel[x-1][y] == '*') {
                    return false;
                }
            }
            carcel[x][y] = carcel[x-1][y];
        }
        return false;
    }

    public static boolean moverIzquierda(int x, int y){

        if(y-1 > 0){
            if((y-1) <= carcel[0].length - 1 && carcel[x][y-1] == 'P'){ //si hay una P cuento el preso IZQUIERDA
                return true;
            }else {
                if(carcel[x][y-1] == 'X' || carcel[x][y-1] == '*') {
                    return false;
                }
            }

            carcel[x][y] = carcel[x][y-1];
        }
        return false;
    }

    public static int contarPresos(boolean funcion){
        int contador = 0;
        if(funcion == true){
            contador= contador+1;
        }
        return contador;
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

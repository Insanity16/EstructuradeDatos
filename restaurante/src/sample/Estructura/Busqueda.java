package sample.Estructura;

public class Busqueda {
    public int secuencial(String[][] array, String dato1, String dato2) {
        int indice = -1;
        for (int x = 0; x < array.length; x++) {
            if (array[x][1].equals(dato1) && array[x][2].equals(dato2)) {
                indice = x;
                return indice;

            }
        }

        return indice;

    }

    public static int[] burbuja(int[] arreglo) {
        int auxiliar;
        int[] arregloOrdenado;
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - i - 1; j++) {
                if (arreglo[j] < arreglo[j + 1]) {
                    auxiliar = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = auxiliar;
                }
            }
        }
        arregloOrdenado = arreglo;
        return arregloOrdenado;
    }

    public String[][] burbujaarray(String[][] arreglo) {
        String auxiliar;
        String auxiliar2;
        String[][] arregloOrdenado;
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - i - 1; j++) {
                if (Integer.parseInt(arreglo[j][1]) > Integer.parseInt(arreglo[j + 1][1])) {
                    auxiliar = arreglo[j][0];
                    auxiliar2 = arreglo[j][1];
                    arreglo[j][0] = arreglo[j + 1][0];
                    arreglo[j][1] = arreglo[j + 1][1];
                    arreglo[j + 1][0] = auxiliar;
                    arreglo[j + 1][1] = auxiliar2;
                }
            }
        }
        arregloOrdenado = arreglo;
        return arregloOrdenado;
    }

    public String[] alfabeto(String[] arreglo) {
        String aux;
        for (int j = 0; j < arreglo.length - 1; j++) {
            for (int i = 0; i < arreglo.length - j - 1; i++) {
                if (arreglo[i].compareTo(arreglo[i + 1]) > 0) {
                    aux = arreglo[i];
                    arreglo[i] = arreglo[i + 1];
                    arreglo[i + 1] = aux;
                }
            }
        }
        return arreglo;
    }

    public String[][] burbujaarrayalfa(String[][] arreglo) {
        String auxiliar;
        String auxiliar2;
        String[][] arregloOrdenado;
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - i - 1; j++) {
                if (arreglo[j][0].compareTo(arreglo[j + 1][0]) > 0) {
                    auxiliar = arreglo[j][0];
                    auxiliar2 = arreglo[j][1];
                    arreglo[j][0] = arreglo[j + 1][0];
                    arreglo[j][1] = arreglo[j + 1][1];
                    arreglo[j + 1][0] = auxiliar;
                    arreglo[j + 1][1] = auxiliar2;
                }
            }
        }
        arregloOrdenado = arreglo;
        return arregloOrdenado;
    }

    /*public  String Busquedabi(String[][] matriz) {

        String mayor = null;
        String pos;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                for (int x = 0; x < matriz.length; x++) {
                    for (int y = 0; y < matriz[x].length; y++) {
                        if (Integer.parseInt(matriz[i][j]) < Integer.parseInt(matriz[x][y])) {
                            mayor = (matriz[i][j]);
                            matriz[i][j] = matriz[x][y];
                            matriz[x][y] = mayor;
                        }
                    }
                }
            }
        }
        return mayor;
    */
    public int binario(int[] arreglo, int precio) {
        int izq = 0;
        int der = arreglo.length - 1;
        int centro = (izq + der) / 2;
        boolean ban = false;
        while (izq <= der && !ban) {
            centro = (izq + izq) / 2;
            if (arreglo[centro] == precio) ban = true;
        else {
                if (arreglo[centro] > precio) izq = centro + 1;
                else der = centro - 1;
            }
        }
        if (ban) return centro;
        return -1;

    }

}



package com.bolsadeideas.springboot.web.app.commos;

public class Validation {


    public static char[][] createMapa(String[] dna) {
        char[][] mapaChar = new char[dna.length][dna.length]; // Creamos el arreglo
        for (int i = 0; i < dna.length; i++) {
            //System.out.println(" Candena : " + dna[i]); // cadena a procesar
            char[] lineaLetras = dna[i].toCharArray(); // generamos array de caracteres
            // Cargamos a la matriz con los elementos que corresponda
            for (int j = 0; j < lineaLetras.length; j++) {
                //System.out.println(" Elemento de linea   : " + lineaLetras[j]);
                char lineaLetra = lineaLetras[j];
                // Guardamos el elemento en la matriz
                mapaChar[i][j] = lineaLetra;
                //System.out.println(" Elemento guardado -> " + mapaChar[i][j]);
            }
        }
        return mapaChar;
    }


    public static boolean idOblicua(char elemento, char[][] mapaChar, int fila, int columna, int limite) {
        return fila < limite && columna < limite && mapaChar[fila][columna] == elemento &&
                fila + 1 < limite && columna + 1 < limite && mapaChar[fila + 1][columna + 1] == elemento &&
                fila + 2 < limite && columna + 2 < limite && mapaChar[fila + 2][columna + 2] == elemento &&
                fila + 3 < limite && columna + 3 < limite && mapaChar[fila + 3][columna + 3] == elemento;

    }

    public static boolean isHorizontal(char elemento, char[][] mapaChar, int fila, int columna, int limite) {
        return fila < limite && columna < limite && mapaChar[fila][columna] == elemento &&
                fila < limite && columna + 1 < limite && mapaChar[fila][columna + 1] == elemento &&
                fila < limite && columna + 2 < limite && mapaChar[fila][columna + 2] == elemento &&
                fila < limite && columna + 3 < limite && mapaChar[fila][columna + 3] == elemento;
    }


    public static boolean isVertical(char elemento, char[][] mapaChar, int fila, int columna, int limite) {
        return fila < limite && columna < limite && mapaChar[fila][columna] == elemento &&
                fila + 1 < limite && columna < limite && mapaChar[fila + 1][columna] == elemento &&
                fila + 2 < limite && columna < limite && mapaChar[fila + 2][columna] == elemento &&
                fila + 3 < limite && columna < limite && mapaChar[fila + 3][columna] == elemento;
    }


    public static Boolean isMutant(String[] dna) {
        boolean isMutant = false;
        Integer cantidadSecuencias = 0; // con mas de 1 secuencia ya se determina como mutante
        char[][] mapaChar = createMapa(dna);
        int limite = mapaChar.length;
        for (int i = 0; i < mapaChar[i].length - 1 && cantidadSecuencias < 2; i++) {
            for (int j = 0; j < mapaChar[i].length; j++) {
                if (mapaChar[i][j] == 'A' || mapaChar[i][j] == 'G' || mapaChar[i][j] == 'C' || mapaChar[i][j] == 'T') {
                    //System.out.println("ELEMENTO PARA VALIDAR : " + " FILA : " + i + " COLUMNA : " + j + " DATO : " + mapaChar[i][j]);
                    if (idOblicua(mapaChar[i][j], mapaChar, i, j, limite)) {
                        //System.out.println("Es oblicua  FILA : " + i + " COLUMNA : " + j);
                        cantidadSecuencias++;
                    }
                    if (isHorizontal(mapaChar[i][j], mapaChar, i, j, limite)) {
                        //System.out.println("Es Horizontal" + " FILA : " + i + " COLUMNA : " + j);
                        cantidadSecuencias++;
                    }
                    if (isVertical(mapaChar[i][j], mapaChar, i, j, limite)) {
                        // System.out.println("Es Vertical" + " FILA : " + i + " COLUMNA : " + j);
                        cantidadSecuencias++;
                    }

                }

            }

        }
        // Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro letras
        // iguales, de forma oblicua, horizontal o vertical.
        if (cantidadSecuencias == 2) {
            isMutant = true;
        }

        return isMutant;
    }


}

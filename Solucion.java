/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Solucion;

import java.util.Arrays;
import poo.io.IO;

/**
 *
 * @author Nacho
 */
public class Solucion {

    /**
     * Este es nuestro main que contiene un menu el cual te permite comprobar
     * que dos matrices son iguales de forma recursiva e iterativa y con tiempo
     * menos y mas fiables
     *
     * @param args
     */
    public static void main(String[] args) {
        int opcion;
        boolean salir = false;
        while (!salir) {
            System.out.println("Introduce un 1 para realizar pruebas con tiempos menos fiables Recursivo\n"
                    + "Introduce un 2 para realizar pruebas con tiempos mas fiables Recursivo \n"
                    + "Introduce un 3 realizar pruebas con tiempos menos fiables Iterativo\n"
                    + "Introduce un 4 realizar pruebas con tiempos mas fiables Iterativo\n"
                    + "Introduce un 5 para salir\n");
            opcion = (int) IO.readNumber();
            if (opcion >= 1 && opcion <= 5) {
                switch (opcion) {
                    case 1:
                        RealizarPruebasRecursivo();//Llama al metodo recursivo que mostrara si son iguales o no y un tiempo poco fiable 
                        break;
                    case 2:
                        RealizarPruebasConTiempoMasFiableRecursivo();//Llama al metodo recursivo que mostrara si son iguales o no y un tiempo  fiable 
                        break;
                    case 3:
                        RealizarPruebasIterativo();//Llama al metodo iterativo que mostrara si son iguales o no y un tiempo poco fiable 
                        break;
                    case 4:
                        RealizarPruebasConTiempoMasFiableIterativo();//Llama al metodo iterativo que mostrara si son iguales o no y un tiempo  fiable 
                        break;
                    default:
                        salir = true;
                        break;
                }
            } else {
                System.out.println("Opcion incorrecta");
            }
        }
    }
    /**
     * Este metodo crea una matriz aleatoria con el numero de filas y columnas
     * indicado por teclado,inicialmente las dos matrices son iguales ya que se
     * hace una copia de la matriz aleatoria en otra,dependiendo de la opcion
     * que introduzca el ususario, las dos matrices continuaran siendo iguales
     * tendran una posicion distinta al principio,a la mitad o al final, a la
     * hora de averiguar si son iguales o no, lo hara de forma recursiva.
     */
    public static void RealizarPruebasRecursivo() {
        int fil, col, opcion;
        System.out.println("Introduce el numero de filas");
        fil = (int) IO.readNumber();
        System.out.println("Introduce el numero de columnas");
        col = (int) IO.readNumber();
        int[][] m1 = getMatrizAleatoria(fil, col);
        int[][] m2 = new int[m1.length][m1[0].length];

        for (int i = 0; i < m2.length; i++) {
            System.arraycopy(m1[i], 0, m2[i], 0, m2[i].length);
        }
        System.out.println("Introduce 1 para comparar dos matrices iguales \n"
                + "Introduce un 2 para que la posicion distinta este al principio \n"
                + "Introduce un 3 para que la posicion distinta este a la mitad \n"
                + "Introduce un 4 para que la posicion distinta este al final");
        opcion = (int) IO.readNumber();
        if (opcion >= 1 && opcion <= 4) {
            switch (opcion) {
                case 1:
                    TiempoMenosFiableRecursivo(m1, m2);//Las matrices son iguales
                    break;
                case 2:
                    m2[0][0] = -1;//Posicion distinta al principio
                    TiempoMenosFiableRecursivo(m1, m2);
                    break;
                case 3:
                    m2[m2.length / 2][m2[0].length / 2] = -1;//Posicion distinta a la mitad 
                    TiempoMenosFiableRecursivo(m1, m2);
                    break;
                default:
                    m2[m2.length - 1][m2[0].length - 1] = -1;//posicion distinta al final
                    TiempoMenosFiableRecursivo(m1, m2);
                    break;
            }
        } else {
            System.out.println("Opcion incorrecta");
        }

    }

    /**
     * Metodo al que llama RealizarPruebasRecursivo() y se encarga de mostrar si
     * son iguales y tiempo poco fiable
     *
     * @param m1
     * @param m2
     */
    private static void TiempoMenosFiableRecursivo(int m1[][], int m2[][]) {
        long sumatorioTiemposRecursivo, inicioRecursivo, finRecursivo;
        boolean res;
        inicioRecursivo = System.nanoTime();
        res = sonMatricesIguales(m1, m2, m1.length - 1);//metodo recursivo que nos indica si son iguales o no 
        finRecursivo = System.nanoTime();
        sumatorioTiemposRecursivo = finRecursivo - inicioRecursivo;
        if (res) {
            System.out.println("Son iguales");
        } else {
            System.out.println("Son distintas");
        }
        System.out.println("Tiempo de ejecucion: " + sumatorioTiemposRecursivo);
    }

    /**
     * Este metodo crea una matriz aleatoria con el numero de filas y columnas
     * indicado por teclado,inicialmente las dos matrices son iguales ya que se
     * hace una copia de la matriz aleatoria en otra,dependiendo de la opcion
     * que introduzca el ususario, las dos matrices continuaran siendo iguales
     * tendran una posicion distinta al principio,a la mitad o al final, a la
     * hora de averiguar si son iguales o no, lo hara de forma iterativa.
     */
    public static void RealizarPruebasIterativo() {
        int fil, col, opcion;
        System.out.println("Introduce el numero de filas");
        fil = (int) IO.readNumber();
        System.out.println("Introduce el numero de columnas");
        col = (int) IO.readNumber();
        int[][] m1 = getMatrizAleatoria(fil, col);
        int[][] m2 = new int[m1.length][m1[0].length];

        for (int i = 0; i < m2.length; i++) {
            System.arraycopy(m1[i], 0, m2[i], 0, m2[i].length);
        }
        System.out.println("Introduce 1 para comparar dos matrices iguales \n"
                + "Introduce un 2 para que la posicion distinta este al principio \n"
                + "Introduce un 3 para que la posicion distinta este a la mitad \n"
                + "Introduce un 4 para que la posicion distinta este al final");
        opcion = (int) IO.readNumber();
        if (opcion >= 1 && opcion <= 4) {
            switch (opcion) {
                case 1:
                    TiempoIterativo(m1, m2);//Las matrices son iguales
                    break;
                case 2:
                    m2[0][0] = -1;//Posicion distinta al principio
                    TiempoIterativo(m1, m2);
                    break;
                case 3:
                    m2[m2.length / 2][m2[0].length / 2] = -1;//Posicion distinta a la mitad 
                    TiempoIterativo(m1, m2);
                    break;
                default:
                    m2[m2.length - 1][m2[0].length - 1] = -1;//posicion distinta al final
                    TiempoIterativo(m1, m2);
                    break;
            }
        } else {
            System.out.println("Opcion incorrecta");
        }

    }

    /**
     * Metodo al que llama RealizarPruebasIterativo() y se encarga de mostrar si
     * son iguales y tiempo poco fiable
     *
     * @param m1
     * @param m2
     */
    private static void TiempoIterativo(int[][] m1, int[][] m2) {
        long inicioIterativo = System.nanoTime();
        boolean res = sonIgualesIterativo(m1, m2);//metodo recursivo que nos indica si son iguales o no  de forma iterativo
        long finIterativo = System.nanoTime();
        long sumatorioTiemposIterativo = finIterativo - inicioIterativo;
        if (res) {
            System.out.println("Son iguales");
        } else {
            System.out.println("Son distintas");
        }
        System.out.println("Tiempo de ejecucion: " + sumatorioTiemposIterativo);
        System.out.println("\n\n");
    }

    /**
     * Este metodo crea una matriz aleatoria con el numero de filas y columnas
     * indicado por teclado,inicialmente las dos matrices son iguales ya que se
     * hace una copia de la matriz aleatoria en otra,dependiendo de la opcion
     * que introduzca el ususario, las dos matrices continuaran siendo iguales
     * tendran una posicion distinta al principio,a la mitad o al final, a la
     * hora de averiguar si son iguales o no, lo hara de forma recursiva, y nos
     * mostrara un tiempo mas fiable
     */
    public static void RealizarPruebasConTiempoMasFiableRecursivo() {
        int fil, col, opcion;
        System.out.println("Introduce el numero de filas");
        fil = (int) IO.readNumber();
        System.out.println("Introduce el numero de columnas");
        col = (int) IO.readNumber();
        int[][] m1 = getMatrizAleatoria(fil, col);
        int[][] m2 = new int[m1.length][m1[0].length];

        for (int i = 0; i < m2.length; i++) {
            System.arraycopy(m1[i], 0, m2[i], 0, m2[i].length);
        }
        System.out.println("Introduce 1 para comparar dos matrices iguales \n"
                + "Introduce un 2 para que la posicion distinta este al principio \n"
                + "Introduce un 3 para que la posicion distinta este a la mitad \n"
                + "Introduce un 4 para que la posicion distinta este al final\n");
        opcion = (int) IO.readNumber();
        if (opcion >= 1 && opcion <= 4) {
            switch (opcion) {
                case 1: {
                    TiempoMasFiableRecursivo(m1, m2);//matrices iguales
                    break;
                }
                case 2: {
                    m2[0][0] = -1;//posicion distinta al principio
                    TiempoMasFiableRecursivo(m1, m2);
                    break;
                }
                case 3: {
                    m1[m1.length / 2][m1.length / 2] = -1;//posicion distinta a la mitad
                    TiempoMasFiableRecursivo(m1, m2);
                    break;
                }
                default: {
                    m2[m2.length - 1][m2[0].length - 1] = -1;//posicion distinta al final 
                    TiempoMasFiableRecursivo(m1, m2);
                    break;
                }
            }
        } else {
            System.out.println("Opcion incorrecta");
        }
    }

    /**
     * Este metodo es el que llama RealizarPruebasConTiempoMasFiableRecursivo()
     * y se encarga de mostrar si son iguales las matrices y de mostrar un
     * tiempo mas fiable ya que hace una media de los tiempos
     *
     * @param m1
     * @param m2
     */
    private static void TiempoMasFiableRecursivo(int m1[][], int m2[][]) {
        long sumatorioTiemposRecursivo, inicioRecursivo, finRecursivo;
        int num = 100;
        boolean res = false;
        long suma = 0;
        for (int i = 0; i < num; i++) {
            inicioRecursivo = System.nanoTime();
            res = sonMatricesIguales(m1, m2, m1.length - 1);//metodo recursivo que nos indica si son iguales o no 
            finRecursivo = System.nanoTime();
            sumatorioTiemposRecursivo = finRecursivo - inicioRecursivo;
            suma += sumatorioTiemposRecursivo;
        }
        if (res) {
            System.out.println("Son iguales");
        } else {
            System.out.println("Son distintas");
        }
        suma = suma / num;
        System.out.println("Tiempo de ejecucion (con mayor fiabilidad): " + suma);

    }

    /**
     * Este metodo crea una matriz aleatoria con el numero de filas y columnas
     * indicado por teclado,inicialmente las dos matrices son iguales ya que se
     * hace una copia de la matriz aleatoria en otra,dependiendo de la opcion
     * que introduzca el ususario, las dos matrices continuaran siendo iguales
     * tendran una posicion distinta al principio,a la mitad o al final, a la
     * hora de averiguar si son iguales o no, lo hara de forma iterativa, y nos
     * mostrara un tiempo mas fiable
     */
    public static void RealizarPruebasConTiempoMasFiableIterativo() {
        int fil, col, opcion;
        System.out.println("Introduce el numero de filas");
        fil = (int) IO.readNumber();
        System.out.println("Introduce el numero de columnas");
        col = (int) IO.readNumber();
        int[][] m1 = getMatrizAleatoria(fil, col);
        int[][] m2 = new int[m1.length][m1[0].length];

        for (int i = 0; i < m2.length; i++) {
            System.arraycopy(m1[i], 0, m2[i], 0, m2[i].length);
        }
        System.out.println("Introduce 1 para comparar dos matrices iguales \n"
                + "Introduce un 2 para que la posicion distinta este al principio \n"
                + "Introduce un 3 para que la posicion distinta este a la mitad \n"
                + "Introduce un 4 para que la posicion distinta este al final\n");
        opcion = (int) IO.readNumber();
        if (opcion >= 1 && opcion <= 4) {
            switch (opcion) {
                case 1: {
                    TiempoIterativoMasFiable(m1, m2);//Matrices iguales
                    break;
                }
                case 2: {
                    m2[0][0] = -1;//Posicion distinta al principio
                    TiempoIterativoMasFiable(m1, m2);
                    break;
                }
                case 3: {
                    m1[m1.length / 2][m1.length / 2] = -1;//Posicion distinta el mitad
                    TiempoIterativoMasFiable(m1, m2);
                    break;
                }
                default: {
                    m2[m2.length - 1][m2[0].length - 1] = -1;//Posicion disinta al final
                    TiempoIterativoMasFiable(m1, m2);
                    break;
                }
            }
        } else {
            System.out.println("Opcion incorrecta");
        }
    }

    /**
     * Este metodo es el que llama RealizarPruebasConTiempoMasFiableIterativo()
     * y se encarga de mostrar si son iguales las matrices y de mostrar un
     * tiempo mas fiable ya que hace una media de los tiempos
     *
     * @param m1
     * @param m2
     */
    private static void TiempoIterativoMasFiable(int[][] m1, int[][] m2) {
        long suma = 0;
        int num = 100;
        boolean res = false;
        for (int i = 0; i < num; i++) {
            long inicioRecursivo = System.nanoTime();
            res = sonIgualesIterativo(m1, m2);
            long finRecursivo = System.nanoTime();
            long sumatorioTiemposRecursivo = finRecursivo - inicioRecursivo;
            suma += sumatorioTiemposRecursivo;
        }
        if (res) {
            System.out.println("Son iguales");
        } else {
            System.out.println("Son distintas");
        }
        suma = suma / num;
        System.out.println("Tiempo de ejecucion (con mayor fiabilidad): " + suma);
    }

    private static boolean sonMatricesIguales(int[][] matriz1, int[][] matriz2, int fila) {
        if (matriz1.length == matriz2.length && matriz1[0].length == matriz2[0].length) {   //Primero comprobamos que tanto las filas como las columnas tengan el mismo tamanyo
            boolean iguales = true;                                                         //Variable booleana para ir controlando que las matrices sean iguales
            if (fila > -1) {                                                                //Seria la logica contraria al caso base. Mientras que la fila sea mayor que 0 vamos a ir decrementando
                //Esto saldra cuando la funcion se llame a si misma tantas veces hasta llegar a -1, que seria nuestro caso base. 
                //Esto es debido a que para el valor fila = 0, tambien queremos realizar la comprobacion de igualdad
                iguales = sonMatricesIguales(matriz1, matriz2, fila - 1);                   //Empleamos la llamada recursiva, y decrementamos nuestra fila tal y como se clarifica en el enunciado
                if (iguales) {                                                              //Esta condicion, la ponemos para evitar pasos extra (asignacion booleana a iguales) cuando hayamos descubierto que las matrices son distintas
                    iguales = sonIguales(matriz1[fila], matriz2[fila]);                     //Llamamos a la funcion son iguales, a la que le vamos pasando los vectores correspondientes a las filas de las matrices                                                                       
                }                                                                               //Le asignamos el valor que devuelva sonIguales a iguales, para conocer la igualdad entre filas
            }
            return iguales;                                                                 //Devuelve iguales en cada llamada. La primera vez que devulve es cuando cumple el caso base (fila == -1)
        } else {
            return false;                                                                   //Devolvera false si las filas o columnas no tienen el mismo tamanyo, ya que no seran iguales las matrices
        }

    }

    private static boolean sonIguales(int[] vector1, int[] vector2) {                        //Como ya hemos comentado, esta es la funcion que nos permitira conocer la igualdad entre las filas de las matrices
        boolean iguales = true;                                                             //Variable booleana para controlar que los elementos sean o no iguales
        if (vector1.length > 0) {                                                           //Misma estrucutura que el anterior metodo. Esta vez, nuestro caso base sera que el tamanyo de los vectores sea 0, ya que un vector de tamanyo 0 no contiene nada
            iguales = sonIguales(Arrays.copyOfRange(vector1, 0, vector1.length - 1), Arrays.copyOfRange(vector2, 0, vector2.length - 1));
            //En la anterior linea, estamos llevando a cabo la llamada recursiva. En cada llamada estamos pasando los vectores con el tamanyo decrementado en 1 gracias a la funcion copyOfRange
            if (vector1[vector1.length - 1] != vector2[vector2.length - 1] && iguales) {    //Gracias a que copyOfRange nos permite subdividir vectores, podemos ir recorriendo posicion por posicion del vector sin necesidad de un iterador 
                //Esto sera gracias a que estamos comparando siempre la ultima posicion del vector que vamos acortado
                iguales = false;                                                            //Si las posiciones (igual a igual) son distintas entonces ya no seran iguales los vectores, ergo no seran iguales las matrices     
            }
        }
        return iguales;                                                                     //Devuelve iguales en cada llamada. La primera vez que devulve es cuando cumple el caso base (vector1.length == 0)

    }

    private static int[][] getMatrizAleatoria(int fil, int col) {
        int[][] m = new int[fil][col];
        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++) {
                int numAleatorio = (int) (Math.random() * 99) + 1;
                m[i][j] = numAleatorio;
            }
        }
        return m;
    }

    private static boolean sonIgualesIterativo(int[][] m1, int[][] m2) {
        boolean iguales = true;
        int i = m1.length - 1;
        while (i >= 0 && iguales) {
            int j = m1[i].length - 1;
            while (j >= 0 && iguales) {
                if (m1[i][j] != m2[i][j]) {
                    iguales = false;
                } else {
                    j--;
                }
            }
            i--;
        }
        return iguales;
    }

}

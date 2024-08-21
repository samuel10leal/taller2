package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;


import java.util.Arrays;

public class SandboxArreglos {
    private int[] arregloEnteros;
    private String[] arregloCadenas;

    public SandboxArreglos() {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    public int[] getCopiaEnteros() {
        return Arrays.copyOf(arregloEnteros, arregloEnteros.length);
    }

    public String[] getCopiaCadenas() {
        return Arrays.copyOf(arregloCadenas, arregloCadenas.length);
    }

    public int getCantidadEnteros() {
        return arregloEnteros.length;
    }

    public int getCantidadCadenas() {
        return arregloCadenas.length;
    }

    public void agregarEntero(int entero) {
        arregloEnteros = Arrays.copyOf(arregloEnteros, arregloEnteros.length + 1);
        arregloEnteros[arregloEnteros.length - 1] = entero;
    }

    public void agregarCadena(String cadena) {
        arregloCadenas = Arrays.copyOf(arregloCadenas, arregloCadenas.length + 1);
        arregloCadenas[arregloCadenas.length - 1] = cadena;
    }

    public void eliminarEntero(int valor) {
        int[] nuevoArreglo = Arrays.stream(arregloEnteros).filter(num -> num != valor).toArray();
        arregloEnteros = nuevoArreglo;
    }

    public void eliminarCadena(String cadena) {
        String[] nuevoArreglo = Arrays.stream(arregloCadenas)
                                      .filter(str -> !str.equalsIgnoreCase(cadena))
                                      .toArray(String[]::new);
        arregloCadenas = nuevoArreglo;
    }

    public void insertarEntero(int entero, int posicion) {
        if (posicion < 0) {
            posicion = 0;
        } else if (posicion > arregloEnteros.length) {
            posicion = arregloEnteros.length;
        }

        int[] nuevoArreglo = new int[arregloEnteros.length + 1];
        System.arraycopy(arregloEnteros, 0, nuevoArreglo, 0, posicion);
        nuevoArreglo[posicion] = entero;
        System.arraycopy(arregloEnteros, posicion, nuevoArreglo, posicion + 1, arregloEnteros.length - posicion);
        arregloEnteros = nuevoArreglo;
    }

    public void eliminarEnteroPorPosicion(int posicion) {
        if (posicion >= 0 && posicion < arregloEnteros.length) {
            int[] nuevoArreglo = new int[arregloEnteros.length - 1];
            System.arraycopy(arregloEnteros, 0, nuevoArreglo, 0, posicion);
            System.arraycopy(arregloEnteros, posicion + 1, nuevoArreglo, posicion, arregloEnteros.length - posicion - 1);
            arregloEnteros = nuevoArreglo;
        }
    }

    public void reiniciarArregloEnteros(double[] valores) {
        arregloEnteros = Arrays.stream(valores).mapToInt(val -> (int) val).toArray();
    }

    public void reiniciarArregloCadenas(Object[] objetos) {
        arregloCadenas = Arrays.stream(objetos).map(Object::toString).toArray(String[]::new);
    }

    public void volverPositivos() {
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] < 0) {
                arregloEnteros[i] = -arregloEnteros[i];
            }
        }
    }

    public void organizarEnteros() {
        Arrays.sort(arregloEnteros);
    }

    public void organizarCadenas() {
        Arrays.sort(arregloCadenas, String.CASE_INSENSITIVE_ORDER);
    }

    public int contarApariciones(int valor) {
        return (int) Arrays.stream(arregloEnteros).filter(num -> num == valor).count();
    }

    public int contarApariciones(String cadena) {
        return (int) Arrays.stream(arregloCadenas).filter(str -> str.equalsIgnoreCase(cadena)).count();
    }

    public int[] buscarEntero(int valor) {
        // Lista para almacenar las posiciones encontradas
        int[] posiciones = new int[arregloEnteros.length];
        int count = 0;

        // Iterar sobre el arreglo para encontrar el valor
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] == valor) {
                posiciones[count++] = i; // Guardar la posición
            }
        }

        // Recortar el arreglo de posiciones para que tenga solo los índices encontrados
        return Arrays.copyOf(posiciones, count);
    }

    public int[] calcularRangoEnteros() {
        if (arregloEnteros.length == 0) {
            return new int[]{};
        }

        int min = Arrays.stream(arregloEnteros).min().orElse(0);
        int max = Arrays.stream(arregloEnteros).max().orElse(0);

        return new int[]{min, max};
    }

    public HashMap<Integer, Integer> calcularHistograma() {
        HashMap<Integer, Integer> histograma = new HashMap<>();

        for (int num : arregloEnteros) {
            histograma.put(num, histograma.getOrDefault(num, 0) + 1);
        }

        return histograma;
    }

    public int contarEnterosRepetidos() {
        HashMap<Integer, Integer> contador = new HashMap<>();

        for (int num : arregloEnteros) {
            contador.put(num, contador.getOrDefault(num, 0) + 1);
        }

        int repetidos = 0;
        for (int count : contador.values()) {
            if (count > 1) {
                repetidos++;
            }
        }

        return repetidos;
    }

    public boolean compararArregloEnteros(int[] otroArreglo) {
        return Arrays.equals(arregloEnteros, otroArreglo);
    }

    public boolean mismosEnteros(int[] otroArreglo) {
        int[] copiaArregloOriginal = Arrays.copyOf(arregloEnteros, arregloEnteros.length);
        int[] copiaOtroArreglo = Arrays.copyOf(otroArreglo, otroArreglo.length);

        Arrays.sort(copiaArregloOriginal);
        Arrays.sort(copiaOtroArreglo);

        return Arrays.equals(copiaArregloOriginal, copiaOtroArreglo);
    }

    public void generarEnteros(int cantidad, int minimo, int maximo) {
        arregloEnteros = new int[cantidad];

        for (int i = 0; i < cantidad; i++) {
            arregloEnteros[i] = (int) (Math.random() * (maximo - minimo + 1)) + minimo;
        }
    }
}
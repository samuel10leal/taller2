package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre listas de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos listaEnteros y listaCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre listas (ie., no haga cosas como construir arreglos para evitar la manipulación de listas).
 * 
 * Intente usar varias formas de recorrer las listas (while, for, for each, iteradores ... )
 */
public class SandboxListas
{
    /**
     * Una lista de enteros para realizar varias de las siguientes operaciones.
     */
    private ArrayList<Integer> listaEnteros;

    /**
     * Una lista de cadenas para realizar varias de las siguientes operaciones
     */
    private LinkedList<String> listaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxListas( )
    {
        listaEnteros = new ArrayList<>();
        listaCadenas = new LinkedList<>();
    }

    /**
     * Retorna una copia de la lista de enteros
     * @return Una copia de la lista de enteros
     */
    public ArrayList<Integer> getCopiaEnteros( )
    {
        return new ArrayList<>(listaEnteros);
    }

    /**
     * Retorna una copia de la lista de cadenas
     * @return Una copia de la lista de cadenas
     */
    public LinkedList<String> getCopiaCadenas( )
    {
        return new LinkedList<>(listaCadenas);
    }

    /**
     * Retorna un arreglo con los valores de la lista de enteros
     * @return Un arreglo de enteros
     */
    public int[] getEnterosComoArreglo( )
    {
        int[] arreglo = new int[listaEnteros.size()];
        for (int i = 0; i < listaEnteros.size(); i++) {
            arreglo[i] = listaEnteros.get(i);
        }
        return arreglo;
    }

    /**
     * Retorna la cantidad de valores en la lista de enteros
     * @return La cantidad de valores en la lista de enteros
     */
    public int getCantidadEnteros( )
    {
        return listaEnteros.size();
    }

    /**
     * Retorna la cantidad de valores en la lista de cadenas
     * @return La cantidad de valores en la lista de cadenas
     */
    public int getCantidadCadenas( )
    {
        return listaCadenas.size();
    }

    /**
     * Agrega un nuevo valor al final de la lista de enteros
     * @param entero El valor que se va a agregar
     */
    public void agregarEntero( int entero )
    {
        listaEnteros.add(entero);
    }

    /**
     * Agrega un nuevo valor al final de la lista de cadenas
     * @param cadena La cadena que se va a agregar
     */
    public void agregarCadena( String cadena )
    {
        listaCadenas.add(cadena);
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro de la lista de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
        listaEnteros.removeIf(e -> e == valor);
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro de la lista de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
        listaCadenas.removeIf(e -> e.equals(cadena));
    }

    /**
     * Inserta un nuevo entero en la lista de enteros en la posición especificada
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor
     */
    public void insertarEntero( int entero, int posicion )
    {
        if (posicion < 0) {
            listaEnteros.add(0, entero);
        } else if (posicion >= listaEnteros.size()) {
            listaEnteros.add(entero);
        } else {
            listaEnteros.add(posicion, entero);
        }
    }

    /**
     * Elimina un valor de la lista de enteros dado su posición
     * @param posicion La posición del elemento a eliminar
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
        if (posicion >= 0 && posicion < listaEnteros.size()) {
            listaEnteros.remove(posicion);
        }
    }

    /**
     * Reinicia la lista de enteros con los valores truncados de un arreglo de valores decimales
     * @param valores Un arreglo de valores decimales
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
        listaEnteros.clear();
        for (double valor : valores) {
            listaEnteros.add((int) valor);
        }
    }

    /**
     * Reinicia la lista de cadenas con las representaciones como Strings de los objetos en una lista
     * @param objetos Una lista de objetos
     */
    public void reiniciarArregloCadenas( List<Object> objetos )
    {
        listaCadenas.clear();
        for (Object obj : objetos) {
            listaCadenas.add(obj.toString());
        }
    }

    /**
     * Modifica la lista de enteros para que todos los valores sean positivos
     */
    public void volverPositivos( )
    {
        for (int i = 0; i < listaEnteros.size(); i++) {
            listaEnteros.set(i, Math.abs(listaEnteros.get(i)));
        }
    }

    /**
     * Modifica la lista de enteros para que todos los valores estén ordenados de mayor a menor
     */
    public void organizarEnteros( )
    {
        listaEnteros.sort((a, b) -> b - a);
    }

    /**
     * Modifica la lista de cadenas para que todos los valores estén ordenados lexicográficamente
     */
    public void organizarCadenas( )
    {
        listaCadenas.sort(String::compareTo);
    }

    /**
     * Cuenta cuántas veces aparece un valor en la lista de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
        int count = 0;
        for (int num : listaEnteros) {
            if (num == valor) {
                count++;
            }
        }
        return count;
    }

    /**
     * Cuenta cuántas veces aparece una cadena en la lista de cadenas
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
        int count = 0;
        String cadenaMinusculas = cadena.toLowerCase(); // Convertimos la cadena de búsqueda a minúsculas
        for (String str : listaCadenas) {
            if (str.equalsIgnoreCase(cadenaMinusculas)) { // Comparamos ignorando mayúsculas y minúsculas
                count++;
            }
        }
        return count;
    }

    /**
     * Cuenta cuántos valores dentro de la lista de enteros están repetidos
     * @return La cantidad de enteros diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
        ArrayList<Integer> contados = new ArrayList<>();
        ArrayList<Integer> repetidos = new ArrayList<>();
        for (int num : listaEnteros) {
            if (contados.contains(num) && !repetidos.contains(num)) {
                repetidos.add(num);
            } else {
                contados.add(num);
            }
        }
        return repetidos.size();
    }

    /**
     * Compara la lista de enteros con un arreglo de enteros y verifica si contienen los mismos elementos exactamente en el mismo orden
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos son los mismos y en el mismo orden, false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
        if (otroArreglo.length != listaEnteros.size()) {
            return false;
        }
        for (int i = 0; i < otroArreglo.length; i++) {
            if (otroArreglo[i] != listaEnteros.get(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Cambia los elementos de la lista de enteros por una nueva serie de valores generada de forma aleatoria
     * @param cantidad La cantidad de elementos que debe haber en la lista
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
        listaEnteros.clear();
        for (int i = 0; i < cantidad; i++) {
            int valor = minimo + (int)(Math.random() * (maximo - minimo + 1));
            listaEnteros.add(valor);
        }
    }
}

package uniandes.dpoo.estructuras.logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con el mapa inicializado vacío
     */
    public SandboxMapas()
    {
        mapaCadenas = new HashMap<>();
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista()
    {
        List<String> valores = new ArrayList<>(mapaCadenas.values());
        valores.sort(String::compareTo);
        return valores;
    }

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida()
    {
        List<String> llaves = new ArrayList<>(mapaCadenas.keySet());
        llaves.sort((s1, s2) -> s2.compareTo(s1));
        return llaves;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa.
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera()
    {
        if (mapaCadenas.isEmpty()) {
            return null;
        }
        String primera = null;
        for (String llave : mapaCadenas.keySet()) {
            if (primera == null || llave.compareTo(primera) < 0) {
                primera = llave;
            }
        }
        return primera;
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima()
    {
        if (mapaCadenas.isEmpty()) {
            return null;
        }
        String ultima = null;
        for (String valor : mapaCadenas.values()) {
            if (ultima == null || valor.compareTo(ultima) > 0) {
                ultima = valor;
            }
        }
        return ultima;
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una colección de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves()
    {
        Collection<String> llavesMayusculas = new ArrayList<>();
        for (String llave : mapaCadenas.keySet()) {
            llavesMayusculas.add(llave.toUpperCase());
        }
        return llavesMayusculas;
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes()
    {
        List<String> valores = new ArrayList<>(mapaCadenas.values());
        List<String> valoresUnicos = new ArrayList<>();
        for (String valor : valores) {
            if (!valoresUnicos.contains(valor)) {
                valoresUnicos.add(valor);
            }
        }
        return valoresUnicos.size();
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena(String cadena)
    {
        String llave = new StringBuilder(cadena).reverse().toString();
        mapaCadenas.put(llave, cadena);
    }

    /**
     * Elimina una cadena del mapa, dada la llave
     * @param llave La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave(String llave)
    {
        mapaCadenas.remove(llave);
    }

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param valor El valor que se debe eliminar
     */
    public void eliminarCadenaConValor(String valor)
    {
        List<String> llavesAEliminar = new ArrayList<>();
        for (Map.Entry<String, String> entry : mapaCadenas.entrySet()) {
            if (entry.getValue().equals(valor)) {
                llavesAEliminar.add(entry.getKey());
            }
        }
        for (String llave : llavesAEliminar) {
            mapaCadenas.remove(llave);
        }
    }

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param objetos Una lista de objetos
     */
    public void reiniciarMapaCadenas(List<Object> objetos)
    {
        mapaCadenas.clear();
        for (Object objeto : objetos)
        {
            String cadena = objeto.toString();
            mapaCadenas.put(new StringBuilder(cadena).reverse().toString(), cadena);
        }
    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas()
    {
        Map<String, String> nuevoMapa = new HashMap<>();
        for (Map.Entry<String, String> entry : mapaCadenas.entrySet())
        {
            nuevoMapa.put(entry.getKey().toUpperCase(), entry.getValue());
        }
        mapaCadenas = nuevoMapa;
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
     * @param otroArreglo El arreglo de cadenas con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores(String[] otroArreglo)
    {
        List<String> valoresMapa = new ArrayList<>(mapaCadenas.values());
        for (String cadena : otroArreglo)
        {
            if (!valoresMapa.contains(cadena))
            {
                return false;
            }
        }
        return true;
    }
}
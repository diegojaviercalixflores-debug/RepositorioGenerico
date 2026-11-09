/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//Nuevo

package repositorio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author Diego Calix
 */
public class RepositorioGenerico<T> {

    private List<T> listaElementos = new ArrayList();
    private Map<String, T> mapaElementos = new HashMap<>();
    private Stack<T> historialOperaciones = new Stack<>();

    public void agregar(String clave, T elemento) {
        listaElementos.add(elemento);
        mapaElementos.put(clave, elemento);
        historialOperaciones.push(elemento);
    }

    public List<T> obtenerTodos() {
        return Collections.unmodifiableList(listaElementos);
    }

    public T buscarPorClave(String clave) {
        return mapaElementos.get(clave);
    }

    public T deshacerUltimo() {
        if (!historialOperaciones.isEmpty()) {
            T ultimo = historialOperaciones.pop();
            listaElementos.remove(ultimo);
            return ultimo;
        }
        return null;
    }
}

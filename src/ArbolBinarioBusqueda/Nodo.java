/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolBinarioBusqueda;

/**
 *
 * @author Maquina
 */
public class Nodo {

    int valor;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(int _valor) {
        this.valor = _valor;
        this.izquierdo = null;
        this.derecho = null;
    }

}

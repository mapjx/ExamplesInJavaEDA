/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abb;

/**
 *
 * @author Maquina
 */
public class Nodo {

    int dato;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(int _dato) {
        this.dato = _dato;
        this.izquierdo = null;
        this.derecho = null;
    }
}

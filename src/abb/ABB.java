/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abb;

import java.util.Scanner;

/**
 *
 * @author Maquina
 */
public class ABB {

    Nodo raiz;
    Scanner teclado = new Scanner(System.in);

    public ABB() {
        this.raiz = null;
    }

    public Nodo addNodo(Nodo _raiz, int _dato) {
        if (_raiz == null) {
            Nodo nuevo = new Nodo(_dato);
            return nuevo;
        } else {
            if (_dato > _raiz.dato) {
                _raiz.derecho = addNodo(_raiz.derecho, _dato);
            } else {
                _raiz.izquierdo = addNodo(_raiz.izquierdo, _dato);
            }
        }
        return _raiz;
    }

    public void InOrden(Nodo _raiz) {
        if (_raiz != null) {
            InOrden(_raiz.izquierdo);
            System.out.print(_raiz.dato + " ");
            InOrden(_raiz.derecho);

        }
    }

    public void preOrden(Nodo _raiz) {
        if (_raiz != null) {
            System.out.print(_raiz.dato + " ");
            preOrden(_raiz.izquierdo);
            preOrden(_raiz.derecho);

        }
    }

    public void posOrden(Nodo _raiz) {
        if (_raiz != null) {
            InOrden(_raiz.izquierdo);
            InOrden(_raiz.derecho);
            System.out.print(_raiz.dato + " ");
        }
    }

    public static void main(String[] args) {
        int _dato, op;

        ABB metodos = new ABB();
        do {
            System.out.println("Insertar [1] ");
            System.out.println("Recorrer [2] ");
            System.out.println("salir [0] ");
            op = metodos.teclado.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Ingrese numero: ");
                    _dato = metodos.teclado.nextInt();
                    metodos.raiz = metodos.addNodo(metodos.raiz, _dato);
                    break;
                case 2:
                    metodos.preOrden(metodos.raiz);
                    System.out.print("\n");
                    metodos.InOrden(metodos.raiz);
                    System.out.print("\n");
                    metodos.posOrden(metodos.raiz);
                    System.out.print("\n");
                    break;
                default:
                    System.out.println("Opcion Incorrecta...");
                    break;
            }
        } while (op != 0);

    }

}

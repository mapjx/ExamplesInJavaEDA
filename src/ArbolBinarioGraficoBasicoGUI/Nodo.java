/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolBinarioGraficoBasicoGUI;

/**
 *
 * @author Maximo Paute
 */
public class Nodo {

    public int dato;
    public Nodo izq;
    public Nodo der;

    public Nodo(int valor) {
        this.dato = valor;
        this.izq = null;
        this.der = null;
    }

    public Nodo insertarNodo(Nodo raiz, int n) {
        if (raiz == null) {
            return new Nodo(n);
        } else if (n <= raiz.dato) {
            raiz.izq = insertarNodo(raiz.izq, n);
        } else {
            raiz.der = insertarNodo(raiz.der, n);
        }
        return raiz;
    }

    public int completos(Nodo aux) {
        if (aux == null) {
            return 0;
        } else {
            if (aux.izq != null && aux.der != null) {
                return completos(aux.izq) + completos(aux.der) + 1;
            }
            return completos(aux.izq) + completos(aux.der);
        }
    }

}

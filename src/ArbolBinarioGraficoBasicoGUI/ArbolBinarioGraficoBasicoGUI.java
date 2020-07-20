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
public class ArbolBinarioGraficoBasicoGUI {

    private Nodo raiz;

    public void insertar(int n) {
        if (raiz == null) {
            raiz = new Nodo(n);
        } else {
            raiz = raiz.insertarNodo(raiz, n);
        }
    }

    public Nodo getRaiz() {
        return raiz;
    }

}

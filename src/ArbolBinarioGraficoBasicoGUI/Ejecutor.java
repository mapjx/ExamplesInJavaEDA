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
public class Ejecutor {

    private Interfaz intf;
    private ArbolBinarioGraficoBasicoGUI arbol;

    public Ejecutor(Interfaz intf, ArbolBinarioGraficoBasicoGUI arbol) {
        this.intf = intf;
        this.arbol = arbol;
    }

    public void inicio() {
        intf.setArbol(arbol);
    }

}

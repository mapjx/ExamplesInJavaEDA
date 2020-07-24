/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAVLGUI;

/**
 *
 * @author Lenin Sanchez
 */
public class Nodo {
    
     int dato;
     int factor; 
     Nodo izq, der, padre;

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public Nodo(int dato) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
         
    }
    
    public Nodo(int dato, Nodo izq, Nodo der) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    } 

}

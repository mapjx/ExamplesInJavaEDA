/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolBinarioBusqueda;

import java.util.Scanner;

/**
 *
 * @author Maquina
 */
public class ArbolBinarioBusqueda {

    Nodo raiz;

    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }

    public void Insertar(int _valor) {
        Nodo nuevo = new Nodo(_valor);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            Nodo padre = null;
            Nodo actual = raiz;
            while (actual != null) {
                padre = actual;
                if (actual.valor > _valor) {
                    actual = actual.izquierdo;
                } else {
                    actual = actual.derecho;
                }
            }
            if (padre.valor > _valor) {
                padre.izquierdo = nuevo;
            } else {
                padre.derecho = nuevo;
            }
        }
    }

    public void Preorden(Nodo actual) {
        if (actual != null) {
            System.out.println(actual.valor + " ");
            Preorden(actual.izquierdo);
            Preorden(actual.derecho);
        }
    }

    public void Inorden(Nodo actual) {
        if (actual != null) {
            Inorden(actual.izquierdo);
            System.out.println(actual.valor + " ");
            Inorden(actual.derecho);
        }
    }

    public void Posorden(Nodo actual) {
        if (actual != null) {
            Posorden(actual.izquierdo);
            Posorden(actual.derecho);
            System.out.println(actual.valor + " ");
        }
    }

    public void Reemplazar(Nodo actual) {
        Nodo p = actual;
        Nodo a = actual.izquierdo;
        while (a.derecho != null) {
            p = a;
            a = a.derecho;
        }
        actual.valor = a.valor;
        System.out.println(a.valor + " VALOR QUE REEMPLAZA... ");
        if (p == actual) {
            p.izquierdo = a.izquierdo;
        } else {
            p.derecho = a.derecho;
        }
    }

    public void Eliminar(int elemento) {
        Nodo padre = raiz;
        Nodo aux = raiz;
        boolean hijoIzquierdo = true;
        boolean encontrado = false;
        while (aux != null) {
            if (aux.valor == elemento) {
                encontrado = true;
                if (aux == raiz) {
                    if (raiz.izquierdo == null) {
                        raiz = raiz.derecho;
                    } else if (raiz.derecho == null) {
                        raiz = raiz.izquierdo;
                    } else {
                        Reemplazar(raiz);
                    }
                } else {
                    System.out.println("Encontrado");
                    if (aux.izquierdo == null) {
                        if (hijoIzquierdo) {
                            padre.izquierdo = aux.derecho;
                        } else {
                            padre.derecho = aux.derecho;
                        }

                    } else if (aux.derecho == null) {
                        if (hijoIzquierdo) {
                            padre.izquierdo = aux.izquierdo;
                        } else {
                            padre.derecho = aux.izquierdo;
                        }
                    } else {
                        Reemplazar(aux);
                    }
                }
                aux = null;
            } else {
                padre = aux;
                if (aux.valor > elemento) {
                    aux = aux.izquierdo;
                    hijoIzquierdo = true;
                } else {
                    aux = aux.derecho;
                    hijoIzquierdo = false;
                }
            }
        }
        if (!encontrado) {
            System.out.println("El elemento no existe...");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArbolBinarioBusqueda myArbol = new ArbolBinarioBusqueda();
        int opcion, numero, elim;
        do {
            System.out.println("[1]. Insertar: ");
            System.out.println("[2]. Preorden: ");
            System.out.println("[3]. Inorden: ");
            System.out.println("[4]. Posorden: ");
            System.out.println("[5]. Eliminar: ");
            System.out.println("[0]. Salir: ");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese elemento: ");
                    numero = entrada.nextInt();
                    myArbol.Insertar(numero);
                    break;
                case 2:
                    myArbol.Preorden(myArbol.raiz);
                    System.out.println("");
                    break;
                case 3:
                    myArbol.Inorden(myArbol.raiz);
                    System.out.println("");
                    break;
                case 4:
                    myArbol.Posorden(myArbol.raiz);
                    System.out.println("");
                    break;
                case 5:
                    System.out.println("Elemento a eliminar ? :");
                    elim = entrada.nextInt();
                    myArbol.Eliminar(elim);
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
    }

}

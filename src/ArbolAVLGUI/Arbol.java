
package ArbolAVLGUI;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Lenin Sanchez
 */
public class Arbol {

    Nodo raiz;
    int cant;
    int altura;
    Nodo nuevo, temp; 
   

    public Nodo getRaiz() {
        return this.raiz;
    }

    public void setRaiz(Nodo r) {
        this.raiz = r;
    }

    public Arbol() {
        this.raiz = null;
    }



    
    public boolean agregar(int dato) {
        Nodo nuevo = new Nodo(dato, null, null);
        insertar(dato);
        return true;
    }
    
    
  public void insertar(int x) {
        //Verificamos si no existe aun un arbol
        if(raiz == null){
            raiz = new Nodo(x);
            raiz.dato = x;
            raiz.der = null;
            raiz.izq = null;
            raiz.padre = null;
            raiz.factor = 0;
        }else{
            //Caso contrario si ya existe
            temp = raiz;
            while(temp != null){
                //si el dato es mayor y hay espacio
                if((x > temp.dato) && (temp.der == null)) {
                    nuevo = new Nodo(x);
                    nuevo.dato = x;
                    nuevo.izq = null;
                    nuevo.der = null;
                    temp.der = nuevo;
                    nuevo.padre = temp;
                    nuevo.factor = 0;
                    balancea(nuevo.padre, 1);
                    break;
                }else
                    //si el dato es menor y hay espacio
                    if ((x<temp.dato)&&(temp.izq==null)){
                        nuevo=new Nodo(x);
                        nuevo.dato=x;
                        nuevo.izq=null;
                        nuevo.der=null;
                        temp.izq=nuevo;
                        nuevo.padre=temp;
                        nuevo.factor=0;
                        balancea(nuevo.padre,-1);
                        break;
                    }
                //si el dato es igual a otro ya agregado
                
                    else 
                        if (x==temp.dato){
                        //Ya existe ese dato en el arbol
                        break;
                    }else

                        //si hay mas datos  a la derecha
                        if(x>temp.dato)
                            temp=temp.der;
                        else
                        //si hay mas datos  a la izquierda
                        temp=temp.izq;
            }
        }
    }//end alta

    public void balancea(Nodo nodo, int incremento)
    {	
            int tipo=-1;
            while(nodo!=null)
            {
                    nodo.factor=nodo.factor+incremento; //Reajusta balances
                    if(nodo.factor==0) //Si es igual a 0 se detiene
                            break;
                    else
                    {
                            tipo=tipoRotacion(nodo); //llamamos al metodo tipoRotacion
                            if(tipo==0) //No hay necesidad de rotar
                            {
                                    if(nodo.padre!=null)
                                    {
                                            if(nodo.dato<nodo.padre.dato)
                                            {
                                                    incremento=-1;
                                            }
                                            else
                                            {
                                                    incremento=1;
                                            }
                                    }
                                    nodo=nodo.padre;
                            }
                            if(tipo==1)	//Rotacion sencilla izquierda
                                    {		
                                            rotacionSI(nodo,nodo.der);
                                            break;
                                    }
                            if(tipo==2) //Rotacion doble derecha-izquierda
                                    {
                                            rotacionSD(nodo.der,nodo.der.izq);
                                            rotacionSI(nodo,nodo.der);
                                            break;
                                    }
                            if(tipo==3) //Rotacion sencilla derecha
                                    {
                                            rotacionSD(nodo,nodo.izq);


                                            break;
                                    }
                            if(tipo==4) //Rotacion doble izquierda-derecha
                                    {
                                    rotacionSI(nodo.izq,nodo.izq.der);
                                    rotacionSD(nodo,nodo.izq);

                                            break;
                                    }

                    }


            }
    }


    public int tipoRotacion(Nodo n)
    {
            if(n.factor==2){
                    if((n.der.factor==0)||(n.der.factor==1))
                            return 1;
                    else 
                        if(n.der.factor==-1)
                            return 2;
            }
            else 
                if(n.factor==-2){
                    if((n.izq.factor==0)||(n.izq.factor==-1))
                            return 3;
                    else 
                        if(n.izq.factor==1)
                            return 4;
            }
            return 0;
    }  
    
    public void rotacionSI(Nodo n, Nodo n1){
        // variables
        int h, b;
        temp = n1.izq;
        if (n == raiz) {
            raiz = n1;
            n1.padre = null;
        }else{
            if (n.dato > n.padre.dato) {
                n.padre.der = n1;
            }else{
                n.padre.izq = n1;
            }
            n1.padre = n.padre;
        }
        n1.izq = n;
        n.der = temp;
        n.padre = n1;
        if (temp != null) {
            temp.padre = n;
        }
        h = n.factor;
        n.factor = (h - 1) - Math.max(n1.factor, 0);
        b = Math.min((h - 2), (h + n1.factor-2));
        n1.factor = Math.min(b, (n1.factor-1));
    }
    // metodo para rotacion derecha -> izquierda
    public void rotacionSD (Nodo n, Nodo n1){
        // variable
        int h , b;
        temp = n1.der;
        if (n == raiz) {
            raiz = n1;
            n1.padre = null;
        }else{
            if (n.dato > n.padre.dato) {
                n.padre.der = n1;
            }else{
                n.padre.izq = n1;
            }
        }
        n1.padre = n.padre;
        n1.der = n;
        n.izq = temp;
        n.padre = n1;
        if (temp != null) {
            temp.padre = n;
        }
        h = n.factor;
        n.factor = (h + 1) - Math.min(n1.factor, 0);
        b = Math.min((h + 2), (h - n1.factor+2));
        n1.factor = Math.max(b, (n1.factor+1));
    }

    
    
    //imprimir ordenado con niveles
 
    String[] niveles;

    public int alturaArbol() {
        altura = 0;
        alturaArbol(raiz, 0);
        return altura;
    }

    private void alturaArbol(Nodo pivote, int nivel) {
        if (pivote != null) {
            alturaArbol(pivote.getIzq(), nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            alturaArbol(pivote.getDer(), nivel + 1);
        }
    }

    public ArrayList imprimirNivel() {
        niveles = new String[altura + 1];
        ArrayList l=new ArrayList();
        imprimirNivel(raiz, 0);
        for (int i = 0; i < niveles.length; i++) {
            l.add(niveles[i] + " ");
            //System.out.println(niveles[i] + " ");
        }
        return l;
    }
      public void imprimirNivel(Nodo pivote, int nivel2) {
        if (pivote != null) {
            niveles[nivel2] = pivote.getDato() + ", " + ((niveles[nivel2] != null) ? niveles[nivel2] : "");
            imprimirNivel(pivote.getDer(), nivel2 + 1);
            imprimirNivel(pivote.getIzq(), nivel2 + 1);
        }
    }
     
    
    //Borrar el que sea
    public int borrar(int x) {
        if (!this.buscar(x)) {
            return 0;
        }

        Nodo z = borrar(this.raiz, x);
        this.setRaiz(z);
        return x;

    }

    private Nodo borrar(Nodo r, int x) {
        if (r == null) {
            return null;//<--Dato no encontrado		
        }
        int compara = ((Comparable) r.getDato()).compareTo(x);
        if (compara > 0) {
            r.setIzq(borrar(r.getIzq(), x));
        } else if (compara < 0) {
            r.setDer(borrar(r.getDer(), x));
        } else {
            System.out.println("Encontro el dato:" + x);
            if (r.getIzq() != null && r.getDer() != null) {
                /*
                 *	Buscar el menor de los derechos y lo intercambia por el dato
                 *	que desea borrar. La idea del algoritmo es que el dato a borrar 
                 *	se coloque en una hoja o en un nodo que no tenga una de sus ramas.
                 **/
                Nodo cambiar = buscarMin(r.getDer());
                int aux = cambiar.getDato();
                cambiar.setDato(r.getDato());
                r.setDato(aux);
                r.setDer(borrar(r.getDer(), x));
                System.out.println("2 ramas");
            } else {
                r = (r.getIzq() != null) ? r.getIzq() : r.getDer();
                System.out.println("Entro cuando le faltan ramas ");
            }
        }
        return r;
    }

    //buscar
    public boolean buscar(int x) {
        return (buscar(this.raiz, x));
    }

    private boolean buscar(Nodo r, int x) {
        if (r == null) {
            return (false);
        }
        int compara = ((Comparable) r.getDato()).compareTo(x);
        if (compara > 0) {
            return (buscar(r.getIzq(), x));
        } else if (compara < 0) {
            return (buscar(r.getDer(), x));
        } else {
            return (true);
        }
    }

    //buscar min
    private Nodo buscarMin(Nodo r) {
        for (; r.getIzq() != null; r = r.getIzq());
        return (r);
    }
       //imprimir preorden
    public ArrayList preOrden() {
        ArrayList l=new ArrayList();
        preOrden(raiz,l);
        return l;
    }

    private void preOrden(Nodo reco, ArrayList l) {       //recorre dato izq-der 
        if (reco != null) {
            l.add(reco.getDato() + " ");
            preOrden(reco.getIzq(),l);
            preOrden(reco.getDer(),l);
        }
    }
    //imprimir InOrden
    public ArrayList inOrden() {
        ArrayList l=new ArrayList();
        inOrden(raiz,l);
        return l;
    }

    private void inOrden(Nodo reco,ArrayList l) {         //recorre Izq-Dato-Der
        if (reco != null) {
            inOrden(reco.getIzq(),l);
            l.add(reco.getDato() + " ");
            inOrden(reco.getDer(),l);
        }
    }

//imprimir post orden
    public ArrayList postOrden() {
        ArrayList l=new ArrayList();
        postOrden(raiz,l);
        return l;
    }

    private void postOrden(Nodo reco, ArrayList l) {     // recorre Izq-Der-Dato
        if (reco != null) {
            postOrden(reco.getIzq(),l);
            postOrden(reco.getDer(),l);
            l.add(reco.getDato() + " ");
        }
    }
    
    //con nivel
       public ArrayList impNiveles() {
        ArrayList l=new ArrayList();
        impNiveles(raiz, 1,l);
        return l;
    }

    private void impNiveles(Nodo reco, int nivel,ArrayList l) {
        if (reco != null) {
            impNiveles(reco.getIzq(), nivel + 1, l);
            l.add(reco.getDato() + " Nivel: (" + nivel + ") ");
            impNiveles(reco.getDer(), nivel + 1, l);
        }
    }
    
    //hojas
    public ArrayList getHojas() {
        ArrayList l = new ArrayList();
        getHojas(this.raiz, l);
        return (l);
    }

    private void getHojas(Nodo r, ArrayList l) {
        if (r != null) {
            if (this.esHoja(r)) {
                l.add(r.getDato());
            }
            getHojas(r.getIzq(), l);
            getHojas(r.getDer(), l);
        }

    }
    protected boolean esHoja(Nodo x) {
        return (x != null && x.getIzq() == null && x.getDer() == null);
    }
    
    
    public int padre(int info) {
        if (info == 0 || this.raiz == null) {
            return 0;
        }
        Nodo x = padre(this.raiz, info);
        if (x == null) {
            return 0;
        }
        return (x.getDato());
    }

    private Nodo padre(Nodo x, int info) {
        if (x == null) {
            return null;
        }
        if ((x.getIzq() != null && x.getIzq().getDato()==(info)) || (x.getDer() != null && x.getDer().getDato()==(info))) {
            return (x);
        }
        Nodo y = padre(x.getIzq(), info);
        if (y == null) {
            return (padre(x.getDer(), info));
        } else {
            return (y);
        }
    }
    
    //eliminar hojas
     public void podar() {
        podar(this.raiz);
    }

    private void podar(Nodo x) {
        if (x == null) {
            return;
        }
        if (this.esHoja(x.getIzq())) {
            x.setIzq(null);
        }
        if (this.esHoja(x.getDer())) {
            x.setDer(null);
        }
        podar(x.getIzq());
        podar(x.getDer());
    }
   
    
    
    
    //dibujar arbol
     public JPanel getdibujo() {
        return new ArbolExpresionGrafico(this);
    }
}

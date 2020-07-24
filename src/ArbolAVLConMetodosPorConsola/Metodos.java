package ArbolAVLConMetodosPorConsola;
/**
 *
 * @author Andres Roman
 */
public class Metodos {
    // punteros
    Nodo nuevo, raiz, temp;
    // constructor
    public Metodos(){
        nuevo = null;
        raiz = null;
    }
    // metodo para ingresar nuevos datos y balancearlos
    public void ingresar(int x) {
        // verificamos si ya existe raiz
        if(raiz == null){
            // creamos el nuevo arbol con raiz
            raiz = new Nodo(x);
            raiz.padre = null;
            raiz.factor = 0;
        }else{
            // se crea un temporal para moverse por el arbol
            temp = raiz;
            // ciclo que recorre el arbol
            while(temp != null){
                // si el dato es mayor y hay espacio
                if((x > temp.dato) && (temp.der == null)) {
                    nuevo = new Nodo(x);
                    // se conecta con el antecesor
                    temp.der = nuevo;
                    nuevo.padre = temp;
                    nuevo.factor = 0;
                    // se balancea con incremento 1 (por derecha)
                    balancea(nuevo.padre, 1);
                    break;
                }else{
                    // si el dato es menor y hay espacio
                    if ((x < temp.dato) && (temp.izq == null)){
                        nuevo = new Nodo(x);
                        // se conecta con el antecesor
                        temp.izq = nuevo;
                        nuevo.padre = temp;
                        nuevo.factor = 0;
                        // se balancea con incremento -1 (por izquierda)
                        balancea(nuevo.padre, -1);
                        break;
                    }else{
                        // si el dato es igual
                        if (x == temp.dato){
                            // se acaba el ciclo y no ingresa nada
                            break;
                        }else{
                            // si hay mas datos se dezplaza a la derecha
                            if(x > temp.dato){
                                temp = temp.der;
                            }else{
                                // si hay mas datos se desplaza a la izquierda
                               temp = temp.izq;
                            }   
                        }
                    }    
                }
            }// fin while
        }
    }// fin ingresar
    // metodo para balancear los datos ingresados
    public void balancea(Nodo n, int inc){
        // se inicializa la variable
        int tipo = -1;
        // ciclo para proceder a las rotaciones
        while(n != null){
            // reajusta el factor de equlibrio dependiendo del incremento
            n.factor = n.factor + inc;
            // si es igual a 0 se detiene, esta balanceado
            if(n.factor == 0){
                break;
            }else{
                // se llama para ver el tipo de rotacion
                tipo = rotacion(n);
                if(tipo == 0){ 
                    // no se necesita rotar
                    if(n.padre != null){
                        if(n.dato < n.padre.dato)
                            inc = -1;
                        else
                            inc = 1;
                    }
                    // se conecta con su antecesor
                    n = n.padre;
                }
                if(tipo == 1){
                    // rotacion I-I
                    rotacionSI(n, n.der);
                    break;
                }
                if(tipo == 2){ 
                    // rotacion D-I
                    rotacionSD(n.der, n.der.izq);
                    rotacionSI(n, n.der);
                    break;
                }
                if(tipo == 3){ 
                    // rotacion D-D
                    rotacionSD(n, n.izq);
                    break;
                }
                if(tipo == 4){ 
                    // rotacion I-D    
                    rotacionSI(n.izq, n.izq.der);
                    rotacionSD(n, n.izq);
                    break;
                }
            }
        }// fin while
    }
    // metodo para verificar el tipo de rotacion segun sus factores de equilibrio
    public int rotacion(Nodo n){
        // rotacion por izquierda
        if(n.factor == 2)
            if((n.der.factor == 0)||(n.der.factor == 1))
                // rotacion I-I
                return 1;
            else 
                if(n.der.factor == -1)
                    // rotacion D-I
                    return 2;
        else 
            // rotacion por derecha
            if(n.factor == -2)
                if((n.izq.factor == 0)||(n.izq.factor == -1))
                    // rotacion D-D
                    return 3;
                else 
                    if(n.izq.factor == 1)
                        // rotacion I-D
                        return 4;
        // no se necesita rotar
        return 0;
    }
    // metodo para la rotacion sencilla a la izquierda, recibe el nodo y su hijo derecho
    public void rotacionSI(Nodo n, Nodo n1){
        // atributos locales
        int factor1, min;
        // temporal por hijo derecho-izquierda
        temp = n1.izq;
        if(n == raiz){
            // se sustituye la raiz
            raiz = n1;
            n1.padre = null;
        }else{
            if(n.dato > n.padre.dato){
                // se conecta por derecha
                n.padre.der = n1;
            }else{
                // se conecta por izquierda
                n.padre.izq = n1;
            }
            // se cambian los antecesores
            n1.padre = n.padre;
        }
        // cambian las conexiones
        n1.izq = n;
        n.der = temp;
        n.padre = n1;
        if(temp != null)
            temp.padre = n;
        // se restablecen los factores
        factor1 = n.factor;
        n.factor = (factor1-1) - Math.max(n1.factor, 0);
        // devuelve el minimo de los factores
        min = Math.min((factor1-2), (factor1 + n1.factor-2));
        // establece el minimo
        n1.factor = Math.min(min, (n1.factor-1));
    }
    // metodo para la rotacion sencilla a la derecha, recibe el nodo y su hijo izquierdo
    public void rotacionSD(Nodo n, Nodo n1){
        // variables locales
        int factor1, min;
        // temporal para hijo izquierdo-derecho
        temp = n1.der;
        if(n == raiz){
            // se sustituye la raiz
            raiz = n1;
            n1.padre = null;
        }else{
            if(n.dato > n.padre.dato)
                // se conecta por derecha
                n.padre.der = n1;
            else
                // se conecta por izquierda
                n.padre.izq = n1;
        }
        // cambian las conexiones
        n1.padre = n.padre;
        n1.der = n;
        n.izq = temp;
        n.padre = n1;
        if(temp != null)
            temp.padre = n;
        // se restablecen los factores
        factor1 = n.factor;
        n.factor = (factor1+1) - Math.min(n1.factor, 0);
        // devuelve el minimo de los factores
        min = Math.min((factor1+2), (factor1 - n1.factor+2));
        // establece el maximo
        n1.factor = Math.max(min, (n1.factor+1));
    }
    // metodo para eliminar un nodo
    public void eliminar(int x){
        if (raiz != null) {
            // temporal para recorrer desde raiz
            temp = raiz;
            // encuentra el dato y remplaza las conexiones desde raiz
            if (temp.dato == x) {
                raiz = remplaza(raiz);
            }else{
                // nodos auxilares para busqueda
                Nodo aux;
                Nodo por = raiz;
                boolean encuentra = false;
                if (x < temp.dato) {
                    // busqueda por izquierda
                    aux = raiz.izq;
                }else{
                    // busqueda por derecha
                    aux = raiz.der;
                }
                // ciclo que recorre el arbol
                while(aux != null && !encuentra){
                    if (x == aux.dato) {
                        // encuentra dato y llama al metodo remplaza
                        encuentra = true;
                        if (aux == por.izq) {
                            // remplaza por izquierda
                            por.izq = remplaza(aux);
                        }else{
                            // remplaza por derecha
                            por.der = remplaza(aux);
                        }
                    }else{
                        // se mueve segun el dato a eliminar
                        por = aux;
                        if (x < aux.dato) {
                            aux = aux.izq;
                        }else{
                            aux = aux.der;
                        }
                    }
                }
                // si no encuentra el dato
                if (!encuentra) {
                    System.out.println("ELEMENTO NO ENCONTRADO");
                }
            }
        }
    }// fin eliminar
    // metodo para remplazar los subarboles del nodo eliminado
    public Nodo remplaza(Nodo n){
        // variable inicializada
        Nodo resultado = null;
        // si es nodo hoja (sin hijos)
        if ((n.izq == null) && (n.der == null)) {
            resultado = null;
        }else{
            // si tiene hijo solo por izquierda
            if ((n.izq != null) && (n.der == null)) {
                resultado = n.izq;
            }else{
                // si tiene hijo solo por derecha
                if ((n.izq == null) && (n.der != null)) {
                    resultado = n.der;
                }else{
                    // si tiene hijo por ambas conexiones
                    Nodo actual = n.der;
                    Nodo aux = n; 
                    while(actual.izq != null){
                        aux = actual;
                        actual = actual.izq;
                    }
                    // sustituye las conexiones 
                    if (n.der == actual) {
                        actual.izq = n.izq;
                    }else{
                        aux.izq = actual.der;
                        actual.der = n.der;
                        actual.izq = n.izq;
                    }
                    // devuelve el subarbol
                    resultado = actual;
                }
            }
        }
        return resultado;
    }
    // metodo para buscar un elemento en el arbol
    public boolean buscar(int x){
        if (raiz != null) {
            // llama al metodo buscar desde raiz
            return (raiz.buscar(x) != null);
        }else{
            // no existe arbol
            return false;
        }
    }
    // metodo para mostrar los recorridos
    public void mostrar(){
        if (raiz != null) {
            System.out.println("Recorrido pre-orden:");
            raiz.preorden();
            System.out.println("");
            System.out.println("Recorrido in-orden:");
            raiz.inorden();
            System.out.println("");
            System.out.println("Recorrido post-orden:");
            raiz.postorden();
        }
    }
    // metodo para imprimir desde raiz
    public void imprimir(){
        imprimirPorNiveles(raiz);
    }
    // metodo para imprmir por niveles
    private void imprimirPorNiveles(Nodo n){
        // variable para el maximo de nodos
        int max = 0;
        // obtiene la altura del arbol
        int nivel = altura();
        // recorre el arbol hacia arriba
        for ( ; nivel >= 0; nivel--)
            // calcula el maximo de nodos
            max += Math.pow(2, nivel);
        // uma 1 del nodo raiz
        max++;
        // se crea un arreglo tipo Nodo con ese tamaño
        Nodo cola[] = new Nodo[max];
        // carga en la pos 1 el nodo raiz
        cola[1] = n;
        int x = 1;
        // carga los demas elementos del arbol,
        // carga null en izq y der si el nodo es null
        // i aumenta de a 2 porque carga en izq y der los hijos
        for (int i = 2; i < max; i += 2, x++){
            if (cola[x] == null){// x aumenta 1, que son los nodos raiz - padre
                cola[i] = null;
                cola[i + 1] = null;
            }else{ // carga los nodos en el arreglo
                cola[i]   = cola[x].izq;
                cola[i + 1] = cola[x].der;
            }
        }
        nivel = 0;
        // contador de nodos no vacios para cada nivel
        int cont = 0; 
        // cantidad de nodos por nivel
        int cantidad = 1;          
        // ultima posicion del nodo en la cola de cada nivel
        int ultimo = 1;             
        // 2 ^ 0 = 1 que es el nodo raiz
        for (int i = 1; i < max; i++){
            // hay cambio de nivel
            if(i == Math.pow(2, nivel)){
            	// nodo raiz tiene nivel 1, por eso (nivel + 1)
            	System.out.print("\n Nivel " + (nivel) + ": ");
                nivel++;
            }
            // imprime los datos de cada nodo
            if( cola[i] != null ){
                System.out.print("[" + cola[i].dato + "]");
                cont++;
            }
            if(ultimo == i  && cantidad == Math.pow(2, --nivel)){
                // primer nivel (raiz)
                if(cantidad == 1)
                    System.out.print(" Cantidad de nodos: " + cont + " (raiz)");
                // resto de niveles
                else
                    System.out.print(" Cantidad de nodos: " +  cont);
                cont = 0;
                cantidad *= 2;
                ultimo += (int)Math.pow(2, ++nivel);
            }
        }
    }
    // metodo para calcular la altura del arbol desde raiz
    public int altura(){
        return calcularAltura(raiz);
    }
    // metodo para calcular la altura del arbol
    private int calcularAltura(Nodo n){
        if (n == null)
            //  no tiene altura
            return -1;
        else
            // devuelve la altura maxima por izquierda o derecha
            return 1 + Math.max(calcularAltura(n.izq), calcularAltura(n.der));
    }
}

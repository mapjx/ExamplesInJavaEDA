package ArbolAVLConMetodosPorConsola;
/**
 *
 * @author Andres Roman
 */
public class Nodo {
    int dato, factor; // dato del nodo y factor de equilibrio
    Nodo izq, der, padre; // conexiones con izquierda, derecha y antecesor
    // constructor
    public Nodo (int x){
        dato = x;
        izq = der = null;
    }
    // metodo para buscar un elemento en el arbol
    public Nodo buscar(int x){
        // si encuentra el dato
        if (x == dato){
            // devuelve el dato
            return new Nodo(x);
        }else{ 
            // si el dato es menor
            if (x < dato){
                // se mueve por la izquierda
                if (izq != null){
                    return izq.buscar(x);
                }else{
                    // no encontró el dato
                    return null;
                }    
            }else{ 
                // si el dato es mayor 
                if (x > dato){
                    // se mueve por la derecha
                    if (der != null){
                        return der.buscar(x);
                    }
                }else{
                    // no encontró el dato
                    return null;
                }
            }
            // no encontró el dato
            return null;
        }
    }
    // metodos para recorridos
    // R-I-D
    public void preorden(){
        System.out.print("\t[ "+dato+" ]");
        if (izq != null)
            izq.preorden();
        if(der != null)
            der.preorden();
    }
    // I-R-D
    public void inorden(){
        if (izq != null)
            izq.inorden();
        System.out.print("\t[ "+dato+" ]");
        if (der != null)
            der.inorden();
    }
    // I-D-R
    public void postorden(){
        if(izq != null)
            izq.postorden();
        if(der !=null)
            der.postorden();
        System.out.print("\t[ "+dato+" ]");
    }
}

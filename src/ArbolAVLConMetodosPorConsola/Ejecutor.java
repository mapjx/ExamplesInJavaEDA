package ArbolAVLConMetodosPorConsola;
import java.util.Scanner;
/**
 *
 * @author Maximo Paute
 */
public class Ejecutor {
    // metodo main
    public static void main(String[] args) {
        // entrada de datos por teclado
        Scanner datos = new Scanner(System.in);
        // objeto Metodos
        Metodos me = new Metodos();
        // atributos
        int op, ele;
        // menu repetitivo
        do{
            System.out.println(""
                    + "-----------ARBOLES------------\n"
                    + "Ingresar un elemento     [ 1 ]\n"
                    + "Buscar un elemento       [ 2 ]\n"
                    + "Eliminar un elemento     [ 3 ]\n"
                    + "Imprimir                 [ 4 ]\n"
                    + "Salir                    [ 0 ]");
            op = datos.nextInt();
            switch (op){
                case 1:
                    System.out.println("Ingrese el elemento:");
                    ele = datos.nextInt();
                    // llama a la funcion ingresar
                    me.ingresar(ele);
                    break;
                case 2:
                    System.out.println("Ingrese el elemento a buscar:");
                    ele = datos.nextInt();
                    // devuelve un boolean segun el metodo buscar
                    if (me.buscar(ele)) {
                        System.out.println("El elemento SI se encuentra en el arbol");
                    }else{
                        System.out.println("El elemento NO se encuentra en el arbol");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el elemento a eliminar:");
                    ele = datos.nextInt();
                    // llama al metodo eliminar
                    me.eliminar(ele);
                    break;
                case 4:
                    // recorridos de orden
                    me.mostrar();
                    System.out.println("");
                    // recorrido por niveles
                    me.imprimir();
                    System.out.println("");
                    break;
                case 0:
                    System.out.println("GRACIAS");
                    break;
                default:
                    System.out.println("INGRESE UNA OPCION CORRECTA");
                    break;
            }
            System.out.println("");
        }while (op != 0);
        datos.close();
    }
}

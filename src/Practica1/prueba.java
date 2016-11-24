package Practica1;

/**
 * Created by adrian on 21/11/2016.
 */
public class prueba{
    public static void main(String[] args){

        TablaHash th = new TablaHash(3);

        for(int i=0 ; i<10 ; i++){
            th.introducirProducto(new Producto("a"+i, i, i));
        }
        System.out.println("TABLA INICIAL:");
        System.out.println(th.toString());

        Producto encontrado;
        for(int i=0 ; i<10 ; i++){
            System.out.println("Buscando a"+i+": ");
            encontrado = th.buscarProducto("a"+i);
            System.out.println(encontrado.toString());
        }
    }
}

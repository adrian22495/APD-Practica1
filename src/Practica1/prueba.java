package Practica1;

/**
 * Created by adrian on 21/11/2016.
 */
public class prueba{
    public static void main(String[] args){
        Tabla_Hash th = new Tabla_Hash();
        Producto p1 = new Producto("p1", 5, 6);
        Producto p2 = new Producto("p2", 61, 234);
        Producto p3 = new Producto("p3", 5, 6);
        Producto p4 = new Producto("p4", 61, 234);
        Producto p5 = new Producto("p5", 5, 6);
        Producto p6 = new Producto("p6", 61, 234);
        Producto p7 = new Producto("p7", 5, 6);
        Producto p8 = new Producto("p8", 61, 234);
        Producto p9 = new Producto("p9", 5, 6);
        Producto p10 = new Producto("p10", 61, 234);
        th.introducir_producto(p1);
        th.introducir_producto(p2);
        th.introducir_producto(p3);
        th.introducir_producto(p4);
        th.introducir_producto(p5);
        th.introducir_producto(p6);
        th.introducir_producto(p7);
        th.introducir_producto(p8);
        th.introducir_producto(p9);
        th.introducir_producto(p10);
        Producto p12 = th.buscar_producto("p8");
        System.out.printf("funciono");
    }
}

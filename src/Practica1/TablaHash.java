package Practica1;

import java.util.Random;

/**
 * Created by adrian on 24/11/2016.
 */
public class TablaHash {

    private ListaProductos[] tabla;
    private int[] tablaAleatoria;
    private int size;

    public TablaHash(int s){
        size = s;

        //Inicializamos la tabla
        tabla = new ListaProductos[size];
        for(int i = 0; i<size;i++){
            tabla[i]  = new ListaProductos();
        }
        //Preparamos la tabla aleatoria para la funcion hash
        tablaAleatoria = new int[256];
        Random r = new Random();
        for (int i = 0; i<256;i++){
            tablaAleatoria[i] = i % (size);
        }
        for( int i = 0; i<500; i++){
            int primero = r.nextInt((254 - 0) + 1);
            int segundo = r.nextInt((254 - 0) + 1);
            int aux = tablaAleatoria[primero];
            tablaAleatoria[primero]=tablaAleatoria[segundo];
            tablaAleatoria[segundo]=aux;
        }
    }

    /**
     * Devolvera el producto con ese nombre, si no se encuentra
     * Devolvera el producto con ese nombre, si no se encuentra
     * devolvera null.
     * @param nombre
     * @return
     */
    public Producto buscarProducto(String nombre)
    {
        int posicion = funcionHash(nombre);
        ListaProductos listP= tabla[posicion];
        while(listP != null && listP.getProducto()!=null){
            if(listP.getProducto().getNombre().equals(nombre)){
                return listP.getProducto();
            }
            listP = listP.getSiguiente();
        }
        return null;
    }
    public void introducirProducto(Producto p) {
        int posicion = funcionHash(p.getNombre());
        tabla[posicion].anadirProducto(p);
    }

    private int funcionHash(String s){
        int h = 0;
        for ( int i=0; i<s.length();i++){
            h=tablaAleatoria[h ^ s.charAt(i)];
        }
        return h;
    }

    public String toString(){
        String cadena = "";
        for(int i=0 ; i<tabla.length ; i++){
            cadena = cadena + tabla[i].toString() + "\n";
        }
        return cadena;
    }
}

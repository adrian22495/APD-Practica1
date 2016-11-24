package Practica1;

import java.util.Random;

/**
 * Created by adrian on 24/11/2016.
 */
public class Tabla_Hash {
    public class ListaProductos{
        private Producto producto;
        private ListaProductos siguiente;

        public ListaProductos(){
            producto = null;
            siguiente = null;
        }
        public ListaProductos(Producto s, ListaProductos l){
            producto = s;
            siguiente = l;
        }
        public Producto getProducto() {
            return producto;
        }
        public void setProducto(Producto p) {
            producto = p;
        }
        public ListaProductos getSiguiente() {
            return siguiente;
        }
        public void setSiguiente(ListaProductos siguiente) {
            this.siguiente = siguiente;
        }
        public void anadirProducto(Producto p){
            //Si es la primera vez
            if(siguiente == null && producto == null){
                producto = p;
            }
            else{
                ListaProductos nodoViejo = new ListaProductos(producto, siguiente);
                siguiente=nodoViejo;
                producto = p;
            }
        }
        public Producto buscarProducto(ListaProductos ls, String nombre){
            Producto p = ls.getProducto();
            if (p!= null && p.getNombre().equals(nombre)){
                return p;
            }
            ListaProductos siguiente = ls.getSiguiente();
            if(siguiente != null){
                return buscarProducto(siguiente, nombre);
            }
            return null;
        }
    }
    private ListaProductos[] tabla;
    private static int[] tablaAleatoria;
    private final int size = 23;

    public Tabla_Hash(){
        //inicializamos la tabla de simbolos
        tabla = new ListaProductos[size];
        for(int i = 0; i<size;i++){
            tabla[i]  = new ListaProductos();
        }
        //Preparamos la tabla aleatoria para la función hash
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

    public void inicializar_tabla(){
        //inicializamos la tabla de simbolos
        tabla = new ListaProductos[size];
        for(int i = 0; i<size;i++){
            tabla[i]  = new ListaProductos();
        }
        //Preparamos la tabla aleatoria para la función hash
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
     * Devolvera el pructo con ese nombre, si no se encuentra
     * devolvera null.
     * @param nombre
     * @return
     */
    public Producto buscar_producto(String nombre)
    {
        int posicion = funcHash(nombre);
        ListaProductos listP= tabla[posicion];
        while(listP != null && listP.getProducto()!=null){
            if(listP.getProducto().getNombre().equals(nombre)){
                return listP.getProducto();
            }
            listP = listP.getSiguiente();
        }
        return null;
    }
    public void introducir_producto(Producto p) {
        int posicion = funcHash(p.getNombre());
        tabla[posicion].anadirProducto(p);
    }
    public static int funcHash(String s){
        int h = 0;
        for ( int i=0; i<s.length();i++){
            h=tablaAleatoria[h ^ s.charAt(i)];
        }
        return h;
    }
}

package Practica1;

/**
 * Created by ALEX on 24/11/2016.
 */
public class ListaProductos {

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

    public String toString(){
        String cadena;
        if(siguiente==null){
            if(producto==null){
                return "";
            }
            else{
                cadena = producto.toString();
            }
        }
        else{
            cadena = producto.toString() + " - " + siguiente.toString();
        }
        return cadena;
    }
}

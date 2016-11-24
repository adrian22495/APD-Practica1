package Practica1;

/**
 * Created by ALEX on 24/11/2016.
 */
public class Producto {

    String nombre;
    long unidades;
    double precio;

    public Producto(String n, long u, double p){
        nombre = n;
        unidades = u;
        precio = p;
    }

    public String getNombre() {
        return nombre;
    }

    public long getUnidades() {
        return unidades;
    }

    public double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUnidades(long unidades) {
        this.unidades = unidades;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

package Practica1;

/**
 * Created by ALEX on 24/11/2016.
 */
public class Producto {

    String nombre;
    int unidades;
    double precio;

    public Producto(String n, int u, double p){
        nombre = n;
        unidades = u;
        precio = p;
    }

    public String getNombre() {
        return nombre;
    }

    public int getUnidades() {
        return unidades;
    }

    public double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

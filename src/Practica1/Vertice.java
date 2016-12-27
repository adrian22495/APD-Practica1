package Practica1;

import java.util.ArrayList;

public class Vertice {
    private Producto p;
    private ArrayList<Vertice> absorbidos = new ArrayList<Vertice>();

    public Vertice(Producto producto){
        p = producto;
    }

    public Producto getProducto(){
        return p;
    }

    public ArrayList<Vertice> getAbsorbidos(){
        return absorbidos;
    }

    public void absorber(Vertice v){
        absorbidos.add(v);
    }

    public String toString(){
        if(absorbidos.size()==0){
            return "" + p.getNombre();
        }
        else{
            String cadena = "" + p.getNombre();
            for(int i=0 ; i<absorbidos.size() ; i++){
                cadena = cadena + "(" + absorbidos.get(i).toString() + ")";
            }
            return cadena;
        }
    }
}
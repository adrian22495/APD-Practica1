package Practica1;

import java.util.ArrayList;

public class Vertice {
    private int id;
    private Producto p;
    private ArrayList<Vertice> absorbidos = new ArrayList<Vertice>();

    public Vertice(int identificador, Producto producto){
        id = identificador;
        p = producto;
    }

    public ArrayList<Vertice> getAbsorbidos(){
        return absorbidos;
    }

    public void absorber(Vertice v){
        absorbidos.add(v);
    }

    public String toString(){
        if(absorbidos.size()==0){
            return "" + id;
        }
        else{
            String cadena = "" + id;
            for(int i=0 ; i<absorbidos.size() ; i++){
                cadena = cadena + "(" + absorbidos.get(i).toString() + ")";
            }
            return cadena;
        }
    }
}
package Practica1;


import java.util.ArrayList;
import java.util.Random;

public class Grafo {

    private static Random r = new Random(System.currentTimeMillis());

    private TablaHash vertices = new TablaHash(7);
    private ArrayList<Arista> aristas = new ArrayList<Arista>();
    private int suma_pesos = 0;

    public Grafo(){}

    public Grafo(TablaHash v, ArrayList<Arista> a){
        vertices = v;
        aristas = a;

        for(int i=0; i<a.size() ; i++){
            suma_pesos = suma_pesos + a.get(i).getPeso();
        }
    }

    public void añadirVertice(Vertice v){
        vertices.introducirVertice(v);
    }

    public void añadirArista(Arista a){
        aristas.add(a);
        suma_pesos = suma_pesos + a.getPeso();
    }

    public int getNumVertices(){
        return vertices.getNumVertices();
    }

    public int getNumAristas(){
        return aristas.size();
    }

    public int getSumaPesos(){
        return suma_pesos;
    }

    public Vertice getVertice(String n){
        return vertices.buscarVertice(n);
    }

    public Arista getArista(int id){
        return aristas.get(id);
    }

    public void contraer(int arista){
        Arista a = aristas.get(arista);
        String id_v1 = a.getVertice1();
        Vertice v1 = vertices.buscarVertice(id_v1);
        String id_v2 = a.getVertice2();
        Vertice v2 = vertices.buscarVertice(id_v2);

        //v1 absorve v2
        v1.absorber(v2);

        //Eliminamos el vertice y la arista de las listas
        vertices.borrarVertice(id_v2);
        aristas.remove(arista);
        suma_pesos = suma_pesos - a.getPeso();

        //Cambiamos las aristas con un extremo en v2, por v1
        for(int i=0 ; i<aristas.size() ; i++){
            a = aristas.get(i);
            if(a.getVertice1().equals(id_v2)){
                a.setVertice1(id_v1);
            }
            if(a.getVertice2().equals(id_v2)){
                a.setVertice2(id_v1);
            }
            if(a.getVertice1().equals(a.getVertice2())){
                suma_pesos = suma_pesos - a.getPeso();
                aristas.remove(i);
            }
        }
    }

    public int elegirArista(){

        int aleatorio = 1+r.nextInt(suma_pesos);
        int acumulado = 0;

        for(int i=0 ; i<getNumAristas() ; i++){
            acumulado = acumulado + aristas.get(i).getPeso();
            if(acumulado>=aleatorio){
                return i;
            }
        }
        return -1;
    }

    public String toString(){
        String cadena = "Vertices:\n";
        cadena = cadena + vertices.toString();
        cadena = cadena + "\nAristas:\n";
        for(int i=0 ; i<aristas.size() ; i++){
            cadena = cadena + aristas.get(i).toString() + "\n";
        }
        return cadena;
    }
}

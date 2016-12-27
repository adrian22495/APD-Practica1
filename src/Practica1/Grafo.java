package Practica1;


import java.util.ArrayList;

public class Grafo {

    private TablaHash vertices = new TablaHash(7);
    private ArrayList<Arista> aristas = new ArrayList<Arista>();

    public Grafo(){}

    public Grafo(TablaHash v, ArrayList<Arista> a){
        vertices = v;
        aristas = a;
    }

    public void añadirVertice(Vertice v){
        vertices.introducirVertice(v);
    }

    public void añadirArista(Arista a){
        aristas.add(a);
    }

    public int getNumVertices(){
        return vertices.getNumVertices();
    }

    public int getNumAristas(){
        return aristas.size();
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
                aristas.remove(i);
            }
        }
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

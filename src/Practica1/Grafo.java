package Practica1;


import java.util.ArrayList;

public class Grafo {

    private ArrayList<Vertice> vertices = new ArrayList<Vertice>();
    private ArrayList<Arista> aristas = new ArrayList<Arista>();

    public Grafo(){}

    public Grafo(ArrayList<Vertice> v, ArrayList<Arista> a){
        vertices = v;
        aristas = a;
    }

    public void añadirVertice(Vertice v){
        vertices.add(v);
    }

    public void añadirArista(Arista a){
        aristas.add(a);
    }

    public int getNumVertices(){
        return vertices.size();
    }

    public int getNumAristas(){
        return aristas.size();
    }

    public Vertice getVertice(int id){
        return vertices.get(id);
    }

    public Arista getArista(int id){
        return aristas.get(id);
    }

    public void contraer(int arista){
        Arista a = aristas.get(arista);
        int id_v1 = a.getVertice1();
        Vertice v1 = vertices.get(id_v1);
        int id_v2 = a.getVertice_2();
        Vertice v2 = vertices.get(id_v2);

        //v1 absorve v2
        v1.absorber(v2);

        //Eliminamos el vertice y la arista de las listas
        vertices.remove(v2);
        aristas.remove(arista);

        //Cambiamos las aristas con un extremo en v2, por v1
        for(int i=0 ; i<aristas.size() ; i++){
            a = aristas.get(i);
            if(a.getVertice1()==id_v2){
                a.setVertice_1(id_v1);
            }
            else if(a.getVertice_2()==id_v2){
                a.setVertice_2(id_v1);
            }
        }
    }

    public String toString(){
        String cadena = "Vertices:\n";
        for(int i=0 ; i<vertices.size() ; i++){
            cadena = cadena + vertices.get(i).toString() + "\n";
        }
        cadena = cadena + "\nAristas:\n";
        for(int i=0 ; i<aristas.size() ; i++){
            cadena = cadena + aristas.get(i).toString() + "\n";
        }
        return cadena;
    }
}

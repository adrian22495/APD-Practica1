package Practica1;

public class Arista {
    private int vertice_1;
    private int vertice_2;

    public Arista(int v1, int v2){
        vertice_1 = v1;
        vertice_2 = v2;
    }

    public int getVertice1(){
        return vertice_1;
    }

    public int getVertice_2(){
        return vertice_2;
    }

    public void setVertice_1(int v1){
        vertice_1 = v1;
    }

    public void setVertice_2(int v2){
        vertice_2 = v2;
    }

    public String toString(){
        return vertice_1 + "-" + vertice_2;
    }
}

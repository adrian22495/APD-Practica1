package Practica1;

public class Arista {
    private String vertice_1;
    private String vertice_2;

    public Arista(String v1, String v2){
        vertice_1 = v1;
        vertice_2 = v2;
    }

    public String getVertice1(){
        return vertice_1;
    }

    public String getVertice2(){
        return vertice_2;
    }

    public void setVertice1(String v1){
        vertice_1 = v1;
    }

    public void setVertice2(String v2){
        vertice_2 = v2;
    }

    public String toString(){
        return vertice_1 + "-" + vertice_2;
    }
}

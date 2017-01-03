package Practica1;

public class ListaVertices {

    private Vertice vertice;
    private ListaVertices siguiente;

    public ListaVertices(){
        vertice = null;
        siguiente = null;
    }

    public ListaVertices(Vertice v, ListaVertices l){
        vertice = v;
        siguiente = l;
    }

    public Vertice getVertice() {
        return vertice;
    }

    public void setVertice(Vertice v) {
        vertice = v;
    }

    public ListaVertices getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(ListaVertices siguiente) {
        this.siguiente = siguiente;
    }

    public void anadirVertice(Vertice v){
        //Si es la primera vez
        if(siguiente == null && vertice == null){
            vertice = v;
        }
        else{
            ListaVertices nodoViejo = new ListaVertices(vertice, siguiente);
            siguiente=nodoViejo;
            vertice = v;
        }
    }

    public String toString(){
        if(siguiente==null){
            if(vertice==null){
                return "";
            }
            else{
                return vertice.toString() + "\n";
            }
        }
        else{
            return vertice.toString() + "\n" + siguiente.toString();
        }
    }
}

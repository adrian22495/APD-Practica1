package Practica1;

import java.util.Random;

public class TablaHash {

    private ListaVertices[] tabla;
    private int[] tablaAleatoria;
    private int size;
    private int num_vertices;

    public TablaHash(int s){
        size = s;
        num_vertices = 0;

        //Inicializamos la tabla
        tabla = new ListaVertices[size];
        for(int i = 0; i<size;i++){
            tabla[i]  = new ListaVertices();
        }
        //Preparamos la tabla aleatoria para la funcion hash
        tablaAleatoria = new int[256];
        Random r = new Random();
        for (int i = 0; i<256;i++){
            tablaAleatoria[i] = i % (size);
        }
        for( int i = 0; i<500; i++){
            int primero = r.nextInt((254 - 0) + 1);
            int segundo = r.nextInt((254 - 0) + 1);
            int aux = tablaAleatoria[primero];
            tablaAleatoria[primero]=tablaAleatoria[segundo];
            tablaAleatoria[segundo]=aux;
        }
    }

    /**
     * Devolvera el Vertice con ese nombre, si no se encuentra
     * Devolvera el Vertice con ese nombre, si no se encuentra
     * devolvera null.
     * @param nombre
     * @return
     */
    public Vertice buscarVertice(String nombre)
    {
        int posicion = funcionHash(nombre);
        ListaVertices listV= tabla[posicion];
        while(listV!=null && listV.getVertice()!=null){
            if(listV.getVertice().getProducto().getNombre().equals(nombre)){
                return listV.getVertice();
            }
            listV = listV.getSiguiente();
        }
        return null;
    }

    public void introducirVertice(Vertice v) {
        num_vertices++;
        int posicion = funcionHash(v.getProducto().getNombre());
        tabla[posicion].anadirVertice(v);
    }

    public void borrarVertice(String nombre){
        num_vertices--;
        int posicion = funcionHash(nombre);
        ListaVertices listV = tabla[posicion];

        while(listV!=null && listV.getVertice() != null){
            if(listV.getSiguiente()==null){
                if(listV.getVertice().getProducto().getNombre().equals(nombre)){
                    listV.setVertice(null);
                }
                else{
                    listV = null;
                }
            }
            else{
                if(listV.getVertice().getProducto().getNombre().equals(nombre)){
                    listV.setVertice(listV.getSiguiente().getVertice());
                    listV.setSiguiente(listV.getSiguiente().getSiguiente());
                }
                else{
                    listV = listV.getSiguiente();
                }
            }
        }
    }

    private int funcionHash(String s){
        int h = 0;
        for ( int i=0; i<s.length();i++){
            h=tablaAleatoria[h ^ s.charAt(i)];
        }
        return h;
    }

    public int getNumVertices(){
        return num_vertices;
    }

    public String toString(){
        String cadena = "";
        for(int i=0 ; i<tabla.length ; i++){
            if(tabla[i]!=null) {
                cadena = cadena + tabla[i].toString();
            }
        }
        return cadena;
    }
}

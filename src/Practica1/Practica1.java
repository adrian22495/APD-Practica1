package Practica1;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class Practica1 {

    private static Random r = new Random(System.currentTimeMillis());

    private static int num_productos = 0;
    private static Scanner lector_pr = null;
    private static Scanner lector_re = null;
    private static TablaHash th = null;
    private static Boolean relaciones[][] = null;

    public static void main(String[] args){

        if(args.length!=3){
            System.err.println("Uso: java Practica1 [num_productos] [fichero_productos] [fichero_relaciones]");
            System.exit(1);
        }

        try{
            num_productos = Integer.parseInt(args[0]);
            lector_pr = new Scanner(new File(args[1])).useDelimiter(" ");
            lector_re = new Scanner(new File(args[2])).useDelimiter(" ");
        }
        catch(IOException e1){
            System.err.println("No se ha podido encontrar alguno de los siguientes ficheros:\n\t- "+args[1]+"\n\t- "+args[2]);
            System.exit(1);
        }
        catch(NumberFormatException e2){
            System.err.println("El numero de porductos "+ num_productos + " no es un numero valido");
            System.exit(1);
        }

        th = new TablaHash((int) num_productos/5); // En cada lista de la tabla habra 5 productos en media
        relaciones = new Boolean[num_productos][num_productos];

        Grafo g = new Grafo();

        cargarProductos(g);
        cargarRelaciones(g);

        System.out.println(g.toString());
    }

    private static void cargarProductos(Grafo g){
        for(int i=0 ; i<num_productos ; i++) {
            String producto = lector_pr.nextLine();
            String[] componentes = producto.split(" ");
            try {
                Producto p = new Producto(componentes[0], Integer.parseInt(componentes[1]), Double.parseDouble(componentes[2]));
                Vertice v = new Vertice(g.getNumVertices(),p);
                g.añadirVertice(v);
            } catch (NumberFormatException e) {
                System.out.println("ERROR");
            }
        }
    }

    private static void cargarRelaciones(Grafo g){
        for(int i=0 ; i<num_productos ; i++){
            String relacion = lector_re.nextLine();
            String[] componentes = relacion.split(" ");
            for(int j=0 ; j<componentes.length ; j++) {
                try {
                    boolean existe_arista = Boolean.parseBoolean(componentes[j]);
                    if(existe_arista){
                        Arista a = new Arista(j,i);
                        g.añadirArista(a);
                    }
                } catch (NumberFormatException e) {}
            }
        }
    }

    private static Grafo Karger(Grafo g){

        Grafo g_mejor = null;

        //Repetimos n^2 veces para "asegurarnos" que es la solucion óptima
        for(int i=0 ; i<num_productos*num_productos ; i++){

            /******************************************/
            //Hay que hacer una copia en profundidad  //
            // Grafo g_copia = g;                     //
            /******************************************/

            //Mientras queden mas de 2 vertices comprimimos dos al azar
            while(g_copia.getNumVertices()>2){
                int arista = r.nextInt(g_copia.getNumAristas());
                g_copia.contraer(arista);
            }

            //Si la solución obtenida es mejor, nos la guardamos
            if(g_copia.getNumAristas()<g_mejor.getNumAristas()){
                /******************************************/
                //Hay que hacer una copia en profundidad  //
                // g_mejor = g_copia;                     //
                /******************************************/
            }
        }

        return g_mejor;
    }
}

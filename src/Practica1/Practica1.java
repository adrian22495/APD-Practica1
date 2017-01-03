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

    //Estructuras para almacenar los datos de los productos y sus relaciones
    private static TablaHash th = null;
    private static Integer[][] relaciones;
    private static Producto[] productos;

    private static int repeticiones=0;

    public static void main(String[] args){

        /************** COMPROBACION DE ARGUMENTOS ****************/
        if(args.length!=4){
            System.err.println("Uso: java Practica1 [num_productos] [fichero_productos] [fichero_relaciones] [repeticiones]");
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
            System.err.println("El numero de productos "+ args[0] + " no es un numero valido");
            System.exit(1);
        }

        try{
            repeticiones = Integer.parseInt(args[3]);
        }
        catch(NumberFormatException e){
            System.err.println("El numero de repeticiones "+ args[3] + " no es un numero valido");
            System.exit(1);
        }

        /************** INICIALIZACION ****************/
        //Creamos las estructuras que contendran los datos
        productos= new Producto [num_productos];
        relaciones = new Integer[num_productos][num_productos];
        th = new TablaHash((int) num_productos/5); // En cada lista de la tabla habra 5 productos en media

        /************** LECTURA DE FICHEROS ****************/
        //Cargamos la informacion de los ficheros en las estructuras
        cargarProductos();
        cargarRelaciones();

        /************** EJECUCION DE KARGER ****************/
        System.out.println("Ejecutando Karger con "+num_productos+" productos y "+repeticiones+" repeticiones...");
        Grafo mejor = null;
        for(int i=0 ; i<repeticiones ; i++) {
            System.out.println("\nRepeticion numero: "+(i+1));
            Grafo g = new Grafo();
            cargarGrafo(g);
            Karger(g);
            System.out.println("Numero de aristas: "+g.getNumAristas());
            System.out.println("Peso de las aristas: "+g.getSumaPesos());
            if(mejor==null){
                mejor=g;
            }
            else if(mejor.getSumaPesos()>g.getSumaPesos()){
                mejor=g;
            }
        }

        /************** RESULTADOS ****************/
        System.out.println("\nResultado final:");
        System.out.println("----------------");
        System.out.println(mejor.toString());
        System.out.println("Peso de las aristas: "+mejor.getSumaPesos());
    }



    //Carga los datos de los productos de los ficheros en la estructura correspondiente
    private static void cargarProductos(){
        for(int i=0 ; i<num_productos ; i++) {
            String producto = lector_pr.nextLine();
            String[] componentes = producto.split(" ");
            try {
                productos[i] = new Producto(componentes[0], Integer.parseInt(componentes[1]), Double.parseDouble(componentes[2]));
            } catch (NumberFormatException e) {
                System.out.println("ERROR");
            }
        }
    }

    //Carga los datos de las relaciones de los productos de los ficheros en la estructura correspondiente
    private static void cargarRelaciones(){
        for(int i=0 ; i<num_productos ; i++){
            String relacion = lector_re.nextLine();
            String[] componentes = relacion.split(" ");
            for(int j=0 ; j<componentes.length ; j++) {
                try {
                    Integer conexiones = Integer.parseInt(componentes[j]);
                    relaciones[i][j] = conexiones;
                } catch (NumberFormatException e) {}
            }
        }
    }

    //Introduce en el grafo [g] los productos y relaciones previamente cargados
    private static void cargarGrafo(Grafo g){
        for(int i=0 ; i<num_productos ; i++) {
            Vertice v = new Vertice(productos[i]);
            g.añadirVertice(v);
        }
        for(int i=0 ; i<num_productos ; i++){
            for(int j=0 ; j<i+1 ; j++) {
                try {
                    if(relaciones[i][j]>0 && i!=j){
                        Arista a = new Arista("p"+(j+1),"p"+(i+1), relaciones[i][j]);
                        g.añadirArista(a);
                    }
                } catch (NumberFormatException e) {}
            }
        }
    }

    //Ejecuta el algoritmo de Karger
    private static void Karger(Grafo g) {

        //Mientras queden mas de 2 vertices comprimimos dos al azar
        while (g.getNumVertices() > 2) {
            int arista = g.elegirArista();
            g.contraer(arista);
        }
    }
}

package Practica1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by adrian on 21/11/2016.
 */
public class Practica1 {

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

        cargarProductos();
        cargarRelaciones();

        //System.out.println("TABLA HASH PRODUCTOS: ");
        //System.out.println(th.toString());
        //System.out.println("TABLA DE RELACIONES: ");
        //for(int i=0 ; i<num_productos ; i++){
        //    for(int j=0 ; j<num_productos ; j++){
        //        System.out.printf(relaciones[i][j]+"  ");
        //    }
        //    System.out.println();
        //}
    }

    private static void cargarProductos(){
        for(int i=0 ; i<num_productos ; i++) {
            String producto = lector_pr.nextLine();
            String[] componentes = producto.split(" ");
            try {
                th.introducirProducto(new Producto(componentes[0], Integer.parseInt(componentes[1]), Double.parseDouble(componentes[2])));
            } catch (NumberFormatException e) {
                System.out.println("ERROR");
            }
        }
    }

    private static void cargarRelaciones(){
        for(int i=0 ; i<num_productos ; i++){
            String relacion = lector_re.nextLine();
            String[] componentes = relacion.split(" ");
            for(int j=0 ; j<componentes.length ; j++) {
                try {
                    relaciones[i][j] = Boolean.parseBoolean(componentes[j]);
                    relaciones[j][i] = Boolean.parseBoolean(componentes[j]);
                } catch (NumberFormatException e) {}
            }
        }
    }

    private static void Karger(){
        //Repetir n^2 veces
        //  Mientras queden mas de 2 nodos
        //    Elegir 2 nodos al azar
        //    Contraerlos en uno solo
        //  fMientras
        //  Si el numero de aristas([nuevas]) entre los dos es menor que las antes calculadas: [corte] = [nuevas];
        //fRepetir
        //El corte mínimo es [corte]

        //Coste(n^4)
        //Probabilidad de correcto sin repeticiones = 1/(n^2)
        //Probabilidad de correcto con repeticiones = (n^2) * 1/(n^2) = 1
    }
}

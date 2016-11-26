package generador_productos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Created by ALEX on 24/11/2016.
 */
public class GeneradorProductos {

    public static final int MAX_UNIDADES = 50000;
    public static final int MAX_PRECIO = 10000;

    public static void main(String[] args){

        if(args.length<3){
            System.err.println("Uso: java GeneradorProductos [num_productos] [fichero_productos] [fichero_relaciones]");
            System.exit(1);
        }

        int num_productos = -1;
        PrintWriter escritor_pr = null;
        PrintWriter escritor_re = null;

        try{
            num_productos = Integer.parseInt(args[0]);
            escritor_pr = new PrintWriter(new FileWriter(args[1]));
            escritor_re = new PrintWriter(new FileWriter(args[2]));
        }
        catch(IOException e1){
            System.err.println("No se ha podido generar alguno de los siguientes ficheros:\n\t- "+args[1]+"\n\t- "+args[2]);
            System.exit(1);
        }
        catch(NumberFormatException e2){
            System.err.println("El valor "+ num_productos + " no es un numero valido");
            System.exit(1);
        }

        Random r = new Random(System.currentTimeMillis());
        for(int i=1 ; i<=num_productos ; i++){
            String nombre = "p"+i;
            int unidades = 1+r.nextInt(MAX_UNIDADES);
            Double precio = r.nextDouble() * MAX_PRECIO;
            String p_String = precio.toString();

            escritor_pr.println(nombre+" "+unidades+" "+p_String.substring(0,p_String.lastIndexOf('.')+3));
        }
        escritor_pr.flush();
        escritor_pr.close();

        for(int i=0 ; i<num_productos ; i++){
            String lista = "";
            for(int j=i ; j<num_productos ; j++){
                lista = lista + r.nextBoolean() + " ";
            }
            escritor_re.println(lista);
        }
        escritor_re.flush();
        escritor_re.close();
    }
}

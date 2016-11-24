package generador_productos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * Created by ALEX on 24/11/2016.
 */
public class GeneradorProductos {

    public static final int MAX_UNIDADES = 50000;
    public static final int MAX_PRECIO = 10000;

    public static void main(String[] args){

        if(args.length<2){
            System.err.println("Uso: java GeneradorProductos [num_productos] [fichero]");
            System.exit(1);
        }

        int num_productos = -1;
        PrintWriter escritor = null;

        try{
            num_productos = Integer.parseInt(args[0]);
            escritor = new PrintWriter(new FileWriter(args[1]));
        }
        catch(IOException e1){
            System.err.println("No se ha podido generar el fichero: "+args[1]);
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

            escritor.println(nombre+"\t"+unidades+"\t"+p_String.substring(0,p_String.lastIndexOf('.')+3));
        }
        escritor.flush();
        escritor.close();
    }
}

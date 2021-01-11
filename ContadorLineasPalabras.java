import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.io.StreamTokenizer;

public class ContadorLineasPalabras {

    static int importTotales = 0;
    static int lineasTotales = 0;
    static int tareasTotales = 0;
    
    public static void main(String[] args) {
       
        //RUTA DEL ARCHIVO A LEER
        File archivo = new File("/Users/Sonatadev/Documents/WhissJava/Contador/ContadorLineasPalabras.java");
        //Con esto se llama al metodo para conteo
        contarPalabrasLineas(archivo);
    }
 
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
       
        //Ruta de archivo a leer
        File archivo = new File("/Users/Sonatadev/Documents/WhissJava/Contador/ContadorLineasPalabras.java");
        //Con esto se llama al metodo para conteo
        contarPalabrasLineas(archivo);
    }
 //Metodo para leer archivos y conteo de cada palabra
    public static void contarPalabrasLineas(File archivo) {
      try {
        // SI EXISTE EL ARCHIVO
        if(archivo.exists()) {
            // ABRE LECTURA
            BufferedReader archivoLeer = new BufferedReader(new FileReader(archivo));
            
            String lineaLeida = null;
            
            // MIENTRAS LA LINEA LEIDA NO SEA NULL
            while((lineaLeida = archivoLeer.readLine()) != null) {
                // System.out.println(lineaLeida);
                
                // CONTAMOS LAS PALABRAS DE LA LINEA
                StringTokenizer letrero = new StringTokenizer(lineaLeida);
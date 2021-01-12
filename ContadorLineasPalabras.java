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
        // Empieza lectura
        if(archivo.exists()) {
            
            BufferedReader archivoLeer = new BufferedReader(new FileReader(archivo));
            
            String lineaLeida = null;
            
            while((lineaLeida = archivoLeer.readLine()) != null) {
                // System.out.println(lineaLeida);
                
                // Conteo de palabras
                StringTokenizer letrero = new StringTokenizer(lineaLeida);
                // Arreglo para el evitar que el programa cuente cosas innecesarias (*//import)
                if ((letrero.countTokens() !=0 ) && (lineaLeida.indexOf("*") == -1) && (lineaLeida.indexOf("//") == -1) && (lineaLeida.length() > 0) && (lineaLeida.indexOf("import") == -1)){
                    
                    // Aumento en el contador de lineas
                    lineasTotales = lineasTotales + 1;
                }
            }
                System.out.println("");
                System.out.println("Lineas totales: " + lineasTotales);
                System.out.println("Import's totales: " + importTotales);
                System.out.println("Tareas totales: " + tareasTotales);
                // Termina Lectura
                archivoLeer.close();
            } else {
                System.out.println("NO EXISTE EL ARCHIVO");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
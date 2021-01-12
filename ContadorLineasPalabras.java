import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.io.StreamTokenizer;
import java.util.Scanner; // Librería para ingresar datos (desde consola)

public class ContadorLineasPalabras {
    // Variables estáticas de inicio
    static int mainTotales = 0;
    static int lineasTotales = 0;
    static int tareasTotales = 0;
    
    public static void main(String[] args) {
        // Acción para entroducir texto (dirección de archivos)
        Scanner scanner = new Scanner(System.in);
        // Se agrega la ruta del archivo a analizar o evaluar
        System.out.printf("\nNombre del Archivo: ");
        String archivero = scanner.nextLine();
       
        //Ruta de archivo a leer
        File archivo = new File(archivero);
        //Con esto se llama al metodo para conteo
        contarPalabrasLineas(archivo);
    }
 //Metodo para leer archivos y conteo de cada palabra
    public static void contarPalabrasLineas(File archivo) {
      try { // Se utiliza cuando se desean prever (clarividencia) excepciones en el transcurso de un programa
        // Empieza lectura
        if(archivo.exists()) {
            // Es una clase para leer el texto de una secuencia de entrada, luego lo almacena en un búfer de caracteres.
            BufferedReader archivoLeer = new BufferedReader(new FileReader(archivo));
            
            String lineaLeida = null;
            
            while((lineaLeida = archivoLeer.readLine()) != null) {
                // System.out.println(lineaLeida);
                
                // Conteo de palabras
                StringTokenizer letrero = new StringTokenizer(lineaLeida);
                // Arreglo para evitar que el programa cuente cosas innecesarias (*//import)
                if ((letrero.countTokens() !=0 ) && (lineaLeida.indexOf("*") == -1) && (lineaLeida.indexOf("//") == -1) && (lineaLeida.length() > 0) && (lineaLeida.indexOf("import") == -1)){    
                    // Aumento en el contador de lineas
                    lineasTotales ++;
                
                // Arreglo para evitar que el programa cuente cosas que no sean main's o que evite las palabras de más de main's    
                if ((lineaLeida.indexOf("main") != -1 ) && (lineaLeida.indexOf("if") == -1) && (lineaLeida.indexOf("System.out.println") == -1) && (lineaLeida.indexOf("mainTotales") == -1)){
                    // Aumento en el contador de "main's"   
                    mainTotales ++;

                // Arreglo para evitar que el programa cuente cosas que no sean las clases    
                if ((lineaLeida.indexOf("public static") != -1 ) && (lineaLeida.indexOf("if") == -1) && (lineaLeida.indexOf("main") == -1)){
                    // Amuento en el contador de clases (tareas)
                    tareasTotales ++;
                        }
                    }
                }
            }
                System.out.println("");
                System.out.println("Lineas totales: " + lineasTotales);
                System.out.println("Main's totales: " + mainTotales);
                System.out.println("Tareas totales: " + tareasTotales);
                System.out.println("");
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
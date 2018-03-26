package utilidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import objetos.Usuario;

/**
 * <p>Esta clase tiene por función todo el proceso realzado con los archivos.
 * <br>Tiene tres métodos:</p>
 * <ol>
 * <li>Método: formatoSO(String ruta) esté método devuelve la ruta de los archivos en función del Sistema Operativo.</li>
 * <li>Método: creaDirectorios(File file) este método crea los directorios y/o archivos necesarios si no existen. Si existen informa de que están preparados.</li>
 * <li>Método: escribirDatos(Usuario usuario) este método escribe los datos de un nuevo usuario en el archivo Datos_del_Programa/datos.txt</li>
 * </ol>
 * @author José Francisco Sánchez Portillo
 */
public class Archivos {

    // Se crea el archivo para guardar los datos de los usuarios:
    private final String PATH_DATOS = Archivos.formatoSO("./Datos_del_Programa/datos.txt");
    private File fdatos;
    // Se crea el archivo para guardar el logger:
    private final String PATH_LOGGER = Archivos.formatoSO("./Datos_de_Logger/logger.log");
    private File fLogger;

    /**
     * Método constructor crea los archivos y directorios necesarios para la ejecución de la aplicación.
     */
    public Archivos() {
        // Crear los archivos/ directorios si no estuvieran creados
        fdatos = new File(PATH_DATOS);
        creaDirectorios(fdatos);
        // Crear los archivos/ directorios si no estuvieran creados
        fLogger = new File(PATH_LOGGER);
        creaDirectorios(fLogger);
    }
    
    /**
     * Método para escribir los datos del nuevo usuario.
     * 
     * @param usuario Se pasa la instancia del objeto Usuario para registrarlo en el archivo Datos_del_Programa/datos.txt
     */
    public void escribirDatos(Usuario usuario) {
        try {
            FileWriter fw = new FileWriter(fdatos, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(usuario.toString());
            pw.close();
            fw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error archivo de Datos no encontrado en escritura: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error de escritura en Datos: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error general de Datos en escritura: " + ex.getMessage());
        }
    }

    /**
     * Crear los directorios necesarios para poder crear el archivo que es
     * pasado por parámetro.
     *
     * @param file Ruta donde va a estar el archivo y el archivo nombre y
     * extensión.
     */
    private void creaDirectorios(File file) {
        // Se comprueba que los directorios existen y si no se crean:
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
            System.out.println("Se han creado los directorios necesarios para albergar: " + file.getParent());
        }
        // Se comprueba que existe el archivo y si no se crea: 
        if (!file.exists()) {
            ES.msgln("La aplicación no tiene datos grabados: Archivo " + file.getName());
            try {
                file.createNewFile();
            } catch (Exception e) {
                System.out.println("\nError al crear el archivo: " + e.getMessage());
            }
        }
        ES.msgln("El archivo " + file.getName() + " está preparado y listo para ser usado.\n");
    }

    /**
     * Método estático que devuelve la ruta formateada si el Sistema Operativo
     * es Windows, y si no lo es devuelve la ruta tal cual.
     *
     * @param ruta Ruta al archivo exterior al proyecto.
     * @return la Ruta formateada en caso de que la ejecución se realice desde
     * Windows
     */
    public static String formatoSO(String ruta) {
        String separador;

        try {
            if (File.separator.equals("\\")) { // Si es cierto es Windows:
                separador = "\\";
                return ruta.replace("/", separador);
            } else { // Y si es falso, es cualquier otro:
                return ruta;
            }
        } catch (Exception e) {
            System.err.println("Error de conversión de ruta. Descripción: " + e.getMessage());
            return ruta;
        }
    }
}

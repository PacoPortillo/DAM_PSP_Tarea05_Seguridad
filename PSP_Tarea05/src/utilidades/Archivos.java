package utilidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import objetos.Usuario;

/**
 *
 * @author Admin
 */
public class Archivos {

    private final String PATH_DATOS = formatoSO("./Datos_del_Programa/datos.txt");
    private File fdatos;

    public Archivos() {
        fdatos = new File(PATH_DATOS);
        creaDirectorios(fdatos);
    }
    
    

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
     * Crea los directorios necesarios para poder crear el archivo que servirá
     * de Almacén de la aplicación.
     *
     * @param file Ruta donde va a estar el archivo que va a sevir de Almacen.
     */
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
    private String formatoSO(String ruta) {
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

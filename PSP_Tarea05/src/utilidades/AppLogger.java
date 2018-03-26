package utilidades;

import java.io.IOException;
import java.util.logging.*;

/**
 * <p>Clase Looger:
 * <br>Crea un fichero que permite realizar un seguimiento de la aplicación.
 * <br>Control de eventos que ocurren en la ejecución.</p>
 * 
 * @author José Francisco Sánchez Portillo
 */
public class AppLogger {

    /**
     * Método estático para registrar el Log.
     * 
     * @param level nivel de seguridad de las actividades.
     * @param msg mensaje del evento.
     */
    public static void logger(Level level, String msg) {

        Logger logger = Logger.getLogger("utilidades.AppLogger");
        FileHandler fh;
        try {
            // Configuro el logger y establezco el formato
            fh = new FileHandler( Archivos.formatoSO("./Datos_de_Logger/logger.log"), true);
            logger.addHandler(fh);
            logger.setLevel(Level.ALL);
            // Si lo queremos en fichero de txto simple:
            SimpleFormatter formatter = new SimpleFormatter();
            // Si lo queremos en formato xml
            //XMLFormatter formatter = new XMLFormatter();
            fh.setFormatter(formatter);

            // Añado un mensaje al log   
            logger.log(level,msg);
            
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (IOException ex) {
            ex.printStackTrace();
            }
        }
    
    // Añado un mensaje al log   
    //logger.log(Level.SEVERE,"7 máxima");
    //logger.log(Level.WARNING,"6");
    //logger.log(Level.INFO,"5");
    //logger.log(Level.CONFIG,"4");
    //logger.log(Level.FINE,"3");
    //logger.log(Level.FINER,"2");
    //logger.log(Level.FINEST,"1 mínima");
    
    // Ejemplo de uso: (colocar en cualquier parte del programa)
    //AppLogger.logger(Level.FINEST, "Se inicia el proceso de registro de usuario:");

}



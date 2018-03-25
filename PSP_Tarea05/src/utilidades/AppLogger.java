package utilidades;

import java.io.IOException;
import java.util.logging.*;

/**
 *
 * @author Admin
 */
public class AppLogger {

    public static void logger(Level level, String msg) {

        Logger logger = Logger.getLogger("utilidades.AppLogger");
        FileHandler fh;
        try {
            // Configuro el logger y establezco el formato
            fh = new FileHandler( Archivos.formatoSO("./Datos_de_Logger/logger.log"), true);
            logger.addHandler(fh);
            logger.setLevel(Level.ALL);
            SimpleFormatter formatter = new SimpleFormatter();
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

}



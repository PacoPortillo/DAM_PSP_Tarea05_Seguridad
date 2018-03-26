package main;

import java.util.logging.Level;
import objetos.Usuario;
import seguridad.ValidaLogin;
import utilidades.AppLogger;
import utilidades.Archivos;
import utilidades.ES;

/**
 * <p>Clase Principal que inicia la aplicación<br>Realiza los siguientes procesos:</p>
 * <ol>
 * <li>Crea una instancia de la clase {@link Archivos}
 * <ul>
 * <li>Esta clase genera los directorios y archivos Datos_del_Programa/datos.txt y Datos_de_Logger/logger.log</li>
 * </ul></li>
 * <li>Realizaa el proceso de validación de un {@link Usuario}, creando una instancia de {@link ValidaLogin} y utilizando sus dos métodos de validación.</li>
 * <li>Finalmente si la validación es correcta crea el {@link Usuario}</li>
 * <li>Fin de la ejecución del programa.</li>
 * </ol>
 * <p>Ver los archivos:</p>
 * <ul>
 * <li>Datos_del_Programa/<strong>datos.txt</strong>: contienen los usuarios que se han creado.</li>
 * <li>Datos_de_Logger/<strong>logger.log</strong>: contiene el registro log del programa.</li>
 * </ul>
 * 
 * @author José Francisco Sánchez Portillo
 */
public class Main {

    /**
     * Método Main, contiene la ejecución de la aplicación comienzo y final.
     * 
     * @param args No maneja argumentos que reciba por consola.
     */
    public static void main(String[] args) {
        // Crear los directorios y archivos para guardar los datos y reflejar los logs del programa:
        Archivos archivos = new Archivos();

        AppLogger.logger(Level.FINEST, "======================================== Se inicia el proceso de registro de usuario:\n");

        String email = "";
        String nombre = "";
        String apellidos = "";
        String phone = "";
        String fechaNac = "";
        int cpostal = 0;

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ValidaLogin vl = new ValidaLogin();
        
        // Primer método de validación: Email
        do {
            email = ES.leeCadena("Correo:\nFormato usuario@servidor.dominio\n"
                    + "usuario: máximo 8 caracteres, letras, números y/o el carácter '_', el primer carácter debe ser una letra minúscula\n"
                    + "servidor: letras y números\n"
                    + "dominio: máximo 3 carácteres.\n"
                    + "Escribe tu correo: ");
            //System.out.println("Escribe tu correo: ");
            //email = br.readLine();
        } while (!vl.val_email(email));

        // Segundo método de validación el resto de los datos del usuario:
        boolean[] b = new boolean[]{false, false, false, false, false};
        do {
            if (!b[0]) {
                nombre = ES.leeCadena("Escribe tu nombre: (Sólo letras y espacios, máximo 15 caracteres)");
            }
            if (!b[1]) {
                apellidos = ES.leeCadena("Escribe tus apellidos: (Sólo letras y espacios, máximo 15 caracteres)");
            }
            if (!b[2]) {
                phone = ES.leeCadena("Escribe tu teléfono: (Formato 999/999/999)");
            }
            if (!b[3]) {
                fechaNac = ES.leeCadena("Escribe tu fecha de nacimiento: (Formato dd/mm/yyyy)");
            }
            if (!b[4]) {
                cpostal = ES.leeEntero("Escribe tu código postal: (Formato 99999)");
            }
            ES.msgln("\n");
            b = vl.val_usuario(nombre, apellidos, phone, fechaNac, cpostal);
            ES.msgln("\n");
        } while (!b[0] || !b[1] || !b[2] || !b[3] || !b[4]);

        // Finalmente si todo es correcto se crea el usuario, se guarda y finaliza el programa.
        ES.msg("\n\nDatos del usuario correctos:\n");
        Usuario u = new Usuario(email, nombre, apellidos, phone, fechaNac, cpostal);
        ES.msg(u.toString());
        AppLogger.logger(Level.CONFIG, "\n\n" + u.toString());
        archivos.escribirDatos(u);
        ES.msg("\nEl usuario ha sido registrado con éxito.\n\n");
        AppLogger.logger(Level.FINEST, "\nUsuario registrado con éxito.\n");
    }

}

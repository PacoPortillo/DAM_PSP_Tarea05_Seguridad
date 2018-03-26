package seguridad;

import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utilidades.AppLogger;

/**
 * <p>Clase que valida los datos de los {@link objetos.Usuario}<br>
 * Contiene dos métodos:</p>
 * <ol>
 * <li>Método val_email: sirve para validar el email.</li>
 * <li>Método val_usuario: sirve para validar el resto de los datos del usuario.</li>
 * </ol>
 * 
 * @author José Francisco Sánchez Portillo
 */
public class ValidaLogin {
    
    private Pattern pat = null;
    private Matcher mat = null;
    
    /**
     * Este método valida un Email como correcto en base a un patrón.
     * Reglas de formato:
     * Formato: usuario@servidor.dominio
     * usuario: máximo 8 caracteres, letras, números o '_' Primer carácter siempre letra minúscula.
     * servidor: cadena formada por letras y numeros 
     * dominio: máximo 3 caracteres (entendiendo por caracteres sólo las letras) (por tanto sólo admite un primer dominio de nivel superior)
     * 
     * @param email recibe por parámetro el Email introducido por el usuario
     * @return true si el email es correcto y false si no lo es.
     */
    public boolean val_email(String email){
        
        //String patron = "^[a-z]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String patron = "^[a-z]{1}[_A-Za-z0-9]{0,7}@([A-Za-z0-9]+)(\\.[A-Za-z]{1,3})$";
        
        pat = Pattern.compile(patron);
        mat = pat.matcher(email);
        
        if(mat.matches()){
            System.out.println("El email es correcto\n");
            AppLogger.logger(Level.CONFIG, "El email es correcto\n");
            return true;
        } else {
            System.out.println("El email " + email + " es incorrecto\n");
            AppLogger.logger(Level.FINE, "El email " + email + " es incorrecto\n");
            return false;
        }
        //return mat.matches();
    }
    
    /**
     * Este método valida los datos como correctos en base a unos patrones.
     * Reglas de formato:
     * Nombre y Apellidos: cadena de caracteres que puede incluir el espacio y una longitud máxima de 15.
     * Teléfono: 999/999/999.
     * Fecha de nacimiento: la fecha será correcta según el formato dd/mm/yyyy.
     * Código postal: 99999
     * 
     * @param nombre recibe por parámetro el nombre introducido por el usuario
     * @param apellidos recibe por parámetro los apellidos introducidos por el usuario
     * @param phone recibe por parámetro el teléfono introducido por el usuario
     * @param fechaNac recibe por parámetro la fecha de nacimiento introducida por el usuario
     * @param cpostal recibe por parámetro el Código Postal introducido por el usuario
     * @return un Array de tipo boolean con True si ha sido correcto el dato y False si no lo ha sido,
     * siendo la posición del array: 0 nombre, 1 apellidos, 2 teléfono, 3 fechaNacimeinto y 4 códigoPostal.
     */
    public boolean[] val_usuario(String nombre, String apellidos, String phone, String fechaNac, int cpostal){
        
        boolean[] b = new boolean[5];
        
        String patron_nombre = "^[A-Za-zñÑáéíóúÁÉÍÓÚ]{1}[A-Za-zñÑáéíóúÁÉÍÓÚ\\s]{1,14}$";
        String patron_phone = "^[0-9]{3}/([0-9]{3})/([0-9]{3})$";
        String patron_fechaNac = "^[0-9]{2}/([0-9]{2})/([0-9]{4})$";
        String patron_cpostal = "^[0-9]{5}$";
        
        // Nombre
        pat = Pattern.compile(patron_nombre);
        mat = pat.matcher(nombre);
        
        if(mat.matches()){
            System.out.println("El nombre es correcto");
            AppLogger.logger(Level.CONFIG, "El nombre es correcto");
            b[0] = true;
        } else {
            System.out.println("El nombre " + nombre + " es incorrecto");
            AppLogger.logger(Level.FINE, "El nombre " + nombre + " es incorrecto");
            b[0] = false;
        }
        
        // Apellidos
        pat = Pattern.compile(patron_nombre);
        mat = pat.matcher(apellidos);
        
        if(mat.matches()){
            System.out.println("Los apellidos son correctos");
            AppLogger.logger(Level.CONFIG, "Los apellidos son correctos");
            b[1] = true;
        } else {
            System.out.println("Los apellidos " + apellidos + " son incorrectos");
            AppLogger.logger(Level.FINE, "Los apellidos " + apellidos + " son incorrectos");
            b[1] = false;
        }
        
        // Phone
        pat = Pattern.compile(patron_phone);
        mat = pat.matcher(phone);
        
        if(mat.matches()){
            System.out.println("El teléfono es correcto");
            AppLogger.logger(Level.CONFIG, "El teléfono es correcto");
            b[2] = true;
        } else {
            System.out.println("El teléfono " + phone + " es incorrecto");
            AppLogger.logger(Level.FINE, "El teléfono " + phone + " es incorrecto");
            b[2] = false;
        }
        
        // Fecha de nacimiento
        pat = Pattern.compile(patron_fechaNac);
        mat = pat.matcher(fechaNac);
        
        if(mat.matches()){
            System.out.println("La fecha de nacimiento es correcta");
            AppLogger.logger(Level.CONFIG, "La fecha de nacimiento es correcta");
            b[3] = true;
        } else {
            System.out.println("La fecha de nacimiento " + fechaNac + " es incorrecta");
            AppLogger.logger(Level.FINE, "La fecha de nacimiento " + fechaNac + " es incorrecta");
            b[3] = false;
        }
        
        // Código Postal
        pat = Pattern.compile(patron_cpostal);
        mat = pat.matcher(Integer.toString(cpostal));
        
        if(mat.matches()){
            System.out.println("El código postal es correcto");
            AppLogger.logger(Level.CONFIG, "El código postal es correcto");
            b[4] = true;
        } else {
            System.out.println("El código postal " + cpostal + " es incorrecto");
            AppLogger.logger(Level.FINE, "El código postal " + cpostal + " es incorrecto");
            b[4] = false;
        }
        
        return b;
    }
}

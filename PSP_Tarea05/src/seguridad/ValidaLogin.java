package seguridad;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class ValidaLogin {
    
    private Pattern pat = null;
    private Matcher mat = null;
    
    public boolean val_email(String email){
        
        //String patron = "^[a-z]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String patron = "^[a-z]{1}[_A-Za-z0-9]{0,7}@([A-Za-z0-9]+)(\\.[A-Za-z]{1,3})$";
        
        pat = Pattern.compile(patron);
        mat = pat.matcher(email);
        
        if(mat.matches()){
            System.out.println("El email es correcto\n");
            return true;
        } else {
            System.out.println("El email " + email + " es incorrecto\n");
            return false;
        }
        //return mat.matches();
    }
    
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
            b[0] = true;
        } else {
            System.out.println("El nombre " + nombre + " es incorrecto");
            b[0] = false;
        }
        
        // Apellidos
        pat = Pattern.compile(patron_nombre);
        mat = pat.matcher(apellidos);
        
        if(mat.matches()){
            System.out.println("Los apellidos son correctos");
            b[1] = true;
        } else {
            System.out.println("Los apellidos " + apellidos + " son incorrectos");
            b[1] = false;
        }
        
        // Phone
        pat = Pattern.compile(patron_phone);
        mat = pat.matcher(phone);
        
        if(mat.matches()){
            System.out.println("El teléfono es correcto");
            b[2] = true;
        } else {
            System.out.println("El teléfono " + phone + " es incorrecto");
            b[2] = false;
        }
        
        // Fecha de nacimiento
        pat = Pattern.compile(patron_fechaNac);
        mat = pat.matcher(fechaNac);
        
        if(mat.matches()){
            System.out.println("La fecha de nacimiento es correcta");
            b[3] = true;
        } else {
            System.out.println("La fecha de nacimiento " + fechaNac + " es incorrecta");
            b[3] = false;
        }
        
        // Código Postal
        pat = Pattern.compile(patron_cpostal);
        mat = pat.matcher(Integer.toString(cpostal));
        
        if(mat.matches()){
            System.out.println("El código postal es correcto");
            b[4] = true;
        } else {
            System.out.println("El código postal " + cpostal + " es incorrecto");
            b[4] = false;
        }
        
        return b;
    }
}

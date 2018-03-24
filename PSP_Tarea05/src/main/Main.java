package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Usuario;
import seguridad.ValidaLogin;
import utilidades.Archivos;
import utilidades.ES;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Archivos archivos = new Archivos();
        
        String email = "";
        String nombre = "";
        String apellidos = "";
        String phone = "";
        String fechaNac = "";
        int cpostal = 0;
        
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        ValidaLogin vl = new ValidaLogin();
        
        do {            
            email = ES.leeCadena("Correo:\nFormato usuario@servidor.dominio\n"
                    + "usuario: máximo 8 caracteres, letras, números y/o el carácter '_', el primer carácter debe ser una letra minúscula\n"
                    + "servidor: letras y números\n"
                    + "dominio: máximo 3 carácteres.\n"
                    + "Escribe tu correo: ");
            //System.out.println("Escribe tu correo: ");
            //email = br.readLine();
        } while (!vl.val_email(email));
        
        
        
        boolean[] b = new boolean[]{false, false, false ,false, false};
        do { 
            if(!b[0]) nombre = ES.leeCadena("Escribe tu nombre: (Sólo letras y espacios, máximo 15 caracteres)");
            if(!b[1]) apellidos = ES.leeCadena("Escribe tus apellidos: (Sólo letras y espacios, máximo 15 caracteres)");
            if(!b[2]) phone = ES.leeCadena("Escribe tu teléfono: (Formato 999/999/999)");
            if(!b[3]) fechaNac = ES.leeCadena("Escribe tu fecha de nacimiento: (Formato dd/mm/yyyy)");
            if(!b[4]) cpostal = ES.leeEntero("Escribe tu código postal: (Formato 99999)");
            ES.msgln("\n");
            b = vl.val_usuario(nombre, apellidos, phone, fechaNac, cpostal);
            ES.msgln("\n");
        } while (!b[0] || !b[1] || !b[2] || !b[3] || !b[4]);
        
        ES.msg("\n\nDatos del usuario correctos:\n");
        Usuario u = new Usuario(email, nombre, apellidos, phone, fechaNac, cpostal);
        ES.msg(u.toString());
        archivos.escribirDatos(u);
        ES.msg("\nEl usuario ha sido registrado con éxito.\n\n");
    }
    
}

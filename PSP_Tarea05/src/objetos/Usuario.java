package objetos;

/**
 * Crea un Usuario para la aplicación:
 * <p>Este usuario contiene:</p>
 * <ol>
 * <li>Email</li>
 * <li>Nombre</li>
 * <li>Apellidos</li>
 * <li>Teléfono</li>
 * <li>Fecha de nacimiento</li>
 * <li>Código Postal</li></ol>
 * 
 * @author José Francisco Sánchez Portillo
 */
public class Usuario {
    
    private String email;
    private String nombre;
    private String apellidos;
    private String phone;
    private String fechaNac;
    private int cpostal;

    // Constructor
    public Usuario(String email, String nombre, String apellidos, String phone, String fechaNac, int cpostal) {
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.phone = phone;
        this.fechaNac = fechaNac;
        this.cpostal = cpostal;
    }

    // Getters & Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getCpostal() {
        return cpostal;
    }

    public void setCpostal(int cpostal) {
        this.cpostal = cpostal;
    }

    /**
     * Méodo toString del Usuario.
     * @return Los valores del usuario listos para imprimir.
     */
    @Override
    public String toString() {
        return "\nUsuario:\n\t" + "Email : " + email + "\n\tNombre : " + nombre 
                + "\n\tApellidos : " + apellidos + "\n\tTeléfono : " + phone 
                + "\n\tFecha de nacimiento : " + fechaNac + "\n\tCódigo Postal : " + cpostal + ".\n";
    }
    
    
    
}

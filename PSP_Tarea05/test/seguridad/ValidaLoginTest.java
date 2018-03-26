package seguridad;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author Admin
 */
@RunWith(value = Parameterized.class)
public class ValidaLoginTest {
    
    // Parámetros de datos:
    private final String email, nombre, apellidos, phone, fechaNac;
    private final int cpostal;
    //Parámetros de resultados:
    private final boolean email_result;
    private final boolean [] user_result = new boolean[5];
    
    @Parameters
    public static Iterable<Object[]> getData(){
        return Arrays.asList(new Object[][]{
            {"antonios@test.com", true, "Juan Carlos", "Díaz Nuñez", "123/123/123", "06/12/1969", 26002, true, true, true, true, true},
            {"antonio@test.com", true, "Juan Carlosxxxx", "Díaz Nuñezxxxxx", "698/698/698", "06/11/1969", 26009, true, true, true, true, true},
            {"antonio@test.es", true, "Ju", "Ca", "698/698/698", "06/11/1969", 26009, true, true, true, true, true},
            {"antonio@test.u", true, "ju", "ca", "698/698/698", "06/11/1969", 26009, true, true, true, true, true},
            {"antonio@test2test.com", true, "Juan2 Carlos", "Díaz2 Nuñez", "123/123/123/", "06/12/1969/", 6002, false, false, false, false, false},
            {"ant_onio@test.com", true, "Juan Carlosxxxx1", "Díaz Nuñezxxxxx1", "698/698/69", "06/11/196", 260090, false, false, false, false, false},
            {"aNT_onio@test.com", true, "J", "C", "98/698/698", "6/11/1969", 206, false, false, false, false, false},
            {"antonio@TEST.com", true, " ju", " ca", "698//98/698", "06//1/1969", 9, false, false, false, false, false},
            {"antonio@TEST.COM", true, "2ju", "3ca", "698/68/698", "06/11/969", 426009, false, false, false, false, false},
            {"aNTONIOS@TEST.ES", true, "", "", "", "", 0, false, false, false, false, false},
            {"+antonio@test.com", false, "", "", "", "", 0, false, false, false, false, false},
            {"_antonio@test.com", false, "", "", "", "", 0, false, false, false, false, false},
            {"Antonio@test.com", false, "", "", "", "", 0, false, false, false, false, false},
            {"2ntonio@test.com", false, "", "", "", "", 0, false, false, false, false, false},
            {" antonio@test.com", false, "", "", "", "", 0, false, false, false, false, false},
            {"antonioss@test.u", false, "", "", "", "", 0, false, false, false, false, false},
            {"antonios@test.", false, "", "", "", "", 0, false, false, false, false, false},
            {"antonios@test", false, "", "", "", "", 0, false, false, false, false, false},
            {"antonios@test.info", false, "", "", "", "", 0, false, false, false, false, false},
            {"antonios@test.c2m", false, "", "", "", "", 0, false, false, false, false, false},
            {"antonios@test.c_m", false, "", "", "", "", 0, false, false, false, false, false},
            {"antonio@test.com.uk", false, "", "", "", "", 0, false, false, false, false, false},
            {"antonio@test..uk", false, "", "", "", "", 0, false, false, false, false, false},
            {"antonio@test_test.com", false, "", "", "", "", 0, false, false, false, false, false},
            {"antonio@@test.com", false, "", "", "", "", 0, false, false, false, false, false},
            {"antoniotest.com", false, "", "", "", "", 0, false, false, false, false, false},
            {"antonio@.test.com", false, "", "", "", "", 0, false, false, false, false, false},
            {"ant.onio@test.com", false, "", "", "", "", 0, false, false, false, false, false}
        });
    }


    public ValidaLoginTest(String email, boolean email_result, String nombre, String apellidos, String phone, String fechaNac, int cpostal, 
            boolean user_result00, boolean user_result01, boolean user_result02, boolean user_result03, boolean user_result04) {
        this.email = email;
        this.email_result = email_result;
        
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.phone = phone;
        this.fechaNac = fechaNac;
        this.cpostal = cpostal;
        this.user_result[0] = user_result00;
        this.user_result[1] = user_result01;
        this.user_result[2] = user_result02;
        this.user_result[3] = user_result03;
        this.user_result[4] = user_result04;
    }
    

    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("Inicia Test: *****************************************");
    }
    
    @After
    public void tearDown() {
        System.out.println("Finaliza Test. **************************************\n\n");
    }

    /**
     * Test of val_email method, of class ValidaLogin.
     */
    @Test
    public void testVal_email() {
        System.out.println("Validar email: " + email);
        ValidaLogin instance = new ValidaLogin();
        boolean result = instance.val_email(email);
        System.out.println("El email " + email + " es: " + result);
        assertEquals(email_result, result);
    }

    /**
     * Test of val_usuario method, of class ValidaLogin.
     */
    @Test
    public void testVal_usuario() {
        System.out.println("Validar usuario=> Nombre: " + nombre + ", Apelliedos: " + apellidos + ", Teléfono: " + phone 
                + ", Fecha de nacimiento: " + fechaNac + ", Código Postal: " + cpostal);
        ValidaLogin instance = new ValidaLogin();
        boolean[] result = instance.val_usuario(nombre, apellidos, phone, fechaNac, cpostal);
        assertArrayEquals(user_result, result);
    }
    
}

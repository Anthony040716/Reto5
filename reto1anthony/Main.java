
package reto1anthony;
import Vistas.*;
import Modelo.*;
public class Main {

    public static void main(String[] args) {
        // llamar clase conexion para BD
        Conexion conexionBD = new Conexion ();
        
        // creamos la isntacia de vista login 
        Login login = new Login();
        // el metodo setVisible hace visible la ventana
        login.setVisible(true);
        
        Conexion conexion = new Conexion();
        conexion.getConnection();
    }
    
}

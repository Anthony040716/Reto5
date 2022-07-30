
package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
    Connection connection;
    //Atributos
    String driver = "com.mysql.cj.jdbc.Driver";
    String cadenaConexion = "jdbc:mysql://localhost:3306/reto1_g53";
    String usuario = "root";
    String contrasena = "";
    
    //contructor sin arqs de la clase
    public Conexion (){
        // conectar con la base de datos
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(cadenaConexion, usuario, contrasena);
            if (connection != null){
                System.out.println("Conexion Exitosa Con La Base de Datos: ");
            }          
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("No Se Pudo Establecer Conexion Con La Base De Datos");
            
        }
    }
    //Funcion retorno la clase conexion 
    public Connection getConnection(){
        return connection;
    }

}

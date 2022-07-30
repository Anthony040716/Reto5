
package Controlador;

import Modelo.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ComboboxSucursal {
    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    ResultSet rs;

    public ComboboxSucursal() {
        
    }
    
    public ArrayList getListaSucursales (){
        System.out.println("Funcion getListaSucursales () ");
        ArrayList mListaSucursal = new ArrayList();
        Sucursal sucursal = null;
        
        try{
            connection = conexion.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery("SELECT idSucursal, nombreSucursal FROM sucursal");
            while (rs.next()){
                sucursal = new Sucursal();
                sucursal.setIdSucursal(rs.getInt("idSucursal"));
                sucursal.setNombreSucursal(rs.getString("nombreSucursal"));
                mListaSucursal.add(sucursal); 
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return mListaSucursal;
    }
}

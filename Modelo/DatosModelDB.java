
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatosModelDB {
    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    PreparedStatement pst;
    ResultSet rs;
    ArrayList list = new ArrayList();
    DatosSucursalPuestoTrabajo datosDB;
    
    public ArrayList<DatosSucursalPuestoTrabajo> getSucursales() {
        ArrayList listaSucursales = new ArrayList();
	
        String query = "SELECT idSucursal, nombreSucursal FROM sucursal;";
	//trycatch 
        try {
            connection = conexion.getConnection();
	    
            pst = connection.prepareStatement(query);
	    
	    System.out.println("PST sucursal: "+pst);
            rs = pst.executeQuery();
	    
	    
            while (rs.next()) {
                datosDB = new DatosSucursalPuestoTrabajo();
                int idSucursalC = rs.getInt("idSucursal");
		System.out.println(idSucursalC);
                String nombreSucursal = rs.getString("nombreSucursal");
                datosDB.setIdSucursal(idSucursalC);
                datosDB.setNombreSucursal(nombreSucursal);
                listaSucursales.add(datosDB);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println("Sucursales lista: " + listaSucursales);
	
        return listaSucursales;
    }
    
    
     public ArrayList<DatosSucursalPuestoTrabajo> getPuestosTrabajos(int idSucursal) {
        
        ArrayList listPuestosTrabajo = new ArrayList();
	
	String queryPuestoTrabajo = "SELECT idPuestoTrabajo, nombrePuestoTrabajo, salario, FK_idSucursal FROM puestotrabajo INNER JOIN sucursal ON (idSucursal = FK_idSucursal) WHERE idSucursal = ? ;";
        //print query
	System.out.println(queryPuestoTrabajo);
	
	try {
            connection = conexion.getConnection();
            pst = connection.prepareStatement(queryPuestoTrabajo);
	    System.out.println(pst);
	    
            pst.setInt(1,idSucursal);
	    
	    System.out.println("pst int 1: "+pst);
            rs = pst.executeQuery();
	    System.out.println("rs: "+rs);
	    
            while (rs.next()) {
                datosDB = new DatosSucursalPuestoTrabajo();
                int idPuestoTrabajo = rs.getInt("idPuestoTrabajo");
                String nombrePuestoTrabajo = rs.getString("nombrePuestoTrabajo");
                float salario = rs.getFloat("salario");
                datosDB.setIdPuestoTrabajo(idPuestoTrabajo);
                datosDB.setNombrePuestoTrabajo(nombrePuestoTrabajo);
                datosDB.setSalario(salario);
                listPuestosTrabajo.add(datosDB);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println("Puestos de trabajo" + listPuestosTrabajo);
        return listPuestosTrabajo;
    }
}

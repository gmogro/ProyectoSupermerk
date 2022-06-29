package Usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Cliente {
	private String cuil;
	private String responsabilidadAfip;
	private int idpersona;
	
	public Cliente() {
	}
	public Cliente(String cuil, String responsabilidadAfip) {
		this.cuil = cuil;
		this.responsabilidadAfip = responsabilidadAfip;
	}
	
	public String getCuil() {
		return cuil;
	}
	public void setCuil(String cuil) {
		this.cuil = cuil;
	}
	public String getResponsabilidadAfip() {
		return responsabilidadAfip;
	}
	public void setResponsabilidadAfip(String responsabilidadAfip) {
		this.responsabilidadAfip = responsabilidadAfip;
	}
	
	public void crearCliente(Connection conexion) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("#######################");
		System.out.println("Datos Personales");
		System.out.println("#######################");
		System.out.println("Apellido :");
		String apellido = sc.nextLine(); 
		System.out.println("Nombre :");
		String nombre = sc.nextLine();
		System.out.println("Domicilio :");
		String domicilio = sc.nextLine();
		System.out.println("Documento :");
		String documento = sc.nextLine();
		System.out.println("Provincia :");
		String provincia = sc.nextLine();
		System.out.println("Codigo Postal :");
		String codigoPostal = sc.nextLine();
		System.out.println("Fecha de Nacimiento : ");
		String fechaNacimiento = sc.nextLine();
		System.out.println("Telefono : ");
		String telefono = sc.nextLine();
		System.out.println("Cuil : ");
		String cuil = sc.nextLine();
		System.out.println("Responsabilidad en Afip : ");
		String afip = sc.nextLine();
		
		Statement statement = null;
		String sql;
		ResultSet rs;
		PreparedStatement stmt;
		try {
			statement = conexion.createStatement();
			sql = "SELECT idpersona FROM persona order by idPersona DESC LIMIT 1;";
			rs = statement.executeQuery(sql);
			int idPersona = 0;
			while(rs.next()) 
			{
				idPersona = rs.getInt("idPersona");
			}
			stmt = conexion.prepareStatement("INSERT INTO persona VALUES (?,?,?,?,?,?,?,?,?)");
        	stmt.setInt(1,idPersona+1);
        	stmt.setString(2,nombre);
        	stmt.setString(3,apellido);
        	stmt.setString(4,domicilio);
        	stmt.setString(5,documento);
        	stmt.setString(6,provincia);
        	stmt.setString(7,codigoPostal);
        	stmt.setString(8,fechaNacimiento);
        	stmt.setString(9,telefono);
        	
        	int response = stmt.executeUpdate();
        	if(response>0) 
        	{
        		System.out.println("se inserto correctamente");
        	}
        
			sql = "SELECT idcliente FROM cliente order by idcliente DESC LIMIT 1;";
			rs = statement.executeQuery(sql);
			int idcliente = 0;
			while(rs.next()) 
			{
				idcliente = rs.getInt("idcliente");
			}
        	stmt = conexion.prepareStatement("INSERT INTO cliente VALUES (?,?,?,?)");
        	stmt.setInt(1,idcliente+1);
        	stmt.setInt(2,idPersona+1);
        	stmt.setString(3,cuil);
        	stmt.setString(4,afip);
        	
        	response = stmt.executeUpdate();
        	if(response>0) 
        	{
        		System.out.println("se inserto cliente correctamente");
        	}
		}catch (SQLException sqle){
            System.out.println("SQLState: "+ sqle.getSQLState());
            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
            sqle.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
	}
}

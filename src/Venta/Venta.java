package Venta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Supermercado.Productos;

public class Venta {
	private String fecha;
	private double total;
	private String observacion;
	private boolean estado;
	
	public Venta() {
	}
	public Venta(String fecha, double total, String observacion, boolean estado) {
		super();
		this.fecha = fecha;
		this.total = total;
		this.observacion = observacion;
		this.estado = estado;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public void crearVenta(Connection conexion) 
	{
		Statement statement = null;
		String sql;
		ResultSet rs;
		int idcategoria = 0;
		try {
			statement = conexion.createStatement();
			sql = "SELECT idproducto,Nombre,Precio FROM producto order by idproducto;";
			rs = statement.executeQuery(sql);
			int option = 0;
			ArrayList<Productos> listaProductos = new ArrayList<Productos>();
			do{
				while(rs.next()) 
				{
					System.out.print(rs.getInt("idproducto")+" - ");
					System.out.print(rs.getString("Nombre"));
					System.out.print(rs.getString("Precio"));
					System.out.println();
				}
				
				sc.nextLine();
			}while(option == 1);
		}catch (SQLException sqle){
            System.out.println("SQLState: "+ sqle.getSQLState());
            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
            sqle.printStackTrace();
	     }catch (Exception e){
	            e.printStackTrace();
	     }
	}
	
}

package Test;

import Supermercado.Productos;
import Utilidades.Conexion;

public class TestProductos {
	public static void main(String[] args) {
		Conexion conexion = new Conexion("supermark","root","Navidad$25");
		System.out.println(conexion.conectar());
		
		Productos producto = new Productos();
		
		producto.crearProducto(conexion.getConnection());
	}
}

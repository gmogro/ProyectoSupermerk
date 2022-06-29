package Test;

import Supermercado.Categorias;
import Utilidades.Conexion;

public class TestCategoria {
	public static void main(String[] args) {
		
		Conexion conexion = new Conexion("supermark","root","Navidad$25");
		
		System.out.println(conexion.conectar());
		
		Categorias categoria = new Categorias();
		
		categoria.crearCategoria(conexion.getConnection());
		
		
		//conexion.desconectar();
	}
}

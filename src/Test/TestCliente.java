package Test;

import Usuarios.Cliente;
import Utilidades.Conexion;

public class TestCliente {
	public static void main(String[] args) {
		Conexion conexion = new Conexion("supermark","root","Navidad$25");
		System.out.println(conexion.conectar());
		Cliente cliente = new Cliente();
		cliente.crearCliente(conexion.getConnection());
		
	}
}

package Principal;

import java.util.Scanner;

import Supermercado.Categorias;
import Supermercado.Productos;
import Usuarios.Cliente;
import Utilidades.Conexion;

public class Principal {
	public static void main(String[] args) {
		//Base de Datos
		Conexion conexion = new Conexion("Supermark","root","Navidad$25");
		System.out.println(conexion.conectar());
		
		//MENU
		Scanner sc = new Scanner(System.in);
		System.out.println("#######################");
		System.out.println("Bienvenidos a SUPERMARK");
		System.out.println("#######################");
		
		//INICIE SESION
		
		System.out.println("#######################");
		System.out.println("MENU");
		System.out.println("1 - Categorias");
		System.out.println("2 - Productos");
		System.out.println("3 - Venta");
		System.out.println("4 - Reporte");
		int option = sc.nextInt(); 
		System.out.println("#######################");
		
		switch (option) {
			case 1: {
						System.out.println("1 - Crear una Categoria");
						System.out.println("2 - Actualizar una Categoria");
						System.out.println("3 - Eliminar una Categoria");
						int optionMenu = sc.nextInt();
						switch (optionMenu) {
							case 1: {
										Categorias categoria = new Categorias();
										categoria.crearCategoria(conexion.getConnection());
										break;
									}
							case 2:
									{
										Categorias categoria = new Categorias();
										categoria.actualizarCategoria(conexion.getConnection());
										break;
									}
							case 3:
									{
										Categorias categoria = new Categorias();
										categoria.eliminarCategoria(conexion.getConnection());
										break;
									}
							default:
								throw new IllegalArgumentException("Error elija opcion correcta");
							}
						break;
					}
			case 2:
				{
					System.out.println("1 - Crear un Producto");
					System.out.println("2 - Actualizar Producto");
					System.out.println("3 - Eliminar Producto");
					int optionMenu = sc.nextInt();
					switch (optionMenu) {
						case 1: {
									Productos producto = new Productos();
									producto.crearProducto(conexion.getConnection());
									break;
								}
						case 2:
								{
									Productos producto = new Productos();
									producto.actualizarProducto(conexion.getConnection());
									break;
								}
						case 3:
								{
									Productos producto = new Productos();
									producto.eliminarProducto(conexion.getConnection());
									break;
								}
						default:
							throw new IllegalArgumentException("Error elija opcion correcta");
						}
					break;
				}
			case 3:
			{
					System.out.println("1 - Crear un Cliente");
					System.out.println("2 - Actualizar Cliente");
					System.out.println("3 - Eliminar Cliente");
					int optionMenu = sc.nextInt();
					switch (optionMenu) {
						case 1: {
									Cliente cliente = new Cliente();
									cliente.crearCliente(conexion.getConnection());
									break;
								}
						case 2:
								{
									Cliente cliente = new Cliente();
									//cliente.actualizarProducto(conexion.getConnection());
									break;
								}
						case 3:
								{
									Cliente cliente = new Cliente();
									//cliente.eliminarProducto(conexion.getConnection());
									break;
								}
						default:
							throw new IllegalArgumentException("Error elija opcion correcta");
						}
					break;
				}
			case 4:
				{
					System.out.println("1 - Crear una Venta");
					System.out.println("2 - Actualizar una Venta");
					System.out.println("3 - Anular una Venta");
					break;
				}
			default:
				throw new IllegalArgumentException("Elija un opcion correcta");
			}
	}
}

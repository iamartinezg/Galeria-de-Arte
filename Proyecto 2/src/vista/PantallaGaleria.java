package vista;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

import Control.ControlGaleria;
import Entidades.Artista;
import Entidades.Cliente;
import Entidades.Compra;
import Entidades.Obra;

public class PantallaGaleria {


	public PantallaGaleria() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ControlGaleria pantalla = new ControlGaleria();
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);

		int metodo =0;
		String titulo = "";
		long codigoArtista = 0;
		int anio = 0;
		int opcion = 0;

		do {
			System.out.println("1. Ver listado de Obras disponibles");
			System.out.println("2. Buscar una Obra por título, artista o año");
			System.out.println("3. Insertar una Obra");
			System.out.println("4. Modificar una Obra");
			System.out.println("5. Eliminar una Obra");
			System.out.println("6. Ver listado de Clientes registrados en el sistema");
			System.out.println("7. Buscar un Cliente");
			System.out.println("8. Insertar Cliente");
			System.out.println("9. Modificar datos de Cliente");
			System.out.println("10. Eliminar un Cliente");
			System.out.println("11. Realizar compra de una Obra");
			System.out.println("12. Eliminar compra de obra");
			System.out.println("13. Ver listado de Compras existentes");
			System.out.println("14. Ver listado de Compras para un mes y año específico insertado por el usuario");
			System.out.println("15. Ver listado de Artistas más vendidos");
			System.out.println("16. Salir");
			System.out.println("Ingrese numero de la opcion: ");
			opcion = sc.nextInt();

			switch(opcion)
			{

			case 1:

				ArrayList<Obra> obras = pantalla.obrasDisponibles();
				for(Obra actual: obras) {
					System.out.println("Titulo: " + actual.getTitulo());
					System.out.println("Fecha: " + actual.getFecha().getTime());
					System.out.println("Precio: " + actual.getPrecioRef());
					System.out.println("Dimensiones: " + actual.getDimensiones());
					System.out.println(" ");
				}

				break;
			case 2:

				System.out.println("Ingrese el metodo a utilizar (1. Titulo, 2. Artista, 3. Año");
				metodo = sc.nextInt();
				if(metodo == 1) {
					System.out.println("Digite el titulo de la obra a buscar");
					sc.nextLine();
					titulo = sc.nextLine();
					Obra obraTitulo = pantalla.buscarObraTitulo(titulo);
					System.out.println("Titulo: " + obraTitulo.getTitulo());
					System.out.println("Fecha: " + obraTitulo.getFecha().getTime());
					System.out.println("Precio: " + obraTitulo.getPrecioRef());
					System.out.println("Dimensiones: " + obraTitulo.getDimensiones());
					System.out.println(" ");
				}
				else if(metodo == 2) {
					System.out.println("Digite el codigo del artista de las obras a buscar");
					codigoArtista = sc.nextLong();
					ArrayList<Obra> obrasArtista = pantalla.buscarObraArtista(codigoArtista);
					for(Obra actual: obrasArtista) {
						System.out.println("Titulo: " + actual.getTitulo());
						System.out.println("Fecha: " + actual.getFecha().getTime());
						System.out.println("Precio: " + actual.getPrecioRef());
						System.out.println("Dimensiones: " + actual.getDimensiones());
						System.out.println(" ");
					}

				}
				else if(metodo == 3) {
					System.out.println("Digite el año de la obra a buscar");
					anio = sc.nextInt();
					ArrayList<Obra> obrasAnio = pantalla.buscarObraAnio(anio);
					for(Obra actual: obrasAnio) {
						System.out.println("Titulo: " + actual.getTitulo());
						System.out.println("Fecha: " + actual.getFecha().getTime());
						System.out.println("Precio: " + actual.getPrecioRef());
						System.out.println("Dimensiones: " + actual.getDimensiones());
						System.out.println(" ");
					}
				}

				break;
			case 3:
			{
				long codigoInsertar = 0;
				String tituloInsertar = "";
				int anioInsertar = 0;
				int mesInsertar = 0;
				int diaInsertar = 0;
				float precioInsertar = 0;
				String dimensionesInsertar = "";
				long cedulaA = 0;
				int opcionArtista = 0;
				long cedulaInsertar = 0;
				String nombreInsertar = "";
				String apellidosInsertar = "";
				int anioA = 0;
				int mesA = 0;
				int diaA = 0;
				long telefonoInsertar = 0;
				long codigoA = 0;

				System.out.println("Digite el codigo de la obra");
				codigoInsertar = sc.nextLong();

				System.out.println("Digite el titulo de la obra");
				sc.nextLine();
				tituloInsertar = sc.nextLine();

				System.out.println("Digite el anio de la obra");
				anioInsertar = sc.nextInt();

				System.out.println("Digite el mes de la obra");
				mesInsertar = sc.nextInt();

				System.out.println("Digite el dia de la obra");
				diaInsertar = sc.nextInt();

				System.out.println("Digite el precio de la obra");
				precioInsertar = sc.nextFloat();

				System.out.println("Digite las dimensiones de la obra");
				sc.nextLine();
				dimensionesInsertar = sc.nextLine();

				ArrayList<Artista> existentes = pantalla.getArtistas();
				for(Artista actual: existentes) {
					System.out.println(" ");
					System.out.println("Cedula: " + actual.getCedula());
					System.out.println("Nombre: " + actual.getNombre());
					System.out.println("Apellidos: " + actual.getApellidos());
					System.out.println(" ");
				}

				System.out.println("El artista que quiere insertar existe. 1.Si, 2.No");
				opcionArtista = sc.nextInt();
				if(opcionArtista == 1) {
					System.out.println("Digite la cedula del artista existente");
					cedulaA = sc.nextLong();
					Artista artistaNuevo = pantalla.buscarArtistaCedula(cedulaA);
					pantalla.insertarObra(codigoInsertar, tituloInsertar, new GregorianCalendar(anioInsertar, mesInsertar -1, diaInsertar), precioInsertar, dimensionesInsertar, artistaNuevo);
				}
				else if(opcionArtista == 2) {
					System.out.println("Digite el codigo del artista");
					codigoA = sc.nextLong();

					System.out.println("Digite la cedula del artista");
					cedulaInsertar = sc.nextLong();

					System.out.println("Digite el nombre del artista");
					sc.nextLine();
					nombreInsertar = sc.nextLine();

					System.out.println("Digite los apellidos del artista");
					apellidosInsertar = sc.nextLine();

					System.out.println("Digite el anio de nacimiento del artista");
					anioA = sc.nextInt();

					System.out.println("Digite el mes de nacimiento del artista");
					mesA = sc.nextInt();

					System.out.println("Digite el dia de nacimiento del artista");
					diaA = sc.nextInt();

					System.out.println("Digite el telefono del artista");
					telefonoInsertar = sc.nextLong();

					Artista nuevo = new Artista(codigoA, cedulaInsertar, nombreInsertar, apellidosInsertar, new GregorianCalendar(anioA, mesA -1, diaA), telefonoInsertar);
					pantalla.getArtistas().add(nuevo);
					pantalla.insertarObra(codigoInsertar, tituloInsertar, new GregorianCalendar(anioInsertar, mesInsertar -1, diaInsertar), precioInsertar, dimensionesInsertar, nuevo);
				}
			}
			break;
			case 4:
			{
				long codigo = 0;
				System.out.println("Digite el codigo de la obra a modificar");
				codigo = sc.nextLong();
				
				pantalla.modificarObra(codigo);
				
			}
				break;
			case 5:
			{
				long codigoEliminar = 0;
				System.out.println("Ingrese el codigo de la obra que desea eliminar");
				codigoEliminar = sc.nextLong();

				pantalla.eliminarObra(codigoEliminar);

			}
			break;
			case 6:
				pantalla.verClientes();

				break;
			case 7:
			{
				long codigoCliente = 0;
				System.out.println("Ingrese el codigo del cliente que quiere buscar");
				codigoCliente = sc.nextLong();

				Cliente buscado = pantalla.buscarCliente(codigoCliente);

				System.out.println(" ");
				System.out.println("Codigo del cliente: " + buscado.getCodigoCliente());
				System.out.println("Cedula: " + buscado.getCedula());
				System.out.println("Nombre: " + buscado.getNombre());
				System.out.println("Apellidos: " + buscado.getApellidos());
				System.out.println("Direccion Entrega: " + buscado.getDireccionEntrega());
				System.out.println("Telefono: " + buscado.getTelefono());
				System.out.println(" ");

			}
			break;
			case 8:
			{
				long codigoC = 0;
				long cedulaC = 0;
				String nombreC = "";
				String apellidosC = "";
				String direccionEntregaC = "";
				long telefonoC = 0;


				System.out.println("Digite el codigo del cliente");
				codigoC = sc.nextLong();

				System.out.println("Digite la cedula del cliente");
				cedulaC = sc.nextLong();

				System.out.println("Digite el nombre del cliente");
				sc.nextLine();
				nombreC = sc.nextLine();

				System.out.println("Digite los apellidos del cliente");
				apellidosC = sc.nextLine();

				System.out.println("Digite la direccion del cliente");
				direccionEntregaC = sc.nextLine();

				System.out.println("Digite el telefono del cliente");
				telefonoC = sc.nextLong();

				pantalla.insertarCliente(codigoC, cedulaC, nombreC, apellidosC, direccionEntregaC, telefonoC);
			}

			break;
			case 9:
			{
				long codigo = 0;
				System.out.println("Digite el codigo del cliente a modificar");
				codigo = sc.nextLong();
				
				pantalla.modificarCliente(codigo);
				
			}
				break;
			case 10:
			{
				long codigoEliminar = 0;
				System.out.println("Ingrese el codigo del cliente que desea eliminar");
				codigoEliminar = sc.nextLong();

				pantalla.eliminarCliente(codigoEliminar);

			}
			break;
			case 11:
			{
				int anioB = 0;
				int mesB = 0;
				int diaB = 0;
				long codigoOB = 0;
				long codigoCB = 0;

				System.out.println("Digite el anio de la compra");
				anioB = sc.nextInt();

				System.out.println("Digite el mes de la compra");
				mesB = sc.nextInt();

				System.out.println("Digite el dia de la compra");
				diaB = sc.nextInt();

				System.out.println("Digite el codigo del cliente");
				codigoCB = sc.nextLong();

				System.out.println("Digite el codigo de la obra");
				codigoOB = sc.nextLong();

				pantalla.realizarCompraObra(anioB, mesB, diaB, codigoCB, codigoOB);
			}	
			break;
			case 12:
			{
				long codigoEliminar = 0;
				System.out.println("Ingrese el codigo de la compra que desea eliminar");
				codigoEliminar = sc.nextLong();

				pantalla.eliminarCompra(codigoEliminar);
			}	
			break;
			case 13:

				ArrayList<Compra> compras = pantalla.verComprasExistentes();
				if(compras.size() > 0) {
					for(Compra actual: compras) {
						System.out.println("Codigo compra: " + actual.getCodigoCompra());
						System.out.println("Fecha: " + actual.getFecha().getTime());
						System.out.println("Pagado: " + actual.isPagado());
						System.out.println("Codigo del cliente asociado: " + actual.getCompraCliente().getCodigoCliente());
						System.out.println("Codigo de la obra asociada: " + actual.getCompraObra().getCodigoObra());
						System.out.println(" ");
					}
				}
				else {
					System.out.println("No hay compras en el sistema");
				}
				break;
			case 14:
				int anioE = 0;
				int mesE = 0;
				
				System.out.println("Ingrese el anio especifico para ver el listado de compras");
				anioE = sc.nextInt();
				
				System.out.println("Ingrese el mes especifico para ver el listado de compras");
				mesE = sc.nextInt();
			
				ArrayList<Compra> compras1 = pantalla.verComprasExistentesAnioYMes(anioE, mesE);
				if(compras1.size() > 0) {
					for(Compra actual: compras1) {
						System.out.println("Codigo compra: " + actual.getCodigoCompra());
						System.out.println("Fecha: " + actual.getFecha().getTime());
						System.out.println("Pagado: " + actual.isPagado());
						System.out.println("Codigo del cliente asociado: " + actual.getCompraCliente().getCodigoCliente());
						System.out.println("Codigo de la obra asociada: " + actual.getCompraObra().getCodigoObra());
						System.out.println(" ");
					}
				}
				else {
					System.out.println("No hay compras en el sistema");
				}

				break;
			case 15:
			{
				ArrayList<Artista> artistas = pantalla.artistasMasVendidos();
				for(Artista actual: artistas) {
					System.out.println("Codigo del Artista: " + actual.getCodigoArtista());
					System.out.println("Cedula: " + actual.getCedula());
					System.out.println("Nombre: " + actual.getNombre());
					System.out.println("Apellidos: " + actual.getApellidos());
					System.out.println("Fecha de nacimiento: " + actual.getFechaNacimiento().getTime());
					System.out.println("Telefono: " + actual.getTelefono());
					System.out.println(" ");
				}
		
			}

				break;
			case 16:
				System.out.println("Se salio del programa");
				break;
			default:
				System.out.println("Opcion no valida");
				break;

			}

		}while(opcion !=16);		
	}
}
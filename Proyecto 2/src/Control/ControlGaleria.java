package Control;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import Entidades.Artista;
import Entidades.Cliente;
import Entidades.Compra;
import Entidades.Obra;

public class ControlGaleria {

	private ArrayList<Obra>obras = new ArrayList<>();
	private ArrayList<Artista>artistas = new ArrayList<>();
	private ArrayList<Cliente>clientes = new ArrayList<>();
	private GestionObras gestionProducto = new GestionObras();
	private GestionClientes gestionCliente = new GestionClientes();
	private ArrayList<Compra> compras = new ArrayList<>();
	
	
	public ControlGaleria() {
		// TODO Auto-generated constructor stub
		this.gestionProducto.listaObras(obras, artistas);
		this.gestionCliente.listaClientes(clientes);
	}
	
	//Punto 2
	
	public ArrayList<Obra> obrasDisponibles(){
		ArrayList<Obra> disponibles = new ArrayList<Obra>();
		for(Obra actual: this.obras) {
			if(obraAsociadaCompra(actual) == false) {
				disponibles.add(actual);
			}
		}
		return disponibles;
	}
	
	public boolean obraAsociadaCompra(Obra obra) {
		for(Compra actual: this.compras) {
			if(actual.getCompraObra().equals(obra)) {
				return true;
			}
		}
		return false;
	}
	
	//Punto 3
	
	public Obra buscarObraTitulo(String titulo) {
		Obra encontrado = null;
		for(Obra actual: this.obras) {
			if(actual.getTitulo().equals(titulo)) {
				encontrado = actual;
			}
		}
		return encontrado;
	}
	
	public ArrayList<Obra> buscarObraArtista(long codigoArtista) {
		ArrayList<Obra> obrasArtista = new ArrayList<Obra>();
		for(Artista actual: this.artistas) {
			if(actual.getCodigoArtista() == codigoArtista) {
				obrasArtista = actual.getObras();
			}
		}
		return obrasArtista;
	}
	
	public ArrayList<Obra> buscarObraAnio(int anio) {
		ArrayList<Obra> obrasAnio = new ArrayList<Obra>();
		for(Obra actual: this.obras) {
			if(actual.getFecha().get(Calendar.YEAR) == anio){
				obrasAnio.add(actual);
			}
		}
		return obrasAnio;
	}
	
	//Punto 4
	
	public Artista buscarArtistaCedula(long cedula) {
		Artista encontrado = null;
		for (Artista actual: this.artistas) {
			if(actual.getCedula() == cedula) {
				encontrado = actual;
			}
		}
		return encontrado;
	}
	
	public void insertarObra(long codigoObra, String titulo, Calendar fecha, float precio, String dimensiones, Artista artista) {
		Obra nueva = new Obra(codigoObra, titulo, fecha, precio, dimensiones);
		if(artista != null) {
			nueva.agregarArtista(artista);
			artista.agregarObra(nueva);
		}
		
		String codigoO = String.valueOf(codigoObra);
		if(buscarObraCodigo(codigoObra) == null && codigoO.length() == 7){
			this.obras.add(nueva);
			System.out.println("Se inserto exitosamente la obra");
		}
		else {
			System.out.println("Ya existe una obra con el codigo insertado o el codigo insertado no tiene 7 digitos");
		}
	}
	
	//Punto 5
	
	public Obra buscarObraCodigo(long codigo) {
		Obra encontrado = null;
		for(Obra actual: this.obras) {
			if(actual.getCodigoObra() == codigo) {
				encontrado = actual;
			}
		}
		return encontrado;
	}
	
	public void modificarObra(long codigoBuscar) {
		Obra buscada = buscarObraCodigo(codigoBuscar);
		Scanner sc = new Scanner (System.in);
		int opcion = 0;
		long codigoM = 0;
		String tituloM = "";
		int anioM = 0;
		int mesM = 0;
		int diaM = 0;
		float precioM = 0;
		String dimensionesM = "";
		
		if(buscada != null) {
			System.out.println("1. Codigo obra: " + buscada.getCodigoObra());
			System.out.println("2. Titulo: " + buscada.getTitulo());
			System.out.println("3. Fecha: " + buscada.getFecha().getTime());
			System.out.println("4. Precio: " + buscada.getPrecioRef());
			System.out.println("5. Dimensiones: " + buscada.getDimensiones());
			
			
			System.out.println("Digite el atributo que desea modificar");
			opcion = sc.nextInt();
			
			if(opcion == 1) {
				System.out.println("Digite el nuevo codigo de la obra");
				codigoM = sc.nextLong();
				if(buscarObraCodigo(codigoM) == null) {
				buscada.setCodigoObra(codigoM);
				System.out.println("Se modifico correctamente el codigo");
				} else {
					System.out.println("El codigo insertado ya existe. No se modifico la obra");
				}
				
			}
			else if(opcion == 2) {
				sc.nextLine();
				System.out.println("Digite el nuevo titulo de la obra");
				tituloM = sc.nextLine();
				
				buscada.setTitulo(tituloM);
				System.out.println("Se modifico correctamente el titulo");
			}
			else if(opcion == 3) {
				System.out.println("Digite el nuevo anio de la obra");
				anioM = sc.nextInt();
				
				System.out.println("Digite el nuevo mes de la obra");
				mesM = sc.nextInt();
				
				System.out.println("Digite el nuevo dia de la obra");
				diaM = sc.nextInt();
				
				buscada.setFecha(new GregorianCalendar(anioM, mesM, diaM));
				System.out.println("Se modifico correctamente la fecha");
			}
			else if(opcion == 4) {
				System.out.println("Digite el nuevo precio de la obra");
				precioM = sc.nextFloat();
				
				buscada.setPrecioRef(precioM);
				System.out.println("Se modifico correctamente el precio");
			}
			else if (opcion == 5) {
				sc.nextLine();
				System.out.println("Digite las nuevas dimensiones de la obra");
				dimensionesM = sc.nextLine();
				
				buscada.setDimensiones(dimensionesM);
				System.out.println("Se modifico correctamente las dimensiones");
			}
		}
		else {
			System.out.println("El codigo de la obra no existe");
		}
	}
	
	//Punto 6
	
	public boolean eliminarObra(long codigo) {
		Obra encontrado = buscarObraCodigo(codigo);
		if(encontrado != null && obraAsociadaCompra(encontrado) == false){
			this.obras.remove(encontrado);
			System.out.println("Se elimino correctamente la obra");
			return true;
		}
		System.out.println("No se pudo eliminar la obra. Revise el codigo insertado");
		return false;
	}
	
	//Punto 7
	
	public void verClientes(){
		for(Cliente actual: this.clientes) {
			System.out.println("Cedula: " + actual.getCedula());
			System.out.println("Nombre completo: " + actual.getNombre() + " " + actual.getApellidos());
			System.out.println("Direccion: " + actual.getDireccionEntrega());
			System.out.println("Telefono: " + actual.getTelefono());
			System.out.println(" ");
		}
	}
	
	//Punto 8
	
	public Cliente buscarCliente(long codigoCliente) {
		Cliente encontrado = null;
		for(Cliente actual: this.clientes) {
			if(actual.getCodigoCliente() == codigoCliente) {
				encontrado = actual;
			}
		}
		return encontrado;
	}
	
	public void insertarCliente(long codigoCliente, long cedula, String nombre, String apellidos, String direccion, long telefono) {
		Cliente nuevo = new Cliente(codigoCliente, cedula, nombre, apellidos, direccion, telefono);
		
		if(buscarCliente(codigoCliente) == null) {
			this.clientes.add(nuevo);
			System.out.println("Se inserto exitosamente el cliente");
		}
		else {
			System.out.println("Ya existe un cliente con el codigo insertado");
		}
	}
	
	//Punto 9
	
	public void modificarCliente(long codigoBuscar) {
		Cliente buscado = buscarCliente(codigoBuscar);
		Scanner sc = new Scanner (System.in);
		int opcion = 0;
		long codigoM = 0;
		long cedulaM = 0;
		String nombreM = "";
		String apellidosM= "";
		String direccionM = "";
		long telefonoM = 0;
		
		if(buscado != null) {
			System.out.println("1. Codigo cliente: " + buscado.getCodigoCliente());
			System.out.println("2. Cedula: " + buscado.getCedula());
			System.out.println("3. Nombre: " + buscado.getNombre());
			System.out.println("4. Apellidos: " + buscado.getApellidos());
			System.out.println("5. Direccion: " + buscado.getDireccionEntrega());
			System.out.println("6. Telefono: " + buscado.getTelefono());
			
			System.out.println("Digite el atributo que desea modificar");
			opcion = sc.nextInt();
			
			if(opcion == 1) {
				System.out.println("Digite el nuevo codigo del cliente");
				codigoM = sc.nextLong();
				if(buscarCliente(codigoM) == null) {
				buscado.setCodigoCliente(codigoM);
				System.out.println("Se modifico correctamente el codigo");
				} else {
					System.out.println("El codigo insertado ya existe. No se modifico el cliente");
				}
				
			}
			else if(opcion == 2) {
				System.out.println("Digite la nueva cedula del cliente");
				cedulaM = sc.nextLong();
				
				buscado.setCedula(cedulaM);
				System.out.println("Se modifico correctamente la cedula");
			}
			else if(opcion == 3) {
				sc.nextLine();
				System.out.println("Digite el nuevo nombre del cliente");
				nombreM = sc.nextLine();
				
				buscado.setNombre(nombreM);
				System.out.println("Se modifico correctamente el nombre");
			}
			else if(opcion == 4) {
				sc.nextLine();
				System.out.println("Digite los nuevos apellidos del cliente");
				apellidosM = sc.nextLine();
				
				buscado.setApellidos(apellidosM);
				System.out.println("Se modifico correctamente los apellidos");
			}
			else if (opcion == 5) {
				sc.nextLine();
				System.out.println("Digite la nueva direccion del cliente");
				direccionM = sc.nextLine();
				
				buscado.setDireccionEntrega(direccionM);
				System.out.println("Se modifico correctamente la direccion");
			}
			else if(opcion == 6) {
				System.out.println("Digite el nuevo telefono del cliente");
				telefonoM = sc.nextLong();
				
				buscado.setTelefono(telefonoM);
				System.out.println("Se modifico correctamente el telefono");
			}
		}
		else {
			System.out.println("El codigo del cliente no existe");
		}
		
	}
	
	//Punto 10
	
	public boolean clienteAsociadoCompra(Cliente cliente) {
		for(Compra actual: this.compras) {
			if(actual.getCompraCliente().equals(cliente)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean eliminarCliente(long codigo) {
		Cliente encontrado = buscarCliente(codigo);
		if(encontrado != null && clienteAsociadoCompra(encontrado) == false){
			this.clientes.remove(encontrado);
			System.out.println("Se elimino exitosamente el cliente");
			return true;
		}
		else {
			System.out.println("No existe un cliente con el codigo insertado");
		return false;
		}
	}
	
	//Punto 11
	
	public boolean clienteObraAsociadaCompra(Cliente cliente, Obra obra) {
		for(Compra actual: this.compras) {
			if(actual.getCompraCliente().equals(cliente) && actual.getCompraObra().equals(obra)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean realizarCompraObra(int anio, int mes, int dia, long codigoCliente, long codigoObra) {
		Obra buscada = buscarObraCodigo(codigoObra);
		Cliente buscado = buscarCliente(codigoCliente);
		if(buscada != null && buscado != null) {
			if(clienteObraAsociadaCompra(buscado, buscada) == false) {
				Compra nueva = new Compra(new GregorianCalendar(anio, mes, dia), false, buscada, buscado);
				this.compras.add(nueva);
				System.out.println("Se realizo la compra exitosamente");
				return true;
			}
			else {
				System.out.println("No se pudo realizar la compra. Verifique que la obra y cliente exista y que no esten asociados a otra compra");
			return false;
			}
		}else {
			System.out.println("La obra o cliente no existe");
			return false;
		}
	}
	
	//Punto 12
	
	public Compra buscarCompra(long codigoCompra) {
		Compra encontrado = null;
		for(Compra actual: this.compras) {
			if(actual.getCodigoCompra() == codigoCompra) {
				encontrado = actual;
			}
		}
		return encontrado;
	}
	
	public boolean eliminarCompra(long codigo) {
		Compra encontrado = buscarCompra(codigo);
		if(encontrado != null){
			this.compras.remove(encontrado);
			System.out.println("Se elimino exitosamente la compra");
			return true;
		}
		System.out.println("No se pudo eliminar la compra. Revise el codigo insertado");
		return false;
	}
	
	//Punto 13
	
	public ArrayList<Compra> verComprasExistentes(){
		ArrayList<Compra> existentes = new ArrayList<Compra>();
		for(Compra actual: this.compras) {
			if(clienteObraAsociadaCompra(actual.getCompraCliente(), actual.getCompraObra()) == true) {
				existentes.add(actual);
			}
		}
		return existentes;
	}
	
	//Punto 14
	
	public ArrayList<Compra> verComprasExistentesAnioYMes(int anio, int mes){
		ArrayList<Compra> existentes = new ArrayList<Compra>();
		for(Compra actual: this.compras) {
			if(clienteObraAsociadaCompra(actual.getCompraCliente(), actual.getCompraObra()) == true) {
				if(actual.getFecha().get(Calendar.YEAR) == anio && actual.getFecha().get(Calendar.MONTH) == mes) {
					existentes.add(actual);
				}
			}
		}
		return existentes;
	}
	
	//Punto 15
	
	public int verCantArtistasPorCompra(Artista art) {
		int cont = 0;
		for(Compra actual: this.compras) {
			if(actual.getCompraObra().getArtistas().contains(art)) {
				cont ++;
			}
		}
		return cont;
	}
	
	public ArrayList<Artista> artistasMasVendidos(){
		ArrayList<Artista> vendidos = new ArrayList<Artista>();
		for(Artista actual: this.artistas) {
			vendidos.add(actual);
		}
		
		for(int i = 0; i < vendidos.size() -1; i++) {
			for(int j = i + 1; j < vendidos.size(); j++) {
				if(verCantArtistasPorCompra(vendidos.get(i)) < verCantArtistasPorCompra(vendidos.get(j))) {
					Artista aux = vendidos.get(i);
					vendidos.set(i, vendidos.get(j));
					vendidos.set(j, aux);
				}
			}
		}
		return vendidos;
	}

	/**
	 * @return the obras
	 */
	public ArrayList<Obra> getObras() {
		return obras;
	}

	/**
	 * @param obras the obras to set
	 */
	public void setObras(ArrayList<Obra> obras) {
		this.obras = obras;
	}

	/**
	 * @return the artistas
	 */
	public ArrayList<Artista> getArtistas() {
		return artistas;
	}

	/**
	 * @param artistas the artistas to set
	 */
	public void setArtistas(ArrayList<Artista> artistas) {
		this.artistas = artistas;
	}

	/**
	 * @return the clientes
	 */
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	/**
	 * @param clientes the clientes to set
	 */
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	/**
	 * @return the compras
	 */
	public ArrayList<Compra> getCompras() {
		return compras;
	}

	/**
	 * @param compras the compras to set
	 */
	public void setCompras(ArrayList<Compra> compras) {
		this.compras = compras;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

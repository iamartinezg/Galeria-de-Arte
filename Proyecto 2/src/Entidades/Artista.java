package Entidades;

import java.util.ArrayList;
import java.util.Calendar;

public class Artista {

	private long codigoArtista;
	private long cedula;
	private String nombre;
	private String apellidos;
	private Calendar fechaNacimiento;
	private long telefono;
	private ArrayList<Obra> obras = new ArrayList<>();
	
	public Artista() {
		// TODO Auto-generated constructor stub
	}

	public Artista(long codigoArtista, long cedula, String nombre, String apellidos, Calendar fechaNacimiento,
			long telefono) {
		this.codigoArtista = codigoArtista;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
	}

	/**
	 * @return the codigoArtista
	 */
	public long getCodigoArtista() {
		return codigoArtista;
	}

	/**
	 * @param codigoArtista the codigoArtista to set
	 */
	public void setCodigoArtista(long codigoArtista) {
		this.codigoArtista = codigoArtista;
	}

	/**
	 * @return the cedula
	 */
	public long getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the telefono
	 */
	public long getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(long telefono) {
		this.telefono = telefono;
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

	public void agregarObra(Obra obra) {
		this.obras.add(obra);
	}
	

}

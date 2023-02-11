package Entidades;

import java.util.ArrayList;
import java.util.Calendar;

public class Obra {
	
	private long codigoObra;
	private String titulo;
	private Calendar fecha;
	private float precioRef;
	private String dimensiones;
	private ArrayList<Artista> artistas = new ArrayList<>();

	public Obra() {
		// TODO Auto-generated constructor stub
	}


	public Obra(long codigoObra, String titulo, Calendar fecha, float precioRef, String dimensiones) {
		this.codigoObra = codigoObra;
		this.titulo = titulo;
		this.fecha = fecha;
		this.precioRef = precioRef;
		this.dimensiones = dimensiones;
	}


	/**
	 * @return the codigoObra
	 */
	public long getCodigoObra() {
		return codigoObra;
	}


	/**
	 * @param codigoObra the codigoObra to set
	 */
	public void setCodigoObra(long codigoObra) {
		this.codigoObra = codigoObra;
	}


	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}


	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	/**
	 * @return the fecha
	 */
	public Calendar getFecha() {
		return fecha;
	}


	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}


	/**
	 * @return the precioRef
	 */
	public float getPrecioRef() {
		return precioRef;
	}


	/**
	 * @param precioRef the precioRef to set
	 */
	public void setPrecioRef(float precioRef) {
		this.precioRef = precioRef;
	}


	/**
	 * @return the dimensiones
	 */
	public String getDimensiones() {
		return dimensiones;
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
	 * @param dimensiones the dimensiones to set
	 */
	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}
	public void agregarArtista(Artista artista) {
		this.artistas.add(artista);
	}

}

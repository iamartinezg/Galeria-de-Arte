package Entidades;

import java.util.Calendar;

public class Compra {

	private long codigoCompra;
	private Calendar fecha;
	private boolean pagado; 
	private Obra compraObra;
	private Cliente compraCliente;
	private static int CONSECUTIVO = 0;
	
	public Compra() {
		// TODO Auto-generated constructor stub
	}

	public Compra(long codigoCompra, Calendar fecha, boolean pagado) {
		this.codigoCompra = codigoCompra;
		this.fecha = fecha;
		this.pagado = pagado;
	}
	
	

	public Compra(Calendar fecha, boolean pagado, Obra compraObra, Cliente compraCliente) {
		this.codigoCompra = ++CONSECUTIVO;
		this.fecha = fecha;
		this.pagado = pagado;
		this.compraObra = compraObra;
		this.compraCliente = compraCliente;
	}

	/**
	 * @return the codigoCompra
	 */
	public long getCodigoCompra() {
		return codigoCompra;
	}

	/**
	 * @param codigoCompra the codigoCompra to set
	 */
	public void setCodigoCompra(long codigoCompra) {
		this.codigoCompra = codigoCompra;
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
	 * @return the pagado
	 */
	public boolean isPagado() {
		return pagado;
	}

	/**
	 * @param pagado the pagado to set
	 */
	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	/**
	 * @return the compraObra
	 */
	public Obra getCompraObra() {
		return compraObra;
	}

	/**
	 * @param compraObra the compraObra to set
	 */
	public void setCompraObra(Obra compraObra) {
		this.compraObra = compraObra;
	}

	/**
	 * @return the compraCliente
	 */
	public Cliente getCompraCliente() {
		return compraCliente;
	}

	/**
	 * @param compraCliente the compraCliente to set
	 */
	public void setCompraCliente(Cliente compraCliente) {
		this.compraCliente = compraCliente;
	}
	
	
	
	

}

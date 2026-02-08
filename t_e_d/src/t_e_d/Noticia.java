package t_e_d;

import java.io.Serializable;

public class Noticia implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String nombrePeriodista, fecha, encabezado;
	
	public Noticia(String nombrePeriodista, String encabezado, String fecha) {
		this.nombrePeriodista = nombrePeriodista;
		this.fecha = fecha;
		this.encabezado = encabezado;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	@Override
	public String toString() {
		return "\nNombre de periodista: "+nombrePeriodista+"\nEncabezado: "+encabezado+"\nFecha: "+fecha+"\n";
	}
}
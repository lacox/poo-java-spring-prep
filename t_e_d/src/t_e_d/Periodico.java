package t_e_d;

import java.io.Serializable;

public class Periodico implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String nombre, tipo;
	
	public Periodico() {}
	public Periodico(String nombre, String tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
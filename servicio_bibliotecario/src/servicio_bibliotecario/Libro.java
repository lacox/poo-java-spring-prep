package servicio_bibliotecario;

import java.io.Serializable;

public class Libro implements Serializable{
	/**
	 * @author lacox(Angel David Salas Mendoza)
	 */
	private static final long serialVersionUID = 1L;
	private int idLibro;
	private String autor, edicion, editorial;
	private boolean estatus;
	
	public Libro(int idLibro, String autor, String edicion, String editorial, boolean estatus) {
		super();
		this.idLibro = idLibro;
		this.autor = autor;
		this.edicion = edicion;
		this.editorial = editorial;
		this.estatus = estatus;
	}
	
	public int getIdLibro() {
		return idLibro;
	}

	public boolean isEstatus() {
		return estatus;
	}
	
	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}
	
	public String definirEstado() {
		if (estatus) {
			return "Disponible";
		} else {
			return "Ocupado";
		}
	}
	
	@Override
	public String toString() {
        return "\nIdLibro: " + idLibro + "\nAutor: " + autor + "\nEdicion: " + edicion + "\nEditorial: " + editorial + "\nEstatus: " + definirEstado();
    }
}
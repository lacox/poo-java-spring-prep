package servicio_bibliotecario;

import java.io.Serializable;
import java.util.LinkedList;

public class DatosBibliotecarios implements Serializable {
	/**
	 * @author lacox(Angel David Salas Mendoza)
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<Usuario> usuarios;
    private LinkedList<Libro> libros;
    private LinkedList<Prestamo> prestamos;
    
	public LinkedList<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(LinkedList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public LinkedList<Libro> getLibros() {
		return libros;
	}
	public void setLibros(LinkedList<Libro> libros) {
		this.libros = libros;
	}
	public LinkedList<Prestamo> getPrestamos() {
		return prestamos;
	}
	public void setPrestamos(LinkedList<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}
}

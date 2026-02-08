package servicio_bibliotecario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class ServicioBibliotecario {
	public LinkedList<Libro> libros;
	public LinkedList<Usuario> usuarios;
	public LinkedList<Prestamo> prestamos;
	
	public ServicioBibliotecario() {
		libros = new LinkedList<>();
		usuarios = new LinkedList<>();
		prestamos = new LinkedList<>();
	}
	
	public void cargarLibros() {
		BufferedReader br = null;
		String id = "";
		String estatus = "";
		String autor = "";
		String edicion = "";
		String editorial = "";
		
		try {
			br = new BufferedReader(new FileReader("libros.txt"));
			while((id = br.readLine()) != null) {
				estatus = br.readLine();
                autor = br.readLine();
                edicion = br.readLine();
                editorial = br.readLine();
                Libro libro = new Libro();
                libro.setIdLibro(Integer.parseInt(id));
                libro.setEstatus(estatus.equalsIgnoreCase("true")); // Revision decia true: Revisar logica
                libro.setAutor(autor);
                libro.setEdicion(edicion);
                libro.setEditorial(editorial);
                libros.add(libro);
			}
		} catch (Exception e) {
			System.out.println("Error"+e.getMessage());
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				System.out.println(libros);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void registrarPrestamo() {}
	public void actualizarEstatus() {}
	public void visualizarPrestamos() {}
}

package servicio_bibliotecario;

//import static java.lang.Thread.sleep;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import javax.swing.JTextArea;

//Runnable es la interface de Java que dispone de un método run y nos permite ejecutar una Tarea en paralelo desde un programa main usando la clase Thread.
//public class Prestamo implements Runnable {
public class Prestamo implements Serializable{
	/**
	 * @author lacox(Angel David Salas Mendoza)
	 */
	private static final long serialVersionUID = 1L;
	private int idPrestamo, idLibro, idUsuario, posicion = 0;
	private long dias;
	private boolean borrar = false;
	private LocalDate fechaEntrada, fechaSalida;
	LinkedList<Libro> libros = new LinkedList<Libro>();
	
	public Prestamo(int idPrestamo, int idLibro, int idUsuario, String fechaE, String fechaS, LinkedList<Libro> libros) {
		this.idPrestamo = idPrestamo;
		this.idLibro = idLibro;
		this.idUsuario = idUsuario;
		this.fechaEntrada = LocalDate.parse(fechaE, DateTimeFormatter.ISO_LOCAL_DATE);
		this.fechaSalida = LocalDate.parse(fechaS, DateTimeFormatter.ISO_LOCAL_DATE);
		this.libros = libros;
		
		Duration diff = Duration.between(fechaEntrada.atStartOfDay(), fechaSalida.atStartOfDay());
		dias = diff.toDays();
		System.out.println("Dias: " + dias);
		//hilo = new Thread(this);
		bloquearLibro();
		//hilo.start(); //el hilo ejecuta el método run de contador atras
	}

	public int getIdPrestamo() {
		return idPrestamo;
	}
	
	public boolean isBorrar() {
		return borrar;
	}
	
	public void bloquearLibro() {
		int cont = 0;
		for (Libro lib : libros) {
			if (lib.getIdLibro() == idLibro) {
				lib.setEstatus(false);
				posicion = cont;
				System.out.println(lib.toString());
			}
			cont++;
		}
	}
	
	public void desbloquearLibro() {
		int cont = 0;
		for(Libro lib: libros) {
			if (lib.getIdLibro() == idLibro) {
				lib.setEstatus(true);
				posicion = cont;
				System.out.println(lib.toString());
			}
			cont++;
		}
	}
	
	public void Contador(JTextArea salida) {
		dias = (Duration.between(LocalDate.now().atStartOfDay(),fechaSalida.atStartOfDay())).toDays();
		if ((dias) <= 0) {
			desbloquearLibro();
			borrar = true;
			salida.setText("\nSe ha desbloqueado el libro: \n"+libros.get(posicion).toString());
		}
	}
	
	@Override
	public String toString() {
        return "\nIdPrestamo: " + idPrestamo + "\nIdLibro: " + idLibro + "\nIdUsuario: " + idUsuario + "\nFecha Entrada: " + fechaEntrada + "\nFecha Salida: " + fechaSalida + "\nDias restantes: " + dias +"\n"+"\nLibro rentado: " + libros.get(posicion);
    }

	/*@Override
	public void run() {
		for(int i = (int) dias; i>0; i--) {
			System.out.println("\t\ti="+i);
			try {
				sleep(1000);
			} catch (InterruptedException ex) {
                Logger.getLogger(Prestamo.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		desbloquearLibro();
		salida.setText(libros.toString());
	}*/
}

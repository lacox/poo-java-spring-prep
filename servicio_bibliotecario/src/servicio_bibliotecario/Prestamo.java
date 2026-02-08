package servicio_bibliotecario;

import static java.lang.Thread.sleep;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

//Runnable es la interface de Java que dispone de un método run y nos permite ejecutar una Tarea en paralelo desde un programa main usando la clase Thread.
public class Prestamo implements Runnable {
	JTextArea salida;
	private Thread hilo;
	LinkedList<Libro> libros;
	private int idPrestamo, idLibro, idUsuario;
	private long dias;
	private LocalDate fechaEntrada, fechaSalida;
	
	public Prestamo(LinkedList<Libro> libros, int idPrestamo, int idLibro, int idUsuario,
			String fechaE, String fechaS, JTextArea salida) throws ParseException{
		this.idPrestamo = idPrestamo;
		this.idLibro = idLibro;
		this.idUsuario = idUsuario;
		this.fechaEntrada = LocalDate.parse(fechaE, DateTimeFormatter.ISO_LOCAL_DATE);
		this.fechaSalida = LocalDate.parse(fechaS, DateTimeFormatter.ISO_LOCAL_DATE);
		this.libros = libros;
		this.salida = salida;
		
		Duration diff = Duration.between(fechaEntrada.atStartOfDay(), fechaSalida.atStartOfDay());
		dias = diff.toDays();
		System.out.println("Dias: " + dias);
		hilo = new Thread(this);
		bloquearLibro();
		salida.setText(libros.toString());
		hilo.start(); //el hilo ejecuta el método run de contador atras
	}

	public int getIdPrestamo() {
		return idPrestamo;
	}
	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public long getDias() {
		return dias;
	}
	public void setDias(long dias) {
		this.dias = dias;
	}
	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public LocalDate getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	public void bloquearLibro() {
		for (Libro lib : libros) {
			if (lib.getIdLibro() == idLibro) {
				lib.setEstatus(false);
				System.out.println(lib.toString());
			}
		}
	}
	
	public void desbloquearLibro() {
		for(Libro lib: libros) {
			if (lib.getIdLibro() == idLibro) {
				lib.setEstatus(true);
				System.out.println(lib.toString());
			}
		}
	}
	
	@Override
	public String toString() {
		return "ID prestamo: "+idPrestamo+"\nFecha de entrada: "+fechaEntrada+
                "\nFecha de salida: "+fechaSalida+"\nDias: "+dias+"\nId libro: "
                +idLibro+"\nId usuario: "+idUsuario+"\n"; 
	}

	@Override
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
	}
}

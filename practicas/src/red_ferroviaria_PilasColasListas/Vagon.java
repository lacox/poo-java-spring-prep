package red_ferroviaria_PilasColasListas;

/**
* @author lacox(Angel David SM)
*/
public class Vagon {
	private String nombre;
	private int capacidad,numeroVagon;

	public Vagon(String nombre, int capacidad, int numeroVagon) {
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.numeroVagon = numeroVagon;
	}

	@Override
	public String toString() {
		return "Nombre del vagon: " + nombre + "\nCapacidad: " + capacidad + "\nNumero de vagon: " + numeroVagon;
	}
}
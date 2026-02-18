package tren;

/**
*@author lacox(Angel David SM)
*/
public class Vagon {
	private int id,capacidad;
	
	public Vagon(int id, int capacidad){
		this.id = id;
		this.capacidad = capacidad;
	}
	
	@Override
	public String toString() {
		return "{" + "id=" + id + ", capacidad=" + capacidad + '}';
	}
}
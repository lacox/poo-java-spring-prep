package tren;

/**
*@author lacox(Angel David SM)
*/
public class Tren {
	private String nombre;
	private Vagon vagon1, vagon2, vagon3;

	public Tren(String nombre){
		this.nombre = nombre;
		vagon1 = new Vagon(001,25);
		vagon2 = new Vagon(002,40);
		vagon3 = new Vagon(003,65);
	}

	@Override
	public String toString() {
		return "--Tren " + nombre + "-- \nVagon 1=" + vagon1 + " \nVagon 2=" + vagon2 + " \nVagon 3=" + vagon3;
	}
}
package publicacion_Herencia;

public class CD extends Publicacion{
	private int tiempoReprod;

	public CD(int tiempoReprod, String titulo, double precio) {
		super(titulo, precio);
		this.tiempoReprod = tiempoReprod;
	}

	public int getTiempoReprod() {
		return tiempoReprod;
	}

	@Override
	public String toString() {
		return "\nTitulo:"+titulo+"\nPrecio: "+precio+"\nTiempo de reproduccion: " + tiempoReprod;
	}
}
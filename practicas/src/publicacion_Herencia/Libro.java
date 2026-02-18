package publicacion_Herencia;

public class Libro extends Publicacion {
	private int numPaginas;

	public Libro(int numPaginas, String titulo, double precio) {
		super(titulo, precio);
		this.numPaginas = numPaginas;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	@Override
	public String toString() {
		return "\nTitulo:"+titulo+"\nPrecio: "+precio+"\nNumPaginas: " + numPaginas;
	}
}
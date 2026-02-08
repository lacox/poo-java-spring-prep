package t_e_d;

public class Impreso extends Periodico{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int precio;
	
	public Impreso(int precio, String nombre, String tipo) {
		super(nombre, tipo);
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "Nombre del periodico: "+nombre+"\nPrecio: "+precio+"\n";
	}
}

package t_e_d;

import java.util.LinkedList;

public class Linea extends Periodico{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected LinkedList<Fecha> fechas = new LinkedList<>();
	
	public Linea(String nombre, String tipo) {
		super(nombre, tipo);
	}
	
	public void addFecha(Fecha fecha) {
		fechas.add(fecha);
	}
	
	public LinkedList<Fecha> getFechas(){
		return fechas;
	}
	
	public boolean existeFecha(String fecha) {
		for (int i = 0; i < fechas.size(); i++) {
			if (fechas.get(i).getFecha().equals(fecha)) {
				return true;
			}
		}
		return false;
	}
	
	@Override 
	public String toString() {
		String msg = "Nombre del periódico: "+ nombre + "\n";
		for(Fecha i : fechas) {
			msg += i;
		}
		return msg;
	}
}

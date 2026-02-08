package t_e_d;

import java.io.Serializable;
import java.util.LinkedList;

public class Fecha implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String fecha;
	protected LinkedList<Noticia> noticias = new LinkedList<>();
	
	public Fecha(String fecha) {
		this.fecha = fecha;
	}
	
	public void addNoticia(Noticia noticia) {
		noticias.add(noticia);
	}
	
	public int sizeNoticias() {
		return noticias.size();
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public LinkedList<Noticia> getNoticias(){
		return noticias;
	}
	
	@Override 
	public String toString() {
		String msg = "";
		for (Noticia i : noticias) {
			msg += i;
		}
		return msg;
	}
}

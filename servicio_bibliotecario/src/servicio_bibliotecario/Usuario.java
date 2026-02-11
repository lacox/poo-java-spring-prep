package servicio_bibliotecario;

import java.io.Serializable;

public class Usuario implements Serializable{
	/**
	 * @author lacox(Angel David Salas Mendoza)
	 */
	private static final long serialVersionUID = 1L;
	private int idUsuario, tipoUsuario;
	private String nombre, apellidoP, apellidoM, direccion;
	
	public Usuario(int idUsuario, String nombre, String apellidoP, String apellidoM, String direccion, int tipoUsuario) {
		this.idUsuario = idUsuario;
		this.tipoUsuario = tipoUsuario;
		this.nombre = nombre;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
		this.direccion = direccion;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public String definirTipoUsuario() {
		if (tipoUsuario == 0) {
			return "Normal";
		} else {
			return "Estudiante";
		}
	}
	
	@Override
	public String toString() {
        return "\nIdUsuario: " + idUsuario + "\nNombre: " + nombre + "\nApellido Materno: " + apellidoM + "\nApellido Paterno: " + apellidoP + "\nDireccion: " + direccion + "\nTipo: " + definirTipoUsuario();
    }
}

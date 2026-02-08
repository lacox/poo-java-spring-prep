package servicio_bibliotecario;

public class Usuario {
	private int idUsuario, tipoUsuario;
	private String nombre, apellidoP, apellidoM, direccion;
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoP() {
		return apellidoP;
	}
	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}
	public String getApellidoM() {
		return apellidoM;
	}
	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		if (tipoUsuario == 0) {
			return "Id usuario: "+idUsuario+"\nNombre: "+nombre+" "+apellidoP+" "+apellidoM+
                    "\nDireccion: "+direccion+"\nUsuario: Normal.\n";
		} else {
			return "Id usuario: "+idUsuario+"\nNombre: "+nombre+" "+apellidoP+" "+apellidoM+
                    "\nDireccion: "+direccion+"\nUsuario: Estudiante.\n";
		}
	}
}

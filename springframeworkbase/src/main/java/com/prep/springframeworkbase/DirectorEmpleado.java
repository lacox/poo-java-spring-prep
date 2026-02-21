package com.prep.springframeworkbase;

public class DirectorEmpleado implements Empleados {
	//Creacion del campo tipo CreacionInforme (interfaz)
	private CreacionInformes informeNuevo;
	private String email, nombreEmpresa;
	
	//Creacion del constructor que inyecta la dependencia
	public DirectorEmpleado(CreacionInformes informe) {
		this.informeNuevo = informe;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return "Gestionar la plantilla de la empresa";
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		return "Informe creado por el Director: " + informeNuevo.getInforme();
	}

}

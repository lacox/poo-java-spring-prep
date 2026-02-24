package com.prep.springannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

// Si la id de component no se especifica se toma el nombre de la clase pero la primera letra se vuelve minuscula
@Component("ComercialExp")
@Scope("singleton")
//@Scope("prototype")
public class ComercialExperimentado implements Empleados{
	@Autowired
	@Qualifier("informeFinancieroTrim3") // bean Id que debe utilizar
	private CreacionInformeFinanciero nuevoInforme;
	
	public ComercialExperimentado() {
		
	}
	
	//Busca en todo el proyecto una clase que implemente la interfaz CreacionInformeFinanciero
	/*@Autowired
	public ComercialExperimentado(CreacionInformeFinanciero nuevoInforme) {
		this.nuevoInforme = nuevoInforme;
	}*/
	/*@Autowired
	public void setNuevoInforme(CreacionInformeFinanciero nuevoInforme) {
		this.nuevoInforme = nuevoInforme;
	}*/

	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return "Vender, vender y vender más!";
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		return nuevoInforme.getInformeFinanciero();
	}
	
	/* Para manejar PostConstruct y PreDestroy, solo pueden usarse
	el patron Singleton pues spring con prototype no maneja el ciclo
	de vida completo del Bean. Pueden usarse los diferentes modificadores de acceso
	pueden devolver cualquier tipo y no deben tener argumentos*/
	// Ejecucion de codigo despues de creacion del Bean
	@PostConstruct
	public void ejecutaDespuesCreacion() {
		System.out.println("Ejecutado tras creación del Bean");
	}
	//Ejecucion de código despues de apagado contenedor Spring
	@PreDestroy
	public void ejecutaAntesDestruccion() {
		System.out.println("Ejecutando antes de la destrucción");
	}
}

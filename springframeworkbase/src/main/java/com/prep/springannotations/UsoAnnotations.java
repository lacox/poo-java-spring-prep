package com.prep.springannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoAnnotations {

	public static void main(String[] args) {
		// Cargar el xml de configuración
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextSA.xml");
		// Pedir un bean al contenedor
		Empleados antonio = context.getBean("ComercialExp", Empleados.class);
		// Usar el bean
		System.out.println(antonio.getInforme());
		System.out.println(antonio.getTareas());
		
		// Cerrar el contexto
		context.close();
	}

}

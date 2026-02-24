package com.prep.springannotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoAnnotations2 {
	public static void main(String[] args) {
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextSA.xml");
		// Leer el class de configuración
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EmpleadosConfig.class);
		//Empleados antonio = context.getBean("ComercialExp", Empleados.class);
		Empleados lucia = context.getBean("ComercialExp", Empleados.class);
		//Empleados antonio = context.getBean("directorFinanciero", Empleados.class);
		DirectorFinanciero antonio = context.getBean("directorFinanciero", DirectorFinanciero.class);
		
		System.out.println(antonio.getTareas());
		System.out.println(antonio.getInforme());
		System.out.println("Email del director: " + antonio.getEmail());
		System.out.println("Nombre de la empresa: " + antonio.getNombreEmpresa());
		
		System.out.println(lucia.getTareas());
		System.out.println(lucia.getInforme());
		/* Se puede utilizar la anotacion scope para cambiar el patron de diseño
		En este caso se cambia el default Singleton por prototype, lo que cambia 
		la logica de una instancia unica a distintas instacias clones*/
		System.out.println(antonio);
		System.out.println(lucia);
		context.close();
	}
}

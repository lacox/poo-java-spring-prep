package com.prep.springframeworkbase;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// Creacion de objetos de tipo Empleado
    	/*Empleados empleado = new JefeEmpleado();
    	Empleados secretario = new SecretarioEmpleado();
    	Empleados director = new DirectorEmpleado();
    	
        System.out.println(director.getTareas());*/
    	// Se carga el archivo xml
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	// Se pide el Bean
    	System.out.println("--------------------------------");
    	Empleados juan = context.getBean("miEmpleado", Empleados.class);
    	System.out.println(juan.getTareas());
    	System.out.println(juan.getInforme());
    	System.out.println("--------------------------------");
    	SecretarioEmpleado maria = context.getBean("miSecretarioEmpleado", SecretarioEmpleado.class);
    	System.out.println(maria.getTareas());
    	System.out.println("Email: " + maria.getEmail());
    	System.out.println(maria.getNombreEmpresa());
    	System.out.println(maria.getInforme());
    	
    	System.out.println("--------------------------------");
    	DirectorEmpleado ramiro = context.getBean("miEmpleado", DirectorEmpleado.class);
    	System.out.println(ramiro.getEmail());
    	System.out.println(ramiro.getNombreEmpresa());
    	context.close();
    }
}

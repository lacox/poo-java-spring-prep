package com.prep.springframeworkbase;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoCicloVidaBean {

	public static void main(String[] args) {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");

    	//Obtencion del bean
    	Empleados juan = context.getBean("miEmpleado", Empleados.class);
    	
    	System.out.println(juan.getInforme());
    	//Cerrar el contexto
    	context.close();
	}

}

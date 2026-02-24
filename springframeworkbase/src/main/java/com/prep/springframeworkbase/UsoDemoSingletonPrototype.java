package com.prep.springframeworkbase;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoDemoSingletonPrototype {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml")) {
			//peticion de beans al contenedor Spring
			SecretarioEmpleado Maria = context.getBean("miSecretarioEmpleadoS", SecretarioEmpleado.class);
			SecretarioEmpleado Pedro = context.getBean("miSecretarioEmpleadoS", SecretarioEmpleado.class);
			
			for (int i = 0; i < 2; i++) {
				System.out.println(Maria);
				System.out.println(Pedro);
				//Debido a que se usa el patron singleton por defecto, ambas instancias apuntan a un unico objeto
				if (Maria == Pedro) {
					System.out.println("Apuntan al mismo objeto");
					Maria = context.getBean("miSecretarioEmpleadoP", SecretarioEmpleado.class);
					Pedro = context.getBean("miSecretarioEmpleadoP", SecretarioEmpleado.class);
				}else {
					// Pero al cambiar el patron de diseño, el resultado cambia y ahora cada instancia es un clon del objeto prototipo
					System.out.println("No se trata del mismo objeto");
				}
			}
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}

}

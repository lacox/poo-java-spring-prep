# Spring (Framework) 
## Inversión de Control (IoC)
### ¿Que es la Inversión de Control?
La inversión de Control (IoC) es principio de diseño en el cual el control sobre la creacion y gestion de objetos no lo tiene el programador directamente, sino el framework.
En lugar de que el código cree sus propias dependencias usando `new`, el framework se encarga de crearlas y administrarlas.
### ¿Cómo funciona en Spring?
Spring utiliza el contenedor llamado `ApplicationContext`. Este contenedor:
- Detecta clases anotadas con `@Component`, `@Service`, `@Repository`, `@Controller`
- Crea instancias (beans)
- Gestiona su ciclo de vida
- Inyecta dependencias automaticamente
A estos objetos gestionados por Spring se les llama Beans.
### ¿Que es la Inyeccion de Dependencias?
-  Definición: Patrón de diseño orientado a objetos en el que se suministran objetos a una clase en lugar de ser la propia clase la que cree dichos objetos.
La Inyeccion de Dependencias es la forma practica en la que se aplica IoC.
En lugar de:
```java
  PedidoRepository repo = new PedidoRepository();
```
Spring hace:
```java
  public PedidoService(PedidoRepository repo)
```
y automaticamente proporciona la instancia.

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

## Patrones de diseño
### Singleton
`Patron de diseño por defecto de Spring`
#### ¿Qué es?
Es un patron de diseño que tiene como objetivo asegurar que solo hay una instancia u objeto por clase y un punto de acceso global a ella.
#### ¿Porqué es necesario esto?
- En determinados escenarios, debe asegurarse de que las clases controlan y gestionan el accceso a un único recurso. Es frecuente necesitar un punto de acceso único a algun recurso del sistema compartido y un único objeto que centralice la administración del recuerso.
- En otros escenarios la necesidad es que diferentes objetos de la aplicacion puedan acceder a un tipo de dato en concreto.
#### Ventajas de utilizar este patrón
- Control estricto de como se acceden a las instancias
- Espacio de nombres reducido
- Mejor desempeño de la herencia
### Prototype
#### ¿Qué es? 
Patron de diseño que tiene como objetivo la creacion de varios objetos a partir de un modelo o "prototipo". Esto lo hace mediante la clonacion de objetos o instancias creadas previamente para despues tener sus propios valores desde setters.
#### ¿Por qué es necesario esto?
- En determinados escenarios se requieren de varios objetos con atributos repetidos (comunes)
- Permite crear nuevos objetos variando los ya existentes con el consiguiente ahorro de tiempo y recursos
- Clonar siempre es más rápido que crear.

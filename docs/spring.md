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

## Ciclo de vida del Bean
1. Se inica el contenedor Spring
   - Se crea el `ApplicationContext`.
   - Se cargan las definiciones de los beans (`BeanDefinition`)
2. Instanciación de Bean
   - Spring crea la instancia (usualmente mediante constructor).
   - Si existe constructor con `@Autowired`, se resuelven dependencias aquí.
3. Inyección de dependencias
   - Inyección por `Constructor`, `Setter` o `Campo(@Autowired)`.
   - Se resuelven referencias a otros beans del contexto.
4. BeanPostProcessor (fase previa a inicialización)
   - Se ejecuta:
   ```java
    PedidoRepository repo = new PedidoRepository();
   ```
   - Permite modificar el bean antes del init.
5. Método Init
6. Bean listo para su uso
    - El bean está completamente inicializado.
    - Puede ser usado por otros componentes.
    - Si es `singleton`, vive hasta que el contenedor se cierre.
    - Si es `prototype`, Spring deja de gestionarlo después de crearlo.
7. BeanPostProcessor (fase posterior a inicialización)
   - Se ejecuta:
   ```java
    postProcessAfterInitialization();
   ```
   - Aquí es donde Spring puede crear proxies (ej. AOP).
8. Contenedor Spring apagado
9. Método destroy
### Scope del Bean
- `singleton` -> Se crea una sola instancia.
- `prototype` -> Spring no gestiona destroy.
- `request`/`session` -> En aplicaciones web.
### Método Init y Destroy
#### Metodo Init
El metodo `init` puede tener los siguientes propositos y se ejecutar antes de tener listo el bean:
- Cargar dependencias de otros beans
- Activación retardada de servicios
- Validar configuración
- Inicializar recursos costosos
- Abrir conexiones
- Inicializar caches
- Arrancar hilos controlados
#### Metodo Destroy
El metodo `destroy` ejecutara las tareas en su interior cuando el bean ya haya terminado su ciclo de vida, este puede tener los siguietes propositos:
- Liberar recuersos
- Cerrar conexiones JDBC
- Detener hilos
- Liberar sockets
- Cerrar pools de conexiones
- Persistir estado antes de apagar

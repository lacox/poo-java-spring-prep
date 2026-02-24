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

## Java Annotations
### ¿Qué son?
Las `Java Annotations` son "etiquetas" que se añaden a nuestras clases, métodos, campos, variables, etc en un programa Java.
### ¿Para qué sirven?
- Para añadir metadatos a nuestros programas (clases) de Java
- Poder describir la naturaleza de un objeto (metadatos) con annotations nos permite utilizarlas como sustituto de los archivos XML
- Las annotations son procesadas en tiempo de compilación o también en tiempo de ejecución.
  #### ¿Qué son los metadatos?
  Un conjunto de datos que describen el contenido y/o propósito de un objeto
### Procesamiento de Annotations
Las annotations pueden procesarse en:
1. En tiempo de compilación: 
Ejemplo: `@Override`. El compilador valida su correcto uso.
2. En tiempo de ejecución:
Frameworks como Spring Framework utilizan reflexión para inspeccionar annotations y modificar el comportamiento dinámicamente.
### ¿Como funcionan las annotations en Spring?
Spring escanea el código de todas nuestras clases en busca de annotations.
- Hay que preparar el XML para que Spring escanee nuestro código
Cuando encuentra una annotation, registra el vean de forma automática en el contenedor.
⚠️ Importante:
Ya no es obligatorio usar XML. En aplicaciones modernas (Spring Boot), la configuración suele hacerse completamente con annotations.
Ejemplo:
```java
@Component
public class MiServicio {
}
```
Spring registrará automáticamente `MiServicio` como Bean.
### Annotations comunes en Spring
#### Anotaciones de estereotipo (registro de Beans)
- `@Component`
- `@Service`
- `@Repository`
- `@Controller`
- `@RestController`
#### Inyección de dependencias
- `@Autowired`
- `@Qualifier`
- `@Primary`
#### Ciclo de vida
- `@PostConstruct`
- `@PreDestroy`
#### Configuración
- `@Configuration`
- `@Bean`
- `@ComponentScan`
### Ventajas Java Annotations con Spring
- Mayor facilidad a la hora de configurar los beans
- Simplifica enormemente el código del archivo de configuración XML
- Especialmente útil cuando debemos configurar cientos de beans en un programa
### Pasos a seguir para utilizar annotations
- Preparar el XML para que Spring escanee nuestro código
- Agregar annotations a nuestras clases de Java
- Pedir el bean al contenedor

## Aplicaciones Web Spring
### ¿Qué es MVC (Modelo Vista Controlador)?
El patrón MVC (Model-View-Controller) es un patrón arquitectónico que separa una aplicación en tres responsabilidades bien definidas:
#### 1. Modelo (Model)
El modelo no es la base de datos, sino la representación en memoria del dominio de la aplicación (POJOs, servicios, entidades, lógica de negocio).

Representa:
   - Los datos
   - La lógica de negocio
   - El acceso a datos

Ejemplo:
```java
  public class Usuario {
    private String nombre;
    private String correo;
  }
```
#### 2. Vista (View)
Es la capa de presentación.

Se encarga de:
  - Mostrar información al usuario
  - Renderizar datos enviados por el controlador

Puede implementarse con:
  - JSP
  - Thymeleaf
  - FreeMarker
  - JSON (en APIs REST)
#### 3. Controlador (Model)
Es el intermediario entre:
  - La petición HTTP
  - El modelo
  - La vista

Se encarga de:
  - Recibir solicitudes
  - Validar datos
  - Invocar servicios
  - Preparar la respuesta

Cuando el usuario hace peticiones al servidor pasa primero por el controlador para su procesamiento y este consulta con el modelo que maneja la información, comunmente en una base de datos, para obtener la informacion relacionada con la petición y presentarla al usuario por medio de una vista.
### Ventajas del MVC
- Separación clara de responsabilidades.
- Facilita pruebas unitarias.
- Mejora la matenibilidad.
- Permite la escalabilidad horizontal.
- Reduce acoplamiento entre capas.
- Favorece trabajo en equipo.
### ¿Como funciona MVC en Spring?
En Spring Framework, específicamente en Spring MVC, el flujo es:
1. El cliente envía una petición HTTP.
2. La petición llega al DispatcherServlet (Front Controller).
3. Spring determina qué método del @Controller debe ejecutarse.
4. El controlador invoca la lógica de negocio (servicios).
5. El modelo se llena con datos.
6. Se selecciona una vista.
7. La vista renderiza la respuesta.
### Componentes clave en Spring MVC
#### DispatcherServlet
Es el Front Controller central que:
- Recibe todas las peticiones
- Las enruta al controlador correcto
#### Controlador
Se define con:
```java
@Controller
@RequestMapping("\usuarios")
public class UsuarioController {
}
```
#### Modelo en Spring
En Spring MVC el modelo suele representarse mediante:
- Objetos del dominio
- Servicios (`@Service`)
- Repositorios (`@Repository`)
Spring facilita la inyección de dependencias entre estas capas.

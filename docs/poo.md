# Programación Orientada a Objetos (POO)

## ¿Qué es una clase?
Una clase es una plantilla que define las caracteristicas (atributos) y comportamientos (métodos) que tendrán los objetos. En java, una clase se define usando la palabra reservada `class`.

Ejemplo: 
```java
public class Persona {
  String nombre;
  int edad;

  void saludar(){
    System.out.println("Hola, mi nombre es " + nombre);
  }
}
```

## ¿Qué es un objeto?
Un objeto es una instancia de una clase. Representa un elemento real creado a partir de la plantilla definida por la clase.

Ejemplo: 
```java
public class Main {
  public static void main(String[] args) {
    Persona persona = new Persona();
    persona.nombre = "Juan";
    persona.edad = 25;
    persona.saludar();
  }
}
```

## Clases Abstractas
Son un tipo particular de clase cuya principal característica es que no pueden ser instanciadas. Por lo general declara la existencia de métodos pero no su implementación, convirtiéndola en una superclase.

Caracteristicas:
  - Al menos uno de sus métodos debe ser abstracto.
  - Sus niveles de visualizacion deben ser public o protected
  - Cuando se usan clases abstractas una clase no puede heredar de varias clases abstractas a la vez.

## Los cuatro pilares de la POO

### Encapsulamiento
Agrupar datos y métodos dentro del objeto, controlando el acceso a ellos para proteger la información interna. Los datos generalmente son de tipo privado y los metodos de tipo publico, se usan metodos publicos (GET, SET) para cambiar o acceder a los datos privados.

El encapsulamiento permite 3 niveles de acceso:
  - public
  - private
  - protected: Nivel intermedio entre `public` y `private`, establece que el acceso a los atributos o metodos que esten definidos por este solo pueden ser utilizados dentro de su propia clase y en sus subclases que herenden de esta.
  
### Abstracción
Modelo simplificado de un problema. Se consideran solo los elementos importantes sin llegar a detalles.

### Herencia
Es el mecanismo para propagar (atributos y metodos) de las superclases a las subclases.

Cada vez que se especializa una clase esta hereda atributos y comportamientos de su superclase; pero añadiendo nuevos compotamientos o modificando alguno de los heredados.
  - La herencia multiple es una caracteristica que permite a una clase heredar atributos y metodos de dos o más superclases.
  - La herencia promueve la reutilización de código y evita la duplicidad de información.
 
### Polimorfismo
Es la capacidad de objetos de diferentes clases de responder al mismo mensaje (método) de forma distinta, adaptándose a su tipo especidfico.
El polimorfismo se realiza en tiempo de ejecución porque durante la compilación no se conoce que tipo de objeto y de operacion ha sido llamada.


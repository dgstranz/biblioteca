# Biblioteca

Este proyecto es una abstracción de una biblioteca.

## Contexto
La Biblioteca Central Universitaria quiere modernizar su proceso de préstamo y devolución de materiales. Para ello, cada uno va a desarrollar un proyecto Java orientado a objetos que modele y gestione recursos bibliotecarios (libros, revistas y DVDs), usuarios y el flujo de préstamos y devoluciones, aplicando herencia, interfaces, clases abstractas, implements/extends, enum y buenas prácticas de empaquetado.

## Requisitos funcionales

1. Modelo de dominio

   * [x] La Biblioteca contiene múltiples `Estanteria`s.
   * [ ] Cada `Estanteria` aloja varios `RecursoBiblioteca`.
   * [x] `RecursoBiblioteca` es una clase abstracta de la cual heredan `Libro`, `Revista` y `DVD`.
   * [x] Un `Usuario` puede tomar prestado o devolver cualquier `RecursoBiblioteca`.

2. Operaciones de préstamo

   * [x] Prestar un recurso solo si está `DISPONIBLE`.
   * [x] Devolver un recurso prestado.
   * [x] Mostrar por pantalla mensajes claros del estado antes y después de cada operación.

3. Estados

   * [x] Cada recurso mantiene un `EstadoRecurso` (`DISPONIBLE`, `PRESTADO`, `RESERVADO`).
   * [x] Al prestar cambia a `PRESTADO`; al devolver a `DISPONIBLE`.

4. Interacción

   * El programa principal (Main) leerá comandos por consola o iniciará el menú con, mínimo, estas opciones:

     * [x] `prestar <idRecurso> <idUsuario>`
     * [x] `devolver <idRecurso>`
     * [x] `listar` (opcional: muestra todos los recursos con su estado).



## Requisitos técnicos y estructura de paquetes
Organiza tu código en esta estructura de paquetes bajo src/:

```
biblioteca/
├── interfaces/ ← Prestamista.java
├── model/      ← RecursoBiblioteca.java, Libro.java, Revista.java, DVD.java, Usuario.java
├── enums/      ← EstadoRecurso.java
└── app/        ← Main.java
```

* [x] `biblioteca.interfaces.Prestamista`

  * [x] Métodos `boolean prestar(RecursoBiblioteca recurso, Usuario usuario)` y `boolean devolver(RecursoBiblioteca recurso)`.
  * [x] Explica en comentarios qué hace cada método. (Recuerda que para
comentar un método se inicia con `/**` y se cierra con `*/`)

* [x] `biblioteca.model.RecursoBiblioteca` - Clase abstracta con atributos `id`, `titulo` y `estado`.

  * [x] Constructor para `id` y `titulo`.
  * [x] Getter para título y método abstracto `String descripcion()`.
  * [x] Subclases de RecursoBiblioteca

	* [x] `Libro (String autor)`
	* [x] `Revista (int numeroEdicion)`
	* [x] `DiscoMusical (int duracion)`
	* [x] `Pelicula (int duracion)`
	* [x] Cada subclase debe:

      * [x] Llamar al constructor de la superclase.
      * [x] Implementar `descripcion()` retornando todos sus datos.

* [x] `biblioteca.enums.EstadoRecurso` con las opciones `DISPONIBLE`, `PRESTADO` y `RESERVADO`.
* [x] `biblioteca.model.Usuario`

  * [x] Atributos `id` (String) y `nombre` (String).
  * [x] Constructor y getters.

* [x] `biblioteca.app.Main`

Las estructuras son posibles sugerencias. Si usáramos el atributo id y es un número muy
largo entonces la key del primer Map “recursos” tendría que ser deltipo adecuado.
Mantiene dos mapas, o diccionarios:

```java
Map<String, RecursoBiblioteca> recursos;
Map<String, Usuario> usuarios;
```

* [ ] Lee comandos de consola (`Scanner` o similar) y llama a los métodos de la interfaz `Prestamista` implementada quizá en una clase `BibliotecaManager` que extienda/implemente lo necesario.

# Sistema de Gestión de Biblioteca (POO Java)

## Información del Estudiante
* **Nombre:** [Tu Nombre Completo]
* **Curso:** Programación Orientada a Objetos
* **Entrega:** ACA - Proyecto Final (Modalidad Individual)

## Descripción del Proyecto
Aplicación interactiva por consola desarrollada en Java que gestiona inventarios de libros físicos y digitales, control de préstamos, búsquedas con excepciones personalizadas y recorrido de datos.

## Funcionalidades
1. Registrar libro (Normal o Digital).
2. Mostrar libros con estadísticas de disponibilidad.
3. Prestar libro (modificación de disponibilidad y control de excepciones).
4. Salida del sistema.

## Clases y Arquitectura
* `modelo.Libro`: Clase base con encapsulamiento.
* `modelo.LibroDigital`: Subclase con herencia y polimorfismo.
* `modelo.Biblioteca`: Contenedor y gestor con `ArrayList`.
* `excepciones.LibroNoEncontradoException`: Excepción personalizada.
* `Main`: Control del menú interactivo, arreglos y try-catch.
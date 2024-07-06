<h1>Product Microservice</h1>
<h6>Este proyecto fue desarrollado con fines exclusivamente didacticos 📙</h6>

![image](https://github.com/Bautistadev/MicroService_product-Service/assets/76666780/b55d6630-81d4-456f-bdfe-16a6333da13b)

<em>Índice</em>
- [Descripcion del proyecto](#Descripcion-del-proyecto)
- [Gestor de dependencias](#Gestor-de-dependencias).
- [Descripcion de las dependencias](#Descripcion-de-las-dependecias)
- [Descripcion de las herramientas CI/CD](#Descripcion-de-las-herramientas-CI/CD).
- [Seguridad](#Seguridad).
- [Demostración de funciones y aplicaciones](#Demostracion-de-funciones-y-aplicaciones).

## Descripcion del proyecto
---
En este proyecto, se desarrolló un pequeño micro servicio que tiene como tarea brindar a quines consuman de este, todo el catalogo de productos
del negocio que lo utilize.
Es un componente clave de una arquitectura de microservicios, diseñado para gestionar todas las operaciones relacionadas con los productos en 
en una plataforma de comercio electrónico.
<h6>Funcionalidad Principal</h6>

- Gestión de Productos: Permite la creación, actualización, eliminación y consulta de productos.
- Inventario: Permite el almacenamiento de las caracteristicas de los productos en una base de datos.

<h6>Version java</h6>
11

<h6>Interfaz y Comunicación</h6>
APIs RESTful: Proporciona una serie de endpoints RESTful que permiten a otros servicios y aplicaciones cliente interactuar con el catálogo de productos. Estos endpoints incluyen:


- 🔵 GET /productos: Obtener una lista de productos.
- 🟢 POST /productos: Crear un nuevo producto.
- 🟡 PUT /productos/{id}: Actualizar un producto existente.
- 🔴 DELETE /productos/{id}: Eliminar un producto.
- 🔵 GET /productos/{id}: Obtener detalles de un producto específico por medio del id.

<h6>Despliegue y escalabilidad</h6>

- Despliegue independediente: Puede ser deplegado de forma independiente, lo que facilita su actualizacion y mantenimiento sin que este afecte a otros componentes/microservicios.
- Escalabilidad horizontal: Puede escalarse de forma horizontal de tal forma de aumetar la capasidad de atencion y manejar los aumentos de trabajo para evitar la satucion del servicio.


## Gestor de dependencias
--
<h6>Maven</h6> 
Maven es una herramienta de desarrollo de software para la gestion y contruccion de proyectos Java. Basado en el concepto de un modelo de objetos de proyecto.
Maven pude gestionar la creacion, los informes y la documentacion de un proyecto a partir de una pieza central de informacion.
Es similar en funcionalidad a Apache Ant, pero tiene un modelo de configuración de construcción más simple, basado en un formato XML.

<h6>Version utilizada en el proyecto:</h6> 
3.2.2

## Descripcion de las dependencias
---

<h4>Actuator</h4>
El desarrollo y la gestion de una aplicacion son los dos aspectos mas importantes dentro del ciclo
de vida de la misma. Es muy importante saber que sucede debajo de la aplicacion, nunca debemos dejar 
de lado la hipotisis de que el sistema caerá, nunca debemos prepararnos para cuando que el sistema caiga (futuro impredesible), sino
que nos preparamos porque este caerá y poder evitarlo(hoy).
Además, cuando la ponemos en producción, su gestión adquiere una importancia fundamental. 
Por lo tanto, siempre se recomienda supervisar la aplicación tanto en la fase de desarrollo como en la de producción.

Para el mismo caso de uso, Spring Boot proporciona una dependencia de actuator que se puede usar para 
el monitoreo y administacion de tu aplicacion Spring Boot con el uso de los 
End Point "/actuator" y "/actuator/health"

![image](https://github.com/Bautistadev/MicroService_product-Service/assets/76666780/d5bf3c96-d418-4e39-b04c-a40abfb35774)

<h4>Configuracion de actuator</h4>
Para utilizar 'Actuator' adebemos agregar la siguiente dependencia en el archivo de configuracion del proyecto
de la aplicacion.

```
+ Maven

<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

```
+ Gradle

 dependencias de build.gradle { 
    implementación 'org.springframework.boot:spring-boot-starter-actuator' 
}
```
> [!NOTE]
> Como mencionamos anteriormente, Spring Boot proporpociona End Points para la gestion y monitorio de la apliacion con actuator. Pero tambien nos brinda la posibilidad de
> habilitarlos o no. Para ello y no extender demaciado este documento, dejo el Link con estas propiedades:
> (https://docs.spring.io/spring-boot/docs/2.1.13.RELEASE/reference/html/production-ready-endpoints.html)



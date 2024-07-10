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
> 

<h4>JPA</h4>
Spring Data JPA, parte de la familia de Spring Data mas grande, Facilita la implementacion de repositorios basados en JPA(Java Persistence API). Su enfoque principal se orienta a la creacion y manipulacion de base de datos con arquitectura relacional
<h6>Por que JPA? 🤔</h6>
La implemetacion de una capa de acceso a la base de datos, a la hora de desarrollar un apliacion, suele ser complicada y tardia. Se debe escribir demasiado codigo repetitivo para ejecutar consultas simples.
Spring Data JPA tiene como objetivo mejorar de manera significante la implelemtacion de capas de accesop a los datos, al reducir el esfuerzo a la cantidad que realmente necesita.

```
+ Maven
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

```
+ Implemetacion
public interface ProductRepository implements JpaRepository
```
>[!NOTE]
>Link para mas informacion:
>(https://spring.io/projects/spring-data-jpa)
>(https://spring.io/guides/gs/accessing-data-jpa)
>(https://www.arquitecturajava.com/spring-boot-jpa-y-su-configuracion/)

<h4>Spring Cloud</h4>
Spring Cloud ofrece herramientas para que los desarrolladores creen rápidamente algunos de los patrones comunes en sistemas distribuidos(por ejemplo, administracionde la configuracion, descubrimiento de servicios, diyuntores, enrutamiento, etc).
<h6>¿Por que Spring Cloud? 🤔</h6>
La coordinacion de los sistemas distribuidos conduce a patrones y, con Spring Cloud, los desarroladores tiene la posibilidad de crear servicion y aplicaciones de manera rapida que implementen esos patrones.

<h6>Eureka Client</h6>
El descubrimientos de los servicios es uno de los principios clave de la arquitectura basa en microservicios. Pero configurar manualmente la coneccion de cada microservicios cliente  u otra forma a convencion, resulta ser muy dificil y fragil. Eureka es servidor y cliente de descubrimiento de servicios de Netflix. El servidor se puede configurar e implementar para wue tenga alta disponibilidad, y cada servidor replica el estado de los servicios.

```
+ Maven
<dependency>
   <groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
	<version>4.0.3</version>
</dependency>
```

```
+ Properties
eureka.instance.instance-id=(Id que identifica al microservicio)
```

```
+ Implemetacion
@EnableDiscoveryClients //Habilitamos cliente aureka
public class MainApplication
```
Si todo esta correcto y no demanda la correccion de errores en sus ejecucion. Nuestro microservicio deberia verse reflejado en el cuadro de intancias.
![Captura de pantalla 2024-07-09 203008](https://github.com/Bautistadev/MicroService_product-Service/assets/76666780/b9993228-4d1b-4915-ad38-52bc4a6b553e)

<h6>Openfeign</h6>
Feign es una libreria desarrollada por Netflix que nos permite generar clientes de serviciso web de forma declarativa. Es una muy buena alternativa de RestTemplate, ademas de integra muy bien con otras herramientas de Spring Cloud como Eureka, Hystrix y Ribbon.
Teniendo en cuenta que ya estamos utilizando Eureka para registrar y descubrir nuestros micro-servicios vamos a ver cómo comunicar dos micro-servicios. Es importante decir que ambos micro-servicios están desarrollados con Java y Spring Boot, ambos exponen una API Rest con endpoints que me permiten consultar, crear, actualizar y eliminar registros de la base de datos y ya están configurados como clientes de Eureka.

```
+ Maven
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```

```
+ Implemetacion
@EnableFeignClients //Habilitamos cliente aureka
public class MainApplication
```

![Diagrama sin título](https://github.com/Bautistadev/MicroService_product-Service/assets/76666780/eafdce4e-cc3e-4184-a1ed-d65d66d71fc0)


>[!NOTE]
>Consta que la implementacion de esta dependencia es crucial para la realizacion de las consultas por parte del microservicio de Shopping microservice.

<h6>Bootstrap</h6>
Spring Cloud Config ofrece compatibilidad del lado del servidor y del lado del cliente para la configuración externalizada en un sistema distribuido. Con Config Server, tiene un lugar central para administrar las propiedades externas de las aplicaciones en todos los entornos. Los conceptos tanto del cliente como del servidor se asignan de manera idéntica a Spring Environmenty PropertySourcelas abstracciones, por lo que se adaptan muy bien a las aplicaciones Spring, pero se pueden usar con cualquier aplicación que se ejecute en cualquier lenguaje. A medida que una aplicación avanza por el proceso de implementación desde el desarrollo hasta la prueba y la producción, puede administrar la configuración entre esos entornos y estar seguro de que las aplicaciones tienen todo lo que necesitan para ejecutarse cuando migran. La implementación predeterminada del backend de almacenamiento del servidor usa git, por lo que admite fácilmente versiones etiquetadas de entornos de configuración y, además, es accesible para una amplia gama de herramientas para administrar el contenido. Es fácil agregar implementaciones alternativas y conectarlas con la configuración de Spring.




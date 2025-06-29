# Estructura de Componentes BackEnd 

Este documento describe la organización de los principales paquetes y componentes del backend de la aplicación. El proyecto está diseñado siguiendo los principios de arquitectura por capas y separación de responsabilidades, además utiliza el patrón CQRS, esto permite que el proyecto posea una estructura modular, mantenible y escalable.

---
## Configuración del entorno
#TODO
---

## Estructura General del Proyecto

```
main
└── java
    └── ucr.ac.cr.BackendVentas
        ├── api
        │   ├── exceptions
        │   ├── rests
        │   └── types
        ├── handlers
        │   ├── commands
        │   │   ├── impl     
        │   └── queries
        │       └── impl
        ├── jpa
        │   ├── entities
        │   └── repositories
        └── BackendVentasApplication.java
└── resources
```

---
## Tecnologías

- **Lenguaje de Programacion:** Java
- **JDK:** versión 21
- **Spring Boot:** se utiliza  Spring Boot 3.4.4 para la gestión de la aplicación y la implementación de servicios web.
- **Spring Cloud Version:** versión compatible con Spring Boot 3.4.4, usado para facilitar la comunicación entre microservicios y gestionar la configuración distribuida.
- **Spring Dependency Management:** encargado de manejar las bibliotecas necesarias para el proyecto, trabajará en conjunto con el gestor de depdencias empleado
- **Base de Datos:** falta especificar (NoSQL o SQL)
- **Eureka:**  servidor de descubrimiento de servicios de Spring Cloud, que se empleará para que los microservicios se registren y descubran entre sí de manera automática, incluyendo balanceo de carga y manejo de concurrencia.

- **Gestor de Dependencias:** Gradle, empleados para compilar, empaquetar y gestionar el ciclo de vida del proyecto.
  - **Hibernate (SQL):** como la implementación de JPA por defecto en Spring Boot. Hibernate se encarga de transformar objetos de Java en registros de base de datos y viceversa, permitiendo trabajar con datos de manera más intuitiva y sin necesidad de escribir consultas SQL manualmente. Además, Hibernate optimiza el rendimiento con características como caching, lazy loading y gestión automática de transacciones.
- **Configuraciones Adicionales:**
  - ...falta especificar
---


---
## Paquetes y Componentes
- **ucr.ac.cr.BackendVentas:** Es el paquete raíz del proyecto. Contiene todos los submódulos organizados de acuerdo con su responsabilidad dentro de la arquitectura.
- **api:** Contiene los componentes expuestos al exterior, principalmente los controladores y definiciones de tipos usados en las APIs.
    - **exceptions:** Manejo de excepciones personalizadas que pueden ser lanzadas por la lógica de negocio o por errores específicos de la aplicación.
    - **rests:** Controladores REST que gestionan las peticiones HTTP entrantes y delegan la lógica a los manejadores (handlers).
    - **types:** Clases que representan objetos de transferencia de datos (DTOs), usados en las peticiones y respuestas de la API.
- **handlers:** Se encarga de la lógica de negocio mediante una separación por responsabilidad.
    - **commands:** Manejadores que ejecutan operaciones que modifican el estado del sistema (crear, actualizar, eliminar).
         - **impl:** Implementaciones específicas de los comandos.
    - **queries:** Manejadores que procesan operaciones de lectura o consulta del sistema, sin modificar el estado.
        - **impl:** Implementaciones específicas de las consultas.
- **jpa:** Responsable del acceso a la base de datos mediante JPA (Java Persistence API).
    - **entities:** Clases que representan las tablas de la base de datos. Son los modelos persistentes de la aplicación.
    - **repositories:** Interfaces que extienden JpaRepository u otras, para manejar la persistencia de las entidades de forma abstracta.
- **models:** Contiene clases de modelo de dominio que encapsulan reglas de negocio o estructuras reutilizables dentro del sistema. Estas clases pueden ser independientes de la persistencia o la exposición vía API.
- **services:** Contiene la lógica de negocio reutilizable y centralizada que puede ser utilizada tanto por controladores (api/rests) como por comandos o queries. Ayuda a mantener una lógica más limpia y desacoplada del resto del sistema.
- **resources:** Contiene archivos de configuración y recursos estáticos como application.properties o application.yml, necesarios para la ejecución del backend.
---


---
## Configuración y Levantamiento del Entorno

### 1. Levantar Eureka: 
Eureka es el servidor de descubrimiento de servicios de Spring Cloud, utilizado para que los microservicios se registren y descubran entre sí de manera automática.

**Pasos para levantar Eureka:**

* Navegar al directorio de Eureka:

    ```powershell
    cd <ruta-del-proyecto>\eureka
    ```
* Usar Gradle para construir y ejecutar Eureka:
    ```powershell
    gradle wrapper
    .\gradlew.bat bootRun
    ```
Eureka estaría corriendo en el puerto 8761 (por defecto). Donde para acceder al panel de control de Eureka se debe abrir la siguiente URL en el navegador:
[http://localhost:8761](http://localhost:8761)
Aquí se podrá ver los servicios registrados y gestionarlos.
### 2. Levantar Gateway (API Gateway)
El API Gateway es un servicio que se encarga de gestionar las solicitudes que llegan a los microservicios y enrutarlas al servicio adecuado.
**Pasos para levantar Gateway:**
* Navegar al directorio del Gateway:
    ```powershell
    cd <ruta-del-proyecto>\gateway
    ```
* Usar Gradle para construir y ejecutar el Gateway:
    ```powershell
    gradle wrapper
    .\gradlew.bat bootRun
    ```
El Gateway se ejecutará en el puerto 8080 por defecto, al cual se accede través de la URL:
[http://localhost:8080](http://localhost:8080)
Las solicitudes entrantes serán redirigidas a los microservicios registrados en Eureka.
### 3. Levantar Servicio de Autenticación (Authentication Service)
El servicio de autenticación maneja la validación de usuarios y la emisión de tokens (por ejemplo, JWT).
**Pasos para levantar el Servicio de Autenticación:**
* Navegar al directorio del Servicio de Autenticación:
    ```powershell
    cd <ruta-del-proyecto>\authentication-service
    ```
* Usar Gradle para construir y ejecutar el Servicio de Autenticación:
    ```powershell
    gradle wrapper
    .\gradlew.bat bootRun
    ```
El servicio se ejecutará en el puerto 8081, y estará accesible a través del Gateway en [http://localhost:8080/authentication-service](http://localhost:8080/authentication-service).
### 4. Levantar Servicio Básico (Basic Service)
Este servicio maneja operaciones básicas de negocio y puede interactuar con otros servicios.
**Pasos para levantar el Basic Service:**
* Navegar al directorio del Basic Service:
    ```powershell
    cd <ruta-del-proyecto>\basic-service
    ```
* Usar Gradle para construir y ejecutar el Basic Service:
    ```powershell
    gradle wrapper
    .\gradlew.bat bootRun
    ```
El servicio se ejecutará en el puerto 8082, y estará accesible a través del Gateway en [http://localhost:8080/basic-service](http://localhost:8080/basic-service).
### Configuración Adicional
* **Base de Datos:** *pendiente.
* **Puertos y URLs:** *pendiente (se usan genéricos)
---
## Bibliografía
- A. Factor, “Qué es la arquitectura en capas: descubre sus ventajas y ejemplos,” Latam Tech - Transformación Digital, Sep. 14, 2023. https://latamtech-sac.com/que-es-la-arquitectura-en-capas-descubre-sus-ventajas-y-ejemplos/
- K. P. Singh, “System design: Command and Query Responsibility Segregation (CQRS),” DEV Community, Sep. 15, 2022. https://dev.to/karanpratapsingh/system-design-command-and-query-responsibility-segregation-cqrs-1kl1

---
**Documento Preparado Por:** JeanCarlo Calderón, Aarón Chacón, Álvaro Siles, Jose Solano
**Fecha:** 02-04-2025
# **Guía de Pruebas**

## **1. Plan de Ejecución de Pruebas**

> **Nota:** Las herramientas mencionadas en esta guía (JUnit, Mockito, Spring Boot Test, Postman, Cypress, etc.) son opciones viables sugeridas para la implementación de pruebas. Su uso dependerá del contexto, recursos disponibles y decisión del equipo. Se pueden emplear unas u otras herramientas según se considere más adecuado.

El presente plan de pruebas describe los tipos de pruebas que se llevarán a cabo para garantizar la calidad y confiabilidad del sistema desarrollado. Las pruebas serán ejecutadas con el soporte de bibliotecas como JUnit, Mockito, Spring Boot Test y herramientas de pruebas complementarias como Postman y Cypress, según corresponda.

### **1.1 Tipos de Pruebas a Ejecutar**

* **Pruebas Unitarias:**
  Se enfocan en verificar el correcto funcionamiento de métodos individuales o clases aisladas. Utilizan bibliotecas como JUnit 5 y Mockito para validar el comportamiento esperado a nivel de componentes. Se empleará H2 como base de datos en memoria para pruebas aisladas.

* **Pruebas de Integración:**
  Evalúan la interacción entre componentes del sistema (por ejemplo, controladores, servicios y repositorios). Se realizarán utilizando Spring Boot Test y Testcontainers, donde aplique.

* **Pruebas Funcionales (Backend):**
  Se validará el comportamiento de los endpoints REST de forma **manual**, utilizando **Postman**. Esta estrategia permite validar la conectividad, entradas/salidas esperadas y la integración entre microservicios dentro del entorno actual de desarrollo.

* **Pruebas Funcionales (Frontend):**
  Se realizarán pruebas **automatizadas end-to-end** utilizando **Cypress**, permitiendo validar la interacción del usuario con el sistema a través de flujos completos desde la interfaz gráfica. Además, se realizarán **pruebas manuales** enfocadas en validar el flujo visual y funcional del sistema, complementadas con capturas de pantalla como evidencia.

* **Pruebas de Regresión:**
  Se aplicarán de forma continua para validar que funcionalidades previamente implementadas no se vean afectadas por cambios recientes en el código fuente. Estas pruebas serán ejecutadas como parte de las rutinas de integración continua (CI/CD).

## **2. Escenarios de Pruebas según las Historias de Usuario**

Cada historia de usuario documentada en el backlog cuenta con uno o más criterios de aceptación, los cuales servirán como base para la definición de los casos de prueba. El objetivo es validar el cumplimiento funcional desde el punto de vista del usuario final.

### **2.1 Identificación de Criterios de Aceptación**

Los criterios de aceptación definen el comportamiento esperado de una funcionalidad. Estos serán extraídos de cada historia de usuario con el fin de establecer condiciones objetivas de verificación.

### **2.2 Definición de Casos de Prueba**

Para cada historia de usuario se elaborarán casos de prueba que cubran (esto a consideración de tiempo para poder realizar estas pruebas, se puede hacer una u otra):

* El flujo principal o escenario nominal.
* Flujos alternativos o secundarios.
* Manejo de errores y validaciones.

**Ejemplo de caso de prueba:**

| Caso de Prueba | Descripción              | Entrada                          | Resultado Esperado              |
| -------------- | ------------------------ | -------------------------------- | ------------------------------- |
| CP-001         | Inicio de sesión exitoso | usuario: admin, clave: 123456    | Acceso a panel de control       |
| CP-002         | Clave incorrecta         | usuario: admin, clave: xyz123    | Mensaje de error en pantalla    |
| CP-003         | Campos vacíos            | usuario: (vacío), clave: (vacío) | Validación visual en formulario |

### **2.3 Validación de Flujos Alternativos y Manejo de Errores**

Se diseñarán pruebas específicas para evaluar condiciones excepcionales, incluyendo:

* Entrada de datos inválidos.
* Respuestas del sistema ante servicios no disponibles.
* Comprobación de restricciones de negocio.

## **3. Resultados de Ejecución de Pruebas**

### **3.1 Registro y Documentación de Resultados**

Los resultados de cada suite de pruebas serán documentados dentro de IntelliJ IDEA y exportados, si corresponde, en formatos compatibles (HTML, XML) mediante herramientas de construcción como Maven o Gradle. En el caso de Cypress, los reportes se documentarán automáticamente en formato visual (capturas) y logs.

Se incluirán las siguientes evidencias:

* Fecha y hora de ejecución.
* Resultado (éxito o fallo).
* Captura de pantalla (para pruebas de UI).
* Logs o trazas relevantes.

### **3.2 Reporte de Errores y Seguimiento**

Todo error detectado durante la ejecución será reportado y clasificado según su severidad. El reporte incluirá:

* Descripción detallada del incidente.
* Pasos para reproducirlo.
* Evidencia visual o textual.
* Estado actual (abierto, en análisis, resuelto).
* Responsable asignado.

Los errores serán registrados y gestionados a través de herramientas de seguimiento como Jira, GitHub Issues o YouTrack.

### **3.3 Criterios de Aprobación para el Pase a Producción**

Una versión del sistema podrá ser promovida a producción únicamente si:

* El 100% de los casos de prueba críticos y de prioridad alta son aprobados.
* No existen errores de severidad crítica o bloqueante abiertos.
* Las pruebas de regresión confirman la estabilidad del sistema.
* El equipo de QA emite la validación formal de calidad.

## **4. Pruebas Automatizadas Críticas (Proceso de Compra)**

Dado que la funcionalidad de **procesar compra** presenta alta complejidad, se recomienda la implementación de pruebas automatizadas para asegurar su correcto funcionamiento. Esta funcionalidad incluye:

* Creación de órdenes y líneas de orden.
* Asociación correcta de productos con pymes.
* Rollback en caso de errores.
* Validación de precios, descuentos y totales.

### **4.1 Herramientas para Pruebas Automatizadas**

* **JUnit 5**
* **Spring Boot Test**
* **H2** como base de datos en memoria

### **4.2 Casos a Automatizar**

* Cálculo del monto total de una orden con múltiples productos y descuentos.
* Aplicación correcta de promociones por pyme o cantidad.

Esta estrategia garantiza que las funcionalidades críticas se mantengan estables y libres de errores durante futuras actualizaciones del sistema.

---

**Documento realizado por Luis Daniel Solano Solano**
**Fecha de actualización: 26/06/2025**
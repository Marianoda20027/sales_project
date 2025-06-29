# Minuta de Planning Sprint 4

**Fecha:** 15-06-2025

**Medio:** Asincronico 


---

## Agenda

### 1. Planning Sprint 4

### 2. Peso de las tareas 

### 3. Continuación de historias de usuario pasadas



---

## Discusión


## Sprint 4 – Planning 

### Objetivo del Sprint

Asegurar el cierre de funcionalidades clave del sistema, incluyendo el registro y publicación de productos, la búsqueda, el proceso de compra y el soporte estructural de base de datos, mediante pruebas integrales y validaciones funcionales que permitan avanzar a una etapa de integración más amplia.

---

### Historias y tareas activas del Sprint 3 para el Sprint 4

#### User Stories Principales

| Historia               | Estado         | Puntos |
| ---------------------- | -------------- | ------ |
| #1 Registrar Pymes     | Ready for Test | 13 pts |
| #2 Publicar Productos  | Ready for Test | 13 pts |
| #3 Localizar productos | In Progress    | 40 pts |
| #4 Procesar Compra     | In Progress    | 40 pts |
| #38 Base de datos      | Ready for Test | 5 pts  |

#### Subtareas asociadas a #4 Procesar Compra

| Task ID | Descripción                                        | Estado |
| ------- | -------------------------------------------------- | ------ |
| #67     | CU-04-01 Agregar producto al carrito               | New    |
| #68     | CU-04-03 Modificar cantidad de producto en carrito | New    |
| #69     | CU-04-02 Visualizar carrito                        | New    |
| #70     | CU-04-04 Eliminar producto del carrito             | New    |
| #86     | CU-04-05 Completar formulario de compra (frontend) | New    |

#### Otras tareas activas

| Task ID | Descripción                                 | Estado      |
| ------- | ------------------------------------------- | ----------- |
| #78     | Spike definición de tablas de los servicios | In Progress |
| #79     | Testing funcionalidad backend – #1          | In Progress |
| #80     | Testing funcionalidad frontend – #2         | In Progress |
| #81     | Testing funcionalidad frontend – #1         | In Progress |
| #83     | Testing funcionalidad backend – #2          | In Progress |
| #91     | Testing funcionalidad frontend – #3         | New         |
| #92     | Testing funcionalidad backend – #3          | New         |

---

### Entregables del Sprint

* Historias #1, #2 y #3 completamente validadas con evidencia de pruebas.
* Proceso de compra (#4) parcialmente implementado con funcionalidades de carrito y formulario funcional.
* Testing de funcionalidades frontend y backend documentado.
* Documento formal del modelo de datos (resultado de #78).
* Base de datos validada y operativa para servicios actuales.

---

## Encuestas de estimación de esfuerzo – Sprint 4

Se listan las historias de usuario y tareas técnicas activas para el Sprint 4. Cada una incluye una descripción breve que resume su estado actual y lo pendiente por completar, con el fin de facilitar la asignación de esfuerzo por parte del equipo.

---

### Historia: Base de datos

**Descripción breve:**
Se configuraron las bases de datos necesarias para cada microservicio. Actualmente se encuentran listas para prueba, por lo que falta validar la conexión con los servicios, realizar pruebas de inserción y consulta, y documentar la configuración final. Es clave asegurar que cada servicio interactúe correctamente con su base.

---

### Historia: Registrar Pymes

**Descripción breve:**
La historia se encuentra en estado de pruebas. El formulario de registro ya fue implementado tanto en frontend como en backend. Lo pendiente es completar y validar el testing de funcionalidad, verificar el envío de correos de verificación y asegurar el cumplimiento de los criterios de aceptación definidos.

---

### Historia: Publicar Productos

**Descripción breve:**
La funcionalidad permite que una pyme publique productos con nombre, precio, categoría y fotos. Lo que queda por realizar es validar el flujo completo mediante pruebas frontend y backend, asegurar que los productos se almacenen correctamente y que la funcionalidad de despublicar y stock se comporte según lo esperado.

---

### Historia: Localizar Productos

**Descripción breve:**
El componente de búsqueda y filtrado ya está en desarrollo. Faltan pruebas funcionales para asegurar que el sistema filtre por categoría, disponibilidad y precio, y que el ordenamiento funcione correctamente. También se debe verificar la experiencia de usuario en dispositivos móviles y la respuesta de los endpoints.

---

### Historia: Procesar Compra

**Descripción breve:**
Esta historia involucra varias funcionalidades relacionadas con el carrito: agregar, modificar cantidad, eliminar productos y completar el formulario de compra. Actualmente, las tareas están en estado inicial. Se debe desarrollar, conectar y validar cada uno de estos flujos, asegurando que se cumpla la lógica de una compra por pyme y que los datos se guarden correctamente.

---

### Historia: Servicio de Inteligencia Artificial

**Descripción breve:**
El sistema debe incorporar un servicio de inteligencia artificial que analice datos de productos, ventas y comportamiento de usuarios para generar recomendaciones personalizadas y detectar tendencias de mercado. Lo pendiente es diseñar y desarrollar el servicio, definir las APIs, validar la privacidad de los datos y asegurar su integración con los microservicios existentes.

---

### Historia: Sitio personalizado para Pyme

**Descripción breve:**
Cada pyme registrada podrá personalizar su sitio en la plataforma con su información, logo, banner y productos destacados. Falta implementar el diseño del sitio personalizado, habilitar las opciones de personalización en el panel de la pyme y desarrollar la vista pública accesible desde productos o la lista de tiendas.

---

### Historia: Registro de usuario

**Descripción breve:**
Permite que nuevos usuarios se registren proporcionando sus datos personales. Se debe validar el formulario, verificar duplicidad de correo, almacenar de forma segura los datos y enviar un correo de confirmación. Lo pendiente es finalizar las validaciones, confirmar el correcto funcionamiento del flujo y asegurar la experiencia del usuario durante el registro.



## Próxima Reunión

**Fecha:** 18-06-2025

**Hora:** 6:30 pm

**Agenda:**

- Reunión de control sobre el estado del sprint.

---

**Minuta Preparada Por:** Luis Daniel Solano

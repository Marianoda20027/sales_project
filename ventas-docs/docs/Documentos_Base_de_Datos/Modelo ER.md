
# Comunicación entre Microservicios

### **Relación entre Microservicios**

1. **Ventas_Service**  
    Se encarga de la gestión de productos, carritos de compra y pedidos de productos por parte de los usuarios cliente. Este servicio interactúa con el Email_Service para enviar formularios de compra a clientes y PYMEs. Además, se comunicará con **Auth_Service** para obtener la información del cliente autenticado (como el user_id) al momento de procesar un pedido, utilizando el token JWT que el cliente envía con cada solicitud. Ventas_Service puede decodificar este token para autenticar al usuario y asociar el pedido con el cliente correspondiente, sin necesidad de hacer una consulta adicional a **Auth_Service**.
    
2. **Email_Service**  
    Se activa en varias etapas del proceso, incluyendo la verificación del registro de nuevos usuarios y PYMEs. Además, envía correos de confirmación de pedido y notificaciones tanto al cliente como a la PYME. También interactúa con el Ventas_Service para enviar estos correos después de que se haya generado un pedido.

    
3. **Auth_Service**  
    Este servicio se encarga de autenticar y autorizar a los usuarios en el sistema. Asegura que solo los usuarios válidos y registrados puedan realizar compras o acceder a ciertas funciones del sistema. Interactúa con **Ventas_Service** para validar la identidad del cliente a través de un token JWT y con **Email_Service** para verificar el registro de usuarios y gestionar la verificación de correo electrónico.
    Además, se encargará de disponer la información de usuarios y PYMES al **Ventas_Service** para cuando se requiera gestionar pedidos
    
4. **AI_Service**  
    __**aún por definir**__


# Descripción de las Tablas de las diferenes Bases de Datos


### Nota de Versión:
- Las tablas relacionadas con el carrito deben ser consultadas con el profesor para determinar si se mantienen o se descartan, considerando la opción de manejar los carritos desde el LocalStorage o SessionStorage del navegador.
- Aún falta definir si las tablas `users` y `pymes` deben estar en el servicio de **Autenticación** o en el de **Ventas**, ya que ambas cumplen funciones críticas en ambos servicios.


# 1. Servicio de Ventas

#### **Tabla de Productos (products)**

Guarda la información sobre los productos que venden las PYMEs.
        
#### Estructura de la tabla

| Atributo      | Tipo de Dato                                  | Descripción                                                    |
| ------------- | --------------------------------------------- | -------------------------------------------------------------- |
| `product_id`  | UUID, PRIMARY KEY, NOT NULL                   | Identificador único del producto.                              |
| `pyme_id`     | UUID, FOREIGN KEY (`pymes.pyme_id`), NOT NULL | Referencia a la PYME que ofrece el producto.                   |
| `name`        | VARCHAR(255), NOT NULL                        | Nombre del producto.                                           |
| `description` | TEXT, NOT NULL                                | Descripción detallada del producto.                            |
| `price`       | DECIMAL(10,2), NOT NULL                       | Precio del producto.                                           |
| `available`   | BOOLEAN, NOT NULL                             | Indica si el producto está disponible para la venta.           |
| `promotion`   | DECIMAL(5,2), NULL                            | Porcentaje de promoción aplicado al producto, si aplica.       |
| `stock`       | INTEGER, NOT NULL                             | Cantidad disponible en inventario.                             |
| `url_img`     | VARCHAR(512), NULL                            | URL de la imagen del producto.                                 |
| `is_active`   | BOOLEAN, NOT NULL, DEFAULT `true`             | Indica si el producto está activo y visible para los usuarios. |


#### **Tabla de Categorías (categories)**

Define las categorías de productos.

Estructura de tabla

| Atributo      | Tipo de Dato                   | Descripción                          |
| ------------- | ------------------------------ | ------------------------------------ |
| `category_id` | INTEGER, PRIMARY KEY, NOT NULL | Identificador único de la categoría. |
| `name`        | VARCHAR(100), UNIQUE, NOT NULL | Nombre único de la categoría.        |
| `description` | TEXT, NULL                     | Descripción general de la categoría. |


#### **Tabla de Relación Productos-Categorías (product_categories)**

Establece la relación entre productos y categorías.  

#### Estructura de la tabla

| Atributo              | Tipo de Dato                                              | Descripción                                                    |
| --------------------- | --------------------------------------------------------- | -------------------------------------------------------------- |
| `product_category_id` | INTEGER, PRIMARY KEY, NOT NULL                            | Identificador único de la relación entre producto y categoría. |
| `product_id`          | UUID, FOREIGN KEY (`products.product_id`), NOT NULL       | Clave foránea que hace referencia al producto.                 |
| `category_id`         | INTEGER, FOREIGN KEY (`categories.category_id`), NOT NULL | Clave foránea que hace referencia a la categoría.              |


#### **Tabla de Carritos de Compra (shopping_carts)**

Representa el carrito de compra de un usuario.

__se debe consultar con el profe__

#### **Tabla de Productos en Carrito (shopping_cart_products)**

Asocia los productos con un carrito específico.        


__se debe consultar con el profe__

#### **Tabla de Métodos de Pago (payment_methods)**

Almacena los métodos de pago disponibles.

#### Estructura de tabla

| Atributo            | Tipo de Dato                   | Descripción                                  |
| ------------------- | ------------------------------ | -------------------------------------------- |
| `payment_method_id` | INTEGER, PRIMARY KEY, NOT NULL | Identificador único del método de pago.      |
| `name`              | VARCHAR(100), UNIQUE, NOT NULL | Nombre del método de pago.                   |
| `description`       | TEXT, NULL                     | Descripción del método de pago.              |
| `is_active`         | BOOLEAN, NOT NULL              | Indica si el método de pago está habilitado. |


#### **Tabla de Métodos de Envío (shipping_methods)**

Almacena los métodos de envío disponibles.        


#### Estructura de la tabla

| Atributo           | Tipo de Dato | Descripción                                                                                                     |
| ------------------ | ------------ | --------------------------------------------------------------------------------------------------------------- |
| `template_id`      | Integer      | Identificador único de la plantilla. Es la clave primaria de la tabla.                                          |
| `name`             | VARCHAR(100) | Nombre único de la plantilla (e.g., "Bienvenida Usuario", "Confirmación de Compra").                            |
| `subject_template` | TEXT         | Asunto de la plantilla de correo. Puede contener variables dinámicas que serán sustituidas en el envío real.    |
| `body_template`    | TEXT         | Cuerpo de la plantilla de correo. También puede contener variables dinámicas que serán sustituidas en el envío. |


#### **Tabla de Pedidos (orders)**

Contiene los pedidos realizados por los clientes.

#### Estructura de la tabla

| Atributo            | Tipo de Dato        | Descripción                                                                                          |
| ------------------- | ------------------- | ---------------------------------------------------------------------------------------------------- |
| `order_id`          | UUID                | Identificador único del pedido. Es la clave primaria.                                                |
| `user_id`           | UUID (NULL)         | Clave foránea que referencia al usuario que hizo el pedido. Puede ser `NULL`.                        |
| `pyme_id`           | UUID                | Clave foránea que referencia a la pyme a la que se le compró.                                        |
| `order_date`        | DATETIME            | Fecha y hora en la que se generó el pedido.                                                          |
| `total_amount`      | DECIMAL(10,2)       | Monto total del pedido.                                                                              |
| `status`            | VARCHAR(20)         | Estado del pedido: 'pending', 'processing', 'shipped', 'delivered', 'cancelled'.                     |
| `payment_method_id` | INTEGER             | Clave foránea que referencia al método de pago usado.                                                |
| `shipping_method_id`| INTEGER             | Clave foránea que referencia al método de envío seleccionado.                                        |
| `shipping_address`  | VARCHAR(255)        | Dirección de envío proporcionada por el cliente.                                                     |


#### **Tabla de Líneas de Pedido (order_lines)**

Desglosa los productos incluidos en un pedido.

#### Estructura de la tabla

| Atributo         | Tipo de Dato    | Descripción                                                                 |
| ---------------- | --------------- | --------------------------------------------------------------------------- |
| `order_line_id`  | UUID            | Identificador único de la línea de pedido. Es la clave primaria.            |
| `order_id`       | UUID            | Clave foránea que referencia al pedido al que pertenece esta línea.         |
| `product_id`     | UUID            | Clave foránea que referencia al producto incluido en el pedido.             |
| `quantity`       | INTEGER         | Cantidad de unidades del producto solicitadas.                              |
| `unit_price`     | DECIMAL(10,2)   | Precio unitario del producto en el momento de realizar el pedido.           |
| `subtotal`       | DECIMAL(10,2)   | Subtotal de esta línea (quantity × unit_price).                             |


#### **Modelo Entidad Relación**

![[Modelo-ER-Servicio-Ventas.png]]


# 2. Servicio de Correos

#### **Tabla de Correos Enviados (sent_emails)**

Esta tabla almacena la información sobre los correos electrónicos enviados. Es útil para hacer un seguimiento del estado de los correos (si fueron enviados con éxito, si fallaron, si están pendientes, etc.), registrar los errores en caso de fallos y mantener un control de los intentos de reenvío. Este seguimiento es crítico, ya que la plataforma realizará las ventas por medio de correos donde las PYMES y los usuarios se pongan de acuerdo fuera de la plataforma, por lo que el éxito de los correos es vital.

        

#### Estrcutrua de la tabla

#### Estructura de la tabla

| Atributo          | Tipo de Dato        | Descripción                                                                                                                                     |
| ----------------- | ------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------- |
| `email_id`        | UUID                | Identificador único del correo. Es la clave primaria de la tabla.                                                                               |
| `recipient_email` | VARCHAR(255)        | Dirección de correo electrónico del destinatario.                                                                                               |
| `subject`         | VARCHAR(255)        | Asunto del correo enviado.                                                                                                                      |
| `body`            | TEXT                | Cuerpo del correo.                                                                                                                              |
| `sent_at`         | DATETIME            | Fecha y hora en que el correo fue enviado.                                                                                                      |
| `status`          | VARCHAR(20)         | Estado del correo enviado. Puede ser 'sent', 'failed', o 'pending'.                                                                             |
| `error_message`   | TEXT (NULL)         | Mensaje de error si el correo falló en su envío. Será `NULL` si no hubo error.                                                                  |
| `retry_count`     | INTEGER (DEFAULT 0) | Número de intentos de reenvío del correo en caso de que el envío haya fallado.                                                                  |
| `service_origin`  | VARCHAR(50)         | Servicio que originó el correo. Ejemplos: 'auth', 'ventas', etc.                                                                                |
| `metadata`        | JSON (NULL)         | Información adicional del correo en formato JSON, por ejemplo, datos personalizados. Puede ser `NULL` si no aplica.                             |
| `template_id`     | Integer (NULL)      | Clave foránea que hace referencia al identificador de la plantilla utilizada para enviar el correo. Relacionado con la tabla `email_templates`. |



#### **Tabla de Plantillas de Correo (email_templates)**

Esta tabla permite predefinir plantillas de correos que se utilizarán en diferentes momentos del proceso, como correos de verificación de PYMES, nuevos usuarios y confirmaciones de formularios de compra.

#### Estructura de la tabla

| Atributo           | Tipo de Dato | Descripción                                                                                                     |
| ------------------ | ------------ | --------------------------------------------------------------------------------------------------------------- |
| `template_id`      | Integer      | Identificador único de la plantilla. Es la clave primaria de la tabla.                                          |
| `name`             | VARCHAR(100) | Nombre único de la plantilla (e.g., "Bienvenida Usuario", "Confirmación de Compra").                            |
| `subject_template` | TEXT         | Asunto de la plantilla de correo. Puede contener variables dinámicas que serán sustituidas en el envío real.    |
| `body_template`    | TEXT         | Cuerpo de la plantilla de correo. También puede contener variables dinámicas que serán sustituidas en el envío. |


#### **Modelo Entidad Relación**
![[Modelo-ER-Servicio-Correos.png]]



# 3. Servicio de Autenticación


#### **Tabla de Usuarios (users)**

Almacena a los diferentes tipos de usuario que maneja el sistema.
#### Estructura de la tabla

| Atributo        | Tipo de Dato | Descripción                                                       |
| --------------- | ------------ | ----------------------------------------------------------------- |
| `user_id`       | UUID         | Identificador único del usuario. Clave primaria de la tabla.      |
| `email`         | VARCHAR(255) | Correo electrónico del usuario. Debe ser único.                   |
| `password_hash` | VARCHAR(255) | Contraseña encriptada.                                            |
| `first_name`    | VARCHAR(100) | Nombre del usuario.                                               |
| `last_name`     | VARCHAR(100) | Apellido del usuario.                                             |
| `address`       | VARCHAR(255) | Dirección física del usuario.                                     |
| `phone`         | VARCHAR(50)  | Número de teléfono del usuario.                                   |
| `role`          | VARCHAR(20)  | Rol asignado. Ejemplos: 'admin', 'customer', 'admin_pyme'.       |
| `is_active`     | BOOLEAN      | Indica si el usuario está activo o no. Útil para la verificación. |


#### **Tabla de PYMEs (pymes)**

Almacena a las diferentes PYMES que ofrecerán sus productos en el sistema.

#### Estructura de la tabla

| Atributo        | Tipo de Dato                    | Descripción                                     |
| --------------- | ------------------------------- | ----------------------------------------------- |
| `pyme_id`       | UUID, PRIMARY KEY, NOT NULL     | Identificador único de la PYME.                 |
| `name`          | VARCHAR(255), UNIQUE, NOT NULL  | Nombre de la PYME.                              |
| `email`         | VARCHAR(255), UNIQUE, NOT NULL  | Correo electrónico único de la PYME.            |
| `password_hash` | VARCHAR(255), NOT NULL          | Contraseña de la PYME, almacenada como un hash. |
| `address`       | VARCHAR(255), NOT NULL          | Dirección de la PYME.                           |
| `phone`         | VARCHAR(50), NOT NULL           | Teléfono de la PYME.                            |
| `description`   | TEXT, NOT NULL                  | Descripción breve de la PYME.                   |
| `logo_url`      | VARCHAR(255), NULL              | URL del logo de la PYME.                        |
| `is_active`     | BOOLEAN, DEFAULT TRUE, NOT NULL | Estado de activación de la PYME.                |


#### **Tabla Relación N:M entre Usuarios y PYMEs (user_pymes)**

En el sistema, un usuario puede estar asociado con una única PYME, pero una PYME puede tener diferentes administradores, por lo que es necesario gestionar esta relación de manera eficiente Esta tabla permite almacenar las relaciones entre los usuarios (admin_pyme) y las empresas a las que están asociados, permitiendo identificar quiénes son propietarios de cada PYME, si aplica.

#### Estructura de la tabla


| Atributo       | Tipo de Dato                                 | Descripción                                                    |
| -------------- | -------------------------------------------- | -------------------------------------------------------------- |
| `user_pyme_id` | INTEGER, PRIMARY KEY, NOT NULL               | Identificador único de la relación entre el usuario y la PYME. |
| `user_id`      | UUID, FOREIGN KEY (users.user_id), NOT NULL  | Clave foránea que hace referencia al usuario.                  |
| `pyme_id`      | UUID, FOREIGN KEY (pymes.pyme_id), NOT NULL  | Clave foránea que hace referencia a la PYME.                   |
| `is_owner`     | BOOLEAN, DEFAULT FALSE, NOT NULL             | Indica si el usuario es propietario de la PYME.                |


#### **Modelo Entidad Relación**
![[Modelo-ER-Servicio-Autenticación.png]]


### 4. Servicio de IA

falta definir con el grupo


Enlace de modelos de entidad relación

Servicio de ventas:
https://dbdiagram.io/d/Modelo-Entidad-Relacion-6813f6921ca52373f5248249

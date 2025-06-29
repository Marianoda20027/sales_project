### **Caso de Uso 02-03: Publicar Producto**

#### **Descripción**
Este caso de uso describe el proceso mediante el cual una Pyme registrada puede agregar productos en la plataforma de comercio electrónico. El objetivo es permitir a los propietarios de Pymes listar sus productos con detalles esenciales como nombre, descripción, categoría, precio e imágenes, para que estos sean visibles y accesibles a los compradores.

#### **Actores**
- **Primarios:**
    - Pyme (Propietario de la empresa)
- **Secundarios:**
    - Sistema de Plataforma de Ventas

#### **Precondiciones**
- La Pyme debe estar registrada y autenticada en la plataforma.
- La Pyme debe tener acceso al formulario para agregar productos.
- El producto debe cumplir con las políticas de la plataforma (por ejemplo, sin contenido prohibido, imágenes adecuadas, etc.).

#### **Postcondiciones**
- El producto se publica en el catálogo de la plataforma.
- Se genera un identificador único para el producto.
- El producto es visible para los compradores en la plataforma.
- El producto no puede ser editado después de ser publicado, pero puede ser despublicado o tener promociones aplicadas.

#### **Flujo Principal**
1. La Pyme accede al panel de gestión de productos en la plataforma.
2. El sistema presenta el formulario de publicación de productos con los siguientes campos: nombre, descripción, categoría, precio, imágenes del producto, disponibilidad y promoción.
3. La Pyme completa los campos obligatorios y adjunta imágenes del producto.
4. El sistema valida los campos ingresados, asegurando que se cumplan los requisitos de la plataforma (por ejemplo, que se ingresen todos los campos obligatorios).
5. El sistema genera un identificador único para el producto.
6. La Pyme confirma la publicación del producto.
7. El sistema publica el producto en la plataforma, haciéndolo visible para los compradores.

#### **Flujos Alternativos**
- **FA-01: Campos incompletos o inválidos**
    1. La Pyme no completa todos los campos obligatorios o ingresa datos inválidos (por ejemplo, un precio no numérico).
    2. El sistema muestra un mensaje de error, indicando los campos que necesitan corrección.
    3. La Pyme corrige los campos y reenvía el formulario.

- **FA-02: Imágenes no válidas**
    1. La Pyme adjunta una imagen que no cumple con las políticas de la plataforma (por ejemplo, una imagen con contenido inapropiado o de tamaño incorrecto).
    2. El sistema muestra un mensaje de error e impide la publicación hasta que se suba una imagen válida.

#### **Requerimientos Especiales**
- El sistema debe permitir cargar imágenes de productos con formatos compatibles (por ejemplo, JPEG, PNG).
- El sistema debe verificar que todos los campos obligatorios estén completos antes de permitir la publicación.
- Los productos deben cumplir con las políticas de la plataforma para evitar la publicación de productos no permitidos.
- El sistema debe generar un identificador único para cada producto.

#### **Escenarios de Prueba**

| Entrada                                             | Salida Esperada                                           |
|-----------------------------------------------------|-----------------------------------------------------------|
| Nombre del producto: "Producto X", Precio: "$20", Categoría: "Electrónica", Imágenes adjuntas | El producto se publica con un identificador único, visible para los compradores. |
| Ingreso de precio no numérico                       | El sistema muestra un mensaje de error: "El precio debe ser un número válido". |
| Imágenes demasiado grandes o en formato no permitido | El sistema muestra un mensaje de error: "La imagen no cumple con las especificaciones". |
| Todos los campos completos, imagen válida, sin errores | El producto se publica exitosamente en el catálogo de la plataforma. |



#### **Prototipos**

![Prototipo Publicar Producto](https://img.plantuml.biz/plantuml/dpng/XL9BQiCm5DmRV8T7eBlw6pUfkmeaNMGJ3EsY4BoGvLT7hMqPIO6MkeVf0Rhg4NAnof-49ZRq8GJIl9cHHbf8HOII95UcyM4Q07OTxPESKI8W4ZpTKyMRxTfkvWql4e6GOdu2eQrwqgzXGmg4lpLfY2kKLB2AiiDFUORMC7dSCGbw4AtRTYd6I-3Fe7O8LIThjogHGCeu34gB-A4TXaEajryIXHaNXsyoPDxdI9NW9QDoXBak3byPbdY1jSoTKfMySnny8qMLeqrvuR22P2YT_jYU_L9br_1_ezyqTaanMUd393bU-csVudDq2x5-4KXFUrr6lE33dBkGt2kTQnEiZhjtRaqV5AUl8-5fZkUwOx4UyudUzNElLwDCVuh1pMnkuMsOM9wVJYsYrrRWpsPUuCq3rtLRZUsIb1Hp8kB1bRN1yJT2R1gVfh70Cks-woy0)

Documento Preparado Por: Jose Solano Araya
Fecha: 01/05/2025

Versión: 1.0 
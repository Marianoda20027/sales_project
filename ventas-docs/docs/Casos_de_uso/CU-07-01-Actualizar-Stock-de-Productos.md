### **Caso de Uso-7-01-Actualizar Stock de Producto**

#### **Descripción**
Este caso de uso describe el proceso mediante el cual una Pyme registrada puede actualizar la cantidad de stock disponible para un producto publicado en la plataforma de comercio electrónico. Permite asegurar que la información de disponibilidad esté siempre actualizada, evitando la venta de productos agotados.

#### **Actores**
- **Primarios:** Pyme 
- **Secundarios:** Sistema de Plataforma de Ventas

#### **Precondiciones**
- La Pyme debe estar registrada y autenticada en la plataforma.
- La Pyme debe tener productos publicados en la plataforma.
- El producto debe estar publicado y activo en el catálogo.

#### **Postcondiciones**
- La cantidad de stock disponible para el producto se actualiza.
- La nueva cantidad de stock se refleja en el catálogo y en la plataforma de ventas.
- Los compradores solo pueden adquirir productos disponibles.

#### **Flujo Principal**
1. La Pyme accede al panel de gestión de productos en la plataforma.
2. El sistema presenta una lista de los productos publicados por la Pyme.
3. La Pyme selecciona un producto del listado para actualizar su stock.
4. El sistema muestra el formulario de actualización de stock, donde la Pyme puede ingresar la nueva cantidad disponible.
5. La Pyme ingresa la nueva cantidad de stock y confirma la actualización.
6. El sistema valida la cantidad ingresada (debe ser un número válido y mayor o igual a 0).
7. El sistema actualiza el stock en la base de datos.
8. El sistema refleja el cambio de stock en la plataforma, actualizando la disponibilidad del producto para los compradores.

#### **Flujos Alternativos**
- **FA-01: Stock no válido**
  1. La Pyme ingresa un valor no válido para la cantidad de stock (número negativo o no numérico).
  2. El sistema muestra un mensaje de error, indicando que la cantidad de stock no es válida y solicita un valor correcto.

- **FA-02: Error de actualización**
  1. El sistema falla al intentar actualizar el stock (por problemas en la base de datos o fallos de comunicación).
  2. El sistema muestra un mensaje de error y sugiere intentar de nuevo.

#### **Requerimientos Especiales**
- El sistema debe permitir solo números enteros para la cantidad de stock.
- Debe haber validación para evitar cantidades negativas.

#### **Escenarios de Prueba**

| Entrada                                    | Salida Esperada                                |
|--------------------------------------------|-----------------------------------------------|
| Ingreso de stock "50" para un producto     | El producto muestra 50 unidades disponibles.  |
| Ingreso de stock "-5"                      | Mensaje de error: "Cantidad de stock no válida". |
| Error en actualización de base de datos    | Mensaje de error: "Error al actualizar el stock". |


#### **Prototipos**

![Prototipo](https://img.plantuml.biz/plantuml/dpng/HOwn2iCm34HtVON81vGktLEwbq96uu2GDOGQ6novGvl-UqKTjpS8n3kTRboLYguK5Lw0U6Qj59Sd5Pmqyns3uAtaK5cpuUrWe--uQyDvaYZCIqvsr_5irfRHGfiLtUdeZLohFFBE6ndmfy4CxaA99LBn_Olxb_FmXb5I-FQ63m00)



Documento Preparado Por: Jose Solano Araya
Fecha: 28/04/2025

Versión: 1.0 
### **Caso de Uso-7-02-Marcar Producto como Agotado**

#### **Descripción**
Este caso de uso describe el proceso mediante el cual una Pyme registrada puede marcar un producto como agotado, lo que indica que ya no hay stock disponible para su compra.

#### **Actores**
- **Primarios:** Pyme 
- **Secundarios:** Sistema de Plataforma de Ventas

#### **Precondiciones**
- La Pyme debe estar registrada y autenticada en la plataforma.
- El producto debe estar publicado en la plataforma y debe tener stock (aunque mínimo) antes de ser marcado como agotado.

#### **Postcondiciones**
- El producto se marca como agotado y ya no se puede comprar.
- El estado de disponibilidad del producto se actualiza en la plataforma.

#### **Flujo Principal**
1. La Pyme accede al panel de gestión de productos.
2. El sistema presenta la lista de productos publicados y su disponibilidad.
3. La Pyme selecciona un producto que desea marcar como agotado.
4. El sistema muestra una opción para marcar el producto como agotado.
5. La Pyme confirma la acción de marcar el producto como agotado.
6. El sistema marca el producto como agotado en la base de datos y actualiza la disponibilidad en la plataforma.
7. El sistema refleja el cambio en la interfaz de la tienda, mostrando el producto como agotado y desactivando la opción de compra.

#### **Flujos Alternativos**
- **FA-01: Producto ya marcado como agotado**
  1. La Pyme intenta marcar un producto ya agotado.
  2. El sistema muestra un mensaje indicando que el producto ya está marcado como agotado.

#### **Requerimientos Especiales**
- El sistema debe impedir que se compren productos marcados como agotados.
- Debe haber un mecanismo de confirmación antes de marcar el producto como agotado para evitar errores.

#### **Escenarios de Prueba**

| Entrada                                 | Salida Esperada                                 |
|-----------------------------------------|-------------------------------------------------|
| Producto con stock de 0 unidades        | El producto se marca como agotado y no disponible para compra. |
| Producto ya marcado como agotado        | Mensaje de error: "El producto ya está agotado".  |



#### **Prototipos**

![Prototipo](https://img.plantuml.biz/plantuml/dpng/FOvH2iCm28RV0xc39oZR3Te330Pz32s82QCqgs3iovRTVGcE-IB-tuSw5aNHWbczUti7C42T7gmOkVInjg3tkt0yIHb-LM6TKqv46nyeVxnsTrQc7IRI4xEv4AwNfQDWwVP2MGo56mgr3SHF1hJBJVruDwOZscDV)



Documento Preparado Por: Jose Solano Araya
Fecha: 28/04/2025

Versión: 1.0 
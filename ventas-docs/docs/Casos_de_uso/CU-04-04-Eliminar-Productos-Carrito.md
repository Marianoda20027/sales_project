# Caso de Uso 04-04: Eliminar Producto del Carrito

**Versión:** 1.0  
**Fecha de creación:** 27-04-2025  
**Última actualización:** 27-04-2025  
**Documento Preparado Por:** Jean Carlo Calderón Rojas

#### Descripción
Este caso de uso permite al cliente eliminar un producto específico que haya agregado previamente a su carrito de compras. Dicho esto, al eliminar el producto, el sistema actualizará automáticamente el total general del carrito.

#### Actores

- **Primarios**: Cliente (puede ser anónimo o registrado)
- **Secundarios**: Sistema

#### Precondiciones

- El cliente puede estar registrado o no estarlo en la plataforma.
- El cliente debe tener al menos un producto agregado en su carrito de compras.
- El sistema debe haber recuperado previamente el contenido del carrito.

#### Postcondiciones

- El producto seleccionado se elimina del carrito de compras del cliente.
- El sistema actualiza y muestra el contenido del carrito y el nuevo total general.
- Si el carrito queda vacío tras la eliminación, se muestra un mensaje indicando que el carrito está vacío.

#### Flujo Principal

1. El cliente accede a su carrito de compras (CU-04-02).
2. El cliente identifica el producto que desea eliminar de la lista mostrada.
3. El cliente selecciona la opción "Eliminar" para el producto deseado.
4. El sistema solicita confirmación para eliminar el producto.
5. El cliente confirma la eliminación.
6. El sistema elimina el producto del carrito.
7. El sistema actualiza la vista del carrito:
    - Si aún existen productos, muestra la nueva lista de productos y el nuevo total general.
    - Si no existen productos, muestra un mensaje indicando que el carrito está vacío.

#### Flujos Alternativos

**FA-01: Error al intentar eliminar el producto**

1. El cliente confirma que desea eliminar un producto.
2. El sistema intenta eliminar el producto pero ocurre un error (por ejemplo, error de conexión o fallo en la base de datos).
3. El sistema muestra un mensaje de error indicando que no se pudo eliminar el producto e invita al cliente a intentarlo nuevamente más tarde.

#### Requerimientos Especiales

- La eliminación debe ejecutarse de forma inmediata tras la confirmación del cliente.
- La actualización del carrito debe reflejarse dinámicamente sin necesidad de recargar manualmente la página.

#### Escenarios de Prueba

| Entrada                                          | Salida Esperada                                                                                             |
| ------------------------------------------------ | ----------------------------------------------------------------------------------------------------------- |
| Cliente elimina un producto del carrito          | El producto se elimina y el carrito muestra los productos restantes con el nuevo total general actualizado. |
| Cliente elimina el único producto del carrito    | El producto se elimina y se muestra el mensaje "Tu carrito está vacío".                                      |
| Cliente cancela la eliminación                   | El producto no se elimina y el carrito se mantiene igual.                                                   |
| Error al intentar eliminar un producto           | Muestra un mensaje de error indicando que no se pudo eliminar el producto.                                  |

#### Links de prototipos

Flujo Principal: 

https://www.plantuml.com/plantuml/png/SoWkIImgAKxCAU6gvb9Gi4coSquiAieioLT8ILLmpiyjA4eijj5FikC2IaO75EMdb2O3vHnZ5JGCDO4Y2X4AhZcPkPbvYKKAiK0bAj66bdgMbh4WvRgwg9gSW9gCi6io1cgoW6c2E2CaloGnnmfaDL3U52Xl3b8AH31dvkUbPHRb9XQ1b0253ks7cOdYJdika8N1XzSgn09fltoWXRLSNEX-rN1CBYbDpCciIap9rmGPI1sN8-HhkK388JKl1HJK0000

FA-01:
https://www.plantuml.com/plantuml/png/RSz1IiL03CRnVKxn7K3q0ezQaAu45TnPkaWxgGpCJ3Gpquru6C_W0GHxCMkhkmTP1FBd1sbpOIkPGw4t0avZSwDfzXRPq0KVVUB9hv_fT3Ks17n_FSfpDSLh5JZ9mf2ZClGFfgvEHV4qN1D0sBtEJ0qS_Zdxe_exHHQyLAVd3JW9cDZC5xqS2DjH3JClQXVmgSWsI5KMZliQru-CmkRag75_Yu7UYLf9xlV37m00

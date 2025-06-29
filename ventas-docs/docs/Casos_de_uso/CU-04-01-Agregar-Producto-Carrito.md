# Caso de Uso 04-01: Agregar Producto al Carrito
**Versión:** 1.0
**Fecha de creación:** 27-04-2025
**Última actualización:** 27-04-2025
**Documento Preparado Por:** Jean Carlo Calderón Rojas

## Descripción
Este caso de uso permite al comprador seleccionar un producto en la plataforma y agregarlo a su carrito de compras asociado a una tienda específica. De esta forma el producto seleccionado se guarda junto con la información relevante como la cantidad deseada y la identificación de la tienda.

## Actores
**Primarios:** Comprador (puede ser anónimo o registrado)
**Secundarios:** Sistema

## Precondiciones
* El comprador puede estar o no registrado en la plataforma.
* El producto seleccionado debe existir y estar disponible en la tienda específica.
* El sistema debe tener la capacidad de almacenar y asociar los productos a un carrito de compras.

## Postcondiciones
* El producto seleccionado se agrega exitosamente al carrito de compras del comprador.
* El sistema actualiza el carrito asociado mostrando el producto, la cantidad seleccionada y la tienda correspondiente.

## Flujo Principal
1. El comprador navega por la plataforma y visualiza un producto disponible.
2. El comprador selecciona las opciones necesarias (por ejemplo, cantidad, variaciones).
3. El comprador pulsa el botón "Agregar al Carrito".
4. El sistema valida la disponibilidad del producto y de la tienda.
5. El sistema agrega el producto seleccionado al carrito de compras del comprador (asociándolo a la tienda).
6. El sistema confirma al comprador que el producto ha sido agregado exitosamente al carrito.

## Flujos Alternativos
### FA-01: Producto sin disponibilidad
1. El comprador selecciona un producto sin stock suficiente.
2. El sistema detecta la falta de stock.
3. El sistema muestra un mensaje indicando que el producto no puede ser agregado por falta de disponibilidad.

### FA-02: Error al agregar el producto al carrito
1. El comprador intenta agregar un producto al carrito.
2. El sistema encuentra un error interno (por ejemplo, problemas de conexión a la base de datos).
3. El sistema muestra un mensaje de error al comprador, sugiriendo que intente nuevamente más tarde.

## Requerimientos Especiales
* La operación de agregado debe ser rápida y debe proporcionar retroalimentación inmediata al comprador.
* El sistema debe evitar la duplicidad de productos en el carrito agregando cantidades si ya existe el mismo producto.

## Escenarios de Prueba
| Entrada                                        | Salida Esperada                                                                 |
|------------------------------------------------|---------------------------------------------------------------------------------|
| Comprador agrega un producto con disponibilidad | El producto aparece en el carrito con la cantidad seleccionada y detalles de la tienda. |
| Comprador intenta agregar un producto sin stock  | El sistema muestra un mensaje de "Producto no disponible".                     |
| Error al intentar agregar el producto          | El sistema muestra un mensaje de error indicando que no se pudo agregar el producto. |

## Links de los prototipos

Flujo principal:
https://www.plantuml.com/plantuml/png/ROynoy8m48Rt_8eRlk5pgE9QIcdfvAHGaK39S6sE4ZWJILC7nVzkKX1HN4BkVPxavQefe0yJSX1t0L3qvSd423Gn7BpJyn1SiUbB4M7t2bGSTcSSoNvu0kAL1kDo-EkaN4kfqhCiI-V-4e6bAKyVjSGqf1azD6Y3qQXp1V-mXHLSluqZCkE2sr-uSUpyWklRpCbujtPGZvx6Q2779kzDSA34GuYAh4vhFm40

FA-01:
https://www.plantuml.com/plantuml/png/BOungiD034JxFSMSuFyB66D8dP0gJN0XhnGYigpCIYv2oDrZmquxxy6RFAY5KudqIS2mZDTclEKmL0EhhrPrAJByBsFQWOlXIM_uzj2iKaFWOVc5bHgX43BLK2Q6Iv6SrIen_Htc7MTZtJLgE7LgHj_ntwJ1efbZxGa-fszAarG-0dy0

FA-02:
https://www.plantuml.com/plantuml/png/5Sv1gi9048JXVP-Y3l1uNY24WBWNN8gBJjA6G38TQZhPY8VnB5xCcMNzV8lgSYWZwnBo4g3fsmlfX2xGYJOfOGis-hWFuJKFIixXpQblHO1hmKyzd7-OKrWAHThjqDNAmlhzP8HojF-AxpXx4KCfkFdcBEGXR-aiZVN33m00
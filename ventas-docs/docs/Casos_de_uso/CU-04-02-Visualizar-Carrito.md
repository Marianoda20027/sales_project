# Caso de Uso 04-02: Visualizar Carrito


**Versión:** 1.0
**Fecha de creación:** 26-04-2025
**Última actualización:** 26-04-2025
**Documento Preparado Por:** Alvaro Siles Quesada

#### Descripción
Este caso de uso permite al cliente visualizar los productos que ha agregado a su carrito de compras. El cliente podrá ver detalles como el nombre del producto, la cantidad seleccionada, el precio unitario y el subtotal por producto. También se mostrará el total general del carrito.

#### Actores

- **Primarios**: Cliente (puede ser anónimo o registrado)
- **Secundarios**: Sistema

#### Precondiciones

- El cliente puede estar registrado o no estarlo en la plataforma.
- El cliente debe haber agregado al menos un producto al carrito de compras.
- El sistema debe tener almacenada la información de los productos agregados al carrito para el cliente actual.

#### Postcondiciones

- El sistema muestra al cliente una vista detallada de los productos en su carrito, incluyendo nombre, cantidad, precio unitario y subtotal por producto.
- El sistema muestra el total general de todos los productos en el carrito.


#### Flujo Principal

1. El cliente selecciona la opción de "Carrito de Compras" desde cualquier página de la plataforma.
2. El sistema recupera la información de los productos agregados al carrito para la sesión actual.
3. El cliente espera la respuesta del sistema.
4. El sistema muestra una lista de productos en el carrito, detallando para cada uno:
    
    - Nombre del producto.
    
    - PYME asociada
        
    - Cantidad seleccionada.
        
    - Precio unitario actual.
        
    - Subtotal (cantidad * precio unitario).
        
    Además del **Total General** de todos los productos.
        
5. El cliente visualiza el contenido de su carrito de compras.

#### Flujos Alternativos

**FA-01: El carrito de compras está vacío**

1. El cliente navega a la sección del carrito de compras.
2. El sistema detecta que el carrito está vacío y muestra un mensaje indicando que el carrito está vacío.

**FA-02: Error al recuperar la información del carrito**

1. El cliente navega a la sección del carrito de compras.
2. El sistema intenta recuperar la información del carrito pero ocurre un error (por ejemplo, problemas de conexión a la base de datos).
3. El sistema muestra un mensaje de error al cliente, indicando que no se pudo cargar el carrito y sugiriendo que intente nuevamente más tarde.


#### Requerimientos Especiales

- La vista del carrito debe ser responsive y adaptable a diferentes tamaños de pantalla.
- El cliente debe poder navegar fácilmente desde la vista del carrito hacia las páginas de los productos individuales.
- La información mostrada (precio, cantidad, subtotal) debe actualizarse dinámicamente si el cliente realiza cambios.

#### Escenarios de Prueba

| Entrada                                          | Salida Esperada                                                                                             |
| ------------------------------------------------ | ----------------------------------------------------------------------------------------------------------- |
| Cliente con 3 productos diferentes en el carrito | Muestra los 3 productos con nombre, cantidad, precio unitario y subtotal para cada uno, y el total general. |
| Cliente con el carrito vacío                     | Muestra el mensaje "Tu carrito está vacío".                                                                 |
| Error al acceder a la información del carrito    | Muestra un mensaje de error indicando que no se pudo cargar el carrito.                                     |

#### Links de prototipos

Flujo Principal:
https://img.plantuml.biz/plantuml/png/ZL91QiCm4BmR_8T5zEp6hWrrI4E2oQs1KETIGWvhQp42Mogot4DBdj17z04zzGd-MEKaIjCIQ0L2C3kxCzhTMMjGcnPhutkllWSmAQOPQYsC0awGgUP9OpkvBgP3SBWbQWwiVpFKGCXWdmJ0LbhnhZHg31aseYM3CAyhnVjFoHpbSRaOmr9nX5orXgGeQZe6x-mvqZAKHd3aOs2mcMo1HVQTRaywL0e5dHJMkB1oLs4IfAdJoBl2A8ErnM_28BtTuplV--qykkHyZIy86Ud-lH4b_hGzruRWNfLO_yDn-8VZA4X65nn_uplNRQTYn_90RTUGTBCuJupZ83vybItaS_ynY2J1w52BhHqhTQppoXkm3IY9amQiOOMLWks0vbHrGXytG7AB-fwrDIF9XtNv0W00

FA-01: 
https://img.plantuml.biz/plantuml/png/DP11QWCn34NtWTpXPowG2wGXPUWsP56wALaejfWEJAI9R8T2wM5wW5oWsxbOvIPZ43R-N-yBxL8couc6l5nyBHV0vhHjoQpFYiXezJmQfStwjArYhPLevXMQruBmC7BAqm-k5AQRDhFFnOX_9D0yJxy2KNnG0dN67KN5Q1fBo9gQX-lbSnpK25ASwB7EoDofJJT_Z-GAIr1noJ0eBeKX73ZrcUwCxpdyoK-zt_76XiCSX6FzQXtHIt78dgu-YlWintkd0tOiiUxZ3m00

FA-02:

https://img.plantuml.biz/plantuml/png/NL0nRiCm3Dm3v0yNpqNxWJGmaAbBMpHZuO6McK209HgKvANeO_g6FY4VA-KuImL8v85tfvFQb4bpeZ5lDr_R3R3l3qTIzLamC8uI9gMqV-eFTLZtZbL5TsXU1LCPV904HteXHIwrgzhcpZOyO346cZTNR7hzHObON40Zb5sPM6zo7y-YWPoHOhEgtertfjbE7pF7J8Y5PmhMCiBr9y6UCF12_xxV-sohrazyy2fJT1KVnNfNuKacKVFeRhIBSg8bqalqpWkw_sRDoOD7J2hzo85WiPDFcH_WLbCG4kjSvMts70TwT18icWLh3TQF_WC0
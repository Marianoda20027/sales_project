# Caso de Uso: Administración de Stock y Disponibilidad

## Descripción
Este caso de uso describe el proceso mediante el cual los vendedores (Pymes) registrados en la plataforma pueden gestionar la disponibilidad y el stock de los productos publicados. El objetivo es garantizar que la información sobre el stock y la disponibilidad de los productos esté actualizada y sea precisa para los clientes.

## Actores
*Primarios:*
- Vendedores (Pymes)

*Secundarios:*
- Sistema de Plataforma de Ventas

## Precondiciones
- La Pyme debe estar registrada y autenticada en la plataforma.
- La Pyme debe tener productos publicados en la plataforma.

## Postcondiciones
- El stock y la disponibilidad de los productos son actualizados correctamente en la plataforma.
- Los clientes podrán ver la disponibilidad actualizada de los productos.

## Flujo Principal
1. La Pyme accede a su panel de gestión de productos.
2. La Pyme selecciona un producto para gestionar su stock y disponibilidad.
3. El sistema muestra la información actual de stock y disponibilidad del producto.
4. La Pyme actualiza el stock y la disponibilidad según sea necesario.
5. El sistema valida y guarda la nueva información del producto.
6. El sistema muestra un mensaje de confirmación indicando que la actualización fue exitosa.

## Flujos Alternativos

### FA-01: Producto sin stock
1. La Pyme intenta actualizar el stock de un producto a cero.
2. El sistema informa que el producto está agotado y se marcará como "no disponible" en el catálogo.

### FA-02: Error en la actualización de stock
1. La Pyme intenta actualizar el stock con un valor no válido (ej. valor negativo).
2. El sistema muestra un mensaje de error indicando que el stock debe ser un número positivo.


## Requerimientos Especiales
- El sistema debe validar que el stock no pueda ser negativo.
- El sistema debe actualizar la disponibilidad del producto en tiempo real, reflejando los cambios al instante en el catálogo de productos.

## Escenarios de Prueba

| Entrada                                       | Salida Esperada                          |
|----------------------------------------------|-------------------------------------------|
| Ingreso de Pyme al panel con productos       | Se muestra listado de productos con stock y disponibilidad |
| Actualización del stock a un número mayor    | El stock del producto se actualiza correctamente |
| Actualización del stock a cero               | El producto se marca como "no disponible" |
| Intento de actualización con valor negativo  | Mensaje de error: stock debe ser positivo |


## Links de los prototipos

FA-01: Producto sin stock:
https://img.plantuml.biz/plantuml/png/XP0zRW9138NxbVOEJzlGHL7AhK0ePH1IqW65cHtGA9unyioauESCz5JX5kcvIIwGAsHOKL14Ik7YoU-pdpsCYJHbptMrKl8MpSYaJEosf7XDOjuRxEeAO5fQHZDLwR99qc9CtaN2Q9iPRyHCU6dkZ3qBweUrUBfleOYhL6iIXJMNfPDiFmJnohJpC0FmM6hn5tMJtwVFdwyZdXcRMoH42qzgI2zd6F62mKJGkRYHu9Pi1x011JMKBcUMjJpy4sesbh1oMcPYNyuDnZBfelSTwcfeGzV_xHS0


FA-02: Error en la actualización de stock:
https://img.plantuml.biz/plantuml/png/ROyn2W8n44NxXRt39mVm05QAM0eMTc8n9gC4PpCoIRPGF8pNiFLYhbk8WkNd_vd7c-L2LcedRTCs1wEEuPPcQY01-L99ueKCkQW_ELpR1X3Qiy2jJKFrHQTOK1SpONwfWWs945RkQmZtVlw9Iq5FCX1YEXfd2egau8p-UPSOTE9-noCQWVUCp8QQa9wFZarnrXnBxCUBFpnZNoWTPL3QpZsV1zFTKDtQPiOfZCul

---

*Documento Preparado Por:* Sofía Mora Badilla  
*Fecha:* 24/04/2025

**Versión:** 2.0 Final
**Ultima actualización:**  01/05/2025
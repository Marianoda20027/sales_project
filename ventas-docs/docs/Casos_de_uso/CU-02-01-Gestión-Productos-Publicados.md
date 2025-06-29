# Caso de Uso: Gestión de Productos Publicados

## Descripción
Este caso de uso describe el proceso mediante el cual los vendedores (Pymes) registrados en la plataforma pueden gestionar los productos que han publicado. Incluye la visualización del catálogo, la despublicación de productos y la aplicación de promociones sobre los mismos.

## Actores
*Primarios:*  
- Vendedores (Pymes)

*Secundarios:*  
- Sistema de Plataforma de Ventas

## Precondiciones
- La Pyme debe estar registrada y autenticada en la plataforma.  
- La Pyme debe tener al menos un producto publicado en la plataforma.

## Postcondiciones
- El producto se mantiene publicado, se despublica o se actualiza su estado de promoción.  
- El estado de disponibilidad del producto es actualizado y reflejado en el catálogo.

## Flujo Principal
1. La Pyme accede a su panel de productos publicados.  
2. El sistema muestra el listado de productos asociados a la Pyme.  
3. La Pyme selecciona una acción: ver, despublicar o aplicar promoción.  
4. El sistema valida la acción.  
5. El sistema ejecuta la acción seleccionada y actualiza el estado del producto.  

## Flujos Alternativos

### FA-01: Error en acción seleccionada
1. La Pyme intenta realizar una acción no permitida (ej. editar un producto).  
2. El sistema rechaza la acción y muestra un mensaje informativo.

### FA-02: Producto ya despublicado
1. La Pyme intenta despublicar un producto que ya se encuentra despublicado.  
2. El sistema informa que el producto ya no está visible para los clientes.

## Requerimientos Especiales
- El sistema debe prevenir la edición de productos ya publicados.  
- Solo se debe permitir la despublicación o gestión de promociones.

## Escenarios de Prueba

| Entrada                                       | Salida Esperada                          |
|----------------------------------------------|-------------------------------------------|
| Ingreso de Pyme al panel con productos       | Se muestra listado de productos          |
| Selección de producto → Opción “Despublicar” | Producto se marca como no visible        |
| Selección de producto → Opción “Aplicar promoción” | Promoción se aplica al producto seleccionado |
| Intento de edición                           | Mensaje de error: edición no permitida   |


## Links de los prototipos

Flujo principal:

https://img.plantuml.biz/plantuml/png/fP0z2W8n44RxGEumv0PgPxM8swSIONUBR39A83kH_0WYdieZU36pAgQoiXpcVM-6hub9XPGdnzaXg0b1I4Nem238u4tMoKUGUNHMA-EZW2jd04wDXH4RYtH6iiQ3l9JiNd0shmFgfEZePjj70ekUsdBB-7NLzTJjC0pG5MhosZxkL8OjnjER28FufLjMNKjGytyeLrLP-U-J9NRZh44ohxAU

Escenarios de pruebas:

Despublicar productos:
https://img.plantuml.biz/plantuml/png/SoWkIImgAStDuUNYvKehIinDLL1oIIqkA4tAoKnEB588ACfFAKqkoLTIgERbKb38IKnApL5GWebQmUKL39MGv5s1fgQ0P276fEGZIoeeWUo2Sm_jTyxFIyiioWNQbWAtEJdpyEOyUspQYbAJInBpqdE03es6wum5gqIJJCnBJis1oDNoSZcavgM0_Ga0

Aplicar promocion:
https://img.plantuml.biz/plantuml/png/SoWkIImgAStDuUNYvKehIinDLL1oBCZ9J4uiKWWeoi_DJyuyl3bFIQ6Qbqj18ISnAJL7GGaedbAQN99lfG1ZAHWfeSYd9cVcAoGcbvGcvbWfF6fQQ6YWOs1WWAn6GGbaeO82K6b9Obvw3j3QaCo2V8MKL8K2kBLMCNdH2YwfnScbgNb0IseKJ0rK5MALqFI59URa5u6KniD1B06heg5Un31B8TevCIyvDGSYLSlBvP2Qbm8E7G00

FA-01: Error en acción seleccionada:

https://img.plantuml.biz/plantuml/png/RO-n3S8m54HxIzxXv04GAMXI9GKjeaSKZcsGXMDRFqw5c86U2cQWeSycBC0A6AH457J_wNHFzwikIKfzwpZh3jP7IRA5ZXR5OiuPPxlC1c995AX4hPGTxXu-81fgRR9Q2Xmv0vniZ8DOKz2zIg74UA4GFpd4nphXyt9zFSvO1PWk3RV9cbdRl0ozHnn5iM-SLLA7sJyZ6PMatxkyTbCh4tDxcwCJPvNn-llX6m00

FA-02: Producto ya despublicado:
https://img.plantuml.biz/plantuml/png/ROyn2W8n44NxGExmoG5ixAnMqDvUB6QJKGBPP4coWeYTlMVm5bfx4o_W5OmMQmhBuRzvCxz9cM8UEYU55Dj87KEjOZ23pW47Wk7K3wspcanGE4e1E6hP_QWPHdwggdnPp2Q0T1x8pR2eHHK6zRayZi_p_NMxe2mp-keF7y0fFwxOssHRLqAA11SIjBFiCwV9FsjadSdl2g_MSyrzARifqKcAXhtvrdu3
---

*Documento Preparado Por:* Sofía Mora Badilla  
*Fecha:* 24/04/2025




**Versión:** 2.0 Final
**Ultima actualización:**  01/05/2025 
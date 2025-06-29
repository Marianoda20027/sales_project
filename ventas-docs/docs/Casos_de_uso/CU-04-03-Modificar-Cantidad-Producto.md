# Caso de Uso 04-03: Modificar Cantidad de Producto en Carrito
**Versión:** 1.0  
**Fecha de creación:** 27-04-2025  
**Última actualización:** 27-04-2025  
**Documento Preparado Por:** Jean Carlo Calderón Rojas

---

## **Descripción**
Permite al cliente modificar la cantidad de un producto en su carrito de compras, actualizando automáticamente el subtotal y el total general.

---

## **Actores**
- **Primario:** Cliente (registrado o anónimo)
- **Secundario:** Sistema

---

## **Precondiciones**
1. El cliente ha agregado al menos un producto al carrito.
2. El sistema tiene almacenada la información del carrito asociado al cliente.

---

## **Postcondiciones**
1. La cantidad del producto se actualiza en el carrito.
2. El sistema recalcula subtotal y total general.
3. El cliente visualiza los cambios inmediatamente.

---

## **Flujo Principal**
1. El cliente accede al carrito de compras (CU 04-02).
2. El cliente localiza el producto cuya cantidad desea modificar.
3. El cliente selecciona una nueva cantidad (mayor o menor).
4. El sistema valida que:
    - La cantidad sea un entero mayor a 0.
    - Haya suficiente stock disponible.
5. El sistema actualiza la cantidad en el carrito.
6. El sistema recalcula el subtotal del producto y el total general.
7. El sistema muestra el carrito actualizado al cliente.

---

## **Flujos Alternativos**

### **FA-01: Cantidad inválida (≤ 0)**
1. El cliente ingresa la cantidad.
2. El sistema avisa que la cantidad introducida debe ser mayor a cero".
3. El cliente debe volver a intentarlo con una cantidad válida.

### **FA-02: Cantidad superior al stock**
1. El cliente ingresa una cantidad de unidades mayor al stock disponible.
2. El sistema muestra la cantidad máxima de unidades disponibles en stock.

### **FA-03: Error en actualización**
1. El sistema falla al actualizar la cantidad de productos.
2. El cliente debe volver a intentar a actualizar la cantidad más tarde.

---

## **Requerimientos Especiales**
- Los cambios que se hagan en la vista de carrito se deben visualizar sin necesidad de refrescar la página.
- La vista del carrito debe ser responsiva y adaptable a los diferentes tamaños de la pantalla.


---

## **Escenarios de Prueba**

| Entrada | Salida Esperada |  
|---------|----------------|  
| Cliente cambia cantidad de 1 a 3 | Subtotal y total general actualizados. |  
| Cliente ingresa 0 | Mensaje: *"Cantidad debe ser > 0"*. |  
| Cliente ingresa cantidad > stock | Mensaje con stock máximo disponible. |  
| Error del sistema | Mensaje: *"Reintente más tarde"*. |  

## **Links de prototipos**

Flujo principal:

https://www.plantuml.com/plantuml/png/SoWkIImgAKxCAU6gvb9Gi4coSquiAieioLT8ILLmpiyjA4eijj5FikC2IZeMbHnUcroQarzi1UG1bGD1T41HVaffCb2zOonG06f2NabcIcAA5KYZWeQ2eOAcWhQ2Bamwk3If9ByaCGSYhH9jQAbdQGdIN0koH5UN2ulXJZWDDy9lk37GS0kuuRP0m0NnPWYoAbEWAlDOa4oqWcz-IcPQPd9YaGBCAeLOi8HpFf2RLmgKW8GBKBYMoo4rBmKKUjG9nz5m1000

FA-01:
https://www.plantuml.com/plantuml/png/FSungeD058NX_gxYBvN78zOYeeIKWVHYSPsPWA0ENCSYX2mfgyZ6GY2nFNnm_cPDQcdLASbTe1hgaraqmi8S_NWTdHgJudH9erTV7OPQ15fBhwVRfbZINIpwpQL8smjm_DAIZ8ASF_x9VYC-384r6BFUeg4KkGXqdFUxtVRoa2Oi_fFt1W00

FA-02:
https://www.plantuml.com/plantuml/png/FSwz2i8m5CNn_Jx5ePCYVZYub5AgpaB1iNIulOaG3BabIIVnaNmANqmgudxEZt-JCiUSs6Tw450DTQkYI5dbZf4ZmpE4GtQ63PBrLiHfOCFLTgY9W6FCxvTCNajqRLGpILQSUWBElrk91VOxBB72ce3Y-iMDIwC6DtXRue0fp4kRDiLiThYeSJSd7FyAUdfIOuEPOpy0

FA-03:
https://www.plantuml.com/plantuml/png/POu_gi904CRxFSNtKht7mrZOXH0YmS92i0yf9hihB6nsOJ9heNWO3-0fSZ4J4HjXYk7xy_6hHo6MaRoegmBAlZf4uqvE4wEX8CwGATTzfMPpop8zTFAnG7laQ9AMYAPJ-2GB_6A3F_nZDQlj3x8TSsIG1sb9vDs569wWtuKS-o1sFeHappIytc6wZn1YO_EiKyiGlg7GgPkgRJ0B-nC0
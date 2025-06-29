# Caso de Uso 04-05: Completar Formulario de Compra


**Versión:** 1.0
**Fecha de creación:** 26-04-2025
**Última actualización:** 26-04-2025
**Documento Preparado Por:** Alvaro Siles Quesada

#### Descripción

Este caso de uso permite al cliente acceder a un formulario donde ingresa su información personal (nombre, apellidos, teléfono, correo electrónico, dirección detallada), selecciona el método de envío y el método de pago para finalizar su compra.

#### Actores

- **Primarios**: Cliente (puede ser anónimo o registrado)
- **Secundarios**: Sistema

#### Precondiciones

- El carrito de compras del cliente ( en sesión o  desde la base de datos) debe contener al menos un producto.
- El sistema debe haber determinado el total de la compra (incluyendo subtotales de productos) y que hayan valores reales.
- El sistema debe tener configurados los métodos de envío disponibles y los métodos de pago aceptados.

#### Postcondiciones

- El sistema muestra al cliente un mensaje indicando si el envío del formulario se realizó con éxito o ha presentando algún problema.
- El sistema enviará un correcto electrónico a Las PYMES cuyos productos se encontraban el formulario.
- El sistema enviará un correcto electrónico al cliente con la confirmación y un resumen del formulario enviado, confirmando el envío del formulario.

#### Flujo Principal

1. El cliente, desde la vista del carrito de compras, selecciona la opción para "Enviar Formulario" o similar.
2. El sistema presenta al cliente el formulario de compra con los siguiente datos solicitados:
	- Nombre.
	- Apellidos.
	- Número de teléfono.
	- Correo electrónico.
	- Dirección detallada.
	- Método de envío (desde las opciones disponibles).
	- Método de pago (desde las opciones disponibles).

3. El cliente introduce la información solicitada y confirma la acción de "Enviar formulario de compra".
4. El sistema valida la información ingresada en el formulario y muestra un mensaje de confirmación al cliente indicando que su información de compra ha sido enviada a la(s) pyme(s) correspondientes.


#### Flujos Alternativos

**FA-01: El cliente no completa todos los campos requeridos**

1. El cliente intenta enviar el formulario sin completar todos los campos obligatorios.
2. El sistema identifica los campos incompletos y muestra un mensaje de error al cliente indicando qué campos son requeridos.
3. El cliente completa los campos faltantes y vuelve al flujo principal.


**FA-02: El cliente ingresa información en un formato incorrecto**

1. El cliente ingresa información en un campo con un formato incorrecto.
2. El sistema detecta el formato inválido y muestra un mensaje de error al cliente indicando el formato requerido para ese campo.
3. El cliente corrige la información y vuelve al flujo principal.



**FA-03: No hay métodos de envío disponibles para la selección**

1. El cliente intenta escoger un método de envío.
2. El sistema muestra un mensaje al cliente indicando que no hay opciones de envío disponibles y ofrece un botón para regresar a la vista del carrito.





**FA-04: No hay métodos de pago disponibles para la selección**

1.  El cliente intenta escoger un método de pago.
2. El sistema muestra un mensaje al cliente indicando que no hay opciones de pago disponibles y ofrece un botón para regresar a la vista del carrito.


 **FA-05: Intentar enviar formulario con carrito vacío**

1. El cliente selecciona "Enviar Formulario de Compra" desde el carrito.
    
2. El sistema verifica el contenido del carrito y detecta que el carrito está vacío; informando mediante un mensaje explicativo.

3. El cliente es redirigido a la pantalla de carrito.



#### Requerimientos Especiales

- El formulario debe ser responsivo y adaptable a diferentes tamaños de pantalla.
- La validación de los campos debe realizarse en el cliente (para una respuesta rápida) y en el servidor (para seguridad).
- Se debe indicar claramente qué campos son obligatorios.
- Si es posible, precargar la información del cliente si está registrado.


#### Escenarios de Prueba

| Entrada                                                                              | Salida Esperada                                                                                                            |
| ------------------------------------------------------------------------------------ | -------------------------------------------------------------------------------------------------------------------------- |
| Cliente completa todos los campos correctamente.                                     | El sistema muestra un mensaje de confirmación de envío a la pyme.                                                          |
| Cliente deja al menos un campo de formulario vacío.                                  | El sistema muestra un mensaje de error indicando que al menos un campo es obligatorio.                                     |
| Cliente ingresa un formato inválido, ya sea: teléfono, apellidos, correo, apellidos. | El sistema muestra un mensaje de error indicando que el formato de al menos un campo es inválido.                          |
| No hay métodos de envío configurados.                                                | El sistema muestra un mensaje indicando que no hay opciones de envío disponibles.                                          |
| No hay métodos de pago configurados.                                                 | El sistema muestra un mensaje indicando que no hay opciones de pago disponibles.                                           |
| El cliente inicia el envío de formulario con un carrito vacío.                       | El sistema muestra un mensaje indicando que no es posible enviar un formulario de compra si no hay productos en el carrito |
#### Links de Prototipos

Flujo Principal:

https://img.plantuml.biz/plantuml/png/VLFDQjj04BuR_0w3ceDT6ladKLE7D3XruaA9ImW-14enezNOtR3Q5Rkh45mAVPNqvaDEUGIzIPwa8rjoN5egM8cT-RwPRxvT3Pr7wnqgtsnyRpO0JkBJiR5fhj1A0md1oAIPHTY7iSfl3LnPgONCKAqJYhmvwSId9RDSmMUJnfPU7mSmcyqcQ8j7X35PZJf1ZgmnPnaf9HFZAjX7evV5Ww8bN1PF6Irht9HKiPeRRIfS5FNw1uVHswDtDM9ahAKwdR9Y31TS3BdMa5AKAXGchS7dqf8GidZI5M64IX6FPImvUCMrt_1CAeHFQ1EfoV7sV79JqSlrdf_AeqcnyYPP6tIXxuh7hGkjctOL0NA-UE2vBRGEzYD8s0lN1eR02-G-u-OEMlt3RtNgchoqdDBW9J7z_zslSF7IczbJjBVa4OGjLedqffCKgvY_i94sjQZTd2pn8IB4g4NfMYrgJiBBEmF2QCzdJlocnLy2lfJg9O-rSr6-bk4HboFUyoKnWXn7_w7zcboUyd3RgrMh3vv__eB-VKbESi6Apw2rrnk4Wm68JjuEjfZU3kO3O_ebPYU_yVOOzg9ksErkubFZKN5emDYZu4zPFvgD8HjT_WI_0G00

FA1:
https://img.plantuml.biz/plantuml/png/VLB1IiD04Bq7yW_JdD9Ul4iCbQWtHQG7GOfiaccxija9isCHn8_ns8CdFo4_vYIsb9RgmC3kcpVpzZ4x3M9OWd4IH-zn192L-Grny-eCMu8QeQ2cPPETbNbVxZEvewPad9mdy7mOe95bAxjSEKt9yxGmJKjWVQLJ70gDXm6NBJfdQmedPWo46Rfkio1F9qK6Ia7CUAe-LAyiOrNPxjl_mUZpGcFh-RRR2DM3uMk_xhvePpXz76yHm23TfwyDgyiKzl1RonZ25dn0iQoW1x6evF-rxirohwJTCyClA0P-TMTiV5WWew-isOaki1AxfkEvJ_eQgq_RBs-kO65yXNgR7z7xuyYJu0YIT3A6OKq1gDIz6I7j3aaSVSJHL3tql-C7

FA2:
https://img.plantuml.biz/plantuml/png/VLB1IiD04Bq7yW_JdbeltYM6IjMR8jA384MccscxPRCJPjUYY1_JOm-U_8Jyc9EOKbgg2yEIDs_cpSliA4IK6D35DFb84u1ibj-obAyEnJ8K16CkAy7iV9OtwIRwzrpEXCuk-l1oUA0ZN5Nad2qudE2qX0cvUZjdpoURj9GnYz39V9OjxMBfD6AU3vffCJ9OlwutZUYmBR-sGiRO-jl_CKCJbtewqtVrDdBHEhxHJb-ySpnu6dO8K8ZrnXSewdC0U_Yj4WgX0nyfMb7GGxIavF-r7d2nLzBg2SgA8iAlxaJGXpa9UMDn9ped4-sQZ_i-wpHMHzjlRwhW6BqX_PeUqtiamj9h_dDPEOe4ZWCOB2kzIXI3kZvu1wDhi2jiisq9XNwQfCbdcepKNlDoVW00

FA3:
https://img.plantuml.biz/plantuml/png/VPB1IiD048RlWRp39AUs5-zIIoNMco9IH90YasGILtPtmkos8k83zU39HyYBkPkgO24Ep67c_tQ6dzcbyoZUeVPfyfOc0FDoSSbYjXf5CTG41PjES7vIBg8SCxzcKmhDJdDu_1k3UjwHrgfcDmQiIVVxXYsF0GMBqAXweOIgIlMVTeI8UHRYsyvLl_TS3rvMTjT_y8-Nx0N5AjjcqH4yuIkO0-eYImCBjN8TMrLgSe2Ltw8sP3tb_o-wmVPtpGIci4Pv9eyGgljG2LhNa92jrD0BnAgXogiT7yzzADZwi1W5KCCTsPfgbaqGRgaLSeT-WIBAy-RuTMRPK_0tcKq3OxfWZKkjMlGSpkk2Y_SqMOQXyGTy0G00

FA4:
https://img.plantuml.biz/plantuml/png/VPBFIiD04CRlWRp3fAUs5-zIIoNgJP4Y8aYHIJF6XSrEc9tw1_5XFFRWoKV8Ypbfgs8XBipbcz_kzytkpgAYQ4IlQVAQ9W2JOdh6KgyyYcCe2NAk6y79GJ7jsbqDBhWkXCQ70xZxkpRTuuQyToN7Fk2AVBk-vy1zGCuYrDizSKBBfMi_Gm_HrP6jtJZdxLgvtCno6XxR3_wUPNWpsYb0KTltKAA0oV0hFpT2CUx4EQaJ4mEe8uF_zxh4wiSfUq89BbHPTtVmW2zGRy7OaOsHKBhOS725fmYur1NwceBIOD_aDkUW1bXKz71jEQXaMLXZJfM5tUevYZZbnVxkBB2IfHYEHyRKZGNWmhiAbUsvexczfSdC3kr-n1S0

FA5:
https://img.plantuml.biz/plantuml/png/NL51QiCm4Bm7yeUDpuNUInf2VG-1GYubXxMzCG9brrr9xg4K-fNsdbVu9tr99QMgImLYMUtip33QEe_g7Lg_NBmk5m3hPbEZgl427K4jvq7HhM-RJHgcktf1PSFz2ge2F60xNQGgY1QrWqm6KEq4Xa0TEMWZbwKe1nPpemY3w7EWwWVhGzhDb2pW3J71eDA5relBeBUYSHzFgjLZw4c9MuFkBaE-tZ_XG3el0Z78YTHZ6TV2td28JXX7wf4xAQE7uAA5v2jQyTIBJXVyB_gK1VQ_0iVqD9Fk2YaShvj_8ejnn2W6SQQn18PDDAxHuPYBXPFeELXK8pVWvZZ8-Ua3nf9pZ65Bt5s_xHi0



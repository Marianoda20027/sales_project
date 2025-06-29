### **Caso de Uso 07-03-Visualizar Estado de Stock**

#### **Descripción**
Este caso de uso describe el proceso mediante el cual una Pyme registrada puede visualizar el estado actual del stock de sus productos publicados, permitiéndole saber qué productos están disponibles y cuáles están agotados.

#### **Actores**
- **Primarios:** Pyme 
- **Secundarios:** Sistema de Plataforma de Ventas

#### **Precondiciones**
- La Pyme debe estar registrada y autenticada en la plataforma.
- La Pyme debe tener productos publicados en la plataforma.

#### **Postcondiciones**
- La Pyme puede ver la cantidad de stock disponible para cada producto publicado.
- El sistema muestra la disponibilidad actualizada para cada producto.

#### **Flujo Principal**
1. La Pyme accede al panel de gestión de productos.
2. El sistema presenta la lista de productos publicados por la Pyme junto con su disponibilidad actual.
3. La Pyme puede ver el estado de stock de cada producto, mostrando la cantidad disponible o si el producto está agotado.
4. El sistema actualiza automáticamente el estado de stock en tiempo real, reflejando cualquier cambio realizado.

#### **Flujos Alternativos**
- **FA-01: Producto sin stock**
  1. El producto tiene un stock de 0 unidades.
  2. El sistema muestra que el producto está agotado.

#### **Requerimientos Especiales**
- La información debe ser actualizada en tiempo real para reflejar los cambios de stock.

#### **Escenarios de Prueba**

| Entrada                                    | Salida Esperada                                    |
|--------------------------------------------|---------------------------------------------------|
| Pyme consulta productos con stock disponible | Se muestran los productos con la cantidad de stock actualizada. |
| Pyme consulta productos agotados           | Los productos agotados se marcan con "Agotado" y no tienen opción de compra. |


#### **Prototipos**

![Prototipo](https://img.plantuml.biz/plantuml/dpng/HOz12i8m44NtWTpXqmCKmGjKrBrGS5DQ69CiWZ5JadHJuzrDjQMpcCr__p7Jn4GXHN99YhSKg95njt4YPsSAk9POCxH1crWz2v1hb8rRO3sfn5WdOsYDCqfPzgMtnSF2_ggus3YojmzdChhZeL-ILO_TKkqOHWe4nQynK5NexgJITbTSb7tXkpDvPHo5_YD5Oxp-loB55m00)



Documento Preparado Por: Jose Solano Araya
Fecha: 28/04/2025

Versión: 1.0 
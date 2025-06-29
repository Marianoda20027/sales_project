# Definition of Done (DoD) – Proyecto Plataforma de Ventas

Este documento define los criterios generales que deben cumplirse al completar tareas técnicas de **backend** y **frontend** dentro del equipo de desarrollo.


**Nombre de la tarea o historia de usuario:**  
**Responsable(s):**  
**Sprint:**  
**Número tarea en Taiga:**  
**Fecha de finalización estimada:**  

---

## 1. Requisitos del producto

- [ ] Todos los **criterios de aceptación** definidos en la historia están implementados.
- [ ] La funcionalidad cumple con los requerimientos del negocio y fue validada con el Product Owner (Leonardo Camacho).

---

## 2. Desarrollo Backend

### Implementación de funcionalidad / lógica de negocio

- [ ] Funcionalidad desarrollada conforme a las **buenas prácticas** definidas en [Guia-Estilo-Código-Backend](Guía-Estilo-Código-Backend.md) como apegarse a los estandares de java.
- [ ] Se manejan adecuadamente los **errores, validaciones y excepciones** definidos en [Guia-de-validaciones](Guia-de-validaciones.md).
- [ ] Las pruebas se ejecutan exitosamente según la lógica de negocio establecida, según los criterios de aceptación y escenarios de prueba.

---

## 3. Desarrollo Frontend

- [ ] Se mantuvo la coherencia visual del sistema de diseño definido en [Guia-de-ui](Guia-de-ui.md).
- [ ] Se validaron flujos de éxito, carga y error definido en [Guia-de-validaciones](Guia-de-validaciones.md).
- [ ] Se añadieron pruebas de UI (manuales o automatizadas, según aplique) segun lo definido en [Guia-Pruebas](Guia-Pruebas.md) según los criterios de aceptación y escenarios de prueba.
- [ ] El cambio mejora la experiencia del usuario final.(si aplica)

---

## 4. Control de versiones y revisiones (Git)

- [ ] Se creó una **rama** siguiendo la convención del equipo, según el documento de[Guía de flujo de trabajo](guia-flujo-trabajo.md).
- [ ] Se abrió un **Pull Request (PR)** hacia la rama principal del sprint (`dev`, `main`, etc.).
- [ ] Se **asignó al menos un reviewer** del equipo en el PR.
- [ ] El código fue **revisado y aprobado** por otro desarrollador antes de hacer merge.
- [ ] Se resolvieron todos los comentarios del PR antes de cerrarlo.(si aplica)

---
## 5. Corrección de bugs

- [ ] Se creó una **rama** siguiendo la convención del equipo, según el documento de[Guía de flujo de trabajo](guia-flujo-trabajo.md).
- [ ] Se solucionó el bug.
- [ ] No se afectó funcionalidades relacionadas.

---

## 6. Documentación

- [ ] Se documentó en el PR o wiki del proyecto **qué se hizo, cómo se hizo y por qué**.

---

## 7. Gestión en Taiga

- [ ] Se cambió el estado de la tarea a **"Ready for Test"** o **"Done"**cuando se finalizó el desarrollo.
- [ ] Tras la revisión y validación, se movió a **"Done"**.
- [ ] Si se tiene algún bloqueo con respecto a la tarea se pasa a estado ***Needs info***

---

## 8. Comunicación con el equipo

- [ ] Se **comunicó al equipo** en la weekly (o por canal interno, como Whatsapp) que la tarea fue completada.
- [ ] Se anotó cualquier **bloqueo, decisión técnica importante o aprendizaje** que deba compartirse.


--- 

Documento modificado: 21-06-2025

Documento realizado por: Luis Daniel Solano y Sofía Mora

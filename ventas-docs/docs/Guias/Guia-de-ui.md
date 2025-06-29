# Guía de Estándares UI – Sistema de Ventas al detalle 

## Objetivo

Establecer un conjunto de normas visuales, estructurales y funcionales para garantizar que el sistema **PYME Shop** ofrezca una experiencia **intuitiva, accesible, responsiva e inclusiva**, adaptada a distintos dispositivos y a personas con diferentes capacidades físicas, cognitivas o sensoriales.

---

## 1. Principios de Diseño

### 1.1 Accesibilidad

* Cumplir al menos con el estándar **WCAG 2.1 nivel AA**.
* Contrastes de color adecuados (mínimo 4.5:1 entre texto y fondo).
* Navegación completa mediante teclado (`tab`, `enter`, `esc`, `espacio`).
* Soporte para lectores de pantalla mediante atributos `aria-*`.
* Botones e inputs con foco visible (`:focus`).

### 1.2 Responsividad

* Diseño adaptativo desde 320px hasta resoluciones de escritorio (>1200px).
* Contenido reordenado verticalmente en pantallas pequeñas.
* Botones y campos de al menos **44x44 px** para permitir uso cómodo desde dispositivos táctiles.
* Flexibilidad de fuentes y márgenes usando unidades relativas (`rem`, `%`, `vw`).

### 1.3 Inclusividad

* Interfaces simples y con lenguaje claro.
* Formularios con instrucciones visuales y ejemplos (placeholders).
* Evitar sobrecarga visual: uso moderado de color, animaciones y estímulos.
* Información presentada en múltiples formas: texto + íconos + colores.

---

## 2. Paleta de Colores

| Rol            | Color principal       | Descripción                                       |
| -------------- | --------------------- | ------------------------------------------------- |
| Color primario | `#007BFF`             | Botones, enlaces, elementos destacados            |
| Color de texto | `#212529`             | Texto principal                                   |
| Fondo general  | `#FFFFFF`             | Fondo principal del contenido                     |
| Gris neutro    | `#F8F9FA`             | Fondos secundarios y formularios                  |
| Error          | `#F8D7DA` / `#842029` | Alertas de error, bordes y mensajes de validación |
| Éxito          | `#D1E7DD` / `#0F5132` | Confirmaciones y acciones correctas               |

Colores deben aplicarse también en sus **estados hover, focus, activo y deshabilitado**, manteniendo consistencia.

---

## 3. Tipografía y Jerarquía

* Fuente: sistema o alternativa sans-serif moderna (ej. Roboto).
* Tamaños definidos en `rem` para escalar en distintos dispositivos.

| Elemento      | Clase Bootstrap | Tamaño sugerido |
| ------------- | --------------- | --------------- |
| Título página | `display-5`     | `2.5rem`        |
| Subtítulo     | `lead`          | `1.25rem`       |
| Texto normal  | `body`          | `1rem`          |
| Notas / ayuda | `text-muted`    | `0.875rem`      |

---

## 4. Componentes Comunes

### 4.1 Navbar

* Siempre visible o colapsable (modo hamburguesa en móviles).
* Contiene: logo, buscador, filtros, autenticación.
* Altura mínima de 56px. Foco visible en todos los enlaces.

### 4.2 Botones

* Colores: `btn-primary`, `btn-outline-primary`, `btn-danger`.
* Estados: `:hover`, `:focus`, `:disabled` bien diferenciados.
* Accesibles con `aria-label` cuando solo contienen íconos.

### 4.3 Formularios

* Inputs con `form-control`, márgenes verticales (`mb-3`).
* Placeholder explicativo y validación visual.
* Textos de ayuda (`form-text`) con color gris (`text-muted`).
* Etiquetas asociadas con `for` + `id` para lectores de pantalla.

### 4.4 Alertas

* Uso de componentes `alert` de Bootstrap.
* Íconos junto al texto para reforzar el mensaje.
* Margen vertical para separación visual.

---

## 5. Interacción y Feedback

| Tipo                      | Mecanismo visual                                 |
| ------------------------- | ------------------------------------------------ |
| Carga                     | Spinner central o `placeholder loading`          |
| Error                     | Caja roja con ícono + texto explicativo          |
| Éxito                     | Caja verde con mensaje breve                     |
| Validación de formularios | Borde rojo/verificado + mensaje debajo del campo |

---

## 6. Inclusión Tecnológica

* Todas las funcionalidades deben funcionar sin necesidad del uso exclusivo del mouse.
* Componentes dinámicos (modales, menús) accesibles por teclado y con gestión del foco.
* Se evitarán tooltips flotantes como único medio de información.

---

## 7. Buenas prácticas generales

* Evitar el uso de colores como único medio para transmitir información.
* Uso de iconos solo cuando aporten valor contextual.
* Los textos siempre deben tener un propósito y ser autoexplicativos.
* Reutilizar componentes para mantener consistencia.
* Priorizar claridad sobre diseño decorativo.

---

## 8. Implementación Técnica

* Utilizar Bootstrap 5 y sus utilidades (`container`, `grid`, `gap`, `order`, `flex`, etc.).
* Personalizar variables SCSS si se compila Bootstrap localmente (`$primary`, `$danger`, etc.).
* Mantener un archivo `styles.css` o `variables.scss` centralizado.
* Estandarizar el uso de clases auxiliares para márgenes, paddings, tamaño, y tipografía.

---

## 9. Seguridad y Privacidad en el Frontend

### 9.1 Principios de seguridad visual y lógica

* **No almacenar información sensible en el frontend.**

  * Nunca guardar tokens, contraseñas, datos personales o de sesión en `localStorage`, `sessionStorage` o variables JS expuestas al DOM.
  * Usar almacenamiento seguro y temporal solo si es estrictamente necesario, y siempre cifrado.

* **Validaciones en cliente solo como apoyo.**

  * Todas las validaciones críticas (autenticación, roles, accesos) deben ser reforzadas en el backend.

* **Protección contra exposición accidental:**

  * Evitar imprimir objetos de usuario o credenciales en consola (`console.log`).
  * No mostrar datos personales innecesarios en formularios, modales o interfaces públicas.
  * No mostrar mensajes de error con información del sistema (ej. stack trace, detalles de red).

### 9.2 Interfaz orientada a la privacidad

* Informar al usuario sobre lo que se recoge (placeholder, etiquetas claras).
* Limitar la persistencia visual de datos privados (ej. limpiar formularios después de envío fallido).
* Mostrar advertencias claras al solicitar información sensible (correo, contraseña, datos fiscales).

---

## 10. Validación de Estándares UI/UX

Se establece el uso de una **checklist oficial de revisión UI/UX** al final de cada iteración de desarrollo, incluyendo pruebas de usabilidad, accesibilidad, consistencia visual, seguridad y responsividad. Esto se contempla solo de modo de referencia para poder guiarse con respecto a lo que podría cumplir la funcionalidad. Ya que se toma en cuenta para validarse en el checklist de Definition of Done. Este checklist es una referencia de guía a la hora de probar una funcionaldiad en UI.

### 10.1 Checklist de validación visual y funcional

| Categoría           | Criterio                                                          | Cumple |
| ------------------- | ----------------------------------------------------------------- | ------ |
| **Visual**          | Todos los textos tienen contraste suficiente (mín. 4.5:1)         | ✅ / ❌  |
|                     | Títulos, botones y formularios siguen la jerarquía establecida    | ✅ / ❌  |
| **Responsividad**   | La interfaz se adapta desde 320px hasta +1200px sin romperse      | ✅ / ❌  |
|                     | Los botones y campos son cómodos de usar en dispositivos táctiles | ✅ / ❌  |
| **Accesibilidad**   | Se puede navegar totalmente por teclado (tabulador, enter, esc)   | ✅ / ❌  |
|                     | Todos los inputs tienen etiquetas asociadas y `aria-*` si aplica  | ✅ / ❌  |
|                     | Todos los elementos interactivos tienen foco visible              | ✅ / ❌  |
| **Seguridad**       | No se guarda información personal sensible en el frontend         | ✅ / ❌  |
|                     | No hay `console.log` con datos personales o de sesión             | ✅ / ❌  |
|                     | Se realiza sanitización/escape de datos que vienen del backend    | ✅ / ❌  |
| **Usabilidad**      | Hay feedback visual para acciones (cargando, éxito, error)        | ✅ / ❌  |
|                     | Los mensajes son claros, concisos y sin ambigüedad                | ✅ / ❌  |
| **Pruebas finales** | Se probaron errores forzados en inputs y servicios                | ✅ / ❌  |
|                     | Se probó la UI en móvil, tablet y escritorio                      | ✅ / ❌  |


---

Documento realizado por: Luis Daniel Solano Solano 

Última modificación: 21-06-2025
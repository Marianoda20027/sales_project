# Documento de Guía de Estilo de Código del Frontend

**Ventas al Detalle para PYMEs**

---

### Estructura del Código

* Definición de la organización de archivos y carpetas.
* Convenciones de nomenclatura para archivos y componentes.
* Separación de responsabilidades en el código.
* Convenciones para la declaración de clases, métodos, variables y funciones.

---

### Organización de Archivos y Carpetas

El proyecto sigue una estructura modular para facilitar el mantenimiento y la escalabilidad. A continuación se describen los directorios del frontend:

* **adapters**: Mapeo de modelos externos a modelos de negocio.
* **assets**: Archivos estáticos como imágenes, íconos, fuentes, etc.
* **components**: Componentes reutilizables utilizados en toda la aplicación.
* **contexts**: Proveedores de contexto global disponibles en la aplicación.
* **hooks**: Hooks personalizados que extienden la funcionalidad de los componentes.
* **models**: Definición de interfaces y tipos utilizados en la aplicación.
* **pages**: Vistas principales de la aplicación como Login, Dashboard, etc.
* **services**: Encapsulan llamadas a APIs o servicios externos (login, registro, etc).
* **utilities**: Funciones auxiliares puras que no gestionan estado.

#### Estructura interna de las páginas

Para mantener una organización más clara, dentro de cada carpeta de página se utiliza una estructura que agrupa archivos por propósito:

* `index.tsx`: componente principal de la vista.
* `hooks.ts`: lógica específica de hooks relacionados a esa página.
* `types.ts`: definición de interfaces o tipos usados en esa página.

Esta estructura permite tener el código **más centralizado y enfocado** dentro del componente de página que se está desarrollando, facilitando su comprensión y mantenimiento.

---

### Convenciones de Nomenclatura para Archivos y Componentes

1. **Archivos de Componentes**:

   * Los nombres de los archivos de componentes deben usar **PascalCase** (por ejemplo, `UserCard.tsx`, `ProductList.tsx`). Esta convención asegura que los componentes se distingan visualmente en el proyecto.

2. **Hooks Personalizados**:

   * Los hooks personalizados deben empezar con el prefijo `use`, seguido de una descripción clara de su función en el nombre. Ejemplos:

     * `useFetchData.ts`
     * `useAuth.ts`
     * `useLocalStorage.ts`

3. **Modelos de Datos**:

   * Los archivos que contienen las clases o estructuras de modelos de datos deben tener un sufijo `.models.ts` y deben estar en **PascalCase**. Ejemplo:

     * `Purchase.models.ts`
     * `User.models.ts`

4. **Interfaces y Tipos**:

   * Las interfaces y los tipos deben ser declarados en **PascalCase**. Ejemplo:

     * `interface Event`
     * `type Response`

5. **Servicios**:

   * Los archivos de servicios deben seguir el formato **\[nombre del recurso].service.ts**. Ejemplo:

     * `events.service.ts`
     * `user.service.ts`

---

### Separación de Responsabilidades

1. **adapters**:

   * **Responsabilidad**: Este directorio se encarga de **transformar** o **mapear** los datos entre modelos externos (de APIs, bases de datos, etc.) y los modelos internos que utiliza la lógica de negocio de la aplicación. No debe contener lógica de UI ni manejar estado.
   * **Ejemplo**: `UserAdapter.ts` mapea los datos de la API a un formato compatible con los modelos internos de la aplicación.

2. **assets**:

   * **Responsabilidad**: Aquí se almacenan los **archivos estáticos** (imágenes, íconos, fuentes, etc.) utilizados por la aplicación. No debe contener lógica ni procesamiento de datos.
   * **Ejemplo**: `logo.png`, `icon.svg`, etc.

3. **components**:

   * **Responsabilidad**: Los componentes deben ser **reutilizables** y encargarse de la **presentación** de la aplicación. Deben recibir datos desde sus **props** o el **contexto** y manejar eventos (clics, formularios, etc.), pero no deben contener lógica de negocio ni llamadas a APIs.
   * **Ejemplo**: `Button.tsx`, `Card.tsx`.

4. **contexts**:

   * **Responsabilidad**: Los contextos gestionan el **estado global** de la aplicación, proporcionando datos a través de toda la aplicación sin necesidad de prop drilling. Aquí debe definirse la lógica de los datos globales, pero no debe incluirse la lógica de presentación o UI.
   * **Ejemplo**: `AuthContext.tsx`, `ThemeContext.tsx`.

5. **hooks**:

   * **Responsabilidad**: Los hooks personalizados se encargan de la **lógica reutilizable**. Estos pueden manejar estado, interactuar con APIs o gestionar efectos secundarios, pero no deben involucrarse en la UI ni tener lógica de presentación.
   * **Ejemplo**: `useFetchData.ts`, `useAuth.ts`.

6. **models**:

   * **Responsabilidad**: Los modelos definen las **interfaces** y **tipos** que se utilizan a lo largo de la aplicación. Son responsables de la **estructura de los datos** pero no incluyen lógica de negocio ni interacción con APIs.
   * **Ejemplo**: `User.models.ts`, `Product.models.ts`.

7. **pages**:

   * **Responsabilidad**: Las páginas son las vistas principales de la aplicación (como Login, Dashboard, etc.). Se encargan de reunir los componentes y orquestar la lógica para la visualización de los datos, pero deben mantenerse enfocadas en la presentación.
   * **Ejemplo**: `LoginPage.tsx`, `DashboardPage.tsx`.

8. **services**:

   * **Responsabilidad**: Los servicios encapsulan la **comunicación con APIs** o cualquier integración con fuentes de datos externas. Son responsables de **realizar llamadas a servidores**, manejar la lógica de negocio relacionada con esos datos, pero no deben gestionar el estado de la UI.
   * **Ejemplo**: `auth.service.ts`, `product.service.ts`.

9. **utilities**:

   * **Responsabilidad**: Las utilidades contienen **funciones auxiliares** que realizan tareas pequeñas y específicas, sin tener que ver con el estado o la UI. Son funciones puras que no dependen de ninguna estructura de datos o estado de la aplicación.
   * **Ejemplo**: `formatDate.ts`, `calculateTotal.ts`.

---

### Convenciones de Código

1. **Métodos**:

   * Los métodos deben seguir la convención **camelCase** (por ejemplo, `handleClick`, `fetchData`, `submitForm`).
   * Los métodos deben ser **funciones flecha** para garantizar que el contexto de `this` esté siempre correctamente vinculado. Ejemplo:

     ```typescript
     const handleClick = () => {
       // Lógica de manejo de clic
     }
     ```
   * Los métodos deben ser pequeños y enfocados en una única tarea, con nombres descriptivos que empiecen con un verbo (por ejemplo, `fetchData`, `handleSubmit`).

2. **Variables**:

   * Las variables también deben seguir la convención **camelCase** (por ejemplo, `userData`, `isLoading`).
   * Las variables booleanas deben usar prefijos como `is`, `has`, `can`, para indicar valores verdadero/falso (por ejemplo, `isAuthenticated`, `canEdit`).
   * Para constantes que no cambian, se debe utilizar **UPPER\_SNAKE\_CASE** (por ejemplo, `API_URL`).

3. **Funciones**:

   * Las funciones deben seguir la convención **camelCase** (por ejemplo, `getUserInfo`, `calculateTotal`).
   * Las funciones que se usen dentro de los componentes deben declararse como funciones flecha para mantener el contexto adecuado de `this`. Ejemplo:

     ```typescript
     const getUserInfo = () => {
       // Lógica para obtener información del usuario
     }
     ```

---



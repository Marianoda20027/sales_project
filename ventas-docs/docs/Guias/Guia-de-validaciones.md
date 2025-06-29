
# Guía de Validaciones – Backend y Frontend

## 1. Objetivo

Definir un estándar unificado para la implementación de validaciones tanto en el backend como en el frontend. Este estándar busca garantizar consistencia en el manejo de errores, claridad en los mensajes al usuario y facilidad de mantenimiento en todo el sistema.

## Validaciones en Backend

### 1. Estructura de errores

Se utiliza una clase `BaseException` para representar errores de negocio. Esta clase contiene:

* Código del error (`code`)
* Mensaje descriptivo (`message`)
* Parámetros opcionales (`params`)

Todos los errores controlados deben extender esta estructura, permitiendo respuestas claras y estructuradas.

### 2. Lanzamiento de errores

Los errores se lanzan mediante un constructor tipo builder:

```java
throw BaseException.exceptionBuilder()
    .code(ErrorCode.PYME_NOT_FOUND)
    .message("Pyme not found")
    .build();
```

Se puede usar `if`, `switch`, o cualquier lógica adecuada, siempre que se use `BaseException` para representar errores esperados del negocio.

### 3. Manejo centralizado

El manejo de excepciones debe realizarse en una clase global con `@ControllerAdvice`, que captura los errores y genera respuestas HTTP uniformes para el frontend. Esto permite desacoplar la lógica de validación de la lógica de negocio.

### 4. Buenas prácticas

* Usar `BaseException` para errores esperados.
* Evitar exponer información sensible.
* Validar preferiblemente en los handlers, no en los controladores.
* Centralizar las respuestas de error para mantener consistencia.

---

## Validaciones en Frontend

### 1. Manejo de errores de API

El frontend define una estructura de respuesta de error que refleja el modelo del backend:

```ts
export interface ErrorResponse {
  message: string;
  code: number;
  params?: string;
}
```

Los errores se gestionan a través del mensaje recibido en la respuesta, utilizando un `switch` para mostrar mensajes personalizados al usuario:

```ts
switch (response.message) {
  case 'EMAIL_ALREADY_EXISTS':
    setError('El correo electrónico ya está registrado');
    break;
  case 'NAME_ALREADY_EXISTS':
    setError('El nombre de la empresa ya está registrado');
    break;
  case 'Connection error':
    setError('Error de conexión. Intenta nuevamente');
    break;
  default:
    setError(response.message || 'Error al registrar. Intenta nuevamente');
}
```

También se puede acceder al error directamente desde la estructura de Axios (`axios.error.response`), permitiendo manejar errores de red o fallos del servidor.

---

### 2. Validación de campos con patrón Factory

Para validar campos de formularios se utiliza el **patrón Factory**, con una interfaz común `Validator` que implementan los diferentes validadores (`EmailValidator`, `PymeNameValidator`, `PasswordValidator`, etc.).

La validación se realiza mediante una llamada centralizada:

```ts
const result = ValidationFactory.validate('pyme.email', email);
```

#### Razones para usar el patrón Factory

1. **Múltiples validadores especializados**
   Se tienen distintos validadores según el tipo de dato a validar. Centralizar su creación evita que el resto del código tenga que decidir cuál usar.

2. **Selección dinámica de validador**
   La fábrica selecciona automáticamente el validador adecuado según la clave de validación.

3. **Evita código duplicado**
   No es necesario repetir estructuras condicionales como `if (type === '...')`.

4. **Lógica centralizada y mantenible**
   Todas las reglas están concentradas en la fábrica y sus clases asociadas, lo que permite escalar o modificar validaciones de forma ordenada.

---

Documento modificado: 21-06-2025

Documento realizado por: Luis Daniel Solano 



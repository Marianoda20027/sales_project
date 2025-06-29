### Plantilla ADR - RS-01 Seguridad

# ADR-Número: ADR-001

# Título: Implementación de autenticación multifactor (MFA)

# Estado: Aprobado

## Contexto

El sistema requiere garantizar la seguridad de los datos sensibles y cumplir con regulaciones como GDPR. Actualmente, solo se usa autenticación básica (usuario/contraseña), lo que representa un riesgo.

## Decisión

Se implementará MFA para todos los usuarios con acceso a datos críticos, usando un proveedor externo (por ejemplo, Google Authenticator).

## Alternativas consideradas

1. Solo contraseñas complejas: Insuficiente ante ataques de phishing.

## Consecuencias

- Positivo: Reduce brechas de seguridad en un 80%.
- Negativo: Aumenta el tiempo de login en un 15%.

## Fecha

14/05/2025

---

### Fitness Function - RS-01 Seguridad

# Fitness Function: Protección contra inyección SQL

**Característica arquitectónica:** Seguridad

- Propósito:
  Garantizar que el sistema no sea vulnerable a ataques de inyección SQL que puedan comprometer la integridad y confidencialidad de los datos.

- Criterio de éxito:
  Ninguna vulnerabilidad de inyección SQL detectada en los análisis de seguridad.

- Método de validación:
  Escaneo automático con la herramienta OWASP ZAP.

- Frecuencia de ejecución:
  En cada despliegue.

---

### Plantilla ADR - RS-02 Responsividad

# ADR-Número: ADR-002

# Título: Implementación de diseño responsivo adaptable a múltiples dispositivos

# Estado: Aprobado

## Contexto

El sistema será accedido desde una variedad de dispositivos (computadoras, tablets, teléfonos móviles). Actualmente, la interfaz está diseñada solo para resoluciones de escritorio, lo que genera problemas de visualización y usabilidad en pantallas pequeñas o intermedias.

Esto impacta directamente la experiencia de usuario y puede limitar el acceso de usuarios móviles al sistema.

## Decisión

Se adoptará un diseño responsivo utilizando principios de mobile-first, media queries y unidades relativas (como em, % o vh/vw). Se empleará un sistema de diseño flexible (por ejemplo, CSS Grid o Flexbox) para asegurar que la interfaz se adapte correctamente a diferentes resoluciones de pantalla.

## Alternativas consideradas

1. Crear versiones separadas para desktop y mobile: Rechazada por duplicación de esfuerzo y mantenimiento complejo.

2. Forzar escala mediante zoom del navegador: Ineficiente y no mejora la experiencia visual.

## Consecuencias

- Positivo: Mejora la experiencia de usuario en múltiples dispositivos, facilita la navegación y reduce rebotes en móviles.

- Negativo: Requiere rediseñar parte del frontend actual y realizar pruebas de visualización en diferentes resoluciones.

## Fecha

14/05/2025

---

### Fitness Function - RS-02 Responsividad

# Fitness Function: Tiempo de respuesta frontend

**Característica arquitectónica:** Responsividad

- Propósito:
  Garantizar que la interfaz de usuario se cargue y responda rápidamente para ofrecer una experiencia fluida al usuario.

- Criterio de éxito:
  Puntaje de rendimiento en Lighthouse igual o superior a 90/100 en el percentil 95.

- Método de validación:
  Auditoría automática con la herramienta Lighthouse.

- Frecuencia de ejecución:

En cada pull request.

---

### Plantilla ADR - RS-03 Accesibilidad

# ADR-Número: ADR-003

# Título: Cumplimiento WCAG 2.1 AA

# Estado: Aprobado

## Contexto

El 15% de los usuarios reportan problemas de accesibilidad como bajo contraste o fallas con lectores de pantalla.

## Decisión

Se adoptarán las pautas WCAG 2.1 AA utilizando librerías como `react-aria`.

## Alternativas consideradas

1. Soluciones personalizadas: Requieren mucho mantenimiento.
2. Mejorar solo el contraste: Insuficiente para cumplir con estándares legales.

## Consecuencias

- Positivo: Mejora notable en la experiencia de usuarios con discapacidad.
- Negativo: Incrementa el tiempo de desarrollo en un 20%.

## Fecha

14/05/2025

---

### Fitness Function - RS-03 Accesibilidad

# Fitness Function: Validación WCAG 2.1 AA

**Característica arquitectónica:** Accesibilidad

- Propósito:
  Asegurar que el sistema sea usable por personas con discapacidades visuales o motrices.

- Criterio de éxito:
  Cero errores críticos reportados por la herramienta de validación de accesibilidad

- Método de validación:
  Auditoría con axe-core.

- Frecuencia de ejecución:

Antes de cada release.

---

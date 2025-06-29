# Documento de guía de despliegue

### Descripción general
Esta guía detalla el proceso de despliegue de una plataforma que permite a pequeñas y medianas empresas (Pymes) exponer y vender sus productos en línea de forma segura y directa, sin intermediarios con una experiencia de usuario simplificada.

### Requisitos del Sistema

#### Hardware 
- CPU: Mínimo 4 núcleos
- RAM: 8 GB o más
- Almacenamiento: 50 GB libres

#### Software
- Sistema operativo: Ubuntu 22.04 / Windows 11
- Java (versión 17)
- Docker & Docker Compose
- Git y Git Bash (Últimas versiones)

### Arquitectura del sistema
- Frontend: React vite
- Backend: Spring Boot (REST API)
- Base de Datos: PostgreSQL 
- Despliegue: Docker Compose (modo desarrollo) 

### Proceso de Despliegue

### 1. Clonar Repositorios
- https://github.com/IF-7100-2025/ventas-frontend
- https://github.com/IF-7100-2025/ventas-backend 


### 2. Configurar variables de entorno

#### Backend (ventas-backend/.env):
SERVER_PORT=8080
DB_HOST=localhost
DB_PORT=5432
DB_NAME=ventasdb
DB_USER=admin
DB_PASSWORD=admin123

#### Frontend (ventas-frontend/.env):

- VITE_API_URL=http://localhost:8080/api

### 3. Construir las imágenes con Docker Compose
- Construir las imágenes con Docker Compose

### 4. Verificar el despliegue

- Frontend (React): http://localhost:5173

- Base de Datos (PostgreSQL): corriendo en el contenedor db en el puerto 5432, con parámetros definidos en el archivo .env

### 5. Pruebas iniciales
- Accede al frontend y valida la conexión con el backend

- Prueba la creación de productos, autenticación y flujo básico de compra

- Verifica los logs del sistema con: docker-compose logs -f


**Versión:** 1.0  
**Fecha de creación:** 06-05-2025  
**Úñtima actualización:**  13-05-2025
**Documento Preparado Por:** Keylin Vega Morales 

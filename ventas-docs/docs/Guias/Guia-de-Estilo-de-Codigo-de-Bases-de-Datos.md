# Guía de estándares de base de datos
## 1. Estándares de Nombramiento

### Convenciones para nombres de tablas, columnas y vistas
- **Tablas**: Se recomienda usar nombres en plural y en minúsculas, con palabras separadas por guiones bajos (snake_case). Ejemplo: `clientes`, `ordenes_compra`.
- **Columnas**: Usar nombres descriptivos y en minúsculas, también separados por guiones bajos. Ejemplo: `id_cliente`, `fecha_creacion`.
- **Vistas**: Las vistas deben seguir la misma convención que las tablas, pero agregar el prefijo `v_` para identificarlas como vistas. Ejemplo: `v_clientes_activos`, `v_ordenes_completadas`.

### Reglas para la nomenclatura de claves primarias (PK) y claves foráneas (FK)
- **Clave primaria**: Usar el nombre de la tabla seguido de `_id`. Ejemplo: `cliente_id`, `producto_id`.
- **Clave foránea**: Usar el nombre de la tabla de origen seguido de `_id`. Ejemplo: `cliente_id` en la tabla `ordenes`.

---

## 2. Guías para Declaraciones de Claves

### Definición y uso adecuado de claves primarias (PK)
- Las claves primarias deben ser **únicas** y **no nulas**.
- Utilizar un tipo de dato adecuado como `INT` o `BIGINT` con incremento automático, dependiendo de la base de datos.

### Reglas para la declaración de claves foráneas (FK)
- Las claves foráneas deben referenciar claves primarias en otras tablas.
- Siempre declarar las claves foráneas con la restricción `ON DELETE CASCADE` o `ON UPDATE CASCADE` si se requiere mantener la integridad referencial de forma automática.

### Convenciones para la definición de claves únicas (UK)
- Usar el sufijo `_unique` para las columnas que deben ser únicas, como `email_unique` o `usuario_unique`.
- Las claves únicas deben ser implementadas tanto en los índices como en las restricciones de la base de datos.

---

## 3. Creación de Scripts con Liquibase

### Directrices para la estructuración de scripts de migración
- Los **scripts de migración** deben ser **claros y ordenados**, con un `changelog` principal que referencie los `changesets` de manera secuencial.
- Cada `changeset` debe tener una descripción clara de lo que realiza y debe estar marcado con un `author` que indique quién realizó el cambio.
- Los **archivos de migración** deben seguir un formato consistente con nombres descriptivos y un timestamp para asegurar el orden correcto en la ejecución.

### Ejemplo de `changeset` con descripción y autor:
```xml
<changeSet id="202304081000_crear_tabla_usuarios" author="tu_nombre">
    <comment>Crea la tabla de usuarios con las columnas esenciales.</comment>
    <createTable tableName="usuarios">
        <column name="id_usuario" type="INT" autoIncrement="true">
            <constraints primaryKey="true" nullable="false" primaryKeyName="PK_usuarios"/>
        </column>
        <column name="nombre" type="VARCHAR(255)">
            <constraints nullable="false"/>
        </column>
        <column name="email" type="VARCHAR(255)">
            <constraints nullable="false" unique="true" uniqueConstraintName="UK_usuarios_email"/>
        </column>
        <column name="fecha_registro" type="TIMESTAMP" defaultValueComputed="CURRENT_TIMESTAMP"/>
    </createTable>
</changeSet>

```

### Ejemplo de `changeset` con rollback:

```xml
<changeSet id="202304081015_crear_tabla_productos" author="tu_nombre">
    <comment>Crea la tabla de productos con las columnas esenciales.</comment>
    <createTable tableName="productos">
        <column name="id_producto" type="INT" autoIncrement="true">
            <constraints primaryKey="true" nullable="false" primaryKeyName="PK_productos"/>
        </column>
        <column name="nombre" type="VARCHAR(255)">
            <constraints nullable="false"/>
        </column>
        <column name="precio" type="DECIMAL(10,2)">
            <constraints nullable="false"/>
        </column>
        <column name="categoria" type="VARCHAR(255)">
            <constraints nullable="false"/>
        </column>
        <column name="descripcion" type="TEXT"/>
        <column name="fecha_creacion" type="TIMESTAMP" defaultValueComputed="CURRENT_TIMESTAMP"/>
    </createTable>
    <rollback>
        <dropTable tableName="productos"/>
    </rollback>
</changeSet>

```

----------

## 4. Mejores Prácticas en la Creación de Migraciones

### Convenciones de Formato y Organización

-   **Organización de los archivos**: Los archivos de migración deben organizarse por fecha y funcionalidad. Los nombres de archivo deben incluir una marca de tiempo para asegurar la secuencia correcta.
    

**Ejemplo de estructura de directorios:**

```
liquibase/
├── changelog-master.xml
├── 202304081000_crear_tabla_usuarios.xml
├── 202304081015_crear_tabla_productos.xml
├── features/
    └── 202304081430_agregar_columna_descripcion_producto.xml

```

-   **Control de Versiones**: Usar un sistema de control de versiones (como Git) para gestionar los archivos de migración, asegurando que se mantenga un historial de los cambios en el esquema de la base de datos.
    

### Recomendaciones Adicionales

-   **Pruebas de Rollback**: Asegúrate de que todos los `rollback` funcionen correctamente antes de aplicar los cambios en un entorno de producción.
    
-   **Documentación de Cambios**: Documenta claramente cada `changeset` con comentarios que expliquen el propósito del cambio y las razones detrás de cada modificación.
    
-   **Revisión de Scripts**: Antes de aplicar cualquier cambio en producción, realiza una revisión exhaustiva de los scripts de migración.
    

----------

## 5. Ejemplo de Uso de Liquibase en un Proyecto de Comercio Electrónico

### Crear la Tabla de Usuarios

```xml
<changeSet id="202304081000_crear_tabla_usuarios" author="tu_nombre">
    <comment>Crea la tabla de usuarios para el registro de clientes en la plataforma.</comment>
    <createTable tableName="usuarios">
        <column name="id_usuario" type="INT" autoIncrement="true">
            <constraints primaryKey="true" nullable="false" primaryKeyName="PK_usuarios"/>
        </column>
        <column name="nombre" type="VARCHAR(255)">
            <constraints nullable="false"/>
        </column>
        <column name="email" type="VARCHAR(255)">
            <constraints nullable="false" unique="true" uniqueConstraintName="UK_usuarios_email"/>
        </column>
        <column name="fecha_registro" type="TIMESTAMP" defaultValueComputed="CURRENT_TIMESTAMP"/>
    </createTable>
</changeSet>

```

### Crear la Tabla de Productos

```xml
<changeSet id="202304081015_crear_tabla_productos" author="tu_nombre">
    <comment>Crea la tabla de productos para almacenar la información de los artículos disponibles para la venta.</comment>
    <createTable tableName="productos">
        <column name="id_producto" type="INT" autoIncrement="true">
            <constraints primaryKey="true" nullable="false" primaryKeyName="PK_productos"/>
        </column>
        <column name="nombre" type="VARCHAR(255)">
            <constraints nullable="false"/>
        </column>
        <column name="precio" type="DECIMAL(10,2)">
            <constraints nullable="false"/>
        </column>
        <column name="categoria" type="VARCHAR(255)">
            <constraints nullable="false"/>
        </column>
        <column name="descripcion" type="TEXT"/>
        <column name="fecha_creacion" type="TIMESTAMP" defaultValueComputed="CURRENT_TIMESTAMP"/>
    </createTable>
</changeSet>


```

### Documento realizado por: Mariano Duran, Luis Daniel Solano, Aaron Chacón


```

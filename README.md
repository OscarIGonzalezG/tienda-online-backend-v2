# 🛒 Tienda Online - Backend (versión 2)

Este es un backend RESTful reconstruido desde cero como una versión optimizada de [mi proyecto anterior](https://github.com/OscarIGonzalezG/TiendaRopa_BackEnd).

## 🚀 Tecnologías
- Java 17
- Spring Boot 3
- Spring Security + JWT
- PostgreSQL
- Maven
- Lombok

## 📌 Objetivos de esta versión
- Estructura profesional y escalable
- Seguridad avanzada con JWT
- Documentación paso a paso (Notion + README)
- Lógica de negocio limpia y desacoplada
- Preparación para integración con Next.js frontend

## 📦 Módulo: Entidades base (User y Role)

### User.java
Clase que representa a los usuarios del sistema (ADMIN, VENDEDOR, CLIENTE).  
Contiene: id, name, email, password, role.

### Role.java
Enum con los posibles roles de usuario.

---

## 🧾 Módulo: Configuración de base de datos

Conexión configurada en application.properties:

- URL de PostgreSQL
- Usuario y contraseña
- Propiedades de JPA (update, show-sql)

La base de datos se conecta correctamente y genera automáticamente las tablas.

---

## 📁 Módulo: Repositorio de Usuario

### UserRepository.java
Repositorio JPA para manejar persistencia de usuarios.

- findByEmail(email): usado para login
- existsByEmail(email): validación en registro

---

## ⚠ Estado del proyecto
Actualmente en desarrollo.  
Cada módulo será subido y documentado a medida que se construya.

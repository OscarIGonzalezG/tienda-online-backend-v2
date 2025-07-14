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
## 🔐 Módulo: Autenticación

### DTOs (Data Transfer Objects)
- `RegisterRequest`: recibe nombre, email y contraseña
- `LoginRequest`: recibe email y contraseña
- `AuthResponse`: devuelve datos del usuario autenticado y token

### AuthService.java
Lógica central del login y registro:
- Registra usuarios codificando su contraseña
- Verifica credenciales en login
- Devuelve un `AuthResponse` (token aún es simulado)

### AuthenticationController.java
Rutas públicas:
- `POST /api/auth/register`
- `POST /api/auth/login`

> ⚠️ Las pruebas desde Postman fallarán hasta configurar seguridad con Spring Security + JWT

---

### ✅ Seguridad – Adaptación y errores resueltos

- Se creó `UserDetailsImpl` para adaptar la entidad `User` a la interfaz `UserDetails` de Spring Security.
- Esto permitió mantener la lógica de seguridad desacoplada del modelo de dominio.
- Se mantuvo `DaoAuthenticationProvider` (aunque esté deprecado), por claridad en la configuración.

---
💡 Nota:
El IDE sugiere reemplazar el getter manual en `UserDetailsImpl` por `@Getter` de Lombok.  
Se mantiene manual para mayor claridad en esta etapa del proyecto.

---
💡 Nota 2:
Se detectó un error común al implementar JWT: mal uso de `SignatureAlgorithm` (escrito como `SingnatureAlgorithm`).  
Corregirlo garantiza que el token se firme correctamente.

---
## ⚠ Estado del proyecto
Actualmente en desarrollo.  
Cada módulo será subido y documentado a medida que se construya.

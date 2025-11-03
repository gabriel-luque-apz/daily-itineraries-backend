# 🗓️ Daily Itineraries

**Daily Itineraries** es una aplicación de escritorio, cuyo objetivo es ayudar a los usuarios a **organizar y gestionar itinerarios diarios** de forma sencilla.  
El sistema permite crear, editar, eliminar y visualizar itinerarios asociados a un usuario registrado.

---

## 🚀 Tecnologías utilizadas

### 🧩 Backend
- Java 21
- Spring Boot 3
- Spring Data JPA
- Spring Security
- MySQL (contenedor Docker)
- Maven

### 🎨 Frontend (próximamente)
- JavaFX
- CSS (para estilos)

---

## 🧱 Arquitectura

El proyecto sigue una arquitectura **cliente-servidor**:
- **Backend (Spring Boot)** actúa como servidor REST que gestiona la lógica de negocio y el acceso a datos.
- **Frontend (JavaFX)** funcionará como cliente de escritorio, comunicándose con el backend mediante peticiones HTTP.

---

## 🗄️ Modelo de datos

### 👤 User

| Campo | Tipo | Descripción |
|--------|------|-------------|
| `id` | Long | Identificador único |
| `username` | String | Nombre de usuario |
| `password` | String | Contraseña encriptada |
| `email` | String | Correo electrónico |

### 🧭 Itinerary

| Campo | Tipo | Descripción |
|--------|------|-------------|
| `id` | Long | Identificador único |
| `title` | String | Título del itinerario |
| `description` | String | Descripción del itinerario |
| `date` | Date | Fecha (día/mes/año) |
| `priority` | Enum (LOW, MEDIUM, HIGH) | Nivel de prioridad |
| `user` | User | Usuario propietario del itinerario |

---

## 🔗 Relaciones

- **Un usuario puede tener varios itinerarios** (`@OneToMany`).
- **Cada itinerario pertenece a un único usuario** (`@ManyToOne`).

---

## ⚙️ Configuración del entorno

### 🧰 Requisitos previos
- JDK 21+
- Maven
- Docker y Docker Compose
- IntelliJ IDEA (recomendado)

---

### 🐬 Configuración de base de datos

El proyecto utiliza **MySQL** dentro de un contenedor Docker.

Ejemplo de comando:

```bash
docker run --name daily-itineraries-db -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=daily-itineraries_db -p 3306:3306 -d mysql:8
```

```dockerfile
version: "3.8"

services:
  mysql:
    image: mysql:8
    container_name: mysql_daily-itineraries
    restart: always
    environment:
      MYSQL_ROOT_PASSWORD: PASSWORD
      MYSQL_DATABASE: daily-itineraries_db
      MYSQL_USER: USERNAME
      MYSQL_PASSWORD: PASSWORD
    ports:
      - "3307:3306"
    volumes:
      - mysql_data:/var/lib/mysql
volumes:
  mysql_data:
```
### Configura el archivo `application.properties` con tus credenciales:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/daily-itineraries_db
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
### 🧪 Endpoints principales (API REST)
👤 Users

| Método | Endpoint       | Descripción |
|--------|----------------|-------------|
| `GET` | `/api/users`   | Lista todos los usuarios|
| `GET` | `/api/users/{id}` | Obtiene un usuario por su ID|
| `POST` | `/api/users`   | Crea un nuevo usuario |
| `PUT` | `/api/users/{id}` | Actualiza un usuario |
| `DELETE` | `/api/users/{id}` | Elimina un usuario |


### 🧪 Endpoints principales (API REST)
🧭 Itineraries

| Método | Endpoint       | Descripción |
|--------|----------------|-------------|
| `GET` | `/api/itineraries/`   | Lista todos los itinerarios|
| `GET` | `/api/itineraries/{id}` | Obtiene un itinerario por su ID|
| `POST` | `/api/itineraries`   | Crea un nuevo itinerario |
| `PUT` | `/api/itineraries/{id}` | Actualiza un itinerario |
| `DELETE` | `/api/itineraries/{id}` | Elimina un itinerario |

### 🔐 Seguridad

El proyecto utiliza Spring Security.
Durante el desarrollo, se emplea autenticación básica (Basic Auth) para acceder a los endpoints desde Postman.


### 🖥️ Frontend (pendiente)

El frontend se desarrollará con JavaFX, que permitirá:

- Iniciar sesión y registrar usuarios. 

- Visualizar itinerarios del usuario autenticado.

- Crear, editar y eliminar itinerarios desde la interfaz gráfica.

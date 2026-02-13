# Tercera Fase Pipe_Line CI/CD

## Primero subiremos el proyecto Spring-Boot con el que trabajaremos.

### 1. Preparar el proyecto en **Spring Initializr**.

> Se le han puesto las siguientes dependencias:

- **Spring Web** - API REST + JSON automático.
- **Spring Data** JPA - Repositorios + PostgreSQL.
- **PostgreSQL Driver** - Conexión DB.
- **Spring Boot DevTools** - Hot reload desarrollo.

### 2. Preparacion del proyecto para usarlo.

***La creacion y configuracion me las saltare porque no es lo que se evaluara.***

### 3. Comenzamos con la preparacion de la practica.

#### 3.1. application.yml

```yml
spring:
  datasource: # Configuración de la fuente de datos.
    url: ${SPRING_DATASOURCE_URL:jdbc:postgresql://localhost:5432/cicd} 
    username: ${SPRING_DATASOURCE_USERNAME:user} # Usuario de la Base de Datos.
    password: ${SPRING_DATASOURCE_PASSWORD:pass} # Contraseña del usuario.
    driver-class-name: org.postgresql.Driver

  jpa: # Configuración de JPA
    hibernate: # Configuración específica de Hibernate
      ddl-auto: create-drop # BORRA y RECREA tablas cada inicio
    show-sql: true # Muestra SQL en consola
server:
  port: 8080
``` 

#### 3.2. docker-compouse.yml

Solo utilizaremos un docker-compouse.yml

#### 3.3. 
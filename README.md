# Introducción al Proyecto:

**Objectiu de la pràctica:** Configurar pipeline CI/CD completa amb GitHub Actions per aplicació Spring Boot.

**Aplicació model:** API REST headless (Spring Boot 3.3.4) amb:
- 3 entitats JPA: Usuario, Producto, Pedido  
- 6 endpoints JSON: GET/POST usuaris, productes, pedidos
- 30 tests JUnit 5 (@WebMvcTest + Mockito)
- PostgreSQL 16 via Docker Compose

**Tecnologies principals:**
Backend: Spring Boot 3.3.4 + Java 21 + Maven
Pipeline: GitHub Actions + Checkstyle + Docker
Tests: JUnit 5 + Testcontainers

## Estructura del proyecto.
```
springboot-ci-cd/
├─ .github/
│  └─ workflows/
│     └─ cicd.yml
├─ Backend/
│  ├─ src/
│  │  ├─ main/
│  │  │  ├─ java/
│  │  │  │  └─ IFC33/
│  │  │  │     └─ Pipe_CI_CD/
│  │  │  │        ├─ controller/
│  │  │  │        │  ├─ PedidoController.java
│  │  │  │        │  ├─ ProductoController.java
│  │  │  │        │  └─ UsuarioController.java
│  │  │  │        ├─ model/
│  │  │  │        │  ├─ Pedido.java
│  │  │  │        │  ├─ Producto.java
│  │  │  │        │  └─ Usuario.java
│  │  │  │        ├─ repository/
│  │  │  │        │  ├─ PedidoRepository.java
│  │  │  │        │  ├─ ProductoRepository.java
│  │  │  │        │  └─ UsuarioRepository.java
│  │  │  │        └─ PipeCiCdApplication.java
│  │  │  └─ resources/
│  │  │     ├─ static/
│  │  │     ├─ templates/
│  │  │     ├─ application.properties
│  │  │     ├─ application.yml
│  │  │     └─ data.sql
│  │  └─ test/
│  │     ├─ java/
│  │     │  └─ IFC33/
│  │     │     └─ Pipe_CI_CD/
│  │     │        └─ PipeCiCdApplicationTests.java
│  │     └─ resources/
│  │        ├─ application-test.yml
│  │        └─ application.properties
│  ├─ target/
│  │  ├─ classes/
│  │  │  ├─ IFC33/
│  │  │  │  └─ Pipe_CI_CD/
│  │  │  │     ├─ controller/
│  │  │  │     │  ├─ PedidoController.class
│  │  │  │     │  ├─ PedidoController$PedidoDTO.class
│  │  │  │     │  ├─ ProductoController.class
│  │  │  │     │  └─ UsuarioController.class
│  │  │  │     ├─ model/
│  │  │  │     │  ├─ Pedido.class
│  │  │  │     │  ├─ Producto.class
│  │  │  │     │  └─ Usuario.class
│  │  │  │     ├─ repository/
│  │  │  │     │  ├─ PedidoRepository.class
│  │  │  │     │  ├─ ProductoRepository.class
│  │  │  │     │  └─ UsuarioRepository.class
│  │  │  │     └─ PipeCiCdApplication.class
│  │  │  ├─ application.properties
│  │  │  ├─ application.yml
│  │  │  └─ data.sql
│  │  ├─ generated-sources/
│  │  │  └─ annotations/
│  │  ├─ generated-test-sources/
│  │  │  └─ test-annotations/
│  │  ├─ maven-status/
│  │  │  └─ maven-compiler-plugin/
│  │  │     ├─ compile/
│  │  │     │  └─ default-compile/
│  │  │     │     ├─ createdFiles.lst
│  │  │     │     └─ inputFiles.lst
│  │  │     └─ testCompile/
│  │  │        └─ default-testCompile/
│  │  │           ├─ createdFiles.lst
│  │  │           └─ inputFiles.lst
│  │  ├─ surefire-reports/
│  │  │  ├─ IFC33.Pipe_CI_CD.ProductoControllerTest.txt
│  │  │  └─ TEST-IFC33.Pipe_CI_CD.ProductoControllerTest.xml
│  │  └─ test-classes/
│  │     ├─ IFC33/
│  │     │  └─ Pipe_CI_CD/
│  │     │     └─ ProductoControllerTest.class
│  │     ├─ application-test.yml
│  │     └─ application.properties
│  ├─ .gitattributes
│  ├─ .gitignore
│  ├─ Dockerfile
│  ├─ mvnw
│  ├─ mvnw.cmd
│  └─ pom.xml
├─ init.sql/
├─ target/
│  └─ Pipe_CI_CD-0.0.1-SNAPSHOT.war/
├─ checkstyle.xml
├─ docker-compose.yml
└─ README.md
```

# Comados para poner en marcha y cargar archivos.

**Inicia todo y permite hacer los tests en local:**

1. Clonar y preparar
```bash
git clone https://github.com/SvenLee-J/springboot-ci-cd
cd springboot-ci-cd
```

2. Entorno desarrollo completo
```bash
docker compose up -d
```

3. Prueba de tests en local
```bash
cd Backend
mvn clean test
```

## Comprovaciones de endpotins:

- http://localhost:8080/api/usuarios

- http://localhost:8080/api/productos

- http://localhost:8080/api/pedidos


# Lista de tests

De 1 a 15 son tests @WebMvcTest sobre endpoints REST:
- GET /api/productos, /api/usuarios, /api/pedidos
- POST /api/productos, /api/usuarios (status 200 con JSON válido)

De 16 a 25 son tests unitarios Mockito sobre repositories:
- assertNotNull(productoRepository), usuarioRepository, pedidoRepository
- assertNotNull(mockMvc), contexto @WebMvcTest

De 26 a 30 son tests de integración preparación:
- Paths endpoints + content-type validation

# Descipcion del workflow

El workflow hace:

- Clona el código (checkout@v4)
- Instala Java 21 (setup-java@v4)
- Cachea Maven (actions/cache@v4) para builds rápidos
- Compila + ejecuta 30 tests (mvn clean package && mvn test)
- Construye imagen Docker (docker build -t cicd-app)

## Descripcion.

- uses: actions/checkout@v4
  
  > Clona el repositorio completo

- name: Set up Java 21
  uses: actions/setup-java@v4
  
  > Instala JDK 21 (Temurin) para compilar

- name: Cache Maven
  uses: actions/cache@v4  

  > Guarda dependencias Maven para builds más rápidos

- name: Build and Test
  run:
    cd Backend
    mvn clean package = Compila y genera JAR
    mvn test = Ejecuta 30 tests JUnit

- name: Build Docker image
  run: |
    cd Backend
    docker build -t cicd-app . =  Crea imagen Docker

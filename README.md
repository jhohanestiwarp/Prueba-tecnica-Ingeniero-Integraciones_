
Project API

API para la administración de cuentas, bancos y usuarios de la compañía simulada Project.
Construida bajo el enfoque de programación reactiva utilizando Spring WebFlux y Spring Security para el manejo de permisos y roles, siguiendo la arquitectura hexagonal.

Documentación API

API Docs (Postman): Ver documentación
https://documenter.getpostman.com/view/11322676/2sB3HtFGrb

Colección Postman: Descargar

https://www.mediafire.com/file/61fqigmy9yzwjac/BancoUnion.postman_collection.json/file

Base de Datos
https://www.mediafire.com/file/xssdza8f844dftb/dump-bancoUnion-202509202349.sql/file


Dump SQL: Descargar

Motor usado: PostgreSQL

Conexión (R2DBC)
spring:
r2dbc:
url: r2dbc:postgresql://localhost:5432/AutoManager
username: postgres
password: 12345678

Docker

Imagen disponible en DockerHub:
project_api:1.0

Levantar aplicación con Docker
# Descargar imagen
docker pull berserker04/project_api:1.0

Ejecutar contenedor
docker run -p 8000:8000 berserker04/project_api:1.0


API expuesta en: http://127.0.0.1:8000

Health check: http://127.0.0.1:8000/api/v1/health

🔑 Credenciales de prueba

{
"email": "carlos2.perez@example.com",
"password": "secreto123"
}


Usuario Cliente

"email": "carlos2.perez@example.com",
"password": "secreto123"

⚙️ Tecnologías

Framework: Spring Boot 3.1.1

Lenguaje: Java 17

Reactive Stack: Spring WebFlux

Base de datos: PostgreSQL (con R2DBC)

Seguridad: Spring Security + JWT

Build Tool: Gradle

Arquitectura: Hexagonal (puertos y adaptadores)

Infraestructura: Docker
<img width="1534" height="946" alt="image (11)" src="https://github.com/user-attachments/assets/448b6b56-88fe-45ae-889c-eb73399d44eb" />
<img width="1492" height="941" alt="image (7)" src="https://github.com/user-attachments/assets/24bbb3bd-0a8f-4261-8803-6d76192b0632" />
<img width="1507" height="948" alt="image (8)" src="https://github.com/user-attachments/assets/c36a966a-bf0f-4f45-a176-f1d4eef8bd1d" />
<img width="1515" height="935" alt="image (9)" src="https://github.com/user-attachments/assets/f6047847-f529-48f4-9874-a502fc6e7108" />
<img width="1520" height="941" alt="image (10)" src="https://github.com/user-attachments/assets/4d542ba6-8b0e-4353-8b78-1c79697b4a13" />


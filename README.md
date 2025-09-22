
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


Prueba_Tecnica_Integraciones_Respuestas_Jhohan
https://www.mediafire.com/file/7ms0fmfsqvwjuk2/Prueba_Tecnica_Integraciones_Respuestas_JhohanPalacios.pdf/file

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

<img width="1534" height="946" alt="image (7)" src="https://github.com/user-attachments/assets/ff84b35c-a9d1-49de-8479-4594cd5965f2" />
<img width="1515" height="935" alt="image (5)" src="https://github.com/user-attachments/assets/d6575c13-0f8b-477c-959b-016b28e81bca" />
<img width="1520" height="941" alt="image (6)" src="https://github.com/user-attachments/assets/8e77592b-0693-4b04-aa4e-7c5f28bd47a2" />
<img width="1492" height="612" alt="image (3)" src="https://github.com/user-attachments/assets/e141511b-221f-4cd9-af71-d8034971686c" />
<img width="1507" height="714" alt="image (4)" src="https://github.com/user-attachments/assets/11e63f2f-d3e3-4128-9e03-9b7413d2e5c7" />


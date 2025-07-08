# 📚 API REST - Gestión de Libros con Lombok y Spring Boot

Este proyecto es una API REST básica desarrollada con **Java y Spring Boot**, que permite realizar operaciones CRUD sobre una entidad "Libro". Se utiliza **Lombok** para reducir código repetitivo mediante anotaciones como `@Data`, `@Builder`, `@AllArgsConstructor`, entre otras.

## 🚀 Tecnologías utilizadas

- Java 17  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- Lombok  
- MySQL  
- Maven

## ✨ Funcionalidades principales

- Crear, consultar, actualizar y eliminar libros
- Conexión a base de datos relacional (MySQL)
- Uso de anotaciones Lombok para simplificar el código
- Arquitectura RESTful básica

## 🔧 Cómo ejecutar el proyecto

1. Clona este repositorio:
   ```bash
   git clone https://github.com/JoahanCarlo/libro_lombok.git

2. Configura la base de datos en el archivo application.properties:
   spring.datasource.url=jdbc:mysql://localhost:3306/libros_db
   spring.datasource.username=root
   spring.datasource.password=tu_contraseña

3. Ejecutar la aplicación:
   ./mvnw spring-boot:run

# Spring Boot Security + JWT Authentication API

A Spring Boot REST API demonstrating database-backed authentication and authorization using Spring Security, BCrypt password hashing, and JWT.

## Featues 

- User registration
- User login
- BCrypt password hashing
- JWT Authentication
- JWT authorization filter
- Role-based authorization
- USER and ADMIN roles
- Protected REST endpoints
- MySQL database
- Environment variables for sensitive configuration
- REST-style 401 and 403 responses 

## Technology

- Java 21
- Spring Boot
- Spring Security 
- Spring Data JPA
- Hibernate
- MySQL 
- JWT (JJWT)
- Maven 
- Postman 
- Git/GitHub

## API Endpoints

Method | Endpoint   | Authentication  | Description
POST   | `/register`| No              | Register a new user
POST   | `/login`   | No              | Login and receives user endppoint
GET    | `/hello`   | JWT required    | Protected user endpoint
GET    | `/admin`   | ADMIN role      | Protected admin endpoint

## Authentication Flow
1. User registers with username and password.
2. Password is hashed using BCrypt before being stored.
3. User logs in with username and password.
4. The server verifies the credentials.
5. A JWT is generated and returned.
6. The client sends the JWT using the `Authorization` header.
7. `JwtAuthenticationFilter` validates the token.
8. Spring Security creates the authenticated security context.
9. Protected endoints can then be accessed according according t the user's role.

## Example Authorities Header

```text 
Authorization: bearer OUT_JWT_TOKEN

Configuration
The project uses environment variables for sensitive information.
Required variable: 
DB_PASSWORD
JWT_SECRET

Example 
spring.datasource.password=${DB_PASSWORD}
jwt.secret=${JWT_SECRET}

Do not put real password ot JWT secrets directly into the source code.

## Testing 
The API was tested using Postman, including:
. Successful user login
. JWT-protected /hello
. USER attempting to access /admin
. Successful ADMIN ccess to /admin
. Registration
. Authentication failures

## Project Structure

src/main/java/com/example/securitypractice/

├── config/
│   └── SecurityConfig.java
│
├── controller/
│   └── UserController.java
│
├── dto/
│   ├── LoginRequest.java
│   ├── LoginResponse.java
│   └── RegisterRequest.java
│
├── entity/
│   └── User.java
│
├── repository/
│   └── UserRepository.java
│
├── security/
│   ├── DatabaseUserDetailsService.java
│   ├── JwtAuthenticationFilter.java
│   ├── JwtService.java
│   └── RestAuthenticationEntryPoint.java
│
├── service/
│   └── UserService.java
│
├── HelloController.java
└── SecuritypracticeApplication.java

## How to Run
1. Clone the repository
got clone https://github.com.Abdullah0192.securitypractice.git
cd securitypractice

2. Configure environment variables 
Set: 
DB_PASSWORD=your_mysql_password
JWT_SECRET=your-long-secret-key

3. Start the application 
mvn spring-boot:run

The application runs on: http://localhost:8080

##Learning Purpose
This project was created as part of my Java/Spring Boot backend develeopment journey to practice:
. Spring Security
. JWT authentication
. Authentication vs authorization
. Role-based access control
. database-backed users
. Secure password storage
. REST API security

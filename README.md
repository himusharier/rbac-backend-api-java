# RBAC Backend API (Spring Boot + JWT)

A Spring Boot RBAC API that uses JWT for stateless authentication and role-based authorization.

## Tech Stack
- Java 17
- Spring Boot 3
- Spring Security
- Spring Data JPA
- H2 Database
- JJWT

## Run
```bash
mvn spring-boot:run
```

## API Documentation (Swagger)
- Swagger UI: http://localhost:8080/swagger-ui/index.html
- OpenAPI JSON: http://localhost:8080/v3/api-docs

## Default Seeded Users
- admin / admin123 (ROLE_ADMIN)
- user / user123 (ROLE_USER)

## Authentication
1. Login:
```http
POST /api/auth/login
Content-Type: application/json

{
  "username": "admin",
  "password": "admin123"
}
```
2. Use returned token:
```http
Authorization: Bearer <token>
```

## Sample Endpoints
- Public:
  - POST /api/auth/login
  - POST /api/auth/register
- User and Admin:
  - GET /api/user/me
- Admin only:
  - GET /api/admin/users

## Access Matrix
- ROLE_USER: `/api/user/**`
- ROLE_ADMIN: `/api/user/**`, `/api/admin/**`

## API Client Import
- Postman collection file: `api-client/rbac-backend-api.postman_collection.json`

# RBAC Backend API Build Plan (Spring Boot + JWT)

## 1. Project Setup
- Initialize a Spring Boot project using Java 17 and Maven.
- Add dependencies:
  - spring-boot-starter-web
  - spring-boot-starter-security
  - spring-boot-starter-data-jpa
  - spring-boot-starter-validation
  - jjwt-api, jjwt-impl, jjwt-jackson
  - h2 (for local/dev)
  - lombok
  - spring-boot-starter-test, spring-security-test
- Define package structure:
  - config
  - security
  - controller
  - service
  - repository
  - model
  - dto
  - exception

## 2. Domain and Persistence
- Create entities:
  - User (id, username, email, password, enabled)
  - Role (id, name)
- Define many-to-many relation between User and Role.
- Create repositories:
  - UserRepository
  - RoleRepository
- Add startup seeding for default roles and test users.

## 3. Security and JWT
- Implement JWT utilities:
  - token generation
  - token validation
  - extracting username and claims
- Implement `UserDetailsService` for loading users from DB.
- Create `JwtAuthenticationFilter` to parse Bearer token and set authentication context.
- Configure `SecurityFilterChain`:
  - stateless session policy
  - disable CSRF (REST API)
  - register JWT filter before username/password filter

## 4. Authentication Flow
- Implement auth endpoints:
  - POST `/api/auth/login` (returns JWT)
  - POST `/api/auth/register` (optional initial self-registration)
- Hash passwords with BCrypt.
- Return structured auth responses with token and user role list.

## 5. RBAC Authorization
- Define role constants (`ROLE_ADMIN`, `ROLE_USER`).
- Protect endpoints with role-based rules:
  - Public: `/api/auth/**`
  - User/Admin: `/api/user/**`
  - Admin only: `/api/admin/**`
- Add method-level authorization using `@PreAuthorize` where useful.

## 6. API Endpoints
- Add sample secured controllers:
  - UserController (profile, self data)
  - AdminController (user management examples)
- Use DTOs and validation annotations.
- Add consistent error handling for auth and validation errors.

## 7. Configuration
- Add `application.yml` with:
  - datasource and JPA settings
  - JWT secret and expiration
  - server port
- Keep sensitive config externalizable via environment variables.

## 8. Testing and Verification
- Unit tests:
  - JWT utility
  - auth service
- Integration tests:
  - login and protected route access
  - role restriction checks (admin vs user)
- Run `mvn clean test` and verify all pass.

## 9. Delivery Notes
- Provide README with:
  - setup/run instructions
  - default seeded users
  - sample login request and Bearer usage
  - endpoint access matrix by role

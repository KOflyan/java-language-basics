## Swagger is available at: http://localhost:8080/api/swagger-ui/index.html
## https://jwt.io/

---

## Goals
1. All endpoints except Swagger should require authentication (that is, a valid JWT should be sent in request headers).
2. Each trainer with `USER` role should only be able to access & update their own data.
3. Each trainer with `ADMIN` role should have full access.
---

## Execution

1. We will need to add new columns to the trainer entity:
```
username VARCHAR(255)
password VARCHAR(1000)
role VARCHAR(255) -- corresponds to `Role` enum in security folder. Hint: use @Enumerated(EnumType.STRING).
```
TO do this, update the entity class and then create a migration:

```sql
ALTER TABLE "trainer"
    ADD COLUMN "username" VARCHAR(255) NOT NULL DEFAULT '',
    ADD COLUMN "password" VARCHAR(1000) NOT NULL DEFAULT '',
    ADD COLUMN "role" VARCHAR(255) NOT NULL DEFAULT 'USER'
;

UPDATE "trainer"
SET "username" = LOWER("name"),
    "password" = LOWER("name")
;

UPDATE "trainer" SET "role" = 'ADMIN' WHERE "username" = 'ash'
;

ALTER TABLE "trainer"
    ALTER COLUMN "username" DROP DEFAULT,
    ALTER COLUMN "password" DROP DEFAULT
;
```

2. Add the following dependencies to build.gradle:
```
implementation 'org.springframework.boot:spring-boot-starter-security:3.2.2'
implementation 'io.jsonwebtoken:jjwt-api:0.12.4'
implementation 'io.jsonwebtoken:jjwt-impl:0.12.4'
implementation 'io.jsonwebtoken:jjwt-jackson:0.12.4'
```

First dependency enables spring security module, subsequent ones are needed to parse the JWT.


3. Investigate `security` folder. Uncomment classes which are now commented out.
Add `@SecurityRequirement(name = "bearerAuth")` annotation for each controller class.
4. Verify that authentication works: go to swagger and try to call any endpoint. You should see 403 FORBIDDEN error.
5. Generate a token for `Ash` using [jwt.io](https://jwt.io).
Set this token in Swagger via `Authorize` button and try calling an endpoint.
6. Make `GET /api/trainer` endpoint available to users with `ADMIN` role only (Hint: `@PreAuthorize("hasAuthority('ADMIN')")`). Test via Swagger.
7. Make sure that trainers can only access and modify their own data (Hint: use `CurrentUser` to get the currently authenticated user).

---

## Extra

1. Introduce `/api/trainer/login` endpoint which asks for username and password. If match is found in the db, endpoint should generate a JWT token and include it in the response:
```json
{
  "token": "asdsfdsf"
}
```
2. Change `/api/trainer/save` so that it accepts username & password, and then saves those to the database (encode password with `PasswordEncoder` before saving).
Endpoint should return saved trainer info along with freshly generated JWT token:

```json
{
  "id": 123,
  "name": "Leon",
  "token": "asdfasdf"
}
```
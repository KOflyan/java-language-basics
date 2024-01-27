## Swagger is available at: http://localhost:8080/api/swagger-ui/index.html


1. Create database `pokemon` using `CREATE DATABASE` SQL statement.
2. Add following dependencies to `build.gradle`:
```
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
implementation 'org.flywaydb:flyway-core:9.21.0'
implementation 'org.postgresql:postgresql:42.6.0'
```
3. Create a folder `src/main/resources/migration`.
4. Add following lines to the `application.properties` file:
```
spring.jpa.hibernate.ddl-auto=none
spring.datasource.url=jdbc:postgresql://localhost:5432/pokemon
spring.datasource.username=postgres
spring.datasource.password=<your pass>
```

5. Check out `LESSON-10-data.sql`. Create your first SQL migration file: `src/main/resources/db/migration/V1__initial_db_schema.sql` 
with the content from `LESSON-10-data.sql`. Run the app and verify that database is populated.

6. Migrate the application logic from using files to using database tables.
To do this, you will need to convert existing models (e.g. Pokemon) to [JPA entities](https://www.baeldung.com/jpa-entities).
You will need to add [repositories](https://medium.com/@bubu.tripathy/best-practices-creating-repository-interfaces-with-jpa-d904bee64397) for the database operations,
e. g. (`public class PokemonRepository extends JpaRepository<Pokemon, Integer>`, where `Pokemon` is the entity we defined and `Integer` is the type of primary key column).

7. Add additional properties to the caught Pokemon (create a migration and update the `TrainerPokemon` entity):
```
attack - numeric
defence - numeric
hit_points - smallint
```
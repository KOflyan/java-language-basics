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
spring.jpa.show-sql=true
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
Entity definitions for `Trainer` and `TrainerToPokemon` are provided below:

```java
@NoArgsConstructor
@Getter @Setter
@Entity(name = "trainer")
public class Trainer {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column
    private String name;

    @Column
    private String location;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "trainer", fetch = FetchType.LAZY)
    @SQLRestriction("is_caught")
    private Set<TrainerPokemon> caughtPokemon;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "trainer_pokemon",
            joinColumns = @JoinColumn(name = "trainer_id"),
            inverseJoinColumns = @JoinColumn(name = "pokemon_id")
    )
    @SQLJoinTableRestriction("NOT is_caught")
    private Set<Pokemon> pokemonToCatch;
}


@Entity(name = "trainer_pokemon")
@NoArgsConstructor
@Getter @Setter
public class TrainerPokemon {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    private Integer level;

    @Column(name = "is_caught")
    private Boolean isCaught;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pokemon_id", nullable = false)
    @JsonIgnore
    private Pokemon pokemon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_id", nullable = false)
    @JsonIgnore
    private Trainer trainer;
}
```

7. Add additional properties to the caught Pokemon (create a migration and update the `TrainerPokemon` entity):
```
attack - numeric
defence - numeric
hit_points - smallint
```
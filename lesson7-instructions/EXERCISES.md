
EX 1
----

1. Create a Spring project: `lesson7-spring-introduction`.
Use Spring Initializr, make sure to select `gradle (groovy)`, `Java 21`.
2. Add Swagger support for the project. Hint: add the following dependency:
```groovy
implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0'
```
Swagger should be available at: `http://localhost:8080/swagger-ui/index.html`
3. Create a GET endpoint which returns `"Hello world!"`.
4. Create a GET endpoint which takes in a URL param, `name` and returns the following JSON:
```json
{
  "name": "<name>",
  "message": "Hello <name>!"
}
```
5. Create a DTO class called `StudentDto`. Add a POST endpoint which accepts this DTO and validates it.
In case input passes the validation, endpoint should return this JSON: `{ "message": "Student object is valid!" }`
`StudentDto` should have the following attributes: `String name`, `Integer age`.
Validation rules:
* Both attributes should not be null
* Name should not be empty and age should be at least 16
* name should consist of alphabetic characters only

Hint: you will need the following dependency:
```groovy
implementation 'org.springframework.boot:spring-boot-starter-validation:3.2.1'
```

EX 2
----

1. Create a JSON representation of the following data:

```
   Name     Grade    Course      School       Favorite subjects       Does sports?
+---------+-------+----------+------------+------------------------+----------------+
| Alice   |   3   |     1    | Harvard    |  math, biology         |      true      |
+---------+-------+----------+------------+------------------------+----------------+
| Bob     |   4   |     1    | TUT        |  economics, business   |      false     |
+---------+-------+----------+------------+------------------------+----------------+
| Martha  |   5   |     3    | Cambridge  |  internation relations |      true      |
+---------+-------+----------+------------+------------------------+----------------+
```
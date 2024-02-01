x## Swagger is available at: http://localhost:8080/api/swagger-ui/index.html

# Description

In Pokémon world, trainers need a convenient way to store and update information about the Pokémon
they own or want to catch. Of course, a trainer yourself, you feel the pain and decide to solve the problem
once and for all by creating a web application!


# Requirements

Create an API, which provides the following functionality:

* Creating Trainers
* Updating Trainer data
* Creating Pokémon
* Updating Pokémon data
* Adding existing Pokémon to a trainer
* Transferring Pokémon from one trainer to another
* Listing saved trainers and Pokémon

All accepted data must be validated.
Use JSON files for saving data (`pokemon.json` & `trainer.json`)

------


## Pokemon

### Pokémon data

```
id - unique numeric identifier
name - Pokémon's name, alphabetic, at least 2 characters
level - integer, min 1 max 100
species - Pokémon's species (e.g. `charizard`, `pikachu`), alphabetic, at least 3 characters
type - Pokémon's type (e.g. rock, ice, electric), at least 3 characters
createdAt - timestamp when the Pokémon was created
```

### Endpoints

* `GET /api/pokemon`
  * Return all Pokémon which were previously saved. If none is available, return an empty list.
* `GET /api/pokemon/{id}`
  * Return saved Pokémon details by the provided id value. If Pokémon with such id does not exist,
    `NotFound` exception should be thrown.
* `POST /api/pokemon`
  * Save provided Pokémon data to a file. 
  If pokemon data does not pass validation, should throw `BadRequest` exception.
  If Pokemon already exists (same `name`, `species` & `type`) - should throw `Conflict` exception.
  Otherwise should save pokemon data to a file and return `201` http status.
* `PATCH /api/pokemon/{id}`
  * Update existing Pokémon data in a file.
  If data does not exist, throw `NotFound` exception.
  If data does not pass validation, throw `BadRequest`.
  All properties except `id` and `createdAt` can be updated, all are optional -- if nothing is provded, nothing should be updated.
  Should return `204` http status when successful.  
* `GET /api/pokemon/{id}/trainer`
  * Return specified Pokémon's trainer data. If Pokemon with this id does not exist or it doesn't have a trainer yet, 
  should throw `NotFound` error.
* `PATCH /api/pokemon/{id}/transfer/{fromTrainerId}/{toTrainerId}`
  * Should transfer the specific Pokémon from one trainer to another -- deleting it from the first trainer's `pokemon` list 
  and adding to the second trainer's `pokemon` list. 
  If this Pokémon is not owned by the first trainer, throw `BadRequest` exception.
  If {fromTrainerId} is equal to {toTrainerId}, should throw `BadRequest` exception.

## Trainer

### Trainer data
`Trainer` should have the following data:
```
id - unique numeric identifier
name - trainer's name, alphabetic, at least 2 characters
currentLocation - optional location of a trainer (can be null)
pokemon - list of Pokémon which trainer has. Defaults to empty list.
pokemonToCatch - list of Pokémon species which trainer wants to catch. Defaults to empty list.
createdAt - timestamp when the trainer was created
```


### Endpoints:

* `GET /api/trainer`
  * Return all trainers which were previously saved. If none is available, return empty list.
  * Example: `GET /api/trainer` should return data for all trainers which were saved:
  ```json
  [
    {
      "id": 1,
      "name": "Ash",
      "currentLocation": "Misty Swamp",
      "pokemon": [
        {
          "id": 10,
          "name": "Sparky",
          "species": "flaafy",
          "createdAt": "2023-01-16 23:20"
        }
      ],
      "pokemonToCatch": ["charizard", "eevie", "pikachu"],
      "createdAt": "2023-01-16 23:00"
    }
  ]
  ```
* `GET /api/trainer/{id}`
  * Return saved trainer details by the provided id value. If trainer with such id does not exist,
  `NotFound` exception should be thrown.
  * Example: `GET /api/trainer/1` should return trainer data for the trainer with id `1`:
  ```json
      {
      "id": 1,
      "name": "Ash",
      "currentLocation": "Misty Swamp",
      "pokemon": [
        {
          "id": 10,
          "name": "Sparky",
          "level": 5,
          "species": "flaafy",
          "type": "electric",
          "createdAt": "2023-01-16 23:20"
        }
      ],
      "pokemonToCatch": ["charizard", "eevie", "pikachu"],
      "createdAt": "2023-01-16 23:00"
    }
  ```
* `POST /api/trainer`
  * Save provided trainer data to a file. `name` must be provided, `currentLocation` and `pokemonToCatch` are optional.
  In case of successful request should return `201` http status. In case validation fails, should throw `BadRequest`.
  * Example: `POST /api/trainer` with data:
  ```json
  {
      "name": "Ash",
      "currentLocation": "Misty Swamp",
      "pokemonToCatch": ["charizard", "eevie", "pikachu"]
  }
  ```
  should create a new trainer.
* `PATCH /api/trainer/{id}`
  * Update existing trainer data in a file. If data does not exist, throw `NotFound` exception.
  Only `name` and `currentLocation` can be updated with this endpoint. Both are optional, if both are null nothing is updated.
  * Example: `PATCH http://localhost/api/trainer/1` with data
  ```json
  {
    "name": "Leon",
    "currentLocation": "Ancient Ruins"
  }
  ```
  should update existing trainer under id `1`.
* `PATCH /api/trainer/{trainerId}/addPokemon/{pokemonId}`
  * Adds Pokemon which was previously saved under this id to the trainer's Pokémon if it is not already there.
  If Pokémon of these species was present in `pokemonToCatch` list, remove it from the list.
  If the Pokémon already exists in `pokemon` list, throw `BadRequest` exception.
  If the Pokémon is already owned by another trainer, throw `BadRequest` exception.
  If Pokémon with this id does not exist or trainer with this id does not exists, should throw `NotFound` error.
  * Example call: `PATCH /api/trainer/1/addPokemon/1`.
* `PATCH /api/trainer/{id}/addPokemonToCatch/{species}`
  * Adds Pokémon species to the trainer's `pokemonToCatch` list if it is not already there.
  If the provided Pokémon species is already in the list, should throw `Conflict` error.
  If trainer with this id does not exist, should throw `NotFound` error.

------

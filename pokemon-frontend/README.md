# Creating frontend for Pokemon API

You can use the following token to call the API: `eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhc2giLCJpYXQiOjE1MTYyMzkwMjJ9.hQ8k-D18Fw4K-jcdxfps0dBfztU9reWyKm0Lc0JGyXI`

Swagger URL: http://localhost:8080/api/swagger-ui/index.html

Frontend server URL: http://localhost:3000

Style the components/pages as you like.

1. Define types for `GET /api/pokemon` endpoint response, put them in `types/pokemon.ts` file. Example endpoint response:
```json
[
  {
    "id": 1,
    "species": "ditto",
    "type": "normal",
    "createdAt": "2024-01-29T20:25:58.931869"
  },
  {
    "id": 2,
    "species": "charizard",
    "type": "fire",
    "createdAt": "2024-01-29T20:25:58.931869"
  },
  {
    "id": 3,
    "species": "sylveon",
    "type": "fairy",
    "createdAt": "2024-01-29T20:25:58.931869"
  }
]
```

2. Create a component named `PokemonTable`, which renders a table from the example data provided below.
Pokemon table should accept pokemon data in the format defined above (in `props`).
3. Create a page named `Home` and register it in `App.tsx`. Simply return `PokemonTable` from this page.
Verify that you see the table when opening the web page.
4. Add another page named `TrainerProfile` which shows trainer's data. At the moment let's assume a trainer has the following data only:
```json
{
  "id": 1,
  "name": "Ash",
  "location": "ancient ruins",
  "role": "ADMIN",
  "createdAt": "2024-01-29T20:25:58.931869"
}
```
You will need to add types for this data (`types/trainer.ts`) similarly how it was done before.
5. Add routing to the app using React router. Two routes should be available: 
   * `/` - shows pokemon table
   * `/profile` - shows trainer profile
5. Create a toolbar with 2 tabs: `Home` and `Profile`. Clicking on a respective tab should render the appropriate page.
6. Change the pokemon table so that data is fetched from pokemon API instead of static file.
Do same for profile (currently you can assume that data is always asked for trainer with id `1`).
7. Add a button to the `PokemonTable` component which allows to add new pokemon to the list.
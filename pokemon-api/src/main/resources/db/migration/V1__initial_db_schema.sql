-- Create pokemon table
CREATE TABLE "pokemon" (
                           "id" SERIAL PRIMARY KEY,
                           "species" VARCHAR(255) NOT NULL UNIQUE,
                           "type" VARCHAR(255) NOT NULL,
                           "created_at" TIMESTAMPTZ NOT NULL DEFAULT NOW()
)
;

-- Create trainer table
CREATE TABLE "trainer" (
                           "id" SERIAL PRIMARY KEY,
                           "name" VARCHAR(255) NOT NULL UNIQUE,
                           "location" VARCHAR(255),
                           "created_at" TIMESTAMPTZ NOT NULL DEFAULT NOW()
)
;
-- Create relation table (used for both caught pokemon and wishlist)
CREATE TABLE "trainer_pokemon" (
                                   "id" SERIAL PRIMARY KEY,
                                   "trainer_id" INTEGER NOT NULL,
                                   "pokemon_id" INTEGER NOT NULL,
                                   "name" VARCHAR(255),
                                   "level" SMALLINT,
                                   "is_caught" BOOLEAN NOT NULL,
                                   "created_at" TIMESTAMPTZ NOT NULL DEFAULT NOW()
)
;

-- Create constraints and indexes
ALTER TABLE "trainer_pokemon"
    ADD CONSTRAINT "uniq__trainer_pokemon__trainer_id_pokemon_id"
        UNIQUE (trainer_id, pokemon_id)
;

ALTER TABLE "trainer_pokemon"
    ADD CONSTRAINT "fk__trainer_pokemon__trainer_id"
        FOREIGN KEY ("trainer_id")
            REFERENCES trainer ("id")
            ON DELETE RESTRICT
            ON UPDATE RESTRICT
;

ALTER TABLE "trainer_pokemon"
    ADD CONSTRAINT "fk__trainer_pokemon__pokemon_id"
        FOREIGN KEY ("pokemon_id")
            REFERENCES pokemon ("id")
            ON DELETE RESTRICT
            ON UPDATE RESTRICT
;

CREATE INDEX "idx__trainer_pokemon__pokemon_ud"
    ON "trainer_pokemon" ("pokemon_id")
;

-- Add pokemon data
INSERT INTO "pokemon"
("species", "type")
VALUES
    ('ditto', 'normal'),
    ('charizard', 'fire'),
    ('sylveon', 'fairy'),
    ('flaaffy', 'electric'),
    ('snorlax', 'normal'),
    ('ekans', 'poison'),
    ('lunatone', 'rock/psychic'),
    ('rapidash', 'psychic/fairy'),
    ('jigglypuff', 'normal/fairy'),
    ('magikarp', 'water'),
    ('togepi', 'fairy'),
    ('oddish', 'grass/poison'),
    ('pikachu', 'electric')
;

-- Add trainer data
INSERT INTO "trainer"
("name", "location")
VALUES
    ('Ash', 'ancient ruins'),
    ('May', 'lasnamäe')
;

-- Add relation data
INSERT INTO "trainer_pokemon"
(trainer_id, pokemon_id, name, level, is_caught)
VALUES
    (
        (SELECT id FROM "trainer" WHERE "name" = 'Ash'),
        (SELECT id FROM "pokemon" WHERE "species" = 'ditto'),
        'Di',
        2,
        true
    ),
    (
        (SELECT id FROM "trainer" WHERE "name" = 'Ash'),
        (SELECT id FROM "pokemon" WHERE "species" = 'ekans'),
        'Snakey',
        3,
        true
    ),
    (
        (SELECT id FROM "trainer" WHERE "name" = 'May'),
        (SELECT id FROM "pokemon" WHERE "species" = 'jigglypuff'),
        'Puff',
        5,
        true
    ),
    (
        (SELECT id FROM "trainer" WHERE "name" = 'May'),
        (SELECT id FROM "pokemon" WHERE "species" = 'flaaffy'),
        null,
        null,
        false
    ),
    (
        (SELECT id FROM "trainer" WHERE "name" = 'May'),
        (SELECT id FROM "pokemon" WHERE "species" = 'magikarp'),
        null,
        null,
        false
    ),
    (
        (SELECT id FROM "trainer" WHERE "name" = 'Ash'),
        (SELECT id FROM "pokemon" WHERE "species" = 'togepi'),
        null,
        null,
        false
    ),
    (
        (SELECT id FROM "trainer" WHERE "name" = 'Ash'),
        (SELECT id FROM "pokemon" WHERE "species" = 'charizard'),
        null,
        null,
        false
    )
;
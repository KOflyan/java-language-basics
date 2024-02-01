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
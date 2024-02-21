ALTER TABLE "trainer"
    ADD CONSTRAINT "uniq__trainer__username"
        UNIQUE ("username")
;

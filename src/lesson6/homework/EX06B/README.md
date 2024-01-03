EX09B - More princesses
=======================

Tuleb välja, et **EX06A**-s genereeritud nimekirja ei ole väga mugav lugeda. 
Ülesandeks on veidi täiendada juba kirjutatud koodi.


Meetodid
------------

``List<Princess> read(String filePath)`` Muuta seda funktsiooni nii, et ta tagastaks List<Princess> -- 
ehk siis igast reast peab looma Princess objekti.

``extractInformation(line)`` Sisuliselt on sama funktsionaalsus mis EX06A ülesande puhul, kuigi nüüd peab viskma erindi
`InvaliPrincessException` sõnumiga "Invalid princess!", kui printsessi nimi, staatus või asukoht on `"None"`.

``List<Princess> sortByPlace(sortedPrincesses)`` Võtab sisse järjendi, kus printsessid on sorteeritud staatuse järgi ja grupeerib need
lisaks sellele asukoha järgi. Näiteks:
    
```

// Before grouping
["Oralie", "FIGHTS FOR LIFE", "Ancient Ruins", "Likes books"],
["Agace", "FIGHTS FOR LIFE", "Misty Swamp", "Can cook"],
["Garnet", "FIGHTS FOR LIFE", "Misty Swamp", "Afraid of spiders"]

// After grouping
["Oralie", "FIGHTS FOR LIFE", "Ancient Ruins", "Likes books"],
["Aida", "FIGHTS FOR LIFE", "Ancient Ruins", "Sassy"],
["Dyanna", "FIGHTS FOR LIFE", "Ancient Ruins", "Sassy"],
<...> ,
["Agace", "FIGHTS FOR LIFE", "Misty Swamp", "Can cook"],
["Garnet", "FIGHTS FOR LIFE", "Misty Swamp", "Afraid of spiders"],
["Edithe", "FIGHTS FOR LIFE", "Misty Swamp", "Pretty"] ...
```

Grupeerida tuleb asukoha esinemise järjekorras. Näiteks, kui meil oleks selline esialgne nimekiri:

```
Oralie              FIGHTS FOR LIFE     Ancient Ruins       Likes books
Remy                FIGHTS FOR LIFE     Old Shack           Sassy
Aida                FIGHTS FOR LIFE     Ancient Ruins       Sassy
Agace               FIGHTS FOR LIFE     Misty Swamp         Can cook
Marilyn             FIGHTS FOR LIFE     Old Shack           Likes books
```


Siis pärast grupeerimist peame saama

```
Oralie              FIGHTS FOR LIFE     Ancient Ruins       Likes books
Aida                FIGHTS FOR LIFE     Ancient Ruins       Sassy
Remy                FIGHTS FOR LIFE     Old Shack           Sassy
Marilyn             FIGHTS FOR LIFE     Old Shack           Likes books
Agace               FIGHTS FOR LIFE     Misty Swamp         Can cook
```

Nagu on näha, kõige esimest gruppi iseloomustab **Ancient Ruins** asukoht, kuna see oli algses nimekirjas esimene. Teine grupp on **Old Shack**, kuna see oli algses nimekirjas järgmine ja nii edasi.
See on nüüd järjestus, mis kirjutatakse faili.

Lisaks sellele peab funktsioon viskama erindi **InvalidPrincessException** järgmistel juhtudel:

1) Kui printsessi staatuseks on **"None"** (erindi sõnumiks on **Invalid princess!**)

2) kui printsessi staatuseks on üks järgmistest: **SAVED, EATEN, SLAYED THE DRAGON HERSELF** (erindi sõnumiks on **The princess is already {status}!**)


``processInputFileAndTransform()`` Juba olemasoleva funktsiooni tuleb natuke muuta nii, et väljundiformaat oleks sarnane sisendiformaadiga. Vaadake `tests/correctOutput.txt` faili.
Faili lõpus ei ole tühja rida.


Viited ja näidised
------------------

Erind: https://javadoc.pages.taltech.ee/exception/exception.html#id1

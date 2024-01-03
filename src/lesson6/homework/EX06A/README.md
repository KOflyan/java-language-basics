EX09A - Princesses && Dragons
=============================

Sinu 12-sajandi maailmas on saabunud rasked ajad. Kogu maailma draakonid ühendasid oma jõud ja varastasid igast kuningriigist seal elanud printsesse.
Ahastuses, peakuningas palub sind päästa vähemalt osa nendest. Olles rüütel, sa nõustud.
Kuningas annab sulle paberi, millele on kirjutatud informatsioon iga printsessi kohta.
Kuna printsesse on väga palju, pead sa otsustama, mis järjekorras sa hakkad neid päästma.
Aga enne seda tuleb ka paberil olev tekst dekodeerida...

Igal printsessil on neli atribuuti:

1) Nimi

2) Staatus

3) Asukoht

4) Lisainfo

Printsessi staatused võivad olla järgmised:

```
statuses = [
    "INJURED", "BORED", "EATEN", "SAVED",
    "IN PANIC", "SLAYED THE DRAGON HERSELF",
    "FIGHTS FOR LIFE"
]
```


3) Koht = asukoht, kus printsessi hoitakse. Sõltuvalt staatusest jagunevad kolme rühma.

```
Dangerous
[
  "Dark Cave", "Dungeon", "Old Shack",
  "High Mountain", "Abandoned Prison",
  "Misty Swamp", "Ancient Ruins"
]

Safw
[
  "Castle", "Pub", "Town Hall", "Office",
  "Library"
]

Afterlife
[
  "Underworld", "Heaven"
]
```

4) Detailid = lisainformatsioon iga printsessi kohta. Miks kuningas arvas, et seda on oluline teada?

```

[
  "Pretty", "Can cook", "Likes books", "Programmer",
  "Will rule the kingdom", "Afraid of spiders",
  "Sassy", "None"
]
```

Ülesandeks on välja lugeda info iga printsessi kohta ette antud failist, järjestada printsessid staatuse järgi ja kirjutada vormindatud tulemus teise faili.

Meetodid
------------

``String decodeLine(String line)`` Dekodeerib argumendina antud rea **utf-8** formaati.

Näiteks:

```

System.out.println(
  decodeLine(
    "TWFybmkgICAgICAgICAgICAgICAgICAgICAgICAgRklHSFRTIEZPUiBMSUZFICAgICAgICAgICAgICAgT2xkIFNoYWNrICAgICAgICAgICAgICAgICAgICAgV2lsbCBydWxlIHRoZSBraW5nZG9tCg=="
    )
);
```
Tagastab:

``Marni                         FIGHTS FOR LIFE               Old Shack                     Will rule the kingdom``

**Hint: base64. Kasuta Base64.getDecoder().decode() funktsiooni.**

``List<String> extractInformation(String line)`` Loeb välja printsessi andmed reast (sõne) peale dekodeerimist. Tagastab järjendi andmetest. Elementide alguses ega lõpus ei tohi olla tühikuid.
Sisendsõnes on andmed alati samas järjekorras: nimi, staatus, asukoht ja lisainfo. Nende vahel võib olla üks või rohkem tühikuid. Tagastatavas järjendis on andmed samas järjekorras.

Näiteks: ``System.out.println(extractInformation("Marni                         FIGHTS FOR LIFE               Old Shack                     Will rule the kingdom"));`` -->
``['Marni', 'FIGHTS FOR LIFE', 'Old Shack', 'Will rule the kingdom']``

**Hint: proovi line.split("\\s\\s+").**

``List<List<String>> read(String filePath)`` Loeb failist informatsiooni ridade kaupa, dekodeerib ja loeb välja printsessi andmed igast reast ja salvestab järjendisse. Funktsioon tagastab saadud järjendi.
Faili päises olevaid ridu tagastatavasse järjendisse ei panda.
Kui faili ei leita, viskab erindi **FileNotFoundException**.

``List<List<String>> filterByStatus(List<List<String>> lines)`` Eemaldab etteantud järjendist printsessid, kelle staatuseks on üks nendest: **"EATEN", "SAVED", "SLAYED THE DRAGON HERSELF"**. Neid pole mõtet päästa. Tagastab filtreeritud järjendi.
Sisendiks on järjend juba dekodeeritud printsesside andmetega.

``List<List<String>> sortByStatus(List<List<String>> filteredLines)`` Järjestab ette antud järjendis olevad printsessid staatuse järgi nii, et see vastaks järgmise reeglile: **FIGHTS FOR LIFE > INJURED > IN PANIC > BORED**.
(**FIGHTS FOR LIFE** on eespool kui **INJURED** jne).
Sama staatusega printsessid tuleb järjestada selles järjekorras, milles nad on algses järjendis (ehk siis eespool olev printsess jääb ettepoole jne).
Tagastab sorteeritud järjendi. Sisendiks on järjend juba dekodeeritud printsesside andmetega.

``void processInputFileAndTransform(String inputFilePath)`` Loeb etteantud failist kodeeritud sõnumi (kasuta funktsiooni ``read``), dekodeerib sõnumi (``decodeLine``), loeb sellest välja printsesside andmed (``extractInformation``).
Kirjutab filtreeritud (``filterByStatus``) ja järjestatud (``sortByStatus``) printsesside andmed vormindatult faili nimega **princessesToSave.txt**.
Faili lõpus ei ole tühja rida. Funktsioon ei tagasta midagi.
Formaat peab olema järgmine:

```

  [printsessi nimi]
  [staatus]
  [asukoht]
  [lisainfo]
  [tühi rida]
```
Ehk siis iga printsessi kohta on 4 rida andmeid. Iga kahe printsessi vahel on tühi rida. Faili lõpus (peale viimase printsessi andmeid) tühja rida ei ole.

-----

Lisalugemiseks
------

Erind: https://javadoc.pages.taltech.ee/exception/exception.html#id1


Kuidas ülesannet lahendada? (mõned vihjed)
-------------------------------------------

Alloleva koodi järgi on mõistlik ülesannet samm-haaval lahendama hakata. Ehk siis funktsioonid tasub selles järjekorras lahendada.

Paar märkust:

- ``extractInformation`` funktsioon peaks suutma töötada ka nii, et etteantavas sõnes on lõpus reavahetus.
- ``processInputFileAndTransform`` funktsiooni tulemusena tekkinud failis ei tohi lõpus olla reavahetusi

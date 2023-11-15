EX03A - Calculator
==================

Kirjutada programm, mis kuvab summa või vahe avaldise nö kalkulaatori ekraanil.

Tulemus peaks olema selline:

```
    UNN-7ed
>---------<
|2 + 5 = 7|
-----------
```

Selleks tuleb realiseerida järgnevad meetodid:

-  **convertName(String name)** - Tagastab sõne, mis on lühendatud versioon kalkulaatori tootja nimest järgneva loogika järgi: [sõne esimesed kolm tähte suurte tähtedena]-[sõne pikkus][sõne viimased kaks tähte väikeste tähtedena]
   Kui sõne on lühem, kui kolm tähte, siis tuleb tagastada "ERROR".

-  **getAdditionExpression(int a, int b)** - Tagastab sõne kahe arvu liitmisel saadud avaldisest. Näiteks "2 + 3 = 5".

-  **getSubtractionExpression(int a, int b)** - Tagastab sõne kahe arvu lahutamisel saadud avaldisest. Näiteks "5 - 2 = 3".

-  **repeat(String separator, int times)** - Tagastab esialgse sõne n kordusega.

-  **getLineSeparator(int width, boolean isDecorated)** - Tagastab sõne, mis koosneb '-' sümbolitest, kus *width* määrab sõne pikkuse.
   Kasuta siin `repeat(string, int)` meetodi.
   Kui võtmesõna (keyword argument) *isDecorated* on True, siis sõne algab sümboliga "<" ja lõppeb sümboliga ">",
   kui see on False, siis koosneb kogu sõne ainult '-' sümbolitest. Võtmesõnaga parameeter *isDecorated* omab vaikeväärtust False.
   Kui *isDecorated* on `true` ja *width* on kahest väiksem, tagastada tühi sõne.

Ette on sulle antud meetod **display**, mis võtab kokku eelnevad meetodid ja
tagastab sõne, mis kujutab kalkulaatori ekraanil olevat avaldist koos lühendatud nimega ekraani kohal.


**Näited:**

```
System.out.println(convertName("Burroughs"));  // -> "BUR-9hs"
System.out.println(convertName("abc"));  // -> "ABC-3bc"
System.out.println(convertName(""));  // -> "ERROR"

System.out.println(getAdditionExpression(2, 3));  // -> "2 + 3 = 5"

System.out.println(repeat("a", 3));  // -> "aaa"

System.out.println(getLineSeparator(4));  // -> "----"
System.out.println(getLineSeparator(4, decorated=True));  // -> ">--<"

System.out.println(display(2, 5));
//     UNN-7ed
// >---------<
// |2 + 5 = 7|
// -----------

System.out.println(display(15, 5, "Burroughs", "subtraction", 20));
//              BUR-9hs
// >------------------<
// |   15 - 5 = 10    |
// --------------------
```


Lisalugemiseks:
---------------

* Sõne: https://javadoc.pages.taltech.ee/string/index.html
* Meetodi mõiste ja kasutamine: https://javadoc.pages.taltech.ee/method/index.html

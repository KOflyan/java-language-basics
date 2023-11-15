EX04B - Scramble
================


Leidsid internetist kuulujutu, et inimene suudab sõnasid lauses lugeda ka siis, kui sõna tähed
niimoodi laiali paisata, et vaid esimene ja viimane täht samaks jääksid. Et seda sõbrale tõestada
lood programmi, millega kiiresti tavalisi lauseid ümber konverteerida. Lood kaks funktsiooni:

Meetodid:
-----------------

``scrambleSentence(sentence)`` Saab kaasa lause ning tagastab muudetud sõnadega lause.

``scrambleWord(word)`` Saab kaasa sõne ning tagastab sõne, kus tähtede asukohad on vahetatud.
Uues sõnes peavad muutumatuks jääma kaasaantud sõne esimene ja viimane täht ning ülakoma (sõne sees võib maksimaalselt üks olla).
Tagastatav sõne ei tohi olla samane esialgse sõnega (v.a erijuhud) ning kui sõne viimaseks
täheks on sümbol (.,;?!"), tuleb muutumatuks jätta lõpust teine täht. Juhul kui tähtede asukohta muuta ei saa, tuleb tagastada
algne sõne. Võib eeldada, et kaasaantud sõne esimene täht on alati korrektne ning
sõne lõpus on maksimaalselt 1 sümbol. Vahetamisega peavad tähed minema tähestikulisse järjekorda ja suuri tähti tuleb vahetamisel
vaadata kui väikseid.


Näidised:
---------

```
System.out.println(scrambleSentence("Hey, how's it going?")); // -> Hey, how's it ginog?
System.out.println(scrambleSentence("The phenomenal power of the human mind.")); // -> The paeehmnnol peowr of the hamun mind.
System.out.println(scrambleSentence("Mo'uSE!")); // -> "Mo'SuE!"
System.out.println(scrambleSentence("CoOol")); // -> "CoOol"

```

--------

Abistavad materjalid:

1. String - https://javadoc.pages.taltech.ee/string/index.html
2. Järjend - https://javadoc.pages.taltech.ee/data_structures/array.html
3. List, sorteerimine - https://javadoc.pages.taltech.ee/data_structures/list.html
3. Tsükkel (järjendi läbikäimiseks) - https://javadoc.pages.taltech.ee/control_flow/loop.html

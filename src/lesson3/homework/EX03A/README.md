EX03A - Sorting
===============

Ülesandeks on realiseerida meetodid `sortList()` ning `getMinLenWord()`, mis
sorteerivad sõnedest koosneva järjendi selle elementide pikkuse alusel.

`getMinLenWord(List<String> listOfWords)` saab muutujana kaasa sõnede järjendi ning
tagastab selles esineva vähima pikkusega sõne. Juhul, kui kaks elementi on sama
pikkusega, tuleb tagastada järjendis eespool asetsev sõne.

Tühja järjendi korral tagastab meetod `null`.

```
System.out.println(getMinLenWord(new ArrayList(Arrays.asList("Hi", "there")))); // => "Hi"
System.out.println(getMinLenWord(new ArrayList(Arrays.asList("Hello", "there")))); // => "Hello"
System.out.println(getMinLenWord(new ArrayList(Arrays.asList("Mary", "had", "a", "little", "lamb")))); // => "a"
System.out.println(getMinLenWord(new ArrayList(Arrays.asList("Mary", "had", "a", "little", "lamb")))); // => "a"
```


``sortList(List<String> listOfWords)`` saab samuti kaasa sõnedest koosneva järjendi ning
tagastab sorteeritud järjendi. Elemendid sorteeritakse nende pikkuse alusel
kasvavalt ning sorteerimiseks kasutatakse `getMinLenWord`() funktsiooni.

```
System.out.println(sortList(new ArrayList<>(Arrays.asList("aaa", "bb", "c")))); // => ["c", "bb", "aaa"]
System.out.println(sortList(new ArrayList<>(Arrays.asList("Hello", "there")))); // => ["Hello", "there"]
System.out.println(sortList(new ArrayList<>(Arrays.asList("Mary", "had", "a", "little", "lamb")))); // => ["a", "had", "Mary", "lamb", "little"]

```

Et funktsioon `getMinLenWord` iga kord sama väärtust ei väljastaks, eeldab lahenduskäik, et
funktsiooni kutsutakse iga kord välja erineva pikkuse järjendiga. Seega peab
algse järjendi pikkus peale igat väljakutset muutuma. Seoses sellega arvestage,
et järjendi muutmine samal ajal, kui te itereerite üle selle järjendi, võib tekitada ootamatuid
probleeme. Seetõttu on soovitatav itereerida üle järjendi koopia.

Tühi järjend sorteeritult on tühi järjend.


Lisalugemiseks:
---------------

* Sõne: https://javadoc.pages.taltech.ee/string/index.html
* Järjend: https://javadoc.pages.taltech.ee/data_structures/list.html
* Tsüklid: https://javadoc.pages.taltech.ee/control_flow/loop.html

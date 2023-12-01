EX10B - Dictionary
==================

Oletame, et teie olete noor IT eriala tudeng, kellel on palju teadmisi ja kes tahab midagi uut IT valdkonnas leiutada. Teil tekkis **GENIAALNE** idee välja anda esimene digitaalne seletussõnaraamat, mis kujutab endast veebiäppi. Nüüd on aeg kiiresti koodi kirjutada ja patendibüroosse joosta.

Ülesanne
--------

Ülesandeks on selle äpi peamise osa realiseerimine.

Tuleb realiseerida klass **Dictionary** ja selle klassi meetodid.

``public Dictionary(String initialData)`` – klassi konstruktor, mille argumendiks on algandmed. Klassi konstruktor loob klassi objekti. *Algandmetest räägime hiljem.*

``public List<String> getDefinitions(String word)`` – sisendiks on sõna (word) ja tagastatavaks on **list** etteantud sõna kõigi definitsioonidega (neid saab olla mitu). Listis võivad definitsioonid olla suvalises järjekorras. Kui sellist sõna sõnastikus ei ole, tagastada **tühi list**.

``public boolean isNoun(String word)`` – sisendiks on sõna ja tagastatavaks väärtuseks **true**, kui see sõna on nimisõnade hulgas, muul juhul  **false**.

``public boolean isVerb(String word)`` – sisendiks on sõna ja tagastatavaks väärtuseks **true**, kui see sõna on tegusõnade hulgas, muul juhul  **false**.

``public boolean isAdjective(String word)`` – sisendiks on sõna ja tagastatavaks väärtuseks **true**, kui see sõna on omadussõnade hulgas, muul juhul  **false**.

``public List<String> getAllNouns()`` – tagastab **listi** kõigi nimisõnadega, mis on sõnastikku kantud. Kui sõnu ei ole, tagastab tühja listi.

``public List<String> getAllAdjectives()`` – tagastab **listi** kõigi tegusõnadega, mis on sõnastikku kantud. Kui sõnu ei ole, tagastab tühja listi.

``public List<String> getAllVerbs()`` – tagastab **listi** kõigi omadussõnadega, mis on sõnastikku kantud. Kui sõnu ei ole, tagastab tühja listi.

``public List<String> search(String subWord, int minLength, int maxLength)`` – tagastab **listi** kõigi sõnastikus olevate sõnade, milles sisaldub **subword**. Listis võivad sõnad olla suvalises järjekorras. **minLen** ja **maxLen** määravad otsitava sõna minimaalse ja maksimaalse pikkuse. Kui nende väärtused pole määratud, siis otsitavate sõnade pikkus pole piiratud. Kui selliseid sõnu ei ole, tagastada tühi list.


Kõik funktsioonid, mille sisendiks sõna *(word, subword)* ei ole tõstutundlikud (**case-insensitive**). St nii suur- kui väiketäht loetakse samaks: ``run``, ``Run``, ``RUN`` jne on kõik võrdsed).

Algandmed
---------

Algandmed kujutavad endast mitmest reast koosnevat sõne, kus read on teineteisest eraldatud *\\n* märgiga.

Rea õige kuju:

```
(x)WORD - WORD DEFINITION
```


**x** asemel on sõnaliikme nimetuse esimene täht.

```
n - noun (nimisõna)
v - verb (tegusõna)
a - adjective (omadussõna)
```

Kui rida on vormistatud valesti, siis see tuleb vahele jätta.

**Nõue:** sõnastikus peavad olema sõnad väikeste tähtedega. Ehk kui sõnas **WORD** on suured tähed, tuleb neid väikesteks muuta!

Reeglid sõnale ja definitsioonile
---------------------------------

Sõna (**WORD**):
1. Vähemalt 1 täht sees!
2. Maksimaalne pikkus: ei ole piiratud.
3. Keelatud sümbolid: ``.`` ning tühik.
4. Sõnas võib olla **ainult** üks kriips ("-").
5. Kriips ei tohi olla esimene ega viimane märk.

Definitsioon (**WORD DEFINITION**):
1. Vähemalt 1 täht sees!
2. Maksimaalne pikkus: ei ole piiratud.
3. Võib sisaldada tühikuid, teisi märke ning numbreid.

Kui sõna on ebakorrektne, ei seda tohi sõnastikku kanda!

Kui definitsioon on ebakorrektne ja sõnal pole teisi korrektseid definitsioone, ei tohi sedagi sõnastikku kanda!

Materjalid
----------

* Sõned ja operatsioonid sõnega: https://javadoc.pages.taltech.ee/string/index.html

* Klassid ja objektid: https://javadoc.pages.taltech.ee/oop/oop-classes-and-objects.html

* Järjend (*list*): https://javadoc.pages.taltech.ee/data_structures/list.html#arraylist

* Kujutis (*map*): https://javadoc.pages.taltech.ee/data_structures/map.html

Vihjed
------

1. Regulaaravaldiste *(regex)* kasutamine teeb ülesannet raskemaks!

2. Loe rohkem *split* funktsioonist.

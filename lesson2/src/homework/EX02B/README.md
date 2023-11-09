EX02B - Table cell indexing
===========================


Olgu tabeli lahtrid nummerdatud järjest 0, 1, 2 selliselt, et alustame vasakult ülevalt ja liigume paremale, kuni terve rida on täidetud (näiteks 0, 1, 2).
Seejärel jätkame teiselt realt vasakult 3, 4, 5 jne. Saame näiteks järgmise tabeli (tabeli read ja veerud on nummerdatud 0, 1, 2):


```
    0   1   2
  +---+---+---+
0 | 0 | 1 | 2 |
  +---+---+---+
1 | 3 | 4 | 5 |
  +---+---+---+
2 | 6 | 7 | 8 |
  +---+---+---+
```


Selleks, et viidata alumisele keskmisele lahtrile, võime kasutada rea ja veeru koordinaate: (2, 1). Samuti võime kasutada lahtri järjekorranumbrit ehk 7.

Ülesandes on teil konkreetse laiusega tabel, tabeli kõrgus pole piiratud. Te peate kirjutama järgmised funktsioonid:

`get_cell_index(row, col, row_len)` - võtab ette rea ja veeru indeksi ning tabeli laiuse (mitu veergu tabelis on). Tagastab vastava asukoha järjekorranumbri. Kui veerg ei mahu tabelisse, tagastada -1.

`get_row_and_col(cell_index, row_len)` - võtab ette lahtri järjekorranumbri ja tabeli laiuse, tagastab enniku vastava rea ja veeru indeksiga.

`get_row_len``(row, col, cell_index)` - võtab ette rea ja veeru indeksi ning lahtri järjekorranumbri, tagastab võimaliku tabeli laiuse. Osade väärtuste puhul ei ole selline olukord võimalik või pole võimalik üheselt öelda, mis on tabeli laius, siis tagastada -1.


Vihjeid
---------

Näiteks kui tabeli laius on 4, siis oleks tabeli ülemine osa selline:

```
    0   1   2   3
  +---+---+---+---+
0 | 0 | 1 | 2 | 3 |
  +---+---+---+---+
1 | 4 | 5 | 6 | 7 |
  +---+---+---+---+
2 | 8 | 9 | 10| 11|
  +---+---+---+---+
   ... ... ... ...

```

Kui tabeli laius on 5, siis oleks tabeli ülemine osa selline:

```
    0   1   2   3   4
  +---+---+---+---+---+
0 | 0 | 1 | 2 | 3 | 4 |
  +---+---+---+---+---+
1 | 5 | 6 | 7 | 8 | 9 |
  +---+---+---+---+---+
2 | 10| 11| 12| 13| 14|
  +---+---+---+---+---+
   ... ... ... ... ...
```

Seega mõned näited viimase tabeli pealt:

```
System.out.println(getCellIndex(0, 0, 5)); // --> 0
System.out.println(getCellIndex(1, 3, 5)); // --> 8
System.out.println(getCellIndex(1, 1, 5)); // --> 6
System.out.println(getCellIndex(3, 1, 5)); // --> 16
System.out.println(getCellIndex(4, 2, 5)); // --> 22

System.out.println(getRowIndex(5, 5)); // --> 1
System.out.println(getColIndex(5, 5)); // --> 0
System.out.println(getRowIndex(11, 5)); // --> 2
System.out.println(getColIndex(11, 5)); // --> 1
```


``getRowLength`` jaoks valemi väljamõtlemiseks võib kasutada eelnevalt leitud valemit/valemeid. Kogu ülesanne on selline, et teil on
kolm erinevat muutujat: koordinaadid, lahtri indeks ja tabeli laius. Iga funktsiooni jaoks on üks neist tundmatu:
``getCellIndex`` puhul on tundmatu lahtri indeks, ``GetRowIndex/getColIndex`` puhul on tundmatu tabeli koordinaadid, ``getRowLength`` puhul on tundmatu tabeli laius.

``getRowLength`` puhul tuleb arvestada, et igasugune koordinaadi ja lahtri indeksi kombinatsioon ei sobi. Kui võtame näiteks koordinaadi 2, 1 (rida 2, veerg 1),
siis eelnevate näidete pealt (tabeli laiused 3, 4, 5) oleks võimalikud lahtri indeksid 7, 9, 11. Ehk siis sinna ei sobi 8, 10 jne.
Kui funktsiooni sisseantud koordinaadid ja lahtri indeks ei ole võimalik kombinatsioon, peab funktsioon tagastama -1.


```
System.out.println(getRowLength(4, 2, 1)); // --> -1
System.out.println(getRowLength(0, 3, 18)); // --> -1
System.out.println(getRowLength(0, 1, 20)); // --> -1
System.out.println(getRowLength(3, 2, 5)); // --> -1
System.out.println(getRowLength(1, 3, 11)); // --> 8
System.out.println(getRowLength(4, 5, 10)); // --> -1
System.out.println(getRowLength(2, 5, 12)); // --> -1
System.out.println(getRowLength(4, 3, 6)); // --> -1
System.out.println(getRowLength(5, 2, 18)); // --> -1
System.out.println(getRowLength(1, 5, 22)); // --> 17

```

Lisalugemiseks:

1. [Matemaatilised avaldised](https://javadoc.pages.taltech.ee/python_and_java_comparison/math.html#matemaatika)
2. [Modulo operator](https://www.geeksforgeeks.org/modulo-or-remainder-operator-in-java/)

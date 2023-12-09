EX12B - 1984
============

Kirjutada programm, mis aitab Suurel Vennal teha puhastusi Okeaania kodanike hulgas. Programm peab sisaldama järgmisi klasse ja meetodeid:



class Citizen
-------------

*Konstruktorid.*

``public Citizen(String name, Party party, CitizenStatus status)``
``public Citizen(String name, Party party)``

Igal kodanikul peab olema nimi, partei ja staatus. Konstruktor võtab seega sisse kolm argumenti: **name**, **party**, **status**. Kui staatus on null, tuleb kasutada vaikeväärtuseks **"citizen"**. Juhul, kui staatus ikka määratakse, peab see olema üks ette antud staatustest (vaata `CitizenStatus`).
Kui määratud staatus ei ole nende hulgas, määratakse staatuseks **"citizen"**. Kui staatuseks on **"prole"**, siis kodaniku parteiks määratakse **null**. Kui staatuseks on **"nonperson"**, määratakse kodaniku nimeks ja parteiks **null**. Kui pärast kontrolli kodaniku partei ei ole **null**, lisatakse kodanik partei liikmete hulka.


**Hint: check if the given status is valid at first. If it is, assign it to the instance variable and perform the rest of status-related actions in the same if-block. If the status is not valid, assign the status variable to "citizen". Only after that you can add the citizen to the party members' list (you should check if the party is not null after your actions and if not, add).**

**Meetodid:**

``setParty(Party party)`` Kui ette antud partei on **Party** klassi instants või **null**, siis esialgu võtab kodaniku maha tema eelnevast parteist, kui ta oli juba teise partei liige; pärast lisab kodaniku uude parteisse (kui see ei ole **null**). Salvestab uue partei vastava instantsimuutuja sisse.

**Hint: First you should check if the new party already has this citizen as a member - if so, just update current citizen's party and don't do anything else. Otherwise, you should add the citizen to the party list of members. Then, if the citizen already has a party and is registered along with other members (this.party.getPartyMembers().contains(this)), they should be removed from this list. So:**

```
    if new party is not null and citizen is already a member of the new party) {
        set current party to this party
        end
    }
    
    if (current party is not null) {
        remove the citizen from current party members
    }
    
    if (new party is not null) {
        add the citizen to the new party members
    }
```

``getParty()`` Tagastab kodaniku partei.

``set_status(CitizenStatus status)`` Määrab kodanikule uue staatuse, kui staatus on etteantud staatuste hulgas. Kui uus staatus on **"nonperson"** ja kodaniku partei ei ole **null**, siis kodanik kohe aurustatakse. Kui staatuseks on **"prole"**, kodaniku parteiks määratakse **null**.

**Hint: call vaporize() with this.party.**

**Hint: check if the status is valid at first. Then assign new status to the citizen's status instance variable and only then perform the rest of actions.**

``getStatus()`` Tagastab kodaniku staatuse.

``setName(String name)`` Määrab kodanikule uue nime.

``getName()`` Tagastab kodaniku nime.

``toString()`` Tagastab sõne **"BIG BROTHER IS WATCHING YOU, {citizen's name}"**

abstract class Party
-----------

*Konstruktor.* Ei võta sisse ühtegi argumenti. Konstruktori sees deklareeritakse järjend, kus hoitakse partei liikmeid.

**Meetodid:**

``addPartyMember(Citizen citizen)`` Lisab kodaniku parteiliikmete hulka. Kodanik peab olema **Citizen** klassi instants, tema nimi ei tohi olla **null** ja staatus ei saa olla **"nonperson"**, ning kodanik ei tohi juba olla liikmete järjendis. Juhul kui tingimused on täidetud, lisatakse kodanik teiste parteiliikmete hulka ja kodaniku parteiks määratakse antud partei. Vastasel juhul ei tee midagi.

``removePartyMember(Citizen citizen)`` Võtab kodaniku maha parteiliikmete hulgast, kui ta on seal olemas.

``vaporize(Citizen citizen)`` Eemaldab argumendina antud kodaniku parteiliikmete hulgast, määrab tema nimeks ja parteiks **null** ja määrab staatuseks **"nonperson"**.

``getPartyMembers()`` Tagastab nimekirja kõikidest partei liikmetest.

``abstract String getPrivileges()``

``static getSlogan()`` Tagastab **"WAR IS PEACE\\nFREEDOM IS SLAVERY\\nIGNORANCE IS STRENGTH"**.

class InnerParty
----------------

On **Party** klassi alamklass.

**Meetodid:**

``getPrivileges()`` Tagastab **"Everything"**

``toString()`` Tagastab **"Inner party"**

class OuterParty
----------------

On **Party** klassi alamklass.

**Meetodid:**

``toString()`` Tagastab **"Outer party"**

class BigBrother
----------------

*Konstruktor.* Võtab sisse **InnerParty** ja **OuterParty** objekti. Konstruktoris deklareeritakse järjend, kus paiknevad kõik kodanikud, kellel on partei - ehk kõik **InnerParty** ja **OuterParty** liikmed. Samamoodi deklareeritakse muutuja, kus hoitakse aurustatud inimeste arvu kogu aja jooksul.

``getAllCitizens()`` Tagastab järjendi kõikide kodanikega.

``massiveVaporize(CitizenStatus status)`` Aurustab kõik kodanikud, kes on antud staatusega: kustutab kodaniku kodanike hulgast, ja teeb sama asju mis vaporize() meetod. Suurendab aurustatud inimeste arvu ühe võrra iga aurustamise korral. Tagastab aurustatud inimeste arvu.

**Hint: first remove the citizen from list of all citizens, then call vaporize()**.

``getNumberOfVaporized()``  Tagastab kogu aja jooksul aurustatud inimeste arvu.


Lisalugemiseks
--------------

* OOP - https://javadoc.pages.taltech.ee/oop/oop-lists.html
* List - https://javadoc.pages.taltech.ee/data_structures/list.html#arraylist

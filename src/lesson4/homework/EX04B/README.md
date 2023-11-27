EX12A - Wands && Wizards
------------------------


public class Wand
-----------------

**Konstruktor:**

- ``public Wand(String woodType, String core):`` Iga võlukepp on valmistatud spetsiifilisest puust ja on unikaalse südamikuga - näiteks fööniksi sulega. Klassi konstruktor võtab sisse kaks parameetrit - *wood_type* ja *core* ning salvestab need samanimelistesse instantsi muutujatesse.

**Meetodid:**

- ``public void setWoodType(String woodType)`` Paneb instantsi muutujale uue väärtuse. Ei tagasta midagi.

- ``public String getWoodType()`` Tagastab `woodType` väärtuse.

- ``public void setCore(String core)`` Paneb instantsi muutujale uue väärtuse. Ei tagasta midagi.

- ``public void getCore()`` Tagastab `core` väärtuse.

- ``public static void checkWand(Wand wand)`` Staatiline meetod. Kontrollib, kas võlukepp, mis on antud funktsiooni parameetrina, on korrektne. Korrektne võlukepp peab olema klassi Wand instants ja sellel peavad olema kõik atribuudid täidetud - ehk puutüüp ja südamik ei ole *null*. Kui võlukepp on korrektne, siis meetod ei tee midagi. Vigase võlukepi puhul tuleb visata erind ``InvalidWandException``.

- ``public String toString()`` Tagastab sõne kujul **"{wood_type}, {core}"**. Vt näited allpool.

- ``public boolean equals(Object o)`` Kui `o` on `Wand` klassi instants ning temal on samad `core` ja `woodType`, tagastab `true`.

- ``public int hashCode()`` Tagastab `Object.hash(...)` tulemuse, mis võtab argumentidena `core` ja `woodType`.


public class Wizard
------------

**Konstruktor:**

- ``public Wizard(String name, Wand wand):`` Igal võluril peab olema nimi, ja võib (aga ei pea) olema oma võlukepp. Ehk konstruktor võtab sisse kaks parameetri, *name* ja *wand*, millest viimane on valikuline parameeter ja tema vaikeväärtus on *null*. Sarnaselt eelmise konstruktoriga tuleb salvestada antud parameetrid samanimelistesse instantsi muutujatesse. Kuid tuleb arvestada sellega, et kui parameeter *wand* ei ole tühi, tuleb selle korrektust kontrollida. Kui parameeter ei ole korrektne (nt *wood`type* või *core* on tühi) tuleb visata ``InvalidWandException`` sõnumiga **"The wand like that does not exist!"** Vihje: kasuta ``check_wand(wand)`` meetodit!

**Meetodid:**

- ``public void setWand(Wand wand)`` Kontrollib, kas antud võlukepp on korrektne ja kui on, salvestab vastavasse instantsimuutujasse. Vastasel juhul viskab ``InvalidWandException`` sõnumiga **"The wand like that does not exist!"**

- ``public void getWand()`` tagastab `wand` väärtuse.

- ``public String toString()`` Tagastab võluri nime.

- ``public boolean equals(Object obj)`` Kui `obj` on `Wizard` klassi instants ning temal on samad `name` ja `wand`, tagastab `true`.

- ``public int hashCode()`` Tagastab `Object.hash(...)` tulemuse, mis võtab argumentidena `name` ja `wand`.

public class School
------------

**Konstruktor:**

- ``public School(String name):`` Igal koolil peab olema nimi. Konstruktor võtab siis sisse parameetri *name* ja salvestab vastavasse samanimelisse instantsi muutujasse. Nimi ei tohi olla suvaline, vaid peab olema üks ette antud nimedest:

```

private static final Set<String> SCHOOL_NAMES = new HashSet<>(Arrays.asList(
    "Hogwarts School of Witchcraft and Wizardry",
    "Durmstrang Institute",
    "Ilvermorny School of Witchcraft and Wizardry", 
    "Castelobruxo",
    "Beauxbatons Academy of Magic"
));
```


Muutuja *schools* peab olema klassi muutuja, mitte instantsi muutuja. Muutuja nimi ja sisu peab sama olema.

Juhul, kui proovitakse luua objekti nimega, mida antud järjendis pole, tuleb visata erind ``InvalidSchoolException`` sõnumiga **"There is no such school!"**

**Meetodid:**

- ``public String addWizard(Wizard wizard)`` Lisab kooli uue võluri. Selleks, et kooli sisse saada, peab võlur olema *Wizard* klassi instants, temal peab olema nimi ja korrektne võlukepp (ei ole *null*). Kui mõni antud tingimustest ei ole tõene, visatakse erind ``NotAWizardException`` sõnumiga **"It's a filthy muggle!"**
  Juhul, kui võlur juba õpib antud koolis, tagastab **"{wizard name} is already studying in this school!"** Õnnestunud lisamise korral tagastab **"{wizard name} started studying in {school name}."**.

- ``public void removeWizard(self, wizard)`` Kui võlur mingil põhjusel otsustab õpingud katkestada, tuleb ta koolis õppivate võlurite nimekirjast maha võtta. Ei tagasta midagi.

- ``public Set<Wizard> getWizards()`` Tagastab järjendi, kus on kõik antud koolis õppivad võlurid.

- ``public Wizard getWizardByWand(self, wand)``  Otsib koolis õppivate võlurite hulgast võluri, kellel on antud võlukepp. Võlukeppi nagu alati peab kontrollima, ükski parameetritest ei saa tühi olla. Vigase võlukepi korral tuleb visata erind ``InvalidWandException`` sõnumiga **"The wand like that does not exist!"** Juhul, kui selline võlur on leitud, tagastatakse selle võluri objekt. Vastasel juhul tagastatakse *null*.

- ``public String toString()`` Tagastab kooli nime.


InvalidSchoolException, InvalidWandException, NotAWizardException
-------------------

On ette antud.


Klassid: https://javadoc.pages.taltech.ee/oop/oop-classes-and-objects.html

Erindid: https://javadoc.pages.taltech.ee/exception/exception.html

Vihjeid
--------

Sellise ülesande puhul oleks mõistlik alustada selleks, et proovime aru saada suurest pildist. Suur pilt võiks sisaldada klasse
ja nendevahelisi seoseid. Ülesandes on kolm klassi: võlukepp (``Wand``), võlur (``Wizard``) ja kool (``School``).
Paneme kirja, millised tingimused võiks nende vahel täidetud olla (see pole lõplik nimekiri):

- võluril võib olla võlukepp. Täpsemalt, võluril võib olla 0 või 1 võlukeppi
- koolis võib olla mitu võlurit. Täpsemalt, koolis võib olla 0 või rohkem võlurit.

Teeme "diagrammi":

```

    +------+ 0..1     +--------+ *     +--------+
    | Wand |----------| Wizard |-------| School |
    +------+          +--------+       +--------+
```

Kood oleks esialgu selline:

```
public class Wand {}

public class Wizard {}

class School {}
```

Edasi tasub mõelda, millisel kujul tasub seoseid hoida. Kui võluril võib olla kuni üks võlukepp, siis võib
võluri objektil olla üks (instantsi) muutuja, mis viitab võlukepile. Kui võluril võlukeppi ei ole, on muutuja väärtus ``null``.
Koolis võib käia mitu võlurit. Selleks, et igal koolil oleks kõikide selle kooli võlurite nimekiri teada, hoiame andmeid järjendis.

Siin tasub tähele panna, et nii võluri võlukepp kui ka koolis käiv võlur, need on viited konkreetsele objektile. Kui Sigatüüka koolis
käivad võlurid Harry ja Hermione, siis viimased on kaks ``Wizard`` tüüpi objekti, kool ise on aga ``School`` tüüpi objekt. Kõiki kooli
õpilasi hoitaks järjendis. Seega, järjendis ongi viit Harry objektile ja Hermione objektile.


Alustada võiks ainult nende siduvatest muutujatest:

```

public class Wand { 
    public Wand() {}
}

public class Wizard:
    private Wand wand;

    public Wizard() {
        this.wand = null;
    }


public class School:
    private Set<String> wizards;

    public School() {
        this.wizards = new HashSet<>(); 
}
```

Antud koodis pole teadlikult õigeid konstruktori päiseid kasutatud. Proovime siin natuke ka OOP teemasid korrata.

Loome objektid:

```
Wand wand = new Wand();
Wizard harry = new Wizard();
School school = new School();
```

Oleme loonud kolm objekti: ühe võlukepi (``wand``), ühe võluri (``harry`` - ühe suhteliselt tuntud võluri järgi) ja ühe kooli (``school``).
Hetkel nende objektide vahel seoseid ei ole. ``harry`` objektil ei ole ühtegi võlukeppi (täpsemalt konstruktoris on tema võlukepiks määratud ``null``).
Koolis ei ole ühtegi võlurit (konstruktoris loodud järjend on tühi).

Täiendame oma programmi võluri klassi vastavalt nõutule. Kõigepealt täiendame konstruktorit - see võtab sisse kaks väärtust: nimi ja võlukepp. Kusjuures viimane
parameeter on valikuline. Kui me siin selle klassiga juba tegeleme, loome veel kaks meetodit: ``setWand`` ja ``getWand``. Esialgu loome neile lihtsustatud sisu.

```java
public class Wizard {

  private String name;
  private Wand wand;
  
  
  public Wizard(String name) {
      this.name = name;
      this.wand = null;
  }

  public Wizard(String name, Wand wand) {
      this.name = name;
      this.wand = wand;
  }

  /**
   * 
   * @return current wand
   */
  public Wand getWand() {
    return this.wand;
  }

  /**
   *
   * @param wand replace current wand
   */
  public void setWand(Wand wand) {
    this.wand = wand;
  }
}
```

Olgu rõhutatud, et teie peate neid meetodeid täiendama vastavalt ülesandes nõutule. Aga baasoperatsioonideks on need meetodid valmis.
Võluri loomisel saame talle ette anda nime ja võlukepi. Lisaks saame küsida võluri võlukeppi (``get_wand`` - see tagastab võlukepi objekti)
ning saame asendada (määrata) võlukepi (``set_wand``).

Täiendame ka kooli klassi. Lisame võimaluse võlureid kooli lisada ja võlurite nimekirja küsida. Konstruktorisse lisame kooli nime parameetri.

```java

import lesson4.homework.EX04B.Wizard;

import java.util.HashSet;

public class School {

  private String name;
  private Set<Wizard> wizards;

  public School(String name) {
    this.name = name;
    this.wizards = new HashSet<>();
  }

  /**
   * Add wizard to the school
   * 
   * @param wizard - person to add
   */
  public void addWizard(Wizard wizard) {
      this.wizards.add(wizard);
  }

  /**
   * 
   * @return all wizards attending this school
   */
  public Set<Wizard> getWizards() {
      return this.wizards;
  }
}

```

Kui siin juba klasse täiendame, tegeleme ka võlukepiga. Konstruktorisse lisame kaks parameetrit ning lisame meetod ``set_wood_type`` ja ``__str__``.

```java

public class Wand {
    private String woodType;
    private String core;
    
    public Wand(String woodType, String core) {
        this.woodType = woodType;
        this.core = core;
    }
    
    public setWoodType(String woodType) {
        this.woodType = woodType;
    }
    
    @Override
    public String toString() {
        return String.format("%s, %s", this.woodType, this.core);
    }
    
    @Override
    public boolean equals(Object o) {
      if (!(obj instanceof Wand o)) {
        return false;
      }

      return this.core.equals(o.core) && this.woodType.equals(o.woodType);
    }

    @Override
    public int hashCode() {
      return Objects.hash(woodType, core);
    }
}


```

Nüüd saame natuke põhjalikuma näite kirjutada (võetud ülesande kirjelduses olev näide):

```
Wand harryWand = new Wand("Holly", "Phoenix feather");
Wand hermioneWand = new Wand("Vine", "Dragon heartstring");

Wizard harry = new Wizard("Harry Potter", harryWand);
Wizard hermione = new Wizard("Hermione Granger");

hermione.setWand(hermioneWand);

School school = new School("Hogwarts");
school.addWizard(harry);
school.addWizard(hermione);
```

Loome kaks võlukepi objekti. Esimene on Harry võlukepp, teine on Hemione'i võlukepp. Need mõlemad loome ``Wand`` klassist. Mälus tekib kaks ``Wand`` instantsi.

Seejärel loome kaks võlurit. Harry puhul anname tema võlukepi kohe konstruktorisse kaasa, Hermione puhul kasutame eraldi ``setWand`` meetodit. Tulemus on sama:
võlurile on lisatud võlukepp. Joonisel on näha, et Harry võlukepi muutuja ``wand`` (täpsemalt siis ``this.wand``) viitab ``Wand`` instantsile, mis eelnevalt sai loodud.
Sama kehtib ka Hermione'i puhul. Selline mälupilt tähendab seda, et kui näiteks muuta ``harryWand`` muutuja kaudu objekti, siis muudetakse mälus seda piirkonda, kuhu
see muutuja viitab (noolega tähistatud joonisel). Samasse kohta viitab ka objekti ``harry`` võlulepi muutuja. Kui mälus midagi muudetakse, muutub see mõlema muutuja jaoks.
(Täpsemalt muutuja on lihtsalt viide mällu, muutub mälu sisu.)

Lõpuks loome kooli objekti ja lisame sinna mõlemad võlurid. Nagu joonisel näha, siis järjendis on kaks elementi, esimene viitab Harry objektile, teine Hermione'i objektile.
Jällegi, järjendis on viited mällu. Kui muudame Harry objekti, siis see muutub nii muutuja ``harry`` kui ka järjendis esimese elemendi jaoks.

**Tähelepanu!** Klassi tasandil kirjeldatud muutujad on n-ö staatilised muutujad. See tähendab seda, et nad pole seotud mitte objektida,
vaid klassiga. Instantsi muutuja on igal objektil erinev (kuigi jah, seal võib sama sisu olla, nt võluri nimi). Staatiline muutuja on aga
kogu klassi peale ühine (kõikidel võlurite puhul on seal sama sisu).

Siinkohal võiks teil olla piisav ülevaade, kuidas edasi toimetada. Võtke iga meetod eraldi ette ja täitke juhiseid. Kui on küsimusi, andke julgekt märku.





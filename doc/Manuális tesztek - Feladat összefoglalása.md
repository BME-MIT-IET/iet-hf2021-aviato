# Manuális tesztek

A feladat során a játékon kézzel végigirányítható teszteseteket terveztem, és végrehajtásukat dokumentáltam. A tesztesetek tervében megtalálható a teszteset rövid leírása, tervének részletes leírása, a teszteset elvárt eredménye és a tesztesetben kapott eredmény. A tesztesetek terve olyan részletességgel bír, hogy az egymás után megnyomandó felületi elemek szekvenciáját is tartalmazza.

Összesen 22 darab tesztesetet dolgoztam ki, melyek kiválasztásánál igyekeztem a leggyakoribban előforduló lehetőségeket preferálni. Ezek a következők:
1.	A játékos egy szomszédos stabil jégtábla lép
2.	A játékos egy nem szomszédos stabil jégtábla lépne
3.	A játékos mozog 0 lépésszámmal
4.	A játékos kutatóval felméri egy mező teherbírását
5.	A játékos kutatóval megpróbálja felmérni egy mező teherbírását 0 lépésszámmal
6.	A játékos elfogyaszt egy élelmet
7.	A játékos megpróbál elfogyasztani egy élelmet 0 lépésszámmal
8.	A játékos takarít egy mezőn
9.	A játékos felvesz egy mezőben található eszközt
10.	A játékos lyukba lép, és nem mentik meg
11.	A játékosok instabil jégtáblára lépnek
12.	A medve az egyik játékos mezejére lép
13.	A játékos a medve mezejére lép
14.	A búvárruhával rendelkező játékos nem fagy meg
15.	A búvárruhával rendelkező játékos ki tud úszni egy szomszédos mezőre
16.	A vízbe esett játékost ki lehet menteni kötéllel
17.	A kötél használata nem kerül lépésszámba, ha nincs kit kimenteni
18.	A körök végén a játékosok testhője eggyel csökken
19.	Az eszkimó iglut épít
20.	Az eszkimó egy mezőre több iglut is tud építeni
21.	Alkatrészeket összegyűjtik és megnyerik a játékot

## Tanulság
A manuális tesztek végrehajtása nagyon hatékony és költségkímélő módszer, mert egy egyszerű szövegszerkesztő program és egy tesztelő fél elegendő hozzá.

## Összegzés
A felhasználói felületen történő megjelenítésben a mezők összeköttetése félrevezető lehet, a bekeretezett ténylegesen szomszédos mezők kiemelése nem elég feltűnő.

### Megjegyzés
A Szkeleton mappában található a tesztek részletes leírása, kimenetele, a **Manuális tesztek.docx** fájlban.
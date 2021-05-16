
# BDD tesztek
A tesztek alapja az volt, hogy készítettünk az alkalmazásnak megfelelő formátumú pályát, amelyen bizonyos viselkedéseket értünk el. A pályán a játéknak megfelelő objektumokat helyeztünk el és ezen objektumok lépéseinek, viselkedéseinek mikéntjét vizsgáltuk, sokszor kitérve a határhelyzetben való viselkedésekre.
A teszteket a Cucumber keretrendszer segítségével valósítottuk meg.

Az alábbi tesztesetek készültek el:
* Az eszkimó tud lépni
* Az eszkimó többet tud lépni
* Az eszkimó nem tud lépni, mert elfogyott a lépésszáma
* Az eszkimó csak olyan mezőre tud lépni, amelyik szomszédos az aktuális mezővel
* Az eszkimó iglut épít
* Az eszkimó havat lapátol
* Az eszkimó nem tud havat lapátolni, mert elfogyott a lépésszáma
* Az eszkimó felvesz tárgyat
* Az eszkimó nem tud tárgyat felvenni, mert a mező hóval van borítva
* Az eszkimó étel használatával a kező életszáma fölé növeli az életét
* Az étel növeli az életszámot
* Az eszkimó nem tud enni, mert elfogyott a lépésszáma
* Az eszkimó sátrat épít
* Az ezkimó beleesik a vízbe
* Az instabil jégtábla befordul a vízbe, ha többen vannak rajta, mint a teherbírása
* A medve tud mozogni
* A medve megtámadja az eszkimót
* A medve megtámadja az eszkimót aki igluban van
* A medve megtámadja az eszkimót aki sátorban van
* Hóvihar esetén a jégtáblán nő a hómennyiség

## Összegzés
A tesztek készítése során megismerkedtünk a Cucumber 
keretrendszerrel, amelyik segítségével szöveges formában tudjuk 
megadni az egyes lépéseket, így a tesztelés mellett hasznos 
környezetet biztosít azok számára, akik nem ismernek egy adott 
programozási nyelvet. A tesztelés rávilágított arra, hogy a 
tesztelés mennyire fontos egy program elkészítése közben és 
kiadás előtt, mert számos hibát, illetve nem várt viselkedést 
tártunk fel. Ezeket a nem várt viselkedéseket természetesen 
kijavítottuk, így állíthatjuk, hogy a házi feladat elvégzése után 
a kód kevesebb hibát tartalmaz. A tesztelés alatt megtanultuk a 
határértékek tesztelésének fontosságát, mivel azokban az 
esetetekben sokkal több hiba fordult elő, mint az értékek 
"normál" tartományában.

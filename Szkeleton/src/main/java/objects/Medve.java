package objects;

import java.util.ArrayList;
import java.util.Random;
import view.GrafNezet;


/**
 * A Medve egy fajta Szereplo (belőle származik le), amely magától lép és ha találkozik másik Szereplo-vel, akkor megtámadja.
 * @author Aviato
 */
public class Medve extends Szereplo {
	/**
	 * Azt mutatja meg, hogy magától lép vagy külső beavatkozás hatására.
	 */
	private boolean autoLepes;
	
	/**
	 * A Medve konstruktora, amely meghívja az ősének a konstruktorát id paraméterrel és a testho-jét 1-re állítja,
	 * valamint beállítja a Ruha-ját Buvarruha-ra (ezzel biztosítva, hogy ne tudjon vízbefagyni és ki is tudjon onnan mászni.
	 * @param b Annak az értéke, hogy magától lép vagy sem
	 * @param id Az adott Medve játékbeli neve
	 */
	public Medve(boolean b,String id) {
		super(id);
		testho = 0;
		autoLepes=b;
		lepesszam = 1;
		this.ruha=new Buvarruha();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -8455595600003604288L;
 

    /**
     * Átlépés egy másik mezőre.
     * @param cel Az új Mezo, ami biztos, hogy szomszédos az előzővel, mert az Autolepes függvény biztosan olyat választ.
     */
    @Override
    public void Atlep(Mezo cel) 
    {
    	 if (!Lephet())
             return;
        Mezo regi= aktmezo;
        aktmezo=cel;
        boolean siker = cel!=null && cel.Befogad(this, regi);
        if (siker) {
            regi.Kiad(this);
            
        }else
        	aktmezo=regi;
    }
    @Override
    public void setLepesszam(int a) {
        
        lepesszam = 1;
      
    }

 

    /**
     * Kiiratáshoz használt függvény, amely az osztály nevét adja vissza egy Stringben.
     * @return Medve Stringgel tér vissza
     */
    @Override
    public String Name() 
    {
        return "Medve";
    }

    /**
     * Ilyen értelemben nincs speciális képessége, így ez a függvény nem csinál semmit.
     */
	@Override
	public void SpecKepesseg(Mezo cel) {
	}
	
	/**
	 * Felüldefiniált függvény, ami nem engedi, hogy elfogyjon a Medve testho-je.
	 * Ez úgy van biztosítva, hogy mindig 1-re állítja az értékét.
	 */
	@Override 
	public void TesthoHozzaad(int novekmeny) {testho = 1; }

	private Random rand = new Random();
	/**
	 * Ha az autoLepes értéke true, akkor kiválasztja az aktmezo szomszédos Mezo-i közül az egyiket, 
	 * amelyre lépni szeretne és ezzel paraméterezve meghívja az Atlep metódusát.
	 * Ha pedig false az értéke, akkor a felhasználót megkéri, hogy válasszon ezek  a szomszédos Mezo-k közül.
	 */
	@Override
	public void Autolepes() {
		
		if(autoLepes)
		{
			lepesszam = 1;
			ArrayList<Mezo> seged =new ArrayList<Mezo>();
			seged = (ArrayList<Mezo>) aktmezo.getSzomszed();
			int s=rand.nextInt(seged.size());
			Atlep(seged.get(s));
			this.Vegeztem();
		}
	
	}

	/**
	 * Amikor érintkezik valamilyen Szereplo-vel, akkor megtámadja őket. Meghívja az aktuális Mezo-jének a Tamadas metódusát.
	 */
	@Override
	public void Erintkezik() {
		aktmezo.Tamadas();
	}



	@Override
	public void FrissitNezet(GrafNezet n) {

		n.FrissitMedve(this,this==Palya.getAktJatekos());

	}
}
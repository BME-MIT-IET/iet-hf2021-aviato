package objects;

import view.GrafNezet;

/**
 *     olyan osztály amely a játékban szereplő Lukat testesíti meg
 *     és a játékszabályoknak megfelelően ha egy szereplő ide lép
 *     akkor mindig vízbe esik, és egy idő után meghal ha nem sikerül
 *     átlépnie egy másik mezoből leszármazott osztályra
 */
public class Luk extends Mezo{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4378829119523386212L;
	public Luk(String id) {
		super(id);
	}
	/**
     *    megpróbálja befogadni a paraméterként megkapott szereplőt, a régi mezőjéről,
     *    feltéve hogy a szereplő szomszédos mezőről érkezik, majd logikai változóként visszatér ezzel a ténnyel
     *    (sikeres befogadás esetén true). Ezek után minden mezőn lévő szereplővel érintkezik, a luk felderítődik
     *    és meghívódik a hatás függvény 
     */
	public boolean Befogad(Szereplo belepo, Mezo regi)
	{
		if(isSzomszed(regi)) {
			szereplok.add(belepo);
			szereplok.forEach((sz)->sz.Erintkezik());
			this.setfelderitett(true);
			Hatas(belepo);
			return true;
		}else {
			return false;
		}
		
		
	}
	
	/**
     *    Ha a Lukra szereplő érkezik akkor az biztos elázik, így meghívja
     *    az elázik függvényt
     */
    public void Hatas(Szereplo sz)
    {
     
        sz.Elazik();
    
    }
    /**
     * ha valaki lukrol probál meg tárgyat felvenni, akkor nem jár sikerrel
     */
    @Override
    public Targy Atad() {
        // TODO Auto-generated method stub
        return null;
       
    }
    /**
     * ha valaki lukra probál meg epuletet epiteni, akkor nem történik semmi
     */
    @Override
    public void setEpulet(Epulet e) {
        // TODO Auto-generated method stub

       
       
    }
    /**
     *     tudatja a kiiratásnál hogy egy Lukon végzik az esetlegesen
     *    mezobol nem felüldefiniált függvényt
     */
    public String Name() {
        return "Luk";
       
    }
	@Override
	public void FrissitNezet(GrafNezet n) {

		n.FrissitLuk(this);

	}
	/**	
	 *Visszaadja a luk teherbírását
	 */
	@Override
	public String getTeherBiras() {
		return "0";
	}
}

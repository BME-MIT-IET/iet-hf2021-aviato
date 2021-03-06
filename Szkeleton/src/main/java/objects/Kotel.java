package objects;
import java.io.Serializable;

import view.GrafNezet;


/**
 * Implementálja a Targy interfészt, csak egy Szereplo hívhatja meg a Kepesseg()
 * függvényét. - Nyílván csak akkor tudja meghívni, ha nála van, tehát már kiásta
 */

public class Kotel implements Targy, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 719590456416671811L;

	/**
	 * paraméter: Szereplo sz - az a szereplo akinél van a kötél, ez hívhatja csak meg a függvényt
	 * 
	 * A 'sz' Szereplo által kiválasztott 'honnan' Mezo-nek szól, hogy pakolja át az
	 * embereket, akik vízben vannak azon a mezon, arra a mezőre amin a 
	 * paraméterben kapott 'sz' Szereplo áll
	 * 
	 * nincs visszatérési érték
	 */
	public void Kepesseg(Szereplo sz, Mezo honnan) {
		
		Mezo akt_mezo = sz.getMezo();
		if(akt_mezo.isSzomszed(honnan))		
			honnan.Kimenekit(akt_mezo);		
		return;
	}
	
	/**
	 *  visszaadja az osztály nevét, implementálja a Targy függvényét
	 */
	public String Name() {
		return "Kotel";
	}

	@Override
	public void FrissitNezet(GrafNezet n) {

		n.FrissitKotel(this);

	}
}

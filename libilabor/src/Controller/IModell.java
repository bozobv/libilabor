package Controller;
import java.util.ArrayList;
import java.util.Random;

import Modell.*;
public interface IModell {
	/**
	 * Egy adott jatekost jellemzo adatok
	 * @param name az aso jatekos neve
	 */
	public void characterStats(String name);
	/**
	 * A player as
	 * @param type a jatekos tipusa
	 * @param name az aso jatekos neve
	 * @param index index, hogy a jatekos melyik icetablere kerul.
	 */
	public void addPlayer(String type, String name, int index);

	/**
	 * Maci hozzaadasa
	 * @param index hogy hova
	 */
	public void addBear(int index);
	/**
	 * Hovihar
	 * @param possibility a hovihar eselye
	 */

	public void blizzardChance(int possibility);

	/**
	 * A hovihar meretenek beallitasa
	 * @param size a meret
	 */
	public void blizzardSize(int size) ;

	/**
	 * ho magassaganak beallitasa
	 * @param snowHeight a ho magassaga
	 */
	public void iceFieldSnow(int snowHeight);
	/**
	 * item beallitasa
	 * @param itemPossibility item valoszinusege
	 */

	public void iceFieldItem(int itemPossibility) ;

	/**
	 * Icefield keszitese
	 * @param type icefield tipusa
	 * @param height magassag
	 * @param width szelesseg
	 
	 */
	
	public void createIceField(String type, int height, int width);
	
	/**
	 * instabil tabla hozzaadasa
	 * @param cap kapacitas
	 * 
	 */
	
	public void addUnstableTable(int cap);

	/**
	 * tabla hozzadasa
	 * @param type table tipusa
	 
	 
	 */
	
	public void addTable(String type);
	/**
	 * szomszedok beallitasa
	 * @param index1 egyik szomszed indexe
	 * @param index2 a masik szomszed indexe
	 */
	public void setNb(int index1, int index2);
	/**
	 * ho magassaganak beallitasa
	 * @param index  a icetable indexe
	 * @param height a magassag
	 * */

	public void setSnow(int index, int height);
	/**
	 * item beallitasa az icetableban
	 * @param type a tipusa az itemnek
	 * @param indexe a tablenek
	 * */
	
	public void setItem(String type, int index);

	/**
	 * Egy item osszetorese
	 * @parma index hogy melyik icetablen van
	 * */
	
	public void destroyItem(int index);
	
	/**
	 * A szomszed lekerdezesere
	 * @param index 
	 * */
	public void getNb(int index);

	/**
	 * player mozgatasa
	 * @param a jatekos neve aki mozdulni akar
	 * @param index hogy hova
	 * */
	public void movePlayer(String name, int index);
	
	/**medve mozgasa
	 * @param honnan 
	 * @param hova
	 * 
	 * */
	public void moveBear(int honnan, int hova);
	
	/**
	 * Egy dolog felvetele
	 * @param name a jatekos neve
	 * */
	
	public void pickUp(String name) ;
	/**
	 * item hozzadasa a jatekoshoz
	 * @param type item tipusa
	 * @param name a jatekos neve 
	 * */

	public void addItem(String type, String name);
	/**
	 * item eltavolitasa
	 * @param type tipus
	 * @param name a jatekos neve
	 * */
	public void removeItem(String type, String name);

	/**
	 * a karakter megolese
	 * @param name a jatekos neve
	 * */
	public void killCharacter(String name);
	
	/**
	 * A player as
	 * @param name az aso jatekos neve
	 */
	public void dig(String name) ;

	public void rope(String name, int index);

	public void setTent(String name);

	public void repairFlareGun(String name) ;

	public void buildIgloo(String name);

	public void scout(String name, int index) ;

	public void setThp(String name, int thp );

	public void setWork(String name, int work);

	public void callBlizzard(int size) ;

	public void save(String saveFileName);
	
	public void load(String saveFileName);
	
	public void killBear(int index);

	public String gameStance();
	
	public Player getCurrentPlayer();
	
	public void nextPlayer();


	void setIfController(Controller controller);

}

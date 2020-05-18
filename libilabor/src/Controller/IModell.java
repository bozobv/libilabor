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
	
	public void addUnstableTable(int cap);

	public void addTable(String type);

	public void setNb(int index1, int index2);

	public void setSnow(int index, int height);
	
	public void setItem(String type, int index);

	public void destroyItem(int index);
	
	public void getNb(int index);

	public void movePlayer(String name, int index);
	
	public void moveBear(int honnan, int hova);
	
	public void pickUp(String name) ;

	public void addItem(String type, String name);
	
	public void removeItem(String type, String name);

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

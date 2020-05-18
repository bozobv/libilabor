package Controller;
import java.util.ArrayList;
import java.util.Random;

import Modell.*;
public interface IModell {
	
	public void characterStats(String name);

	public void addPlayer(String type, String name, int index);

	public void addBear(int index);

	public void blizzardChance(int possibility);

	public void blizzardSize(int size) ;

	public void iceFieldSnow(int snowHeight);

	public void iceFieldItem(int itemPossibility) ;

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
	 * Asas parancs
	 * @param name a jatekos neve aki as
	 */
	public void dig(String name) ;
	/**
	 * A kotel hasznalat parancs
	 * @param name A player neve aki hasznalja 
	 * @param index A tabla, amelyen hasznalni szeretnenk, az elso embert menti meg a tablarol
	 */
	public void rope(String name, int index);
	/**
	 * Felallitja a satrat
	 * @param name A jatekos aki satrat allit
	 */
	public void setTent(String name);
	/**
	 * A jelzopiusztoly osszeszereles indito fuggveny
	 * @param name A jatekos aki kezdemenyezi az osszeszerelest 
	 */
	public void repairFlareGun(String name) ;
	/**
	 * Iglo epites a mezore parancs
	 * @param name Az eszkimo aki epit a mezore
	 */
	public void buildIgloo(String name);
	/**
	 * A sarkkutato kepessegnek parancsa
	 * @param name A kutato neve
	 * @param index	A mezo indexe, amelyet fel akar deriteni
	 */
	public void scout(String name, int index) ;
	/**
	 * Thp setter parancs
	 * @param name Akinek az eletet allitjuk
	 * @param thp Az uj erteke a thp-nak
	 */
	public void setThp(String name, int thp );
	/**
	 * Work setter parancs
	 * @param name Akinek a Workjet allitjuk
	 * @param work Az uj erteke a work-nek
	 */
	public void setWork(String name, int work);
	/**
	 * Hovihar imitalasanak parancsa
	 * @param size Amennyi palyat erint a hovihar
	 */
	public void callBlizzard(int size) ;
	/**
	 * Aktualis jatekallas mentese parancs
	 * @param saveFileName A fajl neve ahova menteni akrunk
	 */
	public void save(String saveFileName);
	/**
	 * A jatek betoltesenek parancsa 
	 * @param saveFileName A fajl neve ahonnan betoltjuk
	 */
	public void load(String saveFileName);
	/**
	 * Medve eltavolitas parancs
	 * @param index A mezo indexe ahonnan a medvet el akarjuk tavolitani
	 */
	public void killBear(int index);
	/**
	 * A jatek kiirasat megvalosito parancs
	 * @return A jatek kiirasa stringkent
	 */
	public String gameStance();
	/**
	 * Visszaadja a soron levo jatekost
	 * @return A soron levo jatekos
	 */
	public Player getCurrentPlayer();
	/**
	 * Kovetkezo soron levo jatekosra valtas
	 */
	public void nextPlayer();
	/**
	 * IceField controlleret allitja be
	 * @param controller a beallitando ertek
	 */
	void setIfController(Controller controller);

}

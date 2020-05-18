package Modell;
import java.util.ArrayList;
import java.util.Random;

import Controller.*;

public class Map implements IModell , java.io.Serializable
{
	/**
	 * A jatek aktualis jegmezoje
	 */
	private IceField iceField ;
	/**
	 * Minden tabla ennyi hoval kezd
	 */
	private int basicSnowHeight = 0;
	/**
	 * A targyak tablaban levo eselye
	 */
	private int FrozenItemDrop = 0;
	/**
	 * A mezo magassaga
	 */
	private int height;
	/**
	 * A mezo szelessege
	 */
	private int width;
	
	/**
	 * 	A soron levo jatekos adatai
	 */
	private String currentPlayer;
	
	/**
	 * Ha vihar lesz ez a tagvaltozo true
	 */
	private boolean blizzardComing = false; 
	
	/**
	 * Getter az iceField valtozohoz
	 * @return az iceField tagvaltozo referenciaja
	 */
	public IceField getIceField() {
		return iceField;
	}
	/**
	 * Getter az height valtozohoz
	 * @return az height tagvaltozo referenciaja
	 */
	public int getHeight(){
		return height;
	}
	/**
	 * Getter az width valtozohoz
	 * @return az width tagvaltozo referenciaja
	 */
	public int getWidth(){
		return width;
	}
	/**
	 * Konstruktor ami a parametereknek megfeleloen inicializalj a Map-et
	 * @param _height magassaga
	 * @param _width szelessege
	 * @param FrozenItemDrop targy esely
	 * @param snowHeight alap homagassag
	 * @param controller a jatek iranyito egysege
	 */
	public Map(int _height, int _width, int FrozenItemDrop, int snowHeight,Controller controller){
		height=_height;
		width=_width;
		iceField = new IceField(height, width, FrozenItemDrop, snowHeight);
		iceField.setController(controller);
	}
	/**
	 * Letrehoz egy kevesbe specifikalt Map-et
	 * @param controller a jatek iranyito egysege
	 */
	public Map(Controller controller)
	{
		iceField = new IceField();
		iceField.load();
		iceField.setController(controller);
	}

	public void createEmptyIceField() 
	{
		iceField = new IceField();
	}
	/**
	 * megkeresi az adott nevu jatekost
	 * @param name ot keressuk
	 * @return adott nevu jatekost
	 */
	public Player searchPlayer(String name) {
		for (int i = 0; i < iceField.getPlayers().size(); i++) {
			if (iceField.getPlayers().get(i).getName().equals(name)) {
				return iceField.getPlayers().get(i);
			}
		}
		return null;
	}
	/**
	 * kiirja az adot nevu karakter adatait
	 * @param name a keresett nev
	 */
	public void characterStats(String name) {
		searchPlayer(name).writeOut();
	}
	
	/**
	 * hozzaad egy playert az adott indexu jegtablahoz
	 * @param type milyen tipusu jatekos keruljon a palyara
	 * @param name a jatekos neve
	 * @param index a jegtabla indexe ahova kerul
	 */
	public void addPlayer(String type, String name, int index) {
		if (type.equals("eskimo")) {

			Eskimo newPlayer = new Eskimo(iceField.getIceTables().get(index));
			newPlayer.setName(name);
			iceField.getIceTables().get(index).getPlayersOnTable().add(newPlayer);
			iceField.addPlayer(newPlayer);
			newPlayer.setCurrentTable(iceField.getIceTables().get(index));

		} else if (type.equals("scientist")) {
			Scientist newPlayer = new Scientist(iceField.getIceTables().get(index));
			newPlayer.setName(name);
			iceField.getIceTables().get(index).getPlayersOnTable().add(newPlayer);
			iceField.addPlayer(newPlayer);
			newPlayer.setCurrentTable(iceField.getIceTables().get(index));
		} else {
			System.out.println("az elvart bemenet: add player eskimo/scientist name index ");
		}

	}
	/**
	 * hozzaad egy medvet az adott indexu jegtablara
	 * @param index a jegtabla indexe
	 */
	public void addBear(int index) {
		PolarBear bear = new PolarBear(iceField.getIceTables().get(index));
		iceField.getIceTables().get(index).getAnimalsOnTable().add(bear);
	}
	/**
	 *beallitja a vihar eselyet
	 *@param possibility az esely 
	 */
	public void blizzardChance(int possibility) {
		iceField.setBlizzardFrequency(possibility);
	}
	/**
	 * beallitja a vihar nagysagat
	 * @param size nagysag
	 */
	public void blizzardSize(int size) {
		iceField.setBlizzardSize(size);
	}
	/**
	 * bellitja az alap homagassagot
	 * @param snowHeight a homagassag
	 */
	public void iceFieldSnow(int snowHeight) {
		basicSnowHeight = snowHeight;

	}
	/**
	 * beallitja a targyak eselyet
	 * @param itemPossibility targyak eselye
	 */
	public void iceFieldItem(int itemPossibility) {
		FrozenItemDrop = itemPossibility;
	}
	/**
	 * letrehoz egy iceField-et a megadott parameterekkel
	 * @param type tipusa
	 * @param height magassaga
	 * @param width szelessege
	 */
	public void createIceField(String type, int height, int width) {
		Random rand = new Random();
		int d = rand.nextInt(10);
		int s = rand.nextInt(10);

		switch(type) {
		case "empty": iceField = new IceField(); break;
		case "defined" : iceField = new IceField(height, width, FrozenItemDrop, basicSnowHeight); break;
		case "random": iceField = new IceField(height, width, d, s); break;
		default: break;
		}

	}
	/**
	 * hozzaad egy instabil tablat a mezohoz egy adott kapacitassal
	 * @param cap kapacitas
	 */
	public void addUnstableTable(int cap) {

		UnstableTable k = new UnstableTable(cap);
		iceField.getIceTables().add(k);
		k.setIceField(iceField);

	}
	/**
	 * hozzaad egy adott tipusu tablat a mezohoz
	 * @param type tipus
	 */
	public void addTable(String type) {
		switch (type) {
		case "stable":
			StableTable t = new StableTable();
			iceField.getIceTables().add(t);
			t.setIceField(iceField);
			;
			break;
		case "hole":
			Hole h = new Hole();
			iceField.getIceTables().add(h);
			h.setIceField(iceField);
			break;
		}
	}
	/**
	 * beallitja a parameterkent kapott indexu tabalakat egymas szomszedainak
	 * @param index1 egyik tabla indexe
	 * @param index2 masik tabla indexe
	 */
	public void setNb(int index1, int index2) {
		if (index1 > iceField.getIceTables().size() || index2 > iceField.getIceTables().size()) {
			System.out.println("nincs ilyen indexu tabla");
		}
		ArrayList<IceTable> i1 = iceField.getIceTables().get(index1).getNeighbours();
		for (int i = 0; i < i1.size(); i++) {
			if (i1.get(i) == iceField.getIceTables().get(index2))
				return;
		}
		i1.add(iceField.getIceTables().get(index2));
		ArrayList<IceTable> i2 = iceField.getIceTables().get(index2).getNeighbours();
		i2.add(iceField.getIceTables().get(index1));
		iceField.getIceTables().get(index1).setNeighbours(i1);
		iceField.getIceTables().get(index2).setNeighbours(i2);
	}
	/**
	 * adott indexu tabla homagassagat allitja be
	 * @param index index
	 * @param height a homagassag
	 */
	public void setSnow(int index, int height) {
		iceField.getIceTables().get(index).setSnowHeight(height);
	}
	/**
	 * bealittja egy adott indexu tablanak a targyat
	 * @param type a targy tipusa
	 * @param index a jegtabla indexe
	 */
	public void setItem(String type, int index) {
		switch (type) {
		case "fg":
			this.iceField.getIceTables().get(index).setFrozenItem(new FlareGunPart());
			break;
		case "r":
			this.iceField.getIceTables().get(index).setFrozenItem(new Rope());
			break;
		case "sc":
			this.iceField.getIceTables().get(index).setFrozenItem(new ScubaSuit());
			break;
		case "s":
			this.iceField.getIceTables().get(index).setFrozenItem(new Shovel());
			break;
		case "ws":
			this.iceField.getIceTables().get(index).setFrozenItem(new WeakShovel());
			break;
		case "t":
			this.iceField.getIceTables().get(index).setFrozenItem(new Tent());
			break;
		case "wh":
			this.iceField.getIceTables().get(index).setFrozenItem(new Whiskey());
			break;
		case "f":
			this.iceField.getIceTables().get(index).setFrozenItem(new Food());
			break;
		case "adr":
			this.iceField.getIceTables().get(index).setFrozenItem(new Adrenalin());
			break;
		default:
			break;

		}
	}
	/**
	 * egy adott indexu jegtablabol eltavolitja a targyat
	 * @param index az adott index
	 */
	public void destroyItem(int index) {
		iceField.getIceTables().get(index).setFrozenItem(null);
	}
	
	/**
	 * a megadott nevu jatekost a megadott indexu jegtablara mozgatja
	 * @param name a jatekos neve
	 * @param index a jegtabla indexe
	 */
	public void movePlayer(String name, int index) {
		Player player = searchPlayer(name);
		IceTable temp = null;
		for (IceTable it : player.getCurrentTable().getNeighbours()) {
			if (it == iceField.getIceTables().get(index))
				temp = it;
		}
		if (temp != null) {
			player.move(temp);
		}
	}
	/**
	 * a medve mozgatasa
	 * @param honnan honnan
	 * @param hova hova
	 */
	public void moveBear(int honnan, int hova) {
		if (iceField.getIceTables().get(honnan).getAnimalsOnTable() == null)
			return;
		PolarBear pb = iceField.getIceTables().get(honnan).getAnimalsOnTable().get(0);
		IceTable temp = null;
		for (IceTable it : pb.getCurrentTable().getNeighbours()) 
		{
			if (it == iceField.getIceTables().get(hova))
				temp = it;
		}
		if (temp != null) {
			pb.move(temp);
		}
		
	}
	/**
	 * felveszi az adott nevu jatekos a tablaja targyat
	 * @param name a jatekos neve
	 */
	public void pickUp(String name) {
		searchPlayer(name).pickUp();
	}
	/**
	 * odaad egy adott nevu jatekosnak egy adott tipusu targyat
	 * @param type a targy tipusa
	 * @param name a jatekos neve
	 */
	public void addItem(String type, String name) {

		Storable item;
		switch (type) {
		case "flaregun":
			item = new FlareGunPart();
			break;
		case "rope":
			item = new Rope();
			break;
		case "scubasuit":
			item = new ScubaSuit();
			break;
		case "shovel":
			item = new Shovel();
			break;
		case "weakshovel":
			item = new WeakShovel();
			break;
		case "tent":
			item = new Tent();
			break;
		default:
			System.out.println("Helytelen parameter!");
			item = null;
			break;
		}
		if (item != null) {
			searchPlayer(name).addToInventory(item);
		}

	}
	/**
	 * eltavolit egy adott tipusu elemet egy adott nevu jatekostol
	 * @param type a targy tipusa
	 * @param name a jatekos neve
	 */
	public void removeItem(String type, String name) {

		int idx;
		switch (type) {
		case "f":
			idx = 0;
			break;
		case "r":
			idx = 1;
			break;
		case "sc":
			idx = 2;
			break;
		case "s":
		case "ws":
			idx = 3;
			break;
		case "t":
			idx = 4;
			break;
		default:
			System.out.println("Helytelen parameter!");
			idx = -1;
			break;
		}
		if (idx > 0) {
			searchPlayer(name).removeFromInventory(idx);
		}

	}
	/**
	 * megoli az adott nevu karaktert
	 * @param name a jatekos neve
	 */
	public void killCharacter(String name) {
		searchPlayer(name).getCurrentTable().removePlayer(searchPlayer(name));

	}
	/**
	 * az adott nevu jatekos as a sajat tablajan
	 * @param name a jatekos neve
	 */
	public void dig(String name) {
		for (Player player : this.iceField.getPlayers()) {
			if (player.getName().equals(name))
				player.dig();
				
		}
	}
	
	/**
	 * adott nevu jatekos haszn�lja a k�telet az adott indexu jegtablan levo egyik jatekosra
	 * @param name a hasznalo neve
	 * @param index a kihuzni kivant jatekos tablaja 
	 */
	public void rope(String name, int index) {
		searchPlayer(name).useItem(1, index);

	}
	/**
	 * felallit az adott nevu jatekos tablajan egy satrat
	 * @param name a jatekos neve
	 */
	public void setTent(String name) {
		for (Player player : this.iceField.getPlayers()) {
			if (player.getName().equals(name))
				player.useItem(4, 0);
		}
	}
	/**
	 * az adott nevu jatekos megprobalja megjavitani a jelzopisztolyt
	 *  @param name a jatekos neve
	 */
	public void repairFlareGun(String name) {
		searchPlayer(name).useItem(0, 0);
	}
	/**
	 * adott nevu jatekos igloot epit a tablajara
	 * @param name jatekos neve
	 */
	public void buildIgloo(String name) {
		for (Player player : this.iceField.getPlayers()) {
			if (player.getName().equals(name))
				player.useSkill(player.getCurrentTable());
		}
	}
	/**
	 * a sarkkutato kepessege
	 * @param sarkkutato neve
	 * @param a megvizsgalni kivant jegtabla indexe
	 */
	public void scout(String name, int index) {
		searchPlayer(name).useSkill(this.iceField.getIceTables().get(index));
	}
	/**
	 * adott nevu jatekosnak egy adott ertekre allitja a thp-jat
	 * @param name a jatekos neve
	 * @param thp erteke
	 */
	public void setThp(String name, int thp ) {

		for (int i = 0; i < iceField.getPlayers().size(); i++) {
			if (iceField.getPlayers().get(i).getName().equals(name)) {

				iceField.getPlayers().get(i).setThp(thp);
				return;
			}
		}

	}
	/**
	 * adott nevu jatekos munkajat adott ertekre allitja
	 * @param name a jatekos neve
	 * @param work a munka erteke
	 */
	public void setWork(String name, int work) {

		for (int i = 0; i < iceField.getPlayers().size(); i++) {
			if (iceField.getPlayers().get(i).getName().equals(name)) {

				iceField.getPlayers().get(i).setWork(work);
				return;
			}
		}

	}
	/**
	 * vihart idez a mezon
	 * @param size ilyen meretu vihart indit
	 */
	public void callBlizzard(int size) {
		iceField.Blizzard(size);
	}
	/**
	 * adott file-ba menti az aktualis jatekallast
	 * @param saveFileName a file eleri utvonala
	 */
	public void save(String saveFileName) 
	{
		this.getIceField().save();
	}
	/**
	 * adott file-bol tolt be egy korabban mentett allast 
	 * @param saveFileName a file eleri utvonala
	 */
	public void load(String name) {
		if (name == "new") 
		{
			iceField = iceField.loadNewGame();
			currentPlayer = iceField.getPlayers().get(0).getName();
		}
		else {
				iceField = iceField.load();
				currentPlayer = iceField.getPlayers().get(0).getName();
		}
	}
	/**
	 * adott indexu tablan megol egy medvet
	 * @param adott tabla indexe
	 */
	public void killBear(int index) 
	{
		PolarBear removedAnimal = iceField.getIceTables().get(index).getAnimalsOnTable().get(0);
		ArrayList<PolarBear> testAnimals = iceField.getAnimal();
		for (int i = 0; i < testAnimals.size(); i++) 
		{
			if (testAnimals.get(i) == removedAnimal)
				testAnimals.remove(i);
		}

	}

	/**
	 * visszaadja az eppen jatszo jatekost
	 * @return eppen jatszo jatekos
	 */
	@Override
	public Player getCurrentPlayer() {
		return searchPlayer(currentPlayer);
	}


	/**
	 * lepteti a jatekosokat
	 */
	public void nextPlayer()
	{

		
		if (currentPlayer == iceField.getPlayers().get(iceField.getPlayers().size() - 1).getName())
		{
			//ha az utso játékos volt, ezek történnek:
			//currentplayer az első játékos lesz
			if(iceField.getPalyerInWater()){
				iceField.endGame();
			}
			currentPlayer = iceField.getPlayers().get(0).getName();

			//állatok lépnek
			for(int j = 0; j < iceField.getIceTables().size(); j++)
			{
				if (iceField.getIceTables().get(j).getAnimalsOnTable().isEmpty() == false)
					iceField.getIceTables().get(j).getAnimalsOnTable().get(0).step();
				//System.out.println("allat: " + j);
			}
			
			for (int i = 0; i < iceField.getPlayers().size(); i++) 
			{
				//osszes player workje 5re allitva
				iceField.getPlayers().get(i).setWork(4);
				Random rand = new Random(); 
				//ha jon vihar, akkor meghivja a vihar fuggvenyt
				if (blizzardComing == true) 
				{
						iceField.Blizzard(iceField.getBlizzardSize());
				}
				//itt 1 a 4hez az esely, hogy kovi korban vihar jon
				if (rand.nextInt(iceField.getBlizzardFrequency()) == 0) 
					blizzardComing = true;
				else
					blizzardComing = false;
			}
		}
		else
			{
				boolean gotit = false;
				int i = 0;
				while(gotit == false)
				{
					if (iceField.getPlayers().get(i).getName() == currentPlayer)
					{
						currentPlayer = iceField.getPlayers().get(i + 1).getName();
						gotit = true;
					}
					i++;
				}
			}
	}
	/**
	 * 	beallitja az iceField vezerlo egyseget
	 * @param vezerlo egyseg
	 */
	@Override
	public void setIfController(Controller controller) {
		iceField.setController(controller);
	}


}

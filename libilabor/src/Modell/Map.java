package Modell;
import java.util.ArrayList;
import java.util.Random;

import Controller.*;

public class Map implements IModell 
{
	private IceField iceField;
	private int basicSnowHeight = 0;
	private int FrozenItemDrop = 0;
	private int height;
	private int width;
	private String currentPlayer;
	
	private boolean blizzardComing = false; 
	

	public IceField getIceField() {
		return iceField;
	}
	public int getHeight(){
		return height;
	}
	public int getWidth(){
		return width;
	}

	public Map(int _height, int _width, int FrozenItemDrop, int snowHeight){
		height=_height;
		width=_width;
		iceField = new IceField(height, width, FrozenItemDrop, snowHeight);
	}

	public void createEmptyIceField() 
	{
		iceField = new IceField();
	}

	public Player searchPlayer(String name) {
		for (int i = 0; i < iceField.getPlayers().size(); i++) {
			if (iceField.getPlayers().get(i).getName().equals(name)) {
				return iceField.getPlayers().get(i);
			}
		}
		return null;
	}

	public void characterStats(String name) {
		searchPlayer(name).writeOut();
	}

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

	public void addBear(int index) {
		PolarBear bear = new PolarBear(iceField.getIceTables().get(index));
		iceField.getIceTables().get(index).getAnimalsOnTable().add(bear);
	}

	public void blizzardChance(int possibility) {
		iceField.setBlizzardFrequency(possibility);
	}

	public void blizzardSize(int size) {
		iceField.setBlizzardSize(size);
	}

	public void iceFieldSnow(int snowHeight) {
		basicSnowHeight = snowHeight;

	}

	public void iceFieldItem(int itemPossibility) {
		FrozenItemDrop = itemPossibility;
	}

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

	public void addUnstableTable(int cap) {

		UnstableTable k = new UnstableTable(cap);
		iceField.getIceTables().add(k);
		k.setIceField(iceField);

	}

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

	public void setSnow(int index, int height) {
		iceField.getIceTables().get(index).setSnowHeight(height);
	}

	public void tableStats(int index) {
		System.out.print(index);
		iceField.getIceTables().get(index).writeOut();
	}

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

	public void destroyItem(int index) {
		iceField.getIceTables().get(index).setFrozenItem(null);
	}

	public void getNb(int index) {

		System.out.print("(");
		ArrayList<IceTable> nbs = iceField.getIceTables().get(index).getNeighbours();
		for (int j = 0; j < nbs.size(); j++) {
			for (int k = 0; k < iceField.getIceTables().size(); k++) {
				if (nbs.get(j) == iceField.getIceTables().get(k))
					System.out.print(k + ", ");
			}
		}
		System.out.print(")");

	}

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
	public void pickUp(String name) {
		searchPlayer(name).pickUp();
	}

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

	public void killCharacter(String name) {
		searchPlayer(name).getCurrentTable().removePlayer(searchPlayer(name));

	}

	public void dig(String name) {
		for (Player player : this.iceField.getPlayers()) {
			if (player.getName().equals(name))
				player.dig();
		}
	}

	public void rope(String name, int index) {
		searchPlayer(name).useItem(1, index);

	}

	public void setTent(String name) {
		for (Player player : this.iceField.getPlayers()) {
			if (player.getName().equals(name))
				player.useItem(4, 0);
		}
	}

	public void repairFlareGun(String name) {
		searchPlayer(name).useItem(0, 0);
	}

	public void buildIgloo(String name) {
		for (Player player : this.iceField.getPlayers()) {
			if (player.getName().equals(name))
				player.useSkill(player.getCurrentTable());
		}
	}

	public void scout(String name, int index) {
		searchPlayer(name).useSkill(this.iceField.getIceTables().get(index));
	}

	public void setThp(String name, int thp ) {

		for (int i = 0; i < iceField.getPlayers().size(); i++) {
			if (iceField.getPlayers().get(i).getName().equals(name)) {

				iceField.getPlayers().get(i).setThp(thp);
				return;
			}
		}

	}

	public void setWork(String name, int work) {

		for (int i = 0; i < iceField.getPlayers().size(); i++) {
			if (iceField.getPlayers().get(i).getName().equals(name)) {

				iceField.getPlayers().get(i).setWork(work);
				return;
			}
		}

	}

	public void callBlizzard(int size) {
		iceField.Blizzard(size);
	}

	public void save(String saveFileName) {
		iceField.save();
	}

	public void load(String name) {
		if (name == "new") 
		{
			iceField = iceField.loadNewGame();
			currentPlayer = iceField.getPlayers().get(0).getName();
		}
		else {
				iceField = iceField.load();
				
		}
	}

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

	public String gameStance() 
	{
		String str="";
		if (iceField != null) 
		{
			str= iceField.writeOut();
		}
		return str;
	}

	@Override
	public Player getCurrentPlayer() {
		return searchPlayer(currentPlayer);
	}


	//ezek még nincsenek késze, csak commitolok
	public void nextPlayer()
	{
		boolean playerDrowning = false; 
		
		if (currentPlayer == iceField.getPlayers().get(iceField.getPlayers().size()).getName())
		{
			//ha az utso játékos volt, ezek történnek:
			//currentplayer az első játékos lesz
			currentPlayer = iceField.getPlayers().get(0).getName();
			
			//állatok lépnek
			for(int j = 0; j < iceField.getAnimal().size(); j++)
			{
				iceField.getAnimal().get(j).step();
			}
			
			for (int i = 0; i < iceField.getPlayers().size(); i++) 
			{
				//osszes player workje 5re allitva
				iceField.getPlayers().get(i).setWork(5);
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
			for (int i = 0; i < iceField.getPlayers().size(); i++) 
			{
				//ha nem az utso jatekos, akkor csak siman a currentplayert allitjuk a kovire
				if (iceField.getPlayers().get(i).getName().equals(currentPlayer)) 
				{
					currentPlayer = iceField.getPlayers().get(i + 1).getName();
				}
			}
	}

	
	
	/*public String[] getCurrentPlayerData()
	{
		//ez fölösleges :)
		String[] cpString = new String[8];
		cpString[0] = currentPlayer;
		cpString[1] = String.valueOf(currentPlayer.getThp());
		cpString[2] = String.valueOf(currentPlayer.getWork());
		
		Storable[] cpInventory = currentPlayer.getInventory();
		for (int i = 0; i<5; i++)
		{
			cpString[3 + i] = cpInventory[i].writeOut();
		}
		return cpString;
	}*/
	
	
	
}

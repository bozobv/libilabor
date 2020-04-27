package libilabor;

import java.util.Random;
import java.util.ArrayList;

public class IceField 
{
	private boolean playerInWater = false;
	private ArrayList<IceTable> iceTables = new ArrayList<IceTable>();
	private ArrayList<Character> characters = new ArrayList<Character>();
	private ArrayList<Player> players = new ArrayList<Player>(); 
	
	//private int FrozenItemDrop = 6; 	// minel nagyobb a szam, annal kisebb az esely, hogy befagyott targy jon letre
	private int blizzardFrequency = 9; //minel nagyobb a szam, annal kisebb az esely a hoviharra
	private int blizzardSize = 0;
	private boolean blizzardComing = false; // jelzi, hogy kovetkezo korben jon-e vihar
	
	public IceField()
	{
		StableTable nextStableTable = new StableTable();
		iceTables.add(nextStableTable);
	}
	
	public IceField(int height, int width, int FrozenItemDrop, int snowHeight) 
	{
		if (height < 2 || width < 2) 
		{
			System.out.println("Tul kicsi, a meret a lenyeg, a magassagnak es a szelessegnek 1-nel nagyobbnak kell lennie");
			return;
		}
		
		if (FrozenItemDrop < 1 || FrozenItemDrop > 10)
		{
			System.out.println("A befagyott targyak eselyenek 1 es 10 kozott kell lennie");
			return;
		}	

		// veletlenszeru legyen a jegtabla tipusok generalasa
		Random rand = new Random();
		int randomTable = 0;
		int TableTypesCount = 3;
		// a jatekosok kiindulo pontja fixen stabil jegtabla
		StableTable firstTable = new StableTable();
		this.iceTables.add(firstTable);
		// jegmezo feltoltese jegtablakkal
		for (int i = 1; i < height * width; i++) 
		{
			randomTable = rand.nextInt(TableTypesCount);

			switch (randomTable) 
			{
				case 0:
					StableTable nextStableTable = new StableTable();
					iceTables.add(nextStableTable);
					break;
				case 1:
					UnstableTable nextUnstableTable = new UnstableTable(4);
					iceTables.add(nextUnstableTable);
					break;
				case 2:
					Hole nextHole = new Hole();
					iceTables.add(nextHole);
					break;
				default:
			}
			iceTables.get(i).setIceField(this);
		}
		
		// Szomszedok meghatarozasa, ho magassag beallitasa
		for (int i = 0; i < height * width; i++) 
		{
			iceTables.get(i).setSnowHeight(snowHeight);
			ArrayList<IceTable> neighbours = new ArrayList<IceTable>();
			
			if (i % width != width - 1) 
				neighbours.add(iceTables.get(i + 1));
			
			if (i % width != 0) 
				neighbours.add(iceTables.get(i - 1));
			
			if (i < iceTables.size() - width) 
				neighbours.add(iceTables.get(i + width));
			
			if (i > width - 1) 
				neighbours.add(iceTables.get(i - width));
			
			iceTables.get(i).setNeighbours(neighbours);	
		}
		
		// itemek elhelyezese
		// FlareGunParts elhelyezes:
		int FGPOnField = 0;
		while (FGPOnField <= 3) 
		{
			int RandomNumber = rand.nextInt(height * width - 1);
			if (iceTables.get(RandomNumber).getFrozenItem() == null) 
			{
				FlareGunPart flg = new FlareGunPart();
				iceTables.get(RandomNumber).setFrozenItem(flg);
				if (iceTables.get(RandomNumber).getItem() != null)
					FGPOnField++;
			}
		}
		
		// random item letrehozas es lepakolas
		int NumberOfItems = 8;
		int ItemSetChance = rand.nextInt(FrozenItemDrop);
		int RandomItem = rand.nextInt(NumberOfItems);
		for (int i = 0; i < iceTables.size(); i++) 
		{
			if (iceTables.get(i).getFrozenItem() != null) 
			{
				if (ItemSetChance == 0) {
					switch (RandomItem) {
					case 0:
						Item Adr = new Adrenalin();
						iceTables.get(i).setFrozenItem(Adr);
						break;
					case 1:
						Item F = new Food();
						iceTables.get(i).setFrozenItem(F);
						break;
					case 2:
						Item SS = new ScubaSuit();
						iceTables.get(i).setFrozenItem(SS);
						break;
					case 3:
						Item Sh = new Shovel();
						iceTables.get(i).setFrozenItem(Sh);
						break;
					case 4:
						Item R = new Rope();
						iceTables.get(i).setFrozenItem(R);
						break;
					case 5:
						Item Wh = new Whiskey();
						iceTables.get(i).setFrozenItem(Wh);
						break;
					case 6:
						Item WSh = new WeakShovel();
						iceTables.get(i).setFrozenItem(WSh);
						break;
					case 7:
						Item T = new Tent();
						iceTables.get(i).setFrozenItem(T);
						break;
					default:
					}
				}
			}
		}
	}

	public void turn() 
	{
		// hovihar erkezesenek a randomizalasahoz
		Random rand = new Random(); 
		boolean playerDrowning = false; // ha az elozo korben valaki vizbeesett buvarruha nelkul, akkor igaz
		int i = 0;
		while (i < characters.size())  // mindegyik jatekosnak meghivja a step fuggvenyet, az utolso
									// jatekosnal ujrainditja a szamlalot
		{
			characters.get(i).step();
			// ha elozo korben valaki vizbeesett, es meg ebben
			// a korben is benne van, akkor vege a jateknak
			if (playerInWater == true && playerDrowning == true)
			{
				endGame();
				return;
			}
			playerDrowning = playerInWater;

			if (i < characters.size() - 1) // megnezi, hogy az utolso jaekosnal jar-e
				i++;
			else 
			{
				i = 0;
				// ha az elozo korben jelezve lett, hogy erkezik hovihar, akkor ebben a
				// korben meghivja a blizzard fuggvenyt
				if (blizzardComing == true) 
				{
					if (blizzardSize < 1 || blizzardSize > 10)
						Blizzard(rand.nextInt(10));
					else
						Blizzard(blizzardSize);
				}
				// esely arra, hogy kovetkezo korben hovihar jon
				if (rand.nextInt(blizzardFrequency) == 0) 
					blizzardComing = true;
				else
					blizzardComing = false;
			}
		}
	}
	
	public void endGame() 
	{
		System.out.println("Legalabb egy jatekos megfulladt, elbuktatok a kuldetest!");
	}

	public void Blizzard(int size) 
	{
		// hovihar  helyenek randomizalasahoz
		Random rand = new Random(); 
		// hovihar helyenek randomizalasa
		int randomTable = rand.nextInt(iceTables.size());
		// hovihar merete tablameret / arany
		int blizzardedTables = iceTables.size() / (10 - size); 
		// meghivjuk az erintett tablakra a blizzardcomming fuggvenyt 
		if (randomTable + blizzardedTables > iceTables.size()) 
		{
			// abban az esetben, ha esetben, ha tulindexelodne a tablak listaja, a
			// masik iranyba hivja meg a blizzard maradek reszet
			for (int j = randomTable; j < iceTables.size(); j++) {
				iceTables.get(j).blizzardComing();
			}

			for (int j = randomTable - 1; j >= iceTables.size() - blizzardedTables; j--) {
				iceTables.get(j).blizzardComing();
			}
		} else {
			// ha nem indexelodik tul, akkor a
			// random kiindulasi ponttol fut le a hovihar
			
			for (int j = randomTable; j < randomTable + blizzardedTables; j++) 
			{
				iceTables.get(j).blizzardComing();
			}

		}
	}
	
	public void setPlayerInWater(boolean b) 
	{
		playerInWater = b;
		System.out.println("ember a vizben!!!");
	}
	
	public boolean getPalyerInWater() 
	{
		
		return playerInWater;
	}
	
	public ArrayList<IceTable> getIceTables() 
	{
		return iceTables;
	}

	public void setIceTables(ArrayList<IceTable> iceTables) 
	{
		this.iceTables = iceTables;
	}
	
	public ArrayList<Character> getCharacter()
	{
		return characters;
	}
	
	public void setPlayers(ArrayList<Player> players) 
	{
		this.players = players;

	}
			
	public void addPlayer(Player newPlayer)
	{
		this.players.add(newPlayer); 
	}
		
	public void victory() 
	{
		System.out.println("Gyozelem");
	}
		
	/*public void setFrozenItemDrop(int frequency) 
	{
		if (frequency < 1) 
		{
			System.out.println("Nullanal nagyobbnak kell lennie, te kis butus");
			return;
		}
		this.FrozenItemDrop = frequency;
		
	}*/
		
	public void setBlizzardFrequency(int frequency) 
	{
		if (frequency < 1) 
		{
			System.out.println("Nullanal nagyobbnak kell lennie, te kis butus");
			return;
		}
		this.blizzardFrequency = frequency;
	}
	
	/*public int getFrozenItemDrop() 
	{
		return this.FrozenItemDrop;
	}*/
	
	public int getBlizzardFrequency() 
	{
		return this.blizzardFrequency;
	}
	
	public void addTable(String TableType, int idx)
	{
		IceTable newTable;
		if(TableType == "stable")
		{
			newTable = new StableTable();
		}
		
		else if(TableType == "unstable")
		{
			newTable = new StableTable();
		}
		
		else if(TableType == "hole")
		{
			newTable = new StableTable();
		}
		else
		{
			System.out.println("Nincs ilyen jegtablafajta. Lehetosegek: stable , unstable . hole");
			return;
		}
		this.iceTables.add(idx, newTable);
	}
	
	public int getBlizzardSize() 
	{
		return blizzardSize;
	}
	
	public void setBlizzardSize(int blizzardSize) 
	{
		if (blizzardSize > 0 && blizzardSize < 11 )
			this.blizzardSize = blizzardSize;
		else
			System.out.println("A hovihar meret 1-tol 10-ig terjedhet ");
	}
	
	
	public void save()
	{
		
	}
	
	public void load()
	{
		
	}
	
	public void writeOut()
	{
		for(int i = 0; i < iceTables.size(); i++ )
		{
			System.out.println(i);
			iceTables.get(i).writeOut();
			System.out.print("(");
			ArrayList<IceTable> nbs = iceTables.get(i).getNeighbours();
			for (int j = 0; j < nbs.size(); j++)
			{
				for(int k = 0; k < iceTables.size(); k++ )
				{
					if(nbs.get(j) == iceTables.get(k))
						System.out.print(k + ", ");
				}
			}
			System.out.print(")");

		}
	}
}

package libilabor;

import java.util.Random;
import java.util.ArrayList;
import java.io.*;

public class IceField implements java.io.Serializable
{
	/**
	 * szerializaciohoz szukseges ID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ez a bool akkor true hogyha egy jatekos veszelyben van tehat lyukba eset
	 */
	private boolean playerInWater = false;
	/**
	 * a mezon levo tablak listaja
	 */
	private ArrayList<IceTable> iceTables = new ArrayList<IceTable>();
	/**
	 * a mezon levo allatok listaja
	 */
	private ArrayList<PolarBear> animals = new ArrayList<PolarBear>();
	/**
	 * a mezon levo jatekosok listaja
	 */
	private ArrayList<Player> players = new ArrayList<Player>(); 
	
	/**
	 * a hovihar eslyehez hasznalt szam
	 */
	private int blizzardFrequency = 9; //minel nagyobb a szam, annal kisebb az esely a hoviharra
	/**
	 * a hovihar merete
	 */
	private int blizzardSize = 0;
	/**
	 * jelzi, hogy kovetkezo korben jon-e vihar
	 */
	private boolean blizzardComing = false; 
	
	/**
	 * default konstruktor ures mezo letrehozasahoz
	 */
	public IceField()
	{
		StableTable nextStableTable = new StableTable();
		iceTables.add(nextStableTable);
	}
	/**
	 * konstruktor parameterekkel itt inicializalunk mindent es hozzuk a mezot a jatek kezdesehez megfelelo allapotea
	 * @param height a jegtablak sorainak szama
	 * @param width a jegtablak oszlopainak szama
	 * @param FrozenItemDrop a itemek eselye tablankent
	 * @param snowHeight a maximalis homagassag ami lehet tablan
	 */
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
				if (iceTables.get(RandomNumber).getFrozenItem() != null)
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
		
		//playerek elhelyezese a tablara
		for(int i = 0; i < players.size(); i++ )
		{
			players.get(i).setCurrentTable(iceTables.get(0));
		}
		
		//allatok elhelyezes random helyre
		for(int i = 0; i < animals.size(); i++ )
		{
			animals.get(i).setCurrentTable(iceTables.get(rand.nextInt(iceTables.size() - 1) + 1));
		}
	}

	/**
	 * a kor menetenek lebonyolitasa
	 */
	public void turn() 
	{
		// hovihar erkezesenek a randomizalasahoz
		Random rand = new Random(); 
		boolean playerDrowning = false; // ha az elozo korben valaki vizbeesett buvarruha nelkul, akkor igaz
		int i = 0;
		while (i < players.size())  // mindegyik jatekosnak meghivja a step fuggvenyet, az utolso
									// jatekosnal ujrainditja a szamlalot
		{
			//players.get(i).step();
			// ha elozo korben valaki vizbeesett, es meg ebben
			// a korben is benne van, akkor vege a jateknak
			if (playerInWater == true && playerDrowning == true)
			{
				endGame();
				return;
			}
			playerDrowning = playerInWater;

			if (i < players.size() - 1) // megnezi, hogy az utolso jaekosnal jar-e
				i++;
			else 
			{
				i = 0;
				for(int j = 0; j < animals.size(); j++)
				{
					animals.get(i).step();
				}
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
	/**
	 * a jatek veget intezo fuggveny
	 */
	public void endGame() 
	{
		System.out.println("Legalabb egy jatekos megfulladt, elbuktatok a kuldetest!");
	}
	/**
	 * hovihar esemenye
	 * @param size a hovihar merete
	 */
	public void Blizzard(int size) 
	{
		// hovihar  helyenek randomizalasahoz
		Random rand = new Random(); 
		// hovihar helyenek randomizalasa
		int randomTable = rand.nextInt(iceTables.size());
		// hovihar merete tablameret / arany
		int blizzardedTables = iceTables.size() / (11 - size); 
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
	
	/**
	 * setter a playerInWater valtozonak
	 * @param b uj ereteke
	 */
	public void setPlayerInWater(boolean b) 
	{
		playerInWater = b;
		System.out.println("ember a vizben!!!");
	}
	/**
	 * gettere a playerInWater valtozonak
	 * @return a valtozo referenciaja
	 */
	public boolean getPalyerInWater() 
	{		
		return playerInWater;
	}
	/**
	 * getter az iceTables valtozohoz
	 * @return a valtozo referenciaja
	 */
	public ArrayList<IceTable> getIceTables() 
	{
		return iceTables;
	}
	/**
	 * Setter az iceTables valtozonak
	 * @param iceTables uj erteke a valtozonak
	 */
	public void setIceTables(ArrayList<IceTable> iceTables) 
	{
		this.iceTables = iceTables;
	}
	/**
	 * hozzad egy medvet a mezo animals listajahoz
	 * @param newBear a hozzadott medve
	 */
	public void addAnimal(PolarBear newBear)
	{
		this.animals.add(newBear); 
	}
	/**
	 * Getter az animals valtozohoz
	 * @return a valtozo referenciaja
	 */
	public ArrayList<PolarBear> getAnimal()
	{
		return animals;
	}
	/**
	 * Getter a players valtozohoz
	 * @return a valtozo referenciaja
	 */
	public ArrayList<Player> getPlayers()
	{
		return players;
	}

	/**
	 * Setter a players valtozohoz
	 * @param players a valtozo uj erteke
	 */
	public void setPlayers(ArrayList<Player> players) 
	{
		this.players = players;

	}
	/**
	 * hozzaad egy uj jatekost a players listahoz
	 * @param newPlayer a hozzaadott jatekos
	 */
	public void addPlayer(Player newPlayer)
	{
		this.players.add(newPlayer); 
	}
	/**
	 * a nyeres logika
	 */
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
	/**
	 * setter a blizzardFrequency valtozohoz
	 * @param frequency a valtozo uj erteke
	 */
	public void setBlizzardFrequency(int frequency) 
	{
		if (frequency < 1 || frequency > 10) 
		{
			System.out.println("ez így nem jó, 1-től 10-ig lehet egész szám, te kis butus");
			return;
		}
		this.blizzardFrequency = frequency;
	}
	
	/*public int getFrozenItemDrop() 
	{
		return this.FrozenItemDrop;
	}*/
	/**
	 * getter a blizzardFrequency valtozohoz
	 * @return a valtozo referenciaja
	 */
	public int getBlizzardFrequency() 
	{
		return this.blizzardFrequency;
	}

	/**
	 * getter a blizzardSize valtozohoz
	 * @return a valtozo referenciaja
	 */
	public int getBlizzardSize() 
	{
		return blizzardSize;
	}
	/**
	 * setter a blizzardSize valtozohoz
	 * @param blizzardSize a valtozo uj erteke
	 */
	public void setBlizzardSize(int blizzardSize) 
	{
		if (blizzardSize > 0 && blizzardSize < 11 )
			this.blizzardSize = blizzardSize;
		else
			System.out.println("A hovihar meret 1-tol 10-ig terjedhet ");
	}
	
	/**
	 * mentes fuggvenye
	 */
	public void save()
	{
		try {
	         FileOutputStream fileOut = new FileOutputStream("/tmp/icefield.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(this);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in /tmp/icefield.ser");
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}
	/**
	 * visszatoltes fuggvenye
	 * @return az eppen betoltendo mezovel
	 */
	public IceField load()
	{
		IceField iF = this;
		try {
	         FileInputStream fileIn = new FileInputStream("/tmp/icefield.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         iF = (IceField) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	         return iF;
	      } catch (ClassNotFoundException c) {
	         System.out.println("icefield class not found");
	         c.printStackTrace();
	         return iF;
	      }
		return iF;
	}
	/**
	 * kiirja a mezo adatait
	 */
	public void writeOut()
	{
		for(int i = 0; i < iceTables.size(); i++ )
		{
			System.out.print(i);
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
			System.out.println(")");
		}
	}
}

package libilabor;

import java.util.Random;
import java.util.ArrayList;

public class IceField {
	private ArrayList<IceTable> iceTables = new ArrayList<IceTable>();
	private boolean playerInWater = false;
	private ArrayList<Player> players = new ArrayList<Player>();
	private static int FrozenItemDrop = 6; // minel nagyobb a szam, annal kisebb az esely, hogy befagyott targy jon
											// letre
		
	public IceField(int height, int width) 
	{
		//Todo playerek
		for(int i = 0; i < 3; i++) {
			players.add(null);
		}
		if (height < 2 || width < 2) {
			System.out.println("Tul kicsi, a meret a lenyeg");
			return;
		}

		if (FrozenItemDrop < 1) {
			System.out.println("Ne szorakozz, allitsd vissza a FrozenItemDrop-ot 0-nal nagyobbra");
			return;
		}

		// veletlenszeru legyen a jegtabla tipusok generalasa
		Random rand = new Random();
		int randomTable = 0;

		// a jatekosok kiindulo pontja fixen stabil jegtabla
		StableTable firstTable = new StableTable();
		this.iceTables.add(firstTable);
		// jegmezo feltoltese jegtablakkal
		for (int i = 1; i < height * width; i++) {
			randomTable = rand.nextInt(3);

			switch (randomTable) {
			case 0:
				StableTable nextStableTable = new StableTable();
				iceTables.add(nextStableTable);
				break;
			case 1:
				// itt valtoztattam meg hogy a konstruktorban megoldja a randomizalt kapacitast
				UnstableTable nextUnstableTable = new UnstableTable(players.size());
				iceTables.add(nextUnstableTable);
				break;
			case 2:
				Hole nextHole = new Hole();
				iceTables.add(nextHole);
				break;
			default:
			}
		}
		// Szomszedok meghatarozasa
		
		ArrayList<IceTable> neighbours = new ArrayList<IceTable>();

		for (int i = 0; i < height * width; i++) {
			if (i % width != width - 1)
				neighbours.add(iceTables.get(i + 1));
			if (i % width != 0)
				neighbours.add(iceTables.get(i - 1));
			if (i < iceTables.size() - width)
				neighbours.add(iceTables.get(i + width));
			if (i > width - 1)
				neighbours.add(iceTables.get(i - width));
			iceTables.get(i).setNeighbours(neighbours);
			neighbours.clear();
			
		}
		
		// itemek elhelyezese
		// FlareGunParts elhelyezes:
		int FGPOnField = 0;
		while (FGPOnField <= 3) {
			int RandomNumber = rand.nextInt(height * width - 1);
			if (iceTables.get(RandomNumber).getFrozenItem() == null) {
				FlareGunPart flg = new FlareGunPart();
				iceTables.get(RandomNumber).setFrozenItem(flg);
				FGPOnField++;
			}
		}
		// random item lepakolas
		int ItemSetChance = rand.nextInt(FrozenItemDrop);
		int RandomItem = rand.nextInt(6);
		for (int i = 0; i < height * width; i++) {
			if (iceTables.get(i).getFrozenItem() != null) {
				if (ItemSetChance == 1) {
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
					default:
					}
				}
			}

		}
		

	}

	public void turn() {
		// hovihar erkezesenek a randomizalasahoz
		Random rand = new Random(); 
		boolean playerDrowning = false; // ha az elozo korben valaki vizbeesett buvarruha nelkul, akkor igaz
		boolean blizzardComing = false;
		int i = 0;
		while (i < players.size()) // mindegyik jatekosnak meghivja a step fuggvenyet, az utolso
									// jatekosnal ujrainditja a szamlalot
		{

			players.get(i).step();
			// ha elozo korben valaki vizbeesett, es meg ebben
			// a korben is benne van, akkor vege a jateknak
			if (playerInWater == true && playerDrowning == true) 
				endGame();

			playerDrowning = playerInWater;

			if (i < players.size()) // megnezi, hogy az utolso jaekosnal jar-e
				i++;
			else {
				i = 0;
				// ha az elozo korben jelezve lett, hogy erkezik hovihar, akkor ebben a
				// korben meghivja a blizzard fuggvenyt
				if (blizzardComing == true) 
					Blizzard();
				// 10% az esely arra, hogy kovetkezo korben hovihar jon
				if (rand.nextInt(10) == 4) 
					blizzardComing = true;
				else
					blizzardComing = false;
			}
		}
	}

	public void endGame() {
		System.out.println("megfulladt, haltatok");
	}

	public void Blizzard() {
		// hovihar meretenek es helyenek randomizalasahoz
		Random rand = new Random(); 
		// hovihar helyenek randomizalasa
		int randomTable = rand.nextInt(iceTables.size());
		// hovihar meretane aranya
		int randomBlizzardSize = rand.nextInt(6) + 1;
		// hovihar merete tablameret / arany
		int blizzardedTables = iceTables.size() / randomBlizzardSize; 
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

	public void setPlayerInWater(boolean b) {
		playerInWater = b;
		System.out.println("ember a vizben!!!");
	}
	
	public boolean getPalyerInWater() {
		
		return playerInWater;
	}
	public ArrayList<IceTable> getIceTables() {
		return iceTables;
	}

	public void setIceTables(ArrayList<IceTable> iceTables) {
		this.iceTables = iceTables;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	public void victory() {
		System.out.println("Gyozelem");
	}

}

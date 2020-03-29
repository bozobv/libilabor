package libilabor;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class IceField 
{
	ArrayList<IceTable> iceTables;
	boolean PlayerInWater = false; 
	ArrayList<Player> players;
	
	public IceField(int height, int width) 
	{
		if (height < 2 || width < 2)
		{
			System.out.println("Tul kicsi, a meret a lenyeg");
			return;
		}
		
		//veletlenszeru legyen a jegtabla tipusok generalasa
		Random rand = new Random();
		int randomTable = 0;
		
		//a jatekosok kiindulo pontja fixen stabil jegtabla
		StableTable firstTable = new StableTable();
		iceTables.add(firstTable);
		
		//jegmezo feltoltese jegtablakkal
		for (int i = 1; i < height * width; i++)
		{
			randomTable = rand.nextInt(3);
			
			switch (randomTable) 
			{
				case 0:
					StableTable nextStableTable = new StableTable();
					iceTables.add(nextStableTable);
					break;
				case 1:
					UnstableTable nextUnstableTable = new UnstableTable();
					iceTables.add(nextUnstableTable);
					break;
				case 2:
					Hole nextHole = new Hole();
					iceTables.add(nextHole);
					break;
				default: 
			}
		}
		
		//Szomszedok meghatarozasa
		
		ArrayList<IceTable> neighbours = new ArrayList<IceTable>();
		
		for (int i = 0; i < height * width; i++)
		{
			if ( i % width != width - 1)
				neighbours.add(iceTables.get(i + 1));
			if ( i % width != 0)
				neighbours.add(iceTables.get(i - 1));
			if ( i < iceTables.size() - width)
				neighbours.add(iceTables.get(i + width));
			if ( i > width - 1)
				neighbours.add(iceTables.get(i - width));
			neighbours.clear();
		}
		
		//itemek elhelyezese
		//FlareGunParts elhelyezés:
		int FGPOnField = 0;
		while(FGPOnField <= 3 )
		{
			int RandomNumber = rand.nextInt(height * width - 1);
			if ( iceTables.get(RandomNumber) == null )
			{
				//iceTables.get(RandomNumber).setItem();
			}
		}
		
		for (int i = 0; i < height * width; i++) {}
		
	}

	
	void Turn() 
	{
		Random rand = new Random(); 						//hóvihar érkezésének a randomizálásához
        boolean playerDrowning = false;						//ha az előző körben valaki vízbeesett búvárruha nélkül, akkor igaz
        boolean blizzardComing = false;		
		int i = 0;
		while (i < players.size())							//mindegyik játékosnak meghívja a step függvényét, az utolsó játékosnál újrainditja a számlálót
		{
			
			players.get(i).Step();
			if (PlayerInWater == true && playerDrowning == true)	//ha előző körben valaki vizbeesett, és még ebben a körben is benne van, akkor vége a játéknak
				EndGame();
			
			playerDrowning = PlayerInWater;
			
			if (i < players.size())							//megnézi, hogy az utolsó jáékosnál jár-e
				i++;
			else
			{
				i = 0;
				if (blizzardComing == true)					//ha az előző körben jelezve lett, hogy érkezik hóvihar, akkor ebben a körben meghívja a blizzard függvényt
					Blizzard();
				
				if (rand.nextInt(10) == 4)					//10% az esély arra, hogy következő körben hóvihar jön
					blizzardComing = true;
				else
					blizzardComing = false;
			}			
		}
	}
	
	void EndGame() 
	{
		System.out.println("megfulladt, haltatok"); 
	}
	
	void Blizzard() 
	{
		Random rand = new Random();															//hóvihar méretének és helyének randomizálásához
		int randomTable = rand.nextInt(iceTables.size());									//hóvihar helyének randomizálása
		int randomBlizzardSize = rand.nextInt(6) + 1;										//hóvihar méretáne aránya
		int blizzardedTables = iceTables.size() / randomBlizzardSize;						//hóvihar mérete táblaméret / arány
		
		if (randomTable + blizzardedTables > iceTables.size()) 								//meghívjuk az érintett táblákra a blizzardcomming függvényt
		{																					//abban az esetben, ha esetben, ha túlindexelődne a táblák listája, a másik irányba hívja meg a blizzard maradék részét
			for (int j = randomTable; j < iceTables.size(); j++)
			{
				iceTables.get(j).BlizzardComing();
			}
						
			for (int j = randomTable - 1; j >= iceTables.size() - blizzardedTables; j--)
			{
				iceTables.get(j).BlizzardComing();
			}
		}
		else 
		{
			for (int j = randomTable; j < randomTable + blizzardedTables; j++)				//ha nem indexelődik túl, akkor a random kiindulási ponttól fut le a hóvihar
			{
				iceTables.get(j).BlizzardComing();
			}
			
		}
	}
	
	void SetPlayerInWater(boolean b) 
	{
		PlayerInWater = b;
		System.out.println("ember a vizben!!!"); 
	}
	
	
	void Victory() 
	{
		System.out.println("Gyozelem"); 
	}

}

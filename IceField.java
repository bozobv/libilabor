package libilabor;
import java.util.Random;

import java.util.List;

public class IceField 
{
	List<IceTable> iceTables;
	boolean PlayerInWater = false; 
	List<Player> players;
	
	public IceField(int height, int width) 
	{
		Random rand = new Random();
		int randomTable = 0;
		
		StableTable firstTable = new StableTable();
		iceTables.add(firstTable);
		
		for (int i = 1; i < height * width; i++)
		{
			randomTable = rand.nextInt(3);
			randomSnowHeight = rand.nextInt(5);
		
			switch (randomTable) 
			{
				case 0:
					StableTable nextStableTable = new StableTable();
					iceTables.add(nextStableTable);
					break;
				case 1:
					UnstableTable nextUnstableTable = new UnstableTable();
					// itt valtoztattam meg hogy a konstruktorban megoldja a randomizalt kapacitast
					UnstableTable nextUnstableTable = new UnstableTable(players.size());
>>>>>>> branch 'master' of https://github.com/bozobv/libilabor.git
					iceTables.add(nextUnstableTable);
					break;
				case 2:
					Hole nextHole = new Hole();
					iceTables.add(nextHole);
					break;
				default: 
			}
		}
		
		//TODO: Szomszedok meghatarozasa
		for (int i = 0; i < width; i++)
		{
			
		}
		
		
		
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
				iceTables.get(j).blizzardComing();
			}
						
			for (int j = randomTable - 1; j >= iceTables.size() - blizzardedTables; j--)
			{
				iceTables.get(j).blizzardComing();
			}
		}
		else 
		{
			for (int j = randomTable; j < randomTable + blizzardedTables; j++)				//ha nem indexelődik túl, akkor a random kiindulási ponttól fut le a hóvihar
			{
				iceTables.get(j).blizzardComing();
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

package libilabor;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;


public class CommandHandler {

	
	private IceField testField;
	private int basicSnowHeight = 0;
	private int FrozenItemDrop = 0;

	public void handling() {
		boolean exit = false;
		Scanner scanner = new Scanner(System.in);
		while (!exit) {
			String input = scanner.nextLine();
			String[] inputWords = input.split(" ");

			switch (inputWords[0]) {
				case "exit":
					exit=true;
					break;
			case "move":
				this.move(inputWords[1], Integer.parseInt(inputWords[2]));
				break;
			case "rope":
				this.rope(inputWords[1], Integer.parseInt(inputWords[2]));
				break;
			case "dig":
				this.dig(inputWords[1]);
				break;
			case "scout":
				this.scout(inputWords[1], Integer.parseInt(inputWords[2]));
				break;
			case "save":
				this.save(inputWords[1]);
				break;
			case "load":
				this.load(inputWords[1]);
				break;
			case "add":
				switch (inputWords[1]) {
				case "player":
					this.addPlayer(inputWords[2], inputWords[3], Integer.parseInt(inputWords[4]));
					break;
				case "bear":
					this.addBear(Integer.parseInt(inputWords[2]));
					break;
				case "table":
					if (inputWords[2].equals("unstable"))
						this.addUnstableTable(Integer.parseInt(inputWords[3]));
					else
						this.addTable(inputWords[2]);
					break;
				case "item":
					this.addItem(inputWords[2], inputWords[3]);
					break;
				default:
					break;
				}
				break;
			case "blizzard":
				switch (inputWords[1]) {
				case "chance":
					this.blizzardChance(Integer.parseInt(inputWords[2]));
					break;
				case "size":
					this.blizzardSize(Integer.parseInt(inputWords[2]));
					break;
				default:
					break;
				}
				break;
			case "icefield":
				switch (inputWords[1]) {
				case "snow":
					this.iceFieldSnow(Integer.parseInt(inputWords[2]));
					break;
				case "items":
					this.iceFieldItem(Integer.parseInt(inputWords[2]));
					break;
				default:
					break;
				}
				break;
			case "create":

				if (inputWords[1] == "icefield")


					this.createIceField(inputWords[2], Integer.parseInt(inputWords[3]), Integer.parseInt(inputWords[4]));

					


				if (inputWords[1].equals("icefield"))
					if(inputWords[2].equals("empty"))
						this.createEmptyIceField();
					else {
					this.createIceField(inputWords[2], Integer.parseInt(inputWords[3]),Integer.parseInt(inputWords[4]));


					}

				break;

			case "set":
				switch (inputWords[1]) {
				case "nb":
					this.setNb(Integer.parseInt(inputWords[2]), Integer.parseInt(inputWords[3]));
					break;
				case "snow":
					this.setSnow(Integer.parseInt(inputWords[2]), Integer.parseInt(inputWords[3]));
					break;
				case "item":
					this.setItem(inputWords[2], Integer.parseInt(inputWords[3]));
					break;
				case "tent":
					this.setTent(inputWords[2]);
					break;
				case "work":
					this.setWork(Integer.parseInt(inputWords[2]), inputWords[3]);
					break;
				case "thp":
					this.setThp(Integer.parseInt(inputWords[2]), inputWords[3]);
					break;
				default:
					break;

				}
				break;

			case "table":
				if (inputWords[1].equals("stat"))
					this.tableStats(Integer.parseInt(inputWords[2]));
				break;

			case "destroy":
				if (inputWords[1].equals("item"))
					this.destroyItem(Integer.parseInt(inputWords[2]));
				break;
			case "get":
				if (inputWords[1].equals("nb"))
					this.getNb(Integer.parseInt(inputWords[2]));
				break;
			case "pick":
				if (inputWords[1].equals("up"))
					this.pickUp(inputWords[2]);
				break;
			case "remove":
				if (inputWords[1].equals("item"))
					this.removeItem(inputWords[2], inputWords[3]);
				break;
			case "character":
				if (inputWords[1].equals("stats"))
					this.characterStats(inputWords[2]);
				break;
			case "kill":
				switch (inputWords[1]) {
				case "character":
					this.killCharacter(inputWords[2]);
					break;
				case "bear":
					this.killBear(Integer.parseInt(inputWords[2]));
					break;
				default:
					break;
				}
				break;
			case "repair":
				if (inputWords[1].equals("flaregun"))
					this.repairFlareGun(inputWords[2]);
				break;
			case "build":
				if (inputWords[1].equals("igloo"))
					this.buildIgloo(inputWords[2]);
				break;

			case "call":
				if (inputWords[1].equals("blizzard"))
					this.callBlizzard(Integer.parseInt(inputWords[2]));
				break;
			}
			gameStance();
		}
		scanner.close();

	}	

	private void createEmptyIceField() 
	{
		testField = new IceField();
	}

	public Player searchPlayer(String name){
        for (int i=0;i<testField.getPlayers().size();i++){
            if(testField.getPlayers().get(i).getName().equals(name)){
                return testField.getPlayers().get(i);
            }
        }
        return null;
    }
		
	public void characterStats(String name)
	{
		searchPlayer(name).writeOut();
	}
	
	public void addPlayer(String type, String name, int index) {
		if (type.equals("eskimo")) {

			Eskimo newPlayer = new Eskimo(testField.getIceTables().get(index));
			newPlayer.setName(name);
			testField.getIceTables().get(index).getPlayersOnTable().add(newPlayer);
			testField.addPlayer(newPlayer);
			newPlayer.setCurrentTable(testField.getIceTables().get(index));

		} else if (type.equals("scientist")) {
			Scientist newPlayer = new Scientist(testField.getIceTables().get(index));
			newPlayer.setName(name);
			testField.getIceTables().get(index).getPlayersOnTable().add(newPlayer);
			testField.addPlayer(newPlayer);
			newPlayer.setCurrentTable(testField.getIceTables().get(index));
		} else {
			System.out.println("az elvárt bemenet: add player eskimo/scientist name index ");
		}

	}

	public void addBear(int index) {
		PolarBear bear = new PolarBear(testField.getIceTables().get(index));
		testField.getIceTables().get(index).getAnimalsOnTable().add(bear);
	}

	public void blizzardChance(int possibility) {
		testField.setBlizzardFrequency(possibility);
	}

	public void blizzardSize(int size) {
		testField.setBlizzardSize(size);
	}

	public void iceFieldSnow(int snowHeight) {
		basicSnowHeight = snowHeight;
		
	}

	public void iceFieldItem(int itemPossibility) {
		FrozenItemDrop = itemPossibility;
	}

	public void createIceField(String type, int height, int width) {
		Random rand = new Random();
		int h = rand.nextInt(10);
		int w = rand.nextInt(10);
		int d = rand.nextInt(10);
		int s = rand.nextInt(10);
		switch(type) {
		case "empty": testField = new IceField(); break;
		case "defined" : testField = new IceField(height, width, FrozenItemDrop, basicSnowHeight); break;
		case "random": testField = new IceField(h, w, d, s); break;
		default: break;
		}
		
	}
	public void addUnstableTable( int cap) {
		
		UnstableTable k = new UnstableTable(cap); 
		testField.getIceTables().add(k); 
		k.setIceField(testField);
		
	}
	
	public void addTable(String type) {
		switch(type) {
		case "stable": StableTable t = new StableTable(); testField.getIceTables().add(t); t.setIceField(testField); ; break;
		case "hole": Hole h = new Hole(); testField.getIceTables().add(h);h.setIceField(testField); break;
		}
	}

	public void setNb(int index1, int index2) {
		if (index1 > testField.getIceTables().size() || index2 > testField.getIceTables().size() )
		{
			System.out.println("nincs ilyen indexu tabla");
		}
        ArrayList<IceTable> i1 = testField.getIceTables().get(index1).getNeighbours();
        for(int i = 0; i < i1.size(); i++)
        {
        	if (i1.get(i) == testField.getIceTables().get(index2))
        		return;
        }
        i1.add(testField.getIceTables().get(index2));
        ArrayList<IceTable> i2 = testField.getIceTables().get(index2).getNeighbours();
        i2.add(testField.getIceTables().get(index1));
	    testField.getIceTables().get(index1).setNeighbours(i1);
	    testField.getIceTables().get(index2).setNeighbours(i2);
	}

	public void setSnow(int index, int height) {
		testField.getIceTables().get(index).setSnowHeight(height);
	}

	public void tableStats(int index) {
		System.out.print(index);
		testField.getIceTables().get(index).writeOut();
	}

	public void setItem(String type, int index) {
		switch (type) {
		case "fg":
			this.testField.getIceTables().get(index).setFrozenItem(new FlareGunPart());
			break;
		case "r":
			this.testField.getIceTables().get(index).setFrozenItem(new Rope());
			break;
		case "sc":
			this.testField.getIceTables().get(index).setFrozenItem(new ScubaSuit());
			break;
		case "s":
			this.testField.getIceTables().get(index).setFrozenItem(new Shovel());
			break;
		case "ws":
			this.testField.getIceTables().get(index).setFrozenItem(new WeakShovel());
			break;
		case "t":
			this.testField.getIceTables().get(index).setFrozenItem(new Tent());
			break;
		default:
			break;

		}
	}

	public void destroyItem(int index) {
		testField.getIceTables().get(index).setFrozenItem(null);
	}

	public void getNb(int index) {

		System.out.print("(");
		ArrayList<IceTable> nbs = testField.getIceTables().get(index).getNeighbours();
		for (int j = 0; j < nbs.size(); j++) {
			for (int k = 0; k < testField.getIceTables().size(); k++) {
				if (nbs.get(j) == testField.getIceTables().get(k))
					System.out.print(k + ", ");
			}
		}
		System.out.print(")");

	}

	public void move(String name, int index) {
		Player player= searchPlayer(name);
		IceTable temp=null;
		for (IceTable it : player.getCurrentTable().getNeighbours()) {
			if(it==testField.getIceTables().get(index))temp=it;
		}
		if(temp!=null) {
			player.move(temp);
		}
	}

	public void pickUp(String name) {
		searchPlayer(name).pickUp();
	}

	public void addItem(String type, String name) {

		Storable item;
		switch(type){
			case "flaregun":
				item=new FlareGunPart();break;
			case "rope":
				item=new Rope();break;
			case "scubasuit":
				item=new ScubaSuit();break;
			case "shovel":
				item=new Shovel();break;
			case "weakshovel":
				item=new WeakShovel();break;
			case "tent":
				item=new Tent();break;
			default:
				System.out.println("Helytelen parameter!");
				item=null;break;
		}
		if(item!=null){
			searchPlayer(name).addToInventory(item);
		}

	}

	public void removeItem(String type, String name) {

		int idx;
		switch(type){
			case "fg":
				idx=0;break;
			case "r":
				idx=1;break;
			case "sc":
				idx=2;break;
			case "s":
			case "ws":
				idx=3;break;
			case "t":
				idx=4;break;
			default:
				System.out.println("Helytelen parameter!");
				idx=-1;break;
		}
		if(idx>0){
			searchPlayer(name).removeFromInventory(idx);
		}

	}

	public void killCharacter(String name) {
		searchPlayer(name).getCurrentTable().removePlayer(searchPlayer(name));

	}

	public void dig(String name) {
		for (Player player : this.testField.getPlayers()){
			if(player.getName().equals(name))player.dig();
		}
	}
	public void rope(String name, int index) {
		searchPlayer(name).useItem(1,index);

	}

	public void setTent(String name) {
		for (Player player : this.testField.getPlayers()){
			if(player.getName().equals(name))player.useItem(4,0);
		}
	}

	public void repairFlareGun(String name) {
		searchPlayer(name).useItem(0,0);
	}

	public void buildIgloo(String name) {
		for (Player player : this.testField.getPlayers()) {
			if (player.getName().equals(name))
				player.useSkill(player.getCurrentTable());
		}
	}

	public void scout(String name, int index) {
		searchPlayer(name).useSkill(this.testField.getIceTables().get(index));
	}

	public void setThp(int thp, String name) {

		for(int i = 0; i<testField.getPlayers().size();i++) {
			if(testField.getPlayers().get(i).getName().equals(name)) {

				testField.getPlayers().get(i).setThp(thp);
				return;
			}
		}


	}

	public void setWork(int work, String name) {

		for(int i = 0; i<testField.getPlayers().size();i++) {
			if(testField.getPlayers().get(i).getName().equals(name)) {

				testField.getPlayers().get(i).setWork(work);
				return;
			}
		}

	}

	public void callBlizzard(int size) {
		testField.Blizzard(size);
	}

	public void save(String saveFileName) {
		testField.save();
	}

	public void load(String saveFileName) {
		testField = testField.load();
	}


	public void killBear(int index) {
		PolarBear removedAnimal = testField.getIceTables().get(index).getAnimalsOnTable().get(0);
		ArrayList<PolarBear> testAnimals = testField.getAnimal();
		for (int i = 0; i < testAnimals.size(); i++) {
			if (testAnimals.get(i) == removedAnimal)
				testAnimals.remove(i);
		}

	}

	public void gameStance() {
		if(testField!=null){
			testField.writeOut();
		}
	}
}

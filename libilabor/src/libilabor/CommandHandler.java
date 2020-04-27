package libilabor;

import java.util.Random;
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
			String commandPart = inputWords[0];

			switch (inputWords[0]) {
			case "move":
				this.move(Integer.parseInt(inputWords[1]));
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
				this.save(inputWords[1]);
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
					this.createIceField(inputWords[2], Integer.parseInt(inputWords[3]),
							Integer.parseInt(inputWords[4]));
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
			default:
				break;
			}
		}
		scanner.close();

	}	

	public Player searchPlayer(String name){
        for (int i=0;i<testField.getPlayers().size();i++){
            if(testField.getPlayers().get(i).getName().equals(name)){
                return testField.getPlayers().get(i);
            }
        }
        return null;
    }
		

	public void addPlayer(String type, String name, int index) {
		if (type.equals("eskimo")) {

			Eskimo newPlayer = new Eskimo(testField.getIceTables().get(index));
			newPlayer.setName(name);
			testField.getIceTables().get(index).playerVisit(newPlayer);
			testField.addPlayer(newPlayer);

			Eskimo newPalyer = new Eskimo(testField.getIceTables().get(index));
			newPalyer.setName(name);
			testField.getIceTables().get(index).playerVisit(newPalyer);

		} else if (type.equals("scientist")) {
			Scientist newPlayer = new Scientist(testField.getIceTables().get(index));
			newPlayer.setName(name);
			testField.getIceTables().get(index).playerVisit(newPlayer);
			testField.addPlayer(newPlayer);
		}
		else 
		{
			System.out.println("az elvárt bemenet: add player eskimo/scientist name index ");
		}

	}

	public void addBear(int index) {
		PolarBear bear = new PolarBear();
		bear.setCurrentTable(testField.getIceTables().get(index));
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

	public void addTable(String type) {
		switch(type) {
		case "stable": StableTable t = new StableTable(); testField.getIceTables().add(t); break;
		case "unstable": UnstableTable k = new UnstableTable(testField.getPlayers().size()); testField.getIceTables().add(k); 
						 break;
		case "hole": Hole h = new Hole(); testField.getIceTables().add(h); break;
		}
	}

	public void setNb(int index1, int index2) {
	}

	public void setSnow(int index, int height) {
	}

	public void tableStats(int index) {
	}

	public void setItem(String type, int index) {
		switch (type) {
		case "FlarGunPart":
			this.testField.getIceTables().get(index).setFrozenItem(new FlareGunPart());
			break;
		case "Rope":
			this.testField.getIceTables().get(index).setFrozenItem(new Rope());
			break;
		case "ScubaSuit":
			this.testField.getIceTables().get(index).setFrozenItem(new ScubaSuit());
			break;
		case "Shovel":
			this.testField.getIceTables().get(index).setFrozenItem(new Shovel());
			break;
		case "Tent":
			this.testField.getIceTables().get(index).setFrozenItem(new Tent());
			break;
		default:
			break;

		}
	}

	public void destroyItem(int index) {
		testField.getIceTables().get(index).setItem(null);
	}

	public void getNb(int index) {
	}

	public void move(int index) {
	}

	public void pickUp(String name) {

	}

	public void addItem(String type, String name) {
	}

	public void removeItem(String type, String name) {
	}

	public void killCharacter(String name) {
	}

	public void dig(String name) {
		for (Player player : this.testField.getPlayers()) {
			if (player.getName().equals(name))
				player.dig();
		}
	}

	public void rope(String name, int index) {
	}

	public void setTent(String name) {
		for (Player player : this.testField.getPlayers()) {
			if (player.getName().equals(name))
				player.useItem(4);
		}
	}

	public void repairFlareGun(String name) {
	}

	public void buildIgloo(String name) {
		for (Player player : this.testField.getPlayers()) {
			if (player.getName().equals(name))
				player.useSkill();
		}
	}

	public void scout(String name, int index) {
	}

	public void setThp(int thp, String name) {
	}

	public void setWork(int work, String name) {
	}

	public void callBlizzard(int size) 
	{
		testField.Blizzard(size);
	}

	public void save(String saveFileName) {
		testField.save();
	}

	public void load(String saveFileName) {
		testField = testField.load();
	}

	public void killBear(int index) 
	{
	}

	public void gameStance() {
		testField.writeOut();
	}
}

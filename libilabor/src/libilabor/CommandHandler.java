package libilabor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class CommandHandler {

	private IceField testField;

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
					this.addTable(inputWords[2], Integer.parseInt(inputWords[3]));
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
					this.blizzardChance(Integer.parseInt(inputWords[2]));
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
					this.iceFieldItem(Double.parseDouble(inputWords[2]));
					break;
				default:
					break;
				}
				break;
			case "create":
				if (inputWords[1].equals("icefield"))
					this.createIceFiled(inputWords[2], Integer.parseInt(inputWords[3]),
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
					this.callBlizzard(Double.parseDouble(inputWords[2]));
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
		if(type.equals("eskimo")){

			Eskimo newPlayer = new Eskimo(testField.getIceTables().get(index));
			newPlayer.setName(name);
			testField.getIceTables().get(index).playerVisit(newPlayer);
			testField.addPlayer(newPlayer);

			Eskimo newPalyer = new Eskimo(testField.getIceTables().get(index));
			newPalyer.setName(name);
			testField.getIceTables().get(index).playerVisit(newPalyer);
		}
		else if(type.equals("scientist")) {
			Scientist newPlayer = new Scientist(testField.getIceTables().get(index));
			newPlayer.setName(name);
			testField.getIceTables().get(index).playerVisit(newPlayer);
			testField.addPlayer(newPlayer);
		}

	}

	public void addBear(int index) {
		PolarBear bear = new PolarBear();
		bear.setCurrentTable(testField.getIceTables().get(index));
		testField.getIceTables().get(index).getAnimalsOnTable().add(bear);
	}

	public void blizzardChance(double possibility) {
	}

	public void blizzardSize(String size) {
	}

	public void iceFieldSnow(int snowHeight) {
	}

	public void iceFieldItem(double itemPossibility) {
	}

	public void createIceFiled(String type, int height, int width) {
	}

	public void addTable(String type, int index) {
	}

	public void setNb(int index1, int index2) {
        ArrayList<IceTable> i1=testField.getIceTables().get(index1).getNeighbours();
        i1.add(testField.getIceTables().get(index1));
        ArrayList<IceTable> i2=testField.getIceTables().get(index2).getNeighbours();
        i2.add(testField.getIceTables().get(index2));
	    testField.getIceTables().get(index1).setNeighbours(i2);
	    testField.getIceTables().get(index2).setNeighbours(i1);
	}

	public void setSnow(int index, int height) {
	    testField.getIceTables().get(index).setSnowHeight(height);
	}

	public void tableStats(int index) {
	}

	public void setItem(String type, int index) {
	}

	public void destroyItem(int index) {
		testField.getIceTables().get(index).setItem(null);
	}

	public void getNb(int index) {
	}

	public void move(int index) {
	}

	public void pickUp(String name) {
		searchPlayer(name).pickUp();
	}

	public void addItem(String type, String name) {
		Storable item;
		switch(type){
			case "fg":
				item=new FlareGunPart();break;
			case "r":
				item=new Rope();break;
			case "sc":
				item=new ScubaSuit();break;
			case "s":
				item=new Shovel();break;
			case "ws":
				item=new WeakShovel();break;
			case "t":
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
    //nem tudunk a rope used-jának infokat adni inne, mindenképp szükséges plusz felhasználói interakció
    //ezek mellett felesleges az indexet átadni a függvénynek
	public void rope(String name, int index) {
	    searchPlayer(name).useItem(1);
	}

	public void setTent(String name) {
		for (Player player : this.testField.getPlayers()){
			if(player.getName().equals(name))player.useItem(4);
		}
	}

	public void repairFlareGun(String name) {
	    searchPlayer(name).useItem(0);
	}

	public void buildIgloo(String name) {
	}

	public void scout(String name, int index) {
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

	public void callBlizzard(double possibility) {
	}

	public void save(String saveFileName)
	{
		testField.save();
	}

	public void load(String saveFileName)
	{
		testField = testField.load();
	}

	public void killBear(int index) {
	}

	public void gameStance() {
		testField.writeOut();
	}
}

package libilabor;

import java.util.Scanner;

public class CommandHandler {
	
	private IceField testField;

	public void handling() {
		boolean exit = false;
		Scanner scanner = new Scanner(System.in);
		while (!exit) {
			String input = scanner.nextLine();
			String[] inputWords =  input.split(" ");
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
			case "add player":
				this.addPlayer(inputWords[2], inputWords[3], Integer.parseInt(inputWords[4]));
				break;
			case "add bear":
				this.addBear(Integer.parseInt(inputWords[2]));
				break;
			case "blizzard chance":
				this.blizzardChance(Integer.parseInt(inputWords[2]));
				break;
			case "blizzard size":
				this.blizzardChance(Integer.parseInt(inputWords[2]));
				break;
			case "icefield snow":
				this.iceFieldSnow(Integer.parseInt(inputWords[2]));
				break;
			case "icefield items":
				this.iceFieldItem(Double.parseDouble(inputWords[2]));
				break;
			case "create icefield":
				this.createIceFiled(inputWords[2], Integer.parseInt(inputWords[3]), Integer.parseInt(inputWords[4]));
				break;
			case "add table":
				this.addTable(inputWords[2], Integer.parseInt(inputWords[3]));
				break;
			case "set nb":
				this.setNb(Integer.parseInt(inputWords[2]), Integer.parseInt(inputWords[3]));
				break;
			case "set snow":
				this.setSnow(Integer.parseInt(inputWords[2]), Integer.parseInt(inputWords[3]));
				break;
			case "table stat":
				this.tableStats(Integer.parseInt(inputWords[2]));
				break;
			case "set item":
				this.setItem(inputWords[2], Integer.parseInt(inputWords[3]));
				break;
			case "destroy item":
				this.destroyItem(Integer.parseInt(inputWords[2]));
				break;
			case "get nb":
				this.getNb(Integer.parseInt(inputWords[2]));
				break;
			case "pick up":
				this.pickUp(inputWords[2]);
				break;
			case "add item":
				this.addItem(inputWords[2], inputWords[3]);
				break;
			case "remove item":
				this.removeItem(inputWords[2], inputWords[3]);
				break;
			case "kill character":
				this.killCharacter(inputWords[2]);
				break;
			case "kill bear":
				this.killBear(Integer.parseInt(inputWords[2]));
				break;
			case "set tent":
				this.setTent(inputWords[2]);
				break;
			case "repair flaregun":
				this.repairFlareGun(inputWords[2]);
				break;
			case "build igloo":
				this.buildIgloo(inputWords[2]);
				break;
			case "set thp":
				this.setThp(Integer.parseInt(inputWords[2]), inputWords[3]);
				break;
			case "set work":
				this.setWork(Integer.parseInt(inputWords[2]), inputWords[3]);
				break;
			case "call blizzard":
				this.callBlizzard(Double.parseDouble(inputWords[2]));
				break;
			default: break;
			}
		}
		scanner.close();

	}
	
	public void addPlayer(String type, String name,  int index) {}
	public void addBear(int index) {}
	public void blizzardChance(double possibility) {}
	public void blizzardSize(String size) {}
	public void iceFieldSnow(int snowHeight) {}
	public void iceFieldItem(double itemPossibility) {}
	public void createIceFiled(String type, int height, int width) {}
	public void addTable(String type, int index) {}
	public void setNb(int index1, int index2) {}
	public void setSnow(int index, int height) {}
	public void tableStats(int index) {}
	public void setItem(String type, int index) {}
	public void destroyItem(int index) {}
	public void getNb(int index) {}
	public void move(int index) {}
	public void pickUp(String name) {}
	public void addItem(String type, String name) {}
	public void removeItem(String type, String name) {}
	public void killCharacter(String name) {}
	public void dig(String name) {}
	public void rope(String name, int index) {}
	public void setTent(String name) {}
	public void repairFlareGun(String name) {}
	public void buildIgloo(String name) {}
	public void scout(String name, int index) {}
	public void setThp(int thp, String name) {}
	public void setWork(int work, String name) {}
	public void callBlizzard(double possibility) {}
	public void save(String saveFileName) {}
	public void load(String saveFileName) {}
	public void killBear(int index) {}
	
	public void gameStance()
	{
		
	}
}
	
	

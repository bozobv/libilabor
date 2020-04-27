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
			if(commandPart.equals("move")) {
				this.move(Integer.parseInt(inputWords[1]));
			}
			else if(commandPart.equals("rope")) {
				this.rope(inputWords[1], Integer.parseInt(inputWords[2]));
			}
			else if(commandPart.equals("dig")) {
				this.dig(inputWords[1]);
			}
			else if(commandPart.equals("scout")) {
				this.scout(inputWords[1], Integer.parseInt(inputWords[2]));
			}
			else if(commandPart.equals("save")) {
				this.save(inputWords[1]);
			}
			else if(commandPart.equals("load")) {
				this.save(inputWords[1]);
			}
			else if(commandPart.concat(inputWords[1]).equals("add player")) {
				this.addPlayer(inputWords[2], inputWords[3], Integer.parseInt(inputWords[4]));				
			}
			else if(commandPart.concat(inputWords[1]).equals("add bear")) {
				this.addBear(Integer.parseInt(inputWords[2]));
			}
			else if(commandPart.concat(inputWords[1]).equals("blizzard chance")) {
				this.blizzardChance(Integer.parseInt(inputWords[2]));
			}
			else if(commandPart.concat(inputWords[1]).equals("blizzard size")) {
				this.blizzardChance(Integer.parseInt(inputWords[2]));
			}
			else if(commandPart.concat(inputWords[1]).equals("icefield snow")) {
				this.iceFieldSnow(Integer.parseInt(inputWords[2]));
			}
			else if(commandPart.concat(inputWords[1]).equals("icefield items")) {
				this.iceFieldItem(Double.parseDouble(inputWords[2]));
			}
			else if(commandPart.concat(inputWords[1]).equals("create icefield")) {
				this.createIceFiled(inputWords[2], Integer.parseInt(inputWords[3]), Integer.parseInt(inputWords[4]));
			}
			else if(commandPart.concat(inputWords[1]).equals("add table")) {
				this.addTable(inputWords[2], Integer.parseInt(inputWords[3]));
			}
			else if(commandPart.concat(inputWords[1]).equals("set nb")) {
				this.setNb(Integer.parseInt(inputWords[2]), Integer.parseInt(inputWords[3]));
			}
			else if(commandPart.concat(inputWords[1]).equals("set snow")) {
				this.setSnow(Integer.parseInt(inputWords[2]), Integer.parseInt(inputWords[3]));
			}
			else if(commandPart.concat(inputWords[1]).equals("table stat")) {
				this.tableStats(Integer.parseInt(inputWords[2]));
			}
			else if(commandPart.concat(inputWords[1]).equals("set item")) {
				this.setItem(inputWords[2], Integer.parseInt(inputWords[3]));
			}
			else if(commandPart.concat(inputWords[1]).equals("destroy item")) {
				this.destroyItem(Integer.parseInt(inputWords[2]));
			}
			else if(commandPart.concat(inputWords[1]).equals("get nb")) {
				this.getNb(Integer.parseInt(inputWords[2]));
			}
			else if(commandPart.concat(inputWords[1]).equals("pick up")) {
				this.pickUp(inputWords[2]);
			}
			else if(commandPart.concat(inputWords[1]).equals("add item")) {
				this.addItem(inputWords[2], inputWords[3]);
			}
			else if(commandPart.concat(inputWords[1]).equals("remove item")) {
				this.removeItem(inputWords[2], inputWords[3]);
			}
			else if(commandPart.concat(inputWords[1]).equals("kill character")) {
				this.killCharacter(inputWords[2]);
			}
			else if(commandPart.concat(inputWords[1]).equals("kill bear")) {
				this.killBear(Integer.parseInt(inputWords[2]));
			}
			else if(commandPart.concat(inputWords[1]).equals("set tent")) {
				this.setTent(inputWords[2]);
			}
			else if(commandPart.concat(inputWords[1]).equals("repair flaregun")) {
				this.repairFlareGun(inputWords[2]);
			}
			else if(commandPart.concat(inputWords[1]).equals("build igloo")) {
				this.buildIgloo(inputWords[2]);
			}
			else if(commandPart.concat(inputWords[1]).equals("set thp")) {
				this.setThp(Integer.parseInt(inputWords[2]), inputWords[3]);
			}
			else if(commandPart.concat(inputWords[1]).equals("set work")) {
				this.setWork(Integer.parseInt(inputWords[2]), inputWords[3]);
			}
			else if(commandPart.concat(inputWords[1]).equals("call blizzard")) {
				this.callBlizzard(Double.parseDouble(inputWords[2]));
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


package libilabor;


import java.util.Scanner;

public class CommandHandler {

	public void handling() {
		boolean exit = false;
		Scanner scanner = new Scanner(System.in);
		while (!exit) {
			String input = scanner.nextLine();
			String[] inputWords =  input.split(" ");
			String commandPart = inputWords[0];
			if(commandPart.equals("rope")) {
				
			}

		}

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
	

	public void gameStance()
	{
		
	}
}


package libilabor;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Player extends Character 
{
	private static final int INVENTORY_STARTING_SIZE=4;
	public static int id=0;
	
	
	
	private String Name;
	private int thp;
	private int work;
	private Storable[] inventory;
	

	
	public Player(String name, int thp, int work, IceTable currentTable) {
		super();
		Name = name;
		this.thp = thp;
		this.work = work;
		this.inventory = new Storable[INVENTORY_STARTING_SIZE];
	}

	//TODO ha meghal valaki, akkor az IceField EndGame fuggvenyet kell meghivni, de nem ismeri az IceFieldet
	public void step() {
		Scanner input = new Scanner(System.in);
		System.out.print("Mit akarsz csinalni:\n" + "0: Mozgas\n" + "1: Asas\n" + "2: Targy felvetle\n"
				+ "3: Kepesseg hasznalata\n" + "4: Targy hasznalata\n" + "5: Raketa javitasa\n" + "6: Semmit");
		int player_choice = input.nextInt();
		while (this.work > 0) {
			switch (player_choice) {
			case 0:
				move();
				break;
			case 1:
				dig();
				break;
			case 2:
				pickUp();
				break;
			case 3:
				useSkill(this.getCurrentTable());
				break;
			case 4:
				Scanner scanner = new Scanner(System.in);
				System.out.print("Melyik itemet akarod hasznalni?:\n" + "0: FlarGunPart\n" + "1:Rope\n"
						+ "2:ScubaSuit\n" + "3:Shovel\n" + "4:Tent\n");
				int ch = input.nextInt();
				useItem(ch);
				scanner.close();
				break;
			case 5:
				repairFlareGun();
				break;
			case 6:
				break;
			}
			work--;
		}
		input.close();
	}		
	
	public void move(){
		ArrayList<IceTable> neighbours=this.currentTable.getNeighbours();
		System.out.println("Irja be melyik szomszedjara akar lepni (szamot irjon) ");
		Scanner scanner = new Scanner(System.in);
		int answer = Integer.valueOf(scanner.nextLine());
		if (answer >= neighbours.size())
		{
			System.out.println("nincs ilyen szomszed");
			scanner.close();
			return;
		}
		neighbours.get(answer).playerVisit(this);
		scanner.close();
	}

	public void useItem(int player_choice){
		if(inventory[player_choice]!=null)inventory[player_choice].used(this);
	}
	
	public abstract void useSkill(IceTable t);
	
	
	public void dig(){
		if(inventory[3]!=null) inventory[3].used(this);
		else currentTable.setSnowHeight(currentTable.getSnowHeight()-1);	
	}
	
	public void pickUp(){
		if(currentTable.getSnowHeight()>0)return;
		Item frozenitem=currentTable.getFrozenItem();
		if(inventory[frozenitem.getId()]==null) {
			frozenitem.pickedUpBy(this);
		}
	}
	public void addToInventory(Storable s){
		if(inventory[s.getId()]==null) {
			inventory[s.getId()]=s;
			currentTable.setFrozenItem(null);
		}
	}

	public void repairFlareGun() {
		currentTable.checkFlareGunPart();
	}
	
	public void fallInHole() {
		work=0;
	}
	
	//Setters&Getters
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getThp() {
		return thp;
	}

	public void setThp(int thp) {
		this.thp = thp;
		//ha thp egy ala csokken, a jateknak vege
		if (thp < 1)
			currentTable.getIceField().endGame();
	}

	public int getWork() {
		return work;
	}

	public void setWork(int work) {
		this.work = work;
	}
	@Override
	public void setCurrentTable(IceTable currenttable){
		this.currentTable.removePlayer(this);
		this.currentTable=currenttable;
		currenttable.getPlayersOnTable().add(this);
	}

	public Storable[] getInventory() {
		return inventory;
	}

	public void setInventory(Storable[] inventory) {
		this.inventory = inventory;
	}

	public void removeFromInventory(int idx) {
		inventory[idx]=null;
	}
	public void attacked(){
		getCurrentTable().getIceField().endGame();
	}

	public abstract void writeOut();


}

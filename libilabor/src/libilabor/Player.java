package libilabor;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Player 
{
	private static final int INVENTORY_STARTING_SIZE=4;
	public static int id=0;
	
	
	
	private String Name;
	private int thp;
	private int work;
	private IceTable currentTable;
	private Storable[] inventory;
	

	
	public Player(String name, int thp, int work, IceTable currentTable) {
		super();
		Name = name;
		this.thp = thp;
		this.work = work;
		this.currentTable = currentTable;
		this.inventory = new Storable[INVENTORY_STARTING_SIZE];
	}

	//TODO ha meghal valaki, akkor az IceField EndGame fuggvenyet kell meghivni, de nem ismeri az IceFieldet
	public void step() {
		Scanner input = new Scanner( System.in );
		System.out.print( "Mit akarsz csin�lni:\n"+ 
				"0: Mozg�s\n" + 
				"1: �s�s\n" + 
				"2: T�rgy felv�tle\n" + 
				"3: K�pess�g haszn�lata\n" + 
				"4: T�rgy haszn�lata\n" + 
				"5: Rak�ta jav�t�sa\n"+
				"6: Semmit");
		int player_choice =  input.nextInt();
		while(this.work>0) {
			switch(player_choice) {
			case 0: move();
			case 1: dig();
			case 2: pickUp();
			case 3: useSkill();
			case 4: useItem();
			case 5: repairFlareGun();
			case 6: break;
			}
			work--;
		}
		input.close();
	}		
	
	public void move(){
		ArrayList<IceTable> neighbours=this.currentTable.getNeighbours();
		//TODO: valami konzolos valaszto rendszer implementalasa
		int player_choice=0;
		neighbours.get(player_choice).playerVisit(this);
	}
	
	public void useItem(){
		Scanner input = new Scanner( System.in );
		System.out.print( "Melyik itemet akarod haszn�lni?:\n"+ 
				"0: FlarGunPart\n"+
				"1:Rope\n"+
				"2:ScubaSuit\n"+
				"3:Shovel\n");
		int player_choice =  input.nextInt();
		if(inventory[player_choice]!=null)inventory[player_choice].used(this);
		input.close();
	}
	
	public abstract void useSkill();
	
	
	public void dig(){
		if(inventory[3]!=null) currentTable.setSnowHeight(currentTable.getSnowHeight()-2);
		else currentTable.setSnowHeight(currentTable.getSnowHeight()-1);	
	}
	
	public void pickUp(){
		if(currentTable.getSnowHeight()>=0)return;
		Item frozenitem= currentTable.getFrozenItem();
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
	}

	public int getWork() {
		return work;
	}

	public void setWork(int work) {
		this.work = work;
	}

	public IceTable getCurrentTable() {
		return currentTable;
	}

	public void setCurrentTable(IceTable currentTable) {
		this.currentTable.removePlayer(this);
		this.currentTable = currentTable;
	}

	public Storable[] getInventory() {
		return inventory;
	}

	public void setInventory(Storable[] inventory) {
		this.inventory = inventory;
	}
	
}

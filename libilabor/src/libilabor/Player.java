package libilabor;

import java.util.ArrayList;

public abstract class Player 
{
	private static final int inventoryStartingSize=4;
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
		this.inventory = new Storable[inventoryStartingSize];
	}

	//ha meghal valaki, akkor az IceField EndGame fuggvenyet kell meghivni, de nem ismeri az IceFieldet
	public void Step() {
		//TODO: valami konzolos valaszto rendszer implementalasa
		int player_choice = 0;
		while(this.work>0) {
			switch(player_choice) {
			case 0: Move();
			case 1: Dig();
			case 2: PickUp();
			case 3: UseSkill();
			case 4: UseItem();
			case 5: RepairFlareGun();
			case 6: break;
			}
			work--;
		}
	}		
	
	public void Move(){
		ArrayList<IceTable> neighbours=this.currentTable.getNeighbours();
		//TODO: valami konzolos valaszto rendszer implementalasa
		int player_choice=0;
		neighbours.get(player_choice).PlayerVisit(this);
	}
	
	
	//TODO: tisztazni kene a nevet mert mashogy van szekvencian
	public void UseItem(){
		
	}
	
	public abstract void UseSkill();
	
	
	public void Dig(){
		//TODO: aso inventory helyenek beirasa
		if(inventory[0]!=null) currentTable.setSnowHeight(currentTable.getSnowHeight()-2);
		else currentTable.setSnowHeight(currentTable.getSnowHeight()-1);	
	}
	
	public void PickUp(){
		if(currentTable.getSnowHeight()>=0)return;
		
		Item frozenitem= currentTable.getFrozenItem();
		
		//TODO: inventory slot mechanizmus implementálása
		if(inventory[0]==null) {
			frozenitem.PickedUpBy(this);
		}
	}
	
	public void AddToInventory(Storable s){
		//TODO: helyes indexeles
		if(inventory[0]==null) {
			inventory[0]=s;
			currentTable.setFrozenItem(null);
		}
	}

	public void RepairFlareGun() {
		currentTable.CheckFlareGunPart();
	}
	
	public void FallInHole () {
		
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
		this.currentTable = currentTable;
	}

	public Storable[] getInventory() {
		return inventory;
	}

	public void setInventory(Storable[] inventory) {
		this.inventory = inventory;
	}
	
}

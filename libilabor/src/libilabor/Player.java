package libilabor;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Player extends Character implements java.io.Serializable {
	private static final int INVENTORY_STARTING_SIZE = 5;
	public static int id = 0;

	private String Name;
	private int thp;
	private int work;
	private Storable[] inventory;

	public Player(String name, int thp, int work, IceTable currentTable) {
		super(currentTable);
		Name = name;
		this.thp = thp;
		this.work = work;
		this.inventory = new Storable[INVENTORY_STARTING_SIZE];
	}

	// TODO ha meghal valaki, akkor az IceField EndGame fuggvenyet kell meghivni, de
	// nem ismeri az IceFieldet
	/*
	 * public void step() { Scanner input = new Scanner(System.in);
	 * System.out.print("Mit akarsz csinalni:\n" + "0: Mozgas\n" + "1: Asas\n" +
	 * "2: Targy felvetle\n" + "3: Kepesseg hasznalata\n" + "4: Targy hasznalata\n"
	 * + "5: Raketa javitasa\n" + "6: Semmit"); int player_choice = input.nextInt();
	 * while (this.work > 0) { switch (player_choice) { case 0: move(); break; case
	 * 1: dig(); break; case 2: pickUp(); break; case 3:
	 * useSkill(this.getCurrentTable()); break; case 4: Scanner scanner = new
	 * Scanner(System.in); System.out.print("Melyik itemet akarod hasznalni?:\n" +
	 * "0: FlarGunPart\n" + "1:Rope\n" + "2:ScubaSuit\n" + "3:Shovel\n" +
	 * "4:Tent\n"); int ch = input.nextInt(); useItem(ch); scanner.close(); break;
	 * case 5: repairFlareGun(); break; case 6: break; } work--; } input.close(); }
	 */

	public void move(IceTable it) {
		ArrayList<IceTable> neighbours = this.getCurrentTable().getNeighbours();
		for (IceTable iceTable : neighbours) 
		{
			if (it == iceTable && this.work > 0)
				iceTable.playerVisit(this);
		}
	}

	public void useItem(int player_choice,int idx)
	{
		if (inventory[player_choice] != null)
			inventory[player_choice].used(this,idx);
	}

	public abstract void useSkill(IceTable t);

	public void dig() {
		if (inventory[3] != null) {
			inventory[3].used(this,0);
		} else {
			this.getCurrentTable().setSnowHeight(this.getCurrentTable().getSnowHeight() - 1);
		}
	}
	
	/**
	 * 
	 */
	public void pickUp(){
		if(this.getCurrentTable().getSnowHeight()>0)return;
		Item frozenitem=this.getCurrentTable().getFrozenItem();
		if(inventory[frozenitem.getId()]==null) {
			frozenitem.pickedUpBy(this);
		}
	}

	public void addToInventory(Storable s) {
		if (inventory[s.getId()] == null) {
			inventory[s.getId()] = s;
			this.getCurrentTable().setFrozenItem(null);
		}
	}

	public void repairFlareGun() {
		 if (this.getCurrentTable().checkFlareGunPart() > 2)
			 System.out.println("GYŐZELEEEEEEEEEEEEM");
	}

	public void fallInHole() {
		work = 0;
	}
	
	
	/**
	 * Getter a name-hez.
	 * @return name 
	 */
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
		// ha thp egy ala csokken, a jateknak vege
		if (thp < 1)
			this.getCurrentTable().getIceField().endGame();
	}

	public int getWork() {
		return work;
	}

	public void setWork(int work) {
		this.work = work;
	}
	// @Override
	/*
	 * public void setCurrentTable(IceTable currenttable){
	 * //this.getCurrentTable().removePlayer(this); this.) = currenttable;
	 * //this.setCurrentTable(currenttable);
	 * currenttable.getPlayersOnTable().add(this); }
	 */

	public Storable[] getInventory() {
		return inventory;
	}

	public void setInventory(Storable[] inventory) {
		this.inventory = inventory;
	}

	public void removeFromInventory(int idx) {
		inventory[idx] = null;
	}

	public void attacked() {
		getCurrentTable().getIceField().endGame();
	}

	public abstract void writeOut();

}

package Modell;

import java.util.ArrayList;


	public abstract class Player extends Character implements java.io.Serializable {
	/** az inventory kezdo merete*/
	private static final int INVENTORY_STARTING_SIZE = 5;
	/** az player egyedi azonositoja*/
	public static int id = 0;
	/** a jatekos neve*/
	private String Name;
	/** a jatekos thp-ja*/
	private int thp;
	/** a jatekos thp-ja*/
	private int work;
	/** a jatekos inventoryja*/
	private Storable[] inventory;
	/**A player konstruktora inicalizalja a szukseges adattagokat*/
	public Player(String name, int thp, int work, IceTable currentTable) {
		super(currentTable);
		Name = name;
		this.thp = thp;
		this.work = work;
		this.inventory = new Storable[INVENTORY_STARTING_SIZE];
	}

	/**
	 * A jatekos move-ja
	 * @param it 
	 */
	public void move(IceTable it) 
	{
		if (this.getWork() < 1)
		{
			System.out.println("nincs eleg munkaja");
			return;
		}
		ArrayList<IceTable> neighbours = this.getCurrentTable().getNeighbours();
		for (IceTable iceTable : neighbours) 
		{
			if (it == iceTable && this.work > 0)
			{
				this.setWork(this.getWork()-1 );
				iceTable.playerVisit(this);
			}	
		}

	}
	/**
	    * A player hasznalja a megadott indexu itemet
	    * @param player_choice
	 */
	public void useItem(int player_choice,int idx)
	{
		if (this.getWork() < 1)
		{
			System.out.println("nincs eleg munkaja");
			return;
		}
		if (inventory[player_choice] != null)
		{
			inventory[player_choice].used(this,idx);
			this.setWork(this.getWork()-1 );
		}
	}
	/**
	 * A player kepessegenek elsutese.
	 * 
	 * @param t
	 */
	public abstract void useSkill(IceTable t);
	/**
	 * A player as
	 */
	public void dig() 
	{
		if (this.getWork() < 1)
		{
			System.out.println("nincs eleg munkaja");
			return;
		}
		this.setWork(this.getWork()-1 );
		if (inventory[3] != null) {
			inventory[3].used(this,0);
		} else {
			this.getCurrentTable().setSnowHeight(this.getCurrentTable().getSnowHeight() - 1);
			if(this.getCurrentTable().getSnowHeight()<=0)this.getCurrentTable().setSnowHeight(0);
		}
	}
	
	/**
	 * A befagyott targyfelvetele
	 */
	public void pickUp()
	{
		if(this.getCurrentTable().getSnowHeight() > 0 || this.getCurrentTable().getFrozenItem() == null )
			return;
		if(work>0) {
		this.getCurrentTable().getFrozenItem().pickedUpBy(this);
		work--;
		}
	}
	/**
	 * Adott targy hozzaadasa az inventoryhoz
	 * @param s 
	 */

	public void addToInventory(Storable s) {
			inventory[s.getId()] = s;
			this.getCurrentTable().setFrozenItem(null);
		
	}
	/**
	 * A flaregun osszeszerelese 
	 */
	public void repairFlareGun() {

		 if (this.getCurrentTable().checkFlareGunPart() > 2){
			 System.out.println("GyoZELEEEEEEEEEEEEM");
			 getCurrentTable().getIceField().win();
		 }
	}
	/**
	 * Ha valaki beleesik a lyukba annak a work-je 0
	 *  
	 */
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
	/**
	 * Setter a name-hez.
	 * 
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * Getter a thp-hez.
	 * @return thp 
	 */
	public int getThp() {
		return thp;
	}
	/**
	 * Setter a thp-hoz.
	 *  
	 */
	public void setThp(int thp) {
		this.thp = thp;
		// ha thp egy ala csokken, a jateknak vege
		if (thp < 1)
			this.getCurrentTable().getIceField().endGame();
	}
	/**
	 * Getter a work-hoz.
	 * @return work 
	 */
	public int getWork() {
		return work;
	}
	/**
	 * Setter a work-hoz.
	 * 
	 */
	public void setWork(int work) {
		/*if (work > 5)
			return;*/
		this.work = work;
	}

	/**
	 * Setter az inventoryhoz
	 * @return inventory 
	 */
	public Storable[] getInventory() {
		return inventory;
	}
	/**
	 * Setter az inventoryhoz
	 * @param inventory 
	 */
	public void setInventory(Storable[] inventory) {
		this.inventory = inventory;
	}
	/**
	 * Egy targy kivetele az inventorybol
	 * @param idx 
	 */  
	public void removeFromInventory(int idx) {
		inventory[idx] = null;
	}
	/**
	 * A jatekos-t tamadas erte. Ezzel veget ert a jatek.
	 */ 
	public void attacked() {
		getCurrentTable().getIceField().endGame();
	}
	/**
	 * Kiirja a player azonositojat.
	 */ 
	public abstract String writeOut();

}

package libilabor;

import java.util.ArrayList;

public abstract class IceTable 
{
	private int snowHeight;
	private int capacity;
	private IceField iceField;
	private ArrayList<Player> playersOnTable;
	private Igloo igloo;
	private Item frozenItem;
	private ArrayList<IceTable> neighbours;

	public IceTable(){
		
		playersOnTable = new ArrayList<Player>();
		neighbours = new ArrayList<IceTable>();
		
	}
	public void PlayerVisit(Player p) {
		
		this.playersOnTable.add(p);
		p.setCurrentTable(this);
	}
	
	public void BlizzardComing() {
		
		System.out.print("A kovetkezo korben hovihar fog tombolni"
				+ "a jegmezon. Mindenki keszüljön fel a katasztrofara!!");
	}
	
	public void CheckFlareGunPart() {}
	
	public void RemovePlayer(Player p) {
		
		playersOnTable.remove(this.playersOnTable.indexOf(p));
	}

	
	//Setters&Getters
	
	public IceField getIceField() {
		return iceField;
	}

	public void setIceField(IceField iceField) {
		this.iceField = iceField;
	}

	public int getSnowHeight() {
		return snowHeight;
	}

	public void setSnowHeight(int snowHeight) {
		this.snowHeight = snowHeight;
	}
	
	public int getCapacity(){
		return capacity;
	}
	
	public ArrayList<IceTable> getNeighbours() {
		
		return neighbours;
	}
	
	public Igloo getIgloo() {
		
		return this.igloo;
	}
	
	public void setIgloo(Igloo i) {
		
		this.igloo = i;
	}
	
	public Item getFrozenItem() {
		return frozenItem;
	}
	
	public ArrayList<Player> getPlayers() {
		return playersOnTable;
	}
	
	public void setFrozenItem(Item i) {
		this.frozenItem=i;
	}
}

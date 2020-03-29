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
		
		//TODO: random  itemezes
		playersOnTable = new ArrayList<Player>();
		neighbours = new ArrayList<IceTable>();
		
	}
	
	public int getSnowHeight() {
		return snowHeight;
	}
	public void setSnowHeight(int snowHeight) {
		this.snowHeight = snowHeight;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public IceField getIceField() {
		return iceField;
	}
	public void setIceField(IceField iceField) {
		this.iceField = iceField;
	}
	public ArrayList<Player> getPlayers() {
		return playersOnTable;
	}
	public void setPlayersOnTable(ArrayList<Player> playersOnTable) {
		this.playersOnTable = playersOnTable;
	}
	public Igloo getIgloo() {
		return igloo;
	}
	public void setIgloo(Igloo igloo) {
		this.igloo = igloo;
	}
	public Item getFrozenItem() {
		return frozenItem;
	}
	public void setFrozenItem(Item frozenItem) {
		this.frozenItem = frozenItem;
	}
	public ArrayList<IceTable> getNeighbours() {
		return neighbours;
	}
	public void setNeighbours(ArrayList<IceTable> neighbours) {
		this.neighbours = neighbours;
	}

	public void playerVisit(Player p) {
		
		this.playersOnTable.add(p);
		p.setCurrentTable(this);
	}
	
	public void blizzardComing() {
		
		System.out.print("A kovetkezo korben hovihar fog tombolni"
				+ "a jegmezon. Mindenki keszüljön fel a katasztrofara!!");
	}
	
	
	public int checkFlareGunPart() {
		
		int parts = 0; 
		
		for(Player p: this.playersOnTable) {
			
			if(p.getInventory()[1] != null) {				
				parts++;
			}
		}
		
		return parts;
	}
	
	public void removePlayer(Player p) {
		
		playersOnTable.remove(this.playersOnTable.indexOf(p));
	}


}
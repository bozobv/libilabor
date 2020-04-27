package libilabor;

import java.util.ArrayList;


public abstract class IceTable 
{
	
	private int snowHeight;
	private int capacity;
	private IceField iceField;
	private ArrayList<Player> playersOnTable;
	private ArrayList<PolarBear> animalsOnTable;
	private Construction construction;
	private Item frozenItem = null;
	private ArrayList<IceTable> neighbours;
	
	public IceTable(){
		
		animalsOnTable = new ArrayList<PolarBear>();
		playersOnTable = new ArrayList<Player>();
		neighbours = new ArrayList<IceTable>();
		
	}
	public ArrayList<Player> getPlayersOnTable() {
		return playersOnTable;
	}

	public void setPlayersOnTable(ArrayList<Player> playersOnTable) {
		this.playersOnTable = playersOnTable;
	}

	public ArrayList<PolarBear> getAnimalsOnTable() {
		return animalsOnTable;
	}

	public void setAnimalsOnTable(ArrayList<PolarBear> animalsOnTable) {
		this.animalsOnTable = animalsOnTable;
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
	public Construction getConstruction() {
		return construction;
	}
	public void setConstruction(Construction construction) {
		this.construction = construction;
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
		p.setTable(this);
	}
	

	public Item getItem(){
		return frozenItem;
	}
	
	public void setItem(Item it){
		frozenItem = it;
	}

	public void blizzardComing() 
	{
		if (playersOnTable != null && getConstruction() == null)
		{
			for (int i = 0; i < playersOnTable.size(); i++)
			{
				int newThp = (playersOnTable.get(i)).getThp() - 1;
				(playersOnTable.get(i)).setThp(newThp);
			}
		}
		
	
	}
	
	
	public int checkFlareGunPart() {
		
		int parts = 0; 
		
		for(Character p: this.playersOnTable) {
			
			if(((Player) p).getInventory()[1] != null) {				
				parts++;
			}
		}
		
		return parts;
	}
	
	public void removePlayer(Player character) {
		
		playersOnTable.remove(this.playersOnTable.indexOf(character));
	}
	public void removeAnimal(PolarBear character) {
		
		animalsOnTable.remove(this.animalsOnTable.indexOf(character));
	}
	
	public void writeOut() {}
	
}

package libilabor;

import java.util.ArrayList;


public abstract class IceTable 
{
	
	private int snowHeight;
	private int capacity;
	private IceField iceField;
	private ArrayList<Character> charactersOnTable;
	private Igloo igloo;
	private Item frozenItem = null;
	private ArrayList<IceTable> neighbours;
	
	public IceTable(){
		
		charactersOnTable = new ArrayList<Character>();
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
	public ArrayList<Character> getCharactersOnTable() {
		return charactersOnTable;
	}
	public void setPlayersOnTable(ArrayList<Character> charactersOnTable) {
		this.charactersOnTable = charactersOnTable;
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
		
		this.charactersOnTable.add(p);
		p.setCurrentTable(this);
	}
	

	public Item getItem(){
		return frozenItem;
	}
	
	public void setItem(Item it){
		frozenItem = it;
	}

	public void blizzardComing() 
	{
		if (charactersOnTable != null && getIgloo() == null)
		{
			for (int i = 0; i < charactersOnTable.size(); i++)
			{
				int newThp = ((Player) charactersOnTable.get(i)).getThp() - 1;
				((Player) charactersOnTable.get(i)).setThp(newThp);
			}
		}
		
	
	}
	
	
	public int checkFlareGunPart() {
		
		int parts = 0; 
		
		for(Character p: this.charactersOnTable) {
			
			if(((Player) p).getInventory()[1] != null) {				
				parts++;
			}
		}
		
		return parts;
	}
	
	public void removeCharacter(Character character) {
		
		charactersOnTable.remove(this.charactersOnTable.indexOf(character));
	}


}

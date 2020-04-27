package libilabor;

public class Hole extends IceTable 
{	
	public Hole() {
		super();
		this.setCapacity(0);
		
	}
	public void playerVisit(Player p) {
		
		this.getCharactersOnTable().add(p);
		if(p.getInventory()[2] != null) return;
		p.fallInHole();
		this.getIceField().setPlayerInWater(true);
		
	}
	public void removePlayer(Player p) {
		
		this.getCharactersOnTable().remove(this.getCharactersOnTable().indexOf(p));
		this.getIceField().setPlayerInWater(false);
		
	}
	
	
	
	public Item getFrozenItem(){
		//System.out.println("ez egy luk, nincs benne semmi");
		//az icefield konstruktora ne tegyen ide item-et
		return null;
	}
	
	public void setFrozenItem(Item it){
		//System.out.println("ez egy luk, ne rakj bele semmit");
	}
	
	public int getCapacity() {
		return 0;
	}
	
	public void writeOut() 
	{
		System.out.print("H(" + this.getCapacity() + "," + this.getSnowHeight());
		System.out.print("null,");
		if(this.getConstruction() == null)
			System.out.print("null");
		else
			this.getConstruction().writeOut();
		System.out.print(",");
		if(this.getCharactersOnTable() == null)
			System.out.print("null");
		else
			for(int i = 0; i < this.getCharactersOnTable().size(); i++)
			{
				this.getCharactersOnTable().get(i).writeOut();
				System.out.print(",");
			}
		System.out.print(")");		
	}


}

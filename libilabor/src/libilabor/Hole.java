package libilabor;

public class Hole extends IceTable 
{
	public Hole() {
		super();
		
	}
	public void playerVisit(Player p) {
		
		this.getPlayers().add(p);
		this.getIceField().setPlayerInWater(true);
		
	}
	public void removePlayer(Player p) {
		
		this.getPlayers().remove(this.getPlayers().indexOf(p));
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
}

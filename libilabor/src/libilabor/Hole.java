package libilabor;

public class Hole extends IceTable 
{
	public Hole() {
		super();
		
	}
	public void playerVisit(Player p) {
		
		this.getPlayers().add(p);
		this.getIceField().SetPlayerInWater(true);
		
	}
	public void removePlayer(Player p) {
		
		this.getPlayers().remove(this.getPlayers().indexOf(p));
		this.getIceField().SetPlayerInWater(false);
		
	}
	
	
	public Item getItem(){
		System.out.println("ez egy luk, nincs benne semmi");
		//az icefield konstruktora ne tegyen ide item-et
		Whiskey w = null;;
		return w;
	}
	
	public void setItem(Item it){
		System.out.println("ez egy luk, ne rakj bele semmit");
	}
}

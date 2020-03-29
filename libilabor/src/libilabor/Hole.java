package libilabor;

public class Hole extends IceTable 
{
	public Hole() {
		super();
		
	}
	public void PlayerVisit(Player p) {
		
		this.getPlayersOnTable().add(p);
		this.getIceField().SetPlayerInWater(true);
		
	}
	public void RemovePlayer(Player p) {
		
		this.getPlayersOnTable().remove(this.getPlayersOnTable().indexOf(p));
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

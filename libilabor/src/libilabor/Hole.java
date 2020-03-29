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
}

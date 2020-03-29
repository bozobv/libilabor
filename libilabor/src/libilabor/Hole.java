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
}

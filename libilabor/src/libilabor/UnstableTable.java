package libilabor;


import java.util.*;
public class UnstableTable extends IceTable 
{
	
	public UnstableTable() {
		super();
		Random rand = new Random();
		int c = rand.nextInt();
		this.setCapacity(c);
		
	}
	void Flip() {
		
		for(Player p: this.getPlayersOnTable()) {
			p.setThp(0);
		}
		this.getIceField().EndGame();
	}
	public void PlayerVisit(Player p) {
		
		this.getPlayersOnTable().add(p);
		
		if(this.getPlayersOnTable().size() > this.getCapacity()) {
			
			this.Flip();
		}
	}
	
}

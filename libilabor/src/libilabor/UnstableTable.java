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
		
		for(Player p: this.getPlayers()) {
			p.setThp(0);
		}
		this.getIceField().EndGame();
	}
	public void PlayerVisit(Player p) {
		
		this.getPlayers().add(p);
		
		if(this.getPlayers().size() > this.getCapacity()) {
			
			this.Flip();
		}
	}
	
}

package libilabor;


import java.util.*;
public class UnstableTable extends IceTable 
{
	
	public UnstableTable(int cap) {
		Random rand = new Random();
		int c = rand.nextInt(cap);
		this.setCapacity(c);

	}
	void flip() {

		for(Player p: this.getPlayers()) {
			p.setThp(0);
		}
		this.getIceField().EndGame();
	}
	public void playerVisit(Player p) {
		
		this.getPlayers().add(p);
		
		if(this.getPlayers().size() > this.getCapacity()) {
			
			this.flip();
		}
	}
	
}

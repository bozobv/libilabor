package libilabor;


import java.util.*;
public class UnstableTable extends IceTable 
{
	
	public UnstableTable(int cap) {
		super();
		Random rand = new Random();
		int c = rand.nextInt(cap) + 1; //+1, hogy ne legyen nulla
		this.setCapacity(c);
	}
	void flip() {

		for(Player p: this.getPlayers()) {
			p.setThp(0);
		}
	}
	public void playerVisit(Player p) {
		
		this.getPlayers().add(p);
		
		if(this.getPlayers().size() > this.getCapacity())
			this.flip();
	}
	
}

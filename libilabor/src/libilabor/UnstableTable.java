package libilabor;


import java.util.*;
public class UnstableTable extends IceTable 
{
	
	public UnstableTable(int cap) 
	{
		super();
		Random rand = new Random();
		int c = rand.nextInt(cap) + 1; //+1, hogy ne legyen nulla
		this.setCapacity(c);
	}
	void flip() {

		for(Character p: this.getCharactersOnTable()) {
			((Player)p).setThp(0);
		}
	}
	public void playerVisit(Player p) {
		
		this.getCharactersOnTable().add(p);
		
		if(this.getCharactersOnTable().size() > this.getCapacity())
			this.flip();
	}
	
}

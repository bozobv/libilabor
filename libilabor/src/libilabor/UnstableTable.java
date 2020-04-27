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
	
	public void writeOut() 
	{
		System.out.print("UT(" + this.getCapacity() + "," + this.getSnowHeight());
		if(this.getFrozenItem() == null)
			System.out.print("null");
		else
			this.getFrozenItem().writeOut();
		System.out.print(",");
		if(this.getConstruction() == null)
			System.out.print("null");
		else
			this.getConstruction().writeOut();
		System.out.print(",");
		if(this.getCharactersOnTable() == null)
			System.out.print("null");
		else
			for(int i = 0; i < this.getCharactersOnTable().size(); i++)
			{
				this.getCharactersOnTable().get(i).writeOut();
				System.out.print(",");
			}
		System.out.print(")");		
	}

}
